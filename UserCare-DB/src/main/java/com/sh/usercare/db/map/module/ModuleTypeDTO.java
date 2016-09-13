package com.sh.usercare.db.map.module;

import com.sh.usercare.db.map.IntEntity;
import com.sh.utils.ModulePosType;

import javax.persistence.*;

/**
 * Created by Admin on 02.10.2015.
 */
@Entity
@Table(name = "module_type",  catalog = "usercare")

public class ModuleTypeDTO extends IntEntity {

    private String template;
    private Boolean editable;
    private Boolean undeletable;
    private String  edittemplate;
    private  Integer  status;
    private String cssclass;

    public String getCssclass() {
        return cssclass;
    }

    public void setCssclass(String cssclass) {
        this.cssclass = cssclass;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEdittemplate() {
        return edittemplate;
    }

    public void setEdittemplate(String edittemplate) {
        this.edittemplate = edittemplate;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getUndeletable() {
        return undeletable;
    }

    public void setUndeletable(Boolean undeletable) {
        this.undeletable = undeletable;
    }

    @Enumerated(EnumType.ORDINAL)
    private ModulePosType dispos;

    public ModulePosType getDispos() {
        return dispos;
    }

    public void setDispos(ModulePosType dispos) {
        this.dispos = dispos;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "ModuleTypeDTO{" +
                "template='" + template + '\'' +
                ", editable=" + editable +
                ", undeletable=" + undeletable +
                ", edittemplate='" + edittemplate + '\'' +
                ", dispos=" + dispos +
                '}';
    }
}
