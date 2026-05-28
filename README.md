# 🏋️ Gimnasio API REST — Proyecto Final UT6

**Autores:** Jonay Martín Rivero González · Jeremi González Perera
**Módulo:** Programación (PRO) — 1ºB DAM  
**Curso:** 2025-2026

---

## Descripción

API REST desarrollada con **Spring Boot** para la gestión de un gimnasio. Permite administrar clientes, entrenadores, clases y entrenamientos con persistencia en base de datos MySQL.

Incluye autenticación HTTP Basic para los endpoints de escritura, validación de datos de entrada, manejo global de excepciones e interfaz web estática que consume la API.

---

## Configuración de la base de datos

Antes de arrancar, crea la base de datos en MySQL:

```sql
CREATE DATABASE gimnasiodb;
```

Las credenciales por defecto configuradas en `application.properties` son:

```
usuario: root
contraseña: root
```

Si tus credenciales son distintas, edita el fichero `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gimnasiodb
spring.datasource.username=root
spring.datasource.password=root
```

Las tablas se crean automáticamente al arrancar (`spring.jpa.hibernate.ddl-auto=update`).

---

## Cómo arrancar el proyecto

Desde la carpeta `Gimnasio/`:

```bash
./mvnw spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

La API estará disponible en: `http://localhost:8080`  
La interfaz web estará en: `http://localhost:8080/index.html`

---

## Autenticación

Los endpoints **GET** son públicos. Los endpoints de escritura (**POST**, **PUT**, **DELETE**) requieren autenticación HTTP Basic:

| Campo | Valor |
|---|---|
| Usuario | `admin` |
| Contraseña | `123456` |

En Postman: pestaña **Authorization** → tipo **Basic Auth**.

---

## Endpoints disponibles

### Clientes — `/api/v1/clientes`

| Método | Ruta | Descripción | Auth |
|---|---|---|---|
| GET | `/api/v1/clientes` | Lista todos los clientes | No |
| GET | `/api/v1/clientes?nombre=xxx` | Busca clientes por nombre (parcial, sin distinción mayúsculas) | No |
| GET | `/api/v1/clientes/{id}` | Obtiene un cliente por ID | No |
| GET | `/api/v1/clientes/entrenador/{id}` | Lista clientes de un entrenador | No |
| POST | `/api/v1/clientes` | Crea un nuevo cliente | Sí |
| PUT | `/api/v1/clientes/{id}` | Actualiza un cliente | Sí |
| DELETE | `/api/v1/clientes/{id}` | Elimina un cliente | Sí |

**Ejemplo body POST/PUT:**
```json
{
  "nombre": "Ana García",
  "nacionalidad": "Española",
  "nacimiento": "1995-03-15",
  "objetivo": "Perder peso",
  "email": "ana@email.com",
  "activo": true,
  "entrenador": { "id": 1 }
}
```

---

### Entrenadores — `/api/v1/entrenadores`

| Método | Ruta | Descripción | Auth |
|---|---|---|---|
| GET | `/api/v1/entrenadores` | Lista todos los entrenadores | No |
| GET | `/api/v1/entrenadores/{id}` | Obtiene un entrenador por ID | No |
| POST | `/api/v1/entrenadores` | Crea un nuevo entrenador | Sí |
| PUT | `/api/v1/entrenadores/{id}` | Actualiza un entrenador | Sí |
| DELETE | `/api/v1/entrenadores/{id}` | Elimina un entrenador | Sí |

**Ejemplo body POST/PUT:**
```json
{
  "nombre": "Carlos López",
  "especialidad": "Crossfit"
}
```

---

### Clases — `/api/v1/clases`

| Método | Ruta | Descripción | Auth |
|---|---|---|---|
| GET | `/api/v1/clases` | Lista todas las clases | No |
| GET | `/api/v1/clases/{id}/aforo` | Número de clientes inscritos en una clase | No |
| POST | `/api/v1/clases` | Crea una nueva clase | Sí |
| POST | `/api/v1/clases/{claseId}/clientes/{clienteId}` | Inscribe un cliente en una clase | Sí |
| DELETE | `/api/v1/clases/{id}` | Elimina una clase | Sí |

**Ejemplo body POST:**
```json
{
  "nombre": "Yoga matutino",
  "horario": "Lunes y miércoles 08:00",
  "sala": 3
}
```

---

### Entrenamientos — `/api/v1/entrenamientos`

| Método | Ruta | Descripción | Auth |
|---|---|---|---|
| GET | `/api/v1/entrenamientos` | Lista todos los entrenamientos | No |
| GET | `/api/v1/entrenamientos/{id}` | Obtiene un entrenamiento por ID | No |
| POST | `/api/v1/entrenamientos` | Crea un nuevo entrenamiento | Sí |
| PUT | `/api/v1/entrenamientos/{id}` | Actualiza un entrenamiento | Sí |
| DELETE | `/api/v1/entrenamientos/{id}` | Elimina un entrenamiento | Sí |

**Ejemplo body POST/PUT:**
```json
{
  "nombre": "HIIT Avanzado",
  "descripcion": "Entrenamiento de alta intensidad",
  "objetivo": "Quemar grasa",
  "dificultad": "Avanzado",
  "duracion": "45 minutos",
  "horario": "Martes 19:00",
  "entrenamiento": true,
  "cliente": { "id": 1 },
  "entrenador": { "id": 1 }
}
```

---

## Estructura del proyecto

```
Gimnasio/
└── src/main/java/com/dam/userapp/
    ├── controller/       # Controladores REST (@RestController)
    │   ├── ClienteController.java
    │   ├── EntrenadorController.java
    │   ├── ClaseController.java
    │   └── EntrenamientoController.java
    ├── service/          # Lógica de negocio (@Service)
    │   ├── ClienteService.java
    │   ├── EntrenadorService.java
    │   ├── ClaseService.java
    │   └── EntrenamientoService.java
    ├── repository/       # Acceso a datos (JpaRepository)
    │   ├── ClienteRepository.java
    │   ├── EntrenadorRepository.java
    │   ├── ClaseRepository.java
    │   └── EntrenamientoRepository.java
    ├── model/            # Entidades JPA (@Entity)
    │   ├── Cliente.java
    │   ├── Entrenador.java
    │   ├── Clase.java
    │   └── Entrenamiento.java
    ├── config/
    │   └── SecurityConfig.java   # Configuración Spring Security
    └── Exception/
        └── GlobalExceptionHandler.java  # @ControllerAdvice
```

---

## Participación en el repositorio

El proyecto ha sido desarrollado en pareja con commits reales de ambos miembros en ramas separadas (`ramaJonay`, `ramaJeremi`) integradas en `main` trabajando en conjunto en todo momento para tener conocimiento de las 2 partes del proyecto.