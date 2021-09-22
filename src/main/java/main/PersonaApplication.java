package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import entities.Autor;
import entities.Domicilio;
import entities.Libro;
import entities.Localidad;
import entities.Persona;

public class PersonaApplication {
		public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Autor autor = Autor.builder()
					.nombre("Gabriel")
					.apellido("García")
					.biografia("Vida de autor")
					.build();
			
			Libro libro = Libro.builder()
					.fecha(0)
					.genero("drama")
					.paginas(24)
					.titulo("Cien años de soledad")
					.build();
			
			Localidad localidad = Localidad.builder()
					.denominacion("carrodilla")
					.build();
			
			Domicilio domicilio = Domicilio.builder()
					.calle("Cobos")
					.numero(5812)
					.localidad(localidad)
					.build();
			
			Persona persona = Persona.builder()
					.apellido("Guiñazu")
					.nombre("Exequiel")
					.dni(38415474)
					.domicilio(domicilio)
					.build();
			
			libro.getAutores().add(autor);
			persona.getLibros().add(libro);
			
			em.persist(autor);
			em.persist(libro);
			em.persist(localidad);
			em.persist(domicilio);
			em.persist(persona);
			em.flush();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			JOptionPane.showConfirmDialog(null, e);
		}
		em.close();
		emf.close();
	}
}
