package com.sh.jhipster.gw.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Comments.
 */

//@Document(collection = "comments")
@Embeddable
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field("number")
    private Long number;


    @Field("status")
    private Integer status;

    @Field("createdate")
    private LocalDate createdate;

    @NotNull
    @Field("commenttext")
    private String commenttext;

    @Field("authorid")
    private Integer authorid;

    @NotNull
    @Field("title")
    private String title;

    @NotNull
    @Field("lastchange")
    private LocalDate lastchange;

    private String slug;


    @Field("type")
    private Integer type;

    public Long getNumber() {
        return number;
    }

    public Comments() {
    }

    public Comments(Integer status, String commenttext, Integer authorid, String title, Integer type) {
        this.status = status;
        this.commenttext = commenttext;
        this.authorid = authorid;
        this.title = title;
        this.type = type;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public Comments status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDate getCreatedate() {
        return createdate;
    }

    public Comments createdate(LocalDate createdate) {
        this.createdate = createdate;
        return this;
    }

    public void setCreatedate(LocalDate createdate) {
        this.createdate = createdate;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public Comments commenttext(String commenttext) {
        this.commenttext = commenttext;
        return this;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public Comments authorid(Integer authorid) {
        this.authorid = authorid;
        return this;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getTitle() {
        return title;
    }

    public Comments title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getLastchange() {
        return lastchange;
    }

    public Comments lastchange(LocalDate lastchange) {
        this.lastchange = lastchange;
        return this;
    }

    public void setLastchange(LocalDate lastchange) {
        this.lastchange = lastchange;
    }

    public Integer getType() {
        return type;
    }

    public Comments type(Integer type) {
        this.type = type;
        return this;
    }


    @Override
    public String toString() {
        return "Comments{" +
            " number='" + number + "'" +
            ", status='" + status + "'" +
            ", createdate='" + createdate + "'" +
            ", commenttext='" + commenttext + "'" +
            ", authorid='" + authorid + "'" +
            ", title='" + title + "'" +
            ", lastchange='" + lastchange + "'" +
            ", type='" + type + "'" +
            '}';
    }
}
