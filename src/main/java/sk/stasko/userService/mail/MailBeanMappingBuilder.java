package sk.stasko.userService.mail;


import org.dozer.loader.api.BeanMappingBuilder;
import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class MailBeanMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(Mail.class, MailDto.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("edit", "edit")
                .fields("message", "message")
                .fields("fullName", "fullName")
                .fields("subject", "subject")
                .fields("phone", "phone")
                .fields("emailFrom", "emailFrom");

        mapping(MailDto.class, Mail.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("edit", "edit")
                .fields("message", "message")
                .fields("fullName", "fullName")
                .fields("subject", "subject")
                .fields("phone", "phone")
                .fields("emailFrom", "emailFrom");
    }
}
