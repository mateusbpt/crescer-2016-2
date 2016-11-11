--Exercicios

--Exercicio 1
select NomeEmpregado, DataAdmissao from Empregado order by DataAdmissao 

--Exercicio 2
select NomeEmpregado, Salario from Empregado where Cargo = 'Atendente' and Salario <= 18500.00

--Exercicio 3
select IDCidade from Cidade where Nome = 'Uberlândia'

--Exercicio 4
select IDCidade, nome from Cidade where UF = 'RS'