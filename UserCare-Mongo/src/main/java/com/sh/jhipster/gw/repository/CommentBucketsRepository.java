package com.sh.jhipster.gw.repository;

import com.sh.jhipster.gw.domain.CommentBuckets;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Spring Data MongoDB repository for the CommentBuckets entity.
 */
@SuppressWarnings("unused")
public interface CommentBucketsRepository extends MongoRepository<CommentBuckets,String> {

    List<CommentBuckets> findByProjid(int projid);

    List<CommentBuckets> findByProjidAndArticid(int projid, Long articid);
}
