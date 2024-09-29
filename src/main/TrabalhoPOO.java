package main;

import DAO.PessoaDAO;
import DAO.UserDAO;
import DAO.PresenteDAO;
import DAO.RecadoDAO;
import CLASSES.Pessoa;
import CLASSES.Usuario;
import GUI.MenuInicial;

public class TrabalhoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PessoaDAO PDAO = new PessoaDAO();
        UserDAO UDAO = new UserDAO();  
        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();
        
        Pessoa pessoa = new Pessoa();
        pessoa.criar("Mara", "65465465", PDAO);
        user1.criar(pessoa, "sys", "1234", UDAO);
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.criar("Eliza", "7777 5555", PDAO);
        user2.criar(pessoa1, "tem", "4321", UDAO);
        PresenteDAO presenteDAO = new PresenteDAO();
        presenteDAO.setVetor();
        
        RecadoDAO recadoDAO = new RecadoDAO();
        recadoDAO.setVetor();
        
        PDAO.add(pessoa1);
        
        MenuInicial menu = new MenuInicial();
        menu.exibir();
    }

}
