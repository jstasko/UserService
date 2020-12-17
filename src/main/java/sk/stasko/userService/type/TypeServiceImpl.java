package sk.stasko.userService.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{
    private final Logger logger = LoggerFactory.getLogger(TypeServiceImpl.class);
    private final TypeDao dao;

    public TypeServiceImpl(TypeDao dao) {
        this.dao = dao;
    }

    @Override
    public Type save(Type type) {
        return dao.save(type);
    }

    @Override
    public List<Type> findAll() {
        logger.trace("Find ALl");
        return this.dao.findAll();
    }
}
