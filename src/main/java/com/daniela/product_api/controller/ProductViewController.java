package com.daniela.product_api.controller;

import com.daniela.product_api.model.Product;
import com.daniela.product_api.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //indica que esta clase maneja peticiones web y devuelve vistas
@RequestMapping("/products") //Todas las rutas tendran este prefijo
public class ProductViewController {
    private final ProductRepository repo;//Es el acceso a la base de datos

    public ProductViewController(ProductRepository repo) {
        this.repo = repo;
    }
    
    //LISTAR productos
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", repo.findAll()); //atrae de la base de datos todos los productos
        return "products/list"; // buscará templates/products/list.html
    }

    //FORMULARIO CREAR
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/create"; // buscará templates/products/create.html
    }

    @PostMapping
    public String create(@ModelAttribute Product product) {
        repo.save(product);
        return "redirect:/products";
    }

    // 3. FORMULARIO EDITAR
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        model.addAttribute("product", product);
        return "products/edit"; // buscará templates/products/edit.html
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        repo.save(product);
        return "redirect:/products";
    }

    // 4. ELIMINAR
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/products";
    }
}
