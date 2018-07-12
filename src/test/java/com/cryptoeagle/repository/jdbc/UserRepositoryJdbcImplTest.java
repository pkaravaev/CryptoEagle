package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.repository.AbstractUserServiceTest;
import com.cryptoeagle.repository.UserRepository;
import com.cryptoeagle.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.cryptoeagle.UserTestData.*;
import static org.junit.Assert.assertEquals;


@ActiveProfiles(profiles = "Jdbc")
public class UserRepositoryJdbcImplTest extends AbstractUserServiceTest {


}