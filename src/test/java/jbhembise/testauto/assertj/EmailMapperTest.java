package jbhembise.testauto.assertj;

import java.util.Collections;

import jbhembise.testauto.mapper.Email;
import jbhembise.testauto.mapper.EmailDto;
import jbhembise.testauto.mapper.EmailMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailMapperTest {

    @Test
    void check_email_is_well_converted_into_email_dto() {
        // Given
        String from = "from@domain";
        String to = "to@domain";
        String subject = "subject";
        String content = "content";
        String fakeFrom = "fake.from@domain";
        String fakeTo = "fake.to@domain";
        String fakeSubject = "fake subject";
        String fakeContent = "fake content";
        Email email = Email.builder()
                .from(from)
                .to(new String[] { to })
                .subject(subject)
                .content(content)
                .build();
        EmailDto expectedDto = EmailDto.builder()
                .from(from)
                .to(Collections.singletonList(to))
                .subject(subject)
                .content(content)
                .build();

        // When
        EmailDto actualDto = EmailMapper.toDto(email);

        // Then
        assertThat(actualDto.getFrom()).isEqualTo(from);
        assertThat(actualDto.getTo().size()).isEqualTo(1);
        assertThat(actualDto.getTo().get(0)).isEqualTo(to);
        assertThat(actualDto.getSubject()).isEqualTo(subject);
        assertThat(actualDto.getContent()).isEqualTo(content);

//        assertThat(actualDto.getFrom()).isEqualTo(fakeFrom);
//        assertThat(actualDto.getTo().size()).isEqualTo(1);
//        assertThat(actualDto.getTo().get(0)).isEqualTo(fakeTo);
//        assertThat(actualDto.getSubject()).isEqualTo(fakeSubject);
//        assertThat(actualDto.getContent()).isEqualTo(fakeContent);

        /*
         * Soft assertions using JUnit5
         *
         * org.opentest4j.MultipleFailuresError: actualDto (4 failures)
         * 	expected: <fake.from@domain> but was: <from@domain>
         * 	expected: <fake.to@domain> but was: <to@domain>
         * 	expected: <fake subject> but was: <subject>
         * 	expected: <fake content> but was: <content>
         */
        assertAll("actualDto assertions",
                () -> assertEquals(from, actualDto.getFrom()),
                () -> assertEquals(to, actualDto.getTo().get(0)),
                () -> assertEquals(subject, actualDto.getSubject()),
                () -> assertEquals(content, actualDto.getContent())
        );

        /*
         * Soft assertions using AssertJ
         *
         * org.assertj.core.api.SoftAssertionError:
         * The following 4 assertions failed:
         * 1) [from] expected:<"f[ake.f]rom@domain"> but was:<"f[]rom@domain">
         * at EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:78) expected:<"f[ake.f]rom@domain"> but was:<"f[]rom@domain">
         * 2) [to] expected:<"[fake.]to@domain"> but was:<"[]to@domain">
         * at EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:79) expected:<"[fake.]to@domain"> but was:<"[]to@domain">
         * 3) [subject] expected:<"[fake ]subject"> but was:<"[]subject">
         * at EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:80) expected:<"[fake ]subject"> but was:<"[]subject">
         * 4) [content] expected:<"[fake ]content"> but was:<"[]content">
         * at EmailMapperTest.check_email_is_well_converted_into_email_dto(EmailMapperTest.java:81) expected:<"[fake ]content"> but was:<"[]content">
         */
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualDto.getFrom()).as("from").isEqualTo(from);
        softly.assertThat(actualDto.getTo().get(0)).as("to").isEqualTo(to);
        softly.assertThat(actualDto.getSubject()).as("subject").isEqualTo(subject);
        softly.assertThat(actualDto.getContent()).as("content").isEqualTo(content);
        softly.assertAll();

        /*
         * Field by field comparison using AssertJ
         *
         * java.lang.AssertionError:
         * Expecting values:
         * <["fake subject", "fake content", "fake.from@domain", ["fake.to@domain"]]>
         * in fields:
         * <["subject", "content", "from", "to"]>
         * but were:
         * <["subject", "content", "from@domain", ["to@domain"]]>
         * in <EmailDto(subject=subject, content=content, from=from@domain, to=[to@domain])>.
         * Comparison was performed on all fields
         */
        assertThat(actualDto).isEqualToComparingFieldByField(EmailDto.builder()
                .from(from)
                .to(Collections.singletonList(to))
                .subject(subject)
                .content(content)
        .build());
    }
}
