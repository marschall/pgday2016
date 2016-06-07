package com.github.marschall.pgday2016;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EndOfSummerTime {

  public static void main(String[] args) {

    ZonedDateTime start = ZonedDateTime.of(2016, 10, 30, 2, 55, 0, 0, ZoneId.of("Europe/Zurich"));
    System.out.println(start);
    System.out.println(start.plusMinutes(5L));
    System.out.println(start.plusMinutes(10L));
  }

}
