package com.sh.usercare.db.service;

import com.sh.usercare.db.map.user.OauthidDTO;
import com.sh.usercare.db.map.user.UserDTO;
import com.sh.usercare.db.map.user.UserPermissionsDTO;

import java.util.List;

/**
 * Created by Shuhrat Faiziev on 16.08.2016.
 */

public interface UserService {
    /**
     * Autowiring sessionFactory
     //     * @param sessionFactory
     */

    UserDTO createLogin(UserDTO userDTO);

    UserDTO saveProfile(UserDTO userDTO);


    UserDTO getUser(String username , String alias);

    UserDTO getUserByEmail(long projid, String email) ;

    UserPermissionsDTO getUserPermission(long projid, long userid );

    OauthidDTO updateOAuthToken(String oAuthToken, UserDTO currentUser);

    OauthidDTO findByProviderAndAccessToken(String providerName , String socialId );

    UserDTO getProjectUserByUsername( long projId , String  username);

    UserDTO getProjectUserByid( long projid , long  userid);

    List<UserDTO> getProjectStaff(long projId , int  limit);

    List<UserDTO> getUsersList(long projid, int type, int status, String username , String email , int  start, int limit, String order ) ;

    void deleteUserPermissions(UserPermissionsDTO userPermissionsDTO) ;

    void saveUserPermissions(UserPermissionsDTO userPermissionsDTO);


}
