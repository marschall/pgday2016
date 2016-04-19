package com.github.marschall.pgday2016;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.ZoneOffset.UTC;

import java.time.ZoneId;

public class MoonLanding {

  public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss VV");

    ZonedDateTime landingUtc = ZonedDateTime.of(1969, 7, 20, 20, 18, 4, 0, UTC);

    System.out.println(landingUtc.format(formatter));
    for (String zoneId : new String[]{"Europe/Zurich", "Europe/Moscow", "America/New_York", "Australia/Sydney"}) {
      System.out.println(landingUtc.withZoneSameInstant(ZoneId.of(zoneId)).format(formatter));
    }

  }

}
