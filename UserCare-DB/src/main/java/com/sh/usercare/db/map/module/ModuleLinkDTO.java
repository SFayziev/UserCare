package com.sh.usercare.db.map.module;

import com.sh.usercare.db.map.file.ImgDTO;
import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Lenovo on 25.03.2016.
 */
@Entity
@Table(name = "module_links",  catalog = "usercare")
public class ModuleLinkDTO extends IntEntity {
    @NotNull
    private Integer modid;
    private Integer pos;
    private String  links;
    private String  title;
    private Boolean  newwindow=false;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "img")
    private ImgDTO imgDTO;

    public ImgDTO getImgDTO() {
        return imgDTO;
    }

    public void setImgDTO(ImgDTO imgDTO) {
        this.imgDTO = imgDTO;
    }

    public ModuleLinkDTO() { }

    public ModuleLinkDTO(Integer modid) {
        this.modid = modid;

    }


    public ModuleLinkDTO(Integer modid,  String links, String title, Boolean newwindow) {
        this.modid = modid;
        this.pos = pos;
        this.links = links;
        this.title = title;
        this.newwindow = newwindow;
    }

    public Integer getModid() {
        return modid;
    }

    public void setModid(Integer modid) {
        this.modid = modid;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getNewwindow() {
        return newwindow;
    }

    public void setNewwindow(Boolean newwindow) {
        this.newwindow = newwindow;
    }
}
