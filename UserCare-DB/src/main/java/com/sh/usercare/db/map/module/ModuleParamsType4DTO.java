package com.sh.usercare.db.map.module;


import javax.persistence.*;

/**
 * Created by Lenovo on 05.11.2015.
 */
@Entity
@DiscriminatorValue(value = "4") //not supported for TABLE_PER_CLASS strategy
@Table(name = "module_params_type_4",  catalog = "usercare")
//    @SecondaryTable(name = "param_type_1", pkJoinColumns = {@PrimaryKeyJoinColumn(name="paramid", referencedColumnName = "id")})
public class ModuleParamsType4DTO extends ModuleParamsDTO<String> {

    private  String value;

    public ModuleParamsType4DTO() {  }

    public ModuleParamsType4DTO(ModuleDTO moduleDTO, String typeKey,  String value) {
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

