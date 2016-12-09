package com.sh.jhipster.gw.service;

import com.sh.jhipster.gw.domain.Article;

import java.math.BigInteger;
import java.util.List;

/**
 * Service Interface for managing Article.
 */
public interface ArticleService {

    String COMMENTS_KEY="ratings.comments";

    /**
     * Save a article.
     *
     * @param article the entity to save
     * @return the persisted entity
     */
    Article save(Article article);



    /**
     *  Get all the articles.
     *
     *  @return the list of entities
     */
    List<Article> findAll(Integer projid);

    /**
     *  Get the "number" article.
     *
     *  @param number the id of the entity
     *  @return the entity
     */
    Article findOne(Integer projid,  Long number);

    /**
     *  Delete the "id" article.
     *
     *  @param number the id of the entity
     */
    void delete(String id );

    boolean incrementStatistic(Integer projid, Long number, String incrementKey,  int value);
}
