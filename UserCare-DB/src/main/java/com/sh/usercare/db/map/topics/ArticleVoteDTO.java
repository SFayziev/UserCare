package com.sh.usercare.db.map.topics;

import com.sh.usercare.db.map.IntEntity;
import com.sh.utils.IpConvertor;

import javax.persistence.*;

/**
 * Created by shuhrat on 03.09.2015.
 */
@Entity
@Table(name = "article_vote",  catalog = "usercare")

public class ArticleVoteDTO extends IntEntity {

    private  Integer articleid;
    private  Integer value;
    private  Long remip;
    private  Integer  userid;

    public ArticleVoteDTO() {

    }

    public ArticleVoteDTO(Integer articleid, Integer value, String remip, Integer userid) {
        this.articleid = articleid;
        this.value = value;
        this.setRemip(remip);
        this.userid = userid;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
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



    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "ArticleVoteDTO{" +
                "articleid=" + articleid +
                ", value=" + value +
                ", remip=" + remip +
                ", userid=" + userid +
                '}';
    }
}
