package com.sh.usercare.db.map.bill;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Admin on 15.03.2016.
 */
@Entity
@Table(name = "tpermission",  catalog = "usercare")
public class TPermissionDTO extends IntEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TPermission{" +
                "name='" + name + '\'' +
                '}';
    }
}
