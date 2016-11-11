--Exercicios

--Exercicio 1:
select Empregado from Projeto
	group by Empregado
		having count(1) > 1 

--Exercicio 2:
select Projeto from Projeto
	where (ValorFaturado-ValorRealizado) > 0
		group by Projeto	
				
--Exercicio 3: 				
select Projeto,
	((100*abs(ValorFaturado-ValorRealizado))/ValorFaturado) as Porcentagem
		from Projeto
			where (ValorFaturado-ValorRealizado) < 0
				group by Projeto, ValorRealizado, ValorFaturado	
					
--Exercicio 4:
	select Empregado,
		case when CHARINDEX(' ', Empregado) = 0 then SUBSTRING(Empregado, 1,len(empregado))
			else SUBSTRING(Empregado, 1, CHARINDEX(' ', Empregado)) end Primeiro_Nome
				from Projeto
					group by Empregado 
				