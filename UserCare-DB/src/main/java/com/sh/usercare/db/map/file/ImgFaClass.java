package com.sh.usercare.db.map.file;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Lenovo on 15.11.2015.
 */
@Entity
@DiscriminatorValue(value = "1") //not supported for TABLE_PER_CLASS strategy
@Table(name = "img_fa_class",  catalog = "usercare")
public class ImgFaClass extends ImgDTO<String> {

    @Transient
    private int paramType=1;

    public int getParamType() {
        return paramType;
    }

    

    private  String svalue;
    private  String ovalue;

    public ImgFaClass( Long projid , String imgkey, String typekey , String svalue, String ovalue) {
        super(typekey);
        this.svalue = svalue;
        this.ovalue = ovalue;
        this.setProjid(projid);
        this.setImgkey(imgkey );
    }

    public ImgFaClass() {

    }

    @Override
    public String getSvalue() {
        return svalue;
    }

    @Override
    public void setSvalue(String svalue) {
        this.svalue = svalue;
    }

    @Override
    public String getOvalue() {
        return ovalue;
    }

    @Override
    public void setOvalue(String ovalue) {
        this.ovalue = ovalue;
    }

    @Override
    public String toString() {
        return "ImgFaClass{" +
                "paramType=" + paramType +
                ", svalue='" + svalue + '\'' +
                ", ovalue='" + ovalue + '\'' +
                "} " + super.toString();
    }
}
