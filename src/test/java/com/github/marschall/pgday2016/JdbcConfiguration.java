package com.github.marschall.pgday2016;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Import(PostgresConfiguration.class)
public class JdbcConfiguration {

  @Autowired
  private DataSource dataSource;

  @Bean
  public PlatformTransactionManager txManager() {
    return new DataSourceTransactionManager(this.dataSource);
  }

  @Bean
  public JdbcOperations jdbcOperations() {
    return new JdbcTemplate(this.dataSource);
  }

}
