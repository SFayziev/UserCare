package com.sh.jhipster.gw.web.rest;

import com.sh.jhipster.gw.JhipsterMongoDbApp;

import com.sh.jhipster.gw.domain.Comments;
import com.sh.jhipster.gw.repository.CommentsRepository;
import com.sh.jhipster.gw.service.CommentsService;

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
 * Test class for the CommentsResource REST controller.
 *
 * @see CommentsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterMongoDbApp.class)
@ActiveProfiles("dev")
public class CommentsResourceIntTest {


    private static final Integer DEFAULT_PROJID = 1;
    private static final Integer UPDATED_PROJID = 2;

    private static final Long DEFAULT_ARTICID = 1l;
    private static final Long UPDATED_ARTICID = 2l;

    private static final Integer DEFAULT_FORUMID = 1;
    private static final Integer UPDATED_FORUMID = 2;

    private static final Integer DEFAULT_STATUS = 1;
    private static final Integer UPDATED_STATUS = 2;

    private static final LocalDate DEFAULT_CREATEDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATEDATE = LocalDate.now(ZoneId.systemDefault());
    private static final String DEFAULT_COMMENTTEXT = "AAAAA";
    private static final String UPDATED_COMMENTTEXT = "BBBBB";

    private static final Integer DEFAULT_AUTHORID = 1;
    private static final Integer UPDATED_AUTHORID = 2;
    private static final String DEFAULT_TITLE = "AAAAA";
    private static final String UPDATED_TITLE = "BBBBB";

    private static final LocalDate DEFAULT_LASTCHANGE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LASTCHANGE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_TYPE = 1;
    private static final Integer UPDATED_TYPE = 2;

    @Inject
    private CommentsRepository commentsRepository;

    @Inject
    private CommentsService commentsService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restCommentsMockMvc;

    private Comments comments;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        CommentsResource commentsResource = new CommentsResource();
        ReflectionTestUtils.setField(commentsResource, "commentsService", commentsService);
        this.restCommentsMockMvc = MockMvcBuilders.standaloneSetup(commentsResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Comments createEntity() {
        Comments comments = new Comments()
                .status(DEFAULT_STATUS)
                .createdate(DEFAULT_CREATEDATE)
                .commenttext(DEFAULT_COMMENTTEXT)
                .authorid(DEFAULT_AUTHORID)
                .title(DEFAULT_TITLE)
                .lastchange(DEFAULT_LASTCHANGE)
                .type(DEFAULT_TYPE);
        return comments;
    }

    @Before
    public void initTest() {
        commentsRepository.deleteAll();
        comments = createEntity();
    }

    @Test
    public void createComments() throws Exception {
        int databaseSizeBeforeCreate = commentsRepository.findAll().size();

        // Create the Comments

        restCommentsMockMvc.perform(post("/api/comments")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(comments)))
                .andExpect(status().isCreated());

        // Validate the Comments in the database
        List<Comments> comments = commentsRepository.findAll();
        assertThat(comments).hasSize(databaseSizeBeforeCreate + 1);
        Comments testComments = comments.get(comments.size() - 1);
        assertThat(testComments.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testComments.getCreatedate()).isEqualTo(DEFAULT_CREATEDATE);
        assertThat(testComments.getCommenttext()).isEqualTo(DEFAULT_COMMENTTEXT);
        assertThat(testComments.getAuthorid()).isEqualTo(DEFAULT_AUTHORID);
        assertThat(testComments.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testComments.getLastchange()).isEqualTo(DEFAULT_LASTCHANGE);
        assertThat(testComments.getType()).isEqualTo(DEFAULT_TYPE);
    }

    @Test
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = commentsRepository.findAll().size();
        // set the field null
        comments.setStatus(null);

        // Create the Comments, which fails.

        restCommentsMockMvc.perform(post("/api/comments")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(comments)))
                .andExpect(status().isBadRequest());

        List<Comments> comments = commentsRepository.findAll();
        assertThat(comments).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCommenttextIsRequired() throws Exception {
        int databaseSizeBeforeTest = commentsRepository.findAll().size();
        // set the field null
        comments.setCommenttext(null);

        // Create the Comments, which fails.

        restCommentsMockMvc.perform(post("/api/comments")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(comments)))
                .andExpect(status().isBadRequest());

        List<Comments> comments = commentsRepository.findAll();
        assertThat(comments).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkTitleIsRequired() throws Exception {
        int databaseSizeBeforeTest = commentsRepository.findAll().size();
        // set the field null
        comments.setTitle(null);

        // Create the Comments, which fails.

        restCommentsMockMvc.perform(post("/api/comments")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(comments)))
                .andExpect(status().isBadRequest());

        List<Comments> comments = commentsRepository.findAll();
        assertThat(comments).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkLastchangeIsRequired() throws Exception {
        int databaseSizeBeforeTest = commentsRepository.findAll().size();
        // set the field null
        comments.setLastchange(null);

        // Create the Comments, which fails.

        restCommentsMockMvc.perform(post("/api/comments")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(comments)))
                .andExpect(status().isBadRequest());

        List<Comments> comments = commentsRepository.findAll();
        assertThat(comments).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void getAllComments() throws Exception {
        // Initialize the database
        commentsService.save(DEFAULT_PROJID, DEFAULT_ARTICID, comments);

        // Get all the comments
        restCommentsMockMvc.perform(get("/api/articles/6/comments?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*].projid").value(hasItem(DEFAULT_PROJID)))
                .andExpect(jsonPath("$.[*].forumid").value(hasItem(DEFAULT_FORUMID)))
                .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
                .andExpect(jsonPath("$.[*].createdate").value(hasItem(DEFAULT_CREATEDATE.toString())))
                .andExpect(jsonPath("$.[*].commenttext").value(hasItem(DEFAULT_COMMENTTEXT)))
                .andExpect(jsonPath("$.[*].authorid").value(hasItem(DEFAULT_AUTHORID)))
                .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
                .andExpect(jsonPath("$.[*].lastchange").value(hasItem(DEFAULT_LASTCHANGE.toString())))
                .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)));
    }

    @Test
    public void getComments() throws Exception {
        // Initialize the database
        commentsRepository.save(comments);

        // Get the comments
        restCommentsMockMvc.perform(get("/api/comments/{id}", comments.getSlug()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.projid").value(DEFAULT_PROJID))
            .andExpect(jsonPath("$.forumid").value(DEFAULT_FORUMID))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.createdate").value(DEFAULT_CREATEDATE.toString()))
            .andExpect(jsonPath("$.commenttext").value(DEFAULT_COMMENTTEXT))
            .andExpect(jsonPath("$.authorid").value(DEFAULT_AUTHORID))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.lastchange").value(DEFAULT_LASTCHANGE.toString()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE));
    }

    @Test
    public void getNonExistingComments() throws Exception {
        // Get the comments
        restCommentsMockMvc.perform(get("/api/comments/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateComments() throws Exception {
        // Initialize the database
        commentsService.save(DEFAULT_PROJID, DEFAULT_ARTICID, comments);

        int databaseSizeBeforeUpdate = commentsRepository.findAll().size();

        // Update the comments
        Comments updatedComments = commentsRepository.findOne(comments.getSlug());
        updatedComments
                .status(UPDATED_STATUS)
                .createdate(UPDATED_CREATEDATE)
                .commenttext(UPDATED_COMMENTTEXT)
                .authorid(UPDATED_AUTHORID)
                .title(UPDATED_TITLE)
                .lastchange(UPDATED_LASTCHANGE)
                .type(UPDATED_TYPE);

        restCommentsMockMvc.perform(put("/api/comments")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(updatedComments)))
                .andExpect(status().isOk());

        // Validate the Comments in the database
        List<Comments> comments = commentsRepository.findAll();
        assertThat(comments).hasSize(databaseSizeBeforeUpdate);
        Comments testComments = comments.get(comments.size() - 1);
        assertThat(testComments.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testComments.getCreatedate()).isEqualTo(UPDATED_CREATEDATE);
        assertThat(testComments.getCommenttext()).isEqualTo(UPDATED_COMMENTTEXT);
        assertThat(testComments.getAuthorid()).isEqualTo(UPDATED_AUTHORID);
        assertThat(testComments.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testComments.getLastchange()).isEqualTo(UPDATED_LASTCHANGE);
        assertThat(testComments.getType()).isEqualTo(UPDATED_TYPE);
    }

    @Test
    public void deleteComments() throws Exception {
        // Initialize the database
        commentsService.save(DEFAULT_PROJID, DEFAULT_ARTICID, comments);

        int databaseSizeBeforeDelete = commentsRepository.findAll().size();

        // Get the comments
        restCommentsMockMvc.perform(delete("/api/comments/{id}", comments.getSlug())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Comments> comments = commentsRepository.findAll();
        assertThat(comments).hasSize(databaseSizeBeforeDelete - 1);
    }
}
