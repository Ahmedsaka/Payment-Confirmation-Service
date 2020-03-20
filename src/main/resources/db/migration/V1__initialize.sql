
CREATE PROCEDURE create_payment_confirmation_tbl
    AS
    BEGIN
        CREATE IF NOT EXISTS TABLE payment_confirmation(
        transaction_id bigint primary key,
        customer_id varchar(50) not null,
        product_id varchar(20) not null,
        transaction_type varchar(30) not null,
        amount float
    )
  END;