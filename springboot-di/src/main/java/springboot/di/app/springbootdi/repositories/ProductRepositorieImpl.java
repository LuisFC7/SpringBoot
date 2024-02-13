package springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;
import springboot.di.app.springbootdi.models.Product;

@Primary
// @RequestScope
@Repository("productList")
public class ProductRepositorieImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositorieImpl() {

        this.data = Arrays.asList(
            new Product(1L, "Memoria Corsair 32", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer Mini", 180L),
            new Product(4L, "MainBoard Gygabyte", 490L)

        );
    }

    @Override
    public List<Product> findAll(){
        return this.data;
    }

    @Override
    public Product findById(Long id){
        return (Product) data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    
}
