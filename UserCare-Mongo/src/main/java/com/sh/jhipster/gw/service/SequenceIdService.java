package com.sh.jhipster.gw.service;

import com.sh.jhipster.gw.domain.SequenceId;

/**
 * Created by Faiziev Shuhrat on 11/24/16.
 */
public interface SequenceIdService {

    /**
     * Save a SequenceId.
     *
     * @param sequenceId sequence
     * @return the persisted entity
     */
    SequenceId save(SequenceId sequenceId);

    /**
     * Increase sequence id and return result.
     *
     * @param  projid Project id
     * @param key sequence key
     * @return the Increased value
     */
    long getIncreasedSequenceId(Integer projid , String key);
}
