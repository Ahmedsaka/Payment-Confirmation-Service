package com.interswitchgroup.crudwithsp;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentConfirmationRepository {

    List< PaymentConfirmation> getAllPayments();

    PaymentConfirmation getPaymentById(long transaction_id);

    PaymentConfirmation getPaymentByCustomerId(String customer_id);

//    public List<PaymentConfirmation>
    List<PaymentConfirmation> getPaymentByProductId(String product_id);

    List<PaymentConfirmation> getPaymentByAmount(double amount);
}
