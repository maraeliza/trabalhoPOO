/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudeteste;

/**
 *
 * @author Jussie
 */
public class ConvidadoIndividualDAO {

 
    public ConvidadoIndividual[] vetor = new ConvidadoIndividual[100];
    public static int itens;
  
    
     public boolean add(ConvidadoIndividual c){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == null){
                this.vetor[i] = c;
                ConvidadoIndividualDAO.itens++;
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(ConvidadoIndividual c){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == c){
                this.vetor[i] = null;
                ConvidadoIndividualDAO.itens++;
                return true;
            }
        }
        return false;
    }
    
    public boolean find(ConvidadoIndividual c){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == c){
                return true;
            }
        }
        return false;
    }
    
    public ConvidadoIndividual getItemByID(int id){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] != null && this.vetor[i].getId() == id){
                return this.vetor[i];
            }
        }
        return null;
    }

    
    

}
