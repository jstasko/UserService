package sk.stasko.userService.order;

import org.dozer.loader.api.BeanMappingBuilder;

import static org.dozer.loader.api.TypeMappingOptions.oneWay;

public class OrderBeanMappingBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(Order.class, OrderDto.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("edit", "edit")
                .fields("description", "description")
                .fields("type", "type")
                .fields("fromDate", "fromDate");
        mapping(OrderDto.class, Order.class, oneWay())
                .fields("id", "id")
                .fields("create", "create")
                .fields("edit", "edit")
                .fields("description", "description")
                .fields("type", "type")
                .fields("fromDate", "fromDate");
    }
}
