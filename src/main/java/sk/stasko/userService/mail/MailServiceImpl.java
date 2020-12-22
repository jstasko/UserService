package sk.stasko.userService.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    private final MailDao mailDao;
    private final JavaMailSender sender;

    @Autowired
    public MailServiceImpl(MailDao mailDao, JavaMailSender sender) {
        this.sender = sender;
        this.mailDao = mailDao;
    }

    @Override
    public Mail sendMail(Mail mail) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("stasko.jozef427@gmail.com");
        helper.setText(mail.getMessage() + " phone " + mail.getPhone());
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getEmailFrom());
        sender.send(message);
        return this.mailDao.save(mail);
    }
}
