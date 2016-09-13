package com.sh.usercare.db.map.project;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by shuhrat on 23.09.2015.
 */
@Entity
@Table(name = "languages",  catalog = "usercare")
public class LanguagesDTO extends IntEntity {

    private String  namesmall;
    private String  name;
    private String  pagecode;
    private String  flagpic;

    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNamesmall() {
        return namesmall;
    }

    public void setNamesmall(String namesmall) {
        this.namesmall = namesmall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPagecode() {
        return pagecode;
    }

    public void setPagecode(String pagecode) {
        this.pagecode = pagecode;
    }

    public String getFlagpic() {
        return flagpic;
    }

    public void setFlagpic(String flagpic) {
        this.flagpic = flagpic;
    }

    @Override
    public String toString() {
        return "languagesDTO{" +
                "namesmall='" + namesmall + '\'' +
                ", name='" + name + '\'' +
                ", pagecode='" + pagecode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
