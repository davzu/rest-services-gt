--------------------------------------------------------
--  DDL for Table TALLER
--------------------------------------------------------

  CREATE TABLE "TALLER" 
   (	"ID_TALLER" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(240), 
	"DESCRIPCION" VARCHAR2(4000), 
	"ESTADO" CHAR(1) DEFAULT '1'
   ) ;
REM INSERTING into TALLER
SET DEFINE OFF;
Insert into TALLER (ID_TALLER,NOMBRE,DESCRIPCION,ESTADO) values ('1','TALLER SPRING 5.0','CURSO DESDE CERO SPRING 5.0','1');
Insert into TALLER (ID_TALLER,NOMBRE,DESCRIPCION,ESTADO) values ('2','TALLER SERVICIOS REST','CURSO SERVICIOS REST','1');
Insert into TALLER (ID_TALLER,NOMBRE,DESCRIPCION,ESTADO) values ('3','TALLER WEB CON JSF','DESARROLLO WEB CON JSF','1');
--------------------------------------------------------
--  DDL for Index SYS_C007372
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007372" ON "TALLER" ("ID_TALLER") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C007373
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007373" ON "TALLER" ("NOMBRE") 
  ;
--------------------------------------------------------
--  Constraints for Table TALLER
--------------------------------------------------------

  ALTER TABLE "TALLER" ADD UNIQUE ("NOMBRE") ENABLE;
  ALTER TABLE "TALLER" ADD PRIMARY KEY ("ID_TALLER") ENABLE;
  ALTER TABLE "TALLER" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
  ALTER TABLE "TALLER" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "TALLER" MODIFY ("ID_TALLER" NOT NULL ENABLE);
