package com.sh.usercare.db.map.project;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Lenovo on 05.11.2015.
 */

@Entity
@DiscriminatorValue(value = "2") //not supported for TABLE_PER_CLASS strategy
@Table(name = "project_params_type_2",  catalog = "usercare")
//@SecondaryTable(name = "param_type_2", pkJoinColumns = {@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")})

public class ProjectParamsType2DTO extends ProjectParamsDTO<Date>  {



    private Date value;

    public ProjectParamsType2DTO(){
    }

    public ProjectParamsType2DTO(ProjectDTO projectDTO, String typeKey, Date value) {
        this.setProjectDTO(projectDTO);
        setTypekey(typeKey);
        this.value = value;
    }



    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Param_type_2{" +

                ", value=" + value +  '}';
    }
}
