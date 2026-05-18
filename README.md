Classe tarefas  
- nome String
- importancia enum
- horário LocalTime
- concluida (true/false) boolean
- categoria String

Métodos
- tarefaConcluida (alterar a tarefa para concluida)
- alterarNome (mudar nome da tarefa)
- alterarImportancia (mudar a importancia da tarefa)
- alterarHorario (mudar horario da tarefa)
- obterResumo (mostrar o resumo das minhas tarefas (semanal))






o programa irá funcionar como uma espécie de controlador de tarefas, aonde você conseguirá: adicionar/remover tarefas,  filtrar as tarefas nos dias específicos e ver quais tarefas estão pendentes para esse dia e conseguir marcar quais tarefas você já completou.

primeiro preciso declarar todos os atributos necessários para os objetos, criar métodos importantes para a acessibilidade do usuário (eu). a ideia vai começar com: criar um método simples que ira sempre pegar um resumo das tarefas com os atributos especificados delas (nome, horário, etc...). a próxima ideia é salvar todas essas informações em dias específicos para o programa ficar mais encapsulado e organizado. depois criado um array-list para salvar todos os dados dos dias das semanas específicos.

a próxima ideia é criar um input para que o sistema pergunte ao usuário quais dias da semana ele quer obter o resumo (utilizando a biblioteca java.util.Scanner;). 

try-catch para se o usuário digitar algo além de um dia da semana, ele diz que não é um dia da semana válido e faz a solicitação novamente.
