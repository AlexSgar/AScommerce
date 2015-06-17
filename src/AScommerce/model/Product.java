package AScommerce.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p WHERE p.quantityAvaiable>0")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique=true)
	private String code;
	
	private String description;
	
	@Column(nullable = false)
	private Float price;
	
	@Column(nullable = false)
	private Integer quantityAvaiable;
	
	@Column(nullable = false)
	private String url;
	
	
	@ManyToMany(mappedBy = "products",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Provider> providers;

	
	
	
	public Product(String name, String code, String description,Float price, Integer quantityAvaiable,String url) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
		this.quantityAvaiable = quantityAvaiable;
		this.url=url;
		this.providers = new LinkedList<Provider>();
	}
	
	public Product(String name, String code, String description,Float price, Integer quantityAvaiable,Provider provider,String url){
		this(name, code, description,price,quantityAvaiable,url);
		this.providers.add(provider);
	}
	
	public Product(String name, String code, String description,Float price, Integer quantityAvaiable,List<Provider> providers,String url){
		this(name, code, description,price,quantityAvaiable,url);
		this.providers= providers;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String codice) {
		this.code = codice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrizione) {
		this.description = descrizione;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float prezzo) {
		this.price = prezzo;
	}

	public Integer getQuantityAvaiable() {
		return quantityAvaiable;
	}

	public void setQuantityAvaiable(Integer quantitaDisponibile) {
		this.quantityAvaiable = quantitaDisponibile;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> fornitori) {
		this.providers.addAll(fornitori);
	}
	public void setProvider(Provider fornitore) {
		this.providers.add(fornitore);
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public boolean equals(Object o){
		Product p = (Product)o;
		return this.id==p.getId();
	}

}
