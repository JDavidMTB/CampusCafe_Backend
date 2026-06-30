☕ CampusCafe Backend

Sistema Backend desarrollado bajo una arquitectura de Microservicios para la gestión integral de una cafetería universitaria. El proyecto permite administrar clientes, productos, categorías, pedidos, pagos, inventario, sucursales, empleados y reportes mediante servicios independientes comunicados a través de un API Gateway.


👥 Integrantes


Juan David Motaban
Benjamín Salas
Lucas Avendaño



🏗️ Arquitectura

El proyecto está basado en una arquitectura de microservicios utilizando Spring Boot, donde cada servicio posee su propia responsabilidad y puede ejecutarse de forma independiente.

Microservicios y puertos

MicroservicioPuertoAPI Gateway8080Producto Service8081Categoría Service8082Cliente Service8083Empleado Service8084Sucursal Service8085Inventario Service8086Pago Service8087Detalle Pedido Service8088Reporte Service8089Pedido Service8090


🚀 Tecnologías utilizadas


Java 21
Spring Boot
Spring Data JPA
Spring Web
Spring Cloud Gateway
Maven
MySQL
Docker
Swagger / OpenAPI
HATEOAS
JUnit 5 + Mockito
Git & GitHub



📂 Estructura del proyecto

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


⚙️ Funcionalidades


Gestión de clientes
Gestión de productos
Administración de categorías
Administración de inventario
Gestión de sucursales
Gestión de empleados
Registro de pedidos
Detalle de pedidos
Gestión de pagos
Generación de reportes
Documentación de API con Swagger
Navegación mediante HATEOAS
Comunicación REST entre microservicios (validación cruzada de datos)



▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio

bashgit clone https://github.com/usuario/CampusCafe_Backend.git

2. Abrir el proyecto

Puede abrirse con:


IntelliJ IDEA
VS Code


3. Configurar la Base de Datos

Modificar el archivo application.properties de cada microservicio con las credenciales correspondientes de MySQL.

4. Compilar cada microservicio

bash.\mvnw.cmd clean package -DskipTests

5. Ejecutar con Docker Compose (recomendado)

Desde la carpeta raíz del proyecto:

bashdocker-compose up --build

Esto levanta automáticamente:


Base de datos MySQL (con healthcheck)
Los 10 microservicios
El API Gateway


6. Crear las bases de datos (solo la primera vez)

bashdocker exec -it mysql mysql -uroot -proot -e "CREATE DATABASE IF NOT EXISTS producto_db; CREATE DATABASE IF NOT EXISTS categoria_db; CREATE DATABASE IF NOT EXISTS cliente_db; CREATE DATABASE IF NOT EXISTS empleado_db; CREATE DATABASE IF NOT EXISTS sucursal_db; CREATE DATABASE IF NOT EXISTS inventario_db; CREATE DATABASE IF NOT EXISTS pago_db; CREATE DATABASE IF NOT EXISTS detalle_pedido_db; CREATE DATABASE IF NOT EXISTS reporte_db; CREATE DATABASE IF NOT EXISTS pedido_db;"

Alternativa: ejecución individual sin Docker

Cada microservicio puede iniciarse mediante:

bashmvn spring-boot:run

o ejecutando la clase principal de Spring Boot desde el IDE.


🛣️ Rutas principales del API Gateway

Todas las solicitudes se realizan a través del Gateway en http://localhost:8080.

Categorías

GET    /api/categorias
GET    /api/categorias/{id}
POST   /api/categorias

Clientes

GET    /api/clientes
GET    /api/clientes/{id}
POST   /api/clientes

Empleados

GET    /api/empleados
POST   /api/empleados

Sucursales

GET    /api/sucursales
POST   /api/sucursales

Inventario

GET    /api/inventario
POST   /api/inventario

Pagos

GET    /api/pagos
POST   /api/pagos

Detalle de Pedido

GET    /api/detalles
POST   /api/detalles

Reportes

GET    /api/reportes
POST   /api/reportes

Pedidos

GET    /api/pedidos
POST   /api/pedidos

Productos

GET    /api/productos
GET    /api/productos/{id}
POST   /api/productos
PUT    /api/productos/{id}


📘 Documentación Swagger / OpenAPI

Cada microservicio expone su documentación interactiva de forma independiente:

ServicioURL Swaggerproducto-servicehttp://localhost:8081/doc/swagger-ui.htmlcategoria-servicehttp://localhost:8082/doc/swagger-ui.htmlcliente-servicehttp://localhost:8083/doc/swagger-ui.htmlempleado-servicehttp://localhost:8084/doc/swagger-ui.htmlsucursal-servicehttp://localhost:8085/doc/swagger-ui.htmlinventario-servicehttp://localhost:8086/doc/swagger-ui.htmlpago-servicehttp://localhost:8087/doc/swagger-ui.htmldetalle-pedido-servicehttp://localhost:8088/doc/swagger-ui.htmlreporte-servicehttp://localhost:8089/doc/swagger-ui.htmlpedido-servicehttp://localhost:8090/doc/swagger-ui.html


🧪 Pruebas unitarias

Las pruebas unitarias se desarrollaron con JUnit 5 y Mockito, siguiendo la estructura Given–When–Then.

Servicios con pruebas implementadas:


categoria-service → CategoriaServiceTest
cliente-service → ClienteServiceTest


Para ejecutar las pruebas de un servicio:

bashcd categoria-service
.\mvnw.cmd test


🔗 Comunicación entre microservicios


producto-service valida la existencia de la categoría remota en categoria-service antes de guardar un producto.
pedido-service valida la existencia del cliente remoto en cliente-service antes de procesar un pedido.



🌐 Despliegue remoto

(completar si se desplegó en Railway, Render u otra plataforma)

URL Gateway remoto: 
URL Swagger remoto:


📌 Características


Arquitectura basada en Microservicios
API REST
Escalabilidad
Independencia entre servicios
Buenas prácticas con Spring Boot
Documentación OpenAPI
Comunicación mediante API Gateway
Persistencia con JPA



📖 Objetivo

Desarrollar un sistema backend escalable para la administración de una cafetería universitaria, aplicando los principios de arquitectura de microservicios y las buenas prácticas de desarrollo de software.


📄 Licencia

Proyecto desarrollado con fines académicos.
