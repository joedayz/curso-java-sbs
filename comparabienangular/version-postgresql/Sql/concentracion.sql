create table departamento
(
    id_departamento int not null constraint departamento_pkey primary key ,
    nombre varchar,
    estado bit
);

create table entidad_financiera
(
    id_entidad_financiera int not null constraint entidad_financiera_pkey primary key ,
    razon_social varchar not null ,
    nombre_comercial varchar,
    path_imagen varchar,
    id_tipo_institucion integer not null,
    id_departamento integer not null constraint
            entidad_financiera_id_departamento_fkey references departamento,
    id_tipo_documento smallint,
    numero_documento varchar,
    direccion varchar,
    telefono varchar,
    correo varchar,
    pagina_web varchar,
    usuario_registro varchar,
    usuario_modifica varchar,
    fecha_registro varchar,
    fecha_modificacion varchar,
    activo bit
);


create table producto_financiero
(
    id_producto_financiero int not null
        constraint producto_financiero_pkey primary key,
    id_entidad_financiera int not null constraint
            producto_financiero_id_entidad_financiera_fkey references entidad_financiera,
    nombre varchar,
    descripcion varchar,
    porcentaje_tea numeric(10,2),
    porcentaje_comision numeric(10,2),
    porcentaje_seguro numeric(10,2),
    observacion varchar,
    plazo_minimo_mes smallint,
    plazo_maximo_mes smallint,
    plazo_minimo_dia smallint,
    plazo_maximo_dia smallint,
    tiene_fondo_seguro bit,
    usuario_registra varchar,
    usuario_modifica varchar,
    fecha_registro varchar,
    fecha_modificacion varchar,
    activo bit,
    id_tipo_producto integer
);

create table detalle_producto_financiero(
    id_detalle_producto_financiero int not null
                                        constraint detalle_producto_financiero_pkey primary key ,
    id_producto_financiero int not null constraint
            detalle_producto_financiero_id_producto_financiero_fkey references producto_financiero,
    monto_maximo_deposito numeric(10,2),
    monto_minimo_deposito numeric(10,2),
    monto_maximo_prestamo numeric(10,2),
    monto_minimo_prestamo numeric(10,2),
    ingreso_permitido integer,
    id_tipo_moneda integer
);


create table opcion(
    id_opcion int not null
        constraint opcion_pkey primary key ,
    nombre varchar not null,
    descripcion varchar,
    path_url varchar,
    icono varchar,
    estado bit,
    orden smallint

);

create table parametro(
        id_parametro int not null
        constraint parametro_pkey primary key ,
        codigo_padre varchar,
        codigo_hijo varchar,
        valor_1 varchar,
        valor_2 varchar,
        descripcion varchar not null,
        orden smallint,
        estado bit
);

