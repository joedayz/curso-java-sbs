package pe.farmaciasperuanas.concentrador.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTOFINANCIERO")
public class ProductoFinanciero implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCTOFINANCIEROID")
	private Long idProductoFinanciero;

	@Column(name="TIPROPRODUCTOID")
	private Integer idTipoProducto;
	
	@Column(name="ENTIDADFINANCIERAID")
	private Integer idEntidadFinanciera;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="PORCENTAJETEA")
	private Double porcentajeTea;
	
	@Column(name="PORCENTAJECOMISION")
	private Double porcentajeComision;
	
	@Column(name="porcentaje_seguro")
	private Double porcentajeSeguro;
	
	@Column(name="OBSERVACION")
	private String observacion;
	
	@Column(name="PLAZOMINIMOMES")
	private Integer plazoMinimoMes;
	
	@Column(name="PLAZOMAXIMOMES")
	private Integer plazoMaximoMes;
	
	@Column(name="PLAZOMINIMODIA")
	private Integer plazoMinimoDia;
	
	@Column(name="PLAZOMAXIMODIA")
	private Integer plazoMaximoDia;
	
	@Column(name="TIENEFONDOSEGURO")
	private Boolean tieneFondoSeguro;
	
	@Column(name="USUARIOREGISTRO", updatable = false)
	private String usuarioRegistro;
	
	@Column(name="USUARIOMODIFICA")
	private String usuarioModifica;
	
	@Column(name="FECHAREGISTRO", updatable = false)
	private String fechaRegistro;
	
	@Column(name="FECHAMODIFICACION")
	private String fechaModificacion;
	
	@Column(name="ACTIVO")
	private Boolean activo;
	
	@OneToMany(mappedBy = "productoFinanciero", cascade = {CascadeType.ALL}, orphanRemoval = true)
	private Set<DetalleProductoFinanciero> detalleProducto;

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

	public Integer getIdEntidadFinanciera() {
		return idEntidadFinanciera;
	}

	public void setIdEntidadFinanciera(Integer idEntidadFinanciera) {
		this.idEntidadFinanciera = idEntidadFinanciera;
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

	public Double getPorcentajeTea() {
		return porcentajeTea;
	}

	public void setPorcentajeTea(Double porcentajeTea) {
		this.porcentajeTea = porcentajeTea;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Boolean getTieneFondoSeguro() {
		return tieneFondoSeguro;
	}

	public void setTieneFondoSeguro(Boolean tieneFondoSeguro) {
		this.tieneFondoSeguro = tieneFondoSeguro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Set<DetalleProductoFinanciero> getDetalleProducto() {
		return detalleProducto;
	}

	public void setDetalleProducto(Set<DetalleProductoFinanciero> detalleProducto) {
		this.detalleProducto = detalleProducto;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
