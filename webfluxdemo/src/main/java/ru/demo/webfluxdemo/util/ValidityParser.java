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
      Pattern.compile("^(\\d+[Y|y])?(\\d+[M|m])?(\\d+[D|d])?(\\d+[H|h])?(\\d+[M|m])?$");
  Pattern valuePattern = Pattern.compile("^(\\d+)(\\w)$");

  public LocalDateTime getFrom(String validity) {
    return Optional.of(validityPattern.matcher(validity))
        .filter(Matcher::find)
        .map(
            matcher -> {
              var years = getValueFromGroup(1, matcher);
              var months = getValueFromGroup(2, matcher);
              var days = getValueFromGroup(3, matcher);
              var hours = getValueFromGroup(4, matcher);
              var minutes = getValueFromGroup(5, matcher);

              LocalDateTime validityDate =
                  LocalDateTime.now(clock)
                      .plusYears(years)
                      .plusMonths(months)
                      .plusDays(days)
                      .plusHours(hours)
                      .plusMinutes(minutes);
              return validityDate.equals(LocalDateTime.now(clock)) ? null : validityDate;
            })
        .orElseThrow();
  }

  private int getValueFromGroup(int nbrOfGroup, Matcher matcher) {
    String stringValue = matcher.group(nbrOfGroup);
    if (stringValue == null) {
      return 0;
    }

    return Optional.of(valuePattern.matcher(stringValue))
        .filter(Matcher::find)
        .map(valueMatcher -> valueMatcher.group(1))
        .map(Integer::parseInt)
        .orElseThrow();
  }
}
