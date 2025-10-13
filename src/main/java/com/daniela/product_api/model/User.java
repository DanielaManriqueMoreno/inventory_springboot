package com.daniela.product_api.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity //Indica que la clase es una entidad persistente(tabla)
@Data //Genera getters, setters, toString, equals y hashCode automaticamente
@NoArgsConstructor //Genera un constructor sin argumentos
@AllArgsConstructor //Genera un constructor con todos los argumentos
@Table(name = "users")  //Especifica el nombre de la tabla en la BD, si no se pone, toma el nombre de la clase
public class User {
    @Id //Indica que el atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Genera el autoincrement usando IDENTITY
    private Long id;

    private String username;
    private String password;
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER) //Relacion muchos a muchos, un usuario puede tener muchos roles y un rol puede ser de muchos usuarios, fetch EAGER carga los roles junto con el usuario
    @JoinTable(
        name = "users_roles", //Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "user_id"), //Columna que referencia a la tabla actual
        inverseJoinColumns = @JoinColumn(name = "role_id") //Columna que referencia a la tabla del otro lado de la relacion
    )

    private Set<Role> roles; //Set es una coleccion que no permite elementos duplicados, se usa para evitar que un usuario tenga el mismo rol mas de una vez
}
//Con @Data, Lombok genera automáticamente todos los métodos que necesitas, así que no hay que escribirlos manualmente.