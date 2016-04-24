package com.github.marschall.pgday2016;

import static com.github.marschall.pgday2016.Constants.PERSISTENCE_UNIT_NAME;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class HibernateConfiguration {

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManager(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    bean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
    bean.setJpaDialect(jpaDialect());
    bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    bean.setDataSource(dataSource);
    return bean;
  }

  @Bean
  public JpaDialect jpaDialect() {
    return new HibernateJpaDialect();
  }

}
