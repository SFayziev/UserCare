package com.sh.usercare.db.map.user;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Admin on 15.09.2015.
 */
@Entity
@Table(name = "user_group",  catalog = "usercare")

public class UserGrDTO extends IntEntity {
    private  String groupname;

    public String getGroupname() {
        return groupname;
    }

    @Override
    public String toString() {
        return "UserGrDTO{" +
                "groupname='" + groupname + '\'' +
                '}';
    }
}
