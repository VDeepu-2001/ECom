package com.example.ECom.Service;

import com.example.ECom.model.Review;
import com.example.ECom.repository.ProductRepository;
import com.example.ECom.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product newProduct) {
        Product product = productRepository.findById(newProduct.getProductId()).orElse(null);
        if (product != null) {
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            product.setCreationDate(newProduct.getCreationDate());

            return productRepository.save(newProduct);
        } else {
            return productRepository.save(newProduct);
               }
        }
        public String deleteById(Long reviewId) {
        productRepository.deleteById(reviewId);
        Product product = productRepository.findById(reviewId).orElse(null);
        if (product == null) {
            return "deletion success";
        } else {
            return "deletion failed";
        }
    }
}
