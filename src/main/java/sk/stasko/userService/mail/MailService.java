package sk.stasko.userService.mail;

import javax.mail.MessagingException;

public interface MailService {
    Mail sendMail(Mail mail) throws MessagingException;
}
