# ZoneStyle — Backend

API REST del sistema de gestión de reservas Estilo Zona, construida con Java 21 y Spring Boot 3.3.4.

## Tecnologías

- Spring Web y Spring Data JPA
- Spring Security y Bean Validation
- MySQL
- Maven Wrapper

## Requisitos y ejecución

1. Instalar Java 21 y disponer de una base de datos MySQL.
2. Configurar los datos de conexión del entorno en `src/main/resources/application.properties`.
3. Ejecutar desde la carpeta principal:

   - Windows: `mvnw.cmd spring-boot:run`
   - Linux/macOS: `./mvnw spring-boot:run`

4. El servidor utiliza `http://localhost:8080` salvo que se configure otro puerto.

> Seguridad: no compartas las credenciales de base de datos. Si hay contraseñas reales comprometidas en el historial de Git, rótalas y externaliza la configuración antes de desplegar. La configuración de CORS y acceso HTTP actual debe revisarse antes de producción.

## Rutas REST principales

| Recurso | Ruta |
| --- | --- |
| Clientes | `/v1/Cliente` |
| Empleados | `/v1/Empleado` |
| Reservas | `/v1/Reserva` |
| Pagos | `/v1/Pago` |

Para otras rutas, revisar las anotaciones `@RequestMapping` en `controller/`.

## Pruebas

- Windows: `mvnw.cmd test`
- Linux/macOS: `./mvnw test`

Las pruebas que arrancan todo el contexto Spring requieren base de datos o perfil de pruebas configurado.
