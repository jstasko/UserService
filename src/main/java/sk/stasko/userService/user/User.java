package sk.stasko.userService.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import sk.stasko.userService.security.user.AuthenticationUser;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AuthenticationUser {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private DateTime create;
    private DateTime edit;
}
