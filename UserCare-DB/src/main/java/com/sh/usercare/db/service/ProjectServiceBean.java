package com.sh.usercare.db.service;

import com.sh.usercare.db.map.project.ProjectDTO;
import com.sh.usercare.db.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Admin on 09.08.2016.
 */
@Service
@Transactional
@CacheConfig(cacheNames = "projectDTO")
@RepositoryRestResource
public  class ProjectServiceBean extends GenericService  implements ProjectService  {

    @Autowired
    ProjectRepository projectRepository;


    @Cacheable
    public List<ProjectDTO> findAll(){
        return (List<ProjectDTO>) projectRepository.findAll();
    }

    @Override
    @Cacheable
    public ProjectDTO findOne(Long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public ProjectDTO create(ProjectDTO greeting) {
        return null;
    }

    @Override
    public ProjectDTO update(ProjectDTO greeting) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @Cacheable
    public  ProjectDTO findByNames(String name){
        return (ProjectDTO) getEntityManager().createQuery("from ProjectDTO as pj where pj.name=:name and pj.status=1").setParameter("name", name)
                .getSingleResult();
    }

    @Override
    @Cacheable
    public ProjectDTO findByAlias(String alias) {
        return (ProjectDTO) getEntityManager().createQuery("from ProjectDTO as pj where pj.alias=:alias and pj.status=1").setParameter("alias", alias)
                .getSingleResult();
    }


}
