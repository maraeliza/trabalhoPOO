/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Pagamento {
    public int id;
    Pessoa pessoa;
    Fornecedor fornecedor;
    String descricao;
    String valor;
    String parcela;
    LocalDate data;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
   
     public static int totalPagamento;
    
    public void criar(int id, Pessoa pessoa,Fornecedor fornecedor, String descricao, String valor, String parcela){
        this.id = totalPagamento++;
        this.pessoa = pessoa;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.parcela = parcela;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        
    }
    public String ler(){
        String dados = "\nMural de Recados "+this.id;
        dados+= "\nNome: "+this.pessoa.getNome();
        dados+= "\nDescricao: "+this.descricao;
        
        return dados;
    }
    private void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    private void deletar(){
        
        
    }
}
