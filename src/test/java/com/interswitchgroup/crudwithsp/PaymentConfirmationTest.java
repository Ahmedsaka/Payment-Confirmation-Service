package com.interswitchgroup.crudwithsp;

import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentConfirmationTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void paymentConfirmationObjectTest() {
        PaymentConfirmation paymentConfirmation = new PaymentConfirmation(1L, "customertest@test.com", "270001", "billpayment", 2500.00);

        assertEquals(paymentConfirmation.getTransaction_id(), 1L);
        assertEquals(paymentConfirmation.getCustomer_id(), "customertest@test.com");
        assertEquals(paymentConfirmation.getProduct_id(), "270001");
        assertEquals(paymentConfirmation.getTransaction_type(), "billpayment");
        assertEquals(paymentConfirmation.getAmount(), 2500.00);
    }

    @Test
    void paymentConfirmationEqualityTest() {
        PaymentConfirmation paymentConfirmation = new PaymentConfirmation(1L, "customertest@test.com", "270001", "billpayment", 2500.00);
        PaymentConfirmation paymentConfirmation1 = new PaymentConfirmation(1L, "customertest@test.com", "270001", "billpayment", 2550.00);

        assertFalse(paymentConfirmation.equals(paymentConfirmation1));
        assertTrue(paymentConfirmation.equals(paymentConfirmation));
    }
}