/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;
import DAO.PessoaDAO;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Pessoa {
    public int id;
    String nome;
    String telefone;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
    LocalDate nascimento;
    public static int totalPessoas;
    
    public void criar( String nome, String telefone, PessoaDAO dao){
        this.id = totalPessoas++;
        this.nome = nome;
       // this.nascimento = nasc;
        this.telefone = telefone;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        dao.add(this);
        
    }
    public String ler(){
        String dados = "\nPessoa "+this.id;
        dados+= "\nNome: "+this.nome;
        dados+= "\nData de nascimento: "+this.nascimento;
        dados+= "\nTelefone: "+this.telefone;
        return dados;
    }
    private void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    private void deletar(){
        
        
    }
}
