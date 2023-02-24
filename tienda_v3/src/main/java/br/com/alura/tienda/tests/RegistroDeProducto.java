package br.com.alura.tienda.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.tienda.dao.CategoriaDao;
import br.com.alura.tienda.dao.ProductoDao;
import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.modelo.CategoriaEnum;
import br.com.alura.tienda.modelo.Producto;
import br.com.alura.tienda.util.JPAUtil;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		//Producto celular = new Producto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), CategoriaEnum.CELULARES);
		Producto celular = new Producto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

	    EntityManager em = JPAUtil.getEntityManager();
	    ProductoDao produtoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        
	    em.getTransaction().begin();
	    
	    categoriaDao.guardar(celulares);
	    produtoDao.guardar(celular);	
	    
	    em.getTransaction().commit();
	    em.close();
	}

}
