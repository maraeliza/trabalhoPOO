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

public class Cerimonial {

    public int id;
    private String nome;
    private String telefone;
    
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public static int totalCerimoniais;
   
    public static String[] getCampos(){
        String[] campos = new String[2];
        campos[0] = "ID: ";
        campos[1] = "Nome: ";
        campos[2] = "Telefone: ";
   
        return campos;
    }
    // Getters e Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotalCerimoniais() {
        return totalCerimoniais;
    }

    public static void setTotalCerimoniais(int total) {
        totalCerimoniais = total;
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

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return this.dataModificacao;
    }

    // Método para criar um novo cerimonial
    public void criar(String nome, String telefone) {
        this.id = ++totalCerimoniais;
        this.nome = nome;
        this.telefone = telefone;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
    }

    // Método para atualizar cerimonial
    public void update(String nome, String telefone) {
        boolean alterou = false;

        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
            alterou = true;
        }

        if (telefone != null && !telefone.isEmpty()) {
            this.telefone = telefone;
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

    // Método para deletar cerimonial
    private void deletar() {
        --totalCerimoniais;
    }

    // Método para ler os dados do cerimonial
    public String ler() {
        String dados = "\n\nID: " + this.id;
        dados += "\n Nome: " + this.nome;
        dados += "\n Telefone: " + this.telefone;
        dados += "\n Data de criação: " + this.dataCriacao;
        dados += "\n Data de modificação: " + (this.dataModificacao != null ? this.dataModificacao.toString() : "N/A");
        
        return dados;
    }
}

