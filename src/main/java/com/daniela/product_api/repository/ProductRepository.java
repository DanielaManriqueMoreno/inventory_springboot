package com.daniela.product_api.repository;

import com.daniela.product_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

//JpaRepository es una interfaz de Spring Data JPA que proporciona métodos CRUD automaticamente como findAll() que lista todos los registros, findById(id) que devuelve el registro especifico, save(entity) que inserta y actualiza, deleteById(id) que elimina por id, findAll(Pageable pegeable) que es para la paginacion.