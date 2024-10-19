/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudeteste;

/**
 *
 * @author Jussie
 */
public class ConvidadoFamiliaDAO {
    
    public ConvidadoFamilia[] vetor = new ConvidadoFamilia[100];
    public static int itens;
    
     public boolean add(ConvidadoFamilia cf){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == null){
                this.vetor[i] = cf;
                ConvidadoFamiliaDAO.itens++;
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(ConvidadoFamilia cf){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == cf){
                this.vetor[i] = null;
                ConvidadoFamiliaDAO.itens++;
                return true;
            }
        }
        return false;
    }
    
    public boolean find(ConvidadoFamilia cf){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == cf){
                return true;
            }
        }
        return false;
    }
    
    public ConvidadoFamilia getItemByID(int id){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] != null && this.vetor[i].getId() == id){
                return this.vetor[i];
            }
        }
        return null;
    }
}
