package com.sh.usercare.db.service;

import com.sh.usercare.db.IntegrationTest;
import com.sh.usercare.db.map.user.UserDTO;
import com.sh.usercare.db.map.user.UserPermissionsDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Shuhrat Faiziev on 16.08.2016.
 */


public class UserServiceIntegrationTest extends IntegrationTest{

    @Autowired
    UserService userService;

    @Test
    public void createLogin() throws Exception {
        UserDTO userDTO= new UserDTO("test@usercare.com");


        userDTO.setProjid(defaultProjectId);

        userService.createLogin(userDTO);
    }

    @Test
    public void saveProfile() throws Exception {
        UserDTO userDTO= userService.getProjectUserByUsername(defaultProjectId, defaultUserName);
        Date localDate= new Date();
        userDTO.setLastlogin(localDate);
        UserDTO userDTO1 = userService.saveProfile(userDTO);
        assertEquals( localDate, userDTO1.getLastlogin() );
    }

    @Test
    public void getUser() throws Exception {
        UserDTO userDTO= userService.getUser(defaultUserName, defaultAlias );
        System.out.println(userDTO );
        System.out.println(userDTO.getId() );
        System.out.println(userDTO.getName() );
        System.out.println(userDTO.getEmail() );
        System.out.println(userDTO.getArticles() );
        System.out.println(userDTO.getComments() );
//        System.out.println(userDTO.getImgDTO());
//        System.out.println(userDTO.getLargImgDTO() );
        System.out.println(userDTO.getOpenid() );
        System.out.println(userDTO.getPassword() );
        System.out.println(userDTO.getPosition() );
        System.out.println(userDTO.getProjid() );
        System.out.println(userDTO.getRaitings() );
        System.out.println(userDTO.getRegdate() );
        System.out.println(userDTO.getRegdateAgo() );
//        System.out.println(userDTO.getUserGrDTO() );
        System.out.println(userDTO.getUsername() );
//        System.out.println(userDTO.getUserPermissionsDTO() );
        System.out.println(userDTO.getUsertype() );

        assertNotNull(userDTO);
        assertEquals(userDTO.getProjid(), defaultProjectId);
    }

    @Test
    public void getUserByEmail() throws Exception {
        UserDTO userDTO= userService.getUser(defaultUserName, defaultAlias );
        UserDTO userDTO2 = userService.getUserByEmail(defaultProjectId, userDTO.getEmail());
        assertNotNull(userDTO2);
    }

    @Test
    public void getUserPermission() throws Exception {
        UserDTO userDTO= userService.getUser(defaultUserName, defaultAlias );
        UserPermissionsDTO userPermissionsDTO= userService.getUserPermission(defaultProjectId , userDTO.getId() );
        assertNotNull(userPermissionsDTO);
    }

    @Test
    @Ignore
    public void updateOAuthToken() throws Exception {
        assertFalse(true);
    }

    @Test
    @Ignore
    public void findByProviderAndAccessToken() throws Exception {
        assertFalse(true);
    }

    @Test
    public void getProjectUserByUsername() throws Exception {
        logger.debug("Start Project service method: getProjectUserByUsername ");
        assertNotNull(userService.getProjectUserByUsername( defaultProjectId , defaultUserName ));
    }

    @Test
    public void getProjectUserById() throws Exception {
        UserDTO userDTO= userService.getUser(defaultUserName, defaultAlias );

        UserDTO userDTO2= userService.getProjectUserByid(defaultProjectId , userDTO.getId() );
        assertNotNull(userDTO2);
    }

//    @Test
//    public void getCurrentUserAuthority() throws Exception {
//       userService.i
//    }

    @Test
    public void getProjectStaff() throws Exception {
        assertNotNull(userService.getProjectStaff(defaultProjectId, 5));
        assertNotNull(userService.getProjectStaff(defaultProjectId, 0));
    }

    @Test
    public void getUsersList() throws Exception {
        List<UserDTO> userDTOList=  userService.getUsersList(defaultProjectId, 1,1, defaultUserName , "@", 1,  2, "regdate");
        assertNotNull(userDTOList);
    }

    @Test
    public void deleteUserPermissions() throws Exception {
        UserDTO userDTO= userService.getUser(defaultUserName, defaultAlias );
        UserPermissionsDTO userPermissionsDTO= userService.getUserPermission(defaultProjectId , userDTO.getId() );
        userService.deleteUserPermissions(userPermissionsDTO);

        UserPermissionsDTO userPermissionsDTO2= userService.getUserPermission(defaultProjectId , userDTO.getId() );

        assertNull(userPermissionsDTO2);
    }

    @Test
    public void saveUserPermissions() throws Exception {
        UserDTO userDTO= userService.getUser(defaultUserName, defaultAlias );
        UserPermissionsDTO userPermissionsDTO= userService.getUserPermission(defaultProjectId , userDTO.getId() );
        int status=userPermissionsDTO.getStatus()==0?1:0;
        userPermissionsDTO.setStatus(status);
        userService.saveUserPermissions(userPermissionsDTO);
        UserPermissionsDTO userPermissionsDTO2= userService.getUserPermission(defaultProjectId , userDTO.getId() );
        assertTrue(userPermissionsDTO2.getStatus()==status);
    }


}