package com.sh.usercare.db.map.module;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;

/**
 * Created by Lenovo on 05.11.2015.
 */

@Entity
@Table(name = "module_params",  catalog = "usercare")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="ptype", discriminatorType=DiscriminatorType.INTEGER)

public  class ModuleParamsDTO<C>  extends IntEntity {

    public ModuleParamsDTO() {
    }
    public ModuleParamsDTO(String typekey, ModuleDTO moduleDTO, C value) {
        this.typekey = typekey;
        this.moduleDTO = moduleDTO;
        this.value = value;
    }

    private String typekey;

    public String getTypekey() {
        return typekey;
    }

    public void setTypekey(String typekey) {
        this.typekey = typekey;
    }

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE )
    @JoinColumn( name="moduleid",  referencedColumnName = "id" , updatable = false)
    private ModuleDTO moduleDTO;

    public ModuleDTO getModuleDTO() {
        return moduleDTO;
    }

    public void setModuleDTO(ModuleDTO moduleDTO) {
        this.moduleDTO = moduleDTO;
    }



    @Transient
    private C value;

    public C getValue() {
        return value;
    }

    public void setValue(C value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "ModuleParamsDTO{" +
                "id=" + id +
                ", module=" + moduleDTO +
                '}';
    }
}
