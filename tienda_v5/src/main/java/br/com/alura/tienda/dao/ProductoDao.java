package br.com.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.modelo.Producto;

public class ProductoDao {
	
	private EntityManager em;
	
	public ProductoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	

	public void actualizar(Producto producto) {
		this.em.merge(producto);
	}
	
	public void remover(Producto producto) {
		//this.em.merge(producto);
		producto=em.merge(producto);
		this.em.remove(producto);
	}
	
	public Producto buscarPorId(Long id) {
		return em.find(Producto.class,id);
	}
	
	public List<Producto> buscarTodos(){
		String jpql = "SELECT p FROM Producto p";
		return em.createQuery(jpql,Producto.class).getResultList();
	}
	
	public List<Producto> buscarPorNombre(String nombre){
		String jpql = "SELECT p FROM Producto p WHERE p.nombre=:nombre";
		return em.createQuery(jpql,Producto.class)
				.setParameter("nombre",nombre)
				.getResultList();
	}
	
	public List<Producto> buscarPorNombreDeCategoria(String nombre){
		String jpql = "SELECT p FROM Producto p WHERE p.categoria.nombre=:nombre";
		return em.createQuery(jpql,Producto.class)
				.setParameter("nombre",nombre)
				.getResultList();
	}
	
	public BigDecimal buscarPrecioDeProductoConNombre(String nombre){
		String jpql = "SELECT p.precio FROM Producto p WHERE p.nombre=:nombre";
		return em.createQuery(jpql,BigDecimal.class)
				.setParameter("nombre",nombre)
				.getSingleResult();
	}
}
