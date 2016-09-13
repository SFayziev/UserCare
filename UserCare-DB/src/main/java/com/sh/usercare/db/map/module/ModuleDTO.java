package com.sh.usercare.db.map.module;

import com.sh.usercare.db.map.IntEntity;
import com.sh.utils.ModulePosType;

import javax.persistence.*;
import java.util.*;

/**
 * Module class
 * Created by Admin on 01.10.2015.
 */
@Entity
@Table(name = "modules",  catalog = "usercare")
public class ModuleDTO extends IntEntity {
//    private  Integer  projid;
    private  Integer  status;
    private  Integer  pos;
    private  Integer usedby;

    @Enumerated(EnumType.ORDINAL)
    private ModulePosType dispos;

    public ModulePosType getDispos() {
        return dispos;
    }

    public void setDispos(ModulePosType dispos) {
        this.dispos = dispos;
    }

    public Integer getUsedby() {
        return usedby;
    }

    public void setUsedby(Integer usedby) {
        this.usedby = usedby;
    }

    @Transient
    private HashMap<String, ModuleParamsDTO> params;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.DETACH )
    @JoinColumn(name = "modtypeid")
    private ModuleTypeDTO moduleTypeDTO;

    public ModuleDTO(Integer forumid, Integer usedby, ModuleTypeDTO moduleTypeDTO) {
        this.forumid = forumid;
        this.moduleTypeDTO = moduleTypeDTO;
        this.usedby=usedby;
        this.setStatus(1);
    }

    public ModuleDTO() {
    }
    private Integer forumid;

    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public ModuleTypeDTO getModuleTypeDTO() {
        return moduleTypeDTO;
    }

    public void setModuleTypeDTO(ModuleTypeDTO moduleTypeDTO) {
        this.moduleTypeDTO = moduleTypeDTO;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "moduleDTO")
    private List<ModuleParamsDTO> moduleParamDTOList ;

    public List<ModuleParamsDTO> getModuleParamDTOList() {
        if (moduleParamDTOList==null) {moduleParamDTOList=new ArrayList<ModuleParamsDTO>();}
        return moduleParamDTOList ;
    }

    public void setModuleParamDTOList(List<ModuleParamsDTO> moduleParamDTOList) {
        this.moduleParamDTOList = moduleParamDTOList;
    }


    public HashMap<String, ModuleParamsDTO> getParams(){
        if (params== null){
            params= new HashMap<String, ModuleParamsDTO>();
            for(ModuleParamsDTO moduleParamDTO:getModuleParamDTOList()){
                params.put(moduleParamDTO.getTypekey(), moduleParamDTO );
            }
        }
        return params;
    }

    @Override
    public String toString() {
        return "ModuleDTO{" +
                "id=" + id +

                ", status=" + status +
                ", pos=" + pos +
                '}';
    }
}
