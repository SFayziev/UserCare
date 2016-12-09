package com.sh.jhipster.gw.service;

import com.sh.jhipster.gw.domain.Projects;

import java.util.List;

/**
 * Service Interface for managing Projects.
 */
public interface ProjectsService {

    /**
     * Save a projects.
     *
     * @param projects the entity to save
     * @return the persisted entity
     */
    Projects save(Projects projects);

    /**
     *  Get all the projects.
     *  
     *  @return the list of entities
     */
    List<Projects> findAll();

    /**
     *  Get the "id" projects.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Projects findOne(String id);

    /**
     *  Delete the "id" projects.
     *
     *  @param id the id of the entity
     */
    void delete(String id);
}
