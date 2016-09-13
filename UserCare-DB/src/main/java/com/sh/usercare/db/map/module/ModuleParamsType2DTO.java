package com.sh.usercare.db.map.module;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lenovo on 05.11.2015.
 */

@Entity
@DiscriminatorValue(value = "2") //not supported for TABLE_PER_CLASS strategy
@Table(name = "module_params_type_2",  catalog = "usercare")
//@SecondaryTable(name = "param_type_2", pkJoinColumns = {@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")})

public class ModuleParamsType2DTO extends ModuleParamsDTO<Date>  {



    private Date value;

    public ModuleParamsType2DTO(){
    }

    public ModuleParamsType2DTO(ModuleDTO moduleDTO,String typeKey,   Date value) {
        this.setModuleDTO(moduleDTO);
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
