/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

import DAO.UsuarioDAO;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Usuario {

    private int id;
    private Pessoa pessoa;
    private int tipo;
    String login;
    String senha;
    LocalDate dataCriacao;
    LocalDate dataModificacao;

    public static int totalUsuario;

    public void criar(Object vetor[]) {
        //Pessoa pessoa, String login, String senha, int tipo
        if (vetor[0] != null && vetor[1] != null && vetor[2] != null && vetor[3] != null) {
            Pessoa pessoa = (Pessoa) vetor[0];
            String login = (String) vetor[1];
            String senha = (String) vetor[2];
            int tipo = (int) vetor[3];

            if (login.length() > 0 && senha.length() > 0 && pessoa != null && this.checarTipo(tipo)) {
                this.id = ++totalUsuario;
                this.pessoa = pessoa;
                this.login = login;
                this.senha = senha;
                this.tipo = tipo;
                this.dataCriacao = LocalDate.now();
                this.dataModificacao = null;
            }
        }

    }

    public boolean checarTipo(int tipo) {
        return (tipo >= 0 && tipo <= 2);
    }

    public String ler() {
        String dados = "\nUsuario " + this.id;
        dados += "\nNome: " + this.getNome();
        dados += "\nLogin: " + this.login;
        dados += "\nSenha: " + this.senha;
        return dados;
    }

    public void atualizar() {

        this.dataModificacao = LocalDate.now();
    }

    public void deletar() {

    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getNome() {
        return this.pessoa.getNome();
    }

    public int getId() {
        return this.id;
    }

    public int getTipo() {
        return this.tipo;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }
}
