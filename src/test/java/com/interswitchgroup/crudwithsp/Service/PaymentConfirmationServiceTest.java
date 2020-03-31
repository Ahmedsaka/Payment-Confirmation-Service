package com.interswitchgroup.crudwithsp.Service;

import com.interswitchgroup.crudwithsp.Dao.PaymentConfirmationRepositoryImpl;
import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class PaymentConfirmationServiceTest {
    //    @MockBean
    private PaymentConfirmationRepositoryImpl confirmationRespository = Mockito.mock(PaymentConfirmationRepositoryImpl.class);

    @InjectMocks
    private PaymentConfirmationServiceImpl paymentConfirmationService;

//    @BeforeEach
//    void  initUseCase () {
//        paymentConfirmationService = new PaymentConfirmationServiceImpl(paymentConfirmationRespository);
//    }

    @Test
    void paymentConfirmationByTransactionId() {
        PaymentConfirmation paymentConfirmation = new PaymentConfirmation(
                1L,
                "customertest@test.com",
                "270001",
                "billpayment",
                2500.00
        );

        Mockito.when(confirmationRespository.getPaymentById(1L))
                .thenReturn(paymentConfirmation);
        System.out.println(paymentConfirmationService.getPaymentById(1L).toString());
        Assertions.assertThat(paymentConfirmationService.getPaymentById(1L)).isNotNull();
    }

    @Test
    void paymentConfirmationByAmountTest() {
        PaymentConfirmation paymentConfirmation = new PaymentConfirmation(
                1L,
                "customertest@test.com",
                "270001",
                "billpayment",
                2500.00
        );
        Mockito.when(paymentConfirmationService.getPaymentByAmount(2500.00))
                .thenReturn(Collections.singletonList(paymentConfirmation));

        Assertions.assertThat(paymentConfirmationService.getPaymentByAmount(2500.00)).isNotNull();
        Assertions.assertThat(paymentConfirmationService.getPaymentByAmount(2500)).isNotEqualTo(2000);
    }


    @Test
    void paymentConfirmationByProductId() {
        PaymentConfirmation paymentConfirmation = new PaymentConfirmation(
                1L,
                "customertest@test.com",
                "270001",
                "billpayment",
                2500.00
        );

        Mockito.when(paymentConfirmationService.getPaymentByProductId("270001"))
                .thenReturn(Collections.singletonList(paymentConfirmation));

        Assertions.assertThat(paymentConfirmationService.getPaymentByProductId("270001")).isNotNull();
    }
}
