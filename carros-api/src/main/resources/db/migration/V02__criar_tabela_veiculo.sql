CREATE TABLE veiculo (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	modelo VARCHAR(20),
	ano_fabricacao DATE,
	ano_modelo DATE,
	placa VARCHAR(8),
	cor VARCHAR(10),
	id_marca BIGINT(20) NOT NULL,
	FOREIGN KEY (id_marca) REFERENCES marca(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
