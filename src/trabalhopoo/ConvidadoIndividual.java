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
public class ConvidadoIndividual {
    private int id;
    Pessoa pessoa;
    String familia;
    String parentesco;
    boolean confirmacao;
    
   
    LocalDate dataCriacao;
    LocalDate dataModificacao;
    public static int totalConvidadoIndividual;
    
    public void criar(int id, Pessoa pessoa, String familia, String parentesco){
        this.id = totalConvidadoIndividual++;
        this.pessoa = pessoa;
        this.parentesco = parentesco;
        this.familia = familia;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        
    }
    public String ler(){
        String dados = "\nConvidado Individual "+this.id;
        dados+= "\nNome: "+this.pessoa.nome;
        dados+= "\nParentesco: "+this.parentesco;
        dados+= "\nConfirmado: "+this.confirmacao;
        return dados;
    }
    public void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    public void deletar(){
        
        
    }
}
