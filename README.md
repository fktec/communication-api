# Communication API (Incompleto)
- Java 8 - Spring Boot (2+)

### Objetivo
O objetivo nesta sprint é o de prover 3 serviços (endpoints) relativos ao envio de comunicação
da empresa.
- Agendamento de envio de comunicação;
- Consulta do envio da comunicação;
- Cancelamento do envio da comunicação.

### Requisitos
- Criar um endpoint que receba uma solicitação de agendamento de envio de comunicação (1);
Este endpoint precisa ter, no mínimo, os seguintes campos:
• Data/Hora para o envio
• Destinatário
• Mensagem a ser entregue

Os possíveis formatos de comunicação que podem ser enviados são:
• email, sms, push e whatsapp

- Neste momento, precisamos deste canal de entrada para realizar o agendamento do envio, ou
seja, este endpoint (1).
- O envio em si não será desenvolvido nesta etapa: você não precisa se preocupar com a
implementação do envio propriamente dito.
- Para esta sprint, ficou decidido que a solicitação do agendamento do envio da comunicação
será salva no banco de dados. Portanto, assim que receber a solicitação do agendamento do
envio (1), ela deverá ser salva no banco de dados.
- Pense com atenção nessa estrutura do banco. Apesar de não ser você quem vai realizar o
envio, essa estrutura já precisa estar pronta para que um colega seu não precise alterar nada
quando for desenvolver esta funcionalidade.
- A preocupação no momento do envio será a de enviar e alterar o status do registro no banco
de dados. Contemple este ponto na sua modelagem da base de dados.
- Deve ter um endpoint para consultar o status do agendamento de envio de comunicação (2). O
agendamento será feito no endpoint (1) e a consulta será feita por este outro endpoint (2).
- Deve ter um endpoint para cancelar um agendamento de envio de comunicação (3).

### Recursos (Dicas)
- Docker File
- Docker Compose

### Algumas melhorias possíveis
- Handler exception = Para padronizar todas as respostas de erro do componente.
- Cachê = Ativar a opção de cachê nas consultas
- Legibilidade Testes = Devido ao uso do MOCKITO ser bastante verboso.
- Autenticação = Disponibilizando autenticação (OAUTH2)
- Logs = Gerar logs em pontos de importância na aplicação.
