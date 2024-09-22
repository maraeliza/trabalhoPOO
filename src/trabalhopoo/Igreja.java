/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

/**
 *
 * @author Jussie
 */
public class Igreja {
    String nomeIgreja;
    String ror; // Registro de Organização Religiosa
    
    
    
    public void criar(String nomeIgreja, String ror){
        this.nomeIgreja = nomeIgreja;
        this.ror = ror;
    }
    
    public String ler(){
        String dados = "Nome Igreja: " + this.nomeIgreja;
        dados += "Registro de Organização Religiosa: " + this.ror;
        return dados;
    }
    
    public void deletar(){
        
    }
}
