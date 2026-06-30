
# ☕ CampusCafe Backend

Sistema Backend desarrollado bajo una arquitectura de **Microservicios** para la gestión integral de una cafetería universitaria. El proyecto permite administrar clientes, productos, categorías, pedidos, pagos, inventario, sucursales, empleados y reportes mediante servicios independientes comunicados a través de un API Gateway.

---

# 👥 Integrantes

- Juan David Motaban
- Benjamín Salas
- Lukas Avendaño

---

# 🏗️ Arquitectura

El proyecto está basado en una arquitectura de microservicios utilizando **Spring Boot**, donde cada servicio posee su propia responsabilidad y puede ejecutarse de forma independiente.

## Microservicios

- API Gateway
- Cliente Service
- Producto Service
- Categoría Service
- Pedido Service
- Detalle Pedido Service
- Pago Service
- Inventario Service
- Sucursal Service
- Empleado Service
- Reporte Service

---

# 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Cloud Gateway
- Maven
- MySQL
- Docker
- Swagger / OpenAPI
- HATEOAS
- Git & GitHub

---

# 📂 Estructura del proyecto

```
CampusCafe Backend
│
├── api-gateway
├── cliente-service
├── producto-service
├── categoria-service
├── pedido-service
├── detalle-pedido-service
├── pago-service
├── inventario-service
├── sucursal-service
├── empleado-service
└── reporte-service
```

---

# ⚙️ Funcionalidades

- Gestión de clientes
- Gestión de productos
- Administración de categorías
- Administración de inventario
- Gestión de sucursales
- Gestión de empleados
- Registro de pedidos
- Detalle de pedidos
- Gestión de pagos
- Generación de reportes
- Documentación de API con Swagger
- Navegación mediante HATEOAS

---

# ▶️ Cómo ejecutar el proyecto

## 1. Clonar el repositorio

```bash
git clone https://github.com/usuario/CampusCafe_Backend.git
```

## 2. Abrir el proyecto

Puede abrirse con:

- IntelliJ IDEA
- 
## 3. Configurar la Base de Datos

Modificar el archivo:

```
application.properties
```

con las credenciales correspondientes de MySQL.

## 4. Ejecutar los microservicios

Cada microservicio puede iniciarse mediante:

```bash
mvn spring-boot:run
```

o ejecutando la clase principal de Spring Boot desde el IDE.

---

# 📚 Documentación API

Cada microservicio dispone de documentación mediante Swagger.

Ejemplo:

```
http://localhost:8080/swagger-ui/index.html
```

*(El puerto dependerá de la configuración de cada servicio.)*

---

# 📌 Características

- Arquitectura basada en Microservicios
- API REST
- Escalabilidad
- Independencia entre servicios
- Buenas prácticas con Spring Boot
- Documentación OpenAPI
- Comunicación mediante API Gateway
- Persistencia con JPA

---

# Arquitectura de puertos

- categoria-service → puerto 8082
- producto-service → puerto 8081
- cliente-service → puerto 8083
- empleado-service → puerto 8084
- sucursal-service → puerto 8085
- inventario-service → puerto 8086
- pago-service → puerto 8087
- detalle-pedido-service → puerto 8088
- reporte-service → puerto 8089
- pedido-service → puerto 8090

# 📖 Objetivo

Desarrollar un sistema backend escalable para la administración de una cafetería universitaria, aplicando los principios de arquitectura de microservicios y las buenas prácticas de desarrollo de software.

---

# 📄 Licencia

Proyecto desarrollado con fines académicos.
