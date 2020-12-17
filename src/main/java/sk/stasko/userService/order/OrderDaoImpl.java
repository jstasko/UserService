package sk.stasko.userService.order;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.stasko.userService.user.User;

@Component
public class OrderDaoImpl implements OrderDao{

    private final OrderRepository orderRepository;
    private final DozerBeanMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

    @Autowired
    public OrderDaoImpl(OrderRepository orderRepository, DozerBeanMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    @Override
    public void findOrderByType(String type) {

    }

    @Override
    public Order save(Order order, User user) {
        logger.info("order is being saved");
        System.out.println(order.getFromDate().toString());
        System.out.println("_____");
        OrderDto orderDto = this.mapper.map(order, OrderDto.class);
        orderDto.setUsernameId(user.getId());
        OrderDto newOrderDto = this.orderRepository.save(orderDto);
        if (newOrderDto.getId() != null) {
            logger.info("user was saved");
            Order newOrder =  this.mapper.map(newOrderDto, Order.class);
            newOrder.setUsername(user.getUsername());
            return newOrder;
        }
        logger.trace("Order have not been saved properly, missing id");
        return null;
    }
}
