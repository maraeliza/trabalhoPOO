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
public class Recado {
   public   int id;
    Pessoa pessoa;
    String comentario;
    
    LocalDate dataCriacao;
    LocalDate dataModificacao;
   
    public static int totalRecado;
    
    public void criar(int id, Pessoa pessoa, String comentario){
        this.id = totalRecado++;
        this.pessoa = pessoa;
        this.comentario = comentario;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        
    }
    private String ler(){
        String dados = "\nMural de Recados "+this.id;
        dados+= "\nNome: "+this.pessoa.nome;
        dados+= "\nComentario: "+this.comentario;
        
        return dados;
    }
    private void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    private void deletar(){
        
        
    }
}
