package org.training.microservice.msorder.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.training.microservice.msorder.models.Meal;
import org.training.microservice.msorder.models.Order;
import org.training.microservice.msorder.rest.models.MealRestObj;
import org.training.microservice.msorder.rest.models.OrderRestObj;

import java.util.List;

@Mapper
public interface IOrderMappings {

    IOrderMappings MAPPER = Mappers.getMapper(IOrderMappings.class);

    Order toOrder(OrderRestObj orderRestObj);

    OrderRestObj toOrderRestObject(Order orderRestObj);

    List<Order> toOrderList(List<OrderRestObj> orderRestObjs);

    List<OrderRestObj> toOrderRestObjList(List<Order> orders);

    @Mapping(source = "count",target = "amount")
    Meal toMeal(MealRestObj mealRestObj);

    @Mappings({@Mapping(source = "amount",target = "count")})
    MealRestObj toMealRestObj(Meal meal);

    List<Meal> toMealList(List<MealRestObj> mealList);

    List<MealRestObj> toMealRestList(List<Meal> mealList);

}
