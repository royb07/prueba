prueba
Api Rest para Prueba Técnica Decrypto.la>>

Descripción:
-------------
Este proyecto implementa una API REST en Java utilizando Spring Boot. La API gestiona los recursos 
relacionados con los "Comitentes" y los "Mercados", con la posibilidad de realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar).

Características:
-----------------
- Gestión de Comitentes y Mercados.
- Operaciones CRUD para Comitentes y Mercados.
- Verificación de duplicados para Comitentes.
- Estadísticas de distribución de Comitentes por país y mercado.

Requisitos:
------------
- Java version 17
- Maven
- Base de datos compatible con Spring Boot (por defecto, se utiliza H2 en memoria, MySQL para instancia en AWS)
- Postman (herramienta para realizar pruebas de manera local)

Repositorio:
-------------
git clone https://github.com/royb07/prueba


Endpoints de la API:
-------------------

Comitentes:
----------
GET /api/comitentes: Obtener todos los comitentes.
POST /api/comitentes: Crear un nuevo comitente.
PUT /api/comitentes/{id}: Actualizar un comitente existente.
DELETE /api/comitentes/{id}: Eliminar un comitente.

Mercados:
---------
GET /api/mercados: Obtener todos los mercados.
POST /api/mercados: Crear un nuevo mercado.
PUT /api/mercados/{id}: Actualizar un mercado existente.
DELETE /api/mercados/{id}: Eliminar un mercado.
GET /api/mercados/statistics: Obtener estadísticas de distribución por país.