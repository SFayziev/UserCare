package com.sh.usercare.web.api;

/**
 * Created by Admin on 09.08.2016.
 */

import com.sh.usercare.db.map.project.ProjectDTO;
import com.sh.usercare.db.service.ProjectService;
import com.sh.usercare.db.service.UserService;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.H;

@RestController
@RequestMapping("/api/projects")
@ExposesResourceFor(ProjectDTO.class)
public class ProjectResource {

    @Inject
    ProjectService projectService;

    @Inject
    UserService userService;


    private final EntityLinks entityLinks;

    public ProjectResource(EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Resource<ProjectDTO>> getProjects() {
        return projectService.findAll().stream().map(album -> new Resource<>(album, this.entityLinks.linkToSingleResource(ProjectDTO.class, album.getName()))).collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Resource<ProjectDTO> getProject(@PathVariable("id") String name ) {
        ProjectDTO projectDTO=projectService.findByNames(name);

        return new Resource<>(projectDTO, this.entityLinks.linkToSingleResource(ProjectDTO.class, name));

    }

}