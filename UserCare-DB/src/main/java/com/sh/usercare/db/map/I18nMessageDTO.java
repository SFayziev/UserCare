package com.sh.usercare.db.map;

import com.sh.usercare.db.map.project.ProjectDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Admin on 18.11.2015.
 */

@Entity
@Table(name = "i18nmessage",  catalog = "usercare")
public class I18nMessageDTO extends IntEntity{

    private  String mkey;

    public I18nMessageDTO(String mkey, ProjectDTO projectDTO) {
        this.mkey = mkey;
        this.projectDTO = projectDTO;
    }

    public I18nMessageDTO() {

    }

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.DETACH )
    @JoinColumn(name = "projid")
    private ProjectDTO projectDTO;

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public String getMkey() {
        return mkey;
    }

    public void setMkey(String mkey) {
        this.mkey = mkey;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "i18nMessageDTO")
    private List<I18nMessageValueDTO> i18nMessageValueDTOs = new ArrayList<I18nMessageValueDTO>();

    public List<I18nMessageValueDTO> getI18nMessageValueDTOs() {
        return i18nMessageValueDTOs;
    }

    public void setI18nMessageValueDTOs(List<I18nMessageValueDTO> i18nMessageValueDTOs) {
        this.i18nMessageValueDTOs = i18nMessageValueDTOs;
    }

    public void setI18nMessageValue(I18nMessageValueDTO i18nMessageValue) {
        if (null==this.i18nMessageValueDTOs){
            this.i18nMessageValueDTOs=new ArrayList<I18nMessageValueDTO>();

        }

        I18nMessageValueDTO findi18nMessageValueDTO=get18nMessageValueByLangId(i18nMessageValue.getLanid());
        if (null==findi18nMessageValueDTO){
            this.i18nMessageValueDTOs.add(i18nMessageValue);
        }
        else {
            findi18nMessageValueDTO.setValue(i18nMessageValue.getValue());
        }
    }

    public I18nMessageValueDTO get18nMessageValueByLangId(Integer langid){
        for (I18nMessageValueDTO i18nMessageValueDTO: getI18nMessageValueDTOs()  ){
            if (Objects.equals(i18nMessageValueDTO.getLanid(), langid)) return i18nMessageValueDTO;
        }
        return null;
    }

    @Override
    public String toString() {
        return "I18nMessageDTO{" +
                "mkey='" + mkey + '\'' +

                ", i18nMessageValueDTOs=" + i18nMessageValueDTOs +
                '}';
    }
}
