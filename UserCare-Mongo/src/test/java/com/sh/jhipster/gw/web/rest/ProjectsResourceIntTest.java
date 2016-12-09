package com.sh.jhipster.gw.web.rest;

import com.sh.jhipster.gw.JhipsterMongoDbApp;

import com.sh.jhipster.gw.domain.Projects;
import com.sh.jhipster.gw.repository.ProjectsRepository;
import com.sh.jhipster.gw.service.ProjectsService;

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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ProjectsResource REST controller.
 *
 * @see ProjectsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterMongoDbApp.class)
@ActiveProfiles("dev")
public class ProjectsResourceIntTest {


    private static final Integer DEFAULT_STATUS = 1;
    private static final Integer UPDATED_STATUS = 2;

    @Inject
    private ProjectsRepository projectsRepository;

    @Inject
    private ProjectsService projectsService;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc restProjectsMockMvc;

    private Projects projects;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ProjectsResource projectsResource = new ProjectsResource();
        ReflectionTestUtils.setField(projectsResource, "projectsService", projectsService);
        this.restProjectsMockMvc = MockMvcBuilders.standaloneSetup(projectsResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Projects createEntity() {
        Projects projects = new Projects()
                .status(DEFAULT_STATUS);
        return projects;
    }

    @Before
    public void initTest() {
        projectsRepository.deleteAll();
        projects = createEntity();
    }

    @Test
    public void createProjects() throws Exception {
        int databaseSizeBeforeCreate = projectsRepository.findAll().size();

        // Create the Projects

        restProjectsMockMvc.perform(post("/api/projects")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(projects)))
                .andExpect(status().isCreated());

        // Validate the Projects in the database
        List<Projects> projects = projectsRepository.findAll();
        assertThat(projects).hasSize(databaseSizeBeforeCreate + 1);
        Projects testProjects = projects.get(projects.size() - 1);
        assertThat(testProjects.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    public void getAllProjects() throws Exception {
        // Initialize the database
        projectsRepository.save(projects);

        // Get all the projects
        restProjectsMockMvc.perform(get("/api/projects?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(projects.getId())))
                .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)));
    }

    @Test
    public void getProjects() throws Exception {
        // Initialize the database
        projectsRepository.save(projects);

        // Get the projects
        restProjectsMockMvc.perform(get("/api/projects/{id}", projects.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(projects.getId()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS));
    }

    @Test
    public void getNonExistingProjects() throws Exception {
        // Get the projects
        restProjectsMockMvc.perform(get("/api/projects/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateProjects() throws Exception {
        // Initialize the database
        projectsService.save(projects);

        int databaseSizeBeforeUpdate = projectsRepository.findAll().size();

        // Update the projects
        Projects updatedProjects = projectsRepository.findOne(projects.getId());
        updatedProjects
                .status(UPDATED_STATUS);

        restProjectsMockMvc.perform(put("/api/projects")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(updatedProjects)))
                .andExpect(status().isOk());

        // Validate the Projects in the database
        List<Projects> projects = projectsRepository.findAll();
        assertThat(projects).hasSize(databaseSizeBeforeUpdate);
        Projects testProjects = projects.get(projects.size() - 1);
        assertThat(testProjects.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    public void deleteProjects() throws Exception {
        // Initialize the database
        projectsService.save(projects);

        int databaseSizeBeforeDelete = projectsRepository.findAll().size();

        // Get the projects
        restProjectsMockMvc.perform(delete("/api/projects/{id}", projects.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Projects> projects = projectsRepository.findAll();
        assertThat(projects).hasSize(databaseSizeBeforeDelete - 1);
    }
}
