package com.interswitchgroup.crudwithsp;

import com.interswitchgroup.crudwithsp.Dao.PaymentConfirmationRespositoryImpl;
import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import com.interswitchgroup.crudwithsp.RestController.PaymentConfirmationController;
import com.interswitchgroup.crudwithsp.Service.PaymentConfirmationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebMvcTest
@ContextConfiguration(classes = {PaymentConfirmationController.class, PaymentConfirmation.class})
class PaymentConfirmationControllerTest {

    private long id = 1L;
    private PaymentConfirmation paymentConfirmation = new PaymentConfirmation(1L,
            "customertest@test.com",
            "270001",
            "billpayment",
            2500.00);

    private PaymentConfirmation paymentConfirmation2 = new PaymentConfirmation(2L,
            "ahmedsaka91@gmail.com",
            "249320",
            "billpayment",
            10500.00);

    List<PaymentConfirmation> paymentConfirmations = Arrays.asList(paymentConfirmation, paymentConfirmation2);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PaymentConfirmationServiceImpl paymentConfirmationService;

    @Test
    void getAllpaymentConfirmationTest() throws Exception {
        Mockito.when(paymentConfirmationService.getAllPayments()).thenReturn(paymentConfirmations);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment_confirmation/allpayments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0]").value(paymentConfirmation))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1]").value(paymentConfirmation2));
    }

    @Test
    void getPaymentConfirmationByTransaction_id() throws Exception{
        Mockito.when(paymentConfirmationService.getPaymentById(id))
                .thenReturn(paymentConfirmation);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment_confirmation/payment/1", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transaction_id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer_id").value("customertest@test.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value("270001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transaction_type").value("billpayment"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount").value(2500.00));
    }


    @Test
    void paymentConfirmationByProductId() {
//        Mockito.when(paymentConfirmationService.getPaymentByProductId("270001"))
//                .thenReturn(Collections.singletonList(paymentConfirmation));
//        this.mockMvc.perform(MockMvcRequestBuilders.get())

    }
}