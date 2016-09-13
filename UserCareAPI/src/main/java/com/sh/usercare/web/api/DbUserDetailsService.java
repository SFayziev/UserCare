package com.sh.usercare.web.api;

import com.sh.usercare.db.map.project.ProjectDTO;
import com.sh.usercare.db.map.user.UserDTO;
import com.sh.usercare.db.map.user.UserGrandAuthority;
import com.sh.usercare.db.service.ProjectService;
import com.sh.usercare.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Shuhrat Faiziev on 16.08.2016.
 */
@Service
public class DbUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String[] sl= s.split("/");

        ProjectDTO projectDTO= projectService.findByAlias(sl[0]);
        if ((sl.length<2) || (projectDTO== null)) return  null;

        UserDTO user = userService.getProjectUserByUsername(projectDTO.getId(),  sl[1] );
        if (user != null) {
            Collection<GrantedAuthority> a = new ArrayList<GrantedAuthority>();
            if (user.getUserPermissionsDTO().getManager()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_MANAGER));
            if (user.getUserPermissionsDTO().getManageusers()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_MANGEUSERS));
            if (user.getUserPermissionsDTO().getAssignperformers()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_ASSIGNPERFORMERS));
            if (user.getUserPermissionsDTO().getChatoperator()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_CHATOPERATOR));
            if (user.getUserPermissionsDTO().getDeletefeedback()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_DELETEFEEDBACK));
            if (user.getUserPermissionsDTO().getEditfeedback()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_EDITFEEDBACK));
            if (user.getUserPermissionsDTO().getFeedbacktags()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_FEEDBACKTAG));
            if (user.getUserPermissionsDTO().getManagefeedback()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_MANAGEFEEDBACK));
            if (user.getUserPermissionsDTO().getModeration()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_MODERATION));
            if (user.getUserPermissionsDTO().getPayforproject()) a.add(new SimpleGrantedAuthority(UserGrandAuthority.ROLE_PAYPROJECT));
//            if (user.getUserPermissionsDTO().manageusers) a.add(new SimpleGrantedAuthority("manageusers"));

            boolean enabled = user.getStatus() == 1;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            return new User(s, user.getPassword() , enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, a);
        }
        else {
            return null;
        }

    }
}
