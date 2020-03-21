package com.interswitchgroup.crudwithsp;

import com.interswitchgroup.crudwithsp.Dao.PaymentConfirmationRespositoryImpl;
import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import com.interswitchgroup.crudwithsp.RestController.PaymentConfirmationController;
import com.interswitchgroup.crudwithsp.Service.PaymentConfirmationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@ContextConfiguration(classes = {PaymentConfirmationController.class, PaymentConfirmationServiceImpl.class})
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
    PaymentConfirmationServiceImpl paymentConfirmationService;

    @Test
    void getAllpaymentConfirmationTest() throws Exception {
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


    @Test
    void paymentConfirmationByName() {
    }
}