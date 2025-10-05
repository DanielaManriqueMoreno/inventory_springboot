package com.daniela.product_api.model;

import jakarta.persistence.*;

@Entity //Indica que la clase es una entidad persistente(tabla)
@Table(name = "products")  //Especifica el nombre de la tabla en la BD, si no se pone, toma el nombre de la clase
public class Product {
    
    @Id //Indica que el atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Genera el autoincrement usando IDENTITY
    private Long id;

    @Column(nullable = false)  //Especifica que la columna no puede ser nula
    private String name;
    private Double price;
    private Integer stock;
    public Product() {}
    public Product(String name, Double price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters y Setters
    // Estos métodos permiten acceder y modificar los atributos privados de la clase. Get es un metodo quedevuelve el valor de un atributo, su nombre empieza con "get" seguido del nombre del atributo, y cuando alguien quiera consultar el valor de por ejemplo nombre, usara "getNombre()". Set es un metodo que asigna un valor a un atributo, su nombre empieza con "set" seguido del nombre del atributo, y cuando alguien quiera modificar el valor de por ejemplo nombre, usara "setNombre(valor)".

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}
    public Integer getStock() {return stock;}
    public void setStock(Integer stock) {this.stock = stock;}
}
