package com.sh.usercare.db.map.file;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by shuhrat on 27.09.2015.
 */

@Entity
@Table(name = "file",  catalog = "usercare")

public class FileDTO extends IntEntity {

    private Integer server;
    private String  path;
    private Integer  type;
    private Integer  status;
    private String   originalFilename;
    private Long  size;
    private String  filekey;
    private Integer  contype;


    public FileDTO(Long size, String originalFilename, String path, Integer type, Integer status) {
        this.size = size;
        this.originalFilename = originalFilename;
        this.path = path;
        this.type = type;
        this.status = status;
    }

    public FileDTO() {
    }

    public Integer getServer() {
        return server;
    }

    public void setServer(Integer server) {
        this.server = server;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFilekey() {
        return filekey;
    }

    public void setFilekey(String filekey) {
        this.filekey = filekey;
    }

    public Integer getContype() {
        return contype;
    }

    public void setContype(Integer contype) {
        this.contype = contype;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "server=" + server +
                ", path='" + path + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", originalFilename='" + originalFilename + '\'' +
                ", size=" + size +
                ", filekey='" + filekey + '\'' +
                ", contype=" + contype +
                '}';
    }
}
