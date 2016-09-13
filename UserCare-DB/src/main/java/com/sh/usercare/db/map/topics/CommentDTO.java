package com.sh.usercare.db.map.topics;

import com.sh.usercare.db.map.IntEntity;
import com.sh.usercare.db.map.user.UserDTO;
import com.sh.utils.TimeAgo;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Admin on 31.08.2015.
 */
@Entity
@Table(name = "comment",  catalog = "usercare")

public class CommentDTO extends IntEntity {

    private String  text;
//    private Integer status;
    private Integer type=1;
    private Date  createdate = new Date();
    private Date lastchange= new Date();
    private Integer votes=0 ;
    private  Integer level;
    private  Integer voteup=0;
    private  Integer votedown=0;
    private  Boolean answer=false;

    public Boolean getAnswer() {
        return answer==null? false:answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getVotes() {
        return votes== null?0:votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getVoteup() {
        return voteup==null?0:voteup;
    }

    public void setVoteup(Integer voteup) {
        this.voteup = voteup;
    }

    public Integer getVotedown() {
        return votedown==null?0:votedown;
    }

    public void setVotedown(Integer votedown) {
        this.votedown = votedown;
    }

    //    private String title="";
    private Integer parentid;
    @Transient
    private TimeAgo timeAgo;

    public TimeAgo getTimeAgo() {
        if (timeAgo== null){  timeAgo= new TimeAgo(createdate);}
        return timeAgo;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {this.createdate = createdate;
    }

    public Date getLastchange() {
        return lastchange;
    }

    public void setLastchange(Date lastchange) {
        this.lastchange = lastchange;
    }



    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE   )
    @JoinColumn(name = "status")
    @NotFound(action = NotFoundAction.IGNORE)
    private ArticleStatusDTO statusDTO;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE )
    @JoinColumn(name = "articid")
    @NotFound(action = NotFoundAction.IGNORE)
    private ArticleDTO articleDTO;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE )
    @JoinColumn(name = "userid")
    @NotFound(action = NotFoundAction.IGNORE)
    private UserDTO userDTO;


    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ArticleStatusDTO getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(ArticleStatusDTO statusDTO) {
        this.statusDTO = statusDTO;
    }

    public ArticleDTO getArticleDTO() {
        return articleDTO;
    }

    public void setArticleDTO(ArticleDTO articleDTO) {
        this.articleDTO = articleDTO;
    }

    public Integer votesDown(Integer value){
        votes=getVotes()+1;
        votedown=getVotedown()+value;
        return votes;
    }
    public Integer votesPlus(Integer value){
        votes=this.getVotes()+1;
        voteup=getVoteup()+value;
        return votes;
    }

    public Integer voteUndo(Integer value){
        this.votes=getVotes()-2;
        return  value>0?votesPlus(-value):votesDown(-value);
    }

    public Integer getVoteSum(){
        return getVoteup()+getVotedown();
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "text='" + text + '\'' +
                ", type=" + type +
                ", createdate=" + createdate +
                ", lastchange=" + lastchange +
                '}';
    }


}
