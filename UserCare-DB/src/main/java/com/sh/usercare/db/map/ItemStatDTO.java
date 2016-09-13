package com.sh.usercare.db.map;

import com.sh.usercare.db.map.topics.ArticleStatusDTO;

import javax.persistence.*;

/**
 * Created by shuhrat on 10.10.2015.
 */
@Entity
@Table(name = "article",  catalog = "usercare")
public class ItemStatDTO  extends  IntEntity{

    private Integer status;
    private Integer type;
    private Long  count;
    private Integer logicalgroup;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    @JoinColumn(name = "status" , insertable = false, updatable = false)
    private ArticleStatusDTO articleStatusDTO;

    public ArticleStatusDTO getArticleStatusDTO() {
        return articleStatusDTO;
    }

    public void setArticleStatusDTO(ArticleStatusDTO articleStatusDTO) {
        this.articleStatusDTO = articleStatusDTO;
    }

    public Integer getLogicalgroup() {
        return logicalgroup;
    }

    public void setLogicalgroup(Integer logicalgroup) {
        this.logicalgroup = logicalgroup;
    }

    public ItemStatDTO() {

    }

    public ItemStatDTO(Integer status, Integer type, Long count) {
        this.status = status;
        this.type = type;
        this.count = count;
    }

    @Override
    public String toString() {
        return "ItemStatDTO{" +
                "status=" + status +
                ", type=" + type +
                ", count=" + count +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
