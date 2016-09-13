package com.sh.usercare.db.repository;

import com.sh.usercare.db.map.user.UserDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Shuhrat Faiziev on 16.08.2016.
 */
@Repository
@CacheConfig(cacheNames = "userDTO")
public interface UserRepository  extends CrudRepository<UserDTO, Long> {

}
