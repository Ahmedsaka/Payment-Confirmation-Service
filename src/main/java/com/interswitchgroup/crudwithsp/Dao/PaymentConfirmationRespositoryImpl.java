package com.interswitchgroup.crudwithsp.Dao;

import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class PaymentConfirmationRespositoryImpl implements PaymentConfirmationRepository {
    @Autowired
     private DataSource dataSource;

     private SimpleJdbcCall findByTransactionId, findByAmount, findByCustomerId, findByProductId, findAllPayments;

     @Autowired
     private void setDataSource(DataSource dataSource){
        findByTransactionId = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_payment_confirmation_by_transaction_id")
                .returningResultSet("transaction", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
        findByCustomerId = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_payment_confirmation_by_customer_id")
                .returningResultSet("transactions", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
        findByProductId = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_payment_confirmation_by_product_id")
                .returningResultSet("transactions", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
        findByAmount = new SimpleJdbcCall(dataSource)
                 .withProcedureName("retrieve_payment_confirmation_by_amount_id")
                 .returningResultSet("transactions", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
        findAllPayments = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_all_payments")
                .returningResultSet("transactions", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
     }

    @Override
    public List<PaymentConfirmation> getAllPayments() {
         Map<String, Object> out = findAllPayments.execute();
         return (List<PaymentConfirmation>) out.get("transactions");
    }

    @Override
    public PaymentConfirmation getPaymentById(long id) {
         Map<String, Object> out = findByTransactionId.useInParameterNames("transaction_id")
                .declareParameters(new SqlParameter("@transaction_id", Types.NUMERIC))
                       .execute(new MapSqlParameterSource().addValue("@transaction_id", id));
         List<PaymentConfirmation> results = (List<PaymentConfirmation>) out.get("transaction");
         return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<PaymentConfirmation> getPaymentByCustomerId(String customer_id) {

        Map<String, Object> out = findByCustomerId.useInParameterNames("customer_id")
                 .declareParameters(new SqlParameter("@customer_id", Types.VARCHAR))
                    .execute(new MapSqlParameterSource().addValue("@customer_id", customer_id));
        return (List<PaymentConfirmation>)out.get("transactions");
    }

    @Override
    public List<PaymentConfirmation> getPaymentByProductId(String product_id) {

         Map<String, Object> out = findByProductId.useInParameterNames("product_id")
                 .declareParameters(new SqlParameter("@product_id", Types.VARCHAR))
                    .execute(new MapSqlParameterSource().addValue("@product_id", product_id));
         return (List<PaymentConfirmation>) out.get("transactions");
    }

    @Override
    public List<PaymentConfirmation> getPaymentByAmount(double amount) {
        Map<String, Object> out = findByAmount.useInParameterNames("amount")
                .declareParameters(new SqlParameter("@amount", Types.FLOAT))
                    .execute(new MapSqlParameterSource().addValue("@amount", amount));
        return (List<PaymentConfirmation>) out.get("transactions");
        }
}
