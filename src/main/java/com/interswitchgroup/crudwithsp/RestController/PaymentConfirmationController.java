package com.interswitchgroup.crudwithsp.RestController;

import com.interswitchgroup.crudwithsp.Dao.PaymentConfirmationRespositoryImpl;
import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping(value = "/payment_confirmation")
public class PaymentConfirmationController {

    private PaymentConfirmationRespositoryImpl paymentConfirmationRespository;

    @Autowired
    public PaymentConfirmationController(PaymentConfirmationRespositoryImpl paymentConfirmationRespository) {
        this.paymentConfirmationRespository = paymentConfirmationRespository;
    }

    @RequestMapping(value = "/payment_confirmation/allpayments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<List<Map<String, Object>>> getAllpaymentConfirmation(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "All transactions");
        return Optional.ofNullable(paymentConfirmationRespository.getAllPayments());
    }

    @RequestMapping(value = "/payment_confirmation/payment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<List<PaymentConfirmation>> getTransactionId(@PathVariable long id) {
        return Optional.ofNullable(paymentConfirmationRespository.getPaymentConfirmationByTransactionId(id));
    }


    @RequestMapping(value = "/payment_confirmation/paymentByProductId" +
            "/{product_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<List<PaymentConfirmation>> getTransactionsByProductId(@PathVariable String product_id) {
        return Optional.ofNullable(paymentConfirmationRespository.getPaymentByProductId(product_id));
    }

    @RequestMapping(value = "/payment_confirmation/paymentByAmount" +
            "/{amount}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<List<PaymentConfirmation>> getTransactionsByAmount(@PathVariable double amount) {
        return Optional.ofNullable(paymentConfirmationRespository.getPaymentByAmount(amount));
    }
}
