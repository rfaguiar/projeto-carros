CREATE TABLE usuario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(20) NOT NULL,
	login VARCHAR(10) NOT NULL,
	senha VARCHAR(10) NOT NULL	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
