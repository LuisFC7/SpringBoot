package springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import springboot.di.app.springbootdi.models.Product;
import springboot.di.app.springbootdi.repositories.ProductRepository;


@Service
public class ProductServicesImpl implements ProductService{

    @Autowired
    private Environment environment;
    private ProductRepository repository;

    public ProductServicesImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            // Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
            // p.setPrice(priceImp.longValue());
            // Product newProd = (Product) p.clone();
            // newProd.setPrice(priceTax.longValue());
            p.setPrice(priceTax.longValue());
            return p;
            // return newProd;
        }).collect(Collectors.toList());
    }


    @Override
    public Product findById(Long id){

        return repository.findById(id);
    }



    
}
