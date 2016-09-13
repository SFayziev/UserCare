package com.sh.usercare.db.map;

import javax.persistence.*;

/**
 * Created by Lenovo on 08.01.2016.
 */
@Entity
@Table(name = "notifications_forums" )
public class NotificationsForumDTO extends IntEntity {
    private  Integer forumid;
//    private  Integer  notifityid;
    private  Boolean enabled;

    public NotificationsForumDTO() {

    }

    public NotificationsForumDTO(Integer forumid,  NotificationsDTO notificationsDTO) {
        this.forumid = forumid;
        this.notificationsDTO = notificationsDTO;
        enabled=true;
    }

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.DETACH )
    @JoinColumn(name = "notifyid")
    private NotificationsDTO notificationsDTO;

    public NotificationsDTO getNotificationsDTO() {
        return notificationsDTO;
    }

    public void setNotificationsDTO(NotificationsDTO notificationsDTO) {
        this.notificationsDTO = notificationsDTO;
    }


    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public Boolean getEnabled() {
        if (enabled== null) enabled=false;
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "NotificationsForumDTO{" +
                "forumid=" + forumid +
                ", enabled=" + enabled +
                ", notificationsDTO=" + notificationsDTO +
                '}';
    }
}
