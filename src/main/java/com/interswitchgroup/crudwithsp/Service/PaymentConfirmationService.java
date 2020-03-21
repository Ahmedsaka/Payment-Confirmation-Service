package com.interswitchgroup.crudwithsp.Service;

import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface PaymentConfirmationService {
    Map<String, Object> getPaymentByAmount(double amount);

    Map<String, Object> getPaymentByProductId(String product_id);

    Map<String, Object> getPaymentByCustomerId(String customer_id);

//    PaymentConfirmation getPaymentConfirmationByTransactionId(long transaction_id);

    Map<String, Object> getAllPayments();
}
