package com.interswitchgroup.crudwithsp.Dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PaymentConfirmationRepository {

    Map<String, Object> getAllPayments();

    Map<String, Object> getPaymentById(long transaction_id);

//    PaymentConfirmation getPaymentConfirmationByTransactionId(long transaction_id);

    Map<String, Object> getPaymentByCustomerId(String customer_id);

    Map<String, Object> getPaymentByProductId(String product_id);

    Map<String, Object> getPaymentByAmount(double amount);
}
