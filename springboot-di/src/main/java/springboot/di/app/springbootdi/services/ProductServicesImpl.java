package springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import springboot.di.app.springbootdi.models.Product;
import springboot.di.app.springbootdi.repositories.ProductRepositorieImpl;

public class ProductServicesImpl {

    private ProductRepositorieImpl repository = new ProductRepositorieImpl();

    public List<Product> findAll(){
        
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            // Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
            // p.setPrice(priceImp.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){

        return repository.findById(id);
    }
}
