package com.interswitchgroup.crudwithsp.Service;

import com.interswitchgroup.crudwithsp.Dao.PaymentConfirmationRespositoryImpl;
import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentConfirmationServiceImpl implements PaymentConfirmationService {

    private PaymentConfirmationRespositoryImpl confirmationRespository;

    @Autowired
    public PaymentConfirmationServiceImpl(PaymentConfirmationRespositoryImpl confirmationRespository) {
        this.confirmationRespository = confirmationRespository;
    }

    @Override
    public List<PaymentConfirmation> getPaymentByAmount(double amount) {
        return confirmationRespository.getPaymentByAmount(amount);
    }

    @Override
    public List<PaymentConfirmation> getPaymentByProductId(String product_id) {
        return confirmationRespository.getPaymentByProductId(product_id);
    }

    @Override
    public List<PaymentConfirmation> getPaymentByCustomerId(String customer_id) {
        return confirmationRespository.getPaymentByCustomerId(customer_id);
    }

//    @Override
//    public PaymentConfirmation getPaymentConfirmationByTransactionId(long transaction_id){
//        return confirmationRespository.getPaymentConfirmationByTransactionId(transaction_id);
//    }

    @Override
    public List<PaymentConfirmation> getAllPayments() {
        return confirmationRespository.getAllPayments();
    }

    public PaymentConfirmation getPaymentById(long id) {
        return confirmationRespository.getPaymentById(id);
    }
}
