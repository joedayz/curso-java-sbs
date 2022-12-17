
CREATE OR REPLACE   VIEW vw_consulta_movimiento as
	SELECT pf.id_producto_financiero,
       pf.nombre,
       pf.fecha_registro,
       ef.id_entidad_financiera,
       ef.nombre_comercial,
       pf.porcentaje_tea,
       p.valor_2                          AS moneda,
       dpf.id_detalle_producto_financiero AS id_detalle,
       dpf.monto_maximo_deposito,
       dpf.monto_maximo_prestamo,
       pf.plazo_maximo_mes,
       pf.activo
FROM producto_financiero pf
         JOIN entidad_financiera ef ON ef.id_entidad_financiera = pf.id_entidad_financiera
         JOIN detalle_producto_financiero dpf ON dpf.id_producto_financiero = pf.id_producto_financiero
         JOIN parametro p ON p.id_parametro = dpf.id_tipo_moneda
;

