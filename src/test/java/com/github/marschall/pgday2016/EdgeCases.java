package com.github.marschall.pgday2016;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

/**
 * Shows issues that can arise when daylight saving changes occur.
 */
@ContextConfiguration(classes = HibernateConfiguration.class)
public class EdgeCases extends AbstractPosgresTest {

  @PersistenceContext
  private EntityManager em;

  /**
   * Shows issues that can arise when converting through native types.
   */
  @Test
  @Sql("classpath:schema.sql")
  @Sql("classpath:data.sql")
  @Sql("classpath:edge-cases.sql")
  public void edgeCases() {
    DemoTable demoTable = em.find(DemoTable.class, BigInteger.valueOf(2L));
    assertNotNull(demoTable);
    assertEquals(LocalDateTime.of(2016, 10, 30, 2, 55, 0), demoTable.getTimestampColumn());

    demoTable = em.find(DemoTable.class, BigInteger.valueOf(3L));
    assertNotNull(demoTable);
    assertEquals(LocalDateTime.of(2016, 3, 27, 2, 55, 0), demoTable.getTimestampColumn());
  }

  @Test
  public void unstorable() {

    ZonedDateTime utc = ZonedDateTime.parse("2016-03-27T02:55:00Z");

    ZonedDateTime zurich = utc.withZoneSameInstant(ZoneId.of("Europe/Zurich"));

    System.out.println(utc);
    System.out.println(zurich);
  }

}
