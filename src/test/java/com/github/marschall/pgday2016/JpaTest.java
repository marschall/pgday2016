package com.github.marschall.pgday2016;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = HibernateConfiguration.class)
public class JpaTest extends AbstractPosgresTest {

  @PersistenceContext
  private EntityManager em;

  @Test
  public void find() {
    DemoTable demoTable = em.find(DemoTable.class, BigInteger.ONE);
    assertNotNull(demoTable);
  }

  @Test
  public void query() {
    DemoTable demoTable = (DemoTable) em.createQuery(
            "SELECT d from DemoTable d WHERE d.timeColumn < :time")
            .setParameter("time", LocalTime.of(12, 5))
            .getSingleResult();
    assertNotNull(demoTable);
  }

}
