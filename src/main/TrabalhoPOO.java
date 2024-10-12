package main;

import DAO.PessoaDAO;
import DAO.UserDAO;
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
        UserDAO userDAO = new UserDAO();
        PresenteDAO presenteDAO = new PresenteDAO();
        RecadoDAO recadoDAO = new RecadoDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        
       
        
        TelaInicial menu = new TelaInicial();
        menu.exibir();
    }

}
