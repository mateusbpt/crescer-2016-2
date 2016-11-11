create table Personagem
(
id int identity primary key,
nome varchar(60) not null,
origem varchar(3) not null,
dataNascimento datetime not null,
altura int not null,
peso decimal(6,2) not null,
golpesEspeciais varchar(255) not null,
personagemOculto bit,
imagem varchar(255)
)

insert into Personagem values
(
'Chun-Li',
'JP',
'12/12/2000 00:00:00',
12,
12.50,
'Teste',
0,
'https://upload.wikimedia.org/wikipedia/en/f/f4/Chun-Li_tatsunoko.png'
)



select * from Personagem