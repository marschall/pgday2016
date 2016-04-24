package com.github.marschall.pgday2016;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name = "demo_table")
public class DemoTable {

  @Column(name = "date_column")
  private LocalDate dateColumn;

  @Column(name = "time_column")
  private LocalTime timeColumn;

  @Column(name = "timestamp_column")
  private LocalDateTime timestampColumn;

  public LocalDate getDateColumn() {
    return dateColumn;
  }

  public void setDateColumn(LocalDate dateColumn) {
    this.dateColumn = dateColumn;
  }

  public LocalTime getTimeColumn() {
    return timeColumn;
  }

  public void setTimeColumn(LocalTime timeColumn) {
    this.timeColumn = timeColumn;
  }

  public LocalDateTime getTimestampColumn() {
    return timestampColumn;
  }

  public void setTimestampColumn(LocalDateTime timestampColumn) {
    this.timestampColumn = timestampColumn;
  }

}
