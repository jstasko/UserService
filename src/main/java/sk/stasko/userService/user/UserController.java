package sk.stasko.userService.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api( tags = "User")
public class UserController  {

    protected UserService service;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping("/email/{email}")
    @ApiOperation(value = "This method is used to get the client email.")
    @ResponseBody
    public User getDoctorByFirstName(@PathVariable String email) {
        logger.info("User with email + " + email + " is being searched");
        return this.service.findByEmail(email);
    }

    @PostMapping("/signUp")
    public @ResponseBody
    User signUp(@RequestBody User user) {
        logger.info("New User is created .. credentials  username " + user.getUsername());
        User newUser = this.service.signUp(user);
        logger.trace("user created with id + " + newUser.getId());
        return newUser;
    }
}
