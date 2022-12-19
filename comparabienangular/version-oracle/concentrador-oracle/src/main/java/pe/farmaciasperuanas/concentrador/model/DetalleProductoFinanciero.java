package pe.farmaciasperuanas.concentrador.model;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLEPRODUCTOFINANCIERO")
public class DetalleProductoFinanciero implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETALLEPRODUCTOFINANCIEROID")
	private Long idDelleProductoFinanciero;

	@Column(name="TIPOMONEDAID")
	private Integer idTipoMoneda;
	
	@Column(name="INGRESOPERMITIDO")
	private Integer ingresoPermitido;
	
	@Column(name="MONTOMINIMOPRESTAMO")
	private Integer montoMinimoPrestamo;
	
	@Column(name="MONTOMAXIMOPRESTAMO")
	private Integer montoMaximoPrestamo;
	
	@Column(name="MONTOMINIMODEPOSITO")
	private Integer montoMinimoDeposito;
	
	@Column(name="MONTOMAXIMODEPOSITO")
	private Integer montoMaximoDeposito;
	
	// Equivalente a @JsonIgnore (Spring Boot)
	@JsonbTransient
	@ManyToOne
	@JoinColumn(name = "PRODUCTOFINANCIEROID", nullable = false)
	private ProductoFinanciero productoFinanciero;

	public Long getIdDelleProductoFinanciero() {
		return idDelleProductoFinanciero;
	}

	public void setIdDelleProductoFinanciero(Long idDelleProductoFinanciero) {
		this.idDelleProductoFinanciero = idDelleProductoFinanciero;
	}

	public Integer getIdTipoMoneda() {
		return idTipoMoneda;
	}

	public void setIdTipoMoneda(Integer idTipoMoneda) {
		this.idTipoMoneda = idTipoMoneda;
	}

	public Integer getIngresoPermitido() {
		return ingresoPermitido;
	}

	public void setIngresoPermitido(Integer ingresoPermitido) {
		this.ingresoPermitido = ingresoPermitido;
	}

	public Integer getMontoMinimoPrestamo() {
		return montoMinimoPrestamo;
	}

	public void setMontoMinimoPrestamo(Integer montoMinimoPrestamo) {
		this.montoMinimoPrestamo = montoMinimoPrestamo;
	}

	public Integer getMontoMaximoPrestamo() {
		return montoMaximoPrestamo;
	}

	public void setMontoMaximoPrestamo(Integer montoMaximoPrestamo) {
		this.montoMaximoPrestamo = montoMaximoPrestamo;
	}

	public Integer getMontoMinimoDeposito() {
		return montoMinimoDeposito;
	}

	public void setMontoMinimoDeposito(Integer montoMinimoDeposito) {
		this.montoMinimoDeposito = montoMinimoDeposito;
	}

	public Integer getMontoMaximoDeposito() {
		return montoMaximoDeposito;
	}

	public void setMontoMaximoDeposito(Integer montoMaximoDeposito) {
		this.montoMaximoDeposito = montoMaximoDeposito;
	}

	public ProductoFinanciero getProductoFinanciero() {
		return productoFinanciero;
	}

	public void setProductoFinanciero(ProductoFinanciero productoFinanciero) {
		this.productoFinanciero = productoFinanciero;
	}
	
}
