# Plan Tentativo de Historias de Usuario (Roadmap)

El proyecto se dividirá en 2 iteraciones, buscando entregar el Mínimo Producto Viable (MVP) en la primera iteración, y las funcionalidades de control y facturación masiva en la segunda.

## 🎯 Iteración 1: Módulo Central y Facturación Básica (MVP)

**Objetivo:** Permitir al usuario registrar clientes y servicios, emitir una factura y registrar un pago para verificar la funcionalidad principal del sistema.

| Módulo | Historias de Usuario a Entregar (MVP) | Requisito Principal |
| :--- | :--- | :--- |
| **Gestión de Datos** | * Como Administrativo, quiero cargar un nuevo servicio con su precio y alícuota de IVA. | Carga de Servicios |
| | * Como Administrativo, quiero registrar los datos de un Cliente (Razón social, DNI, Condición de IVA, etc.) y asignarle servicios contratados. | Alta de Clientes |
| **Facturación** | * Como Administrativo, quiero emitir una **Factura Individual** y establecer su fecha de vencimiento. | Facturación Individual |
| **Pagos** | * Como Administrativo, quiero ver un listado de facturas pendientes y **marcar la opción de Pago Total** con un tilde para registrar el pago. | Pago Total |
| | * Como Administrativo, quiero **ver el detalle de la Factura y del Recibo** una vez emitidos. | Visualización de Comprobantes |
| **Técnico/Diseño** | * El sistema debe utilizar enums para tipos fijos (ej: Condición IVA, Tipo de Servicio). | Estructura de Clases (POO) |

## 🚀 Iteración 2: Facturación Masiva y Control de Cuentas

**Objetivo:** Implementar la funcionalidad central de Facturación Masiva, la gestión de la anulación fiscal y el manejo avanzado de pagos (saldo a favor).

| Módulo | Historias de Usuario a Entregar | Requisito Principal |
| :--- | :--- | :--- |
| **Facturación Masiva** | * Como Administrativo, quiero **iniciar la Facturación Masiva** pulsando el "Boton grande Facturar" para facturar todos los servicios activos del periodo. | Ejecución de Fact. Masiva |
| | * Como Administrativo, quiero ver el **registro de la facturación masiva** (fecha, vencimiento y cantidad de facturas generadas). | Registro de Fact. Masiva |
| **Anulación** | * Como Administrativo, quiero **anular una factura** registrando el motivo y que se **genere una Nota de Crédito**. | Anulación con NC |
| | * Como Administrativo, quiero un **registro de facturas anuladas** para trazabilidad. | Registro de Anulaciones |
| **Pagos Avanzados** | * Como Administrativo, quiero **registrar pagos parciales y pagos por adelantado** (Saldo a favor) para mantener el estado de la cuenta. | Pagos Parciales/Adelantados |
| **Gestión** | * Como Administrativo, quiero **actualizar la Condición de IVA de un cliente** para que tome el nuevo régimen fiscal en la próxima factura. | Actualización de Datos |