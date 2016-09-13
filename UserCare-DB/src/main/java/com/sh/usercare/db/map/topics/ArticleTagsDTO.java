package com.sh.usercare.db.map.topics;

import com.sh.usercare.db.map.forum.ForumTagsDTO;
import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;

/**
 * Created by Admin on 19.01.2016.
 */

@Entity
@Table(name = "article_tag",  catalog = "usercare")

public class ArticleTagsDTO extends IntEntity {

    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.DETACH )
    @JoinColumn(name = "articid")
    private ArticleDTO articleDTO;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE )
    @JoinColumn(name = "tagid")
    private ForumTagsDTO forumTagsDTO;

    public ArticleDTO getArticleDTO() {
        return articleDTO;
    }

    public void setArticleDTO(ArticleDTO articleDTO) {
        this.articleDTO = articleDTO;
    }

    public ForumTagsDTO getForumTagsDTO() {
        return forumTagsDTO;
    }

    public void setForumTagsDTO(ForumTagsDTO forumTagsDTO) {
        this.forumTagsDTO = forumTagsDTO;
    }


    @Override
    public String toString() {
        return "ArticleTagsDTO{" +
                "articleDTO=" + articleDTO +
                ", forumTagsDTO=" + forumTagsDTO +
                '}';
    }
}
