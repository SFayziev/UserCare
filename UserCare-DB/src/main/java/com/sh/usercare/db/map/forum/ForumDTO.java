package com.sh.usercare.db.map.forum;

import com.sh.usercare.db.map.file.ImgDTO;
import com.sh.usercare.db.map.IntEntity;
import com.sh.usercare.db.map.project.ProjectDTO;
import com.sh.utils.ForumType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by shuhrat on 24.09.2015.
 */
@Entity
@Table(name = "forum",  catalog = "usercare")
//@org.hibernate.annotations.Cache(  usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,
//        region="ForumDTO")
public class ForumDTO extends IntEntity implements Serializable {
    private String name;
    private String i18nvalue;
    private ForumType type;
    private Integer status;
    private Integer articles=0;
    private Integer comments=0;
    private Integer votes=0 ;
    private Integer langid;
    private Integer  votetype=0;
    private Integer  votelimit=0;
    private Boolean  satisfactionon=false;
    private Boolean sharingon=false;
    private String meta="";
//    private Integer  firstreplystatus;
    private Integer  defhelpdesk;
    private Integer defkhowlagebase;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "logoimg")
    private ImgDTO imgDTO;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL, mappedBy = "forumDTO")
    private ForumPrivacyDTO privacy;

    public ForumPrivacyDTO getPrivacy() {
        if (privacy== null){
            privacy=new ForumPrivacyDTO();
            privacy.setForumDTO(this);
        }
        return privacy;
    }

    public void setPrivacy(ForumPrivacyDTO privacy) {
        this.privacy = privacy;
    }

    public ImgDTO getImgDTO() {
        return imgDTO;
    }

    public void setImgDTO(ImgDTO imgDTO) {
        this.imgDTO = imgDTO;
    }

    public Integer getVotetype() {
        return votetype;
    }

    public Integer getLangid() {
        return langid;
    }

    public void setLangid(Integer langid) {
        this.langid = langid;
    }

    public void setVotetype(Integer votetype) {
        this.votetype = votetype;
    }

    public Integer getVotelimit() {
        return votelimit;
    }

    public void setVotelimit(Integer votelimit) {
        this.votelimit = votelimit;
    }

    public Boolean getSatisfactionon() {
        return satisfactionon;
    }

    public void setSatisfactionon(Boolean satisfactionon) {
        this.satisfactionon = satisfactionon;
    }

    public Boolean getSharingon() {
        return sharingon;
    }

    public void setSharingon(Boolean sharingon) {
        this.sharingon = sharingon;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

//    public Integer getFirstreplystatus() {
//        return firstreplystatus;
//    }
//
//    public void setFirstreplystatus(Integer firstreplystatus) {
//        this.firstreplystatus = firstreplystatus;
//    }

    public Integer getDefhelpdesk() {
        return defhelpdesk;
    }

    public void setDefhelpdesk(Integer defhelpdesk) {
        this.defhelpdesk = defhelpdesk;
    }

    public Integer getDefkhowlagebase() {
        return defkhowlagebase;
    }

    public void setDefkhowlagebase(Integer defkhowlagebase) {
        this.defkhowlagebase = defkhowlagebase;
    }



    public Integer getComments() {
        return comments== null?0 : comments ;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getArticles() {
        return articles== null?0: articles;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getI18nvalue() {
        return i18nvalue;
    }

    public void setI18nvalue(String i18nvalue) {
        this.i18nvalue = i18nvalue;
    }

    @Enumerated(EnumType.ORDINAL)
    public ForumType getType() {
        return type;
    }

    public void setType(ForumType type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    @OneToMany (fetch = FetchType.EAGER , cascade = CascadeType.DETACH)
//    @JoinTable( name = "forum_type" ,
//            joinColumns = { @JoinColumn(name = "id") },
//            inverseJoinColumns = { @JoinColumn(name = "forumid") })
//    @WhereJoinTable( clause = "forumid='0'")
//    private List<TopicTypeDTO> topicTypeDTOs;
//
//    public List<TopicTypeDTO> getTopicTypeDTOs() {
//        return topicTypeDTOs;
//    }
//
//    public void setTopicTypeDTOs(List<TopicTypeDTO> topicTypeDTOs) {
//        this.topicTypeDTOs = topicTypeDTOs;
//    }

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.DETACH )
    @JoinColumn(name = "projid")
    private ProjectDTO projectDTO;

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    @Override
    public String toString() {
        return "ForumDTO{" +
                "name='" + name + '\'' +
                ", i18nvalue='" + i18nvalue + '\'' +
                ", type=" + type +
                ", status=" + status +

                ", projectDTO=" + projectDTO +
                '}';
    }
}
