package com.github.marschall.pgday2016;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

public class JdbcOperationsTest extends AbstractPosgresTest {

  @Autowired
  private JdbcOperations jdbcOperations;


  @Test
  public void query() throws SQLException {
    Class<LocalDate> elementType = LocalDate.class;
    Object[] bindParameters = new Object[]{LocalTime.of(12, 5)};
    List<LocalDate> dates = this.jdbcOperations.queryForList("SELECT date_column FROM demo_table WHERE time_column < ?",
            elementType, bindParameters);

    System.out.println(dates);
  }

}
