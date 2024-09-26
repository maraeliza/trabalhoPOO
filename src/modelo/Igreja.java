/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jussie
 */
public class Igreja {
    public int id;
    String nomeIgreja;
    String ror; // Registro de Organização Religiosa
    
    public static int totalIgreja;
    
    public void criar(String nomeIgreja, String ror){
        this.id = totalIgreja++;
        this.nomeIgreja = nomeIgreja;
        this.ror = ror;
    }
    
    public String ler(){
        String dados = "Nome Igreja: " + this.nomeIgreja;
        dados += "Registro de Organização Religiosa: " + this.ror;
        return dados;
    }
    
    private void deletar(){
        
    }
}
