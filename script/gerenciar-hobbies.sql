CREATE SCHEMA hobbies;

create table hobbies.autores(

  id serial primary key,
  nome varchar(100),
  nome_artistico varchar(100),
  data_nascimento date,
  sexo varchar(1),
  telefone varchar(15),
  email varchar(100) unique,
  data_hora_criacao timestamp default current_timestamp,
  data_hora_ultima_modificacao timestamp default current_timestamp
);


create table hobbies.editoras(

  id serial primary key,
  nome varchar(200),
  telefone varchar(15),
  email varchar(100) unique,
  data_hora_criacao timestamp default current_timestamp,
  data_hora_ultima_modificacao timestamp default current_timestamp

);

create table hobbies.enderecos(

  id serial primary key,
  cep integer,
  logradouro varchar(200),
  complemento varchar(200),
  bairro varchar(200),
  cidade varchar(200),
  uf varchar(2),
  autor_id integer not null,
  data_hora_criacao timestamp default current_timestamp,
  data_hora_ultima_modificacao timestamp default current_timestamp,
  foreign key (autor_id) references hobbies.autores (id)
);

create table hobbies.livros(

  id serial primary key,
  titulo varchar(200),
  genero varchar(100),
  edicao varchar(100),
  volume integer,
  paginas integer,
  data_publicacao date,
  isbn integer,
  preco numeric(7,2),
  avaliacao varchar(100),
  estrelas integer,
  editora_id integer not null,
  data_hora_criacao timestamp default current_timestamp,
  data_hora_ultima_modificacao timestamp default current_timestamp,
  foreign key (editora_id) references hobbies.editoras (id)
);

create table hobbies.autores_livros(

  id serial primary key,
  autor_id integer not null,
  livro_id integer not null,
  foreign key (autor_id) references hobbies.autores (id),
  foreign key (livro_id) references hobbies.livros (id)
);