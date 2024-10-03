/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOPAI;


import GUI.Util;

/**
 *
 * @author Mara
 */
public class DAOPAI {
    private Class<?> tipoClasseDAO;
    private String tipoClasse;
    private int id;
    private  Class<?> [] vetor;
    private  int nItens;
    
   
    public DAOPAI(Class<?> tipoClasseDAO, String tipoClasse){
        this.tipoClasseDAO = tipoClasseDAO;
        this.tipoClasse = tipoClasse;
        this.vetor = new Class<?>[10]; // Inicializa o vetor com tamanho 10
        this.nItens = 0; // Inicializa o número de itens
       
    }
    
    public int setNItens() {
        return nItens;
    }

    public static int getItens() {
        return nItens;
    }

    public boolean setVetor() {
        if (nItens == 0) {
            this.vetor = new Class<?>[100];
            return true;
        } else {
            return false;
        }
    }

    public Class<?> [] getVetor() {
        return this.vetor;
    }
    
    public static String getTexto(){
        String texto = "";
        
        for (int i = 0; i < this.vetor.length; i++){
            System.out.println("PERCORRENDO VETOR");
            if(this.vetor[i] != null){
                System.out.println("ITEM NÃO NULO");
                int id = this.vetor[i].getId();
                
                texto += this.vetor[i].ler();
                
            }
        }
        System.out.println("No método getTexto: "+texto);
        return texto;
    }

    public static void cadastrar(String tipo){
        System.out.println("ADICIONANDO ");
         
        if(DAOPAI.addVetor() == true){
            switch(tipo){
                case "Igreja":
                    IgrejaDAO.cadastrar();
                    break;
                case "Presente":
                    PresenteDAO.cadastrar();
                    break;
                case "Recado":
                    RecadoDAO.cadastrar();
                    break;
                case "Pessoa":
                    PessoaDAO.cadastrar();
                    break;
                case "Usuario":
                    UsuarioDAO.cadastrar();
                    break;
                case "Pagamento":
                    PagamentoDAO.cadastrar();
                    break;
                case "Fornecedor":
                    FornecedorDAO.cadastrar();
                    break;
                case "ConvidadoIndividual":
                    ConvidadoIndividualDAO.cadastrar();
                    break;
                case "Cerimonial":
                    CerimonialDAO.cadastrar();
                    break;      
                case "Cartorio":
                    CartorioDAO.cadastrar();
                    break;      
                      
                default:
                    System.out.println("Nao foi possivel adicionar");
                    break;
        }else{
            System.out.println("NÃO FOI POSSíVEL ADICIONAR !");
        }      
    }
    public static void atualizar(String idS, String nome, String tipo){
        int id = Util.stringToInt(idS);
       
        
           
    }
    public static boolean  addVetor(Class<?> p) {
        System.out.println("ADICIONANDO NO VETOR");
        for (int i = 0; i < this.vetor.length; i++) {
            System.out.println("Percorrendo vetor");
            if (this.vetor[i] == null) {
                System.out.println("ITEM NULO ");
                this.vetor[i] = p;
                this.nItens++;
                return true;
            }
        }
        return false;
    }

    public boolean remove( p) {
        for (int i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i] == p) {
               this.vetor[i] = null;
                this.nItens--;
                return true;
            }
        }
        return false;
    }
  
    public static boolean find(int id) {
        for (int i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i] != null && this.vetor[i].id == id) {
                return true;
            }
        }
        return false;
    }

    public static  getItemByID(int id) {
        for (int i = 0; i <this.vetor.length; i++) {
            if (this.vetor[i] != null && this.vetor[i].id == id) {
                return this.vetor[i];
            }
        }
        return null;
    }
     public static boolean delItemByID(int id) {
        for (int i = 0; i <this.vetor.length; i++) {
            if (this.vetor[i] != null && this.vetor[i].id == id) {
                this.vetor[i] = null;
                return true;
            }
        }
        return false;
    }
    public void montarPainelCadastro(){
        
    }
    public void montarPainelRelatorio(){
        
    }
}
