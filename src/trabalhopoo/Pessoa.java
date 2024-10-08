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
public class Pessoa {
    int id;
    String nome;
    String telefone;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
    LocalDate nascimento;
    
    
    public void criar(int id, String nome, String telefone, LocalDate nasc){
        this.id = id;
        this.nome = nome;
        this.nascimento = nasc;
        this.telefone = telefone;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        
    }
    public String ler(){
        String dados = "\nPessoa "+this.id;
        dados+= "\nNome: "+this.nome;
        dados+= "\nData de nascimento: "+this.nascimento;
        dados+= "\nTelefone: "+this.telefone;
        return dados;
    }
    public void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    public void deletar(){
        
        
    }
}
