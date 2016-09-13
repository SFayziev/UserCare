package com.sh.usercare.db.map.module;

import javax.persistence.*;

/**
 * Created by Lenovo on 05.11.2015.
 */
    @Entity
    @DiscriminatorValue(value = "1") //not supported for TABLE_PER_CLASS strategy
    @Table(name = "module_params_type_1",  catalog = "usercare")
//    @SecondaryTable(name = "param_type_1", pkJoinColumns = {@PrimaryKeyJoinColumn(name="paramid", referencedColumnName = "id")})
    public class ModuleParamsType1DTO extends ModuleParamsDTO<Integer> {


        private  Integer value;



    public ModuleParamsType1DTO() {

    }

    public ModuleParamsType1DTO(ModuleDTO moduleDTO, String typeKey ,Integer value) {
        this.setModuleDTO(moduleDTO);
        setTypekey(typeKey);
        this.value = value;
    }



    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Param_type_1{" +

                ", value=" + value +
                '}';
    }
}

