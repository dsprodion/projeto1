Create table Cliente(
id int not null auto_increment primary key,
nome varchar(150),
telefone varchar(20),
cidade_id int
) ENGINE = InnoDB DEFAULT CHARSET=UTF8;

alter table Cliente add constraint FK_cliente_cidade foreign key (cidade_id) references Cidade(id);

insert into Cliente(nome,telefone,cidade_id) values('Vanessa','3298-2431',1);
insert into Cliente(nome,telefone,cidade_id) values('Amanda','3298-2231',1);
insert into Cliente(nome,telefone,cidade_id) values('Bruna','3298-2831',3);
insert into Cliente(nome,telefone,cidade_id) values('Caio','3298-3631',1);
insert into Cliente(nome,telefone,cidade_id) values('Veronica','3298-2441',5);
insert into Cliente(nome,telefone,cidade_id) values('Valéria','3298-3625',4);
insert into Cliente(nome,telefone,cidade_id) values('Larissa','3298-0341',1);
insert into Cliente(nome,telefone,cidade_id) values('Carla','3298-4891',1);
insert into Cliente(nome,telefone,cidade_id) values('Bianca','3206-2331',7);
insert into Cliente(nome,telefone,cidade_id) values('Camila','3298-2951',8);
insert into Cliente(nome,telefone,cidade_id) values('Juliana','3298-0416',2);