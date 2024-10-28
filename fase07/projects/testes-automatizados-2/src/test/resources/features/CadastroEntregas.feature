# language: pt

@regressivo
Funcionalidade: Cadastro de nova entrega
  Como usuário da API
  Quero cadastrar uma nova entrega
  Para que o registro seja salvo corretamente no sistema

  Cenário: Cadastro bem-sucedido de entrega
    Dado que eu tenha os seguintes dados da entrega:
      | campo          | valor        |
      | numeroPedido   | 1            |
      | nomeEntregador | Ana Silva    |
      | statusEntrega  | EM_SEPARACAO |
      | dataEntrega    | 2024-08-22   |
    Quando eu enviar a requisição para o endpoint "/entregas" de cadastro de entregas
    Então o status code da resposta deve ser 201

  @padrão
  Cenário: Cadastro de entrega sem sucesso ao passar o campo statusEntrega invalido
    Dado que eu tenha os seguintes dados da entrega:
      | campo          | valor      |
      | numeroPedido   | 1          |
      | nomeEntregador | Ana Silva  |
      | statusEntrega  | EM_ROTA    |
      | dataEntrega    | 2024-08-22 |
    Quando eu enviar a requisição para o endpoint "/entregas" de cadastro de entregas
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro da api deve retornar a mensagem "Dados fornecidos estão em formato inválido."