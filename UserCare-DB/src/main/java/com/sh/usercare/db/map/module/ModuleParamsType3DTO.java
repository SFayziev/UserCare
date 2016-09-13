package com.sh.usercare.db.map.module;

import javax.persistence.*;

/**
 * Created by Lenovo on 05.11.2015.
 */
@Entity
@DiscriminatorValue(value = "3") //not supported for TABLE_PER_CLASS strategy
@Table(name = "module_params_type_3",  catalog = "usercare")
//    @SecondaryTable(name = "param_type_1", pkJoinColumns = {@PrimaryKeyJoinColumn(name="paramid", referencedColumnName = "id")})
public class ModuleParamsType3DTO extends ModuleParamsDTO<String> {


    private  String value;



    public ModuleParamsType3DTO() {

    }

    public ModuleParamsType3DTO(ModuleDTO moduleDTO, String typeKey,  String value) {
        this.setModuleDTO(moduleDTO);
        this.value = value;
        this.setTypekey(typeKey);
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Param_type_1{" +

                ", value=" + value +
                '}';
    }
}

