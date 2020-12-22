package sk.stasko.userService.mail;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.stasko.userService.user.User;
import sk.stasko.userService.user.UserDto;

@Component
public class MailDaoImpl implements MailDao{
    private final MailRepository mailRepository;
    private final DozerBeanMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(MailDaoImpl.class);

    @Autowired
    public MailDaoImpl(MailRepository mailRepository, DozerBeanMapper mapper) {
        this.mailRepository = mailRepository;
        this.mapper = mapper;
    }

    @Override
    public Mail save(Mail mail) {
        logger.info("mail is being saved");
        MailDto mailDto = this.mapper.map(mail, MailDto.class);
        MailDto newMailDto = this.mailRepository.save(mailDto);
        if (newMailDto.getId() != null) {
            logger.info("user was saved");
            return this.mapper.map(newMailDto, Mail.class);
        }
        logger.trace("Mail have not been saved properly, missing id");
        return null;
    }
}
