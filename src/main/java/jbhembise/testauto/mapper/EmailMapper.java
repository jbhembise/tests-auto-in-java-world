package jbhembise.testauto.mapper;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EmailMapper {

    public static EmailDto toDto(Email email) {
        EmailDto dto = new EmailDto();
        dto.setFrom(email.getFrom());
        dto.setContent(email.getContent());
        dto.setSubject(email.getSubject());
        dto.setTo(Arrays.stream(email.getTo()).collect(Collectors.toList()));
        return dto;
    }
}
