package com.sh.usercare.db.map.project;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;

/**
 * Created by Lenovo on 05.11.2015.
 */

@Entity
@Table(name = "project_params",  catalog = "usercare")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="ptype", discriminatorType=DiscriminatorType.INTEGER)
public  class ProjectParamsDTO<C>  extends IntEntity {

    public ProjectParamsDTO() {
    }
    public ProjectParamsDTO(String typekey, ProjectDTO  projectDTO, C value) {
        this.typekey = typekey;
        this. projectDTO =  projectDTO;
        this.value = value;
    }

    private String typekey;

    public String getTypekey() {
        return typekey;
    }

    public void setTypekey(String typekey) {
        this.typekey = typekey;
    }

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.DETACH )
    @JoinColumn( name="projid",  referencedColumnName = "id" , updatable = false)
    private ProjectDTO projectDTO;

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    @Transient
    private C value;

    public C getValue() {
        return value;
    }

    public void setValue(C value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProjectParamsDTO{" +
                "typekey='" + typekey + '\'' +
                ", projectDTO=" + projectDTO +
                ", value=" + value +
                '}';
    }
}
