USE [test]
GO
/****** Object:  StoredProcedure [dbo].[retrieve_all_payments]    Script Date: 31/03/2020 11:16:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER PROC [dbo].[retrieve_all_payments]
AS
BEGIN
	SELECT * FROM payment_confirmation
END;