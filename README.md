# Servicio de Gestión de Clientes

Este proyecto implementa una API REST para la gestión de clientes. Permite a los usuarios realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los datos de los clientes.

## Requisitos

- Java 17
- Gradle
- Docker
- Spring Boot 3

## Ejecución con Docker

Para ejecutar el proyecto usando Docker, sigue estos pasos:

- Construye la imagen de Docker. Ubícate en la raíz del proyecto y ejecuta:
    ```bash
    docker build -t gestion-clientes .
    ```
- Ejecuta la imagen (asegúrate de que el puerto 8080 esté disponible):
    ```bash
    docker run -p 8080:8080 gestion-clientes
    ```
    La aplicación estará disponible en http://localhost:8080.

## Endpoints de la API

### 1. Crear Cliente: `POST /v1/client`

Crea un nuevo cliente en el sistema.

- **Payload de solicitud:**
    ```json
    {
        "name": "Juan Perez",
        "address": "123 Calle Principal",
        "phone": "555-1234",
        "password": "password123",
        "state": true
    }
    ```
- **Respuesta exitosa:** 200 OK

### 2. Actualizar Cliente: `PUT /v1/client`

Actualiza los datos de un cliente existente.

- **Payload de solicitud:**
    ```json
    {
        "idClient": 1,
        "name": "Juan Perez",
        "address": "123 Calle Nueva",
        "phone": "555-5678",
        "password": "newPassword123",
        "state": true
    }
    ```
- **Respuesta exitosa:** 200 OK

### 3. Obtener Todos los Clientes: `GET /v1/client`

Retorna una lista de todos los clientes registrados.

- **Respuesta exitosa:** 200 OK
- **Respuesta:** Lista de `ClientResponseDto`

### 4. Obtener Cliente por ID: `GET /v1/client/{id}`

Obtiene la información detallada de un cliente por su ID.

- **Respuesta exitosa:** 200 OK
- **Respuesta:** `ClientResponseDto`

### 5. Obtener Cliente por Nombre: `GET /v1/client/name?name={nombre}`

Obtiene la información de un cliente por su nombre.

- **Respuesta exitosa:** 200 OK
- **Respuesta:** `ClientResponseDto`

### 6. Eliminar Cliente: `DELETE /v1/client`

Elimina un cliente del sistema.

- **Parámetro de solicitud:** `idClient` (ID del cliente a eliminar)
- **Respuesta exitosa:** 200 OK

## Validaciones

- La API realiza validaciones en los campos de entrada.
- Errores específicos serán retornados si los datos no cumplen con los requisitos.

## Seguridad y Autenticación

- (Incluir detalles sobre cómo se maneja la autenticación y seguridad, si es aplicable).

## Test

- Instrucciones sobre cómo ejecutar pruebas unitarias y de integración.

## Contribuciones

- Guía para contribuir al proyecto, si es un proyecto de código abierto.
