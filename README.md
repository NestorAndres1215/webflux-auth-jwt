# WebFlux Auth JWT

## Descripción
Este proyecto es una **API reactiva** construida con **Spring WebFlux**, **R2DBC** y **MySQL**, que implementa **autenticación con JWT**.  
Permite registrar usuarios, iniciar sesión y proteger endpoints usando tokens JWT de manera totalmente reactiva.  
El proyecto incluye documentación de endpoints y manejo de roles, siendo ideal como base para aplicaciones web modernas y seguras.

---

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring WebFlux** – programación reactiva
- **Spring Security** – autenticación y autorización
- **R2DBC (Reactive Relational Database Connectivity)** – acceso reactivo a MySQL
- **MySQL** – base de datos relacional
- **JWT (JSON Web Tokens)** – manejo de tokens para autenticación
- **Maven** – gestión de dependencias
- **Lombok** – generación automática de getters/setters


---

## Dependencias principales

En `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot WebFlux -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>

    <!-- Spring Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- R2DBC MySQL -->
    <dependency>
        <groupId>io.asyncer</groupId>
        <artifactId>r2dbc-mysql</artifactId>
        <version>0.9.4</version>
    </dependency>

    <!-- Spring Data R2DBC -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-r2dbc</artifactId>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
