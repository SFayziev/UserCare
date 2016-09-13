package com.sh.usercare.db.map.topics;

import com.sh.usercare.db.map.IntEntity;
import com.sh.utils.IpConvertor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by shuhrat on 03.09.2015.
 */
@Entity
@Table(name = "comment_vote",  catalog = "usercare")

public class CommentVoteDTO extends IntEntity {

    private  Integer commentid;
    private  Integer value;
    private  Long remip;
    private  Integer userid;

    public CommentVoteDTO(){}

    public CommentVoteDTO(Integer commentid, Integer value, String remip, Integer userid) {
        this.commentid = commentid;
        this.value = value;
        this.setRemip( remip);
        this.userid = userid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getRemip() {
        IpConvertor ipConvertor= new IpConvertor();
        return remip==null?null: ipConvertor.longToIp(remip);
    }

    public void setRemip(String remip) {
        IpConvertor ipConvertor= new IpConvertor();
        this.remip = remip==null? null: ipConvertor.ipToLong (remip);
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
