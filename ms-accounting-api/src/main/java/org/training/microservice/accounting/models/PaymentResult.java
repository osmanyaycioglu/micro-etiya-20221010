package org.training.microservice.accounting.models;

public class PaymentResult {
    private Long customerId;
    private int result;
    private String desc;

    public Long getCustomerId() {
        return customerId;
    }

    public PaymentResult setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public int getResult() {
        return result;
    }

    public PaymentResult setResult(int result) {
        this.result = result;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public PaymentResult setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
