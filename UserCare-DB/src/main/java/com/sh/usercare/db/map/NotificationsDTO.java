package com.sh.usercare.db.map;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 08.01.2016.
 */
@Entity
@Table(name = "notifications" )
public class NotificationsDTO extends IntEntity {


    private  Boolean  topiccreated=true;
    private  Boolean  commentcreated=true;
    private  Boolean  statuschanged=true;
    private  Boolean  updatwatchtopics=true;
    private  Boolean  topicmerged=true;
    private  Boolean  ournews=true;
    private  Integer  userid;

    public NotificationsDTO() {

    }

    public NotificationsDTO(Integer userid) {
        this.userid = userid;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "notificationsDTO")
    List<NotificationsForumDTO> notificationsForumDTOList ;

    public List<NotificationsForumDTO> getNotificationsForumDTOList() {
        if (notificationsForumDTOList== null) notificationsForumDTOList= new ArrayList<NotificationsForumDTO>();
        return notificationsForumDTOList;
    }

    public void setNotificationsForumDTOList(List<NotificationsForumDTO> notificationsForumDTOList) {
        this.notificationsForumDTOList = notificationsForumDTOList;
    }

    public  void addForumToList(Integer forumid){
        for (NotificationsForumDTO notificationsForumDTO:getNotificationsForumDTOList() ) {
            if(notificationsForumDTO.getForumid() == forumid ) return;
        }
        NotificationsForumDTO notificationsForumDTO= new NotificationsForumDTO(forumid, this );
        getNotificationsForumDTOList().add(notificationsForumDTO );

    }

    public Boolean getTopiccreated() {
        return topiccreated;
    }

    public void setTopiccreated(Boolean topiccreated) {
        this.topiccreated = topiccreated;
    }

    public Boolean getCommentcreated() {
        return commentcreated;
    }

    public void setCommentcreated(Boolean commentcreated) {
        this.commentcreated = commentcreated;
    }

    public Boolean getStatuschanged() {
        return statuschanged;
    }

    public void setStatuschanged(Boolean statuschanged) {
        this.statuschanged = statuschanged;
    }

    public Boolean getUpdatwatchtopics() {
        return updatwatchtopics;
    }

    public void setUpdatwatchtopics(Boolean updatwatchtopics) {
        this.updatwatchtopics = updatwatchtopics;
    }

    public Boolean getTopicmerged() {
        return topicmerged;
    }

    public void setTopicmerged(Boolean topicmerged) {
        this.topicmerged = topicmerged;
    }

    public Boolean getOurnews() {
        return ournews;
    }

    public void setOurnews(Boolean ournews) {
        this.ournews = ournews;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "NotificationsDTO{" +
                "topiccreated=" + topiccreated +
                ", commentcreated=" + commentcreated +
                ", statuschanged=" + statuschanged +
                ", updatwatchtopics=" + updatwatchtopics +
                ", topicmerged=" + topicmerged +
                ", ournews=" + ournews +
                ", userid=" + userid +
                '}';
    }
}
