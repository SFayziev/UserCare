package com.sh.usercare.db.map.file;

import com.sh.usercare.db.map.IntEntity;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Lenovo on 05.11.2015.
 */

@Entity
@Table(name = "img",  catalog = "usercare")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="itype", discriminatorType=DiscriminatorType.INTEGER)
public  class ImgDTO<C> extends IntEntity {

    @Transient
    private int paramType;
    private  Long projid;

    private Boolean deleted=false;
    private String imgkey;

    public Long getProjid() {
        return projid;
    }

    public void setProjid(Long projid) {
        this.projid = projid;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public int getParamType() {
        return paramType;
    }

  

    public ImgDTO() {
    }

    /**
     *
     * @param typekey  PARAM KEY
     * @param svalue small value
     * @param ovalue original Value
     */
    public ImgDTO(Long projid, String typekey, C svalue ,  C ovalue) {

        this.projid=projid;
        this.typekey = typekey;
        this.ovalue = ovalue;
        this.svalue = svalue;
    }

    public String getImgkey() {
        return imgkey;
    }

    public void setImgkey(String imgkey) {
        this.imgkey = imgkey;
    }

    public ImgDTO(String typekey) {
        this.typekey = typekey;
    }

    private String typekey;


    public String getTypekey() {
        return typekey;
    }

    public void setTypekey(String typekey) {
        this.typekey = typekey;
    }



    @Transient
    private C svalue;

    @Transient
    private C ovalue;

    public C getSvalue() {
        return svalue;
    }

    public void setSvalue(C svalue) {
        this.svalue = svalue;
    }

    public C getOvalue() {
        return ovalue;
    }

    public void setOvalue(C ovalue) {
        this.ovalue = ovalue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "ImgDTO{" +
                "typekey='" + typekey + '\'' +
                ", svalue='" + svalue + '\'' +
                ", ovalue='" + ovalue + '\'' +
                "} " + super.toString();
    }
}
