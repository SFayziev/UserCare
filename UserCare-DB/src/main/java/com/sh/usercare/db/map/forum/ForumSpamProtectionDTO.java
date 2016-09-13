package com.sh.usercare.db.map.forum;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Lenovo on 03.12.2015.
 */
@Entity
@Table(name = "forum_spam_protection",  catalog = "usercare")
public class ForumSpamProtectionDTO extends IntEntity {
    private  Boolean  sanonymousfeedback=false;
    private  Boolean  anonymousvoting=false;
    private  Boolean  captchaanonymous=false;
    private  Boolean  captchaauthuser=false;
    private  Boolean  captchaemailnotverified=false;
    private  Integer  captchamessagecount;
    private  Integer  captchaaccountage;
    private  Boolean  modflagbyusers=false;
    private  Boolean  modbyakismet=false;
    private  Boolean  modexternallink=false;
    private  Boolean  modemailnotverified=false;
    private  Integer  modmessagecount;
    private  Integer  modaccountage;
    private  Integer  forumid;
    private  Long  projid;
    private  Integer  ftype;
    private  Boolean   modseletecteduser;

    public ForumSpamProtectionDTO(Integer id ) {
        this.id = id;
    }
    public ForumSpamProtectionDTO( ) {

    }

    public Boolean getModseletecteduser() {
        return modseletecteduser;
    }

    public void setModseletecteduser(Boolean modseletecteduser) {
        this.modseletecteduser = modseletecteduser;
    }

    public Boolean getSanonymousfeedback() {
        return sanonymousfeedback;
    }

    public void setSanonymousfeedback(Boolean sanonymousfeedback) {
        this.sanonymousfeedback = sanonymousfeedback;
    }

    public Boolean getAnonymousvoting() {
        return anonymousvoting;
    }

    public void setAnonymousvoting(Boolean anonymousvoting) {
        this.anonymousvoting = anonymousvoting;
    }

    public Boolean getCaptchaanonymous() {
        return captchaanonymous;
    }

    public void setCaptchaanonymous(Boolean captchaanonymous) {
        this.captchaanonymous = captchaanonymous;
    }

    public Boolean getCaptchaauthuser() {
        return captchaauthuser;
    }

    public void setCaptchaauthuser(Boolean captchaauthuser) {
        this.captchaauthuser = captchaauthuser;
    }

    public Boolean getCaptchaemailnotverified() {
        return captchaemailnotverified;
    }

    public void setCaptchaemailnotverified(Boolean captchaemailnotverified) {
        this.captchaemailnotverified = captchaemailnotverified;
    }

    public Integer getCaptchamessagecount() {
        return captchamessagecount;
    }

    public void setCaptchamessagecount(Integer captchamessagecount) {
        this.captchamessagecount = captchamessagecount;
    }

    public Integer getCaptchaaccountage() {
        return captchaaccountage;
    }

    public void setCaptchaaccountage(Integer captchaaccountage) {
        this.captchaaccountage = captchaaccountage;
    }

    public Boolean getModflagbyusers() {
        return modflagbyusers;
    }

    public void setModflagbyusers(Boolean modflagbyusers) {
        this.modflagbyusers = modflagbyusers;
    }

    public Boolean getModbyakismet() {
        return modbyakismet;
    }

    public void setModbyakismet(Boolean modbyakismet) {
        this.modbyakismet = modbyakismet;
    }

    public Boolean getModexternallink() {
        return modexternallink;
    }

    public void setModexternallink(Boolean modexternallink) {
        this.modexternallink = modexternallink;
    }

    public Boolean getModemailnotverified() {
        return modemailnotverified;
    }

    public void setModemailnotverified(Boolean modemailnotverified) {
        this.modemailnotverified = modemailnotverified;
    }

    public Integer getModmessagecount() {
        return modmessagecount;
    }

    public void setModmessagecount(Integer modmessagecount) {
        this.modmessagecount = modmessagecount;
    }

    public Integer getModaccountage() {
        return modaccountage;
    }

    public void setModaccountage(Integer modaccountage) {
        this.modaccountage = modaccountage;
    }

    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public Long getProjid() {
        return projid;
    }

    public void setProjid(Long projid) {
        this.projid = projid;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    @Override
    public String toString() {
        return "ForumSpamProtection{" +
                "sanonymousfeedback=" + sanonymousfeedback +
                ", anonymousvoting=" + anonymousvoting +
                ", captchaanonymous=" + captchaanonymous +
                ", captchaauthuser=" + captchaauthuser +
                ", captchaemailnotverified=" + captchaemailnotverified +
                ", captchamessagecount=" + captchamessagecount +
                ", captchaaccountage=" + captchaaccountage +
                ", modflagbyusers=" + modflagbyusers +
                ", modbyakismet=" + modbyakismet +
                ", modexternallink=" + modexternallink +
                ", modemailnotverified=" + modemailnotverified +
                ", modmessagecount=" + modmessagecount +
                ", modaccountage=" + modaccountage +
                ", forumid=" + forumid +
                ", projid=" + projid +
                ", ftype=" + ftype +
                "} " + super.toString();
    }
}
