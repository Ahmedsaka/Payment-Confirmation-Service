USE [test]
GO
/****** Object:  StoredProcedure [dbo].[retrieve_payment_confirmation_by_transaction_id]    Script Date: 31/03/2020 11:20:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Ahmed Saka
-- Create date: 13/03/2020
-- Description:	Retrieve payment confirmation by transaction id
-- =============================================
ALTER PROCEDURE [dbo].[retrieve_payment_confirmation_by_transaction_id]
	-- Add the parameters for the stored procedure here
	@transaction_id bigint = 0
	--@customer_id VARCHAR(30),
	-- @product_id VARCHAR(30),
	-- @transaction_type VARCHAR(50),
	--@amount FLOAT

	--@p2 int = 0
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT *-- @customer_id = customer_id, @product_id = product_id, @transaction_type  = transaction_type, @amount = amount
	FROM dbo.payment_confirmation
		WHERE transaction_id = @transaction_id;
	--EXECUTE retrieve_payment_confirmation_by_transaction_id @transaction_id = 1;
	--, @p2
END
