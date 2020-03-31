USE [test]
GO
/****** Object:  StoredProcedure [dbo].[retrieve_payment_confirmation_by_amount_id]    Script Date: 31/03/2020 11:23:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER PROC [dbo].[retrieve_payment_confirmation_by_amount_id]
@amount FLOAT
AS
BEGIN
	SELECT * FROM payment_confirmation
	WHERE amount = @amount
END;