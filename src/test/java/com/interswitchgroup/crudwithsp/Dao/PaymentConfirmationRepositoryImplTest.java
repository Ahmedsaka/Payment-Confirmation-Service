package com.interswitchgroup.crudwithsp.Dao;

import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.jdbc.core.BeanPropertyRowMapper.*;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = PaymentConfirmationRepositoryImpl.class)
class PaymentConfirmationRepositoryImplTest {

    @InjectMocks
    PaymentConfirmationRepositoryImpl repository;

    DataSource dataSource;
    Connection connection;
    DatabaseMetaData databaseMetaData;
    @BeforeEach
    void setUp() throws Exception {
        SimpleJdbcCall findByProductId = Mockito.mock(SimpleJdbcCall.class);
        SimpleJdbcCall findByCustomerId = Mockito.mock(SimpleJdbcCall.class);
        SimpleJdbcCall getAllpayments = Mockito.mock(SimpleJdbcCall.class);
        dataSource = Mockito.mock(DataSource.class);
        connection = Mockito.mock(Connection.class);
        databaseMetaData = Mockito.mock(DatabaseMetaData.class);
        given(dataSource.getConnection()).willReturn(connection);
        given(connection.getMetaData()).willReturn(databaseMetaData);
    }

    @Test
    void paymentConfirmationById() {
        PaymentConfirmation paymentConfirmation = new PaymentConfirmation(
                1L,
                "customertest@test.com",
                "270001",
                "billpayment",
                2500.00
        );

//        Assertions.assertThat(repository.getPaymentById(1L)).isNotNull();
//        Assertions.assertThat(repository.getPaymentById(1L)).isEqualTo(paymentConfirmation);
//
//        SimpleJdbcCall findByTransactionId = new SimpleJdbcCall(dataSource)
//                .withProcedureName("retrieve_payment_confirmation_by_transaction_id")
//                .returningResultSet("transaction",
//                        newInstance(PaymentConfirmation.class));
//
//        Map<String, Object> out = findByTransactionId.useInParameterNames("transaction_id")
//                .declareParameters(new SqlParameter("@transaction_id", Types.NUMERIC))
//                .execute(new MapSqlParameterSource().addValue("@transaction_id", 1L));
//        List<PaymentConfirmation> result = (List<PaymentConfirmation>) out.get("transaction");
//
//        when(repository.getPaymentById(1L))
//                .thenReturn(result.get(0));
//        Assertions.assertThat((List<PaymentConfirmation>)out.get("transaction")).isEqualTo(paymentConfirmation);

    }

    @AfterEach
    void tearDown() {
    }

}