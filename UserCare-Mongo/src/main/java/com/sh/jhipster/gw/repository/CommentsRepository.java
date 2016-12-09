package com.sh.jhipster.gw.repository;

import com.sh.jhipster.gw.domain.Comments;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Comments entity.
 */
@SuppressWarnings("unused")
public interface CommentsRepository extends MongoRepository<Comments,String> {

}
