/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Usuario {
    int id;
    Pessoa pessoa;
    String tipo;
    String login;
    String senha;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
    
    public static int totalUsuario;
    
    public void criar(Pessoa pessoa, String login, String senha){
        this.id = totalUsuario++;
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        
    }
    public String ler(){
        String dados = "\nUsuario "+this.id;
        dados+= "\nLogin: "+this.login;
        dados+= "\nSenha: "+this.senha;
        return dados;
    }
    public void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    public void deletar(){
        
        
    }
}
