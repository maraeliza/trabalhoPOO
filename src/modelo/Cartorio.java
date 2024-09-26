/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;

/**
 *
 * @author Jussie
 */
public class Cartorio {
    public int id;
    String nomeJuiz;
    LocalDate dataRegistro;
    String noivo;
    String noiva;
    //String local;
     public static int totalCartorio;
    
    public void criar(String nomeJuiz, LocalDate dataRegistro, String noivo, String noiva){
        this.id = totalCartorio++;
        this.nomeJuiz = nomeJuiz;
        this.dataRegistro = dataRegistro;
        this.noivo = noivo;
        this.noiva = noiva;
    }
    
    public String ler(){
        String dados = "Nome Juiz: " + this.nomeJuiz;
        dados += "Data de Registro: " + this.dataRegistro;
        dados += "Noivo: " + this.noivo;
        dados += "Noiva: " + this.noiva;
        return dados;
    }
    
    private void deletar(){
        
    }
}
