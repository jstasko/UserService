package sk.stasko.userService.type;

import java.util.List;

public interface TypeDao {
    Type save(Type type);
    List<Type> findAll();
}
