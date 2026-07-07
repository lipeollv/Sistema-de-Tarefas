package sistema.de.tarefas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tarefa {
    private String processo;
    private String nomeDoCliente;
    private LocalDate dataIntimacao;
    private LocalDate dataLimite;
    private int prazoEmDias;
    private String oQueFazer;
    private String tribunal;
    private Situacao situacao;
    private String categoria;
    private String advogado;
    private String anotacoes;

    public long getDiasRestantes() {
        if (this.dataLimite == null) return 0;
        LocalDate hoje = LocalDate.now();
        return ChronoUnit.DAYS.between(hoje, this.dataLimite);
    }

    public enum Situacao {
        PENDENTE,
        EM_ATRASO,
        EM_ANDAMENTO,
        EM_REVISAO,
        PROTOCOLAR,
        PROTOCOLADO,
        AGUARDANDO_DECISAO,
        CONCLUIDO
    }

    public Tarefa(String processo, String nomeDoCliente, LocalDate dataIntimacao, LocalDate dataLimite, int prazoEmDias, String oQueFazer, String tribunal, Situacao situacao, String categoria, String advogado) {
        this.processo = processo;
        this.nomeDoCliente = nomeDoCliente;
        this.dataIntimacao = dataIntimacao;
        this.dataLimite = dataLimite;
        this.prazoEmDias = prazoEmDias;
        this.oQueFazer = oQueFazer;
        this.tribunal = tribunal;
        this.situacao = situacao;
        this.categoria = categoria;
        this.advogado = advogado;
        this.anotacoes = anotacoes;
    }

    // Getters
    public String getProcesso() {return this.processo;}
    public String getNomeDoCliente() {return this.nomeDoCliente;}
    public LocalDate getDataIntimacao() {return this.dataIntimacao;}
    public LocalDate getDataLimite() {return this.dataLimite;}
    public int getPrazoEmDias() {return this.prazoEmDias;}
    public String getOQueFazer() {return this.oQueFazer;}
    public String getTribunal() {return this.tribunal;}
    public Situacao getSituacao() {return this.situacao;}
    public String getCategoria() {return this.categoria;}
    public String getAdvogado() {return this.advogado;}
    public String getAnotacoes() {return this.anotacoes;}

    public void setProcesso(String processo) {this.processo = processo;}
    public void setNomeDoCliente(String nomeDoCliente) {this.nomeDoCliente = nomeDoCliente;}
    public void setDataIntimacao(LocalDate dataIntimacao) {this.dataIntimacao = dataIntimacao;}
    public void setDataLimite(LocalDate dataLimite) {this.dataLimite = dataLimite;}
    public void setPrazoEmDias(int prazoEmDias) {this.prazoEmDias = prazoEmDias;}
    public void setOQueFazer(String oQueFazer) {this.oQueFazer = oQueFazer;}
    public void setTribunal(String tribunal) {this.tribunal = tribunal;}
    public void setSituacao(Situacao situacao) {this.situacao = situacao;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
    public void setAdvogado(String advogado) {this.advogado = advogado;}
    public void setAnotacoes(String anotacoes) {this.anotacoes = anotacoes;}



    public void excluirProcesso() {
    }

    public String obterResumo() {
        return "Processo: " + this.processo + "| Cliente: " + this.nomeDoCliente + "| Data da Intimação: " + this.dataIntimacao + "| Limite: " + this.dataLimite + "(" + getDiasRestantes() + "Dias rest.)" + "| Tribunal: " + this.tribunal + "| Situação: " + this.situacao + "| Categoria: " + this.categoria + "| Advogado: " + this.advogado;
    }

    public String toLinhaTexto() {
        String notasSeguras = this.anotacoes != null ? this.anotacoes.replace("\n", "[QUEBRA]").replace("\r", "[QUEBRA]") : "";

        return this.processo + "|" +this.nomeDoCliente + "|" + this.dataIntimacao + "|" + this.dataLimite + "|" + this.prazoEmDias + "|" + this.oQueFazer + "|" + this.tribunal + "|" + this.situacao + "|" + this.categoria + "|" + this.advogado + "|" + notasSeguras;
    }
}