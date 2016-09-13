package com.sh.usercare.db.map;

import javax.persistence.*;

/**
 * Created by Admin on 18.11.2015.
 */
@Entity
@Table(name = "i18nmessage_value",  catalog = "usercare")
public class I18nMessageValueDTO extends IntEntity{

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
    @JoinColumn( name="mesid",  referencedColumnName = "id" )
    private I18nMessageDTO i18nMessageDTO;

    private  Integer lanid;


    private  String value;

    public I18nMessageValueDTO() {
    }


    public I18nMessageValueDTO(I18nMessageDTO i18nMessageDTO, Integer lanid, String value) {
        this.i18nMessageDTO = i18nMessageDTO;
        this.lanid = lanid;
        this.value = value;
    }

    public I18nMessageDTO getI18nMessageDTO() {
        return i18nMessageDTO;
    }

    public void setI18nMessageDTO(I18nMessageDTO i18nMessageDTO) {
        this.i18nMessageDTO = i18nMessageDTO;
    }

    public Integer getLanid() {
        return lanid;
    }

    public void setLanid(Integer lanid) {
        this.lanid = lanid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "I18nMessageValueDTO{" +
                "lanid=" + lanid +
                ", value='" + value + '\'' +
                "} " + super.toString();
    }
}
