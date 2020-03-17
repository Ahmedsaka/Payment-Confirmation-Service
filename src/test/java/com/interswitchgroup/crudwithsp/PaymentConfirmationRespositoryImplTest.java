package com.interswitchgroup.crudwithsp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = PaymentConfirmationRespositoryImpl.class)
class PaymentConfirmationRespositoryImplTest {

    @Autowired
    PaymentConfirmationRespositoryImpl respository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void paymentConfirmationRepositoryImplTest() {


    }
}