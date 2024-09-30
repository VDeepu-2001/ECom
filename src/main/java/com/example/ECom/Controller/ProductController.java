package com.example.ECom.Controller;

import com.example.ECom.Service.ProductService;
import com.example.ECom.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

        @PutMapping("/Products")
        public Product updateProduct(@RequestBody Product newProduct) {
//            Product product = productRepository.findById(id).orElse(null);
//            if (product != null) {
//                product.setProductName(newProduct.getProductName());
//                product.setDescription(newProduct.getDescription());
//                product.setPrice(newProduct.getPrice());
//                product.setCreationDate(newProduct.getCreationDate());
//                //Use the save method to update the product in the database
                return productService.updateProduct(newProduct);
//            }
//            return null;
        }

        @DeleteMapping("/products")
        public String deleteProduct(@RequestBody Long Id) {
        return productService.deleteById(Id);
        }
}
