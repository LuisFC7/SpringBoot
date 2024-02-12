package springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;
import springboot.di.app.springbootdi.models.Product;

public class ProductRepositorieImpl {

    private List<Product> data;

    public ProductRepositorieImpl() {

        this.data = Arrays.asList(
            new Product(1L, "Memoria Corsair 32", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer Mini", 180L),
            new Product(4L, "MainBoard Gygabyte", 490L)

        );
    }

    public List<Product> findAll(){

        return this.data;
    }

    public Product findById(Long id){´
        return (Product) data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    
}
