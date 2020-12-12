package sk.stasko.userService.user;

public interface UserDao {
    User findDoctorByEmail(String email);
    User findDoctorByUsername(String username);
    User save(User user);
}
