package com.sh.usercare.db.map.forum;

import com.sh.usercare.db.map.IntEntity;
import com.sh.usercare.db.map.topics.ArticleTagsDTO;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Lenovo on 29.11.2015.
 */
@Entity
@Table(name = "forum_tags",  catalog = "usercare")
public class ForumTagsDTO extends IntEntity {

private  Integer forumid;
private  String name;

    public ForumTagsDTO(Integer forumid, String name) {
        this.forumid = forumid;
        this.name = name;
    }

    public ForumTagsDTO() {

    }


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "forumTagsDTO")
    private List<ArticleTagsDTO> articleTagsDTOList;

    public List<ArticleTagsDTO> getArticleTagsDTOList() {
        return articleTagsDTOList;
    }

    public void setArticleTagsDTOList(List<ArticleTagsDTO> articleTagsDTOList) {
        this.articleTagsDTOList = articleTagsDTOList;
    }

    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ForumTagsDTO{" +
                "forumid=" + forumid +
                ", tag='" + name + '\'' +
                "} " + super.toString();
    }
}
