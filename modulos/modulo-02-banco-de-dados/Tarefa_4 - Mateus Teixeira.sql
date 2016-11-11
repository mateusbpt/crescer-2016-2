--Exercicio 1
select count(IDPedido) as Pedidos_Setembro_2016 from Pedido
	where month(DataPedido) = '09' and year(DataPedido) = '2016' 
		
--Exercicio 2
select Nome from Produto prod
	inner join ProdutoMaterial mat on mat.IDProduto = prod.IDProduto
		where IDMaterial = 15836	

--Exercicio 3
select IDCliente, Nome, RazaoSocial from Cliente	
	where RazaoSocial LIKE '%LTDA%'  or Nome LIKE '%LTDA%'

--Exercicio 4
insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
	values('Galocha Maragato', 35.67, 77.95, 'A')

--Exercicio 5
select prod.IDProduto,prod.Nome from Produto prod 
left join PedidoItem pedItem on prod.IDProduto = pedItem.IDProduto
	where pedItem.IDProduto is null

select IDProduto, Nome from Produto prod
	where not exists(Select 1 from PedidoItem item 
						where prod.IDProduto = item.IDProduto) 
	  
--Exercicio 6
select top(1) with ties count(1) as quantidade, UF from Cidade c
	inner join Cliente cli on cli.IDCidade = c.IDCidade
		group by UF
			order by quantidade desc 

--Exercicio 7 
