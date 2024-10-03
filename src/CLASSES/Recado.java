/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;
import GUI.Util;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Recado {

    public int id;
    Pessoa pessoa;
    String comentario;

    LocalDate dataCriacao;
    LocalDate dataModificacao;

    public static int totalRecados;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalRecados() {
        return totalRecados;
    }

    public static void setTotalRecados(int t) {
        totalRecados = t;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataModificacao = LocalDate.now();
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return this.dataModificacao;
    }

    public void criar(Pessoa pessoa, String comentario) {
        this.id = ++totalRecados;
        this.pessoa = pessoa;
        this.comentario = comentario;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;

    }

public void update(String comentario,  Pessoa p){
        boolean alterou = false;
        if(comentario.length() > 0){
            this.comentario = comentario;
            alterou = true;
            
        }
       
        if(p != null){
            this.pessoa = p;
            alterou = true;
            
        }
        
        if(alterou){
            this.atualizarDataModificacao();
        }
        
    }
    private void atualizarDataModificacao() {

        this.dataModificacao = LocalDate.now();
    }

    private void deletar() {
        --totalRecados;
    }

    public String ler() {
        String dados = "";
        dados = "\n\nID: " + this.id;
        dados += "\n   Comentário: " + this.comentario;
        if(this.pessoa != null){
            dados += "\n   Autor: " + this.pessoa.nome;
        }
        dados += "\n Data de criação: " + Util.dateToString(this.dataCriacao);
        

        return dados;
    }
}
