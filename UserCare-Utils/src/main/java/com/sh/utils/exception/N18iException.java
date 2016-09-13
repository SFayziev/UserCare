package com.sh.utils.exception;

/**
 * Created by Lenovo on 16.02.2016.
 */
public class N18iException extends Exception {

    private  Integer projectId;
    private  Integer forumId;
    private  N18IErrorCodes n18IErrorCodes;

    public N18iException(Integer projectId, Integer forumId, N18IErrorCodes n18IErrorCodes) {
        super(n18IErrorCodes.getDefaultValue());
        this.forumId = forumId;
        this.forumId = forumId;
        this.n18IErrorCodes = n18IErrorCodes;

    }

    public N18iException( N18IErrorCodes n18IErrorCodes) {
        super(n18IErrorCodes.getDefaultValue());
        this.n18IErrorCodes = n18IErrorCodes;

    }

    public N18iException(Integer projectId,  N18IErrorCodes n18IErrorCodes) {

        super( n18IErrorCodes.getDefaultValue());
        this.projectId = projectId;
        this.n18IErrorCodes = n18IErrorCodes;
    }


    public Integer getProjectId() {
        return projectId;
    }

    public Integer getForumId() {
        return forumId;
    }

    public N18IErrorCodes getN18IErrorCodes() {
        return n18IErrorCodes;
    }
}
