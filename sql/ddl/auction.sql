--------------------------------------------------------
--  DDL for Table AUCTION
--------------------------------------------------------

  CREATE TABLE "AUCTION" 
   (	"ID" NUMBER, 
	"TITLE" VARCHAR2(100), 
	"CURRENT_BID_ID" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Index AUCTION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "AUCTION_PK" ON "AUCTION" ("ID") 
  ;
--------------------------------------------------------
--  Constraints for Table AUCTION
--------------------------------------------------------

  ALTER TABLE "AUCTION" ADD CONSTRAINT "AUCTION_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "AUCTION" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "AUCTION" MODIFY ("ID" NOT NULL ENABLE);
