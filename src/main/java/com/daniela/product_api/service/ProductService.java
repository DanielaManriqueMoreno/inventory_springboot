package com.daniela.product_api.service;

import com.daniela.product_api.exception.ResourceNotFoundException;
import com.daniela.product_api.model.Product;
import com.daniela.product_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) { this.repo = repo; }
    public List<Product> list() { return repo.findAll(); }
    public Product getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado: " + id));
    }
    public Product create(Product p) { return repo.save(p); }
    public Product update(Long id, Product p) {
        Product existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado: " + id));
        existing.setName(p.getName());
        existing.setPrice(p.getPrice());
        existing.setStock(p.getStock());
        return repo.save(existing);
    }
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Producto no encontrado: " + id);
        repo.deleteById(id);
    }
}

//La capa de Service está en el medio, entre el Controller y el Repository. Su función es que el controlador no esté lleno de lógica complicada, sino que solo reciba la petición y se la pase al Service.
//El Controller es el mesero → recibe tu orden.
//El Service es el chef → sabe las recetas y cocina (lógica de negocio).
//El Repository es la despensa → guarda los ingredientes (base de datos).
//El Model/Entity es el menú → define qué platos existen (tablas/objetos).