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
public class Fornecedor {
    int id;
    
    String nome;
    String cnpj;
    String telefone;
    double valorAPagar;
    int parcelas;
    String estado;
    
    
    LocalDate dataCriacao;
    LocalDate dataModificacao;
    
    
    
    public void criar(int id, String nome, String cnpj){
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        
        this.dataCriacao = LocalDate.now();
       
        
    }
    public String ler(){
        String dados = "\nFornecedor "+this.id;
        dados+= "\nNome: "+this.nome;
        dados+= "\nCNPJ: "+this.cnpj;
        dados+= "\nTelefone: "+this.telefone;
        return dados;
    }
    public void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    public void deletar(){
        
        
    }
}
