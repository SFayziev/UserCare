package com.sh.usercare.db.map.project;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Lenovo on 05.11.2015.
 */
    @Entity
    @DiscriminatorValue(value = "1") //not supported for TABLE_PER_CLASS strategy
    @Table(name = "project_params_type_1",  catalog = "usercare")
//    @SecondaryTable(name = "param_type_1", pkJoinColumns = {@PrimaryKeyJoinColumn(name="paramid", referencedColumnName = "id")})
    public class ProjectParamsType1DTO extends ProjectParamsDTO<Integer> {


        private  Integer value;



    public ProjectParamsType1DTO() {

    }

    public ProjectParamsType1DTO(ProjectDTO projectDTO, String typeKey, Integer value) {
        this.setProjectDTO(projectDTO);
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

