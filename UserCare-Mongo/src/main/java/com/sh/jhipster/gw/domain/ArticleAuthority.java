package com.sh.jhipster.gw.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;

@Embeddable
public  class ArticleAuthority{
    @Field("userid")
    private Integer userid;

    @Field("updateduserid")
    private Integer updateduserid;

    @Field("assigneduserid")
    private Integer assigneduserid;

    @Field("deleted")
    private Boolean deleted;

    @Field("disabled")
    private Boolean disabled;

    @Field("answercommentid")
    private Integer answercommentid;

    @Field("needreview")
    private Boolean needreview;

    @Field("logicalgroup")
    private Integer logicalgroup;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUpdateduserid() {
        return updateduserid;
    }

    public void setUpdateduserid(Integer updateduserid) {
        this.updateduserid = updateduserid;
    }

    public Integer getAssigneduserid() {
        return assigneduserid;
    }

    public void setAssigneduserid(Integer assigneduserid) {
        this.assigneduserid = assigneduserid;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getAnswercommentid() {
        return answercommentid;
    }

    public void setAnswercommentid(Integer answercommentid) {
        this.answercommentid = answercommentid;
    }

    public Boolean getNeedreview() {
        return needreview;
    }

    public void setNeedreview(Boolean needreview) {
        this.needreview = needreview;
    }

    public Integer getLogicalgroup() {
        return logicalgroup;
    }

    public void setLogicalgroup(Integer logicalgroup) {
        this.logicalgroup = logicalgroup;
    }
}
