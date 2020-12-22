package sk.stasko.userService.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    private String id;
    private String fullName;
    private String subject;
    private String emailFrom;
    private String phone;
    private String message;
    private DateTime create;
    private DateTime edit;

    public Mail(String fullName, String subject, String emailFrom, String phone, String message) {
        this.fullName = fullName;
        this.subject = subject;
        this.emailFrom = emailFrom;
        this.phone = phone;
        this.message = message;
    }
}
