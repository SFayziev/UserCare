package com.sh.usercare.db.map.forum;

import com.sh.usercare.db.map.IntEntity;
import com.sh.usercare.db.map.topics.ArticleStatusDTO;

import javax.persistence.*;

/**
 * Created by Admin on 02.12.2015.
 */
@Entity
@Table(name = "topic_type_status",  catalog = "usercare")
public class TopicTypeStatusDTO extends IntEntity {
//    private  Long projid;
//    private  Integer forumid;

    private  String  custname;
    private Integer pos;

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "statusid")
    private ArticleStatusDTO articleStatusDTO;

    public String getName(){
        return  articleStatusDTO == null? null : articleStatusDTO.getName();
    }
    public ArticleStatusDTO getArticleStatusDTO() {
        return articleStatusDTO;
    }

    public void setArticleStatusDTO(ArticleStatusDTO articleStatusDTO) {
        this.articleStatusDTO = articleStatusDTO;
    }

    public TopicTypeStatusDTO() {
    }

    public TopicTypeStatusDTO(Long projid , ArticleStatusDTO articleStatusDTO, TopicTypeDTO topicTypeDTO, String custname) {
        this.articleStatusDTO = articleStatusDTO;
        this.topicTypeDTO = topicTypeDTO;
        this.custname = custname;
//        this.forumid=topicTypeDTO.getForumid();
//        this.projid=projid;
    }

    public TopicTypeStatusDTO(ArticleStatusDTO articleStatusDTO,  String custname) {
        this.articleStatusDTO = articleStatusDTO;
        this.custname = custname;
//        this.projid=articleStatusDTO.getProjid();
    }


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    @JoinColumn(name = "typeid")
    private TopicTypeDTO topicTypeDTO ;

    public TopicTypeDTO getTopicTypeDTO() {
        return topicTypeDTO;
    }

    public void setTopicTypeDTO(TopicTypeDTO topicTypeDTO) {
        this.topicTypeDTO = topicTypeDTO;
    }

//    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.MERGE)
//    @JoinColumn(name = "forumstatusid")
//    private ForumStatusDTO forumStatusDTO;
//
//    public ForumStatusDTO getForumStatusDTO() {
//        return forumStatusDTO;
//    }
//
//    public void setForumStatusDTO(ForumStatusDTO forumStatusDTO) {
//        this.forumStatusDTO = forumStatusDTO;
//    }

//    public Integer getProjid() {
//        return projid;
//    }
//
//    public void setProjid(Long projid) {
//        this.projid = projid;
//    }

//    public Integer getForumid() {
//        return forumid;
//    }
//
//    public void setForumid(Integer forumid) {
//        this.forumid = forumid;
//    }



    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    @Override
    public String toString() {
        return "TopicTypeStatusDTO{" +
//                "projid=" + projid +
//                ", forumid=" + forumid +
                ", custname='" + custname + '\'' +
                '}';
    }
}
