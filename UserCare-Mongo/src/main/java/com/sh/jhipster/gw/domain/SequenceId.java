package com.sh.jhipster.gw.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Faiziev Shuhrat on 11/24/16.
 */
@Document(collection = "sequenceId")
public class SequenceId implements Serializable {

    public static String COMMENTKEY="commetid";
    public static String ARTICLEKEY="articleid";

    private String id;
    private Integer projid;
    private String key;
    private Long seq;

    public SequenceId() {
    }

    public SequenceId(Integer projid, String key) {
        this.projid = projid;
        this.key = key;
    }

    public SequenceId(Integer projid, String key, long seq) {
        this.projid = projid;
        this.key = key;
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProjid() {
        return projid;
    }

    public void setProjid(Integer projid) {
        this.projid = projid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "SequenceId{" +
            "id='" + id + '\'' +
            ", projid=" + projid +
            ", key='" + key + '\'' +
            ", seq=" + seq +
            '}';
    }
}
