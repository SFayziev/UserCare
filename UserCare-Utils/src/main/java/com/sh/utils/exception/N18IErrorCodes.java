package com.sh.utils.exception;

/**
 * Created by Admin on 16.02.2016.
 */
public enum N18IErrorCodes implements N18nLoggable {

    DATABASE(0, LoggingLevel.DEVELOPMENT, "db.error", "DB error ", "A database error has occured."),
    DUPLICATE_USER(1, LoggingLevel.DEVELOPMENT, "user.exist", "user exists", "This user already exists."),
    AJAX_YOU_MUST_SIGNIN(201, LoggingLevel.DEVELOPMENT, "ajax.signin", " Sign in", "You should sign in."),
    VOTE_DISABLED(210, LoggingLevel.DEVELOPMENT, "vote.disabled", "Vote", "Voting is disabled."),
    VOTE_POSITIVE(211, LoggingLevel.DEVELOPMENT, "vote.positive.only", "Vote", "Positive vote only."),
    ARTICLE_NOT_FOUND(301, LoggingLevel.DEVELOPMENT, "article.not.found", "Article", "Article not found."),
    FORUM_PRIVATE(403, LoggingLevel.DEVELOPMENT, "forum.is.private", "forum", "Forum is private"),
    FORBIDDEN(403, LoggingLevel.DEVELOPMENT, "permission", "Permission", "Forbidden" )

    ;


    /**
     * Numeric message code -- must be unique.
     */
    private final int code;

    /**
     * What message level the message is associated with.
     */
    private final LoggingLevel level;

    /**
     * Contains the message text.
     */
    private final String message;

    private final String n18nCode;

    private  final  String defaultValue;



    N18IErrorCodes(int theCode, LoggingLevel theLevel, String theN18nCode, String theMessage, String theDefaultValue) {
        this.code = theCode;
        this.level = theLevel;
        this.message = theMessage;
        defaultValue = theDefaultValue;
        this.n18nCode = theN18nCode;
    }


    public int getCode() {
        return code;
    }


    public LoggingLevel getLevel() {
        return level;
    }


    public String getMessage() {
        return message;
    }


    public String getN18nCode() {
        return n18nCode;
    }


    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
        public String toString() {
            return code + ": " + message;
        }
    
    
}
