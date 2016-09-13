package com.sh.usercare.db.map.project;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;

/**
 * Created by Admin on 15.09.2015.
 */

@Entity
@Table(name = "project_stats",  catalog = "usercare")

public class ProjectStatsDTO extends IntEntity {
//    `projid` int(11) NOT NULL DEFAULT '0',
    private Integer  unmarked=0;
    private Integer  active=0;
    private Integer  closed=0;
    private Integer  people=0;
    private Integer  comments=0;
    private Integer  votes=0;
    private Integer articles=0;
    private Long projid;

    public ProjectStatsDTO() {
    }
    public ProjectStatsDTO(Long projid) {
        this.projid = projid;
    }

    public Long getProjid() {
        return projid;
    }

    public void setProjid(Long projid) {
        this.projid = projid;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }

//    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL )
//    @JoinColumn(name = "projid")
//    private ProjectDTO projectDTO;

    public Integer getArticles(){
        return unmarked+active+closed;
    }

//    public ProjectDTO getProjectDTO() {
//        return projectDTO;
//    }
//
//    public void setProjectDTO(ProjectDTO projectDTO) {
//        this.projectDTO = projectDTO;
//    }

    public Integer getUnmarked() {
        return unmarked;
    }

    public void setUnmarked(Integer unmarked) {
        this.unmarked = unmarked;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Integer getComments() {
        return comments;
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

    @Override
    public String toString() {
        return "ProjectStatsDTO{" +
                "votes=" + votes +
                ", comments=" + comments +
                ", people=" + people +
                ", closed=" + closed +
                ", active=" + active +
                ", unmarked=" + unmarked +
                '}';
    }
}
