/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Jussie
 */
import java.time.LocalDate;

public class Igreja {

    public int id;
    private String nome;
    private String endereco;
    
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public static int totalIgrejas;

    // Getters e Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotalIgrejas() {
        return totalIgrejas;
    }

    public static void setTotalIgrejas(int total) {
        totalIgrejas = total;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.dataModificacao = LocalDate.now();
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
        this.dataModificacao = LocalDate.now();
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return this.dataModificacao;
    }

    // Método para criar uma nova igreja
    public void criar(String nome, String endereco) {
        this.id = ++totalIgrejas;
        this.nome = nome;
        this.endereco = endereco;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
    }

    // Método para atualizar igreja
    public void update(String nome, String endereco) {
        boolean alterou = false;

        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
            alterou = true;
        }

        if (endereco != null && !endereco.isEmpty()) {
            this.endereco = endereco;
            alterou = true;
        }

        if (alterou) {
            this.atualizarDataModificacao();
        }
    }

    // Método para atualizar a data de modificação
    private void atualizarDataModificacao() {
        this.dataModificacao = LocalDate.now();
    }

    // Método para deletar igreja
    private void deletar() {
        --totalIgrejas;
    }

    // Método para ler os dados da igreja
    public String ler() {
        String dados = "\n\nID: " + this.id;
        dados += "\n Nome: " + this.nome;
        dados += "\n Endereço: " + this.endereco;
        dados += "\n Data de criação: " + this.dataCriacao;
        dados += "\n Data de modificação: " + (this.dataModificacao != null ? this.dataModificacao.toString() : "N/A");
        
        return dados;
    }
}
