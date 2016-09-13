package com.sh.usercare.db.map.project;


import com.sh.usercare.db.map.file.FileDTO;
import com.sh.usercare.db.map.file.ImgDTO;
import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Admin on 30.10.2015.
 */
@Entity
@Table(name = "project_design",  catalog = "usercare")
public class ProjectDesignDTO extends IntEntity implements Serializable {

    private Integer sidebarPos;
    private Integer layoutmode=0;

    public Integer getLayoutmode() {
        return layoutmode;
    }

    public void setLayoutmode(Integer layoutmode) {
        this.layoutmode = layoutmode;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, orphanRemoval = true)
    @JoinColumn(name = "projid" )
    private ProjectDTO projectDTO;

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "faviconFile", nullable = true)
    private ImgDTO faviconFileDTO;

    public ImgDTO getFaviconFileDTO() {
        return faviconFileDTO;
    }

    public void setFaviconFileDTO(ImgDTO faviconFileDTO) {
        this.faviconFileDTO = faviconFileDTO;
    }

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "bgimageFile" , nullable = true )
    private ImgDTO bgimageFileDTO;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "logoFile" , nullable = true)
    private ImgDTO logoFileDTO;

    public ImgDTO getBgimageFileDTO() {
        return bgimageFileDTO;
    }

    public void setBgimageFileDTO(ImgDTO bgimageFileDTO) {
        this.bgimageFileDTO = bgimageFileDTO;
    }

    public ImgDTO getLogoFileDTO() {
        return logoFileDTO;
    }

    public void setLogoFileDTO(ImgDTO logoFileDTO) {
        this.logoFileDTO = logoFileDTO;
    }

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "cssFile" )
    private FileDTO cssFileDTO;

    public ProjectDesignDTO() {
    }

    public ProjectDesignDTO(Long projid) {
//        this.projid=projid;

    }


    public Integer getSidebarPos() {
        return sidebarPos;
    }

    public void setSidebarPos(Integer sidebarPos) {
        this.sidebarPos = sidebarPos;
    }





    public FileDTO getCssFileDTO() {
        return cssFileDTO;
    }

    public void setCssFileDTO(FileDTO cssFileDTO) {
        this.cssFileDTO = cssFileDTO;
    }


    @Override
    public String toString() {
        return "projectDesignDTO{" +

                ", cssFileDTO=" + cssFileDTO +
                '}';
    }
}
