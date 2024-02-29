-- Realizar un backup de una base de datos
/*
01. Listar todos los customers que inicien su id con la letra 'A'. Guardar el archivo como "ejercicio01.sql" y lo subes a tu repositorio
*/

SELECT * FROM Customers
WHERE CustomerID LIKE'A%'