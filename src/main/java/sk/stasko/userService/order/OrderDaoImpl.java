package sk.stasko.userService.order;

import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.stasko.userService.user.User;

@Component
@Slf4j
public class OrderDaoImpl implements OrderDao{

    private final OrderRepository orderRepository;
    private final DozerBeanMapper mapper;

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
        log.info("order is being saved");
        //System.out.println(order.getFromDate().toString());
        //System.out.println("_____");
        OrderDto orderDto = this.mapper.map(order, OrderDto.class);
        orderDto.setUsernameId(user.getId());
        OrderDto newOrderDto = this.orderRepository.save(orderDto);
        if (newOrderDto.getId() != null) {
            log.info("user was saved");
            Order newOrder =  this.mapper.map(newOrderDto, Order.class);
            newOrder.setUsername(user.getUsername());
            return newOrder;
        }
        log.trace("Order have not been saved properly, missing id");
        return null;
    }
}
