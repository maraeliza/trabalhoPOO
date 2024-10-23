/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.time.LocalDate;

/**
 *
 * @author Jussie
 */
import java.time.LocalDate;

public class Cartorio {

    public int id;
    private String nome;
    private String telefone;
    private String endereco;

    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public static int totalCartorios;
    
     public static String[] getCampos(){
        String[] campos = new String[2];
        campos[0] = "ID: ";
        campos[1] = "Nome: ";
        campos[2] = "Telefone: ";
        campos[3] = "Endereço: ";
        return campos;
    }
    // Getters e Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotalCartorios() {
        return totalCartorios;
    }

    public static void setTotalCartorios(int total) {
        totalCartorios = total;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.dataModificacao = LocalDate.now();
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    // Método para criar um novo cartório
    public void criar(String nome, String telefone, String endereco) {
        this.id = ++totalCartorios;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
    }

    // Método para atualizar cartório
    public void update(String nome, String telefone, String endereco) {
        boolean alterou = false;

        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
            alterou = true;
        }

        if (telefone != null && !telefone.isEmpty()) {
            this.telefone = telefone;
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

    // Método para deletar cartório
    private void deletar() {
        --totalCartorios;
    }

    // Método para ler os dados do cartório
    public String ler() {
        String dados = "\n\nID: " + this.id;
        dados += "\n Nome: " + this.nome;
        dados += "\n Telefone: " + this.telefone;
        dados += "\n Endereço: " + this.endereco;
        dados += "\n Data de criação: " + this.dataCriacao;
        dados += "\n Data de modificação: " + (this.dataModificacao != null ? this.dataModificacao.toString() : "N/A");
        
        return dados;
    }
}

