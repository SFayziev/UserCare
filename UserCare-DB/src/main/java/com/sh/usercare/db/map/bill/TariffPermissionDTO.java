package com.sh.usercare.db.map.bill;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Admin on 15.03.2016.
 */
@Entity
@Table(name = "tariff_permission",  catalog = "usercare")
public class TariffPermissionDTO extends IntEntity {
    private  Integer tariffid;
    private  Integer permissionid;

    public Integer getTariffid() {
        return tariffid;
    }

    public void setTariffid(Integer tariffid) {
        this.tariffid = tariffid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    @Override
    public String toString() {
        return "TariffPermissionDTO{" +
                "tariffid=" + tariffid +
                ", permissionid=" + permissionid +
                '}';
    }
}
