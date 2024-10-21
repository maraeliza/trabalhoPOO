/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CLASSES.Pessoa;
import CLASSES.Recado;
import GUI.Util;

/**
 *
 * @author Mara
 */
public class RecadoDAO {
    private Class<Recado> classe;
    private int id;
    private static Recado[] vetor;
    private static int nItens;
    
   
    public RecadoDAO(){
        
        this.classe = Recado.class;
        nItens = 0;
         this.setVetor();
    }
    public static Class<Recado> getClasse(){
        return Recado.class;
    }
    
    public static int setNItens() {
        return nItens;
    }

    public static int getNItens() {
        return nItens;
    }

    public boolean setVetor() {
        if (this.nItens == 0) {
            this.vetor = new Recado[100];
            return true;
        } else {
            return false;
        }
    }

    public Recado[] getVetor() {
        return this.vetor;
    }
    
    public static String getTexto(){
        String texto = "RECADOS JÁ CADASTRADOS";
        
        for (int i = 0; i < vetor.length; i++){
            if(vetor[i] != null){
                int id = vetor[i].getId();
                texto += vetor[i].ler();
                
            }
        }
        if(texto.equals("RECADOS JÁ CADASTRADOS")){
             texto += "\n\nNENHUM ITEM ENCONTRADO!\n";
        }    
        return texto;
    }

    public static void cadastrar(String coment, Pessoa pessoa){
        Recado recado = new Recado();
        Object[] vetor = new Object[2];
        vetor[0] = pessoa;
        vetor[1] = coment;
        recado.criar(vetor);
        if(RecadoDAO.addVetor(recado) == true){
            System.out.println(" ADICIONADO COM SUCESSO!");
        }else{
            System.out.println("NÃO FOI POSSíVEL ADICIONAR!");
        }      
    }
    public static void atualizar(String idS, String comentario){
        int id = Util.stringToInt(idS);
        if(comentario.length() > 1 ){
            if (RecadoDAO.find(id)){
                Recado recado = RecadoDAO.getItemByID(id);
                recado.setComentario(comentario);
                
                Util.mostrarMSG("RECADO ATUALIZADO COM SUCESSO!");
            }else{
                Util.mostrarErro("RECADO NÃO ENCONTRADO");
            }
        }else{
            Util.mostrarErro("PREENCHA OS CAMPOS!");
        }
        
           
    }
    public static boolean  addVetor(Recado p) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == null) {
                
                vetor[i] = p;
                nItens++;
                return true;
            }
        }
        return false;
    }

    public boolean remove(Recado p) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == p) {
               vetor[i] = null;
                nItens--;
                return true;
            }
        }
        return false;
    }
  
    public static boolean find(int id) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null && vetor[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static Recado getItemByID(int id) {
        for (int i = 0; i <vetor.length; i++) {
            if (vetor[i] != null && vetor[i].getId() == id) {
                return vetor[i];
            }
        }
        return null;
    }
     public static boolean delItemByID(int id) {
        for (int i = 0; i <vetor.length; i++) {
            if (vetor[i] != null && vetor[i].getId() == id) {
                vetor[i] = null;
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
