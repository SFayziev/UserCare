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

    UserDTO getUserByEmail(Long projid, String email) ;

    UserPermissionsDTO getUserPermission(Long projid, Long userid );

    OauthidDTO updateOAuthToken(String oAuthToken, UserDTO currentUser);

    OauthidDTO findByProviderAndAccessToken(String providerName , String socialId );

    UserDTO getProjectUserByUsername( Long projId , String  username);

    UserDTO getProjectUserByid( Long projid , Long  userid);

    List<UserDTO> getProjectStaff(Long projId , Integer  limit);

    List<UserDTO> getUsersList(Long projid, Integer type, Integer status, String username , String email , Integer  start, Integer limit, String order ) ;

    void deleteUserPermissions(UserPermissionsDTO userPermissionsDTO) ;

    void saveUserPermissions(UserPermissionsDTO userPermissionsDTO);


}
