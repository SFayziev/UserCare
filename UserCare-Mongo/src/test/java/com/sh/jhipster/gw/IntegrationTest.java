package com.sh.jhipster.gw;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by Faiziev Shuhrat on 11/30/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterMongoDbApp.class)
@ActiveProfiles("dev")
public class IntegrationTest {
     public  static final Integer DEFAULT_PROJID = 2;


    public static final Long DEFAULT_ARTICID = 6l;
    public static final Long UPDATED_ARTICID = 6l;

    public static final Integer DEFAULT_FORUMID = 1;
    public  static final Integer UPDATED_FORUMID = 2;

    public  static final Integer DEFAULT_STATUS = 1;
    public  static final Integer UPDATED_STATUS = 2;

    public  static final LocalDate DEFAULT_CREATEDATE = LocalDate.ofEpochDay(0L);
    public  static final LocalDate UPDATED_CREATEDATE = LocalDate.now(ZoneId.systemDefault());
    public  static final String DEFAULT_COMMENTTEXT = "AAAAA";
    public  static final String UPDATED_COMMENTTEXT = "BBBBB";

    public  static final Integer DEFAULT_AUTHORID = 1;
    public  static final Integer UPDATED_AUTHORID = 2;
    public  static final String DEFAULT_TITLE = "AAAAA";
    public  static final String UPDATED_TITLE = "BBBBB";

    public  static final LocalDate DEFAULT_LASTCHANGE = LocalDate.ofEpochDay(0L);
    public  static final LocalDate UPDATED_LASTCHANGE = LocalDate.now(ZoneId.systemDefault());

    public  static final Integer DEFAULT_TYPE = 1;
    public  static final Integer UPDATED_TYPE = 2;

}
