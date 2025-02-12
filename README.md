# Ticket API

## Descripción
Ticket API es un servicio REST para la gestión de tickets. Permite la creación, consulta y actualización de tickets en el sistema.

## Endpoints

### Crear un Ticket
**Endpoint:**
```
POST /api/tickets
```
**Descripción:**
Crea un nuevo ticket en el sistema.

**Parámetros:**
- `user` (String, requerido) - Nombre de usuario que crea el ticket.

**Ejemplo de solicitud:**
```
POST /api/tickets?user=johndoe
```

**Respuesta:**
```json
{
    "id": 1,
    "username": "johndoe",
    "creationDate": "2024-02-11T12:00:00",
    "updateDate": "2024-02-11T12:00:00",
    "status": "OPEN"
}
```

---

### Obtener Todos los Tickets
**Endpoint:**
```
GET /api/tickets
```
**Descripción:**
Retorna la lista de todos los tickets paginados.

**Parámetros opcionales:**
- `size` (Integer) - Número de elementos por página (por defecto 10).
- `page` (Integer) - Número de la página.

**Ejemplo de solicitud:**
```
GET /api/tickets?page=0&size=5
```

**Respuesta:**
```json
[
    {
        "id": 1,
        "username": "johndoe",
        "creationDate": "2024-02-11T12:00:00",
        "updateDate": "2024-02-11T12:00:00",
        "status": "OPEN"
    },
    {
        "id": 2,
        "username": "janedoe",
        "creationDate": "2024-02-11T13:00:00",
        "updateDate": "2024-02-11T13:00:00",
        "status": "CLOSE"
    }
]
```

---

### Obtener un Ticket por ID
**Endpoint:**
```
GET /api/tickets/{id}
```
**Descripción:**
Obtiene un ticket específico basado en su ID.

**Ejemplo de solicitud:**
```
GET /api/tickets/1
```

**Respuesta:**
```json
{
    "id": 1,
    "username": "johndoe",
    "creationDate": "2024-02-11T12:00:00",
    "updateDate": "2024-02-11T12:00:00",
    "status": "OPEN"
}
```

---

### Cerrar un Ticket
**Endpoint:**
```
PUT /api/tickets/{id}/close
```
**Descripción:**
Cierra un ticket cambiando su estado a `CLOSE`.

**Ejemplo de solicitud:**
```
PUT /api/tickets/1/close
```

**Respuesta:**
```json
{
    "id": 1,
    "username": "johndoe",
    "creationDate": "2024-02-11T12:00:00",
    "updateDate": "2024-02-11T14:00:00",
    "status": "CLOSE"
}
```

## Modelo de Datos

```json
{
    "id": 1,
    "username": "johndoe",
    "creationDate": "2024-02-11T12:00:00",
    "updateDate": "2024-02-11T12:00:00",
    "status": "OPEN"
}
```

## Tecnologías utilizadas
- **Spring Boot** 
- **Spring Data JPA** 
- **H2 Database** 

## Instalación y Ejecución

1. Clonar el repositorio:
   ```sh
   git clone https://github.com/mkcastro85/tickets.git
   cd tickets
   ```
2. Construir y ejecutar el proyecto con Maven:
   ```sh
   mvn spring-boot:run
   ```


