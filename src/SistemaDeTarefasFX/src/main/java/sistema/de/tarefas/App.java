package sistema.de.tarefas;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.net.DatagramPacket;
import java.time.LocalDate;

public class App extends Application {
    private javafx.collections.ObservableList<Tarefa> dados;
    private TableView<Tarefa> tabela;

    @Override
    public void start(Stage stage) {
        carregarDoArquivo();

        tabela = new TableView<>();
        tabela.setItems(dados);

        TableColumn<Tarefa, String> colunaProcesso = new TableColumn<>("Número do Processo");
        colunaProcesso.setCellValueFactory(new PropertyValueFactory<>("processo"));

        TableColumn<Tarefa, String> colunaCliente = new TableColumn<>("Nome do Cliente");
        colunaCliente.setCellValueFactory(new PropertyValueFactory<>("nomeDoCliente"));

        TableColumn<Tarefa, String> colunaIntimacao = new TableColumn<>("Data Intimação");
        colunaIntimacao.setCellValueFactory(new PropertyValueFactory<>("dataIntimacao"));

        TableColumn<Tarefa, String> colunaLimite = new TableColumn<>("Limite Intimação");
        colunaLimite.setCellValueFactory(new PropertyValueFactory<>("dataLimite"));

        TableColumn<Tarefa, String> colunaDiasRestantes = new TableColumn<>("Dias Restantes");
        colunaDiasRestantes.setCellValueFactory(new PropertyValueFactory<>("DiasRestantes"));

        TableColumn<Tarefa, String> colunaPrazoEmDias = new TableColumn<>("Prazo em Dias");
        colunaPrazoEmDias.setCellValueFactory(new PropertyValueFactory<>("prazoEmDias"));

        TableColumn<Tarefa, String> colunaOqueFazer = new TableColumn<>("O que Fazer");
        colunaOqueFazer.setCellValueFactory(new PropertyValueFactory<>("oQueFazer"));

        TableColumn<Tarefa, String> colunaTribunal = new TableColumn<>("Tribunal");
        colunaTribunal.setCellValueFactory(new PropertyValueFactory<>("tribunal"));

        TableColumn<Tarefa,String> colunaSituacao = new TableColumn<>("Situação");
        colunaSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));

        TableColumn<Tarefa, String> colunaCategoria = new TableColumn<>("Categoria");
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        TableColumn<Tarefa, String> colunaAdvogado = new TableColumn<>("Advogado");
        colunaAdvogado.setCellValueFactory(new PropertyValueFactory<>("advogado"));

        tabela.getColumns().add(colunaProcesso);
        tabela.getColumns().add(colunaCliente);
        tabela.getColumns().add(colunaIntimacao);
        tabela.getColumns().add(colunaLimite);
        tabela.getColumns().add(colunaDiasRestantes);
        tabela.getColumns().add(colunaPrazoEmDias);
        tabela.getColumns().add(colunaOqueFazer);
        tabela.getColumns().add(colunaTribunal);
        tabela.getColumns().add(colunaSituacao);
        tabela.getColumns().add(colunaCategoria);
        tabela.getColumns().add(colunaAdvogado);

        tabela.setRowFactory(tv -> {
            TableRow<Tarefa> linha = new TableRow<>();
            ContextMenu menuContexto = new ContextMenu();
            MenuItem itemExcluir = new MenuItem("Excluir");
            MenuItem itemEditar = new MenuItem("Editar");
            MenuItem itemAnotacoes = new MenuItem("Anotações");

            itemExcluir.setOnAction(event -> {
                Tarefa tarefaSelecionada = linha.getItem();
                if (tarefaSelecionada != null) {
                    dados.remove(tarefaSelecionada);
                    salvarNoArquivo(dados);
                }
            });

            itemEditar.setOnAction(event -> {
                Tarefa tarefaSelecionada = linha.getItem();
                TreeItem<String> raizAtual = tabela.getScene().getRoot() != null ? (TreeItem<String>) ((TreeView<String>) ((BorderPane) tabela.getScene().getRoot()).getLeft()).getRoot() : null;
                if (tarefaSelecionada != null) {
                    abrirJanelaCadastro(raizAtual, tarefaSelecionada);
                }
            });

            itemAnotacoes.setOnAction(event -> {
                Tarefa tarefaSelecionada = linha.getItem();
                if (tarefaSelecionada != null) {
                    Stage janelaNota = new Stage();
                    janelaNota.setTitle("Anotações do Processo");

                    TextArea areaAnotacao = new TextArea();
                    areaAnotacao.setText(tarefaSelecionada.getAnotacoes());
                    areaAnotacao.setWrapText(true);

                    Button botaoSalvarNota = new Button("Salvar Anotações");
                    botaoSalvarNota.setOnAction(e -> {
                        tarefaSelecionada.setAnotacoes(areaAnotacao.getText());
                        salvarNoArquivo(dados);
                        janelaNota.close();
                    });

                    javafx.scene.layout.VBox layoutNota = new javafx.scene.layout.VBox(10);
                    layoutNota.setPadding(new javafx.geometry.Insets(15));
                    layoutNota.getChildren().addAll(new Label("Anotações detalhadas"), areaAnotacao, botaoSalvarNota);

                    Scene cenaNota = new Scene(layoutNota, 400, 300);
                    janelaNota.setScene(cenaNota);
                    janelaNota.show();
                }
            });

            menuContexto.getItems().addAll(itemEditar, itemExcluir, itemAnotacoes);

            linha.emptyProperty().addListener((obs, wasEmpy, isEmpty) -> {
                if (isEmpty) {
                    linha.setContextMenu(null);
                    linha.setStyle("");
                } else {
                    linha.setContextMenu(menuContexto);
                    Tarefa tarefa = linha.getItem();

                    if (tarefa != null && tarefa.getDiasRestantes() <= 0) {
                        linha.setStyle("-fx-text-background-color: red; -fx-text-fill: red;");
                    } else {
                        linha.setStyle("");
                    }
                }
            });
            return linha;
        });

        Button botaoAdicionar = new Button("+");
        botaoAdicionar.setStyle("-fx-font-size: 20px; -fx-background-radius: 30px; -fx-min-width: 50px; -fx-min-height: 50px;");

        javafx.scene.layout.StackPane camadaCentro = new javafx.scene.layout.StackPane();
        camadaCentro.getChildren().addAll(tabela, botaoAdicionar);

        javafx.geometry.Insets margem = new javafx.geometry.Insets(0, 20, 20, 0);
        javafx.scene.layout.StackPane.setAlignment(botaoAdicionar, Pos.BOTTOM_RIGHT);
        javafx.scene.layout.StackPane.setMargin(botaoAdicionar, margem);

        TreeItem<String> raiz = new TreeItem<>("Todos Processos");
        atualizarArvore(raiz);
        TreeView<String> arvore = new TreeView<>(raiz);
        raiz.setExpanded(true);

        botaoAdicionar.setOnAction(e -> abrirJanelaCadastro(raiz, null));

        arvore.getSelectionModel().selectedItemProperty().addListener((obs, velhoValor, novoValor) -> {
            if (novoValor != null) {
                if (novoValor.getParent() == null) {
                    tabela.setItems(dados);
                }
                else if (novoValor.getParent().getParent() == null) {
                    filtrarPorAdvogado(novoValor.getValue());
                }
                else if (novoValor.getParent().getParent().getParent() == null) {
                    String situacaoPasta = novoValor.getValue();
                    String advogadoPasta = novoValor.getParent().getValue();
                    filtrarPorSituacao(advogadoPasta, situacaoPasta);
                }
                else {
                    String anoClicado = novoValor.getValue();
                    String situacaoPasta = novoValor.getParent().getValue();
                    String advogadoPasta = novoValor.getParent().getParent().getValue();
                    filtrarPorAno(advogadoPasta, situacaoPasta, anoClicado);
                }
            }
        });

        BorderPane painelPrincipal = new BorderPane();
        painelPrincipal.setLeft(arvore);
        painelPrincipal.setCenter(camadaCentro);

        var scene = new Scene(painelPrincipal, 900, 600);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void filtrarPorAdvogado(String nomeAdvogado) {
        javafx.collections.transformation.FilteredList<Tarefa> dadosFiltrados =
                new javafx.collections.transformation.FilteredList<>(dados, t -> {
                    return t.getAdvogado().equalsIgnoreCase(nomeAdvogado);
                });
        tabela.setItems(dadosFiltrados);
    }

    private void filtrarPorSituacao(String nomeAdvogado, String situacaoPasta) {
        javafx.collections.transformation.FilteredList<Tarefa> dadosFiltrados =
                new javafx.collections.transformation.FilteredList<>(dados, t -> {
                    boolean bateAdvogado = t.getAdvogado().equalsIgnoreCase(nomeAdvogado);

                    if (situacaoPasta.equals("Processos Concluídos")) {
                        return bateAdvogado && t.getSituacao() == Tarefa.Situacao.CONCLUIDO;
                    } else {
                        return bateAdvogado && t.getSituacao() != Tarefa.Situacao.CONCLUIDO;
                    }
                });
        tabela.setItems(dadosFiltrados);
    }

    private void filtrarPorAno(String nomeAdvogado, String situacaoPasta, String anoClicado) {
        javafx.collections.transformation.FilteredList<Tarefa> dadosFiltrados =
                new javafx.collections.transformation.FilteredList<>(dados, t -> {
                    boolean bateAdvogado = t.getAdvogado().equalsIgnoreCase(nomeAdvogado);
                    boolean bateAno = String.valueOf(t.getDataIntimacao().getYear()).equals(anoClicado);

                    if (situacaoPasta.equals("Processos Concluídos")) {
                        return bateAdvogado && bateAno && t.getSituacao() == Tarefa.Situacao.CONCLUIDO;
                    } else {
                        return bateAdvogado && bateAno && t.getSituacao() != Tarefa.Situacao.CONCLUIDO;
                    }
                });
        tabela.setItems(dadosFiltrados);
    }

    private void carregarDoArquivo() {
        java.io.File arquivo = new java.io.File("processos_salvos.txt");

        if (!arquivo.exists()) {
            SistemaDeTarefas.inicializarTarefas();
            dados = javafx.collections.FXCollections.observableArrayList(SistemaDeTarefas.listaDeTarefas);
            return;
        }

        dados = javafx.collections.FXCollections.observableArrayList();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = java.util.regex.Pattern.compile("\\|").split(linha);
                if (partes.length >= 10) {
                    Tarefa t = new Tarefa(
                            partes[0],
                            partes[1],
                            LocalDate.parse(partes[2]),
                            LocalDate.parse(partes[3]),
                            Integer.parseInt(partes[4]),
                            partes[5],
                            partes[6],
                            Tarefa.Situacao.valueOf(partes[7]),
                            partes[8],
                            partes[9]
                    );
                    if (partes.length >= 11) {
                        String notasComEnter = partes[10].replace("[QUEBRA]", "\n");
                        t.setAnotacoes(notasComEnter);
                    }
                    dados.add(t);
                }
            }
        } catch (java.io.IOException | java.time.format.DateTimeParseException | NumberFormatException e) {
            System.err.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    private void salvarNoArquivo(javafx.collections.ObservableList<Tarefa> lista) {
        java.io.File arquivo = new java.io.File("processos_salvos.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(arquivo))) {
                for (Tarefa t: lista) {
                    writer.println(t.toLinhaTexto());
                }
            }
        } catch (java.io.IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    private void abrirJanelaCadastro(TreeItem<String> raiz, Tarefa tarefaExistente) {
        Stage novaJanela = new Stage();
        novaJanela.setTitle(tarefaExistente == null ? "Cadastrar Novo Processo" : "Editar Processo");

        TextField campoProcesso = new TextField();
        campoProcesso.setPromptText("Número Do Processo");

        TextField campoCliente = new TextField();
        campoCliente.setPromptText("Nome Do Cliente");

        DatePicker campoIntimacao = new DatePicker();
        campoIntimacao.setPromptText("Data Da Intimação");

        DatePicker campoLimite = new DatePicker();
        campoLimite.setPromptText("Data Limite");

        TextField campoPrazo = new TextField();
        campoPrazo.setPromptText("Prazo Em Dias (Ex: 15)");

        TextField campoOQueFazer = new TextField();
        campoOQueFazer.setPromptText("O Que Fazer");

        TextField campoTribunal = new TextField();
        campoTribunal.setPromptText("Tribunal");

        ComboBox<Tarefa.Situacao> comboSituacao = new ComboBox<>();
        comboSituacao.getItems().setAll(Tarefa.Situacao.values());
        comboSituacao.setValue(Tarefa.Situacao.PENDENTE);

        TextField campoCategoria = new TextField();
        campoCategoria.setPromptText("Categoria");

        java.util.List<String> advogadosUnicos = dados.stream().map(Tarefa::getAdvogado).distinct().toList();

        ComboBox<String> comboAdvogado = new ComboBox<>();
        comboAdvogado.setPromptText("Selecione o Advogado");
        comboAdvogado.getItems().setAll(advogadosUnicos);
        comboAdvogado.setMaxWidth(Double.MAX_VALUE);

        Button botaoNovoAdvogado = new Button("+");
        botaoNovoAdvogado.setOnAction(ev -> {
            TextInputDialog dialogo = new TextInputDialog();
            dialogo.setTitle("Novo Advogado");
            dialogo.setHeaderText("Cadastrar Advogado");
            dialogo.setContentText("Nome do Advogado");

            java.util.Optional<String> resultado = dialogo.showAndWait();
            resultado.ifPresent(nome -> {
                if (!nome.trim().isEmpty() && !comboAdvogado.getItems().contains(nome)) {
                    comboAdvogado.getItems().add(nome);
                    comboAdvogado.setValue(nome);
                }
            });
        });

        javafx.scene.layout.HBox linhaAdvogado = new javafx.scene.layout.HBox(5);
        linhaAdvogado.getChildren().addAll(comboAdvogado, botaoNovoAdvogado);
        javafx.scene.layout.HBox.setHgrow(comboAdvogado, Priority.ALWAYS);

        if (tarefaExistente != null) {
            campoProcesso.setText(tarefaExistente.getProcesso());
            campoCliente.setText(tarefaExistente.getNomeDoCliente());
            campoIntimacao.setValue(tarefaExistente.getDataIntimacao());
            campoLimite.setValue(tarefaExistente.getDataLimite());
            campoPrazo.setText(String.valueOf(tarefaExistente.getPrazoEmDias()));
            campoOQueFazer.setText(tarefaExistente.getOQueFazer());
            campoTribunal.setText(tarefaExistente.getTribunal());
            comboSituacao.setValue(tarefaExistente.getSituacao());
            campoCategoria.setText(tarefaExistente.getCategoria());
            comboAdvogado.setValue(tarefaExistente.getAdvogado());
        }

        Button botaoSalvar = new Button("Salvar");

        botaoSalvar.setOnAction(e -> {
            if (comboAdvogado.getValue() == null) {
                System.err.println("Por favor, selecione um advogado.");
                return;
            }
            try {
                if (tarefaExistente == null) {
                    Tarefa novaTarefa = new Tarefa(
                            campoProcesso.getText(),
                            campoCliente.getText(),
                            campoIntimacao.getValue(),
                            campoLimite.getValue(),
                            Integer.parseInt(campoPrazo.getText()),
                            campoOQueFazer.getText(),
                            campoTribunal.getText(),
                            comboSituacao.getValue(),
                            campoCategoria.getText(),
                            comboAdvogado.getValue()
                    );
                    dados.add(novaTarefa);
                } else {
                    tarefaExistente.setProcesso(campoProcesso.getText());
                    tarefaExistente.setNomeDoCliente(campoCliente.getText());
                    tarefaExistente.setDataIntimacao(campoIntimacao.getValue());
                    tarefaExistente.setDataLimite(campoLimite.getValue());
                    tarefaExistente.setPrazoEmDias(Integer.parseInt(campoPrazo.getText()));
                    tarefaExistente.setOQueFazer(campoOQueFazer.getText());
                    tarefaExistente.setTribunal(campoTribunal.getText());
                    tarefaExistente.setSituacao(comboSituacao.getValue());
                    tarefaExistente.setCategoria(campoCategoria.getText());
                    tarefaExistente.setAdvogado(comboAdvogado.getValue());

                    tabela.refresh();
                }

                salvarNoArquivo(dados);
                if (raiz != null) {
                    atualizarArvore(raiz);
                }

                novaJanela.close();
            } catch (Exception ex) {
                System.err.println("Erro ao salvar. Verifique se todos os campos foram preenchidos corretamente.");
            }
        });
        javafx.scene.layout.VBox layout = new javafx.scene.layout.VBox(10);
        layout.setPadding(new javafx.geometry.Insets(15));
        layout.getChildren().addAll(
                new Label("Número do processo:"), campoProcesso,
                new Label("Nome do Cliente:"), campoCliente,
                new Label("Datas:"), campoIntimacao, campoLimite,
                new Label("Prazo em Dias:"), campoPrazo,
                new Label("Ação / Tribunal:"), campoOQueFazer, campoTribunal,
                new Label("Situação / Categoria:"), comboSituacao, campoCategoria,
                new Label("Advogado:"), linhaAdvogado,
                botaoSalvar
        );
        Scene cenaCadastro = new Scene(layout, 350, 580);
        novaJanela.setScene(cenaCadastro);
        novaJanela.show();
    }

    private void atualizarArvore(TreeItem<String> raiz) {
        raiz.getChildren().clear();

        java.util.List<String> advogadosUnicos = dados.stream()
                .map(Tarefa::getAdvogado)
                .distinct()
                .toList();

        for (String advogado : advogadosUnicos) {
            if (advogado == null || advogado.trim().isEmpty()) continue;

            TreeItem<String> noAdvogado = new TreeItem<>(advogado);
            raiz.getChildren().add(noAdvogado);

            TreeItem<String> noPendentes = new TreeItem<>("Processos Pendentes");
            TreeItem<String> noConcluidos = new TreeItem<>("Processos Concluídos");
            noAdvogado.getChildren().addAll(noPendentes, noConcluidos);

            java.util.List<Integer> anosAtivos = dados.stream()
                    .filter(t -> t.getAdvogado().equalsIgnoreCase(advogado))
                    .filter(t -> t.getSituacao() != Tarefa.Situacao.CONCLUIDO)
                    .map(t -> t.getDataIntimacao().getYear())
                    .distinct()
                    .sorted()
                    .toList();

            for (Integer ano : anosAtivos) {
                noPendentes.getChildren().add(new TreeItem<>(String.valueOf(ano)));
            }

            java.util.List<Integer> anosConcluidos = dados.stream()
                    .filter(t -> t.getAdvogado().equalsIgnoreCase(advogado))
                    .filter(t -> t.getSituacao() == Tarefa.Situacao.CONCLUIDO)
                    .map(t -> t.getDataIntimacao().getYear())
                    .distinct()
                    .sorted()
                    .toList();

            for (Integer ano : anosConcluidos) {
                noConcluidos.getChildren().add(new TreeItem<>(String.valueOf(ano)));
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Application.launch(App.class, args);
        }
    }
}