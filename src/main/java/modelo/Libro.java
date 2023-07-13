package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Libro")
public class Libro {
	
	@Id
	@GeneratedValue
	@Column(name = "lib_id")
	private long id;
	@Id
	@Column(name = "lib_nombre")
	private String nombre;
	@Id
	@Column(name = "lib_autor")
	private String autor;
	@Id
	@Column(name = "lib_pais")
	private String pais;
	


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
