package jbhembise.testauto.mutation;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static java.time.temporal.ChronoUnit.YEARS;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    String firstName;
    String lastName;
    LocalDate birthDate;

    public boolean isMajor() {
        return YEARS.between(birthDate, LocalDate.now()) >= 18;
    }
}
