# teste_hbsis
Sistema de previsão do tempo

Sistema foi desenvolvido utilizando as seguintes tecnológias.

Java 1.8
Servidor de aplicação: Glassfish Server 4.1
IDE de Desenvolvimento: Netbeans 8.2
Framework JSF 2
Primefaces 5.3
Maven
Banco de dados mysql

E como requisito foi utilizada a API  http://openweathermap.org/api  


Para executar o projeto é necessário criar um banco de dados no mysql

create database hbsis;

use hbsis;

Um dos primeiros requisitos foi desenvolver uma aplicação web que permita o usuário cadastrar uma cidade "que" retorne dados da API, ou sejá, não é permitido deixar o usuário cadastrar uma cidade que não retorne dados da API.

Para desenvolver esse requisito a API Weather disponibiliza um arquivo list.city.json com todas as cidades cadastradas na base deles o que eu fiz foi baixar esse arquivo e importar pra dentro do meu mysql e então foi criada uma tabela "city" contendo todas as cidades da API. 
Em seguida eu criei uma tabela Country com a sigla de todos os paises. 

Estarei enviando por email o script das tabelas para serem executados no mysql.



