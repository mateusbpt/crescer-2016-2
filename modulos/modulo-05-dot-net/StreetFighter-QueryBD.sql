Create table Personagem
(
Id int identity,
Nome varchar(60) not null,
Origem varchar(3) not null,
DataNascimento Datetime not null,
Altura int not null,
Peso decimal(6,2) not null,
GolpesEspeciais varchar(255) not null,
PersonagemOculto bit,
Imagem varchar(255),
	constraint PK_Id primary key (Id)
)

select *from Personagem

Create table Login 
(
Id int identity,
Nome varchar(40) not null,
Senha varchar(50) not null,
	constraint PK_Id_Login primary key (Id)
)

--Adicionando Logins:

Insert into Login(Nome, Senha) values ('bernardo', '3d0c5ff858a963d439286de99a5cf272') 
Insert into Login(Nome, Senha) values ('nunes', '6567759bef943353814159e104c1cd2e') 
Insert into Login(Nome, Senha) values ('admin', 'c393315309a671631bd05f746e6e1622') 

select * from Login

SELECT Nome, Senha from Login

--Adicionando Logins EF:

Insert into Cadastro([Login], Senha) values ('bernardo', '3d0c5ff858a963d439286de99a5cf272') 
Insert into Cadastro([Login], Senha) values ('nunes', '6567759bef943353814159e104c1cd2e') 
Insert into Cadastro([Login], Senha) values ('admin', 'c393315309a671631bd05f746e6e1622') 

select * from Personagem