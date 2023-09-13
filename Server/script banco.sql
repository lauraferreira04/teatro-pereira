create schema teatropereira;

use teatropereira;


CREATE TABLE usuario (
  idusuario int NOT NULL AUTO_INCREMENT,
  nomeusuario varchar(50),
  login varchar(40),
  senha varchar(40),
  cpf varchar(11),
  email varchar(60),
  telefone varchar(20),
  tipo tinyint COMMENT '0 -> admin | 1 -> comum',
  PRIMARY KEY (idusuario)
);

CREATE TABLE evento (
  idevento int NOT NULL AUTO_INCREMENT,
  nomeartista varchar(50),
  nomeevento varchar(50),
  datahora datetime,
  valor decimal(10,2),
  qtdcadeiras int,
  banner longblob,
  PRIMARY KEY (idevento)
);

CREATE TABLE reserva (
  idreserva int not null auto_increment,
  idevento int NOT NULL ,
  idusuario int not null,
  qtdingressos int,
  valortotal decimal(10,2),
  PRIMARY KEY (idreserva),
  FOREIGN KEY (idevento) REFERENCES evento (idevento),
  FOREIGN KEY (idusuario) REFERENCES usuario (idusuario)
);