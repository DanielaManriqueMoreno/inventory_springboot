package com.daniela.product_api.controller;

import com.daniela.product_api.model.Product;
import com.daniela.product_api.repository.ProductRepository;
import com.daniela.product_api.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;

    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping //Listar todos los productos
    public List<Product> list() { return repo.findAll(); }

    @GetMapping("/{id}") //Obtener un producto por su ID
    public Product getById(@PathVariable Long id) {
    return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado: " + id));
    }

    @PostMapping  //recibe JSON (@RequestBody) lo persiste con save() y retorna 201 Created con la ubicación del recurso
    public ResponseEntity<Product> create(@RequestBody Product p) {
    Product saved = repo.save(p);
    return ResponseEntity.created(URI.create("/api/products/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}") //busca el producto por id, si existe actualiza sus campos y lo guarda
    public Product update(@PathVariable Long id, @RequestBody Product p) {
    Product existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado: " + id));
    existing.setName(p.getName());
    existing.setPrice(p.getPrice());
    existing.setStock(p.getStock());
    return repo.save(existing);
    }

    @DeleteMapping("/{id}")  //verifica existencia y elimina, retorna 204 No Content
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    if (!repo.existsById(id)) throw new ResourceNotFoundException("Producto no encontrado: " + id);
    repo.deleteById(id);
    return ResponseEntity.noContent().build();
    }
}

//Para validar entradas, añade @Valid y anotaciones como @NotBlank, @Min en la entidad y maneja MethodArgumentNotValidException. En producción deberías proteger endpoints con Spring Security.