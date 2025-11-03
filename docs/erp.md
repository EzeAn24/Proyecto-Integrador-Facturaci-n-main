# Especificación de requisitos de software (ERP - Sistema de Facturación de Servicios)

## [cite_start]Enunciado del problema [cite: 1]

[cite_start]El problema a resolver es la gestión ineficiente y manual de la facturación de servicios para una empresa argentina[cite: 1]. [cite_start]Actualmente, la administración se enfrenta a la complejidad de manejar múltiples cuentas de clientes con diferentes condiciones fiscales (IVA según legislación argentina), la diversidad de servicios y la necesidad de procesos críticos como la facturación masiva por período[cite: 1]. Un sistema automatizado es esencial para asegurar la precisión fiscal, mantener el estado correcto de las cuentas y optimizar el tiempo del personal administrativo.

---

## [cite_start]Clientes potenciales [cite: 2]

[cite_start]Los clientes potenciales (usuarios del software) que se beneficiarán de esta solución son el **Personal Administrativo y Contable de la Empresa**[cite: 2]. Estos usuarios serán los únicos que interactuarán con el sistema, siendo responsables de la gestión de cuentas y clientes, la carga de servicios, la emisión de facturas (masiva e individual), la anulación de facturas y el registro de pagos.

---

## [cite_start]Solución propuesta [cite: 4]

La solución es un Sistema de Facturación de Servicios (ERP) basado en POO que centraliza la gestión de cuentas de clientes bajo la legislación argentina de IVA. El sistema permitirá:
1.  **Gestión Completa de Clientes y Servicios:** Carga flexible de servicios con distintos IVA, y registro de clientes con su condición fiscal.
2.  **Facturación Eficiente:** Emisión de facturas individuales o masivas por período mediante una acción iniciada por el usuario ("Boton grande que diga facturar"). La facturación aplicará el IVA correcto y se basará en los servicios asignados y activos en cada cuenta.
3.  **Manejo de Pagos y Cuentas:** Registro de pagos (totales, parciales o por adelantado), generación de recibos detallados y el objetivo primario de mantener el estado de las cuentas.
4.  **Trazabilidad Fiscal:** Anulación de facturas mediante Notas de Crédito y registro del motivo de anulación.

---

## [cite_start]Requisitos [cite: 5]

Los requisitos se presentan en formato de Historias de Usuario (el tipo principal es Funcional):

| Tipo | Módulo | Historia de Usuario |
| :--- | :--- | :--- |
| **Funcional** | Gestión de Datos | Como **Administrativo**, quiero **cargar un nuevo servicio** con su nombre, precio y alícuota de IVA (Distinto IVA), para que esté disponible para ser asignado a cuentas. |
| **Funcional** | Gestión de Datos | Como **Administrativo**, quiero **registrar los datos de un Cliente** (Razón social, DNI, Condición de IVA, email, etc.) para que la cuenta esté lista para la facturación. |
| **Funcional** | Facturación | Como **Administrativo**, quiero **asignar múltiples servicios** a una cuenta de cliente para definir qué se facturará. |
| **Funcional** | Facturación | Como **Administrativo**, quiero **iniciar la Facturación Masiva** pulsando el botón "Facturar", para emitir todas las facturas de servicios activos para el período. |
| **Funcional** | Facturación | Como **Administrativo**, quiero **establecer la fecha de vencimiento** de las facturas generadas, para tener libertad en los plazos. |
| **Funcional** | Pagos | Como **Administrativo**, quiero **ver un listado de facturas pendientes** y tener la opción de **pagar parcial o totalmente** la deuda para mantener el estado de la cuenta. |
| **Funcional** | Pagos | Como **Administrativo**, quiero **registrar un Pago por Adelantado** (Saldo a favor) para que se aplique en futuras facturaciones. |
| **Funcional** | Anulación | Como **Administrativo**, quiero **anular una factura** registrando el motivo o concepto y que el sistema **genere automáticamente una Nota de Crédito**. |
| **No Funcional**| Diseño | El sistema debe tener una **interfaz de usuario de color morado** para cumplir con el requisito estético. |
| **No Funcional**| Seguridad | El sistema **no requerirá funcionalidad de Login** ya que solo el usuario interno interactúa. |
| **Técnico** | Estructura | El sistema debe utilizar **enums** para el manejo de estados o tipos fijos (ej: Condición de IVA, Estado de Cuenta, Tipo de Pago, etc.). |

---

## [cite_start]Arquitectura de software [cite: 6]

### Tipo de Aplicación

[cite_start]Será una aplicación **Cliente-Servidor**[cite: 7]. Dada la naturaleza de la tarea (POO II), se recomienda desarrollar un *backend* robusto para la lógica de negocio y gestión de datos. El usuario será el personal interno de la empresa.

### Estructura y Tecnologías

* [cite_start]**Arquitectura:** **Cliente-Servidor**[cite: 7]. La lógica de negocio y los datos residen en el servidor, al que accede la interfaz de usuario (el cliente).
* **Lenguajes de Programación / Frameworks:**
    * **Backend (Servidor/POO):** Se utilizará **Java** (dada la materia de POO II) con el *framework* **Spring Boot** para construir la lógica de negocio, la gestión de objetos y la API REST para el cliente.
    * **Frontend (Cliente):** Se usará un cliente web simple (HTML/CSS/JavaScript) o un framework como **Vue.js/React** para consumir la API y proporcionar la interfaz de usuario morada.
* **Base de Datos:** Se utilizará un motor de base de datos **Relacional** como **PostgreSQL** o **MySQL** para la persistencia de las entidades (Clientes, Cuentas, Servicios, Facturas, Pagos).