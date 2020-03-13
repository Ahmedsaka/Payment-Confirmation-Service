package com.interswitchgroup.crudwithsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PaymentConfirmationRespositoryImpl implements PaymentConfirmationRepository {

    @Autowired
     private DataSource dataSource;

     private JdbcTemplate jdbcTemplate;
     private SimpleJdbcCall simpleJdbcCall;

     @PostConstruct
     private void setDataSource(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("retreive_payment_confirmation_by_id");
     }

    @Override
    public List<PaymentConfirmation> getAllPayments() {
         String sql = "SELECT * FROM payment_confirmation";
        return jdbcTemplate.queryForList(sql, PaymentConfirmation.class);
    }

    @Override
    public PaymentConfirmation getPaymentById(long transaction_id) {

//        String sql = "SELECT * FROM payment_confirmation WHERE transaction_id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{transaction_id},
//                (resultSet, i) -> {
//                    PaymentConfirmation paymentConfirmation = new PaymentConfirmation();
//                    paymentConfirmation.setTranaction_id(resultSet.getLong("transaction_id"));
//                    paymentConfirmation.setCustomer_id(resultSet.getString("customer_id"));
//                    paymentConfirmation.setProduct_id(resultSet.getString("product_id"));
//                    paymentConfirmation.setTransaction_type(resultSet.getString("transaction_type"));
//                    paymentConfirmation.setAmount(resultSet.getDouble("amount"));
//                    return paymentConfirmation;
//                }
//        );
    }

    @Override
    public PaymentConfirmation getPaymentByCustomerId(String customer_id) {
        String sql = "SELECT * FROM payment_confirmation WHERE customer_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{customer_id},
                (resultSet, i) -> {
                    PaymentConfirmation paymentConfirmation = new PaymentConfirmation();
                    paymentConfirmation.setTranaction_id(resultSet.getLong("transaction_id"));
                    paymentConfirmation.setCustomer_id(resultSet.getString("customer_id"));
                    paymentConfirmation.setProduct_id(resultSet.getString("product_id"));
                    paymentConfirmation.setTransaction_type(resultSet.getString("transaction_type"));
                    paymentConfirmation.setAmount(resultSet.getDouble("amount"));
                    return paymentConfirmation;
                }
        );
    }

    @Override
    public List<PaymentConfirmation> getPaymentByProductId(String product_id) {
        String sql = "SELECT * FROM payment_confirmation WHERE product_id = ?";
        return jdbcTemplate.query(sql, new Object[]{product_id},
                (resultSet, i) -> {
                    PaymentConfirmation paymentConfirmation = new PaymentConfirmation();
                    paymentConfirmation.setTranaction_id(resultSet.getLong("transaction_id"));
                    paymentConfirmation.setCustomer_id(resultSet.getString("customer_id"));
                    paymentConfirmation.setProduct_id(resultSet.getString("product_id"));
                    paymentConfirmation.setTransaction_type(resultSet.getString("transaction_type"));
                    paymentConfirmation.setAmount(resultSet.getDouble("amount"));
                    return paymentConfirmation;
                }
        );
    }

    @Override
    public List<PaymentConfirmation> getPaymentByAmount(double amount) {
        String sql = "SELECT * FROM payment_confirmation WHERE amount = ?";
        return jdbcTemplate.query(sql, new Object[]{amount},
                (resultSet, i) -> {
                    PaymentConfirmation paymentConfirmation = new PaymentConfirmation();
                    paymentConfirmation.setTranaction_id(resultSet.getLong("transaction_id"));
                    paymentConfirmation.setCustomer_id(resultSet.getString("customer_id"));
                    paymentConfirmation.setProduct_id(resultSet.getString("product_id"));
                    paymentConfirmation.setTransaction_type(resultSet.getString("transaction_type"));
                    paymentConfirmation.setAmount(resultSet.getDouble("amount"));
                    return paymentConfirmation;
                }
        );
    }
}
