# CRUD de Empleados con Spring Boot y Thymeleaf

Este es un proyecto de demostración de una aplicación web CRUD (Crear, Leer, Actualizar, Eliminar) de empleados desarrollada con Spring Boot y Thymeleaf.

## Características

*   Listar empleados con paginación y ordenamiento.
*   Agregar nuevos empleados.
*   Actualizar la información de los empleados existentes.
*   Eliminar empleados.
*   Inicio de sesión de usuario y registro con verificación por correo electrónico.

## Tecnologías Utilizadas

*   **Framework:** Spring Boot 3.1.5
*   **Lenguaje de Programación:** Java 17
*   **Motor de Plantillas:** Thymeleaf
*   **Persistencia de Datos:** Spring Data JPA (Hibernate)
*   **Base de Datos:** PostgreSQL
*   **Seguridad:** Spring Security
*   **Dependencias:**
    *   `spring-boot-starter-data-jpa`
    *   `spring-boot-starter-thymeleaf`
    *   `spring-boot-starter-web`
    *   `spring-boot-starter-security`
    *   `spring-boot-starter-mail`
    *   `postgresql`
    *   `lombok`

## Configuración del Entorno Local

### Prerrequisitos

*   JDK 17 o superior.
*   Maven 3.2 o superior.
*   Una base de datos PostgreSQL en ejecución.

### Pasos

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/tu-usuario/CRUD_Empleados_SENA.git
    ```
2.  **Configurar la base de datos:**
    *   Cree una base de datos en PostgreSQL.
    *   Actualice el archivo `src/main/resources/application.properties` con la URL de su base de datos, el nombre de usuario y la contraseña.
3.  **Configurar el correo electrónico:**
    *   Actualice el archivo `src/main/resources/application.properties` con la configuración de su servidor de correo.
4.  **Ejecutar la aplicación:**
    ```bash
    mvn spring-boot:run
    ```
    La aplicación estará disponible en `http://localhost:8080`.

## Despliegue

Esta aplicación está configurada para ser desplegada en [Render](https://render.com/) utilizando una base de datos PostgreSQL. Las variables de entorno `JDBC_DATABASE_URL`, `JDBC_DATABASE_USERNAME` y `JDBC_DATABASE_PASSWORD` se utilizan para configurar la conexión a la base de datos en el entorno de producción.
