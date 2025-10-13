package com.daniela.product_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity //Indica que la clase es una entidad persistente(tabla)
@Data //Genera getters, setters, toString, equals y hashCode automaticamente
@NoArgsConstructor //Genera un constructor sin argumentos
@AllArgsConstructor //Genera un constructor con todos los argumentos
@Table(name = "roles")  //Especifica el nombre de la tabla en la BD, si no se pone, toma el nombre de la clase
public class Role {
    @Id //Indica que el atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Genera el autoincrement usando IDENTITY
    private Long id;
    private String name; 
}

//Con @Data, Lombok genera automáticamente todos los métodos que necesitas, así que no hay que escribirlos manualmente
