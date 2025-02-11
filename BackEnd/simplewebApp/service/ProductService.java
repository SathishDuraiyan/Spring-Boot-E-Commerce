package com.example.simplewebApp.service;

import com.example.simplewebApp.model.Product;
import com.example.simplewebApp.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Component
public class ProductService{
    @Autowired
    ProductRep repo;
//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101,"Laptop",50000), 
//            new Product(102,"mouse",600)
//    ));
    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId)
                .orElse(new Product(100,"No Item",0));
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
