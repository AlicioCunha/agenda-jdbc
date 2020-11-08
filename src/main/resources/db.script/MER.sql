-- criaca do banco agenda
CREATE DATABASE agenda;
-- marca para usar o banco
USE agenda;

-- criacao da tabela de usuarios
CREATE TABLE usuario(
	id int not null auto_increment primary key,
    nome varchar(50) not null
);
-- criacao da tabela de locais
CREATE TABLE local(
	id int not null auto_increment primary key,
    nome varchar(50) not null
);

-- criacao da tabela de lista de tarefas
CREATE TABLE lista_tarefa(
	id int not null auto_increment primary key,
    descricao varchar(100) not null,
    data_cadastro datetime default now(),
    status_tarefa int not null default 1,
    data_execucao datetime,
    data_conclusao datetime,
    observacao varchar(1000),
    local_id int,
    usuario_id int
);
-- 1 - PENDENTE - 2 - FAZENDO - 3 - CONCLUIDO - 4 - CANCELADO

-- adicionado a chave estrangeira entre lista de tarefas e local
ALTER TABLE lista_tarefa ADD FOREIGN KEY fk_lista_tarefa_local (local_id)
					REFERENCES local(id);

-- adicionado a chave estrangeira entre lista de tarefas e usuario
ALTER TABLE lista_tarefa ADD FOREIGN KEY fk_lista_tarefa_usuario (usuario_id)
					REFERENCES usuario(id);

-- adiciona um novo usuario
insert into usuario(nome) values ('alicio');

-- buscar as informações da tabela usuario
select * from usuario;

-- adiciona um novo local
insert into local(nome) values ('Celesc');
insert into local(nome) values ('Cooper');

-- buscar as informações da tabela local
select * from local;

insert into lista_tarefa(descricao, 	 observacao,              local_id, usuario_id)
				values('Ir ao mercado',  'Comprar arroz e feijão', 2,        1);

select * from lista_tarefa;

desc local;