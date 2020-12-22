package sk.stasko.userService.mail;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/mail")
@CrossOrigin(origins = "http://localhost:3000/")
@Api( tags = "Mail")
public class MailController {

    private final MailService mailService;
    private final Logger logger = LoggerFactory.getLogger(MailController.class);

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    @ResponseBody
    private Mail sendMail(@RequestBody Mail mail) {
        logger.trace("mail is being handle");
        try {
            return this.mailService.sendMail(mail);
        } catch (MessagingException e) {
            logger.trace(e.getMessage());
            return null;
        }
    }
}
