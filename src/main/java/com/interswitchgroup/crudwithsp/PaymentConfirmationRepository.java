package com.interswitchgroup.crudwithsp;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PaymentConfirmationRepository {

    List<Map<String, Object>> getAllPayments();

    PaymentConfirmation getPaymentById(long transaction_id);

    List<PaymentConfirmation> getPaymentConfirmationByTransactionId(long transaction_id);

    List<PaymentConfirmation> getPaymentByCustomerId(String customer_id);

    List<PaymentConfirmation> getPaymentByProductId(String product_id);

    List<PaymentConfirmation> getPaymentByAmount(double amount);
}
