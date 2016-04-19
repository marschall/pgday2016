package com.github.marschall.pgday2016;

import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.transaction.annotation.Transactional;

@Sql("classpath:schema.sql")
@Sql("classpath:data.sql")
@Transactional
@ContextConfiguration(classes = PostgresConfiguration.class)
public abstract class AbstractPosgresTest {

  @ClassRule
  public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

  @Rule
  public final SpringMethodRule springMethodRule = new SpringMethodRule();

}
