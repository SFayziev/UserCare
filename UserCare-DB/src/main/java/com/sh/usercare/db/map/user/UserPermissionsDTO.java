package com.sh.usercare.db.map.user;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;

/**
 * Created by Lenovo on 07.12.2015.
 */
@Entity
@Table(name = "user_permissons",  catalog = "usercare")

public class UserPermissionsDTO extends IntEntity {

//    private  Integer userid;
    private  Boolean manager=false;
    private  Boolean showinteamlist=false;
    private  Boolean payforproject=false;
    private  Boolean manageusers=false;
    private  Boolean assignperformers=false;
    private  Boolean editfeedback=false;
    private  Boolean deletefeedback=false;
    private  Boolean managefeedback=false;
    private  Boolean feedbacktags=false;
    private  Boolean moderation=false;
    private  Boolean translationcontent=false;
    private  Boolean chatoperator=false;
    private  Boolean viewstatistics=false;
    private Integer status=0;
//    private Integer userid;

//    public Integer getUserid() {
//        return userid;
//    }
//
//    public void setUserid(Integer userid) {
//        this.userid = userid;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.DETACH )
    @JoinColumn(name = "userid",  insertable = false, updatable = false )
    private UserDTO userDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    public Boolean getShowinteamlist() {
        return showinteamlist;
    }

    public void setShowinteamlist(Boolean showinteamlist) {
        this.showinteamlist = showinteamlist;
    }

    public Boolean getPayforproject() {
        return  manager?manager:payforproject;
    }

    public void setPayforproject(Boolean payforproject) {
        this.payforproject = payforproject;
    }

    public Boolean getManageusers() {
        return manager?manager:manageusers;
    }

    public void setManageusers(Boolean manageusers) {
        this.manageusers = manageusers;
    }

    public Boolean getAssignperformers() {
        return manager?manager:assignperformers;
    }

    public void setAssignperformers(Boolean assignperformers) {
        this.assignperformers = assignperformers;
    }

    public Boolean getEditfeedback() {
        return manager?manager:editfeedback;
    }

    public void setEditfeedback(Boolean editfeedback) {
        this.editfeedback = editfeedback;
    }

    public Boolean getDeletefeedback() {
        return manager?manager:deletefeedback;
    }

    public void setDeletefeedback(Boolean deletefeedback) {
        this.deletefeedback = deletefeedback;
    }

    public Boolean getManagefeedback() {
        return manager?manager:managefeedback;
    }

    public void setManagefeedback(Boolean managefeedback) {
        this.managefeedback = managefeedback;
    }

    public Boolean getFeedbacktags() {
        return manager?manager:feedbacktags;
    }

    public void setFeedbacktags(Boolean feedbacktags) {
        this.feedbacktags = feedbacktags;
    }

    public Boolean getModeration() {
        return manager?manager:moderation;
    }

    public void setModeration(Boolean moderation) {
        this.moderation = moderation;
    }

    public Boolean getTranslationcontent() {
        return manager?manager:translationcontent;
    }

    public void setTranslationcontent(Boolean translationcontent) {
        this.translationcontent = translationcontent;
    }

    public Boolean getChatoperator() {
        return manager?manager:chatoperator;
    }

    public void setChatoperator(Boolean chatoperator) {
        this.chatoperator = chatoperator;
    }

    public Boolean getViewstatistics() {
        return manager?manager:viewstatistics;
    }

    public void setViewstatistics(Boolean viewstatistics) {
        this.viewstatistics = viewstatistics;
    }

    @Override
    public String toString() {
        return "UserPermissionsDTO{" +

                " manager=" + manager +
                ", showinteamlist=" + showinteamlist +
                ", payforproject=" + payforproject +
                ", manageusers=" + manageusers +
                ", assignperformers=" + assignperformers +
                ", editfeedback=" + editfeedback +
                ", deletefeedback=" + deletefeedback +
                ", managefeedback=" + managefeedback +
                ", feedbacktags=" + feedbacktags +
                ", moderation=" + moderation +
                ", translationcontent=" + translationcontent +
                ", chatoperator=" + chatoperator +
                ", viewstatistics=" + viewstatistics +
                "} " + super.toString();
    }
}
