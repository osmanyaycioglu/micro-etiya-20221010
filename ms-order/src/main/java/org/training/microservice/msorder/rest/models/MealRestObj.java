package org.training.microservice.msorder.rest.models;

public class MealRestObj {
    private String mealName;
    private Float count;

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Float getCount() {
        return count;
    }

    public void setCount(Float count) {
        this.count = count;
    }
}
