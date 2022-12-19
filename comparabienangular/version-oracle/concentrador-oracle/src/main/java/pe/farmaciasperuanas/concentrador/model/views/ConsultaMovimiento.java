package pe.farmaciasperuanas.concentrador.model.views;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_CONSULTA_MOVIMIENTO")
public class ConsultaMovimiento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DETALLEID")
	private Long idDetalle;
	
	@Column(name = "PRODUCTOFINANCIEROID")
	private Integer idProductoFinanciero;

	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="ENTIDADFINANCIERAID")
	private Integer idEntidadFinanciera;
	 
	@Column(name="FECHAREGISTRO")
	private String fechaRegistro;
	
	@Column(name="NOMBRECOMERCIAL")
	private String nombreComercial;
	
	@Column(name="PORCENTAJETEA")
	private Double porcentajeTea;
	 
	@Column(name="MONEDA")
	private String moneda;
	
	@Column(name="MONTOMAXIMODEPOSITO")
	private Double montoMaximoDeposito;
	
	@Column(name="MONTOMAXIMOPRESTAMO")
	private Double montoMaximoPrestamo;
	
	@Column(name="PLAZOMAXIMOMES")
	private Integer plazoMaximoMes;
	
	@Column(name="ACTIVO")
	private Boolean activo;

	public Integer getIdProductoFinanciero() {
		return idProductoFinanciero;
	}

	public void setIdProductoFinanciero(Integer idProductoFinanciero) {
		this.idProductoFinanciero = idProductoFinanciero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Double getPorcentajeTea() {
		return porcentajeTea;
	}

	public void setPorcentajeTea(Double porcentajeTea) {
		this.porcentajeTea = porcentajeTea;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Double getMontoMaximoDeposito() {
		return montoMaximoDeposito;
	}

	public void setMontoMaximoDeposito(Double montoMaximoDeposito) {
		this.montoMaximoDeposito = montoMaximoDeposito;
	}

	public Double getMontoMaximoPrestamo() {
		return montoMaximoPrestamo;
	}

	public void setMontoMaximoPrestamo(Double montoMaximoPrestamo) {
		this.montoMaximoPrestamo = montoMaximoPrestamo;
	}

	public Integer getPlazoMaximoMes() {
		return plazoMaximoMes;
	}

	public void setPlazoMaximoMes(Integer plazoMaximoMes) {
		this.plazoMaximoMes = plazoMaximoMes;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getIdEntidadFinanciera() {
		return idEntidadFinanciera;
	}

	public void setIdEntidadFinanciera(Integer idEntidadFinanciera) {
		this.idEntidadFinanciera = idEntidadFinanciera;
	}

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}
	
	
}
