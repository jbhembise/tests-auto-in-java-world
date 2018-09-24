package jbhembise.testauto.mutation;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonTest {

    @Test
    public void should_say_person_is_major_when_she_has_more_than_18_years_old() {
        // Given
        Person person = Person.builder()
                .firstName("Jean-Baptiste")
                .lastName("Hembise")
                .birthDate(LocalDate.of(1982, Month.FEBRUARY, 27))
                .build();

        // When
        boolean isMajor = person.isMajor();

        // Then
        assertTrue(isMajor);
    }

    // Nota bene : I wouldn't have done this test without looking at Pitest report !
    @Test
    public void should_say_person_is_major_when_she_has_just_18_years_old_today() {
        // Given
        Person person = Person.builder()
                .firstName("Jean-Baptiste")
                .lastName("Hembise")
                .birthDate(LocalDate.now().minus(18, ChronoUnit.YEARS))
                .build();

        // When
        boolean isMajor = person.isMajor();

        // Then
        assertTrue(isMajor);
    }

    @Test
    public void should_say_person_is_major_when_she_has_less_than_18_years_old() {
        // Given
        Person person = Person.builder()
                .firstName("Jean-Baptiste")
                .lastName("Hembise")
                .birthDate(LocalDate.now().minus(18, ChronoUnit.YEARS).plusDays(1))
                .build();

        // When
        boolean isMajor = person.isMajor();

        // Then
        assertFalse(isMajor);
    }
}
