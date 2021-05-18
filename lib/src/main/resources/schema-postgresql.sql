CREATE TABLE IF NOT EXISTS visitante (
     id serial PRIMARY KEY,
     nome varchar(50),
     email varchar(256),
     telefone numeric(11,0),
     mensagem varchar(500),
     formaContato varchar(10),
     periodo char(5)
);
