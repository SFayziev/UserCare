package com.sh.usercare.db.map.project;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Lenovo on 05.11.2015.
 */
@Entity
@DiscriminatorValue(value = "4") //not supported for TABLE_PER_CLASS strategy
@Table(name = "project_params_type_4",  catalog = "usercare")
//    @SecondaryTable(name = "param_type_1", pkJoinColumns = {@PrimaryKeyJoinColumn(name="paramid", referencedColumnName = "id")})
public class ProjectParamsType4DTO extends ProjectParamsDTO<String> {

    private  String value;

    public ProjectParamsType4DTO() {  }

    public ProjectParamsType4DTO(ProjectDTO projectDTO, String typeKey, String value) {
        this.setProjectDTO(projectDTO);
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

