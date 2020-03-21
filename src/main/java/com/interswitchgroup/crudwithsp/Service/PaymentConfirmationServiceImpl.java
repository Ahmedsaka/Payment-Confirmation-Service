package com.interswitchgroup.crudwithsp.Service;

import com.interswitchgroup.crudwithsp.Dao.PaymentConfirmationRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentConfirmationServiceImpl implements PaymentConfirmationService {

    private PaymentConfirmationRespositoryImpl confirmationRespository;

    @Autowired
    public PaymentConfirmationServiceImpl(PaymentConfirmationRespositoryImpl confirmationRespository) {
        this.confirmationRespository = confirmationRespository;
    }

    @Override
    public Map<String, Object> getPaymentByAmount(double amount) {
        return confirmationRespository.getPaymentByAmount(amount);
    }

    @Override
    public Map<String, Object> getPaymentByProductId(String product_id) {
        return confirmationRespository.getPaymentByProductId(product_id);
    }

    @Override
    public Map<String, Object> getPaymentByCustomerId(String customer_id) {
        return confirmationRespository.getPaymentByCustomerId(customer_id);
    }

//    @Override
//    public PaymentConfirmation getPaymentConfirmationByTransactionId(long transaction_id){
//        return confirmationRespository.getPaymentConfirmationByTransactionId(transaction_id);
//    }

    @Override
    public Map<String, Object> getAllPayments() {
        return confirmationRespository.getAllPayments();
    }

    public Object getPaymentById(long id) {
        return confirmationRespository.getPaymentById(id);
    }
}
