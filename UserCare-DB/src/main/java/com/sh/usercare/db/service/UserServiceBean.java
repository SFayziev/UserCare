package com.sh.usercare.db.service;

import com.sh.usercare.db.map.user.OauthidDTO;
import com.sh.usercare.db.map.user.UserDTO;
import com.sh.usercare.db.map.user.UserPermissionsDTO;
import com.sh.usercare.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Shuhrat Faiziev on 16.08.2016.
 */
@Service
@Transactional
@CacheConfig(cacheNames = "userDTO")
public class UserServiceBean extends GenericService  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Value("${default.user.topic.module.id}")
    private  String usertopicModId;


    private ShaPasswordEncoder passwordEncoder= new ShaPasswordEncoder();


    @Override
    public UserDTO createLogin(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encodePassword(userDTO.getPassword(), null ) );
        userDTO=  userRepository.save (userDTO);
        return userDTO;
    }

    @Override
    public UserDTO saveProfile(UserDTO userDTO) {
        userDTO =  userRepository.save(userDTO);
        return userDTO;
    }

    @Override
    @Cacheable
    public UserDTO getUser(String username, String alias) {
        return  (UserDTO)getEntityManager().createQuery("from UserDTO as ud where projid in (select id  from ProjectDTO where alias=:alias) and  username=:username ")
                .setParameter("username", username)
                .setParameter("alias", alias)
                .getSingleResult();
    }

    @Override
    public UserDTO getUserByEmail(long projid, String email) {
        return (UserDTO) getEntityManager().createQuery("from UserDTO as us where us.projid=:projid and  us.email=:email")
                .setParameter("email", email).setParameter("projid", projid) .getSingleResult();
    }



    @Override
    public OauthidDTO updateOAuthToken(String oAuthToken, UserDTO currentUser) {
        OauthidDTO oauthidDTO= (OauthidDTO) getEntityManager()
                .createQuery("from OauthidDTO auth where auth.userDTO.id=:id ").setParameter("id", currentUser.getId())
                .getSingleResult();

        oauthidDTO.setAccess_token(oAuthToken);
        getEntityManager().merge(oauthidDTO);
        return  oauthidDTO;
    }

    @Override
    public OauthidDTO findByProviderAndAccessToken(String providerName, String socialId) {
        return (OauthidDTO) getEntityManager().createQuery("from OauthidDTO oa where oa.provider=:provider and oa.access_token=:socialId ")
                .setParameter("provider", providerName ).setParameter("socialId", socialId).getSingleResult();
    }

    @Override
    public UserDTO getProjectUserByUsername(long projId, String username) {
        return (UserDTO) getEntityManager().createQuery("from UserDTO ud where ud.projid=:projid and  ud.username=:username")
                .setParameter("username", username).setParameter("projid", projId).getSingleResult();
    }


    @Override
    public UserDTO getProjectUserByid(long projid, long userid) {
        return (UserDTO) getEntityManager().createQuery("from UserDTO ud where ud.projid=:projid and  ud.id=:userid")
                .setParameter("userid", userid).setParameter("projid", projid).getSingleResult();
    }

    @Override
    public List<UserDTO> getProjectStaff(long projid, int limit) {
        Query query= getEntityManager().createQuery("from UserDTO ud where ud.projid=:projid and ud.status=1 and (userGrDTO.id=1 or ud.userGrDTO.id=2 )")
                 .setParameter("projid", projid) ;
        if (limit>0) query.setMaxResults(limit);

        return query.getResultList();
    }

    @Override
    public List<UserDTO> getUsersList(long projid, int type, int status, String username, String email, int start, int limit, String order) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserDTO> criteria = builder.createQuery( UserDTO.class );
        Root<UserDTO> root = criteria.from( UserDTO.class );
        criteria.select( root );
        List<Predicate>  criteriaList = new ArrayList();

        criteriaList.add( builder.equal( root.get( "projid" ), projid ));
        criteriaList.add( builder.equal( root.get( "status" ), (status != null &&  status == 0)? status: 1 ));
        if (type != null && type > -1) {
            criteriaList.add( builder.equal( root.get( "usertype" ), type) );
        }

        if (username!= null && !username.isEmpty()) {
            criteriaList.add( builder.like( root.get( "name" ), "%"+username.trim()+"%" ) );
        }

        if (email!= null && !email.isEmpty()) {
            criteriaList.add( builder.like( root.get( "email" ), "%"+email.trim()+"%"  ) );
        }

        if( Objects.equals(order, "bycomment")) { criteria.orderBy( builder.asc(root.get("comments") ));}
        else if(Objects.equals(order, "byraitings")) {criteria.orderBy( builder.asc(root.get("raitings") )); }
        else if(Objects.equals(order, "regdate")) { criteria.orderBy( builder.asc(root.get("regdate") )); }

        criteria.where(builder.and((Predicate[]) criteriaList.toArray(new Predicate[0])));
        Query qurty=getEntityManager().createQuery( criteria );
        if (limit!= null && limit>0) qurty.setMaxResults(limit);
        if (start!= null) qurty.setFirstResult(start);
        return  qurty.getResultList();

    }


    @Override
    public void deleteUserPermissions(UserPermissionsDTO userPermissionsDTO) {
        getEntityManager().remove(userPermissionsDTO);
    }

    @Override

    public void saveUserPermissions(UserPermissionsDTO userPermissionsDTO) {
        getEntityManager().merge(userPermissionsDTO);
    }

    @Override
    public UserPermissionsDTO getUserPermission(long projid, long userid) {
        return (UserPermissionsDTO) getEntityManager().createQuery("select ud.userPermissionsDTO from UserDTO ud where ud.id=:id and  ud.projid=:projid")
                .setParameter("id", userid).setParameter("projid", projid).getSingleResult();
    }
}
