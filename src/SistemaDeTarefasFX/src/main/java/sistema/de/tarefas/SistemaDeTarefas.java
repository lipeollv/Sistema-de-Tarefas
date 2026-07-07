package sistema.de.tarefas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;



public class SistemaDeTarefas { // criando uma classe 
    public static ArrayList<Tarefa> listaDeTarefas;

    public static void inicializarTarefas() {
        Tarefa p1 = new Tarefa(
                "147285",
                "João",
                LocalDate.of(2026,7,1),
                LocalDate.of(2026,7,21),
                16,
                "Contestar Petição",
                "TJAM",
                Tarefa.Situacao.PENDENTE,
                "Cível",
                "Gabi"

        );

        listaDeTarefas = new ArrayList<>(Arrays.asList(p1));
    }

}
    
