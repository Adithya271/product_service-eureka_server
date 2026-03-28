package com.adit.product_service.service;

import com.adit.product_service.model.Product;
import com.adit.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product create(Product Product) {
        return repository.save(Product);
    }

    public Product update(Long id, Product product) {
        Product existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNama(product.getNama());
            existing.setHarga(product.getHarga());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
