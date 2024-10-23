/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class Pagamento implements ClasseInterface {

    private int id;
    private LocalDate data;
    private Pessoa pessoa; // Supondo que a classe Pessoa já exista
    private String descricao;
    private Fornecedor fornecedor; // Supondo que a classe Fornecedor já exista
    private double valor;
    private int parcela; // Para pagamento parcelado
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private static int total;

    public static String[] getCampos() {
        String[] campos = new String[10];
        campos[0] = "ID: ";
        campos[1] = "DATA: ";
        campos[2] = "PESSOA: ";
        campos[3] = "DESCRIÇÃO: ";
        campos[4] = "FORNECEDOR: ";
        campos[5] = "VALOR: ";
        campos[6] = "PARCELA: ";

        return campos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    public boolean criar(Usuario user, Object vetor[]) {
        return criar(vetor);
    }
    public boolean criar( Object vetor[]) {
        System.out.println("CRIANDO UM NOVO PAGAMENTO!");
        System.out.println("Dados: " + vetor[0] + " " + vetor[1] + " " + vetor[2] + " " + vetor[3] + " " + vetor[4]);

        boolean alterado = false;

        if (vetor[0] != null && vetor[0] instanceof LocalDate) {
            this.data = (LocalDate) vetor[0]; // Data do pagamento
            if (vetor[1] != null && vetor[1] instanceof Pessoa) {
                this.pessoa = (Pessoa) vetor[1]; // Pessoa
                alterado = true;
            }
        }

        if (alterado) {
            if (vetor[2] != null && vetor[2] instanceof String) {
                this.descricao = (String) vetor[2]; // Descrição
            }

            if (vetor[3] != null && vetor[3] instanceof Fornecedor) {
                this.fornecedor = (Fornecedor) vetor[3]; // Fornecedor
            }

            if (vetor[4] != null && vetor[4] instanceof Double) {
                this.valor = (Double) vetor[4]; // Valor
            }

            if (vetor[5] != null && vetor[5] instanceof Integer) {
                this.parcela = (Integer) vetor[5]; // Parcela
            }

            // Atribui o ID único e define as datas de criação e modificação
            this.id = ++total;
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null; // Nenhuma modificação inicial
        }

        return alterado;
    }

    public void atualizar() {
        // Lógica para atualizar um pagamento no banco de dados
        this.dataModificacao = LocalDate.now();
        // Atualizar informações no banco de dados
    }

    public void deletar() {
        // Lógica para deletar um pagamento do banco de dados
    }

    public String ler() {
        StringBuilder resultado = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        resultado.append("ID: ").append(this.id).append("\n");

        if (this.data != null) {
            resultado.append("Data: ").append(this.data.format(formatter)).append("\n");
        }

        if (this.pessoa != null && this.pessoa.getNome() != null && !this.pessoa.getNome().isEmpty()) {
            resultado.append("Pessoa: ").append(this.pessoa.getNome()).append("\n");
        }

        if (this.descricao != null && !this.descricao.isEmpty()) {
            resultado.append("Descrição: ").append(this.descricao).append("\n");
        }

        if (this.fornecedor != null && this.fornecedor.getNome() != null && !this.fornecedor.getNome().isEmpty()) {
            resultado.append("Fornecedor: ").append(this.fornecedor.getNome()).append("\n");
        }

        resultado.append("Valor: ").append(this.valor).append("\n");

        if (this.parcela > 0) {
            resultado.append("Parcela: ").append(this.parcela).append("\n");
        }

        if (this.dataCriacao != null) {
            resultado.append("Data de Criação: ").append(this.dataCriacao.format(formatter)).append("\n");
        }

        if (this.dataModificacao != null) {
            resultado.append("Data da Última Modificação: ").append(this.dataModificacao.format(formatter)).append("\n");
        }

        return resultado.toString();
    }

    // Método para verificar e atualizar o estado do pagamento
    public void verificarPagamentoAgendado() {
        LocalDate hoje = LocalDate.now();
        if (data.isEqual(hoje) && valor > 0) {
            // Lógica para atualizar o estado do pagamento
            // Se for uma parcela única ou se todas as parcelas foram pagas
            if (parcela == 1 || valor <= 0) {
                // Atualizar o estado do fornecedor
                this.fornecedor.setEstado(1);
            }
        }
    }

    public void update(Object vetor[]) {
        boolean alterou = false;

        if (vetor[0] != null && vetor[0] instanceof LocalDate) {
            LocalDate novaData = (LocalDate) vetor[0];
            if (!novaData.equals(this.data)) {
                this.data = novaData;
                alterou = true;
            }
        }

        if (vetor[1] != null) {
            String descricao = (String) vetor[1];
            if (descricao.length() > 0 && !descricao.equals(this.descricao)) {
                this.descricao = descricao;
                alterou = true;
            }
        }

        if (vetor[2] != null) {
            Fornecedor f = (Fornecedor) vetor[2];
            if (f != null && !f.equals(this.fornecedor)) {
                this.fornecedor = f;
                alterou = true;
            }
        }

        if (vetor[3] != null) {
            Double novoValor = (Double) vetor[3];
            if (novoValor != null && !novoValor.equals(this.valor)) {
                this.valor = novoValor;
                alterou = true;
            }
        }

        if (vetor[4] != null) {
            Integer novaParcela = (Integer) vetor[4];
            if (novaParcela != null && !novaParcela.equals(this.parcela)) {
                this.parcela = novaParcela;
                alterou = true;
            }
        }

        if (alterou) {
            this.atualizarDataModificacao();
        }
    }

    public void atualizarDataModificacao() {

        this.dataModificacao = LocalDate.now();
    }

}
