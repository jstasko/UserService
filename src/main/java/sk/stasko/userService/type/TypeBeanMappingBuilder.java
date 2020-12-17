package sk.stasko.userService.type;

import org.dozer.loader.api.BeanMappingBuilder;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class TypeBeanMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(Type.class, TypeDto.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("edit", "edit")
                .fields("name", "name");
        mapping(TypeDto.class, Type.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("edit", "edit")
                .fields("name", "name");
    }
}
