module sistema.de.tarefas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Você precisa abrir o pacote para o JavaFX conseguir ler suas classes
    opens sistema.de.tarefas to javafx.fxml;

    exports sistema.de.tarefas;
}