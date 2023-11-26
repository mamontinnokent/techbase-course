package ru.demo.webfluxdemo.util;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ValidityParser {

  Clock clock;
  Pattern validityPattern =
      Pattern.compile("^(\\d[Y|y])?(\\d[M|m])?(\\d[D|d])?(\\d[H|h])?(\\d[M|m])?$");
  Pattern numberPattern = Pattern.compile("^(\\d)\\w$");

  public LocalDateTime getFrom(String validity) {
    return Optional.of(validityPattern.matcher(validity))
        .filter(Matcher::find)
        .map(
            matcher -> {
              int years;
              int months;
              int days;
              int hours;
              int minutes;

              return LocalDateTime.now(clock);
            })
        .orElseThrow();
  }
}
