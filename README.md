# DOSW_Lab7_Aguirre_Contreras_Gonzalez_Nieto_Moreno-

## Entidades seleccionadas para persistencia (Laboratorio 7)

Para esta entrega se seleccionaron cuatro entidades del dominio de OficioYa
que cubren las funcionalidades de **autenticación** y **gestión de trabajadores (CRUD)**.

| Entidad | Funcionalidad | Justificación |
|---|---|---|
| `Usuario` | Autenticación | Almacena las credenciales (correo y contraseña), el indicador de administrador y el estado activo. Es la base del inicio de sesión con JWT. |
| `Trabajador` | Trabajadores (CRUD) | Perfil de oferta del servicio: oficio principal, tarifa aproximada, disponibilidad, promedio de calificación y estado de pausa. |
| `Contratante` | Autenticación / perfiles | Perfil de demanda. Con el patrón User + Profiles una misma persona puede ser contratante y trabajador sin columnas nulas. |
| `Oficio` | Trabajadores (CRUD) | Catálogo de oficios que clasifica a los trabajadores y sirve de base para la búsqueda. |

### Relaciones

| Relación | Cardinalidad | Implementación JPA |
|---|---|---|
| Usuario ↔ Trabajador | 1:1 (opcional) | `@OneToOne` |
| Usuario ↔ Contratante | 1:1 (opcional) | `@OneToOne` |
| Oficio → Trabajador (oficio principal) | 1:N | `@ManyToOne` en Trabajador |
| Trabajador ↔ Oficio (oficios secundarios) | N:M | `@ManyToMany` con tabla `trabajador_oficios` |

### Decisiones de diseño

- **Separar Usuario de los perfiles** evita datos nulos y permite la dualidad de roles.
- **Privacidad:** el correo y el teléfono viven en `Usuario`, pero no se exponen en los modelos públicos.
- Las demás entidades del ERD (solicitudes, calificaciones, mensajes, galería, etc.)
  se persistirán en siguientes iteraciones.




