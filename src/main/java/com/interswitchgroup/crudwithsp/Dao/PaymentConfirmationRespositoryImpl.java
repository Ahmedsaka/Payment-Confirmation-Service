package com.interswitchgroup.crudwithsp.Dao;

import com.interswitchgroup.crudwithsp.Model.PaymentConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class PaymentConfirmationRespositoryImpl implements PaymentConfirmationRepository {
//
    @Autowired
     private DataSource dataSource;

     private JdbcTemplate jdbcTemplate;
     private SimpleJdbcCall findByTransactionId, findByAmount, findByCustomerId, findByProductId;

//     @PostConstruct
     @Autowired
     private void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        findByTransactionId = new SimpleJdbcCall(dataSource)
                .withProcedureName("retrieve_payment_confirmation_by_transaction_id")
                .returningResultSet("transaction", BeanPropertyRowMapper.newInstance(PaymentConfirmation.class))
              ;
     }

    @Override
    public List<Map<String, Object>> getAllPayments() {
         String sql = "SELECT * FROM payment_confirmation";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public PaymentConfirmation getPaymentById(long id) {
        PaymentConfirmation payCon = new PaymentConfirmation();
                findByTransactionId.useInParameterNames("transaction_id")
                .declareParameters(
                        new SqlParameter("@transaction_id", Types.NUMERIC),
                        new SqlParameter("@customer_id", Types.VARCHAR),
                        new SqlParameter("@product_id", Types.VARCHAR),
                        new SqlParameter("@transaction_type", Types.VARCHAR),
                        new SqlParameter("@amount", Types.NUMERIC)
                );
             SqlParameterSource in = new MapSqlParameterSource()
                 .addValue("@transaction_id", id);
         Map<String, Object> out = findByTransactionId.execute(in);
            payCon.setTransaction_id((Long) out.get("@transaction_id"));
            payCon.setCustomer_id((String) out.get("@customer_id"));
            payCon.setProduct_id((String) out.get("@product_id"));
            payCon.setTransaction_type((String) out.get("@transaction_type"));
            payCon.setAmount((Double) out.get("@amount"));
       return payCon ;
    }

    @Override
    public PaymentConfirmation getPaymentConfirmationByTransactionId(long transaction_id){
         return jdbcTemplate.queryForObject("SELECT * FROM payment_confirmation WHERE transaction_id = ?",new Object[]{transaction_id}, BeanPropertyRowMapper.newInstance(PaymentConfirmation.class));
    }

    @Override
    public List<PaymentConfirmation> getPaymentByCustomerId(String customer_id) {
        return getPayment("SELECT * FROM payment_confirmation WHERE customer_id = ?", customer_id);
    }

    @Override
    public List<PaymentConfirmation> getPaymentByProductId(String product_id) {
        return getPayment("SELECT * FROM payment_confirmation WHERE product_id = ?", product_id);
    }

    @Override
    public List<PaymentConfirmation> getPaymentByAmount(double amount) {
                return getPayment("SELECT * FROM payment_confirmation WHERE amount = ?", amount);
        }

        private <T> List<PaymentConfirmation> getPayment(String sql, T params){
            return jdbcTemplate.query(sql, new Object[]{params}, (resultSet, i) -> new PaymentConfirmation(
                    resultSet.getLong("transaction_id"),
                    resultSet.getString("customer_id"),
                    resultSet.getString("product_id"),
                    resultSet.getString("transaction_type"),
                    resultSet.getDouble("amount")
            ));
        }
}
