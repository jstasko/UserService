package sk.stasko.userService.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Type {
    private String id;
    private String name;
    private DateTime create;
    private DateTime edit;
}
