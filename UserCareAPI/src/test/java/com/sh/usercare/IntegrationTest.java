package com.sh.usercare;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shuhrat Faiziev on 17.08.2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser(username = "admin", authorities = { "ROLE_MANAGER", "ROLE_MANAGEUSERS" })
@Transactional
abstract public class IntegrationTest {
    protected Logger logger= Logger.getLogger(this.getClass());

    /**
     * Default records to testing
     */
    public static Long defaultProjectId = 2L;
    public static Long defaultForumId = 2L;
    public static String defaultUserName = "admin";
    public static String defaultAlias = "feedback";



}
