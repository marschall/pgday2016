package com.github.marschall.pgday2016;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Shows how to use Java 8 Date Time types with plain JDBC.
 */
public class JdbcTest extends AbstractJdbcTest {

  @Autowired
  private DataSource dataSource;


  @Test
  public void query() throws SQLException {
    try (Connection connection = this.dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(
             "SELECT date_column FROM demo_table WHERE time_column < ?")) {

      statement.setObject(1, LocalTime.of(12, 5));
      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          LocalDate date = resultSet.getObject(1, LocalDate.class);
          System.out.println(date);
        }
      }
    }
  }

}
