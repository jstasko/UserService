package sk.stasko.userService.order;

import org.dozer.DozerBeanMapper;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sk.stasko.userService.user.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDaoImplTest {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderDao orderDao;

    @Test
    void save() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSSZ");
        DateTime from = formatter.parseDateTime("2020-01-12 09:00:00.000Z");

        orderDao.save(
                Order.builder().fromDate(from).build(),
                User.builder().build()
        );
    }
}
