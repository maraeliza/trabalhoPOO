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
public class MuralRecados {
     int id;
    Pessoa pessoa;
    String comentario;
    
    LocalDate dataCriacao;
    LocalDate dataModificacao;
   
    public static int totalMuralRecados;
    
    public void criar(int id, Pessoa pessoa, String comentario){
        this.id = id;
        this.pessoa = pessoa;
        this.comentario = comentario;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        
    }
    public String ler(){
        String dados = "\nMural de Recados "+this.id;
        dados+= "\nNome: "+this.pessoa.nome;
        dados+= "\nComentario: "+this.comentario;
        
        return dados;
    }
    public void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    public void deletar(){
        
        
    }
}
