CREATE DATABASE EXPLORE_DESCUBRA;

USE EXPLORE_DESCUBRA;

CREATE TABLE  Clientes (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(40),
    cpf VARCHAR(11),
    email VARCHAR(80),
    senha VARCHAR(10)
);

CREATE TABLE  Pacotes (
    id_pacotes INTEGER PRIMARY KEY AUTO_INCREMENT,
    periodo_pacotes VARCHAR(40),
    destino_pacotes VARCHAR(40),
    preco_pacotes DECIMAL(40, 2)
);

CREATE TABLE  Compras (
    id_compras INTEGER PRIMARY KEY AUTO_INCREMENT,
    data_compras VARCHAR(40),
    id_pacotes INTEGER,
    id INTEGER,
    periodo_pacotes VARCHAR(40),
    destino_pacotes VARCHAR(40),
    FOREIGN KEY(id_pacotes) REFERENCES Pacotes (id_pacotes),
    FOREIGN KEY(id) REFERENCES Clientes (id)
);

-- Criando (Create) --

INSERT INTO Pacotes VALUES
(default, '10/05 - 10/06', 'Joao Pessoa - PB', 7299),
(default,'30/05 - 20/06', 'Natal - RN', 2999),
(default,'28/05 - 30/06', 'Patos - PB', 3299),
(default,'03/02 - 05/03', 'Campina Grande - PB', 6299);

INSERT INTO Clientes VALUES
(default,'thiago', '00012345605', 'thiago@gmail.com', '12345'),
(default,'Maria', '00112345605', 'maria@gmail.com', '12345'),
(default,'Valeria', '00112345605', 'valeria@gmail.com', '12345'),
(default,'Adnaldo', '00212345605', 'adnaldo@gmail.com', '12345');

INSERT INTO Compras (data_compras, id_pacotes, id, periodo_pacotes, destino_pacotesperiodo_pacotesdestino_pacotes) 
VALUES
('10/05/2023', 2, 1, (SELECT periodo_pacotes FROM Pacotes WHERE id_pacotes = 2), (SELECT destino_pacotes FROM Pacotes WHERE id_pacotes = 2)),
('20/06/2023', 3, 4, (SELECT periodo_pacotes FROM Pacotes WHERE id_pacotes = 3), (SELECT destino_pacotes FROM Pacotes WHERE id_pacotes = 3)),
('06/03/2023', 4, 3, (SELECT periodo_pacotes FROM Pacotes WHERE id_pacotes = 4), (SELECT destino_pacotes FROM Pacotes WHERE id_pacotes = 4)),
('10/07/2023', 1, 2, (SELECT periodo_pacotes FROM Pacotes WHERE id_pacotes = 1), (SELECT destino_pacotes FROM Pacotes WHERE id_pacotes = 1));



-- Consulta (read) --

select * from Pacotes;
select * from Clientes;
select * from Compras;
select c.*, cl.*, pdv.* from compras c, clientes cl, pacotes pdv where c.id_compras = pdv.id_pacotes and c.id = cl.id;


-- Atualizando (update) --


UPDATE Clientes set nome = "Queiroz Silva", cpf = "08652547509" ,email = "silva@gmail.com", senha = "54321" where id = 1;
UPDATE Pacotes set periodo_pacotes = "12/10/23 - 20/20/23", destino_pacotes = "Maceio - AL" , preco_pacotes = "499" where id_pacotes = 1;
UPDATE Compras set data_compras = "05/07/1994", id_pacotes = 2, id = 3 where id_compras = 1;


-- Deletando (delete) --    

delete from Clientes where id = 1;
delete from Compras where id_compras = 1;
delete from Pacotes where Id_pacotes = 1;