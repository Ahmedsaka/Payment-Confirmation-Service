package com.interswitchgroup.crudwithsp.Service;

import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PaymentConfirmationService {
    List<PaymentConfirmation> getPaymentByAmount(double amount);

    List<PaymentConfirmation> getPaymentByProductId(String product_id);

    List<PaymentConfirmation> getPaymentByCustomerId(String customer_id);

    PaymentConfirmation getPaymentConfirmationByTransactionId(long transaction_id);

    List<Map<String, Object>> getAllPayments();
}
