-- 02. Listar a todos los customers que sean de los paises: France, Germany, Sweeden. Guardar como el archivo "ejercicio0.sql" y subirlo a tu repositorio
SELECT * FROM Customers
WHERE Country = 'Germany' or Country = 'France' or Country = 'Sweden'