package com.sh.usercare.db.map.topics;

import com.sh.usercare.db.map.file.ImgDTO;
import com.sh.usercare.db.map.IntEntity;
import com.sh.utils.ForumType;

import javax.persistence.*;

/**
 * Created by Lenovo on 30.11.2015.
 */
@Entity
@Table(name = "article_type",  catalog = "usercare")
public class ArticleTypeDTO extends IntEntity {
    private  String name;
    private  String  custname;
    private Integer ttype=1;
    private ForumType ftype;

    public Integer getTtype() {
        return ttype;
    }

    public ArticleTypeDTO(String name) {
        this.name = name;
    }
    public ArticleTypeDTO() {

    }

    public void setTtype(Integer ttype) {
        this.ttype = ttype;
    }

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "logoimg")
    private ImgDTO imgDTO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public ImgDTO getImgDTO() {
        return imgDTO;
    }

    public void setImgDTO(ImgDTO imgDTO) {
        this.imgDTO = imgDTO;
    }

    @Override
    public String toString() {
        return "ArticleTypeDTO{" +
                "name='" + name + '\'' +
                ", custname='" + custname + '\'' +
                ", imgDTO=" + imgDTO +
                "} " + super.toString();
    }
}
