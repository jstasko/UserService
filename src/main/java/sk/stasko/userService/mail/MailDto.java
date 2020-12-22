package sk.stasko.userService.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stasko.userService.core.BaseDocumentDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection= "mail")
public class MailDto extends BaseDocumentDto {
    private String fullName;
    private String subject;
    private String emailFrom;
    private String phone;
    private String message;
}
