package com.sh.usercare.db.map.forum;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;

/**
 * Created by Admin on 26.11.2015.
 */
@Entity
@Table(name = "forum_privacy",  catalog = "usercare")
public class ForumPrivacyDTO extends IntEntity{
    private Integer type = 0;
    private Boolean sso = false;
    private Boolean anonymousview = false;
    private Boolean authorizedview = false;
    private Boolean autosubscribe = false;
    private Integer assigntype;
    private Integer assigntag;
    private Integer commentshow = 1;

    public Integer getCommentshow() {
        return commentshow;
    }

    public void setCommentshow(Integer commentshow) {
        this.commentshow = commentshow;
    }

    public Integer getAssigntag() {
        return assigntag;
    }

    public void setAssigntag(Integer assigntag) {
        this.assigntag = assigntag;
    }

    public Integer getAssigntype() {
        return assigntype;
    }

    public void setAssigntype(Integer assigntype) {
        this.assigntype = assigntype;
    }

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.DETACH )
    @JoinColumn(name = "forumid")
    private ForumDTO forumDTO;

    public ForumDTO getForumDTO() {
        return forumDTO;
    }

    public void setForumDTO(ForumDTO forumDTO) {
        this.forumDTO = forumDTO;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getSso() {
        return sso;
    }

    public void setSso(Boolean sso) {
        this.sso = sso;
    }

    public Boolean getAnonymousview() {
        return anonymousview;
    }

    public void setAnonymousview(Boolean anonymousview) {
        this.anonymousview = anonymousview;
    }

    public Boolean getAuthorizedview() {
        return authorizedview;
    }

    public void setAuthorizedview(Boolean authorizedview) {
        this.authorizedview = authorizedview;
    }

    public Boolean getAutosubscribe() {
        return autosubscribe;
    }

    public void setAutosubscribe(Boolean autosubscribe) {
        this.autosubscribe = autosubscribe;
    }

    @Override
    public String toString() {
        return "ForumPrivacyDTO{" +
                "type=" + type +
                ", sso=" + sso +
                ", anonymousview=" + anonymousview +
                ", authorizedview=" + authorizedview +
                ", autosubscribe=" + autosubscribe +
                '}';
    }
}
