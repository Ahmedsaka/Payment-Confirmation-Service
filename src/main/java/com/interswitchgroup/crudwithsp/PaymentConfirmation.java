package com.interswitchgroup.crudwithsp;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaymentConfirmation {
    private long tranaction_id;
    private String customer_id;
    private String product_id;
    private String transaction_type;
    private Double amount;

    public void setTranaction_id(long tranaction_id) {
        this.tranaction_id = tranaction_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
