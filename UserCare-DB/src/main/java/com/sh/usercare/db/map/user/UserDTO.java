package com.sh.usercare.db.map.user;

import com.sh.usercare.db.map.LongEntity;
import com.sh.usercare.db.map.file.ImgDTO;
import com.sh.utils.TimeAgo;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by shuhrat on 29.08.2015.
 */

@Entity(name = "UserDTO")
@Table(name = "user",  catalog = "usercare")
public class UserDTO extends LongEntity {

    private String username;
    @NotNull
    private String  password;
    private Date regdate = new Date();
    private Integer status = 1;
    private Integer  openid;
    private BigDecimal raitings;
    private Date  lastlogin = new Date();
    private Integer  comments;
    private Integer  articles;
    private String name;
    private String position;
    private String token;

    @Transient
    private TimeAgo regdateAgo;

    public TimeAgo getRegdateAgo() {
        if (regdateAgo== null){  regdateAgo= new TimeAgo(regdate);}
        return regdateAgo;
    }

    public UserDTO(String email) {
        this.email = email;
        this.name=email.substring(0, email.indexOf('@'));
        this.username=this.name;
        this.password= UUID.randomUUID().toString();
        this.setArticles(0);
        this.setComments(0);
        this.setPosition(null);

    }

    public UserDTO() {

    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRaitings() {
        return raitings;
    }

    public void setRaitings(BigDecimal raitings) {
        this.raitings = raitings;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getArticles() {
        return articles;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }

    @Email
    @NotNull      (message="user.email.not.null")
    private String  email;
    private Integer usertype= 0;
    @NotNull
    private Long projid;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JoinColumn(name = "larglogoimg")
    private ImgDTO largImgDTO;

    public ImgDTO getLargImgDTO() {
        return largImgDTO;
    }

    public void setLargImgDTO(ImgDTO largImgDTO) {
        this.largImgDTO = largImgDTO;
    }

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JoinColumn(name = "logoimg")
    private ImgDTO imgDTO;

    public ImgDTO getImgDTO() {
        return imgDTO;
    }

    public void setImgDTO(ImgDTO imgDTO) {
        this.imgDTO = imgDTO;
    }

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE,  mappedBy = "userDTO")
//    @JoinColumn(name = "id", foreignKey = "userid",  insertable = false, updatable = false  )
    UserPermissionsDTO userPermissionsDTO;
    public UserPermissionsDTO getUserPermissionsDTO() {

        if(null == userPermissionsDTO){
            userPermissionsDTO= new UserPermissionsDTO();
            userPermissionsDTO.setUserDTO(this);
        }
        return userPermissionsDTO;
    }



    public void setUserPermissionsDTO(UserPermissionsDTO userPermissionsDTO) {

        this.userPermissionsDTO = userPermissionsDTO;
    }

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JoinColumn(name = "gr" )
    private UserGrDTO userGrDTO;



    public UserGrDTO getUserGrDTO() {
        return userGrDTO;
    }

    public void setUserGrDTO(UserGrDTO userGrDTO) {
        this.userGrDTO = userGrDTO;
    }

    public Long getProjid() {
        return projid;
    }

    public void setProjid(Long projid) {
        this.projid = projid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOpenid() {
        return openid;
    }

    public void setOpenid(Integer openid) {
        this.openid = openid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='HIDDEN" +   '\'' +
                ", regdate=" + regdate +
                ", status=" + status +
                ", openid=" + openid +
                ", email='" + email + '\'' +
                ", usertype=" + usertype +
                '}';
    }
}
