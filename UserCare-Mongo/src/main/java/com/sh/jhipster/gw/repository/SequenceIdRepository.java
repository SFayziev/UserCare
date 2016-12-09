package com.sh.jhipster.gw.repository;

/**
 * Created by Faiziev Shuhrat on 11/24/16.
 */

import com.sh.jhipster.gw.domain.SequenceId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Spring Data MongoDB repository for the SequenceId entity.
 */
@SuppressWarnings("unused")
public interface SequenceIdRepository extends MongoRepository<SequenceId,String> {
    @Query("{ 'projid' : ?0 , 'key' : ?0}")
    SequenceId findOneByProjidAndKey(Integer projid, String key);
}
