package com.sh.jhipster.gw.service.impl;

import com.sh.jhipster.gw.domain.SequenceId;
import com.sh.jhipster.gw.service.ArticleService;
import com.sh.jhipster.gw.domain.Article;
import com.sh.jhipster.gw.repository.ArticleRepository;
import com.sh.jhipster.gw.service.SequenceIdService;
import javassist.NotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigInteger;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Service Implementation for managing Article.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    private final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Inject
    private ArticleRepository articleRepository;

    @Inject
    SequenceIdService sequenceIdService;

    @Inject
    MongoTemplate mongoTemplate;

    /**
     * Save a article.
     *
     * @param article the entity to save
     * @return the persisted entity
     */
    public Article save(Article article) {
        log.debug("Request to save Article : {}", article);

        if (article.getNumber()== null || article.getNumber()==0){
            article.setNumber( sequenceIdService.getIncreasedSequenceId( article.getProjid(), SequenceId.ARTICLEKEY) );
        }
        Article result = articleRepository.save(article);
        return result;
    }

    /**
     *  Get all the articles.
     *
     *  @return the list of entities
     */
    public List<Article> findAll(Integer projid) {
        log.debug("Request to get all project's Articles");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("projid" ,exact());
        List<Article> result = articleRepository.findAll(Example.of(new Article(projid), matcher) );
        return result;
    }

    /**
     *  Get one article by id.
     *
     *  @param projid the id of the Project
     *  @param number article id number
     *  @return the entity
     */
    public Article findOne(Integer projid, Long number) {
        log.debug("Request to get Article : {}", number);
        Article result =  mongoTemplate.findOne(query(where("projid").is(projid).and("number").is(number) ), Article.class );
        return result;
    }

    /**
     *  Delete the  article by id.
     *
     *  @param projid the id of the Project
     *  @param number article id number
     */
    public void delete(String id ) {
        log.debug("Request to delete Article : {}", id);
        articleRepository.delete(id);
    }


    /**
     *  Get one article by id.
     *
     *  @param projid the id of the Project
     *  @param number article id number
     *  @return the entity
     */
    public boolean incrementStatistic(Integer projid, Long number, String incrementKey,  int value) {
        log.debug("Increment Statistic of  Article : {}", number);
        final Update update = new Update().inc(incrementKey, value);
        return  mongoTemplate.updateFirst(getQueryArticle(projid, number), update , Article.class ).getN()>0 ;

    }

    private Query getQueryArticle(int projid, long  articid){
        Query query= new Query(new Criteria().andOperator(
            Criteria.where("projid").is(projid)));
        query.addCriteria(Criteria.where("articid").is(articid) );
//        if (bucketid != null) query.addCriteria(Criteria.where("bucketid").is(bucketid) );
//        if (number!= null)  query.addCriteria(Criteria.where("commentsList").elemMatch(Criteria.where("number").is(number)));

        return query;
    }


}
