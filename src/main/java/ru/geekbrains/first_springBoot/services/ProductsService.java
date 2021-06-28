package ru.geekbrains.first_springBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.first_springBoot.exception.NotProductByID;
import ru.geekbrains.first_springBoot.models.Product;
import ru.geekbrains.first_springBoot.repository.ProductsReposytory;

import java.util.List;
import java.util.Optional;

@Component
public class ProductsService {
    private ProductsReposytory products;

    @Autowired
    public ProductsService(ProductsReposytory products) {
        this.products = products;
    }

    public List<Product> getAll(){
        return this.products.get();
    }

    public Product findByID(long id){
        Optional<Product> res = this.products.findByID(id);
        return res.orElseThrow(()-> new NotProductByID(id));
    }
    public long size(){
        return this.products.get().size();
    }
    public void addProduct(Product p){
        this.products.add(p);
    }
}
