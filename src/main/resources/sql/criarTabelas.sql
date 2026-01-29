CREATE TABLE Autor (
    id UUID NOT NULL PRIMARY KEY,
    nome VARCHAR( 254 ) NOT NULL,
    data_nascimento DATE NOT NULL,
    nacionalidade VARCHAR( 254 ) NOT NULL
);

CREATE TABLE Livro (
    id UUID NOT NULL PRIMARY KEY,
    isbn VARCHAR( 10 ) NOT NULL,
    titulo VARCHAR( 254 ) NOT NULL,
    data_publicacao DATE NOT NULL,
    genero VARCHAR( 30 ) NOT NULL,
    preco NUMERIC( 18, 2 ),
    id_autor UUID NOT NULL REFERENCES Autor( id ),

    CONSTRAINT chk_genero CHECK( genero in ( 'FICCAO', 'FANTASIA', 'MISTERIO' ) )
);