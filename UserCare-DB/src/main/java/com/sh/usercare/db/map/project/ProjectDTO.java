package com.sh.usercare.db.map.project;

import com.sh.usercare.db.map.I18nMessageDTO;
import com.sh.usercare.db.map.I18nMessageValueDTO;
import com.sh.usercare.db.map.IntEntity;
import com.sh.usercare.db.map.LongEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by shuhrat on 06.08.2015.
 */

@Entity
@Table(name = "project",  catalog = "usercare")
@XmlRootElement
public class ProjectDTO extends LongEntity {
    @Transient
    @Value("${category.content.count}")
    private  int CategoryCount;

    private String name;
    private String alias;
    private Integer status=0;
    private Date startdate;
    private Integer type;
    @URL
    private String url;
    @Email
    private String email;
    private Integer lang;
    private  Long defaultforum;

//    @Transient
//    HashMap<String, ProjectParamsDTO> params;
//
//    @Transient
//    HashMap<String, I18nMessageDTO> i18nMessages;


    public Integer getLang() {
        return lang;
    }

    public void setLang(Integer lang) {
        this.lang = lang;
    }

    public Long getDefaultforum() {
        return defaultforum;
    }

    public void setDefaultforum(Long defaultforum) {
        this.defaultforum = defaultforum;
    }



//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, mappedBy = "projectDTO")
//    List<I18nMessageDTO> i18nMessageDTOList ;
//
//    public List<I18nMessageDTO> getI18nMessageDTOList() {
//        return i18nMessageDTOList;
//    }
//
//    public void setI18nMessageDTOList(List<I18nMessageDTO> i18nMessageDTOList) {
//        this.i18nMessageDTOList = i18nMessageDTOList;
//    }


//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, mappedBy = "projectDTO")
//    List<ProjectParamsDTO> projectParamsDTOList;
//
//    public List<ProjectParamsDTO> getProjectParamsDTOList() {
//        return projectParamsDTOList;
//    }
//
//    public HashMap<String, ProjectParamsDTO> getParams(){
//        if (params== null){
//            params= new HashMap<String, ProjectParamsDTO>();
//            for(ProjectParamsDTO projectParamsDTO:getProjectParamsDTOList()){
//                params.put(projectParamsDTO.getTypekey(), projectParamsDTO );
//            }
//        }
//        return params;
//    }
//
//    public HashMap<String, I18nMessageDTO> getI18nMessages(){
//        if (i18nMessages== null){
//           reInitializeI18n();
//        }
//        return i18nMessages;
//    }
//    public final String getMessage(String code, Object[] args, String defaultParamsMessage, Locale locale){
//        I18nMessageDTO mresresult=getI18nMessages().get(code);
//        if (mresresult != null){
//            String defaultMessage= null;
//            String codeMessage=null;
//            for(I18nMessageValueDTO i18nMessageValueDTO:mresresult.getI18nMessageValueDTOs() ){
//                if (i18nMessageValueDTO.getLanid()==1 ) defaultMessage=i18nMessageValueDTO.getValue();
//                if ((i18nMessageValueDTO.getLanid()==2) && (locale.getLanguage().equals("ru"))){
//                    codeMessage=i18nMessageValueDTO.getValue();
//                }
//                else if ((i18nMessageValueDTO.getLanid()==4) && (locale.getLanguage().equals("de"))){
//                    codeMessage=i18nMessageValueDTO.getValue();
//                }
//                else if ((i18nMessageValueDTO.getLanid()==5) && (locale.getLanguage().equals("fr"))){
//                    codeMessage=i18nMessageValueDTO.getValue();
//                }
//            }
//            return codeMessage==null?defaultMessage:codeMessage;
//
//        }
//
//        return null;
//    }
//    public void reInitializeI18n(){
//        i18nMessages= new HashMap<String, I18nMessageDTO>();
//        for(I18nMessageDTO i18nMessageDTO:getI18nMessageDTOList()){
//            i18nMessages.put(i18nMessageDTO.getMkey(), i18nMessageDTO );
//        }
//    }
//    public void setProjectParamsDTOList(List<ProjectParamsDTO> projectParamsDTOList) {
//        this.projectParamsDTOList = projectParamsDTOList;
//    }

//    @OneToOne(mappedBy = "projectDTO" , fetch = FetchType.LAZY, cascade = CascadeType.MERGE , orphanRemoval = true)
//
//    private ProjectDesignDTO projectDesignDTO;
//
//    public ProjectDesignDTO getProjectDesignDTO() {
//        if (projectDesignDTO== null){
//            projectDesignDTO= new ProjectDesignDTO();
//            projectDesignDTO.setProjectDTO(this);
//        }
//        return projectDesignDTO;
//    }
//
//    public void setProjectDesignDTO(ProjectDesignDTO projectDesignDTO) {
//        this.projectDesignDTO = projectDesignDTO;
//    }

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH )
//    @JoinColumn(name="projid", insertable = false, updatable = false)

//    private  List<ArticleTypeDTO> articleTypeDTOs;
//
//    public List<ArticleTypeDTO> getArticleTypeDTOs() {
//        return articleTypeDTOs;
//    }
//
//    public void setArticleTypeDTOs(List<ArticleTypeDTO> articleTypeDTOs) {
//        this.articleTypeDTOs = articleTypeDTOs;
//    }
//
//
//
//    public ArticleTypeDTO getArticleTypeById(Integer id){
//        for (ArticleTypeDTO articleTypeDTO:getArticleTypeDTOs()){
//            if (Objects.equals(id, articleTypeDTO.id)) return articleTypeDTO;
//        }
//        return null;
//    }



    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", status=" + status +
                ", startdate=" + startdate +
                ", type=" + type +
                '}';
    }
}
