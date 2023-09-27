create table topicos (
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(255) not null unique,
    autor varchar(255) not null,
    curso varchar(255) not null,
    status varchar(100) not null,
    data datetime not null,



    primary key (id)

);