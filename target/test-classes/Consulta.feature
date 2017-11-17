@Consulta
Feature: Testar uma cotacao de seguro de automoveis. 

	Para conhecer o seguro de Automoveis
 	Como um usuário
 	Eu quero fazer uma cotacao ao seguro de automoveis
 	De modo que eu consiga a página de seguro de automoveis
 	
@enable
@start
Scenario: Consulta cotacao de seguro de automoveis 
	Given que eu estou na pagina inicial da porto seguros 
	When eu clicar no link faca uma cotacao
	Then deverei validar se estou na pagina de iniciar cotacao
	When informar um nome Válido
	And informar um cpf Válido
	And informar um email Válido
	
	