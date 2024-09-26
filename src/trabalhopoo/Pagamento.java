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
public class Pagamento {
    int id;
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
        this.id = id;
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
        dados+= "\nNome: "+this.pessoa.nome;
        dados+= "\nDescricao: "+this.descricao;
        
        return dados;
    }
    public void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    public void deletar(){
        
        
    }
}
