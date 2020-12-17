package sk.stasko.userService.user;

public interface UserDao {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User save(User user);
}
