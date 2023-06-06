CREATE TABLE topicos(

    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL UNIQUE,
    mensaje VARCHAR(250) NOT NULL UNIQUE,
    fecha_de_creacion DATE,
    estatus VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,

    PRIMARY KEY(id)
);