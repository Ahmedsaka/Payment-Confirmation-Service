package com.interswitchgroup.crudwithsp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@Builder
public class PaymentConfirmation {
    @JsonProperty("transaction_id")
    private long transaction_id;
    @JsonProperty("customer_id")
    private String customer_id;
    @JsonProperty("product_id")
    private String product_id;
    @JsonProperty("transaction_type")
    private String transaction_type;
    @JsonProperty("amount")
    private Double amount;

    public PaymentConfirmation() {
    }

    public PaymentConfirmation(long transaction_id, String customer_id, String product_id, String transaction_type, Double amount) {
        this.transaction_id = transaction_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.transaction_type = transaction_type;
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentConfirmation)) return false;
        PaymentConfirmation that = (PaymentConfirmation) o;
        return transaction_id == that.transaction_id &&
                customer_id.equals(that.customer_id) &&
                product_id.equals(that.product_id) &&
                transaction_type.equals(that.transaction_type) &&
                amount.equals(that.amount);
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction_id, customer_id, product_id, transaction_type, amount);
    }
}
