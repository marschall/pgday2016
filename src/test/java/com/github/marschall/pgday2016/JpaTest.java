package com.github.marschall.pgday2016;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = HibernateConfiguration.class)
public class JpaTest extends AbstractPosgresTest {

  @PersistenceContext
  private EntityManager em;

  @Test
  public void select() {
    assertNotNull(em);
  }

}
