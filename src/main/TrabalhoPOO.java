package main;

import DAO.PessoaDAO;
import DAO.UsuarioDAO;
import DAO.PresenteDAO;
import DAO.RecadoDAO;
import CLASSES.Pessoa;
import CLASSES.Usuario;
import GUI.TelaInicial;

public class TrabalhoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        UsuarioDAO userDAO = new UsuarioDAO();
        PresenteDAO presenteDAO = new PresenteDAO();
        RecadoDAO recadoDAO = new RecadoDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        
       
        String op = "";
        TelaInicial menu = new TelaInicial();
        op = menu.exibir();
        System.out.println("FORA DO MENU A OPCAO INICIAL ESCOLHIDA E "+op);
    }

}
