package main;

import DAO.PessoaDAO;
import DAO.UserDAO;
import modelo.Pessoa;
import modelo.Usuario;

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
         
       
        
        PDAO.add(pessoa1);
        
        
        
    }

}
