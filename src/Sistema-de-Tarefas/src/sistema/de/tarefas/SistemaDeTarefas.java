package sistema.de.tarefas;

import java.time.LocalTime; // importando a biblioteca LocalTime
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class SistemaDeTarefas { // criando uma classe 

    public static void main(String[] args) { // criando um método sem retorno (void).
        Tarefa s1 = new Tarefa( Tarefa.DiaDaSemana.SEGUNDA,"Acordar", Tarefa.Importancia.ALTA, LocalTime.of(7, 0), "Rotina"); // criando um novo objeto e colocando as informações desse novo objeto conforme o contrutor.
        Tarefa s2 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Cafe da Manha", Tarefa.Importancia.ALTA, LocalTime.of(7, 15), "Rotina");
        Tarefa s3 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Trabalho ent", Tarefa.Importancia.ALTA, LocalTime.of(7, 45), "Rotina");
        Tarefa s4 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Almoco", Tarefa.Importancia.ALTA, LocalTime.of(13, 0), "Rotina");
        Tarefa s5 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Pausa mental", Tarefa.Importancia.MEDIA, LocalTime.of(13, 30), "Disciplina");
        Tarefa s6 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Trabalho sair", Tarefa.Importancia.ALTA, LocalTime.of(17, 0), "Rotina");
        Tarefa s7 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Dar oi Sophia/Laura", Tarefa.Importancia.ALTA, LocalTime.of(17, 15), "Rotina");
        Tarefa s8 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Lanchar", Tarefa.Importancia.ALTA, LocalTime.of(17, 30), "Rotina");
        Tarefa s9 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Meditar", Tarefa.Importancia.MEDIA, LocalTime.of(17, 50), "Disciplina");
        Tarefa s10 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Academia", Tarefa.Importancia.ALTA, LocalTime.of(18, 0), "Disciplina");
        Tarefa s11 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Estudar 30min - Fisica", Tarefa.Importancia.ALTA, LocalTime.of(19, 30), "Estudo");
        Tarefa s12 = new Tarefa(Tarefa.DiaDaSemana.SEGUNDA, "Dormir", Tarefa.Importancia.ALTA, LocalTime.of(23, 0), "Disciplina");
        Tarefa t1 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Acordar", Tarefa.Importancia.ALTA, LocalTime.of(7, 0), "Rotina");
        Tarefa t2 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Cafe da Manha", Tarefa.Importancia.ALTA,  LocalTime.of(7, 15), "Rotina");
        Tarefa t3 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Trabalho ent", Tarefa.Importancia.ALTA,  LocalTime.of(7, 45), "Rotina");
        Tarefa t4 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Almoco", Tarefa.Importancia.ALTA,  LocalTime.of(13, 0), "Rotina");
        Tarefa t5 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Pausa mental", Tarefa.Importancia.MEDIA,  LocalTime.of(13, 30), "Disciplina");
        Tarefa t6 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Trabalho sair", Tarefa.Importancia.ALTA,  LocalTime.of(17, 0), "Rotina");
        Tarefa t7 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Dar oi Sophia/Laura", Tarefa.Importancia.ALTA,  LocalTime.of(17, 15), "Rotina");
        Tarefa t8 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Lanchar", Tarefa.Importancia.ALTA,  LocalTime.of(17, 30), "Rotina");
        Tarefa t9 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Meditar", Tarefa.Importancia.MEDIA,  LocalTime.of(17, 50), "Disciplina");
        Tarefa t10 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Estudar 40min - JAVA", Tarefa.Importancia.ALTA,  LocalTime.of(18, 0), "Estudo");     
        Tarefa t11 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Faculdade", Tarefa.Importancia.ALTA,  LocalTime.of(19, 0), "Estudo");
        Tarefa t12 = new Tarefa(Tarefa.DiaDaSemana.TERÇA, "Dormir", Tarefa.Importancia.ALTA,  LocalTime.of(23, 30), "Disciplina");
        Tarefa q1 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Acordar", Tarefa.Importancia.ALTA, LocalTime.of(7, 0), "Rotina"); 
        Tarefa q2 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Cafe da Manha", Tarefa.Importancia.ALTA, LocalTime.of(7, 15), "Rotina");        
        Tarefa q3 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Trabalho ent", Tarefa.Importancia.ALTA, LocalTime.of(7, 45), "Rotina");  
        Tarefa q4 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Almoco", Tarefa.Importancia.ALTA, LocalTime.of(13, 10), "Rotina");         
        Tarefa q5 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Pausa mental", Tarefa.Importancia.MEDIA, LocalTime.of(13, 30), "Disciplina");         
        Tarefa q6 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Trabalho sair", Tarefa.Importancia.ALTA, LocalTime.of(17, 0), "Rotina");         
        Tarefa q7 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Dar oi Sophia/Laura", Tarefa.Importancia.ALTA, LocalTime.of(17, 15), "Rotina");      
        Tarefa q8 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Lanchar", Tarefa.Importancia.ALTA, LocalTime.of(17, 30), "Rotina");          
        Tarefa q9 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Meditar", Tarefa.Importancia.MEDIA, LocalTime.of(17, 50), "Disciplina");          
        Tarefa q10 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Academia", Tarefa.Importancia.ALTA, LocalTime.of(18, 0), "Disciplina");         
        Tarefa q11 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Faculdade", Tarefa.Importancia.ALTA, LocalTime.of(19, 0), "Rotina");          
        Tarefa q12 = new Tarefa(Tarefa.DiaDaSemana.QUARTA, "Dormir", Tarefa.Importancia.ALTA, LocalTime.of(23, 30), "Rotina");
        Tarefa i1 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Acordar", Tarefa.Importancia.ALTA, LocalTime.of(7, 0), "Rotina");
        Tarefa i2 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Cafe da Manha", Tarefa.Importancia.ALTA, LocalTime.of(7, 15), "Rotina");      
        Tarefa i3 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Trabalho ent", Tarefa.Importancia.ALTA, LocalTime.of(7, 45), "Rotina");        
        Tarefa i4 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Almoco", Tarefa.Importancia.ALTA, LocalTime.of(13, 0), "Rotina");
        Tarefa i5 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Pausa mental", Tarefa.Importancia.MEDIA, LocalTime.of(13, 30), "Disciplina");  
        Tarefa i6 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Trabalho sair", Tarefa.Importancia.ALTA, LocalTime.of(17, 0), "Rotina");  
        Tarefa i7 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Dar oi Sophia/Laura", Tarefa.Importancia.ALTA, LocalTime.of(17, 15), "Rotina");  
        Tarefa i8 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Lanchar", Tarefa.Importancia.ALTA, LocalTime.of(17,30), "Rotina");  
        Tarefa i9 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Meditar", Tarefa.Importancia.MEDIA, LocalTime.of(17, 50), "Disciplina");  
        Tarefa i10 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Estudar 40min - Calculo", Tarefa.Importancia.ALTA, LocalTime.of(18, 0), "Estudo");  
        Tarefa i11 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Faculdade", Tarefa.Importancia.ALTA, LocalTime.of(19, 0), "Rotina");  
        Tarefa i12 = new Tarefa(Tarefa.DiaDaSemana.QUINTA, "Dormir", Tarefa.Importancia.ALTA, LocalTime.of(23, 30), "Rotina");  
        Tarefa f1 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Acordar", Tarefa.Importancia.ALTA, LocalTime.of(7, 0), "Rotina");
        Tarefa f2 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Cafe da Manha", Tarefa.Importancia.ALTA, LocalTime.of(7, 15), "Rotina");
        Tarefa f3 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Trabalho ent", Tarefa.Importancia.ALTA, LocalTime.of(7, 45), "Rotina");
        Tarefa f4 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Almoco", Tarefa.Importancia.ALTA, LocalTime.of(13, 0), "Rotina");
        Tarefa f5 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Pausa mental", Tarefa.Importancia.MEDIA, LocalTime.of(13, 30), "Disciplina");
        Tarefa f6 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Trabalho sair", Tarefa.Importancia.ALTA, LocalTime.of(17, 0), "Rotina");
        Tarefa f7 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Dar oi Sophia/Laura", Tarefa.Importancia.ALTA, LocalTime.of(17, 15), "Rotina");
        Tarefa f8 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Lanchar", Tarefa.Importancia.ALTA, LocalTime.of(17, 30), "Rotina");
        Tarefa f9 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Meditar", Tarefa.Importancia.MEDIA, LocalTime.of(17, 50), "Disciplina");
        Tarefa f10 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Academia", Tarefa.Importancia.ALTA, LocalTime.of(18, 0), "Rotina");
        Tarefa f11 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Estudar 30min - Calculo",  Tarefa.Importancia.ALTA, LocalTime.of(19, 30), "Estudo");
        Tarefa f12 = new Tarefa(Tarefa.DiaDaSemana.SEXTA, "Dormir", Tarefa.Importancia.ALTA, LocalTime.of(23, 30),  "Rotina");

                
         ArrayList<Tarefa> listaDeTarefas = new ArrayList(Arrays.asList(s1, s2, s3 , s4, s5, s6, s7, s8, s9, s10, s11, s12, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12,
                 f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12)); // salvando todas as terefas dentro de uma lista array com nome de "listaDeTarefas"
         
        Scanner input = new Scanner(System.in); // variável para salvar o que o usuário escrever
        
        
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.println("Digite um dia da Semana para obter a rotina (SEGUNDA, TERÇA, QUARTA, QUINTA OU SEXTA): "); // input para perguntar para o usuário o dia da semana
                String resposta = input.nextLine(); // variável para salvar a resposta do usuário
                Tarefa.DiaDaSemana diaEscolhido = Tarefa.DiaDaSemana.valueOf(resposta.toUpperCase()); // transformar a resposta do usuário em enum para comparar no if
                
                for (Tarefa t : listaDeTarefas) { // iniciar um loop que só pertente a classe "Tarefa" chamado "t" que percorre toda a listaDeTarefas
                    if ( t.getDiaDaSemana() == diaEscolhido) { // se o dia da semana for igual a resposta
                         System.out.println(t.obterResumo()); // imprime o resumo do dia da semana
                     
                             } 
                        } 
                    entradaValida = true;
                
               } catch (IllegalArgumentException e) {
                        System.out.println("Erro! digite um dia da semana valido.");
                    }
        }   
    }
}
    
