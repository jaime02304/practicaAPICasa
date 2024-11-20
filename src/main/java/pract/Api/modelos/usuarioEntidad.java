package pract.Api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class usuarioEntidad {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long idUsuario;

	@Column(name = "nombreUsuario")
	private String nombreUsuario;

	@Column(name = "apellidoUsuario")
	private String apellidoUsuario;

	@Column(name = "correoUsuario", unique = true, nullable = false)
	private String correoUsuario;

	@Column(name = "contraseniaUsuario")
	private String contraseniaUsuario;

	@Column(name = "dniUsuario", unique = true)
	private String dniUsuario;

	@Column(name = "esAdmin")
	private Boolean esAdmin;

	@Lob // Usado para tipos grandes como imágenes
	@Column(name = "imagenUsuario")
	private byte[] imagenUsuario; // Imagen como array de bytes

	@Column(name = "Direccion")
	private String direccion;

	@Column(name = "Alias")
	private String alias;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getContraseniaUsuario() {
		return contraseniaUsuario;
	}

	public void setContraseniaUsuario(String contraseniaUsuario) {
		this.contraseniaUsuario = contraseniaUsuario;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public Boolean getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(Boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public byte[] getImagenUsuario() {
		return imagenUsuario;
	}

	public void setImagenUsuario(byte[] imagenUsuario) {
		this.imagenUsuario = imagenUsuario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
