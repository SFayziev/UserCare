package com.sh.usercare.db.map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by shuhrat on 16.08.2015.
 */
@MappedSuperclass
public abstract class LongEntity implements GenericEntity<Long> {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy= GenerationType.AUTO )
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @CreatedDate
//    LocalDateTime createdDate;
//    @LastModifiedDate
//    LocalDateTime modifiedDate;
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public LocalDateTime getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(LocalDateTime modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }
}
