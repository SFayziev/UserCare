package com.sh.usercare.db.map;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by shuhrat on 16.08.2015.
 */
@MappedSuperclass
public abstract class IntEntity implements Serializable, Cloneable{

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy= GenerationType.AUTO )
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
