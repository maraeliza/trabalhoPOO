package main;


import DAO.DAO;
import GUI.TelaInicial;

public class TrabalhoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
       
        String op = "";
        DAO dao = new DAO();
        
        TelaInicial menu = new TelaInicial();
        op = menu.exibir(dao);
        System.out.println("FORA DO MENU A OPCAO INICIAL ESCOLHIDA E "+op);
    }

}
