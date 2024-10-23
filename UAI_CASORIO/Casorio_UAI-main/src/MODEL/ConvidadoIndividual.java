/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import CONTROLLER.DAO;
import static MODEL.Pessoa.total;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class ConvidadoIndividual implements ClasseInterface{
    
    private int id;
    private Pessoa pessoa;
    private ConvidadoFamilia familia;
    private String parentesco;
    private boolean confirmacao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    public static int totalConvidadoIndividual;
    private DAO dao;
    

     
    public boolean criar(Usuario user, Object[] vetor) {
       return false;

    }

    public boolean criar(Object[] vetor) {
        return false;
    }

    public void update(Object vetor[]){
    
    }
    
    public int getId(){
    
        return this.id;
    
    }

    public void setId(int id){
        this.id = id;
    }
    
    public LocalDate getDataCriacao(){
    
        return this.dataCriacao;
    
    }

    public LocalDate getDataModificacao(){
    
        return null;
    
    }

    public void atualizarDataModificacao(){
    
    }
    
     public String ler() {
        StringBuilder resultado = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Adiciona informações da pessoa
        resultado.append("comvidado Individual").append(this.id);
        resultado.append("Pessoa ").append(this.id);
        resultado.append("\nNome: ").append(this.pessoa);

        // Verifica e adiciona o parentesco
        if (this.parentesco != null && !this.parentesco.isEmpty()) {
            resultado.append("\nParentesco: ").append(this.parentesco);
        }
        
        // Verifica e formata a data de criação
        if (this.dataCriacao != null) {
            resultado.append("\nData de Criação: ").append(this.dataCriacao.format(formatter));
        }

        // Verifica e formata a data de modificação
        if (this.dataModificacao != null) {
            resultado.append("\nData da Última Modificação: ").append(this.dataModificacao.format(formatter));
        }

        resultado.append("\n\n");
        return resultado.toString();
    }
     public void deletar(){
        
        
    }
}
