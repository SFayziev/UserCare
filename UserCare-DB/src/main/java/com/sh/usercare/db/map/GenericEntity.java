package com.sh.usercare.db.map;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by shuhrat on 16.08.2015.
 */
public interface GenericEntity<ID extends Serializable> {
    public abstract ID getId();
    public abstract void setId(final ID id);

//    public LocalDateTime getCreatedDate();
//
//    public void setCreatedDate(LocalDateTime createdDate);
//
//    public LocalDateTime getModifiedDate() ;
//
//    public void setModifiedDate(LocalDateTime modifiedDate) ;

}