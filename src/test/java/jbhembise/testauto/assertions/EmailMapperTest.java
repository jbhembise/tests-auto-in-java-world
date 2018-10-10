package jbhembise.testauto.assertions;

import java.util.Arrays;
import java.util.Collections;
import com.google.common.truth.Truth;

import jbhembise.testauto.mapper.Email;
import jbhembise.testauto.mapper.EmailDto;
import jbhembise.testauto.mapper.EmailMapper;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmailMapperTest {

    private static final String FROM = "from@domain";
    private static final String TO = "to@domain";
    private static final String SUBJECT = "subject";
    private static final String CONTENT = "content ...";

    private static final Email EMAIL = Email.builder()
            .from(FROM)
            .to(new String[] { TO })
            .subject(SUBJECT)
            .content(CONTENT)
            .build();
    /*
     * Assertions list using JUnit5
     *
     * expected: <fake.FROM@domain> but was: <FROM@domain>
     *  org.opentest4j.AssertionFailedError: expected: <fake.FROM@domain> but was: <FROM@domain>
     *  at jbhembise.testauto.assertj.EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:49)
     *  at java.lang.Thread.run(Thread.java:748)
     */
    @Test
    void check_email_conversion_works_using_junit_assertions() {
        // Given  // When
        EmailDto actualDto = EmailMapper.toDto(EMAIL);

        // Then
        assertNotNull(actualDto);
        assertEquals(FROM, actualDto.getFrom());
        assertNotNull(actualDto.getTo());
        assertEquals(1, actualDto.getTo().size());
        assertEquals(TO, actualDto.getTo().get(0));
        assertEquals(SUBJECT, actualDto.getSubject());
        assertEquals(CONTENT, actualDto.getContent());
    }

    /*
     * Assertions list using AssertJ
     * expected:<"f[ake.f]rom@domain"> but was:<"f[]rom@domain">
     * Expected :"fake.FROM@domain"
     * Actual   :"FROM@domain"
     */
    @Test
    void check_email_conversion_works_using_assertj_assertions() {
        // Given  // When
        EmailDto actualDto = EmailMapper.toDto(EMAIL);

        // Then
        assertThat(actualDto).isNotNull();
        assertThat(actualDto.getFrom()).isEqualTo(FROM);
        assertThat(actualDto.getTo()).containsOnly(TO);
        assertThat(actualDto.getSubject()).isEqualTo(SUBJECT);
        assertThat(actualDto.getContent()).isEqualTo(CONTENT);
    }

    /*
     * Assertions list using Google Truth
     * expected: fake.FROM@domain
     * but was : FROM@domain
     */
    @Test
    void check_email_conversion_works_using_google_truth_assertions() {
        // Given  // When
        EmailDto actualDto = EmailMapper.toDto(EMAIL);

        // Then
        Truth.assertThat(actualDto).isNotNull();
        Truth.assertThat(actualDto.getFrom()).isEqualTo(FROM);
        Truth.assertThat(actualDto.getTo()).containsExactly(TO);
        Truth.assertThat(actualDto.getSubject()).isEqualTo(SUBJECT);
        Truth.assertThat(actualDto.getContent()).isEqualTo(CONTENT);
    }

    /*
     * Assertions list using Hamcrest
     * Expected: is "fake.FROM@domain"
     * but: was "FROM@domain"
     * Expected :fake.FROM@domain
     * Actual   :FROM@domain
     */
    @Test
    void check_email_conversion_works_using_hamcrest_assertions() {
        // Given  // When
        EmailDto actualDto = EmailMapper.toDto(EMAIL);

        // Then
        MatcherAssert.assertThat(actualDto, notNullValue());
        MatcherAssert.assertThat(actualDto.getFrom(), is(FROM));
        MatcherAssert.assertThat(actualDto.getTo(), hasSize(1));
        MatcherAssert.assertThat(actualDto.getTo(), contains(TO));
        MatcherAssert.assertThat(actualDto.getSubject(), is(SUBJECT));
        MatcherAssert.assertThat(actualDto.getContent(), is(CONTENT));
    }

    /*
     * Soft assertions using JUnit5
     *
     * org.opentest4j.MultipleFailuresError: actualDto assertions (4 failures)
     * expected: <fake.FROM@domain> but was: <FROM@domain>
     * Multiple Failures (1 failure)
     * expected: <fake.TO@domain> but was: <TO@domain>
     * expected: <fake SUBJECT> but was: <SUBJECT>
     * expected: <fake CONTENT> but was: <CONTENT>
     */
    @Test
    void check_email_conversion_works_using_junit_grouped_assertions() {
        // Given  // When
        EmailDto actualDto = EmailMapper.toDto(EMAIL);

        // Then
        assertNotNull(actualDto);
        assertAll("actualDto assertions",
                () -> assertEquals(FROM, actualDto.getFrom()),
                () -> {
                    assertNotNull(actualDto.getTo());
                    assertAll(
                            () -> assertEquals(1, actualDto.getTo().size()),
                            () -> assertEquals(TO, actualDto.getTo().get(0))
                    );
                },
                () -> assertEquals(SUBJECT, actualDto.getSubject()),
                () -> assertEquals(CONTENT, actualDto.getContent())
        );
    }

    /*
     * Soft assertions using AssertJ
     *
     * org.assertj.core.api.SoftAssertionError:
     * The following 4 assertions failed:
     * 1) [FROM] expected:<"f[ake.f]rom@domain"> but was:<"f[]rom@domain">
     * at EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:78) expected:<"f[ake.f]rom@domain"> but was:<"f[]rom@domain">
     * 2) [TO] expected:<"[fake.]TO@domain"> but was:<"[]TO@domain">
     * at EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:79) expected:<"[fake.]TO@domain"> but was:<"[]TO@domain">
     * 3) [SUBJECT] expected:<"[fake ]SUBJECT"> but was:<"[]SUBJECT">
     * at EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:80) expected:<"[fake ]SUBJECT"> but was:<"[]SUBJECT">
     * 4) [CONTENT] expected:<"[fake ]CONTENT"> but was:<"[]CONTENT">
     * at EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:81) expected:<"[fake ]CONTENT"> but was:<"[]CONTENT">
     */
    @Test
    void check_email_conversion_works_using_assertj_soft_assertions() {
        // Given  // When
        EmailDto actualDto = EmailMapper.toDto(EMAIL);

        // Then
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualDto.getFrom()).as("from").isEqualTo(FROM);
        softly.assertThat(actualDto.getTo()).as("to").containsExactly(TO);
        softly.assertThat(actualDto.getSubject()).as("subject").isEqualTo(SUBJECT);
        softly.assertThat(actualDto.getContent()).as("content").isEqualTo(CONTENT);
        softly.assertAll();
    }

    /*
     * Field by field comparison using AssertJ
     *
     * java.lang.AssertionError:
     * Expecting values:
     * <["fake SUBJECT", "fake CONTENT", "fake.FROM@domain", ["fake.TO@domain"]]>
     * in fields:
     * <["SUBJECT", "CONTENT", "FROM", "TO"]>
     * but were:
     * <["SUBJECT", "CONTENT", "FROM@domain", ["TO@domain"]]>
     * in <EmailDto(SUBJECT=SUBJECT, CONTENT=CONTENT, FROM=FROM@domain, TO=[TO@domain])>.
     * Comparison was performed on all fields
     */
    @Test
    void check_email_conversion_works_using_assertj_single_assertion() {
        // Given  // When
        EmailDto actualDto = EmailMapper.toDto(EMAIL);

        // Then
        assertThat(actualDto).isEqualToComparingFieldByField(
                EmailDto.builder()
                        .from(FROM)
                        .to(Collections.singletonList(TO))
                        .subject(SUBJECT)
                        .content(CONTENT)
                        .build());
    }

    @Test
    void test_string_using_from_assertj() {
        Assertions.assertThat("abc")
                .isNotNull()
                .hasSize(3)
                .startsWith("a")
                .contains("a", "b", "c")
                .endsWith("c")
                .isEqualToIgnoringCase("ABC");
    }

    @Test
    void test_string_using_using_google_truth() {
        String actualString = "abc";
        Truth.assertThat(actualString).isNotNull();
        Truth.assertThat(actualString).hasLength(3);
        Truth.assertThat(actualString).startsWith("a");
        Truth.assertThat(actualString).contains("a");
        Truth.assertThat(actualString).contains("b");
        Truth.assertThat(actualString).contains("c");
        Truth.assertThat(actualString).endsWith("c");
        Truth.assertThat(actualString).ignoringCase().isEqualTo("ABC");
    }

    @Test
    void test_string_using_hamcrest() {
        MatcherAssert.assertThat("abc", CoreMatchers.allOf(
                not(nullValue()),
                startsWith("a"),
                stringContainsInOrder(Arrays.asList("a", "b", "c")),
                endsWith("c"),
                equalToIgnoringCase("ABC")
        ));
    }
}
