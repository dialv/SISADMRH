/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     21/06/2018 17:43:37                          */
/*==============================================================*/



/*==============================================================*/
/* Table: ASISTENCIACAPACITACION                                */
/*==============================================================*/
create table ASISTENCIACAPACITACION
(
   CODIGOASISTENCIACAPACITACION int not null,
   CODIGOCAPACITACION   int not null,
   HORASRECIBIDAS       int not null,
   UBICACIONASISTENCIACAPACITACION varchar(50),
   EMPLEADO VARCHAR(50),
   NOMBREPUESTO VARCHAR(50),
TELEFONO varchar(11),
EMAIL varchar(50),
codigoempleado int not null,

   primary key (CODIGOASISTENCIACAPACITACION)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA
(
   CODIGOBITACORA       int not null,
   CODIGOEVENTOBITACORA int,
   NOMBREEVENTOBITACORA varchar(50),
   FECHABITACORA        date,
   IP                   varchar(18),
   CODIGOUSUARIOBITACORA varchar(10),
   primary key (CODIGOBITACORA)
);

/*==============================================================*/
/* Table: CAPACITACION                                          */
/*==============================================================*/
create table CAPACITACION
(
   CODIGOCAPACITACION   int not null,
   CODIGOCAPACITADOR    int not null,
   NOMBRECAPACITACION   varchar(50),
   DESCRIPCIONCAPACITACION varchar(500),
   CATEGORIACAPACITACION varchar(30),
   DESCRIPCIONCATEGORIA varchar(500),
   DEPARTAMENTORESPONSABLE varchar(100),
   DURACIONHORACAPACITACION int,
   DURACIONDIACAPACITACION int,
   ORGANISMOPATROCINADOR varchar(200),
   TIPOEVENTO           varchar(200),
   ESPECIALIDADEVENTO   varchar(200),
   PAISCAPACITACION     varchar(50),
   FECHACAPACITACIONDESDE    date,
FECHACAPACITACIONHASTA    date,
   TIPOCAPACITACION     varchar(20),
   ESTADOCAPACITACION   int,
   primary key (CODIGOCAPACITACION)
);

/*==============================================================*/
/* Table: CAPACITADOR                                           */
/*==============================================================*/
create table CAPACITADOR
(
   CODIGOCAPACITADOR    int not null,
   CODIGOEMPLEADO       int not null,
   TEMADOMINIO          varchar(200),
   INSTITUCIONCAPACITADOR      varchar(100),
   TIPOCAPACITADOR      varchar(100),
 TIPOAGRUPACION      varchar(100),
   DUICAPACITADOR       varchar(10),
   NITCAPACITADOR       varchar(17),
   CARNETRESIDENCIA     int,
   TELEFONOCAPACITADOR  varchar(11),
   TELEFONOMOVILCAPACITADOR varchar(11),
   EMAILCAPACITADOR     varchar(50),
   NOMBRECAPACITADOR    varchar(100),
   primary key (CODIGOCAPACITADOR)
);

/*==============================================================*/
/* Table: COMISION                                              */
/*==============================================================*/
create table COMISION
(
   CODIGOCOMISION       int not null,
   CODIGOEMPLEADO       int not null,
   NOMBRECOMISION       varchar(50),
   NUMEROACUERDOCOMISION int,
   FECHADESDECOMISION   date,
   FECHAHASTACOMISION   date,
   NIVELCOMISION        int,
   primary key (CODIGOCOMISION)
);

/*==============================================================*/
/* Table: COMITE                                                */
/*==============================================================*/
create table COMITE
(
   CODIGOCOMITE         int not null,
   CODIGOEMPLEADO       int not null,
    NIT varchar(20) not null,
    DUI varchar(13) not null,
   NOMBRECOMITE         varchar(50),
   RESPONSABLECOMITE    varchar(30),
   DESRIPCIONCOMITE     varchar(100),
   NUMEROACUERDOCOMITE  int,
   MIEMBROMAXIMO        int,
   FECHADESDECOMITE     date,
   FECHAHASTACOMITE     date,
   primary key (CODIGOCOMITE)
);

/*==============================================================*/
/* Table: CONTACTO                                              */
/*==============================================================*/
create table CONTACTO
(
   CODIGOCONTACTO       int not null,
   NOMBRECONTACTO       varchar(50),
   APELLIDOCONTACTO     varchar(50),
   DIRECCION            varchar(100),
   TELEFONOFIJOCONTACTO varchar(11),
   TELEFONOMOVILCONTACTO varchar(11),
   COLUMN_7             char(10),
   primary key (CODIGOCONTACTO)
);

/*==============================================================*/
/* Table: CONTRATO                                              */
/*==============================================================*/
create table CONTRATO
(
   CODIGOCONTRATO       int not null,
   CODIGOEMPLEADO       int not null,
   SALARIOACTUAL      float,
   PLAZANOMINAL          varchar(100),
   SISTEMAPAGO           varchar(50),
   UNIDADPRECIDE        varchar(100),
   LINEATRABAJO         varchar(100),
   PARTIDACONTRATO      varchar(9),
   SUBPARTIDACONTRATO   varchar(100),
   FECHAINICIOCONTRATO  date,
   FECHAFINCONTRATO     date,
   primary key (CODIGOCONTRATO)
);

/*==============================================================*/
/* Table: COSTOCAPACITACION                                     */
/*==============================================================*/
create table COSTOCAPACITACION
(
   CODIGOCOSTOCAPACITACION int not null,
   CODIGOCAPACITACION   int not null,
   COSTOPERSONA         float,
   NUMEROPERSONA        int,
   COSTOCAPACITADOR     float,
   primary key (CODIGOCOSTOCAPACITACION)
);

/*==============================================================*/
/* Table: CUADRODIRECTIVO                                       */
/*==============================================================*/
create table CUADRODIRECTIVO
(
   CODIGOCUADRODIRECTIVO int not null,
   CODIGOEMPLEADO       int not null,
   RESPONSABLECUADRODIRECTIVO varchar(30),
   AREA                 varchar(30),
   DESRIPCIONCUADRODIRECTIVO varchar(100),
   FECHAPRESENTACION    datetime,
   primary key (CODIGOCUADRODIRECTIVO)
);

/*==============================================================*/
/* Table: DEPENDIENTEEMPLEADO                                   */
/*==============================================================*/
create table DEPENDIENTEEMPLEADO
(
   CODIGODEPENDIENTEEMPLEADO int not null,
   CODIGOEMPLEADO       int not null,
   NOMBREDEPENDIENTEEMPLEADO varchar(50),
   APELLIDODEPENDIENTEEMPLEADO varchar(50),
   PARENTESCO           varchar(50),
   FECHANACIMIENTODEPENDIENTEEMPLEADO date,
   DEPENDIENTE          varchar(9),
   SEXODEPENDIENTEEMPLEADO varchar(10),
   primary key (CODIGODEPENDIENTEEMPLEADO)
);

/*==============================================================*/
/* Table: DESCUENTO                                             */
/*==============================================================*/
create table DESCUENTO
(
   CODIGODESCUENTO      int not null,
   NOMBREDESCUENTO      varchar(50),
   TIPODESCUENTO        varchar(50),
   MONTODESCUENTO       float,
   TIPOBANCO            varchar(100),
   CLASE                varchar(100),
   MONTOPAGO            float,
   SALARIO              float,
   primary key (CODIGODESCUENTO)
);

/*==============================================================*/
/* Table: DIAGNOSTICOCAPACITACION                               */
/*==============================================================*/
create table DIAGNOSTICOCAPACITACION
(
   CODIGODIAGNOSTICOCAPACITACION int not null,
   CODIGOCAPACITACION   int not null,
   NECESIDADCAPACITACION varchar(500),
   MESCAPACITACION      varchar(20),
   RESULTADOOBTENER     varchar(500),
   NOMBREAUTORIZADIAGNOSTICOCAPACITACION varchar(150),
   DIRECCION            varchar(100),
   DIAGNOSTICODESDE DATE,
DIAGNOSTICOHASTA DATE,
   CARGOAUTORIZADIAGNOSTICOCAPACITACION varchar(100),
   primary key (CODIGODIAGNOSTICOCAPACITACION)
);

/*==============================================================*/
/* Table: DISCAPACIDAD                                          */
/*==============================================================*/
create table DISCAPACIDAD
(
   CODIGODISCAPACIDAD   int not null,
   NOMBREDISCAPACIDAD   varchar(50),
   DESCRIPCIONDISCAPACIDAD varchar(200),
   primary key (CODIGODISCAPACIDAD)
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO
(
   CODIGOEMPLEADO       int not null,
   NOMBREEMPLEADO       varchar(50),
   APELLIDOEMPLEADO     varchar(50),
   FECHANACIMIENTOEMPLEADO date,
   NACIONALIDAD         varchar(50),
   TIPONACIONALIDAD     varchar(50),
   DEPARTAMENTONACIMIENTO varchar(50),
   MUNICIPIONACIMIENTO  varchar(50),
   GRUPOSANQUINEO       varchar(20),
   TELEFONOMOVILEMPLEADO varchar(11),
   TELEFONOFIJOEMPLEADO varchar(11),
   RECIDENCIAPERMANENTE varchar(50),
   ESTADOFAMILIAR       varchar(50),
   DEPARTAMENTORECIDENCIA varchar(50),
   MUNICIPIORESIDENCIA  varchar(50),
   DUIEMPLEADO          varchar(10),
   NITEMPLEADOR         varchar(17),
   ISSSEMPLEADO         varchar(9),
   FECHAINGRESOSECPUB   date,
   FECHAINGRESOSECPRIV  date,
   FECHAINGRESOMINISTERIO date,
   AFILIACIONPENSION    varchar(6),
   NUMEROAFILIACION     varchar(12),
   TIPOCUENTA           varchar(2),
   NOMBREINSTIUCIONDEPOSITAR varchar(50),
   EMAILEMPLEADO        varchar(50),
   ESTADOEMPLEADO       int,
   SEXOEMPLEADO         varchar(1),
   primary key (CODIGOEMPLEADO)
);

/*==============================================================*/
/* Table: EMPLEADOASISTENCIACAPACITACION                        */
/*==============================================================*/
create table EMPLEADOASISTENCIACAPACITACION
(
   CODIGOEMPLEADO       int not null,
   CODIGOASISTENCIACAPACITACION int not null,
   primary key (CODIGOEMPLEADO, CODIGOASISTENCIACAPACITACION)
);


/*==============================================================*/
/* Table: EMPLEADOCAPACITACION                                  */
/*==============================================================*/
create table EMPLEADOCAPACITACION
(
   CODIGOEMPLEADO       int not null,
   CODIGOCAPACITACION   int not null,
   primary key (CODIGOEMPLEADO, CODIGOCAPACITACION)
);

/*==============================================================*/
/* Table: EMPLEADOCONTACTO                                      */
/*==============================================================*/
create table EMPLEADOCONTACTO
(
   CODIGOEMPLEADO       int not null,
   CODIGOCONTACTO       int not null,
   primary key (CODIGOEMPLEADO, CODIGOCONTACTO)
);

/*==============================================================*/
/* Table: EMPLEADODESCUENTO                                     */
/*==============================================================*/
create table EMPLEADODESCUENTO
(
   CODIGOEMPLEADO       int not null,
   CODIGODESCUENTO      int not null,
   primary key (CODIGOEMPLEADO, CODIGODESCUENTO)
);

/*==============================================================*/
/* Table: EMPLEADODISCAPACIDAD                                  */
/*==============================================================*/
create table EMPLEADODISCAPACIDAD
(
   CODIGOEMPLEADO       int not null,
   CODIGODISCAPACIDAD   int not null,
   primary key (CODIGOEMPLEADO, CODIGODISCAPACIDAD)
);

/*==============================================================*/
/* Table: EMPLEADOEXPERIENCIALABORAL                            */
/*==============================================================*/
create table EMPLEADOEXPERIENCIALABORAL
(
   CODIGOEMPLEADO       int not null,
   CODIGOEXPERIENCIALABORAL int not null,
   primary key (CODIGOEMPLEADO, CODIGOEXPERIENCIALABORAL)
);

/*==============================================================*/
/* Table: EMPLEADOIDIOMA                                        */
/*==============================================================*/
create table EMPLEADOIDIOMA
(
   CODIGOEMPLEADO       int not null,
   CODIGOIDIOMA         int not null,
   primary key (CODIGOEMPLEADO, CODIGOIDIOMA)
);

/*==============================================================*/
/* Table: EMPLEADOMISION                                        */
/*==============================================================*/
create table EMPLEADOMISION
(
   CODIGOEMPLEADO       int not null,
   CODIGOMISION         int not null,
   primary key (CODIGOEMPLEADO, CODIGOMISION)
);

/*==============================================================*/
/* Table: EMPLEADONIVELESCOLARIDAD                              */
/*==============================================================*/
create table EMPLEADONIVELESCOLARIDAD
(
   CODIGOEMPLEADO       int not null,
   CODIGONIVELNIVELESCOLARIDAD int not null,
   primary key (CODIGOEMPLEADO, CODIGONIVELNIVELESCOLARIDAD)
);

/*==============================================================*/
/* Table: EMPLEADOPROGRAMA                                      */
/*==============================================================*/
create table EMPLEADOPROGRAMA
(
   CODIGOEMPLEADO       int not null,
   CODIGOPROGRAMA       int not null,
   primary key (CODIGOEMPLEADO, CODIGOPROGRAMA)
);

/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
create table ESTADO
(
   CODIGOESTADO         int not null,
   NOMBREESTADO         varchar(50),
   VALORESTADO          varchar(100),
   primary key (CODIGOESTADO)
);

/*==============================================================*/
/* Table: EVENTO                                                */
/*==============================================================*/
create table EVENTO
(
   CODIGOEVENTOBITACORA int not null,
   NOMBREEVENTOBITACORA varchar(50),
   DESCRIPCIONEVENTO    varchar(300),
   primary key (CODIGOEVENTOBITACORA)
);

/*==============================================================*/
/* Table: EVUALUACIONCAPACITACION                               */
/*==============================================================*/
create table EVUALUACIONCAPACITACION
(
   CODIGOEVALUACIONCAPACITACION int not null,
   CODIGOCAPACITACION   int not null,
   LUGARCAPACITACION    varchar(100),
   HORAEVUALUACIONCAPACITACION datetime,
   DOMINIOTEMA          varchar(4),
   HABILIDADCOMUNICACION varchar(2),
   ESPECTATIVA          varchar(2),
   CLARIDADTEMA         varchar(2),
   ALCLARADUDAS         varchar(2),
   INTERESTEMA          varchar(2),
   SATIFACCIONDETEMA    varchar(2),
   COMPRENCIONDETEMA    varchar(2),
   PLANEACIONTIEMPO     varchar(4),
   DISTRIBUCIONTIEMPO   varchar(4),
   CONTENIDOCLARO       varchar(4),
   CONTENIDOAPLICADOTRABAJO varchar(4),
   SATISFECHOCONTENIDO  varchar(2),
   NECESARIOCAPACITACION varchar(2),
   EQUIPOTECNOLOGICO    varchar(2),
   MATERIALUTILIZADO    varchar(2),
   TIEMPOCAPACITACIONOPTIMO varchar(2),
   COMENTARIO           varchar(100),
   PUNTUALIDAD          varchar(2),
   primary key (CODIGOEVALUACIONCAPACITACION)
);

/*==============================================================*/
/* Table: EXPEDIENTEEMPLEADO                                    */
/*==============================================================*/
create table EXPEDIENTEEMPLEADO
(
   CODIGOEXPEDIENTEEMPLEADO int not null,
   CODIGOEMPLEADO       int not null,
   LLAMADAATENCION      varchar(50),
   FECHADESPIDO         date,
   JUBILADO             varchar(2),
   PENCIONADO           varchar(2),
   SANCIONES            varchar(200),
   SALARIOINICIAL       float,
   SALARIOFINAL         float,
   LOGROS               varchar(200),
   FECHAINICIOCONTRATO  date,
   FECHAFINCONTRATO     date,
   NOMBRECARGO          varchar(50),
   NOMBREPLAZA          varchar(50),
   DESCRIPCIONPLAZA     varchar(200),
   NUP                  varchar(20),
   LICENCIA             varchar(20),
   DISCAPCIDAD          varchar(100),
   TRABAJOPRIVADO       varchar(2),
   TRABAJOPUBLICO       varchar(2),
   MOTIVODESPIDO        varchar(300),
   primary key (CODIGOEXPEDIENTEEMPLEADO)
);

/*==============================================================*/
/* Table: EXPERIENCIALABORAL                                    */
/*==============================================================*/
create table EXPERIENCIALABORAL
(
   CODIGOEXPERIENCIALABORAL int not null,
   NOMBREINSTITUCION    varchar(50),
   FECHADESDEEXPERIENCIALABORAL date,
   FECHAHASTAEXPERIENCIALABORAL date,
   SALARIOINICIAL       float,
   SALARIOFINAL         float,
   MOTIVORETIRO         varchar(200),
   SECTOREXPERIENCIALABORAL varchar(20),
   primary key (CODIGOEXPERIENCIALABORAL)
);

/*==============================================================*/
/* Table: HABILIDAD                                             */
/*==============================================================*/
create table HABILIDAD
(
   CODIGOHABILIDAD      int not null,
   CODIGOEMPLEADO       int not null,
   NOMBREHABLIDAD       varchar(50),
   primary key (CODIGOHABILIDAD)
);

/*==============================================================*/
/* Table: HIJOSDISCAPACIDAD                                     */
/*==============================================================*/
create table HIJOSDISCAPACIDAD
(
   CODIGOHIJODISCAPACIDAD int not null,
   CODIGOEMPLEADO       int not null,
   NOMBREHIJODISCAPACIDAD varchar(50),
   APELLIDOHIJODISCAPACIDAD varchar(50),
   NOMBREDISCAPACIDAD   varchar(50),
   PARENTESCO           varchar(50),
   FECHANAMIMIENTOHIJOSDISCAPACIDAD date,
   primary key (CODIGOHIJODISCAPACIDAD)
);

/*==============================================================*/
/* Table: IDIOMA                                                */
/*==============================================================*/
create table IDIOMA
(
   CODIGOIDIOMA         int not null,
   NOMBREIDIOMA         varchar(50),
   ESCRIBE              varchar(2),
   HABLA                varchar(2),
   TRADUCE              varchar(2),
   NIVEL                varchar(2),
   primary key (CODIGOIDIOMA)
);

/*==============================================================*/
/* Table: INASISTENCIA                                          */
/*==============================================================*/
create table INASISTENCIA
(
   CODIGOINASISTENCIA   int not null,
   CODIGOEMPLEADO       int not null,
   MOTIVOINASISTENCIA   varchar(200),
   CONSTANCIAINASISTENCIA varchar(200),
   FECHADESDEINASISTENCIA date,
   FECHAHASTAINASISTENCIA date,
   primary key (CODIGOINASISTENCIA)
);

/*==============================================================*/
/* Table: INCAPACIDAD                                           */
/*==============================================================*/
create table INCAPACIDAD
(
   CODIGOINCAPACIDAD    int not null,
   CODIGOEMPLEADO       int not null,
   NUMEROFICHAISSS      varchar(12),
   SUBSIDIO             float,
   FORMAINCAPACIDAD     varchar(100),
   FONDOINCAPACIDAD     varchar(200),
   OBSERVACION          varchar(500),
   DOCUMENTO1           BLOB,
   DOCUMENTO2           BLOB,
   FECHADESDEINCAPACIDAD date,
   FECHAHASTAINCAPACIDAD date,
   FECHAEMISION         date,
   TIPOINCAPACIDAD      varchar(30),
   primary key (CODIGOINCAPACIDAD)
);

/*==============================================================*/
/* Table: MISION                                                */
/*==============================================================*/
create table MISION
(
   CODIGOMISION         int not null,
   NOMBREMISION         varchar(50),
   OBJETIVOMISION       varchar(100),
   RESPONSABLEGASTO     varchar(50),
   ORGANISMOPATROCINADOR varchar(50),
ORGANISMOINVITA varchar(50),
   DEPARTAMENTOMISION   varchar(100),
   PAISDESTINO          varchar(50),
 CIUDAD          varchar(50),
   CANTIDADDIA          int,
   FECHAACUERDOMISION   date,
   GASTOVIAJE           float,
   TIPOTRANSPORTE       varchar(30),
   GASTOTERMINALES      float,
 VIATICOS     float,
   GASTOSTOTALES        float,
   CANTIDADMESES        int,
   DOCUMENTO            varchar(50),
     BOLETO            varchar(20),
   NUMEROACUERDO int,
   TIPOMISION           int,
   FECHASALIDAMISION    date,
   FECHAREGRESOMISION   date,
   primary key (CODIGOMISION)
);

/*==============================================================*/
/* Table: NIVELESCOLARIDAD                                      */
/*==============================================================*/
create table NIVELESCOLARIDAD
(
   CODIGONIVELNIVELESCOLARIDAD int not null,
   CENTROEDUCATIVO      varchar(50),
   ANIOSAPROBADOS       int,
   ESTUDIOREALIZADO     varchar(300),
   FINALIZADO           varchar(2),
   TITULOOBTENIDO       varchar(50),
   PAISNIVELESCOLARIDAD varchar(50),
   FECHADESDENIVELESCOLARIDAD date,
   FECHAHASTANIVELESCOLARIDAD date,
   primary key (CODIGONIVELNIVELESCOLARIDAD)
);

/*==============================================================*/
/* Table: PROGRAMA                                              */
/*==============================================================*/
create table PROGRAMA
(
   CODIGOPROGRAMA       int not null,
   NOMBREPROGRAMA       varchar(50),
   FECHAPROGRAMA        date,
   DESCRIPCIONPROGRAMA  varchar(10),
   RANGOEDAD            varchar(10),
   primary key (CODIGOPROGRAMA)
);

/*==============================================================*/
/* Table: PROGRAMAHIJOSDISCAPACIDAD                             */
/*==============================================================*/
create table PROGRAMAHIJOSDISCAPACIDAD
(
   CODIGOHIJODISCAPACIDAD int not null,
   CODIGOPROGRAMA       int not null,
   primary key (CODIGOHIJODISCAPACIDAD, CODIGOPROGRAMA)
);



/*==============================================================*/
/* Table: UBICACIONFISICA                                       */
/*==============================================================*/
create table UBICACIONFISICA
(
   CODIGOUBICACION      int not null,
   CODIGOEMPLEADO       int not null,
   NOMBREUBICACION      varchar(50),
   JEFEINMEDIATO        varchar(50),
   CARGOFUNCIONAL       varchar(50),
   TEAREADESEMPENIA     varchar(500),
   primary key (CODIGOUBICACION)
);


alter table ASISTENCIACAPACITACION add constraint FK_LLEVA foreign key (CODIGOCAPACITACION)
      references CAPACITACION (CODIGOCAPACITACION) on delete restrict on update restrict;

alter table CAPACITACION add constraint FK_IMPARTE foreign key (CODIGOCAPACITADOR)
      references CAPACITADOR (CODIGOCAPACITADOR) on delete restrict on update restrict;

alter table CAPACITADOR add constraint FK_PUEDE_SER foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table COMISION add constraint FK_PERTENECE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table COMITE add constraint FK_ES_MIENBRO_DE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table CONTRATO add constraint FK_POSEE_UN foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table COSTOCAPACITACION add constraint FK_GENERA foreign key (CODIGOCAPACITACION)
      references CAPACITACION (CODIGOCAPACITACION) on delete restrict on update restrict;

alter table CUADRODIRECTIVO add constraint FK_ES_PARTE_DE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table DEPENDIENTEEMPLEADO add constraint FK_SE_ENCARGA_DE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table DIAGNOSTICOCAPACITACION add constraint FK_SE_HACE foreign key (CODIGOCAPACITACION)
      references CAPACITACION (CODIGOCAPACITACION) on delete restrict on update restrict;

alter table EMPLEADOASISTENCIACAPACITACION add constraint FK_LLEVA_UNA foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADOASISTENCIACAPACITACION add constraint FK_LLEVA_UNA2 foreign key (CODIGOASISTENCIACAPACITACION)
      references ASISTENCIACAPACITACION (CODIGOASISTENCIACAPACITACION) on delete restrict on update restrict;



alter table EMPLEADOCAPACITACION add constraint FK_RECIBE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADOCAPACITACION add constraint FK_RECIBE2 foreign key (CODIGOCAPACITACION)
      references CAPACITACION (CODIGOCAPACITACION) on delete restrict on update restrict;

alter table EMPLEADOCONTACTO add constraint FK_NECESITA foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADOCONTACTO add constraint FK_NECESITA2 foreign key (CODIGOCONTACTO)
      references CONTACTO (CODIGOCONTACTO) on delete restrict on update restrict;

alter table EMPLEADODESCUENTO add constraint FK_SE_REALIZA foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADODESCUENTO add constraint FK_SE_REALIZA2 foreign key (CODIGODESCUENTO)
      references DESCUENTO (CODIGODESCUENTO) on delete restrict on update restrict;

alter table EMPLEADODISCAPACIDAD add constraint FK_PADECE_DE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADODISCAPACIDAD add constraint FK_PADECE_DE2 foreign key (CODIGODISCAPACIDAD)
      references DISCAPACIDAD (CODIGODISCAPACIDAD) on delete restrict on update restrict;

alter table EMPLEADOEXPERIENCIALABORAL add constraint FK_ADQUIERE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADOEXPERIENCIALABORAL add constraint FK_ADQUIERE2 foreign key (CODIGOEXPERIENCIALABORAL)
      references EXPERIENCIALABORAL (CODIGOEXPERIENCIALABORAL) on delete restrict on update restrict;

alter table EMPLEADOIDIOMA add constraint FK_HABLA foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADOIDIOMA add constraint FK_HABLA2 foreign key (CODIGOIDIOMA)
      references IDIOMA (CODIGOIDIOMA) on delete restrict on update restrict;

alter table EMPLEADOMISION add constraint FK_ENVIADO_A foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADOMISION add constraint FK_ENVIADO_A2 foreign key (CODIGOMISION)
      references MISION (CODIGOMISION) on delete restrict on update restrict;

alter table EMPLEADONIVELESCOLARIDAD add constraint FK_TIENE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADONIVELESCOLARIDAD add constraint FK_TIENE2 foreign key (CODIGONIVELNIVELESCOLARIDAD)
      references NIVELESCOLARIDAD (CODIGONIVELNIVELESCOLARIDAD) on delete restrict on update restrict;

alter table EMPLEADOPROGRAMA add constraint FK_SE_BENEFICIA foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table EMPLEADOPROGRAMA add constraint FK_SE_BENEFICIA2 foreign key (CODIGOPROGRAMA)
      references PROGRAMA (CODIGOPROGRAMA) on delete restrict on update restrict;

alter table EVUALUACIONCAPACITACION add constraint FK_SE_REALIZAN foreign key (CODIGOCAPACITACION)
      references CAPACITACION (CODIGOCAPACITACION) on delete restrict on update restrict;

alter table EXPEDIENTEEMPLEADO add constraint FK_SE_CREA foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table HABILIDAD add constraint FK_DESARROLLA foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table HIJOSDISCAPACIDAD add constraint FK_ES_RESPONSABLE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table INASISTENCIA add constraint FK_POSEE foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table INCAPACIDAD add constraint FK_SE_OTORGA foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;

alter table PROGRAMAHIJOSDISCAPACIDAD add constraint FK_RECIBE_UN foreign key (CODIGOHIJODISCAPACIDAD)
      references HIJOSDISCAPACIDAD (CODIGOHIJODISCAPACIDAD) on delete restrict on update restrict;

alter table PROGRAMAHIJOSDISCAPACIDAD add constraint FK_RECIBE_UN2 foreign key (CODIGOPROGRAMA)
      references PROGRAMA (CODIGOPROGRAMA) on delete restrict on update restrict;


alter table UBICACIONFISICA add constraint FK_PERTENECE_A foreign key (CODIGOEMPLEADO)
      references EMPLEADO (CODIGOEMPLEADO) on delete restrict on update restrict;
