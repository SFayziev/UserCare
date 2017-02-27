package com.sh.jhipster.gw.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import com.sh.jhipster.gw.domain.Article;
import com.sh.jhipster.gw.domain.CommentBuckets;
import com.sh.jhipster.gw.domain.SequenceId;
import com.sh.jhipster.gw.repository.CommentBucketsRepository;
import com.sh.jhipster.gw.service.ArticleService;
import com.sh.jhipster.gw.service.CommentBucketsService;
import com.sh.jhipster.gw.service.CommentsService;
import com.sh.jhipster.gw.domain.Comments;
import com.sh.jhipster.gw.repository.CommentsRepository;
import com.sh.jhipster.gw.service.SequenceIdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Service Implementation for managing Comments.
 */
@Service
public class CommentsServiceImpl implements CommentsService{

    private final Logger log = LoggerFactory.getLogger(CommentsServiceImpl.class);

    @Inject
    private CommentsRepository commentsRepository;

    @Inject
    ArticleService articleService;

    @Inject
    CommentBucketsService commentBucketsService;


    @Inject
    SequenceIdService sequenceIdService;

    @Inject
    MongoTemplate mongoTemplate;


    /**
     *  Save a comments.
     *
     * @param comments the entity to save
     * @return the persisted entity
     */
    @Transactional
    public Comments save(int  projid , long articid,  Comments comments) {
        log.debug(" ------ Request to save Comments : {}  ------ ", comments);
        Boolean isnew=false;
        Article article = articleService.findOne(projid, articid );
        if (article != null){
            if (comments.getNumber() == null || comments.getNumber()==0) isnew=true;
            CommentBuckets commentBuckets= commentBucketsService.findLast(projid, articid );
            if (commentBuckets == null ) {
                commentBuckets= new CommentBuckets(projid, articid);
                commentBucketsService.save(commentBuckets);
            }
            if (isnew) {
                comments.setNumber(sequenceIdService.getIncreasedSequenceId(projid, SequenceId.COMMENTKEY ));
                addComment(projid, articid, commentBuckets.getBucketid(),comments);
                articleService.incrementStatistic(projid, articid, ArticleService.COMMENTS_KEY, 1 );
            }
            else {
                updateComment(projid, articid, comments);
            }

            return comments;
        }
        log.error("Article with id : {} not found " , articid );
        return null;
    }

    /**
     *  Get all the comments.
     *
     *  @return the list of entities
     */
    public List<Comments> findAll(int  projid , long articid, Pageable pageable) {
        log.debug("Request to get all Comments");
        final List<Comments> result = commentsRepository.findAll();
        return result;
    }

    /**
     *  Get one comments by id.
     *
     *  @param number the Commetid of the entity
     *  @return the entity
     */
    public Comments findOne(int  projid , long articid, long  number) {
        log.debug("Request to get Comments : {}", number);
        CommentBuckets commentBuckets = getComment(projid, articid, number );
        return commentBuckets.getCommentsList().size()>0? commentBuckets.getCommentsList().get(0) : null;
    }

    /**
     *  Delete the  comments by id.
     *
     *  @param number the id of the entity
     */
    public int delete(int  projid , long articid, long  number) {
        log.debug("Request to delete Comments : {}", number);
        final Query query= getQueryComment(projid, articid, null, number);
        final Update increaseCommentBucket= new Update().inc("count", -1);

        WriteResult writeResult = mongoTemplate.updateFirst(query, increaseCommentBucket, CommentBuckets.class);
//        TODO : rise exception if writeResult.getN() eq 0

        final Update update = new Update().pull("commentsList", new BasicDBObject("number", number));
        WriteResult result= mongoTemplate .updateFirst(query, update, CommentBuckets.class );
        if (result.getN()>0){

            articleService.incrementStatistic(projid, articid, ArticleService.COMMENTS_KEY, -1 );
            final Update decreaseCommentBucket= new Update().inc("count", -1);
            mongoTemplate.updateFirst(query, decreaseCommentBucket, CommentBuckets.class);
        }

        return result.getN();
    }

    private int updateComment(final int projid,final long  articid, final Comments comments){
        Query query=getQueryComment(projid, articid, null, comments.getNumber());
        final Update update = new Update().set("commentsList.$", comments);
        return mongoTemplate.updateFirst(query, update, CommentBuckets.class ).getN() ;
    }

    private int  addComment(final int projid, final long  articid, final Integer bucketid, final Comments comments){
        Query query=getQueryComment(projid, articid , bucketid,  null);
        final Update update = new Update().addToSet("commentsList", comments);
        WriteResult result = mongoTemplate.updateFirst(query, update, CommentBuckets.class );
            if (result.getN()>0) {
                final Update increaseCommentBucket= new Update().inc("count", 1);
                mongoTemplate.updateFirst(query, increaseCommentBucket, CommentBuckets.class);
            }
        return result.getN();
    }

    private Query getQueryComment(final  int projid, final  long  articid, final  Integer bucketid, final  Long number){
        final  Query query= new Query();
        query.addCriteria(Criteria.where("projid").is(projid) );
        query.addCriteria(Criteria.where("articid").is(articid) );
        if (bucketid != null) query.addCriteria(Criteria.where("bucketid").is(bucketid) );
        if (number != null)  query.addCriteria(Criteria.where("commentsList").elemMatch(Criteria.where("number").is(number)));
        return query;
    }

    private CommentBuckets getComment(int projid, long  articid, long number){
        final  Query query=getQueryComment(projid, articid, null, number);
                query.fields().include("commentsList.$" );
        return  mongoTemplate.findOne(query,  CommentBuckets.class );
    }
}
