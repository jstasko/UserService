package sk.stasko.userService;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sk.stasko.userService.mail.MailBeanMappingBuilder;
import sk.stasko.userService.type.TypeBeanMappingBuilder;
import sk.stasko.userService.user.UserBeanMappingBuilder;

@SpringBootApplication
@EnableMongoRepositories("sk.stasko.userService")
@EnableMongoAuditing
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public DozerBeanMapper mapper() {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping(new UserBeanMappingBuilder());
		mapper.addMapping(new TypeBeanMappingBuilder());
		mapper.addMapping(new MailBeanMappingBuilder());
		return mapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
