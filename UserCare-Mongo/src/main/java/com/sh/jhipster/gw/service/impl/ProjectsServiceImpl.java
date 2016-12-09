package com.sh.jhipster.gw.service.impl;

import com.sh.jhipster.gw.service.ProjectsService;
import com.sh.jhipster.gw.domain.Projects;
import com.sh.jhipster.gw.repository.ProjectsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Service Implementation for managing Projects.
 */
@Service
public class ProjectsServiceImpl implements ProjectsService{

    private final Logger log = LoggerFactory.getLogger(ProjectsServiceImpl.class);
    
    @Inject
    private ProjectsRepository projectsRepository;

    /**
     * Save a projects.
     *
     * @param projects the entity to save
     * @return the persisted entity
     */
    public Projects save(Projects projects) {
        log.debug("Request to save Projects : {}", projects);
        Projects result = projectsRepository.save(projects);
        return result;
    }

    /**
     *  Get all the projects.
     *  
     *  @return the list of entities
     */
    public List<Projects> findAll() {
        log.debug("Request to get all Projects");
        List<Projects> result = projectsRepository.findAll();

        return result;
    }

    /**
     *  Get one projects by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Projects findOne(String id) {
        log.debug("Request to get Projects : {}", id);
        Projects projects = projectsRepository.findOne(id);
        return projects;
    }

    /**
     *  Delete the  projects by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Projects : {}", id);
        projectsRepository.delete(id);
    }
}
