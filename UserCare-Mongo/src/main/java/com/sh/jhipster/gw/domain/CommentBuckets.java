package com.sh.jhipster.gw.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.ElementCollection;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A CommentBuckets.
 */

@Document(collection = "commentbuckets")
public class CommentBuckets implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    private String id;

    @NotNull
    @Field("articid")
    private Long articid;

    @NotNull
    @Field("projid")
    private Integer projid;


    @NotNull
    @Field("bucketid")
    private Integer bucketid=0;

    @NotNull
    @Field("count")
    private Integer count=0;

    @ElementCollection
    List<Comments> commentsList= new ArrayList<>();

    public CommentBuckets(int  projid,  long articid,   List<Comments> commentsList) {
        this.articid = articid;
        this.projid = projid;
        this.commentsList = commentsList;
        this.count = commentsList.size();
    }

    public CommentBuckets(int  projid, long articid) {
        this.articid = articid;
        this.projid = projid;

    }

    public CommentBuckets(int projid , long articid, Comments comment) {
        this.articid = articid;
        this.projid = projid;
        this.commentsList = new ArrayList<>();
        this.commentsList.add(comment);

        this.count = 1;
    }

    public CommentBuckets() {
    }

    public Long getArticid() {
        return articid;
    }

    public void setArticid(Long articid) {
        this.articid = articid;
    }

    public Integer getProjid() {
        return projid;
    }

    public void setProjid(Integer projid) {
        this.projid = projid;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBucketid() {
        return bucketid;
    }

    public CommentBuckets bucketid(Integer bucketid) {
        this.bucketid = bucketid;
        return this;
    }

    public void setBucketid(Integer bucketid) {
        this.bucketid = bucketid;
    }

    public Integer getCount() {
        return count;
    }

    public CommentBuckets count(Integer count) {
        this.count = count;
        return this;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommentBuckets commentBuckets = (CommentBuckets) o;
        if(commentBuckets.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, commentBuckets.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CommentBuckets{" +
            "id=" + id +
            ", bucketid='" + bucketid + "'" +
            ", count='" + count + "'" +
            '}';
    }
}
