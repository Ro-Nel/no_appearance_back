CREATE TABLE tipo_usuario (
    id_tipo_usuario int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipo_usuario varchar(100) NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL
);
CREATE TABLE administrador (
    id_administrador int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    apellido varchar(100) NOT NULL,
    nacimiento date NOT NULL,
    correo varchar(100) NOT NULL,
    contrasena varchar(100) NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL
);
CREATE TABLE cliente (
    id_cliente int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    apellido varchar(100) NOT NULL,
    nacimiento date NOT NULL,
    correo varchar(100) NOT NULL,
    contrasena varchar(100) NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL
);
CREATE TABLE chat (
    id_chat int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_cliente1 int NOT NULL,
    id_cliente2 int NOT NULL,
    estado int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL,
    FOREIGN KEY (id_cliente1)REFERENCES cliente (id_cliente),
    FOREIGN KEY (id_cliente2)REFERENCES cliente (id_cliente)
);
CREATE TABLE mensaje(
    id_mensaje int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    mensaje text NOT NULL,
    id_chat int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL,
    FOREIGN KEY (id_chat)REFERENCES chat(id_chat)
);
CREATE TABLE reporte(
    id_reporte int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_reportero int NOT NULL,
    id_reportado int NOT NULL,
    razon varchar(100) NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL,
    FOREIGN KEY (id_reportero)REFERENCES cliente (id_cliente),
    FOREIGN KEY (id_reportado)REFERENCES cliente (id_cliente)
);


CREATE TABLE categoria (
    id_categoria int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    categoria varchar(100) NOT NULL,
    foto text NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL
);
CREATE TABLE subcategoria (
    id_subcategoria int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    subcategoria varchar(100) NOT NULL,
    foto text NULL,
    id_categoria int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL,
    FOREIGN KEY (id_categoria)REFERENCES categoria(id_categoria)
);

CREATE TABLE cliente_subcategoria(
    id_cliente_subcategoria int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_cliente int NOT NULL,
    id_subcategoria int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL,
    FOREIGN KEY (id_subcategoria)REFERENCES cliente (id_cliente),
    FOREIGN KEY (id_cliente)REFERENCES cliente (id_cliente)
);

CREATE TABLE `no_appearance`.`match` (
    `id_match` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_cliente1 int NOT NULL,
    id_cliente2 int NOT NULL,
    estado int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL,
    FOREIGN KEY (id_cliente1)REFERENCES cliente (id_cliente),
    FOREIGN KEY (id_cliente2)REFERENCES cliente (id_cliente)
);

CREATE TABLE match_subcategoria (
    match_subcategoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_match` INT NOT NULL,
    id_subcategoria int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user int NOT NULL,
    tx_date timestamp NOT NULL,
    tx_update date NOT NULL,
    FOREIGN KEY (`id_match`) REFERENCES `no_appearance`.`match`(`id_match`),
    FOREIGN KEY (id_subcategoria) REFERENCES subcategoria(id_subcategoria)
);
