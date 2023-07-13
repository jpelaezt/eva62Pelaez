package servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import modelo.Libro;
import negocio.GestionLibros;

@Path("libros")
public class GLibrosService {
	
	@Inject
	private GestionLibros glibros;
	
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Libro libro) {
		try {
			glibros.guardarLibros(libro);
			Respuesta error = new Respuesta();
			error.setCodigo(1111);
			error.setMensaje("Cliente creado: " +libro.getNombre());
			return Response.status(Response.Status.OK).entity(error).build();
		}catch(Exception e){
			e.printStackTrace();
			Respuesta error = new Respuesta();
			error.setCodigo(9999);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("ListaLibros")
	@Produces("application/json")
	public List<Libro> libroList() throws Exception{
		List<Libro> listaLibros = glibros.libroList();
		return listaLibros;
	}

}
