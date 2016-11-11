--Exercicios

--Questão 1
select * into CidadeAux from Cidade

--Questão 2
truncate table CidadeAux
insert into CidadeAux select * from Cidade

--Questão 3
Create table Produto 
(
  CodigoIdentificacao int identity not null,
  NomeCurto varchar(20) not null,
  NomeDescritivo varchar(100) not null,
  DataCriacao datetime default getdate() not null,
  LocalEstoque varchar(30) not null,
  Quantidade int not null,
  Preco decimal(8,2) not null,
  constraint PK_produto primary key(CodigoIdentificacao)
);	

-- Questão 4

insert into Produto(NomeCurto, NomeDescritivo, LocalEstoque, Quantidade, Preco)
values('Fifa 2017','Game para PC Fifa 2017', 'Games', 100, 229.90)

insert into Produto(NomeCurto, NomeDescritivo, LocalEstoque, Quantidade, Preco)
values('PES 2017','Game para PC PES 2017','Games', 20, 199.90)

select * from Produto