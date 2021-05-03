drop user 'user'@'localhost';
drop schema ecomerce;

create schema ecomerce;

use ecomerce;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on ecomerce.* to user@'localhost';


create table cli_cliente (
  cli_id bigint unsigned not null auto_increment,
  cli_nome varchar(20) not null,
  cli_senha varchar(100) not null,
  cli_email varchar(50) not null,
  cli_idade int not null,
  
  PRIMARY KEY (cli_id),
  UNIQUE KEY uni_cli_email (cli_email)  
);


create table ped_pedido (
  ped_id bigint unsigned not null auto_increment,
  ped_nome varchar(50) not null,
  ped_valor int not null,
  cli_id bigint unsigned not null,
  primary key (ped_id),  
  unique key uni_ped_nome (ped_nome),
  foreign key pedcli_cli_fk (cli_id) references cli_cliente (cli_id) on delete restrict on update cascade
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

insert into cli_cliente(cli_nome, cli_senha, cli_email, cli_idade)
    values('Ariana', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C', 'ariana@email.com', 37);
insert into cli_cliente(cli_nome, cli_senha, cli_email, cli_idade)
    values('Ariana1','$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C', 'ariana1@email.com', 37);


insert into ped_pedido(ped_nome, ped_valor, cli_id)
    values('pedido01', 200, 1);
insert into ped_pedido(ped_nome, ped_valor, cli_id)
    values('pedido02', 400, 2);


insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN');
insert into aut_autorizacao (aut_nome)
    values ('ROLE_USUARIO');