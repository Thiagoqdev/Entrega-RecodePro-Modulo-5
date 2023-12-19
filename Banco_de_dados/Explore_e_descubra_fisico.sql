CREATE DATABASE EXPLORE_DESCUBRA;

USE EXPLORE_DESCUBRA;

CREATE TABLE Clientes (
Id_cliente INTEGER PRIMARY KEY auto_increment,
Nome_cliente VARCHAR(40),
Cpf_cliente VARCHAR(11),
Email_cliente VARCHAR(80),
Senha_cliente VARCHAR(10)
);

CREATE TABLE Pacotes (
Id_pacotes INTEGER PRIMARY KEY auto_increment,
Periodo_pacotes VARCHAR(40),
Destino_pacotes VARCHAR(40),
Preco_pacotes DECIMAL(40)
);

CREATE TABLE Compras (
id_compras INTEGER PRIMARY KEY auto_increment,
Data_compras VARCHAR(40),
Id_pacotes INTEGER,
Id_cliente INTEGER,
FOREIGN KEY(Id_pacotes) REFERENCES Pacotes (Id_pacotes),
FOREIGN KEY(Id_cliente) REFERENCES Clientes (Id_cliente)
);

-- Criando (Create) --

insert into Pacotes values
(default, '10/05 - 10/06', 'Joao Pessoa - PB', '7299'),
(default, '30/05 - 20/06', 'Natal - RN', '2999'),
(default, '28/05 - 30/06', 'Patos - PB', '3299'),
(default, '03/02 - 05/03', 'Campina Grande - PB', '6299');

insert into Clientes values 
(default, 'thiago', '00012345605', 'thiago@gmail.com', '12345'),
(default,'Maria', '00112345605', 'maria@gmail.com', '12345'),
(default,'Valeria', '00112345605', 'valeria@gmail.com', '12345'),
(default,'Adnaldo', '00212345605', 'adnaldo@gmail.com', '12345');

insert into Compras values 
(default,'10/05/2023', '2', '1'),
(default,'20/06/2023', '3', '4'),
(default,'06/03/2023', '4', '3'),
(default,'10/07/2023', '1', '2');

-- Consulta (read) --

select * from Pacotes;
select * from Clientes;
select * from Compras;
select c.id_compras, c.Data_compras, cl.Nome_cliente, cl.Cpf_cliente, pdv.Periodo_Pacotes, pdv.Destino_Pacotes, pdv.Preco_Pacotes from compras c, clientes cl, pacotes pdv where c.id_compras = pdv.id_pacotes and c.id_cliente = cl.id_cliente;


-- Atualizando (update) --


UPDATE Clientes set Nome_cliente = "Queiroz Silva", Cpf_cliente = "08652547509" ,Email_cliente = "silva@gmail.com", Senha_cliente = "54321" where id_cliente = 1;
UPDATE Pacotes set Periodo_Pacotes = "12/10/23 - 20/20/23", Destino_Pacotes = "Maceio - AL" , Preco_Pacotes = "499" where Id_pacotes = 1;
UPDATE Compras set Data_compras = "05/07/1994", id_pacotes = 2, id_cliente = 3 where id_compras = 1;


-- Deletando (delete) --    

delete from Clientes where Id_cliente = 1;
delete from Compras where id_compras = 1;
delete from Pacotes where Id_pacotes = 1;
