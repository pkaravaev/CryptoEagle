package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.repository.AbstractUserTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;


@ActiveProfiles(profiles = {"Jpa","PostgreSQL" })
public class UserJpaTest extends AbstractUserTest {


}