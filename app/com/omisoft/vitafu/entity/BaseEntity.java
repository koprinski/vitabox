package com.omisoft.vitafu.entity;

import play.db.ebean.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Abstract entity. All DB entities must implement this one.
 * Created by dido on 10/16/14.
 */
@MappedSuperclass
public abstract class BaseEntity extends Model implements Serializable {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
