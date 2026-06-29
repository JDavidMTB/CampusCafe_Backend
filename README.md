🚀 Guía de Integración: Docker + Swagger — CampusCafe
Archivos entregados
Archivo	Para qué sirve
`docker-compose.yml`	Levanta todos los microservicios + MySQL con un solo comando
`init-db.sql`	Crea automáticamente las 10 bases de datos al arrancar MySQL
`Dockerfile`	Plantilla para construir la imagen de cada microservicio
`SwaggerConfig.java`	Clase de configuración Swagger (una por microservicio)
`CategoriaController_con_Swagger.java`	Ejemplo de controller anotado con Swagger
`application.properties.template`	Plantilla de propiedades con Swagger activado
---
PARTE 1 — Integrar Swagger
Paso 1: Agregar dependencia en cada `pom.xml`
Abre el `pom.xml` de cada microservicio y agrega esto dentro de `<dependencies>`:
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.6.0</version>
</dependency>
```
Paso 2: Agregar propiedades en cada `application.properties`
Abre el `application.properties` de cada microservicio y agrega al final:
```properties
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
springdoc.swagger-ui.path=/doc/swagger-ui.html
```
Paso 3: Crear la clase `SwaggerConfig.java`
En cada microservicio, crea la carpeta `config/` dentro de tu paquete principal y copia el archivo `SwaggerConfig.java`. Ajusta solo estas dos líneas:
```java
.title("CampusCafe - Categoria Service API")      // ← cambia por el nombre del servicio
.description("API para gestión de categorías...")  // ← cambia la descripción
```
Paso 4: Anotar tus controllers (opcional pero recomendado para la nota)
Usa las anotaciones del archivo `CategoriaController_con_Swagger.java` como modelo:
`@Tag` → en la clase del controller
`@Operation` → en cada método
`@ApiResponses` + `@ApiResponse` → para documentar los códigos HTTP
`@Parameter` → para documentar los parámetros de ruta
URLs de Swagger por microservicio
Servicio	URL Swagger
producto-service	http://localhost:8081/doc/swagger-ui/index.html
categoria-service	http://localhost:8082/doc/swagger-ui/index.html
cliente-service	http://localhost:8083/doc/swagger-ui/index.html
empleado-service	http://localhost:8084/doc/swagger-ui/index.html
sucursal-service	http://localhost:8085/doc/swagger-ui/index.html
inventario-service	http://localhost:8086/doc/swagger-ui/index.html
pago-service	http://localhost:8087/doc/swagger-ui/index.html
detalle-pedido-service	http://localhost:8088/doc/swagger-ui/index.html
reporte-service	http://localhost:8089/doc/swagger-ui/index.html
pedido-service	http://localhost:8090/doc/swagger-ui/index.html
---
PARTE 2 — Integrar Docker
Estructura de carpetas esperada
```
CampusCafe - Backend/
├── docker/                    ← Carpeta nueva donde pones los archivos Docker
│   ├── docker-compose.yml
│   └── init-db.sql
├── categoria-service/
│   ├── Dockerfile             ← Copia el Dockerfile aquí
│   ├── pom.xml
│   └── src/
├── producto-service/
│   ├── Dockerfile             ← Copia el Dockerfile aquí
│   └── ...
├── cliente-service/
│   ├── Dockerfile
│   └── ...
... (repite para todos los servicios)
```
Paso 1: Copiar el `Dockerfile`
Coloca una copia del archivo `Dockerfile` en la raíz de cada microservicio (junto al `pom.xml`).  
El Dockerfile es igual para todos, no necesitas modificarlo.
Paso 2: Crear la carpeta `docker/` y copiar los archivos
Crea una carpeta llamada `docker/` dentro de `CampusCafe - Backend/` y copia allí:
`docker-compose.yml`
`init-db.sql`
Paso 3: Levantar todo el sistema
Desde la carpeta `docker/`, ejecuta en la terminal:
```bash
docker-compose up --build
```
Esto hará:
Construir la imagen de cada microservicio con Maven (puede tardar ~5 min la primera vez)
Levantar MySQL y crear las 10 bases de datos automáticamente
Arrancar los 10 microservicios
Paso 4: Verificar que todo funciona
```bash
# Ver servicios corriendo
docker ps

# Ver logs de un servicio específico
docker logs categoria-service

# Detener todo
docker-compose down

# Detener y eliminar volúmenes (bases de datos)
docker-compose down -v
```
Nota importante sobre contraseñas
El `docker-compose.yml` usa `MYSQL_ROOT_PASSWORD: root`. Si tu `application.properties` tiene la contraseña vacía, en Docker debes usar `root`. Las variables de entorno en el docker-compose sobreescriben el `application.properties`.
---
Puertos del sistema
Microservicio	Puerto local	Base de datos
producto-service	8081	producto_db
categoria-service	8082	categoria_db
cliente-service	8083	cliente_db
empleado-service	8084	empleado_db
sucursal-service	8085	sucursal_db
inventario-service	8086	inventario_db
pago-service	8087	pago_db
detalle-pedido-service	8088	detalle_pedido_db
reporte-service	8089	reporte_db
pedido-service	8090	pedido_db
MySQL	3306	—
