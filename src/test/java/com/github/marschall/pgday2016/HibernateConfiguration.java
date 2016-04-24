package com.github.marschall.pgday2016;

import static com.github.marschall.pgday2016.Constants.PERSISTENCE_UNIT_NAME;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Import(PostgresConfiguration.class)
public class HibernateConfiguration {

  @Autowired
  private DataSource dataSource;

  @Bean
  public JpaDialect jpaDialect() {
    return new HibernateJpaDialect();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManager() {
    LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    bean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
    bean.setJpaDialect(jpaDialect());
    bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    bean.setDataSource(dataSource);
    return bean;
  }



  @Bean
  public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
    transactionManager.setDataSource(dataSource);
    transactionManager.setJpaDialect(this.jpaDialect());
    return transactionManager;
  }

}
