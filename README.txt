# 🛍️ Product API - Sistema de Gestión de Productos

Este proyecto es una aplicación web desarrollada con **Spring Boot** que permite **gestionar productos** (crear, listar, editar y eliminar), utilizando **Thymeleaf** para las vistas y **MySQL** como base de datos.  
Además, está preparada para **consumir APIs externas** (por ejemplo, de productos tecnológicos) y comparar esos datos con los almacenados localmente.

---

## Tecnologías utilizadas

| Tecnología | Descripción |
|-------------|-------------|
| **Java 21** | Lenguaje de programación principal. |
| **Spring Boot 3.5.6** | Framework para construir aplicaciones web rápidamente. |
| **Spring Data JPA** | Permite mapear clases Java a tablas en la base de datos (ORM con Hibernate). |
| **Thymeleaf** | Motor de plantillas HTML para crear vistas dinámicas. |
| **Spring Web / MVC** | Permite crear controladores y manejar rutas HTTP. |
| **Spring WebFlux** | Usado para consumir APIs externas con `WebClient`. |
| **MySQL** | Base de datos principal del proyecto. |
| **H2** | Base de datos en memoria usada para pruebas. |
| **Bootstrap 5** | Framework CSS para el diseño visual de las vistas. |

---

## Estructura del proyecto
src/
├── main/
│ ├── java/com/daniela/product_api/
│ │ ├── controller/ → Controladores web (manejan las rutas y vistas)
│ │ ├── model/ → Clases de entidad (Product, etc.)
│ │ ├── repository/ → Interfaces que acceden a la base de datos
│ │ ├── service/ → Lógica de negocio y conexión con APIs externas
│ │ └── ProductApiApplication.java → Clase principal que arranca la app
│ └── resources/
│ ├── templates/ → Archivos HTML de Thymeleaf
│ │ ├── products/ → Vistas de productos (list, create, edit)
│ │ └── alerts/ → Vistas de alertas (comparación con API externa)
│ ├── static/ → Archivos estáticos (CSS, JS, imágenes)
│ └── application.properties → Configuración de la base de datos
└── test/ → Pruebas unitarias y de integración


---

## Configuración

En el archivo `src/main/resources/application.properties`, debes definir la conexión a MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_api
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

🔸 ddl-auto=update permite que las tablas se creen o actualicen automáticamente según las entidades Java.
🔸 show-sql=true muestra en consola las consultas SQL ejecutadas por Hibernate.

## Dependencias principales

Estas son las librerías más importantes incluidas en el archivo pom.xml:

Dependencia |	Función
spring-boot-starter-web |	Permite crear controladores y manejar peticiones HTTP.
spring-boot-starter-data-jpa  |	Conecta con la base de datos y maneja entidades JPA.
spring-boot-starter-thymeleaf	| Permite crear vistas HTML dinámicas.
spring-boot-starter-validation  |	Agrega validaciones automáticas a los formularios.
spring-boot-starter-webflux	 | Permite consumir APIs externas con WebClient.
mysql-connector-j |	Controlador para conectar con MySQL.
h2 |	 Base de datos en memoria para pruebas.

## Cómo ejecutar el proyecto

-Clona el repositorio o descarga el código fuente.
-Asegúrate de tener MySQL y Maven instalados.
-Crea una base de datos llamada product_api.
En la raíz del proyecto, ejecuta:

mvn clean install
mvn spring-boot:run

Abre el navegador y entra en:
http://localhost:8080/products

## Autora
Daniela Manrique
Proyecto desarrollado con fines de aprendizaje en Spring Boot y APIs REST.