package com.sh.jhipster.gw.domain;

import javax.persistence.Embeddable;

@Embeddable
public  class ArticleRating{

    private Integer votes=0;
    private Integer voteup=0;
    private Integer votedown=0;
    private Integer followers=0;
    private Integer views=0;
    private Integer comments=0;

    public void increaseComments() {
       comments++;
    }

    public void decreaseComments() {
        comments--;
    }



    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getVoteup() {
        return voteup;
    }

    public void setVoteup(Integer voteup) {
        this.voteup = voteup;
    }

    public Integer getVotedown() {
        return votedown;
    }

    public void setVotedown(Integer votedown) {
        this.votedown = votedown;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Rating{" +
            "votes=" + votes +
            ", voteup=" + voteup +
            ", votedown=" + votedown +
            ", followers=" + followers +
            ", views=" + views +
            ", comments=" + comments +
            '}';
    }
}
