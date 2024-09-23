/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     03-09-2024 22:15:58                          */
/*==============================================================*/


drop table if exists CARGOS;

drop table if exists MARCACIONES;

drop table if exists TRABAJADORES;

drop table if exists TURNOS;

drop table if exists USUARIOS;

/*==============================================================*/
/* Table: CARGOS                                                */
/*==============================================================*/
create table CARGOS
(
   ID                   int not null auto_increment,
   CARGO                varchar(50) not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: MARCACIONES                                           */
/*==============================================================*/
create table MARCACIONES
(
   ID                   int not null auto_increment,
   RUT                  int not null,
   FECHA                date not null,
   HORA                 time not null,
   TIPO                 bool not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: TRABAJADORES                                          */
/*==============================================================*/
create table TRABAJADORES
(
   RUT                  int not null auto_increment,
   ID                   int,
   NOMBRES              varchar(60) not null,
   APELLIDOS            varchar(80) not null,
   CORREO               varchar(100),
   DEPARTAMENTO         varchar(25) not null,
   AREA                 varchar(25),
   primary key (RUT)
);

/*==============================================================*/
/* Table: TURNOS                                                */
/*==============================================================*/
create table TURNOS
(
   ID                   int not null auto_increment,
   DESCRIPCION          varchar(25) not null,
   INGRESO              time not null,
   SALIDA               time not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
create table USUARIOS
(
   RUT                  int not null auto_increment,
   ID                   int,
   NOMBRES              varchar(60) not null,
   APELLIDOS            varchar(80) not null,
   CORREO               varchar(100),
   primary key (RUT)
);

alter table MARCACIONES add constraint FK_REALIZA_UNA foreign key (RUT)
      references TRABAJADORES (RUT) on delete restrict on update restrict;

alter table TRABAJADORES add constraint FK_TIENE_ASIGNADO_UN foreign key (ID)
      references TURNOS (ID) on delete restrict on update restrict;

alter table USUARIOS add constraint FK_TIENE_UN foreign key (ID)
      references CARGOS (ID) on delete restrict on update restrict;

