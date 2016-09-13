package com.sh.usercare.db.map.forum;

import com.sh.usercare.db.map.IntEntity;
import com.sh.usercare.db.map.topics.ArticleTypeDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 30.11.2015.
 */
@Entity
@Table(name = "topic_type",  catalog = "usercare")
public class TopicTypeDTO extends IntEntity {

    @NotNull
    private  Integer forumid;
    private  Integer pos=255;
    private  Boolean enable=true;
    private  Boolean useraccess=true;
    private  Integer firstreplystatus;

    public Integer getFirstreplystatus() {
        return firstreplystatus;
    }

    public void setFirstreplystatus(Integer firstreplystatus) {
        this.firstreplystatus = firstreplystatus;
    }


    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "articletypeid")
    private ArticleTypeDTO articleTypeDTO;

    public TopicTypeDTO(Integer forumid, String name) {
        this.forumid = forumid;
        this.articleTypeDTO = new ArticleTypeDTO(name);
        this.pos=255;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "topicTypeDTO")
    @OrderBy("pos")
    List<TopicTypeStatusDTO> typeStatusDTOList ;

    public List<TopicTypeStatusDTO> getTypeStatusDTOList() {
        if (typeStatusDTOList == null){typeStatusDTOList= new ArrayList<TopicTypeStatusDTO>();}
        return typeStatusDTOList;
    }

//    public List<ForumStatusDTO> markIsinType(List<ForumStatusDTO> forumStatusesList){
//        for (ForumStatusDTO forumStatusDTO: forumStatusesList ){
//            forumStatusDTO.getArticleStatusDTO().setIsInForumType(false);
//            for(TopicTypeStatusDTO topicTypeStatusDTO:getTypeStatusDTOList()){
//                if (forumStatusDTO.getArticleStatusDTO().getId()==topicTypeStatusDTO.getForumStatusDTO().getArticleStatusDTO().getId() ) forumStatusDTO.getArticleStatusDTO().setIsInForumType(true);
//            }
//        }
//
//        return forumStatusesList;
//    }

    public TopicTypeStatusDTO getTypeStatusbyArticStatusid(Integer articiStatusid){
        for(TopicTypeStatusDTO topicTypeStatusDTO:getTypeStatusDTOList()){
            if (articiStatusid==topicTypeStatusDTO.getArticleStatusDTO().getId() ) return topicTypeStatusDTO;
        }
        return  null;
    }

    public void setTypeStatusDTOList(List<TopicTypeStatusDTO> typeStatusDTOList) {
        this.typeStatusDTOList = typeStatusDTOList;
    }

    public void addTypeStatusDTO(TopicTypeStatusDTO topicTypeStatusDTO){
        topicTypeStatusDTO.setTopicTypeDTO(this);
        Boolean changed=false;
        for(TopicTypeStatusDTO topicTypeStatusDTO1: getTypeStatusDTOList() ){
            if (topicTypeStatusDTO.getArticleStatusDTO()==topicTypeStatusDTO1.getArticleStatusDTO()){
                changed=true;
                topicTypeStatusDTO1.setCustname(topicTypeStatusDTO.getCustname());
            }
        }
        if (!changed){
            getTypeStatusDTOList().add(topicTypeStatusDTO);
        }
    }



    public Boolean getUseraccess() {
        return useraccess;
    }

    public void setUseraccess(Boolean useraccess) {
        this.useraccess = useraccess;
    }

    public TopicTypeDTO() {

    }
    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public ArticleTypeDTO getArticleTypeDTO() {
        if (articleTypeDTO== null) { articleTypeDTO= new ArticleTypeDTO(); }
        return articleTypeDTO;
    }

    public void setArticleTypeDTO(ArticleTypeDTO articleTypeDTO) {
        this.articleTypeDTO = articleTypeDTO;
    }


    @Override
    public String toString() {
        return "TopicTypeDTO{" +
                "forumid=" + forumid +
                ", pos=" + pos +
                ", enable=" + enable +
                ", articleTypeDTO=" + articleTypeDTO +
                "} " + super.toString();
    }
}
