package pe.farmaciasperuanas.concentrador.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENTIDADFINANCIERA")
public class EntidadFinanciera implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENTIDADFINANCIERAID")
	private Long idEntidadFinanciera;

	@Column(name="RAZONSOCIAL")
	private String razonSocial;
	
	@Column(name="NOMBRECOMERCIAL")
	private String nombreComercial;
	 
	@Column(name="PATHIMAGEN")
	private String pathImagen;
	 
	@Column(name="TIPOINSTITUCIONID")
	private Integer idTipoInstitucion;
	
	@Column(name="DEPARTAMENTOID")
	private Integer idTipoDocumento;
	
	@Column(name="NUMERODOCUMENTO")
	private String numeroDocumento;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="CORREO")
	private String correo;
	
	@Column(name="PAGINAWEB")
	private String paginaWeb;
	
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
	
	@ManyToOne
	@JoinColumn(name = "DEPARTAMENTOID")
	private Departamento departamento;

	public Long getIdEntidadFinanciera() {
		return idEntidadFinanciera;
	}

	public void setIdEntidadFinanciera(Long idEntidadFinanciera) {
		this.idEntidadFinanciera = idEntidadFinanciera;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public Integer getIdTipoInstitucion() {
		return idTipoInstitucion;
	}

	public void setIdTipoInstitucion(Integer idTipoInstitucion) {
		this.idTipoInstitucion = idTipoInstitucion;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
