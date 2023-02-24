<h1>PIZZARIA_QUE_DELICIA<h1>**O Desafio**

Este desafio consiste em desenvolver uma aplicação para gerenciar um carrinho de compras de uma cafeteria fictícia, com as seguintes funcionalidades:

- Listagem de produtos disponíveis (cafés) para a compra

- Adicionar itens em um carrinho- Remover itens do carrinho- Exibir dados do carrinho- Realizar checkout- Consultar CEP

O exercício deverá resultar na **implementação de uma API Rest,** utilizando o framework/banco de sua preferência, com endpoints que contemplem todas as funcionalidades listadas acima.Todos endpoints devem checar se o usuário está autenticado para retornar alguma resposta.

As definições de cada endpoint, como verbo a ser utilizado, parâmetros e formato da resposta, ficam a cargo da pessoa desenvolvedora. Porém serão necessários os **seguintes endpoints** atendendo algumas regras:

1. Login, onde a API recebe um usuário e senha, verifica se são válidos, e retorna um token de autorização

2. Retornar o endereço associado à um CEP. Isso pode ser realizado via integração com APIs como [ViaCep]([https://viacep.com.br/](https://viacep.com.br/)), ou qualquer outra de sua preferência

3. Retornar uma lista de produtos, esse endpoint deve possuir funcionalidades de paginação, filtro e ordenação

4. Buscar um produto por id

5. Buscar o carrinho/pedido ativo de um usuário

6. Alterar detalhes de um pedido, como endereço de entrega e método de pagamento

7. Adicionar/remover itens a um carrinho/pedido

Por fim, será necessário:

1. **Configurar uma imagem docker e um arquivo docker-compose** para que o projeto possa ser facilmente executado via containers;
2. Gerar o swagger da aplicação com a documentação de cada endpoint e exemplos de resposta

Para este projeto, será necessário relembrar conceitos como:

- REST

- Autenticação / JWT

- HTTP (status, verbos, request params, query params)

- ORM / Database querying- Camadas utilizadas (service, model, repository, controller) 

- Modelagem de banco

- Validação de requisições

Além disso, o desafio requer conhecimentos sobre métodos e detalhes específicos de linguagens. Assim como lógica de programação.