package ru.geekbrains.first_springBoot.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.first_springBoot.models.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductsReposytory {
    private List<Product> werehouse;

    @PostConstruct
    public void init() {
        Random r = new Random();
        this.werehouse = new ArrayList();
        for (int i = 0; i < 10; i++) {
            this.werehouse.add(new Product(i, "Product_" + i, 100 + (10 * r.nextDouble())));
        }
    }

    public List<Product> get() {
        return Collections.unmodifiableList(werehouse);
    }

    public void add(Product p){
        this.werehouse.add(p);
    }


    public Optional<Product> findByID(long id) {
        for (Product p : this.werehouse) {
            if (p.getId()==id){
                return Optional.of(p);
            }
        }
        return Optional.ofNullable(null);
    }
}
