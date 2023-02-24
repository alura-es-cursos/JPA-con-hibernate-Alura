package br.com.alura.tienda.tests;

import javax.persistence.EntityManager;

import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.util.JPAUtil;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");

	    EntityManager em = JPAUtil.getEntityManager();
	            
	    em.getTransaction().begin();
	    
	    //V1
	    /*
	    em.persist(celulares);
	    celulares.setNombre("LAPTOPS");
	    em.getTransaction().commit();
	    em.close();
	    celulares.setNombre("PANTALLAS");
	    */
	    
	    //V2
	    /*
	    em.persist(celulares);
	    celulares.setNombre("LAPTOPS");
	    em.flush();
	    em.clear();
	    
	    celulares = em.merge(celulares);
	    celulares.setNombre("PANTALLAS");
	    em.flush();
	    em.remove(celulares);
	    */
	    
	    //V3
	    /*
	    em.persist(celulares);
	    celulares.setNombre("LAPTOPS");
	    em.flush();
	    em.clear();
	    
	    celulares = em.merge(celulares);
	    celulares.setNombre("PANTALLAS");
	    em.flush();
	    //em.clear();
	    em.remove(celulares);
	    em.flush();
	    */
	}

}
