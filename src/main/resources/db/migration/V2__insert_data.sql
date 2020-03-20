
--ALTER TABLE payment_confirmation COLUMN product_id NULL;

INSERT INTO payment_confirmation(transaction_id, customer_id, product_id, transaction_type, amount)
VALUES(3, 'samson.oyetayo@interswitchgroup.com', '270001', 'billpayment', 50000);