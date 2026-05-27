#LevelUp Arcade - Sistema de Gestión

Este proyecto es una aplicación de consola desarrollada en **Java** para la gestión de usuarios y puntuaciones de una plataforma de juegos Arcade. La aplicación sigue los estándares profesionales de arquitectura de software.

##Tecnologías Utilizadas
* **Lenguaje:** Java 17 (o la versión que uses)
* **Base de Datos:** MySQL corriendo en **Ubuntu Server**
* **Conectividad:** JDBC (MySQL Connector/J)
* **Control de Versiones:** Git & GitHub

##Arquitectura del Proyecto
El proyecto implementa el **Patrón DAO (Data Access Object)** y la estructura **MVC (Modelo-Vista-Controlador)** para garantizar un código limpio y mantenible:

* **Modelo (`usuarios.model`):** Contiene los POJOs (entidades de datos).
* **Vista (`usuarios.view`):** Gestión de la interfaz de usuario por consola.
* **Controlador (`usuarios.controller`):** Orquestador de la lógica entre la vista y los datos.
* **DAO (`usuarios.dao`):** Implementación de las operaciones CRUD (Create, Read, Update, Delete) en la base de datos.

##Funcionalidades
- [x] Registro de nuevos jugadores.
- [x] Listado completo de usuarios.
- [x] Modificación de perfiles existentes.
- [x] Eliminación de usuarios del sistema.

##Requisitos Previos
1. Tener configurado el servidor **Ubuntu Server** con MySQL.
2. Ejecutar el script SQL incluido para crear las tablas.
3. Configurar la IP del servidor en la clase `DatabaseConnection.java`.

---
Desarrollado por: [Elena Arnaus Mirones]
