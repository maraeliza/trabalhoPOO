/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class MuralRecados {
    public  int id;
    Pessoa pessoa;
    String comentario;
    
    LocalDate dataCriacao;
    LocalDate dataModificacao;
   
    public static int totalMuralRecados;
    
    public void criar(int id, Pessoa pessoa, String comentario){
        this.id = totalMuralRecados++;
        this.pessoa = pessoa;
        this.comentario = comentario;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        
    }
    public String ler(){
        String dados = "\nMural de Recados "+this.id;
        dados+= "\nNome: "+this.pessoa.getNome();
        dados+= "\nComentario: "+this.comentario;
        
        return dados;
    }
    private void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    private void deletar(){
        
        
    }
}
