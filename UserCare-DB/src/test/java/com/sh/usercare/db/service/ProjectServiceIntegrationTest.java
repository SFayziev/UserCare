package com.sh.usercare.db.service;

import com.sh.usercare.db.IntegrationTest;
import com.sh.usercare.db.map.project.ProjectDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Shuhrat Faiziev on 22.08.2016.
 */
public class ProjectServiceIntegrationTest  extends IntegrationTest {

    @Autowired
    ProjectServiceBean projectServiceBean;

    @Test
    public void findAll() throws Exception {
        List<ProjectDTO> projectDTOList = projectServiceBean.findAll();
        assertNotNull(projectDTOList );
    }

    @Test
    public void findOne() throws Exception {
        ProjectDTO projectDTO= projectServiceBean.findOne(defaultForumId );
        System.out.println( projectDTO );
        System.out.println( projectDTO.getId() );
        System.out.println( projectDTO.getAlias() );
        System.out.println( projectDTO.getDefaultforum() );
        System.out.println( projectDTO.getEmail() );
        System.out.println( projectDTO.getLang() );
        System.out.println( projectDTO.getStartdate() );
        System.out.println( projectDTO.getType() );
        System.out.println( projectDTO.getUrl() );

        assertNotNull( projectServiceBean.findOne(defaultForumId ));
    }

    @Test
    public void create() throws Exception {
        ProjectDTO projectDTO= new ProjectDTO();
        projectDTO.setStatus(1);
        projectDTO.setName(defaultAlias);
        projectDTO.setAlias(defaultAlias);
        projectDTO.setDefaultforum(defaultForumId);
        projectDTO.setEmail(defaultAlias +"@test.com" );
        projectDTO.setLang(0);
        projectDTO.setStartdate(new Date());
        projectDTO.setType(0);
        projectDTO.setUrl("http://www." + defaultAlias + ".usercare.com");
        projectDTO.setId(null);
        projectServiceBean.create(new ProjectDTO());
    }

    @Test
    public void update() throws Exception {
       ProjectDTO projectDTO= projectServiceBean.findOne(defaultForumId );
       Integer status=projectDTO.getStatus()==0 ? 1:0;
       projectDTO.setStatus(status);
       projectServiceBean.update(projectDTO);
        ProjectDTO projectDTO2= projectServiceBean.findOne(defaultForumId );
        assertEquals( status , projectDTO2.getStatus() );
    }

    @Test
    public void delete() throws Exception {
        projectServiceBean.delete(defaultForumId);
    }

    @Test
    public void findByNames() throws Exception {
        ProjectDTO projectDTO= projectServiceBean.findOne(defaultForumId );
        assertNotNull( projectServiceBean.findByNames( projectDTO.getName() ));
    }

    @Test
    public void getbyAlias() throws Exception {
        assertNotNull( projectServiceBean.findByAlias( defaultAlias ));
    }

}