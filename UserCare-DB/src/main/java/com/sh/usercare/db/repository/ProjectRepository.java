package com.sh.usercare.db.repository;

import com.sh.usercare.db.map.project.ProjectDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 16.08.2016.
 */
@Repository
public interface ProjectRepository extends CrudRepository<ProjectDTO, Long> {
}
