package com.interswitchgroup.crudwithsp.RestController;

import com.interswitchgroup.crudwithsp.Service.PaymentConfirmationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping(value = "/payment_confirmation")
public class PaymentConfirmationController {

    private static Logger LOG = LoggerFactory.getLogger(PaymentConfirmationController.class);
    private PaymentConfirmationServiceImpl paymentConfirmationService;

    @Autowired
    public PaymentConfirmationController(PaymentConfirmationServiceImpl paymentConfirmationService) {
        this.paymentConfirmationService = paymentConfirmationService;
    }

    @RequestMapping(value = "/payment_confirmation/allpayments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Map<String, Object>> getAllpaymentConfirmation(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "All transactions");
//        paymentConfirmationService.getAllPayments()
//                .stream()
//                .forEach(p-> LOG.info(p.toString()));
        return Optional.ofNullable(paymentConfirmationService.getAllPayments());
    }

//    @RequestMapping(value = "/payment_confirmation/payment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Optional<PaymentConfirmation> getTransactionId(@PathVariable long id) {
//        return Optional.ofNullable(paymentConfirmationService.getPaymentConfirmationByTransactionId(id));
//    }


    @RequestMapping(value = "/payment_confirmation/paymentByProductId" +
            "/{product_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Map<String, Object>> getTransactionsByProductId(@PathVariable String product_id) {
        return Optional.ofNullable(paymentConfirmationService.getPaymentByProductId(product_id));
    }

    @RequestMapping(value = "/payment_confirmation/paymentByAmount" +
            "/{amount}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Map<String, Object>> getTransactionsByAmount(@PathVariable double amount) {
        return Optional.ofNullable(paymentConfirmationService.getPaymentByAmount(amount));
    }

    @RequestMapping(value = "/payment_confirmation/paymentByCustomerId" +
            "/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Map<String, Object>> getTransactionsByCustomerId(@PathVariable String customerId) {
        return Optional.ofNullable(paymentConfirmationService.getPaymentByCustomerId(customerId));
    }

    @RequestMapping(value = "/payment_confirmation/payment1/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Object> getTransactionId1(@PathVariable long id) {
        return Optional.ofNullable(paymentConfirmationService.getPaymentById(id));
    }
}
