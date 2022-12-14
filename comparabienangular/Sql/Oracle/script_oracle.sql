create table OPCION
(
    OPCIONID    NUMBER(19) generated as identity
        primary key,
    NOMBRE      VARCHAR2(100),
    DESCRIPCION VARCHAR2(200),
    PATHURL     VARCHAR2(200),
    ICONO       VARCHAR2(100),
    ESTADO      CHAR
        constraint CONS_OPCION_ESTADO
            check (ESTADO IN ('1', '0')),
    ORDEN       NUMBER(4)
)
;

--- OPCION TABLE

INSERT INTO HR.OPCION ( Nombre, Descripcion, PathUrl, Icono, Estado, Orden) VALUES ( N'Deposito Plazo', N'Deposito de dinero', N'/deposito-plazo/result', N'fas fa-money-bill', 1, 2);
INSERT INTO HR.OPCION ( Nombre, Descripcion, PathUrl, Icono, Estado, Orden) VALUES ( N'Prestamos Personales', N'Prestamo de dinero', N'/prestamo/result', N'fas fa-hand-holding-usd', 1, 1);


-- DEPARTAMENTO TABLE

create table DEPARTAMENTO
(
    DEPARTAMENTOID NUMBER(19)  generated as identity primary key,
    NOMBRE         varchar2(100),
    ESTADO         CHAR(1) CONSTRAINT cons_atable_col1 CHECK (ESTADO IN ('1','0'))
)
;

INSERT INTO Departamento ( Nombre, Estado) VALUES ( N'Lima', 1);
INSERT INTO Departamento ( Nombre, Estado) VALUES ( N'Amazonas', 1);
INSERT INTO Departamento ( Nombre, Estado) VALUES ( N'Arequipa', 1);
INSERT INTO Departamento ( Nombre, Estado) VALUES ( N'Apurimac', 1);
INSERT INTO Departamento ( Nombre, Estado) VALUES ( N'Ayacucho', 1);
INSERT INTO Departamento ( Nombre, Estado) VALUES ( N'Cajamarca', 1);
INSERT INTO Departamento ( Nombre, Estado) VALUES ( N'Cusco', 1);

-- PARAMETRO TABLE

create table PARAMETRO
(
    PARAMETROID NUMBER(19)  generated as identity primary key,
    CODIGOPADRE varchar2(10),
    CODIGOHIJO  varchar2(10),
    VALOR1      varchar2(100),
    VALOR2      varchar2(100),
    DESCRIPCION varchar2(200),
    ORDEN       number(4),
    ESTADO      CHAR(1) CONSTRAINT CONS_PARAMETRO_ESTADO CHECK (ESTADO IN ('1','0'))
);

INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( N'DOC', null, N'Tipo Documento', null, N'Tipo de Documento', null, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'DOC', null, N'DNI', N'Documento Nacional Identidad', 1, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'DOC', null, N'RUC', N'Registro Unico Contribuyente', 2, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( N'MON', null, N'Tipo Moneda', null, N'Tipo de Moneda', null, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'MON', null, N'SOLES', N'Soles Peruanos', 1, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'MON', null, N'DOLARES', N'Dolares Americanos', 2, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( N'INS', null, N'Tipo Institucion', null, N'Tipo Institucion', null, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'INS', null, N'BANCO', N'Banco - ASBANC', 1, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'INS', null, N'CAJA', N'Caja', 2, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'INS', null, N'COOPERATIVA', N'Cooperativa', 3, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'INS', null, N'OTRO', N'Otro', 4, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( N'TD', null, N'Tipo Producto', null, N'Tipo de Producto Financiero', null, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'TD', null, N'PRESTAMO PERSONAL', N'Prestamo Personal', 1, 1);
INSERT INTO Parametro ( CodigoPadre, CodigoHijo, Valor1, Valor2, Descripcion, Orden, Estado) VALUES ( null, N'TD', null, N'DEPOSITO', N'Deposito a Plazo', 2, 1);

--- PROSPECTO TABLE

create table PROSPECTO
(
    PROSPECTOID     NUMBER(19)  generated as identity primary key,
    Nombres         varchar2(200),
    Apellidos       varchar2(200),
    TipoDocumentoID int,
    NumeroDocumento varchar2(20),
    Email           varchar2(200),
    NumeroCelular   varchar2(20),
    DepartamentoID  NUMBER(19),
    FechaRegistro   TIMESTAMP,
    Activo          char(1)
)
;
 alter table PROSPECTO
  add constraint FK_PROSPECTO_DEPARTAMENTOID
  foreign key (DEPARTAMENTOID)
  references DEPARTAMENTO (DEPARTAMENTOID);

-- entridad financiera table

create table ENTIDADFINANCIERA
(
    ENTIDADFINANCIERAID NUMBER(19)  generated as identity primary key,
    RAZONSOCIAL         varchar2(200),
    NOMBRECOMERCIAL     varchar2(200),
    PATHIMAGEN          varchar2(200),
    TipoInstitucionID   NUMBER(4),
    DepartamentoID      NUMBER(19),
    TipoDocumentoID     NUMBER(4),
    NUMERODOCUMENTO     varchar2(20),
    DIRECCION           varchar2(200),
    TELEFONO            varchar2(20),
    CORREO              varchar2(100),
    PAGINAWEB           varchar2(100),
    USUARIOREGISTRO     varchar2(100),
    FECHAREGISTRO       TIMESTAMP,
    USUARIOMODIFICA     varchar2(100),
    FECHAMODIFICACION   TIMESTAMP,
    ACTIVO              CHAR(1)
);


 alter table ENTIDADFINANCIERA
  add constraint FK_ENTIDADFINANCIERA_DEPARTAMENTOID
  foreign key (DEPARTAMENTOID)
  references DEPARTAMENTO (DEPARTAMENTOID);


---


INSERT INTO EntidadFinanciera ( RazonSocial, NombreComercial, PathImagen, TipoInstitucionID, DepartamentoID, TipoDocumentoID, NumeroDocumento, Direccion, Telefono, Correo, PaginaWeb, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( N'BBVA CONTINENTAL', N'BBVA Continental', N'https://enviotodo.pe/wp-content/uploads/2020/01/logobbva.png', 8, 2, 3, N'000292992', N'Av. Mandamiento - 903 ', N'03939393', N'bbva@gmail.com', null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO EntidadFinanciera ( RazonSocial, NombreComercial, PathImagen, TipoInstitucionID, DepartamentoID, TipoDocumentoID, NumeroDocumento, Direccion, Telefono, Correo, PaginaWeb, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( N'SCOTIABANK', N'Scotiabank', N'https://style.shockvisual.net/wp-content/uploads/2019/05/logo-scotiabank.png', 8, 1, 3, N'39999393933', N'Av. Plaza CC - San Isidro', N'92929202', N'scotiabank@gmail.com', null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO EntidadFinanciera ( RazonSocial, NombreComercial, PathImagen, TipoInstitucionID, DepartamentoID, TipoDocumentoID, NumeroDocumento, Direccion, Telefono, Correo, PaginaWeb, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( N'INTERBANK', N'Interbank', N'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQaIaVxDUfkWpVFOrqFJQhUMXMwVd7AnX4BJg&usqp=CAU', 8, 3, 3, N'93930303', N'Av. Saenz Peña 90 - Malaga', N'393930302', N'interbank@interbank.pe', null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO EntidadFinanciera ( RazonSocial, NombreComercial, PathImagen, TipoInstitucionID, DepartamentoID, TipoDocumentoID, NumeroDocumento, Direccion, Telefono, Correo, PaginaWeb, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( N'BCP', N'Banco Credito Peru', N'https://logovtor.com/wp-content/uploads/2020/03/banco-de-credito-del-peru-bcp-logo-vector.png', 8, 1, 3, N'121312322', N'Av. Saenz Peña #428', N'2323390', N'bancocreditoperu@bcp.com.pe', null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO EntidadFinanciera ( RazonSocial, NombreComercial, PathImagen, TipoInstitucionID, DepartamentoID, TipoDocumentoID, NumeroDocumento, Direccion, Telefono, Correo, PaginaWeb, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( N'MI BANCO ', N'Mi Banco', N'https://www.mibanco.com.pe/repositorioaps/data/1/1/1/zon/zona-logo/images/logo.png', 8, 3, 3, N'393939302', N'AV. Puente Nuevo # 940 - Bellavista', N'22828289', N'mibanco@outlook.pe', null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO EntidadFinanciera ( RazonSocial, NombreComercial, PathImagen, TipoInstitucionID, DepartamentoID, TipoDocumentoID, NumeroDocumento, Direccion, Telefono, Correo, PaginaWeb, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( N'CAJA SULLANA', N'Sullana', N'https://seeklogo.com/images/C/caja-sullana-logo-B67137F998-seeklogo.com.png', 9, 1, 3, N'233030303', N'Av. Nicolas Pierola #890 - Lince', N'7373738', N'cajasullana@hotmail.com', null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO EntidadFinanciera ( RazonSocial, NombreComercial, PathImagen, TipoInstitucionID, DepartamentoID, TipoDocumentoID, NumeroDocumento, Direccion, Telefono, Correo, PaginaWeb, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( N'CAJA DEL SANTA', N'Caja Del Santa', N'https://sevend.pe/images/clientes/caja%20del%20santa.png', 9, 2, 3, N'484849302', N'Av. Mesa Redonda 890', N'2311111', N'cajasanta@gmail.com', null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);


----
create table PRODUCTOFINANCIERO
(
    PRODUCTOFINANCIEROID NUMBER(19)  generated as identity primary key,
    TIPOPRODUCTOID       NUMBER(4),
    ENTIDADFINANCIERAID  NUMBER(19),
    Nombre               varchar2(100),
    Descripcion          varchar2(200),
    PorcentajeTea        decimal(10, 2),
    PorcentajeComision   decimal(10, 2),
    PorcentajeSeguro     decimal(10, 2),
    Observacion          varchar2(500),
    PlazoMinimoMes       INTEGER,
    PlazoMaximoMes       INTEGER,
    PlazoMinimoDia       INTEGER,
    PlazoMaximoDia       INTEGER,
    TieneFondoSeguro     CHAR(1),
    UsuarioRegistro      varchar2(100),
    FechaRegistro        TIMESTAMP,
    UsuarioModifica      varchar2(100),
    FechaModificacion    TIMESTAMP,
    Activo               CHAR(1)
)
;
 alter table PRODUCTOFINANCIERO
  add constraint FK_PRODUCTOFINANCIERO_ENTIDADFINANCIERAID
  foreign key (ENTIDADFINANCIERAID)
  references ENTIDADFINANCIERA (ENTIDADFINANCIERAID);

---

INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 14, 1, N'Deposito BBVA Continental', N'Deposito BBVA Continental Free', 0.19, 0.23, 0.19, N'Deposito BBVA Continental con multiples beneficios', null, null, 60, 1800, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 13, 1, N'Prestamo BBVA Continental', N'Prestamo BBVA Continental Online ', 0.19, 0.19, 1.09, N'Prestamo BBVA Continental con beneficios', 3, 60, null, null, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 14, 2, N'Deposito Scotiabank', N'Deposito Scotiabank Free', 1.20, 0.90, 0.82, N'Deposito Scotiabank con beneficios', null, null, 30, 1600, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 13, 2, N'Prestamo Scotiabank', N'Prestamo Scotiabank Online', 1.20, 1.45, 1.33, N'Prestamo Scotiabank Online - Cero Mantenimiento', 6, 49, null, null, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 13, 3, N'Prestamo Interbank ', N'Prestamo Interbank Online', 0.20, 0.01, 0.02, N'Prestamo Interbank con beneficios clubsueldo', 3, 39, null, null, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 14, 3, N'Deposito Interbank', N'Deposito Interbank Free', 1.29, 1.02, 0.23, N'Deposito Interbank con beneficios', null, null, 30, 1300, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 13, 4, N'Prestamo BCP', N'Prestamo Trabajadores BCP ', 0.90, 0.45, 0.19, N'Prestamo Trabajadpres BCP  - ClubSueldo', 3, 60, null, null, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 14, 4, N'Deposito BCP', N'Deposito BCP', 0.13, 0.34, 0.32, N'Deposito BCP', null, null, 30, 900, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 14, 6, N'Deposito mi banco', N'Deposito club beneficiarios', 0.20, 0.19, 1.20, N'Deposito exclusivo para club Mi Banco', null, null, 30, 410, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);
INSERT INTO ProductoFinanciero ( TipoProductoID, EntidadFinancieraID, Nombre, Descripcion, PorcentajeTea, PorcentajeComision, PorcentajeSeguro, Observacion, PlazoMinimoMes, PlazoMaximoMes, PlazoMinimoDia, PlazoMaximoDia, TieneFondoSeguro, UsuarioRegistro, FechaRegistro, UsuarioModifica, FechaModificacion, Activo) VALUES ( 13, 6, N'Prestamo Mi Banco', N'Prestamo Mi Banco Online', 0.12, 0.13, 0.43, N'Prestamo Mi Banco con beneficios ', 3, 50, null, null, null, N'Farmacias Peruanas', null, N'Farmacias Peruanas', null, 1);


---

create table DetalleProductoFinanciero
(
    DetalleProductoFinancieroID NUMBER(19)  generated as identity primary key,
    ProductoFinancieroID        NUMBER(19),
    TipoMonedaID                INTEGER,
    IngresoPermitido            INTEGER,
    MontoMinimoPrestamo         DECIMAL(10, 2),
    MontoMaximoPrestamo         DECIMAL(10, 2),
    MontoMinimoDeposito         DECIMAL(10, 2),
    MontoMaximoDeposito         DECIMAL(10, 2)
)
;
 alter table DetalleProductoFinanciero
  add constraint FK_DETALLEPRODUCTOFINANCIERO_ProductoFinancieroID
  foreign key (ProductoFinancieroID)
  references PRODUCTOFINANCIERO (ProductoFinancieroID);

---

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 1, 5, null, null, null, 1500.00, 4580.00);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 1, 6, null, null, null, 1400.00, 4200.00);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 1, 6, null, null, null, 1100.00, 4500.00);

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 2, 6, 4000, 1000.00, 99001.00, null, null);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 2, 5, 4000, 1000.00, 10000.00, null, null);

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 3, 6, null, null, null, 1000.00, 79000.00);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 3, 5, null, null, null, 1000.00, 80000.00);

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 4, 5, 500, 1000.00, 8000.00, null, null);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 4, 6, 500, 1000.00, 12000.00, null, null);

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 5, 5, 500, 1000.00, 52000.00, null, null);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 5, 6, 500, 1000.00, 46000.00, null, null);

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 6, 5, null, null, null, 1000.00, 69000.00);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 6, 6, null, null, null, 1000.00, 69000.00);

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 8, 6, null, null, null, 1000.00, 39000.00);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 8, 5, null, null, null, 1000.00, 49000.00);

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 9, 5, null, null, null, 1000.00, 20000.00);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 9, 6, null, null, null, 1000.00, 19000.00);

INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 10, 5, 500, 1000.00, 2000.00, null, null);
INSERT INTO DetalleProductoFinanciero ( ProductoFinancieroID, TipoMonedaID, IngresoPermitido, MontoMinimoPrestamo, MontoMaximoPrestamo, MontoMinimoDeposito, MontoMaximoDeposito) VALUES ( 10, 6, 1000, 1000.00, 48000.00, null, null);