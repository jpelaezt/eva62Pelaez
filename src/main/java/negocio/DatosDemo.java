package negocio;

import java.util.List;

import DAO.LibroDAO;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import modelo.Libro;

@Singleton
@Startup
public class DatosDemo {
	
	@Inject
	private LibroDAO daoLibro;
	
	@PostConstruct
	public void init() {
		System.out.println("Prueba CRUD libro");
		
		Libro l = new Libro();
		l.setId("aaaa1");
		l.setNombre("Historia");
		l.setAutor("Jonnathan");
		l.setPais("Ecuador");
		daoLibro.insert(l);
		
		List<Libro> listaClientes = daoLibro.getall();
		System.out.println("Total registros " + listaClientes.size());
		//Listamos todos los clientes
		for (int i = 0; i < listaClientes.size(); i++) {
		     System.out.println("CLIENTE "+(i+1)+" id "+listaClientes.get(i).getId()+" NOMBRE "+listaClientes.get(i).getNombre()+ " AUTOR "+listaClientes.get(i).getAutor()); 
		}
	}
	
	
	
	

}
