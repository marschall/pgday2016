package com.github.marschall.pgday2016;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * Shows how to use Java 8 Date Time types with JPA.
 */
@ContextConfiguration(classes = HibernateConfiguration.class)
public class JpaTest extends AbstractPosgresTest {

  @PersistenceContext
  private EntityManager em;

  @Test
  public void find() {
    DemoTable demoTable = em.find(DemoTable.class, BigInteger.ONE);
    assertNotNull(demoTable.getDateColumn());
  }

  /**
   * Shows how to use Java 8 Date Time types with JPQL.
   */
  @Test
  public void jpqlQuery() {
    LocalTime time = LocalTime.of(12, 5);

    DemoTable demoTable = (DemoTable) em.createQuery(
            "SELECT d from DemoTable d WHERE d.timeColumn < :time")
            .setParameter("time", time)
            .getSingleResult();
    assertNotNull(demoTable);
    assertNotNull(demoTable.getDateColumn());
  }

  /**
   * Shows how to use Java 8 Date Time types with criteria API.
   */
  @Test
  public void criteriaApi() {
    LocalTime time = LocalTime.of(12, 5);

    CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<DemoTable> query = builder.createQuery(DemoTable.class);
    Root<DemoTable> root = query.from(DemoTable.class);
    CriteriaQuery<DemoTable> beforeTwelfeFive = query.where(
            builder.lessThan(root.get(DemoTable_.timeColumn), time));
    List<DemoTable> resultList = em.createQuery(beforeTwelfeFive).getResultList();
    assertNotNull(resultList);
  }

}
