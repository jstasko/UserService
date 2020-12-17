package sk.stasko.userService.order;

import sk.stasko.userService.user.User;

public interface OrderDao {
    void findOrderByType(String type);
    Order save(Order order, User user);
}
