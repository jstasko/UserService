package sk.stasko.userService.type;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypeDaoImpl implements TypeDao{

    private final TypeRepository repository;
    private final DozerBeanMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(TypeDaoImpl.class);

    @Autowired
    public TypeDaoImpl(TypeRepository repository, DozerBeanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Type save(Type type) {
        logger.info("order is being saved");
        TypeDto typeDto = this.mapper.map(type, TypeDto.class);
        TypeDto newTypeDto = this.repository.save(typeDto);
        if (newTypeDto.getId() != null) {
            logger.info("user was saved");
            return  this.mapper.map(newTypeDto, Type.class);
        }
        logger.trace("Order have not been saved properly, missing id");
        return null;
    }

    @Override
    public List<Type> findAll() {
        return this.repository
                .findAll()
                .stream()
                .map(i -> this.mapper.map(i, Type.class))
                .collect(Collectors.toList());
    }
}
