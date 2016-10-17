--Exercicio 1
select count(IDPedido) as Pedidos_Setembro_2016 from Pedido
	where month(DataPedido) = '09' and year(DataPedido) = '2016' 
		
--Exercicio 2
select Nome from Produto prod
	inner join ProdutoMaterial mat on mat.IDProduto = prod.IDProduto
		where IDMaterial = 15836	

--Exercicio 3
select Nome, RazaoSocial from Cliente	
	where RazaoSocial LIKE '%LTDA%'  or Nome LIKE '%LTDA%'

--Exercicio 4
insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
	values('Galocha Maragato', 35.67, 77.95, 'A')

--Exercicio 5

