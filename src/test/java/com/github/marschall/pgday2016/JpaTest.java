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
    LocalTime time = LocalTime.of(12, 5);

    DemoTable demoTable = (DemoTable) em.createQuery(
            "SELECT d from DemoTable d WHERE d.timeColumn < :time")
            .setParameter("time", time)
            .getSingleResult();
    assertNotNull(demoTable);
  }



  @Test
  public void criteria() {
    LocalTime time = LocalTime.of(12, 5);

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<DemoTable> cq = cb.createQuery(DemoTable.class);
    Root<DemoTable> demoTable = cq.from(DemoTable.class);
    CriteriaQuery<DemoTable> beforeTwelfeFixe = cq.where(
            cb.lessThan(demoTable.get(DemoTable_.timeColumn), time));
    List<DemoTable> resultList = em.createQuery(beforeTwelfeFixe).getResultList();
    assertNotNull(resultList);
  }

}
