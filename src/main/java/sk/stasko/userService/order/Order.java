package sk.stasko.userService.order;

import lombok.*;
import org.joda.time.DateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    private String id;
    private String description;
    private String type;
    private DateTime fromDate;
    private String username;
    private DateTime create;
    private DateTime edit;


    public void setFromDate(String fromDate) {
        this.fromDate = DateTime.parse(fromDate);
    }

    public void setFromDate(DateTime time) {
        this.fromDate = time;
    }
}
