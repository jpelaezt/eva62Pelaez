package negocio;

import java.util.List;

import DAO.LibroDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import modelo.Libro;

@Stateless
public class GestionLibros {
	
	@Inject
	private LibroDAO daoLibro;
	
	public void guardarLibros(Libro libro) throws Exception {
		//if(this.isCedulaValidate(cliente.getCedula()))
			//throw new Exception("Cedula incorrecta");
		if(daoLibro.read(libro.getId()) == null) {
			try {
				daoLibro.insert(libro);
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Error al insertar "+e.getMessage());
			}
		}else {
			try {
				daoLibro.update(libro);
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Error al actualizar  "+e.getMessage());
			}
		}
	}
	
	public List<Libro> libroList() throws Exception{
		try {
			List<Libro> listaLibros = daoLibro.getall();
			if(listaLibros.isEmpty()) {
				return null;
			}else {
				return listaLibros;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error al listar "+e.getMessage());
		}
	}

}
