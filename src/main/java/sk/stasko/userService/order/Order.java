package sk.stasko.userService.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
