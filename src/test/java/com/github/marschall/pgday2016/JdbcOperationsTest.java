package com.github.marschall.pgday2016;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

/**
 * Shows how to use Java 8 Date Time types with Spring {@link JdbcOperations}.
 */
public class JdbcOperationsTest extends AbstractJdbcTest {

  @Autowired
  private JdbcOperations jdbcOperations;

  @Test
  public void query() throws SQLException {
    Class<LocalDate> returnType = LocalDate.class;
    Object[] bindParameters = new Object[]{LocalTime.of(12, 5)};

    List<LocalDate> dates = this.jdbcOperations.queryForList(
            "SELECT date_column FROM demo_table WHERE time_column < ?",
            returnType, bindParameters);

    System.out.println(dates);
  }

}
