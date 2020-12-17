package sk.stasko.userService.type;

import java.util.List;

public interface TypeService {
    Type save(Type type);
    List<Type> findAll();
}
