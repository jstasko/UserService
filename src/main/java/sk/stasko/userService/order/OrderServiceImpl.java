package sk.stasko.userService.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sk.stasko.userService.user.User;

@Service
public class OrderServiceImpl implements OrderService{

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderDao repository;

    public OrderServiceImpl(OrderDao repository) {
        this.repository = repository;
    }

    @Override
    public void findOrderByType(String type) {

    }

    @Override
    public Order save(Order order, User user) {
        return this.repository.save(order, user);
    }
}
