/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import VIEW.Util;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

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

    public static String[] getCampos() {
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

    public boolean criar(Object vetor[]) {
        boolean alterado = false;
        if (vetor[1] != null) {
            this.comentario = (String) vetor[1];
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null;
            this.id = ++total;
              alterado = true;
        }
        if (vetor[0] != null) {
            this.pessoa = (Pessoa) vetor[0];
        }
        return alterado;
    }

    public boolean criar(Usuario user, Object vetor[]) {
        boolean alterado = false;
        if (vetor[0] != null) {
            this.comentario = (String) vetor[0];
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null;
            this.id = ++total;
            alterado = true;
        }
        if (user != null) {
            this.pessoa = user.getPessoa();
        }
        return alterado;
    }

    public void update(Object vetor[]) {
        boolean alterou = false;
        if (vetor[0] != null) {
            String comentario = (String) vetor[1];
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
        StringBuilder resultado = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Adiciona o ID
        resultado.append("\nID: ").append(this.id);

        // Verifica se o comentário não é nulo ou vazio
        if (this.comentario != null && !this.comentario.isEmpty()) {
            resultado.append("\n   Comentário: ").append(this.comentario);
        }

        // Verifica se a pessoa não é nula e se o nome é válido
        if (this.pessoa != null && this.pessoa.getNome() != null && this.pessoa.getNome().length() > 1) {
            resultado.append("\n   Autor: ").append(this.pessoa.getNome());
        }

        // Verifica e formata a data de criação
        if (this.dataCriacao != null) {
            resultado.append("\n   Data de Criação: ").append(this.dataCriacao.format(formatter));
        }
        if (this.dataModificacao != null) {
            resultado.append("\n   Data da Última Modificação: ").append(this.dataModificacao.format(formatter));
        }
        return resultado.toString();
    }

}
