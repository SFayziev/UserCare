package com.sh.usercare.db.map.file;

import javax.persistence.*;

/**
 * Created by Lenovo on 15.11.2015.
 */
@Entity
@DiscriminatorValue(value = "3") //not supported for TABLE_PER_CLASS strategy
@Table(name = "img_file",  catalog = "usercare")
public class ImgFile extends ImgDTO<FileDTO> {

    @Transient
    private int paramType=3;

    public int getParamType() {
        return paramType;
    }


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE )
    @JoinColumn(name = "svalue")
    private  FileDTO svalue;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.MERGE )
    @JoinColumn(name = "ovalue")
    private  FileDTO ovalue;

    public ImgFile(Long projid , String imgkey,  String typekey, FileDTO svalue, FileDTO ovalue) {
        super( typekey);
        this.setProjid(projid);
        this.setImgkey(imgkey );
        this.svalue = svalue;
        this.ovalue = ovalue;
    }

    public ImgFile() {

    }

    @Override
    public FileDTO getSvalue() {
        return svalue;
    }

    @Override
    public void setSvalue(FileDTO svalue) {
        this.svalue = svalue;
    }

    @Override
    public FileDTO getOvalue() {
        return ovalue;
    }

    @Override
    public void setOvalue(FileDTO ovalue) {
        this.ovalue = ovalue;
    }
}
