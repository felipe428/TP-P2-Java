CREATE TABLE IF NOT EXISTS visitante (
     id serial PRIMARY KEY,
     nome varchar(50),
     email varchar(256),
     mensagem varchar(500)
);

CREATE TABLE IF NOT EXISTS cardapio (
     id serial PRIMARY KEY,
     nome varchar(50),
     descricao varchar(300),
     preco numeric(3,2)
);

ALTER TABLE cardapio
ALTER COLUMN preco TYPE numeric(5,2);
