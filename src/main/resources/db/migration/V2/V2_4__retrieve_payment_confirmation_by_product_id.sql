USE [test]
GO
/****** Object:  StoredProcedure [dbo].[retrieve_payment_confirmation_by_product_id]    Script Date: 31/03/2020 11:22:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER PROC [dbo].[retrieve_payment_confirmation_by_product_id]
@product_id VARCHAR(30)
AS
BEGIN
	SELECT * FROM payment_confirmation
	WHERE product_id = @product_id
END;