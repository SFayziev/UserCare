package com.sh.jhipster.gw.service.impl;

import com.sh.jhipster.gw.domain.SequenceId;
import com.sh.jhipster.gw.repository.SequenceIdRepository;
import com.sh.jhipster.gw.service.SequenceIdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

/**
 * Created by Faiziev Shuhrat on 11/24/16.
 */

@Service
public class SequenceIdServiceImpl implements SequenceIdService {

    private final Logger log = LoggerFactory.getLogger(SequenceIdServiceImpl.class);

    @Inject
    private SequenceIdRepository sequenceIdRepository;

    /**
     * Save a SequenceId.
     *
     * @param sequenceId sequence
     * @return the persisted entity
     */
    @Override
    public SequenceId save(SequenceId sequenceId) {
        SequenceId sequenceId1= sequenceIdRepository.save(sequenceId);
        return sequenceId1;
    }

    /**
     * Increase sequence id and return result.
     *
     * @param projid Project id
     * @param key    sequence key
     * @return increased result
     */
    @Override
    public long getIncreasedSequenceId(Integer projid, String key) {
        log.debug("Request to increase sequence id for project : {}  key : {}", projid, key);
//        ExampleMatcher matcher = ExampleMatcher.matching()
//            .withMatcher("projid", exact())
//            .withMatcher("key", exact().ignoreCase());
        Example<SequenceId> example = Example.of(new SequenceId(projid, key));
        SequenceId sequenceId = sequenceIdRepository.findOne( example);
        if (sequenceId == null) {
            sequenceId = new SequenceId(projid, key,0);
        }
        sequenceId.setSeq(sequenceId.getSeq()+1);
        this.save(sequenceId);
        return sequenceId.getSeq();
    }
}
