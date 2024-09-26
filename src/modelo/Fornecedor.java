/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Fornecedor {
    public int id;
    
    String nome;
    String cnpj;
    String telefone;
    double valorAPagar;
    int parcelas;
    String estado;
    
    
    LocalDate dataCriacao;
    LocalDate dataModificacao;
    
    public static int totalFornecedor;
    
    public void criar(String nome, String cnpj){
        this.id = totalFornecedor++;
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
    private void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    private void deletar(){
        
        
    }
}
