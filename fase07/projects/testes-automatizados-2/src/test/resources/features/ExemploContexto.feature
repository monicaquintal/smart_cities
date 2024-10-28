# language: pt

@regressivo
Funcionalidade: Deletar uma entrega
  Como usuário da API
  Quero conseguir deletar uma entrega
  Para que o registro seja apagado corretamente no sistema

  Contexto: Cadastro bem-sucedido de entrega
    Dado que eu tenha os seguintes dados da entrega:
      | campo          | valor        |
      | numeroPedido   | 1            |
      | nomeEntregador | Ana Silva    |
      | statusEntrega  | EM_SEPARACAO |
      | dataEntrega    | 2024-08-22   |
    Quando eu enviar a requisição para o endpoint "/entregas" de cadastro de entregas
    Então o status code da resposta deve ser 201

  Cenário: Deve ser possível deletar uma entrega
    Dado que eu recupere o ID da entrega criada no contexto
    Quando eu enviar a requisição com o ID para o endpoint "/entregas" de deleção de entrega
    Então o status code da resposta deve ser 204