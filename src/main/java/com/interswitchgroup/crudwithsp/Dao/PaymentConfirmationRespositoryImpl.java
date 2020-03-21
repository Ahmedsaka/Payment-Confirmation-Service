package com.interswitchgroup.crudwithsp.Dao;

import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;

@Repository
public class PaymentConfirmationRespositoryImpl implements PaymentConfirmationRepository {
//
    @Autowired
     private DataSource dataSource;

     private JdbcTemplate jdbcTemplate;
     private SimpleJdbcCall findByTransactionId, findByAmount, findByCustomerId, findByProductId, findAllPayments;

//     @PostConstruct
     @Autowired
     private void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        findByTransactionId = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_payment_confirmation_by_transaction_id")
                .returningResultSet("transaction", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
        findByCustomerId = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_payment_confirmation_by_customer_id")
                .returningResultSet("transaction", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
        findByProductId = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_payment_confirmation_by_product_id")
                .returningResultSet("transaction", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
        findByAmount = new SimpleJdbcCall(dataSource)
                 .withProcedureName("retrieve_payment_confirmation_by_amount_id")
                 .returningResultSet("transaction", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
        findAllPayments = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_all_payments")
                .returningResultSet("transactions", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
     }

    @Override
    public Map<String, Object> getAllPayments() {
         return findAllPayments.execute();
//         String sql = "SELECT * FROM payment_confirmation";
//        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public Map<String, Object> getPaymentById(long id) {
               return findByTransactionId.useInParameterNames("transaction_id")
                .declareParameters(
                        new SqlParameter("@transaction_id", Types.NUMERIC)
                ).execute( new MapSqlParameterSource()
                        .addValue("@transaction_id", id));
    }

//    @Override
//    public PaymentConfirmation getPaymentConfirmationByTransactionId(long transaction_id){
//         return jdbcTemplate.queryForObject("SELECT * FROM payment_confirmation WHERE transaction_id = ?",new Object[]{transaction_id}, BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
//    }

    @Override
    public Map<String, Object> getPaymentByCustomerId(String customer_id) {
        return findByCustomerId.useInParameterNames("customer_id")
                 .declareParameters(
                         new SqlParameter("@customer_id", Types.VARCHAR))
         .execute( new MapSqlParameterSource()
                 .addValue("@customer_id", customer_id));
    }

    @Override
    public Map<String, Object> getPaymentByProductId(String product_id) {
         return findByProductId.useInParameterNames("product_id")
                 .declareParameters(new SqlParameter("@product_id", Types.VARCHAR))
         .execute(new MapSqlParameterSource().addValue("@product_id", product_id));
    }

    @Override
    public Map<String, Object> getPaymentByAmount(double amount) {
        return findByAmount.useInParameterNames("amount")
                .declareParameters(new SqlParameter("@amount", Types.FLOAT))
                .execute(new MapSqlParameterSource().addValue("@amount", amount));
        }

//        private <T> List<PaymentConfirmation> getPayment(String sql, T params){
//            return jdbcTemplate.query(sql, new Object[]{params}, (resultSet, i) -> new PaymentConfirmation(
//                    resultSet.getLong("transaction_id"),
//                    resultSet.getString("customer_id"),
//                    resultSet.getString("product_id"),
//                    resultSet.getString("transaction_type"),
//                    resultSet.getDouble("amount")
//            ));
//        }
}
