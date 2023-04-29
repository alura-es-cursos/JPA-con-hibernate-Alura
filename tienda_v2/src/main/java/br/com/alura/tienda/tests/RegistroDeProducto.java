package br.com.alura.tienda.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.tienda.modelo.Producto;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Producto celular= new Producto();
		celular.setNombre("Xiaomi Redmi");
		celular.setDescripcion("Muy Bueno");
		celular.setPrecio(new BigDecimal("800"));

		EntityManagerFactory factory = Persistence.
		        createEntityManagerFactory("tienda");

	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(celular);
	    em.getTransaction().commit();
	    em.close();
	}

}
