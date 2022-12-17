CREATE OR REPLACE  VIEW vw_consulta_entidad_producto
 AS SELECT pf.id_producto_financiero,
       pf.id_tipo_producto,
       ef.id_tipo_institucion,
       ef.nombre_comercial                AS producto,
       ef.path_imagen,
        pa.id_parametro                    AS id_moneda,
       pa.valor_2                         AS moneda,
       pf.porcentaje_tea,
       dpf.id_detalle_producto_financiero AS id_consulta_entidad_producto,
       dpf.monto_minimo_deposito,
       dpf.monto_maximo_deposito,
       dpf.monto_minimo_prestamo,
       dpf.monto_maximo_prestamo,
       dpf.ingreso_permitido,
       pf.porcentaje_comision,
       pf.porcentaje_seguro,
       pf.plazo_minimo_dia,
       pf.plazo_maximo_dia,
       pf.plazo_minimo_mes,
       pf.plazo_maximo_mes,
       pf.nombre,
       pf.descripcion,
       pf.observacion,
       de.id_departamento,
       de.nombre                          AS ubicacion

FROM producto_financiero pf
         JOIN entidad_financiera ef ON ef.id_entidad_financiera = pf.id_entidad_financiera
         JOIN detalle_producto_financiero dpf ON dpf.id_producto_financiero = pf.id_producto_financiero
         JOIN parametro pa ON pa.id_parametro = dpf.id_tipo_moneda
         JOIN departamento de ON de.id_departamento = ef.id_departamento;