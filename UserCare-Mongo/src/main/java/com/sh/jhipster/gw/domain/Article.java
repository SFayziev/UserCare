package com.sh.jhipster.gw.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Article.
 */

//@Document(collection = "article")
@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private Long number;

    @NotNull
    @Field("projid")
    private Integer projid;

    @NotNull
    @Field("forumid")
    private Integer forumid;

    @NotNull
    @Field("catid")
    private Integer catid;

    @NotNull
    @Field("title")
    private String title;


    @NotNull
    @Field("text")
    private String text;

    @NotNull
    @Field("status")
    private Integer status;

    @NotNull
    @Field("type")
    private Integer type;

    @NotNull
    @Field("createdate")
    private LocalDate createdate;

    @Field("lastchange")
    private LocalDate lastchange;

    @ElementCollection
    private ArticleRating ratings= new ArticleRating();

    @ElementCollection
    private ArticleAuthority authority = new ArticleAuthority();

    public ArticleAuthority getAuthority() {
        return authority;
    }

    public void setAuthority(ArticleAuthority authority) {
        this.authority = authority;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }



    public ArticleRating getRatings() {

        return ratings== null? new ArticleRating(): ratings;
    }

    public void setRatings(ArticleRating ratings) {
        this.ratings = ratings;
    }



    public Article(Integer projid, Long number ) {
        this.number = number;
        this.projid = projid;
    }

    public Article(Integer projid) {
        this.projid = projid;
    }

    public Article() {
    }

    public Article(Integer projid, Integer forumid, Integer catid, String title, String text) {
        this.projid = projid;
        this.forumid = forumid;
        this.catid = catid;
        this.title = title;
        this.text = text;
        this.status=0;
        this.createdate=LocalDate.now();
        this.lastchange=LocalDate.now();
        this.type=0;
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

    public Article projid(Integer projid) {
        this.projid = projid;
        return this;
    }

    public void setProjid(Integer projid) {
        this.projid = projid;
    }

    public String getText() {
        return text;
    }

    public Article text(String text) {
        this.text = text;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }

    public Article status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public Article type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDate getCreatedate() {
        return createdate;
    }

    public Article createdate(LocalDate createdate) {
        this.createdate = createdate;
        return this;
    }

    public void setCreatedate(LocalDate createdate) {
        this.createdate = createdate;
    }

    public LocalDate getLastchange() {
        return lastchange;
    }

    public Article lastchange(LocalDate lastchange) {
        this.lastchange = lastchange;
        return this;
    }

    public void setLastchange(LocalDate lastchange) {
        this.lastchange = lastchange;
    }

    public String getTitle() {
        return title;
    }

    public Article title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public Integer getForumid() {
        return forumid;
    }

    public Article forumid(Integer forumid) {
        this.forumid = forumid;
        return this;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public Integer getCatid() {
        return catid;
    }

    public Article catid(Integer catid) {
        this.catid = catid;
        return this;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Article article = (Article) o;
        if(article.number== null || number == null) {
            return false;
        }
        return Objects.equals(number, article.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "Article{" +
            "number=" + number +
            ", projid='" + projid + "'" +
            ", text='" + text + "'" +
            ", status='" + status + "'" +
            ", type='" + type + "'" +
            ", createdate='" + createdate + "'" +
            ", lastchange='" + lastchange + "'" +
            ", title='" + title + "'" +
            ", forumid='" + forumid + "'" +
            ", catid='" + catid + "'" +
            ", ratings='" + ratings + "'" +
            '}';
    }
}

