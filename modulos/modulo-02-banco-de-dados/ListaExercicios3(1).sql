--Exercicio 7:
Select emp.NomeEmpregado as Empregado,
			dep.NomeDepartamento as Departamento,
				ger.NomeEmpregado as Gerente
					from Empregado emp
						left join Empregado ger on emp.IDGerente = ger.IDEmpregado
							left join Departamento dep on dep.IDDepartamento = emp.IDDepartamento
							
--Exercicio 8: 
select IDEmpregado, 
	NomeEmpregado, 
	Cargo, 
	IDGerente, 
	DataAdmissao, 
	Salario, 
	Comissao, 
	IDDepartamento
	into CopiaEmpregado
		from Empregado


begin transaction 
update CopiaEmpregado 
	set Salario = Salario+((Salario/100)*14.5)
		from CopiaEmpregado emp inner join Departamento dep on dep.IDDepartamento = emp.IDDepartamento
								where Localizacao = 'SAO PAULO'		
commit	

--Exercicio 9:
select (select sum(c.Salario)-sum(e.Salario) 
	from CopiaEmpregado c) as Diferenca
		from Empregado e

			
--Exercicio 10: 
	Select  top(1) with ties NomeDepartamento, max(Salario) as MaiorSalario
		from Empregado emp
			left join Departamento dep on dep.IDDepartamento = emp.IDDepartamento
				group by NomeDepartamento
					order by MaiorSalario desc
