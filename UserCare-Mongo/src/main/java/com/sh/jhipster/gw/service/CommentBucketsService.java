package com.sh.jhipster.gw.service;

import com.sh.jhipster.gw.domain.CommentBuckets;
import com.sh.jhipster.gw.domain.Comments;

import java.util.List;

/**
 * Service Interface for managing CommentBuckets.
 */
public interface CommentBucketsService {

    /**
     * Save a commentBuckets.
     *
     * @param commentBuckets the entity to save
     * @return the persisted entity
     */
    CommentBuckets save(CommentBuckets commentBuckets);

    /**
     *  Get all the commentBuckets.
     *
     *  @return the list of entities
     */
    List<CommentBuckets> findAll(Integer projid);

    /**
     *  Get all the commentBuckets.
     *
     *  @return the list of entities
     */
    List<CommentBuckets> findAll(int projid, long forumid );

    /**
     *  Get the "id" commentBuckets.
     *
     *  @param projid the id of the Project
     *  @return the entity
     */
    CommentBuckets findLast(int projid, long articid );

    /**
     *  Delete the "id" commentBuckets.
     *
     *  @param id the id of the entity
     */
    void delete(String id);


    Long count(Integer projid, Long articid );


}
