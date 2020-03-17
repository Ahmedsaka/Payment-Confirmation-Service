package com.interswitchgroup.crudwithsp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
@ContextConfiguration(classes = PaymentConfirmationController.class)
class PaymentConfirmationControllerTest {

    private long id = 1L;
    private PaymentConfirmation paymentConfirmation = new PaymentConfirmation(1L,
            "customertest@test.com",
            "270001",
            "billpayment",
            2500.00);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PaymentConfirmationRespositoryImpl paymentConfirmationRespository;

    @Test
    void getAllpaymentConfirmationTest() throws Exception {
//        Mockito.when(this.paymentConfirmationRespository.getAllPayments())
//                .thenReturn(Collections.singletonList(paymentConfirmation));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment_confirmation/allpayments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

//    @Test
//    void getPaymentConfirmationByTransaction_id() throws Exception{
//        Mockito.when(this.paymentConfirmationRespository.getPaymentById(id))
//                .thenReturn(paymentConfirmation);
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/payment_confirmation/payment/{id}"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].transaction_id").value(1L))
//                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].customer_id").value("customertest@test.com"));
//    }


}