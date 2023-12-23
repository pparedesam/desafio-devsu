# Servicio de Gestión de Clientes

Este proyecto implementa una API REST para la gestión de clientes. Permite a los usuarios realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los datos de los clientes.

## Requisitos

- Java 17
- Gradle
- Docker
- Spring Boot 3

## Ejecución con Docker Compose

Para ejecutar el proyecto usando Docker Compose, sigue estos pasos:

- Ubícate en la raíz del proyecto donde se encuentra el archivo `docker-compose.yml`.
- Ejecuta el siguiente comando para construir y levantar los servicios:
    ```bash
    docker-compose up --build
    ```
- Los servicios estarán disponibles en los siguientes puertos:
  - Person Service: http://localhost:8080
  - Account Service: http://localhost:8081

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
- **Ejemplo de respuesta:**
    ```json
    {
        "id": 1,
        "name": "Juan Perez",
        "address": "123 Calle Principal",
        "phone": "555-1234"
    }
    ```

### 2. Actualizar Cliente: `PUT /v1/client`

Actualiza los datos de un cliente existente.

- **Payload de solicitud:**
    ```json
    {
        "idClient": 1,
        "name": "Juan Perez Actualizado",
        "address": "123 Calle Nueva",
        "phone": "555-5678",
        "password": "newPassword123",
        "state": true
    }
    ```
- **Respuesta exitosa:** 200 OK
- **Ejemplo de respuesta:**
    ```json
    {
        "id": 1,
        "name": "Juan Perez Actualizado",
        "address": "123 Calle Nueva",
        "phone": "555-5678"
    }
    ```

### 3. Obtener Todos los Clientes: `GET /v1/client`

Retorna una lista de todos los clientes registrados.

- **Respuesta exitosa:** 200 OK
- **Ejemplo de respuesta:**
    ```json
    [
        {
            "id": 1,
            "name": "Juan Perez",
            "address": "123 Calle Principal",
            "phone": "555-1234"
        }
    ]
    ```

### 4. Obtener Cliente por ID: `GET /v1/client/{id}`

Obtiene la información detallada de un cliente por su ID.

- **Respuesta exitosa:** 200 OK
- **Ejemplo de respuesta:**
    ```json
    {
        "id": 1,
        "name": "Juan Perez",
        "address": "123 Calle Principal",
        "phone": "555-1234"
    }
    ```

### 5. Obtener Cliente por Nombre: `GET /v1/client/name?name={nombre}`

Obtiene la información de un cliente por su nombre.

- **Respuesta exitosa:** 200 OK
- **Ejemplo de respuesta:**
    ```json
    {
        "id": 1,
        "name": "Juan Perez",
        "address": "123 Calle Principal",
        "phone": "555-1234"
    }
    ```

### 6. Eliminar Cliente: `DELETE /v1/client`

Elimina un cliente del sistema basándose en su ID.

- **Parámetro de solicitud:** `idClient` (ID del cliente a eliminar)
- **Respuesta exitosa:** 200 OK


