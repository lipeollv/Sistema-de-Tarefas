package sistema.de.tarefas;

import java.time.LocalTime; // importando uma biblioteca de horário.

public class Tarefa { // criando uma classe.
    
    private DiaDaSemana diaDaSemana;
    private String nome; // criando um atributo do tipo String chamada "nome". para o nome da tarefa.
    private Importancia importancia; // criando um atributo do tipo enum que foi chamado de "Importancia". para a importancia da tarefa.
    private LocalTime horario; // criando um atributo com uma ferramenta da biblioteca LocalTime. para o horario da tarefa.
    private boolean concluida; // criando um atributo do tipo boolean chamado concluido. para dizer se a tarefa foi concluida ou não.
    private String categoria;
    
    public DiaDaSemana getDiaDaSemana() {
        return this.diaDaSemana;
    }
    
    enum Importancia { // criando um enum.
        BAIXA,
        MEDIA,
        ALTA,
    }
    
    enum DiaDaSemana {
        SEGUNDA,
        TERÇA,
        QUARTA,
        QUINTA,
        SEXTA
    }
    
    public Tarefa(DiaDaSemana diaDaSemana, String nome, Importancia importancia, LocalTime horario, String categoria) { // criando um construtor 
        this.diaDaSemana = diaDaSemana;
        this.nome = nome; 
        this.importancia = importancia;
        this.horario = horario;
        this.categoria = categoria;
    }
    
    public void tarefaConcluida() { // criando um método para quando a tarefa for concluida.
        this.concluida = true;
        
    }
    
    public void alterarNome(String novoNome) { // criando um método para mudar o nome da tarefa.
        this.nome = novoNome;
    }
    
    public void alterarImportancia(Importancia novaImportancia) { // criando um método para alterar a importancia da tarefa.
        this.importancia = novaImportancia;
    }   
    

    
    public void alterarHorario(LocalTime novoHorario) { // criando um método para alterar a importancia o horario da tarefa.
        this.horario = novoHorario;
    }
    
    public String obterResumo() { // método para criar uma ordem de resumo na impressão
        return "Tarefa: " + nome + " | Horario: " + horario ;
    }
}

