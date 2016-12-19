package com.sh.jhipster.gw.service.impl;

import com.sh.jhipster.gw.domain.util.MangoDBParams;
import com.sh.jhipster.gw.service.CommentBucketsService;
import com.sh.jhipster.gw.domain.CommentBuckets;
import com.sh.jhipster.gw.repository.CommentBucketsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Service Implementation for managing CommentBuckets.
 */
@Service
public class CommentBucketsServiceImpl implements CommentBucketsService{

    private final Logger log = LoggerFactory.getLogger(CommentBucketsServiceImpl.class);

    @Inject
    private CommentBucketsRepository commentBucketsRepository;


    @Inject
    MongoTemplate mongoTemplate;

    /**
     * Save a commentBuckets.
     *
     * @param commentBuckets the entity to save
     * @return the persisted entity
     */
    public CommentBuckets save(CommentBuckets commentBuckets) {
        log.debug("Request to save CommentBuckets : {}", commentBuckets);
        commentBuckets.setCount(commentBuckets.getCommentsList().size());

        if (commentBuckets.getId()== null) {
            commentBuckets.setBucketid(this.count(commentBuckets.getProjid(),  commentBuckets.getArticid() ).intValue() );
        }

        CommentBuckets result = commentBucketsRepository.save(commentBuckets);
        return result;
    }

    /**
     *  Get all the commentBuckets.
     *
     *  @return the list of entities
     */
    public List<CommentBuckets> findAll(Integer projid ) {
        log.debug("Request to get all CommentBuckets");
        List<CommentBuckets> result = commentBucketsRepository.findByProjid(projid);

        return result;
    }

    /**
     *  Get all the commentBuckets.
     *
     *  @return the list of entities
     */
    public List<CommentBuckets> findAll(int projid, long articid ) {
        log.debug("Request to get all CommentBuckets");
        List<CommentBuckets> result = commentBucketsRepository.findByProjidAndArticid(projid, articid);

        return result;
    }

    /**
     *  Get one commentBuckets by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public CommentBuckets findOne(String id) {
        log.debug("Request to get CommentBuckets : {}", id);
        CommentBuckets commentBuckets = commentBucketsRepository.findOne(id);
        return commentBuckets;
    }

    /**
     *  Delete the  commentBuckets by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete CommentBuckets : {}", id);
        commentBucketsRepository.delete(id);
    }

    /**
     *  return count  of the  commentBuckets by projid and articid.
     *
     *  @param projid the id of the project
     *  @param articid the id of article
     *
     *  @return count
     */
    public Long count(Integer projid, Long articid ){
        Long result=mongoTemplate.count(query(where("projid").is(projid).and("articid").is(articid) ), CommentBuckets.class );
        return result;
    }

    public  CommentBuckets findLast(int projid, long articid ){
        CommentBuckets result=mongoTemplate.findOne(query(where("projid").is(projid).and("articid").is(articid).and("count").lt(MangoDBParams.COMMENTSBUCKETMAXELEMENT )   ), CommentBuckets.class );
        return result;
    }



}
