package com.sh.jhipster.gw.service;

import com.sh.jhipster.gw.domain.Comments;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service Interface for managing Comments.
 */
public interface CommentsService {

    /**
     * Save a comments.
     *
     * @param comments the entity to save
     * @return the persisted entity
     */
    Comments save(int  projid , Long articid,  Comments comments);

    /**
     *  Get all the comments.
     *
     *  @return the list of entities
     */
    List<Comments> findAll(int  projid , Long articid, Pageable pageable);

    /**
     *  Get the "id" comments.
     *
     *  @param number the id of the entity
     *  @return the entity
     */
    Comments findOne(int  projid , long articid, long  number);

    /**
     *  Delete the "id" comments.
     *
     *  @param number the id of the entity
     */
    int delete(int  projid , long articid, long  number);
}
