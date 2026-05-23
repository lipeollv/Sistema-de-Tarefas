package sistema.de.tarefas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;


/**
 * JavaFX App
 */
public class App extends Application{


    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
       // criação de botões;
        var btnSegunda = new Button("Segunda");
        var btnTerca = new Button("Terça");
        var btnQuarta = new Button("Quarta");
        var btnQuinta = new Button("Quinta");
        var btnSexta = new Button ("Sexta");
        
        // criação de uma area de texto;
        var areaResumo = new TextArea();
        
        // aplicando ações quando um botão é clicado;
        btnSegunda.setOnAction(e -> {
            String textoFinal = "Rotina Segunda-Feira:\n";
            
            for (Tarefa t: SistemaDeTarefas.listaDeTarefas) {
                if (t.getDiaDaSemana() == Tarefa.DiaDaSemana.SEGUNDA) {
                    textoFinal += t.obterResumo() + "\n";
                }
            } areaResumo.setText(textoFinal);
            
        }); btnTerca.setOnAction(e -> {
            areaResumo.setText("Rotina Terça-Feira:");
        }); btnQuarta.setOnAction(e -> {
            areaResumo.setText("Rotina Quarta-Feira:"); 
        }); btnQuinta.setOnAction(e -> {
            areaResumo.setText("Rotina Quinta-Feira:");
        }); btnSexta.setOnAction(e -> {
            areaResumo.setText("Rotina Sexta-Feira:");
        });
        
        // colocando todos os botões criados em uma linha vertical (VBox);
        var linhaBotoes = new VBox(60);
        linhaBotoes.getChildren().addAll(btnSegunda, btnTerca, btnQuarta, btnQuinta, btnSexta);
        
        // colocando os botões e a area de texto lado a lado usando uma linha horizontal (VBox);
        var colunas = new HBox(70);
        colunas.getChildren().addAll(linhaBotoes, areaResumo);
        
        // uma variável para mostrar na interface do programa;
        var scene = new Scene(colunas, 640, 480);   
        
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}