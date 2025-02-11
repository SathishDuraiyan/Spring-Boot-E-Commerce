package com.example.javaproject.service;

import java.io.IOException;
import java.util.List;

import com.example.javaproject.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.javaproject.model.Product;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    @Transactional
        public List<Product> getAllProducts() {
            return  repo.findAll();
    }
    public Product addProduct(Product prod, MultipartFile imageFile) throws IOException {
        try {
            prod.setImageName(imageFile.getOriginalFilename());
            prod.setImageType(imageFile.getContentType());
            prod.setImageData(imageFile.getBytes());
            return repo.save(prod);
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
            return null;
        }
    }
        public Product updateProducts(int id,Product prod,MultipartFile imageFile) throws IOException {
        prod.setImageData(imageFile.getBytes());
        prod.setImageName(imageFile.getOriginalFilename());
        prod.setImageType(imageFile.getContentType());
        return repo.save(prod);
        }

        public Product getProduct(int prodId) {
            return repo.findById(prodId).orElse(null);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
