package sk.stasko.userService.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stasko.userService.core.BaseDocumentDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection= "order")
public class OrderDto extends BaseDocumentDto {
    private String description;
    private String type;
    private DateTime fromDate;
    private String usernameId;

    public void setFromDate(String fromDate) {
        this.fromDate = DateTime.parse(fromDate);
    }

    public void setFromDate(DateTime time) {
        this.fromDate = time;
    }
}
