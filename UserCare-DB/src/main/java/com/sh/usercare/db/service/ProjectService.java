package com.sh.usercare.db.service;

import com.sh.usercare.db.map.project.ProjectDTO;
import org.springframework.security.access.annotation.Secured;

import java.util.Collection;

/**
 * Created by Admin on 16.08.2016.
 */
public interface ProjectService  {
    @Secured("ROLE_MANAGER")
    Collection<ProjectDTO> findAll();

    ProjectDTO findOne(long id);

    ProjectDTO create(ProjectDTO greeting);

    ProjectDTO update(ProjectDTO greeting);

    void delete(long id);

    ProjectDTO findByNames(String name);

    ProjectDTO findByAlias(String s);
}