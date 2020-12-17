package sk.stasko.userService.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User findUserByUsername(String username);
    User signUp(User user);
}
