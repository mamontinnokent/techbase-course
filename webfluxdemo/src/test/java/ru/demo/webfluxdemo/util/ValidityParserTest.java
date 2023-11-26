package ru.demo.webfluxdemo.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class ValidityParserTest {
  Pattern numberPattern = Pattern.compile("^(\\d)(\\w)$");

  @Test
  void getFrom() {
    String example = "2d";

    Matcher matcher = numberPattern.matcher(example);
    matcher.find();
    String group = matcher.group(1);
    System.out.println(group);
  }
}
