package pe.farmaciasperuanas.concentrador.model.views;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_CONSULTA_ENTIDAD_PRODUCTO")
public class ConsultaEntidadProducto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "CONSULTAENTIDADPRODUCTOID")
	private Long idConsultaEntidadProducto;
	
	@Column(name = "PRODUCTOFINANCIEROID")
	private Long idProductoFinanciero;
	
	@Column(name="TIPOPRODUCTOID")
	private Integer idTipoProducto;
	
	@Column(name="TIPOINSTITUCIONID")
	private Integer idTipoInstitucion;
	
	@Column(name="PRODUCTO")
	private String producto;
	
	@Column(name="PATHIMAGEN")
	private String pathImagen;
	
	@Column(name="MONEDAID")
	private Integer idMoneda;
	
	@Column(name="MONEDA")
	private String moneda;
	
	@Column(name="PORCENTAJETEA")
	private Double porcentajeTea;
	
	@Column(name="MONTOMINIMODEPOSITO")
	private Double montoMinimoDeposito;

	@Column(name="MONTOMAXIMODEPOSITO")
	private Double montoMaximoDeposito;
	 
	@Column(name="MONTOMINIMOPRESTAMO")
	private Double montoMinimoPrestamo;
	
	@Column(name="MONTOMAXIMOPRESTAMO")
	private Double montoMaximoPrestamo;
	
	@Column(name="INGRESOPERMITIDO")
	private Integer ingresoPermitido;
	
	@Column(name="PORCENTAJECOMISION")
	private Double porcentajeComision;
	
	@Column(name="PORCENTAJESEGURO")
	private Double porcentajeSeguro;

	@Column(name="PLAZOMINIMODIA")
	private Integer plazoMinimoDia;
	 
	@Column(name="PLAZOMAXIMODIA")
	private Integer plazoMaximoDia;
	
	@Column(name="PLAZOMINIMOMES")
	private Integer plazoMinimoMes;
	
	@Column(name="PLAZOMAXIMOMES")
	private Integer plazoMaximoMes;
	
	@Column(name="DEPARTAMENTOID")
	private Integer idDepartamento;
	
	@Column(name="UBICACION")
	private String ubicacion;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="OBSERVACION")
	private String observacion;

	public Long getIdProductoFinanciero() {
		return idProductoFinanciero;
	}

	public void setIdProductoFinanciero(Long idProductoFinanciero) {
		this.idProductoFinanciero = idProductoFinanciero;
	}

	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public Integer getIdTipoInstitucion() {
		return idTipoInstitucion;
	}

	public void setIdTipoInstitucion(Integer idTipoInstitucion) {
		this.idTipoInstitucion = idTipoInstitucion;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public Integer getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(Integer idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Double getPorcentajeTea() {
		return porcentajeTea;
	}

	public void setPorcentajeTea(Double porcentajeTea) {
		this.porcentajeTea = porcentajeTea;
	}

	public Double getMontoMinimoDeposito() {
		return montoMinimoDeposito;
	}

	public void setMontoMinimoDeposito(Double montoMinimoDeposito) {
		this.montoMinimoDeposito = montoMinimoDeposito;
	}

	public Double getMontoMaximoDeposito() {
		return montoMaximoDeposito;
	}

	public void setMontoMaximoDeposito(Double montoMaximoDeposito) {
		this.montoMaximoDeposito = montoMaximoDeposito;
	}

	public Double getMontoMinimoPrestamo() {
		return montoMinimoPrestamo;
	}

	public void setMontoMinimoPrestamo(Double montoMinimoPrestamo) {
		this.montoMinimoPrestamo = montoMinimoPrestamo;
	}

	public Double getMontoMaximoPrestamo() {
		return montoMaximoPrestamo;
	}

	public void setMontoMaximoPrestamo(Double montoMaximoPrestamo) {
		this.montoMaximoPrestamo = montoMaximoPrestamo;
	}

	public Integer getIngresoPermitido() {
		return ingresoPermitido;
	}

	public void setIngresoPermitido(Integer ingresoPermitido) {
		this.ingresoPermitido = ingresoPermitido;
	}

	public Double getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(Double porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}

	public Double getPorcentajeSeguro() {
		return porcentajeSeguro;
	}

	public void setPorcentajeSeguro(Double porcentajeSeguro) {
		this.porcentajeSeguro = porcentajeSeguro;
	}

	public Integer getPlazoMinimoDia() {
		return plazoMinimoDia;
	}

	public void setPlazoMinimoDia(Integer plazoMinimoDia) {
		this.plazoMinimoDia = plazoMinimoDia;
	}

	public Integer getPlazoMaximoDia() {
		return plazoMaximoDia;
	}

	public void setPlazoMaximoDia(Integer plazoMaximoDia) {
		this.plazoMaximoDia = plazoMaximoDia;
	}

	public Integer getPlazoMinimoMes() {
		return plazoMinimoMes;
	}

	public void setPlazoMinimoMes(Integer plazoMinimoMes) {
		this.plazoMinimoMes = plazoMinimoMes;
	}

	public Integer getPlazoMaximoMes() {
		return plazoMaximoMes;
	}

	public void setPlazoMaximoMes(Integer plazoMaximoMes) {
		this.plazoMaximoMes = plazoMaximoMes;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getIdConsultaEntidadProducto() {
		return idConsultaEntidadProducto;
	}

	public void setIdConsultaEntidadProducto(Long idConsultaEntidadProducto) {
		this.idConsultaEntidadProducto = idConsultaEntidadProducto;
	}

}
