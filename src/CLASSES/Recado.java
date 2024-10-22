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
public class Recado implements ClasseInterface {

    private int id;
    private Pessoa pessoa;
    private String comentario;

    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public static int total;
    
    public static String[] getCampos(){
        String[] campos = new String[2];
        campos[0] = "ID: ";
        campos[1] = "Comentário: ";
        return campos;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public static void setTotal(int t) {
        total = t;
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

    public void criar(Object vetor[]) {

        if (vetor[1] != null) {
            this.comentario = (String) vetor[1];
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null;
            this.id = ++total;
        }
        if (vetor[0] != null) {
            this.pessoa = (Pessoa) vetor[0];
        }
    }

    public void criar(Usuario user, Object vetor[]) {

        if (vetor[0] != null) {
            this.comentario = (String) vetor[0];
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null;
            this.id = ++total;
        }
        if (user != null) {
            this.pessoa = user.getPessoa() ;
        }
    }

    public void update(Object vetor[]) {
        boolean alterou = false;
        if (vetor[0] != null) {
            String comentario = (String) vetor[0];
            if (comentario.length() > 0) {
                this.comentario = comentario;
                alterou = true;

            }
        }
       
        if (alterou) {
            this.atualizarDataModificacao();
        }

    }

    public void update(Usuario user, Object vetor[]) {
        boolean alterou = false;
        if (vetor[0] != null) {
            String comentario = (String) vetor[0];
            if (comentario.length() > 0) {
                this.comentario = comentario;
                alterou = true;

            }
        }
        if (user != null) {
            Pessoa p = user.getPessoa();
            if (p != null) {
                this.pessoa = p;
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

    public void deletar() {
        --total;
    }

    public String ler() {
        String dados = "";
        dados = "\nID: " + this.id;
        dados += "\n   Comentário: " + this.comentario;
        if (this.pessoa != null && this.pessoa.getNome().length() > 1) {
            dados += "\n   Autor: " + this.pessoa.getNome();
        }
        dados += "\n   Data de criação: " + Util.dateToString(this.dataCriacao);

        return dados;
    }
    
   
}
