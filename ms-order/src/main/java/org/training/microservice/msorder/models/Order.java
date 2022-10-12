package org.training.microservice.msorder.models;

import org.training.microservice.msorder.validation.StartCheck;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;


public class Order {
    private Long          orderId;
    private String        customerName;
    private String        customerNumber;
    private String        order;
    private Integer       minutes;
    private LocalDateTime receiveDate;
    private EOrderStatus  orderStatus = EOrderStatus.ACTIVE;
    private List<Meal>    mealList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", order='" + order + '\'' +
                ", minutes=" + minutes +
                ", receiveDate=" + receiveDate +
                ", orderStatus=" + orderStatus +
                ", mealList=" + mealList +
                '}';
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }
}
