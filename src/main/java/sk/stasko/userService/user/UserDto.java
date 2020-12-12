package sk.stasko.userService.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stasko.userService.core.BaseDocumentDto;

@Getter
@Setter
@Document(collection= "Users")
public class UserDto extends BaseDocumentDto {
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
}
