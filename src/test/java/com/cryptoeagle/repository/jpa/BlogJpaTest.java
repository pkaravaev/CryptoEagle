package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.repository.AbstractBlogTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles =  {"Jpa","PostgreSQL"})
public class BlogJpaTest extends AbstractBlogTest {

}
