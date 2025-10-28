package com.examly.springdemo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.examly.springdemo.exception.ResourceNotFoundException;
import com.examly.springdemo.model.Product;
import com.examly.springdemo.model.User;
import com.examly.springdemo.repository.ProductRepository;
import com.examly.springdemo.repository.UserRepository;
import com.examly.springdemo.util.ImageUtils;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public Product saveProduct(int userId, Product product) throws IOException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        // Decode and save image if Base64 data present
        if (product.getCoverImage() != null && product.getCoverImage().startsWith("data:image")) {
            String fileName = ImageUtils.saveBase64Image(product.getCoverImage(), uploadDir);
            product.setCoverImage(fileName);
        }

        product.setUser(user);
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(int productId) throws IOException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        // Convert stored image file name back to Base64
        if (product.getCoverImage() != null) {
            String filePath = uploadDir + "/" + product.getCoverImage();
            File imageFile = new File(filePath);
            if (imageFile.exists()) {
                String base64Image = ImageUtils.encodeImageToBase64(imageFile);
                product.setCoverImage(base64Image);
            }
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        productRepository.delete(product);
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setOrigin(product.getOrigin());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setCoverImage(product.getCoverImage());
        productRepository.save(existingProduct);
        return existingProduct;
    }
}
