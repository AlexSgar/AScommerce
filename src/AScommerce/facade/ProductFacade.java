package AScommerce.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import AScommerce.model.Product;

@Stateless(name="productFacade")
public class ProductFacade {
	
	@PersistenceContext(unitName = "unit-jee-AScommerce")
	private EntityManager em;
	
	public Product createProduct (String name, String code, String description,Float price, Integer quantityAvaiable){
		Product p = new Product(name, code, description,price,quantityAvaiable);
		em.persist(p);
		return p;
	}
	
	public List<Product> getAllProducts(){
		TypedQuery<Product> q = em.createNamedQuery("findAllProducts",Product.class);	
		List<Product> resultList = q.getResultList();
		return resultList;
		
	}

	public Product findProduct(Long id) {
		return em.find(Product.class, id);
	}

	
	
	
//
//	public void updateProduct(Product product) {
//        em.merge(product);
//	}
//	
//    private void deleteProduct(Product product) {
//        em.remove(product);
//    }
//
//	public void deleteProduct(Long id) {
//        Product product = em.find(Product.class, id);
//        deleteProduct(product);
//	}
	
}
