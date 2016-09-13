package com.sh.usercare.db.map.topics;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by shuhrat on 26.09.2015.
 */

@Entity
@Table(name = "follow",  catalog = "usercare")
public class FollowDTO extends IntEntity {

    private  Integer articleid;
    private  Integer userid;

    public FollowDTO(Integer articleid, Integer userid) {
        this.articleid = articleid;
        this.userid = userid;
    }

    public FollowDTO() {
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "FollowDTO{" +
                "articleid=" + articleid +
                ", userid=" + userid +
                '}';
    }
}
