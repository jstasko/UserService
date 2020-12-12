package sk.stasko.userService.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDto, String> {
    UserDto findByFirstName(String firstName);
    UserDto findByEmail(String email);
    UserDto findByUsername(String email);
}
