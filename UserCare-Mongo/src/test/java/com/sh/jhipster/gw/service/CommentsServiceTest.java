package com.sh.jhipster.gw.service;

import com.sh.jhipster.gw.IntegrationTest;
import com.sh.jhipster.gw.JhipsterMongoDbApp;
import com.sh.jhipster.gw.domain.Article;
import com.sh.jhipster.gw.domain.Comments;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.*;

/**
 * Created by Faiziev Shuhrat on 11/30/16.
 */


public class CommentsServiceTest extends IntegrationTest {

    @Inject
    CommentsService commentsService;

    @Inject
    ArticleService articleService;


    private Article article;
    @Before
    public void doBefor(){
        article= new Article(DEFAULT_PROJID,DEFAULT_FORUMID,0,DEFAULT_TITLE, DEFAULT_COMMENTTEXT ) ;
        article.getRatings().increaseComments();
        article= articleService.save(article);

        System.out.println(articleService.findOne(article.getProjid(), article.getNumber() ));
    }


    @Test
    @Rollback(false)
//    @Transactional
    public void save() throws Exception {
        for (int i =0 ; i<500 ; i++){
            Comments comments= new Comments(DEFAULT_STATUS, DEFAULT_COMMENTTEXT, DEFAULT_AUTHORID, DEFAULT_TITLE , DEFAULT_TYPE);
            comments= commentsService.save(article.getProjid(), article.getNumber() , comments );
            comments.setCommenttext("part 2 ");
            commentsService.save(article.getProjid(), article.getNumber() , comments );
            comments= commentsService.findOne(article.getProjid(), article.getNumber(), comments.getNumber() );
            if (i % 2 ==0)    commentsService.delete(article.getProjid(), article.getNumber(), comments.getNumber() );

            Assert.assertNotNull(comments);
        }

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void findOne() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}
