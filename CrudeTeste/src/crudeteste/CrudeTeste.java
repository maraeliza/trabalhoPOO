/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudeteste;

import java.time.LocalDate;

/**
 *
 * @author Jussie
 */
public class CrudeTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConvidadoFamiliaDAO cfDAo = new ConvidadoFamiliaDAO(); 
        ConvidadoFamilia familia1 = new ConvidadoFamilia();
        
        LocalDate dataCasamento = LocalDate.of(2024, 12, 15);
                
        familia1.Criar(0, "silva", "Julio", "Laura", dataCasamento, cfDAo);
        
        
        System.out.println(familia1.toString());
        
         Boolean acharFamilia = cfDAo.find(familia1);
         
         if(acharFamilia){
             System.out.println("\n\nFamilia encontrada: " + familia1.getNomeFamilia());
         }else{
             System.out.println("Familia nao encontrada");
         }
    }
    
}
