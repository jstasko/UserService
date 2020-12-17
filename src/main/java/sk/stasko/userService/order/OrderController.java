package sk.stasko.userService.order;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stasko.userService.user.User;
import sk.stasko.userService.user.UserService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:3000/")
@Api( tags = "Order")
public class OrderController {

    private final OrderService service;
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }


    @PostMapping("/save")
    @ResponseBody
    private Order saveOrder(@RequestBody Order order) {
        logger.trace("Finding user for order");
        User user = userService.findUserByUsername(order.getUsername());
        if (user == null) {
            logger.trace("User does not exist");
            return null;
        }
        logger.trace("Creating order for user");
        return this.service.save(order, user);
    }
}
