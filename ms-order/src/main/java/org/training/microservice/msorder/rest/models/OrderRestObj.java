package org.training.microservice.msorder.rest.models;

import io.swagger.v3.oas.annotations.Parameter;
import org.training.microservice.msorder.validation.StartCheck;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrderRestObj {
    @NotEmpty(message = "customerName boş olamaz")
    @Size(min = 10,max = 30)
    private String customerName;
    @NotEmpty(message = "customerNumber boş olamaz")
    @Size(min = 8,max = 12)
    @StartCheck("n:")
    private String customerNumber;
    private String order;
    @Max(24000)
    @Min(1)
    @Positive
    private Integer minutes;
    @Future
    private LocalDateTime receiveDate;
    private List<MealRestObj> mealList;

    public List<MealRestObj> getMealList() {
        return mealList;
    }

    public void setMealList(List<MealRestObj> mealList) {
        this.mealList = mealList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public LocalDateTime getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(LocalDateTime receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Override
    public String toString() {
        return "OrderRestObj{" +
                "customerName='" + customerName + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", order='" + order + '\'' +
                ", minutes=" + minutes +
                ", receiveDate=" + receiveDate +
                '}';
    }
}
