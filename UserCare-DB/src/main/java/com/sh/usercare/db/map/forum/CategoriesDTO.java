package com.sh.usercare.db.map.forum;

import com.sh.usercare.db.map.file.ImgDTO;
import com.sh.usercare.db.map.IntEntity;
import com.sh.usercare.db.map.topics.ArticleDTO;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import javax.persistence.*;
import java.util.List;

/**
 * Created by shuhrat on 23.09.2015.
 */
@Entity
@Table(name = "categories",  catalog = "usercare")
public class CategoriesDTO extends IntEntity {


    private  String  name;
    private  Integer  parentid=0;
    private  String description;
    private  Boolean privated=false;
    private  Integer  pos=0;

    private  Integer articles;
    private Integer comments;
    private Integer votes ;
    private  Long projid;
    private  Integer forumid;

    public Long getProjid() {
        return projid;
    }

    public void setProjid(Long projid) {
        this.projid = projid;
    }

    public CategoriesDTO() {

    }


    public CategoriesDTO(Long projid, Integer  forumid) {
        this.projid=projid;
        this.forumid = forumid;
    }

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "logoimg")
    @NotFound(action = NotFoundAction.IGNORE)
    private ImgDTO imgDTO;

    public ImgDTO getImgDTO() {
        return imgDTO;
    }

    public void setImgDTO(ImgDTO imgDTO) {
        this.imgDTO = imgDTO;
    }

    public Integer getComments() {
        return comments== null? 0: comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public void increaseArticle(int val){
        setArticles(getArticles()+val);
    }
    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getArticles() {
        return articles== null? 0 : articles;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Boolean getPrivated() {
        return privated;
    }

    public void setPrivated(Boolean privated) {
        this.privated = privated;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @Transient
    private List<ArticleDTO> articleDTOList;

    public List<ArticleDTO> getArticleDTOList() {
        return articleDTOList;
    }

    public void setArticleDTOList(List<ArticleDTO> articleDTOList) {
        this.articleDTOList = articleDTOList;
    }

    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

//    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE )
//    @JoinColumn(name = "forumid")
//    private ForumDTO forumDTO;
//
//    public ForumDTO getForumDTO() {
//        return forumDTO;
//    }

//    public void setForumDTO(ForumDTO forumDTO) {
//        this.forumDTO = forumDTO;
//    }

//    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE )
//    @JoinColumn(name = "projid")
//    private ProjectDTO projectDTO;

//    public ProjectDTO getProjectDTO() {
//        return projectDTO;
//    }
//
//    public void setProjectDTO(ProjectDTO projectDTO) {
//        this.projectDTO = projectDTO;
//    }

    @Override
    public String toString() {
        return "CategoriesDTO{" +
                ", name='" + name + '\'' +
                ", parentid=" + parentid +
                ", description='" + description + '\'' +
                ", privated=" + privated +
                ", pos=" + pos +
                '}';
    }
}
