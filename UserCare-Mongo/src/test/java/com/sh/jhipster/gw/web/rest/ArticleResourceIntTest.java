package com.sh.jhipster.gw.web.rest;

import com.sh.jhipster.gw.JhipsterMongoDbApp;

import com.sh.jhipster.gw.domain.Article;
import com.sh.jhipster.gw.repository.ArticleRepository;
import com.sh.jhipster.gw.service.ArticleService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.hasItem;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ArticleResource REST controller.
 *
 * @see ArticleResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterMongoDbApp.class)
@ActiveProfiles("dev")
public class ArticleResourceIntTest {


    private static final Integer DEFAULT_PROJID = 2;
    private static final Integer UPDATED_PROJID = 1;
    private static final String DEFAULT_TEXT = "AAAAA";
    private static final String UPDATED_TEXT = "BBBBB";

    private static final Integer DEFAULT_STATUS = 1;
    private static final Integer UPDATED_STATUS = 2;

    private static final Integer DEFAULT_TYPE = 1;
    private static final Integer UPDATED_TYPE = 2;

    private static final LocalDate DEFAULT_CREATEDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATEDATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LASTCHANGE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LASTCHANGE = LocalDate.now(ZoneId.systemDefault());
    private static final String DEFAULT_TITLE = "AAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBB";

    private static final Integer DEFAULT_USERID = 1;
    private static final Integer UPDATED_USERID = 2;

    private static final Integer DEFAULT_UPDATEDUSERID = 1;
    private static final Integer UPDATED_UPDATEDUSERID = 2;

    private static final Integer DEFAULT_ASSIGNEDUSERID = 1;
    private static final Integer UPDATED_ASSIGNEDUSERID = 2;

    private static final Boolean DEFAULT_DELETED = false;
    private static final Boolean UPDATED_DELETED = true;

    private static final Integer DEFAULT_FORUMID = 1;
    private static final Integer UPDATED_FORUMID = 2;

    private static final Integer DEFAULT_CATID = 1;
    private static final Integer UPDATED_CATID = 2;

    private static final Boolean DEFAULT_DISABLED = false;
    private static final Boolean UPDATED_DISABLED = true;

    private static final Integer DEFAULT_ANSWERCOMMENTID = 1;
    private static final Integer UPDATED_ANSWERCOMMENTID = 2;

    private static final Boolean DEFAULT_NEEDREVIEW = false;
    private static final Boolean UPDATED_NEEDREVIEW = true;

    private static final Integer DEFAULT_LOGICALGROUP = 1;
    private static final Integer UPDATED_LOGICALGROUP = 2;

    @Inject
    private ArticleRepository articleRepository;

    @Inject
    private ArticleService articleService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restArticleMockMvc;

    private Article article;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ArticleResource articleResource = new ArticleResource();
        ReflectionTestUtils.setField(articleResource, "articleService", articleService);
        this.restArticleMockMvc = MockMvcBuilders.standaloneSetup(articleResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Article createEntity() {
        Article article = new Article()
                .projid(DEFAULT_PROJID)
                .text(DEFAULT_TEXT)
                .status(DEFAULT_STATUS)
                .type(DEFAULT_TYPE)
                .createdate(DEFAULT_CREATEDATE)
                .lastchange(DEFAULT_LASTCHANGE)
                .title(DEFAULT_TITLE)
                .forumid(DEFAULT_FORUMID)
                .catid(DEFAULT_CATID);
        return article;
    }

    @Before
    public void initTest() {
        articleRepository.deleteAll();
        article = createEntity();
    }

    @Test
    public void createArticle() throws Exception {
        int databaseSizeBeforeCreate = articleRepository.findAll().size();

        // Create the Article

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isCreated());

        // Validate the Article in the database
        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeCreate + 1);
        Article testArticle = articles.get(articles.size() - 1);
        assertThat(testArticle.getProjid()).isEqualTo(DEFAULT_PROJID);
        assertThat(testArticle.getText()).isEqualTo(DEFAULT_TEXT);
        assertThat(testArticle.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testArticle.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testArticle.getCreatedate()).isEqualTo(DEFAULT_CREATEDATE);
        assertThat(testArticle.getLastchange()).isEqualTo(DEFAULT_LASTCHANGE);
        assertThat(testArticle.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testArticle.getForumid()).isEqualTo(DEFAULT_FORUMID);
        assertThat(testArticle.getCatid()).isEqualTo(DEFAULT_CATID);
    }

    @Test
    public void checkProjidIsRequired() throws Exception {
        int databaseSizeBeforeTest = articleRepository.findAll().size();
        // set the field null
        article.setProjid(null);

        // Create the Article, which fails.

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isBadRequest());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkTextIsRequired() throws Exception {
        int databaseSizeBeforeTest = articleRepository.findAll().size();
        // set the field null
        article.setText(null);

        // Create the Article, which fails.

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isBadRequest());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = articleRepository.findAll().size();
        // set the field null
        article.setStatus(null);

        // Create the Article, which fails.

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isBadRequest());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = articleRepository.findAll().size();
        // set the field null
        article.setType(null);

        // Create the Article, which fails.

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isBadRequest());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCreatedateIsRequired() throws Exception {
        int databaseSizeBeforeTest = articleRepository.findAll().size();
        // set the field null
        article.setCreatedate(null);

        // Create the Article, which fails.

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isBadRequest());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkTitleIsRequired() throws Exception {
        int databaseSizeBeforeTest = articleRepository.findAll().size();
        // set the field null
        article.setTitle(null);

        // Create the Article, which fails.

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isBadRequest());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkForumidIsRequired() throws Exception {
        int databaseSizeBeforeTest = articleRepository.findAll().size();
        // set the field null
        article.setForumid(null);

        // Create the Article, which fails.

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isBadRequest());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCatidIsRequired() throws Exception {
        int databaseSizeBeforeTest = articleRepository.findAll().size();
        // set the field null
        article.setCatid(null);

        // Create the Article, which fails.

        restArticleMockMvc.perform(post("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(article)))
                .andExpect(status().isBadRequest());

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void getAllArticles() throws Exception {
        // Initialize the database
        articleService.save(article);

        // Get all the articles
        restArticleMockMvc.perform(get("/api/articles?sort=id,desc").header("projid", "2" ) )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*].projid").value(hasItem(DEFAULT_PROJID)))
                .andExpect(jsonPath("$.[*].text").value(hasItem(DEFAULT_TEXT.toString())))
                .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
                .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
                .andExpect(jsonPath("$.[*].createdate").value(hasItem(DEFAULT_CREATEDATE.toString())))
                .andExpect(jsonPath("$.[*].lastchange").value(hasItem(DEFAULT_LASTCHANGE.toString())))
                .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
;
    }

    @Test
    public void getArticle() throws Exception {
        // Initialize the database
        article=articleService.save(article);

        // Get the article
        restArticleMockMvc.perform( get("/api/articles/{number}", article.getNumber()).header("projid", "2" ) )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.number").value(article.getNumber()))
            .andExpect(jsonPath("$.projid").value(DEFAULT_PROJID))
            .andExpect(jsonPath("$.text").value(DEFAULT_TEXT.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.createdate").value(DEFAULT_CREATEDATE.toString()))
            .andExpect(jsonPath("$.lastchange").value(DEFAULT_LASTCHANGE.toString()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
            .andExpect(jsonPath("$.forumid").value(DEFAULT_FORUMID))
            .andExpect(jsonPath("$.catid").value(DEFAULT_CATID));
    }

    @Test
    public void getNonExistingArticle() throws Exception {
        // Get the article
        restArticleMockMvc.perform(get("/api/articles/{number}", Long.MAX_VALUE).header("projid", "2" ) )
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateArticle() throws Exception {
        // Initialize the database
        articleService.save(article);

        int databaseSizeBeforeUpdate = articleRepository.findAll().size();

        // Update the article
        Article updatedArticle = articleService.findOne(article.getProjid(), article.getNumber());
        updatedArticle
                .projid(UPDATED_PROJID)
                .text(UPDATED_TEXT)
                .status(UPDATED_STATUS)
                .type(UPDATED_TYPE)
                .createdate(UPDATED_CREATEDATE)
                .lastchange(UPDATED_LASTCHANGE)
                .title(UPDATED_TITLE)
                .forumid(UPDATED_FORUMID)
                .catid(UPDATED_CATID);

        restArticleMockMvc.perform(put("/api/articles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(updatedArticle)))
                .andExpect(status().isOk());

        // Validate the Article in the database
        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeUpdate);
        Article testArticle = articles.get(articles.size() - 1);
        assertThat(testArticle.getProjid()).isEqualTo(UPDATED_PROJID);
        assertThat(testArticle.getText()).isEqualTo(UPDATED_TEXT);
        assertThat(testArticle.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testArticle.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testArticle.getCreatedate()).isEqualTo(UPDATED_CREATEDATE);
        assertThat(testArticle.getLastchange()).isEqualTo(UPDATED_LASTCHANGE);
        assertThat(testArticle.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testArticle.getForumid()).isEqualTo(UPDATED_FORUMID);
        assertThat(testArticle.getCatid()).isEqualTo(UPDATED_CATID);
    }

    @Test
    public void deleteArticle() throws Exception {
        // Initialize the database
        articleService.save(article);

        int databaseSizeBeforeDelete = articleRepository.findAll().size();

        // Get the article
        restArticleMockMvc.perform(delete("/api/articles/{number}", article.getNumber() ).header("projid", "2" )
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(databaseSizeBeforeDelete - 1);
    }
}
