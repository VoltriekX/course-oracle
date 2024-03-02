/*
Ejercicios
1. Crear una nueva base de datos llamada "TALLERSQL".
2. Crear una tabla llamada "Clientes", considerar los atributos ID, Nombre, Apellido, Telefono, Direccion, Email.
3. Insertar 10 registros en la tabla creada anteriormente.
4. mostrar todos los registros insertados.
5. Actualizar 5 registros de la tabla anteriormente creada utilizando where
6.Eliminar 2 registros utilizando WHERE.
7.Guardar todo tu trabajo en tu repositorio de github

*/
--1
Create database TALLERSQL

--2
USE TALLERSQL
Create table Clientes (
ID INT PRIMARY KEY,
NOMBRE VARCHAR (100),
APELLIDO VARCHAR (100),
TELEFONO CHAR(9),
DIRECCION VARCHAR (50),
EMAIL VARCHAR (100),

)
GO
--3
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('01','PEDRO','SUAREZ','972526152','AV. EL OLIVAR 741 ','fortges721@gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('02','VENEDECTINO','ZUÑIGA','923243623','AV. BRASIL Nº 515 - 519 ','VENECGA@gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('03','JUAN','ZAPATA','977255234','AV. SAN MARTIN Nº 270 ','Valores324gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('04','RODRIGO','CARHUAMACA','952414332','CALLE CASCANUESCES 350 ','554hells@gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('05','PAOLO','CORDOBA','972454352','CALLE 30 MZ Q1 LT13 URB. EL PINAR ','Maria232@gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('06','HAROLD','CACERES','961242363','AV. LOS PORTALES SECTOR 4 URB. ','romulo3652@gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('07','CAROLINA','ORMEÑO','936265523','AV. MIGUEL ANGEL Nº 193A URB. FIORI ','kiko21432@gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('08','JOSE','CORREA','916275243','AV. SANTIAGO WAGNER 2855','marcos725r@gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('09','ROXANA','MORALES','963662532','JR. GERONIMO DE ALIAGA NORTE 136 ','Santafe2383@gmail.com')
INSERT INTO Clientes (ID, Nombre, Apellido, Telefono, Direccion, Email) VALUES ('10','MARIA','RIOS','933754221','AV. GONZALES PRADA 458 - 460 ','Carambola24@gmail.com')
--4
Select * from Clientes
--5
UPDATE Clientes SET APELLIDO ='CROSS' WHERE NOMBRE ='PEDRO' ;SELECT * FROM Clientes;
UPDATE Clientes SET APELLIDO = 'PICASSO' WHERE NOMBRE = 'VENEDECTINO' SELECT * FROM Clientes;
UPDATE Clientes SET APELLIDO = 'LENON' WHERE NOMBRE = 'JUAN' SELECT * FROM Clientes;
UPDATE Clientes SET APELLIDO = 'PAMPAÑAUPA' WHERE NOMBRE = 'RODRIGO' SELECT * FROM Clientes;
UPDATE Clientes SET APELLIDO = 'VENEGAS' WHERE NOMBRE = 'PAOLO' SELECT * FROM Clientes;
--6
DELETE FROM Clientes WHERE NOMBRE = 'JOSE' ;
DELETE FROM Clientes WHERE NOMBRE = 'CAROLINA' ;
--7 
--TA BIEN


