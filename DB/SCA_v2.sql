/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     22-09-2024 16:23:37                          */
/*==============================================================*/
DROP TABLE if EXISTS CARGOS;
DROP TABLE if EXISTS MARCACIONES;
DROP TABLE if EXISTS TRABAJADORES;
DROP TABLE if EXISTS TURNOS;

/*==============================================================*/
/* Table: CARGOS                                                */
/*==============================================================*/
CREATE TABLE CARGOS
(
 ID INT NOT NULL AUTO_INCREMENT,
 CARGO VARCHAR(50) NOT NULL, PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: MARCACIONES                                           */
/*==============================================================*/
CREATE TABLE MARCACIONES
(
 ID INT NOT NULL AUTO_INCREMENT,
 RUT INT NOT NULL,
 FECHA DATE NOT NULL,
 HORA TIME NOT NULL,
 TIPO BOOL NOT NULL, PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: TRABAJADORES                                          */
/*==============================================================*/
CREATE TABLE TRABAJADORES
(
 RUT INT NOT NULL AUTO_INCREMENT,
 DV VARCHAR(1),
 ID INT,
 CAR_ID INT,
 NOMBRES VARCHAR(60) NOT NULL,
 APELLIDOS VARCHAR(80) NOT NULL,
 DEPARTAMENTO VARCHAR(25) NOT NULL,
 AREA VARCHAR(25),
 CORREO VARCHAR(100),
 CLAVE VARCHAR(60), PRIMARY KEY (RUT)
);

/*==============================================================*/
/* Table: TURNOS                                                */
/*==============================================================*/
CREATE TABLE TURNOS
(
 ID INT NOT NULL AUTO_INCREMENT,
 DESCRIPCION VARCHAR(25) NOT NULL,
 INGRESO TIME NOT NULL,
 SALIDA TIME NOT NULL, PRIMARY KEY (ID)
); ALTER TABLE MARCACIONES ADD CONSTRAINT FK_REALIZA_UNA FOREIGN KEY (RUT) REFERENCES TRABAJADORES (RUT) ON
DELETE RESTRICT ON
UPDATE RESTRICT; ALTER TABLE TRABAJADORES ADD CONSTRAINT FK_TIENE_ASIGNADO_UN FOREIGN KEY (ID) REFERENCES TURNOS (ID) ON
DELETE RESTRICT ON
UPDATE RESTRICT; ALTER TABLE TRABAJADORES ADD CONSTRAINT FK_TIENE_UN FOREIGN KEY (CAR_ID) REFERENCES CARGOS (ID) ON
DELETE RESTRICT ON
UPDATE RESTRICT;

