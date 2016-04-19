package com.github.marschall.pgday2016;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PostgresConfiguration {

  @Bean
  public DataSource dataSource() {
//    PGSimpleDataSource dataSource = new PGSimpleDataSource();
//    dataSource.setDatabaseName(YOUR_DATABASE_NAME)
    return new SingleConnectionDataSource("jdbc:postgresql:test", true);
  }

  @Bean
  public PlatformTransactionManager txManager() {
    return new DataSourceTransactionManager(this.dataSource());
  }


}
