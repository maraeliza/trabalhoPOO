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

    public void criar(Pessoa pessoa, String login, String senha, int tipo) {
        this.id = totalUsuario++;
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;

    }

    public String ler() {
        String dados = "\nUsuario " + this.id;
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
        System.out.println("LOGIN " + this.login);
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
