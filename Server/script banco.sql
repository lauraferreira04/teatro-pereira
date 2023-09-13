create schema teatropereira;

use teatropereira;


CREATE TABLE usuario (
  idusuario int NOT NULL AUTO_INCREMENT,
  nomeusuario varchar(50) NOT NULL,
  login varchar(40) NOT NULL,
  senha varchar(40) NOT NULL,
  cpf varchar(14) NOT NULL,
  email varchar(60) NOT NULL,
  telefone varchar(20) NOT NULL,
  tipo tinyint NOT NULL COMMENT '0 -> admin | 1 -> comum',
  PRIMARY KEY (idusuario)
);

CREATE TABLE evento (
  idevento int NOT NULL AUTO_INCREMENT,
  nomeevento varchar(50) NOT NULL,
  nomeartista varchar(50) NOT NULL,
  datahora datetime NOT NULL,
  valor decimal(10,2) NOT NULL,
  qtdcadeiras int NOT NULL,
  banner longblob NOT NULL,
  PRIMARY KEY (idevento)
);

CREATE TABLE reserva (
  idreserva int not null auto_increment,
  idevento int NOT NULL ,
  idusuario int NOT null,
  qtdingressos int NOT NULL,
  valortotal decimal(10,2) NOT NULL,
  PRIMARY KEY (idreserva),
  FOREIGN KEY (idevento) REFERENCES evento (idevento),
  FOREIGN KEY (idusuario) REFERENCES usuario (idusuario)
);