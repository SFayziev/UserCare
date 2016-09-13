package com.sh.usercare.db.map.topics;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.awt.*;

/**
 * Created by shuhrat on 29.08.2015.
 */
@Entity
@Table(name = "article_status",  catalog = "usercare")

public class ArticleStatusDTO extends IntEntity {

    private String name;
    private String color="#FFFFFF";
    private Integer logicalgroup=0;
    private Integer action=0;

    private Integer pos;
    private Integer forumid;
    private  Long projid;
    private  Integer atype=1;


    @Transient
    private Boolean isInForumType=false;
    @Transient
    Color rgbcolor ;

    public Boolean getIsInForumType() {
        return isInForumType;
    }

    public void setIsInForumType(Boolean isInForumType) {
        this.isInForumType = isInForumType;
    }

    public ArticleStatusDTO(Long projid, Integer forumid) {
        this.projid = projid;
        this.forumid = forumid;
    }

    public ArticleStatusDTO() {

    }

    public Color getRgbcolor() {
        if (rgbcolor== null){
            try {
                rgbcolor=  Color.decode(color);

            } catch (Exception e) {
                rgbcolor= Color.decode("#cccccc");
            }
        }
        return rgbcolor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {

        try {
            rgbcolor=  Color.decode(color);

        } catch (Exception e) {
            rgbcolor= Color.decode("#cccccc");
        }

        this.color = color;
    }

    public Integer getAtype() {
        return atype;
    }

    public void setAtype(Integer atype) {
        this.atype = atype;
    }

    public Long getProjid() {
        return projid;
    }

    public void setProjid(Long projid) {
        this.projid = projid;
    }

    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getLogicalgroup() {
        return logicalgroup;
    }

    public void setLogicalgroup(Integer logicalgroup) {
        this.logicalgroup = logicalgroup;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "ArticleStatusDTO{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", logicalgroup=" + logicalgroup +
                ", action=" + action +
                '}';
    }
}
