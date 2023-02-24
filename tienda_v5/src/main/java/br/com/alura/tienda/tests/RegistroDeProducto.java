package br.com.alura.tienda.tests;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.tienda.dao.CategoriaDao;
import br.com.alura.tienda.dao.ProductoDao;			
import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.modelo.Producto;
import br.com.alura.tienda.util.JPAUtil;

public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtil.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		
		Producto p = productoDao.buscarPorId(1l);
		System.out.println(p.getNombre());
		
		List<Producto> todos = productoDao.buscarTodos();
		todos.forEach(System.out::println);
		
		List<Producto> todosPorNombre = productoDao.buscarPorNombre("Xiaomi");
		todosPorNombre.forEach(System.out::println);
		
		List<Producto> todosPorNombreDeCategoria = productoDao.buscarPorNombreDeCategoria("CELUALRES");
		todosPorNombreDeCategoria.forEach(System.out::println);
		
		BigDecimal precioDeProducto = productoDao.buscarPrecioDeProductoConNombre("Xiaomi Redmi");
		System.out.println("precio de producto: "+ precioDeProducto);
		
		
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		
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
