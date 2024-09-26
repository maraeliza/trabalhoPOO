/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

/**
 *
 * @author Jussie
 */
public class Cerimonial {
    private int id;
    String noiva;
    String noivo;
    String padrinhos;
    String madrinhas;
    String local;
    int nrPadrinhos;
    int nrMadrinhas;
    int qtdConvidados;
    public static int totalCerimonial;
    
    public void criar(String noiva, String noivo, String padrinhos, String madrinhas, String local, int nrPadrinhos, int nrMadrinhas, int qtdConvidados){
        this.id = totalCerimonial++;
        this.noiva = noiva;
        this.noivo = noivo;
        this.padrinhos = padrinhos;
        this.madrinhas = madrinhas;
        this.local = local;
        this.nrPadrinhos = nrPadrinhos;
        this.nrMadrinhas = nrMadrinhas;
        this.qtdConvidados = qtdConvidados;
    }
    public String ler(){
        String dados = "Nome da noiva: " + this.noiva;
        dados += "Nome do noivo: " + this.noivo;
        dados += "Nome dos padrinhos: " + this.padrinhos;
        dados += "Nome das madrinhas: " + this.madrinhas;
        dados += "Local: " + this.local;
        return dados;
    }
    
    public void deletar(){
        
    }
}
