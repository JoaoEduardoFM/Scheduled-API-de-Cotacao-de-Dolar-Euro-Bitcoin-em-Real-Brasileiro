# Consultar cotação atualizada em Scheduled

![image](https://github.com/JoaoEduardoFM/Scheduled-API-de-Cotacao-de-Dolar-Euro-Bitcoin-em-Real-Brasileiro/assets/90796699/ad218812-5b8a-43a1-b99c-11c72b55439a)


 > Status: Em desenvolvimento ⚠️

### É uma aplicação planejada por mim, onde realizo a Integração com o sistema conomia.awesomeapi e busco a cotação atualizada em um Scheduled.
Esta API de cotação de dólar, euro e bitcoin em real brasileiro fornece uma maneira simples e padronizada de acessar informações de câmbio atualizadas. Utilizando um escalonador parametrizado por um arquivo YAML, as cotações são buscadas regularmente e disponibilizadas através de endpoints específicos. Utilize esta API para integrar facilmente as cotações em seus aplicativos financeiros, serviços de conversão monetária e outras soluções relacionadas.
### Sistema integrado:(https://economia.awesomeapi.com.br/)

### Retorno exemplo:

  {"USDBRL":{"code":"USD","codein":"BRL","name":"Dólar Americano/Real Brasileiro","high":"4.8114","low":"4.8107","varBid":"0.0005","pctChange":"0.01","bid":"4.8102","ask":"4.8112","timestamp":"1686880577","create_date":"2023-06-15 22:56:17"},"EURBRL":{"code":"EUR","codein":"BRL","name":"Euro/Real Brasileiro","high":"5.273","low":"5.261","varBid":"-0.0038","pctChange":"-0.07","bid":"5.2611","ask":"5.2691","timestamp":"1686899443","create_date":"2023-06-16 04:10:43"},"BTCBRL":{"code":"BTC","codein":"BRL","name":"Bitcoin/Real Brasileiro","high":"124425","low":"120500","varBid":"2968","pctChange":"2.46","bid":"123694","ask":"123705","timestamp":"1686899464","create_date":"2023-06-16 04:11:04"}}

endpoints:
GET /usuario/buscaRegistros: Este endpoint retorna todos os usuários cadastrados, permitindo uma visualização completa da lista de usuários e suas respectivas informações.
GET /usuario/buscaPorId/{id}: Com este endpoint, é possível buscar um usuário específico com base no seu ID. Isso permite a recuperação detalhada das informações de um usuário em particular.
GET /usuario/buscaPorTitulo/{titulo}: Ao utilizar este endpoint, você pode buscar usuários com base no título. Isso é útil para encontrar usuários específicos que possuem um determinado título relacionado às atividades.
GET /usuario/buscaPorDescricao/{descricao}: Aqui, é possível buscar usuários com base em uma descrição específica. Essa funcionalidade permite a localização de usuários que tenham atividades com uma determinada descrição.
GET /usuario/buscaPorDataConclusao/{data}: Com este endpoint, é possível buscar usuários com base em sua data de conclusão. Isso facilita a identificação de usuários que concluíram suas atividades em uma determinada data.
GET /usuario/buscaPorStatus/{status}: Este endpoint permite buscar usuários com base no status de suas atividades, fornecendo uma visão dos usuários com atividades concluídas ou em andamento.
GET /usuario/buscaPorPrioridade/{prioridade}: Com este endpoint, você pode buscar usuários com base na prioridade de suas atividades. Isso permite identificar usuários que possuem atividades de alta prioridade.
POST /usuario/cadastraRegistro: Utilizando este endpoint, é possível cadastrar um novo usuário com suas respectivas informações e atividades relacionadas.
PUT /usuario/atualizaRegistro/{id}: Com esse endpoint, é possível atualizar as informações de um usuário existente com base no seu ID.
PATCH /usuario/atualizaParcialmente/{id}: Este endpoint permite atualizar parcialmente as informações de um usuário, fornecendo apenas os campos que desejam ser modificados.
DELETE /usuario/deletaUsuario/{id}: 

## Tecnologias usadas:
![header](https://user-images.githubusercontent.com/90796699/228732700-385f1245-70e2-4afa-8fcb-3838c43cc3d1.png)
![header](https://user-images.githubusercontent.com/90796699/228732963-6bafac5b-bb12-4e8d-b72a-47b3798f7bc3.png)
![header](https://user-images.githubusercontent.com/90796699/229381110-73a2592a-5e58-4948-ae38-a179cc119e10.png)
<table>
  <tr>
    <td>Java</td>
    <td>spring-boot</td>
    <td>H2</td>
  </tr>
  <tr>
    <td>17</td>
    <td>2.5.3</td>
    <td>h2</td>
  </tr>
</table>

## Esses recursos estão em desenvolvimento:

- Em desenvolvimento ⚠️
