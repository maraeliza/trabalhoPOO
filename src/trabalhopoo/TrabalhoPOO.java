/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhopoo;

/**
 *
 * @author Jussie
 */
public class TrabalhoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

        pessoa.criar("Mara", "65465465");
        String dados = pessoa.ler();
        System.out.println(dados);

        Usuario user1 = new Usuario();
        user1.criar(pessoa, "user", "1234");
        
        System.out.println(user1.pessoa.nome);
    }

}
