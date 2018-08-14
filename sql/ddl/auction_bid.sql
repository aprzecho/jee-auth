--------------------------------------------------------
--  DDL for Table AUCTION_BID
--------------------------------------------------------

  CREATE TABLE "AUCTION_BID" 
   (	"ID" NUMBER, 
	"AUCTION_ID" NUMBER, 
	"BID_VALUE" NUMBER, 
	"USERNAME" VARCHAR2(50)
   ) ;
--------------------------------------------------------
--  DDL for Index AUCTION_BID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "AUCTION_BID_PK" ON "AUCTION_BID" ("ID") 
  ;
--------------------------------------------------------
--  Constraints for Table AUCTION_BID
--------------------------------------------------------

  ALTER TABLE "AUCTION_BID" ADD CONSTRAINT "AUCTION_BID_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "AUCTION_BID" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "AUCTION_BID" MODIFY ("BID_VALUE" NOT NULL ENABLE);
  ALTER TABLE "AUCTION_BID" MODIFY ("AUCTION_ID" NOT NULL ENABLE);
  ALTER TABLE "AUCTION_BID" MODIFY ("ID" NOT NULL ENABLE);
