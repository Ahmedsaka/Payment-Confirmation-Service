USE [test]
GO
/****** Object:  StoredProcedure [dbo].[retrieve_payment_confirmation_by_customer_id]    Script Date: 31/03/2020 11:21:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER PROC [dbo].[retrieve_payment_confirmation_by_customer_id]
@customer_id VARCHAR(30)

AS
BEGIN
	SELECT * FROM payment_confirmation
	WHERE customer_id = @customer_id
END;