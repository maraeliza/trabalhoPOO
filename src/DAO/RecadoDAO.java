/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
    }
    public static Class<Recado> getClasse(){
        return Recado.class;
    }
    public int setNItens() {
        return nItens;
    }

    public static int getItens() {
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
            System.out.println("PERCORRENDO VETOR");
            if(vetor[i] != null){
                System.out.println("ITEM NÃO NULO");
                int id = vetor[i].getId();
                
                texto += vetor[i].ler();
                
            }
        }
        System.out.println("No método getTexto: "+texto);
        return texto;
    }

    public static void cadastrar(String nome){
        System.out.println("ADICIONANDO RECADO");
        Recado recado = new Recado();
        recado.criar(null,nome);
        if(RecadoDAO.addVetor(recado) == true){
            System.out.println("RECADO ADICIONADO COM SUCESSO!");
        }else{
            System.out.println("NÃO FOI POSSíVEL ADICIONAR RECADO!");
        }      
    }
    public static void atualizar(String idS, String comentario){
        int id = Util.stringToInt(idS);
        System.out.println("ENCONTRANDO RECADO....");
        if(comentario.length() > 1 ){
            if (RecadoDAO.find(id)){
                System.out.println("ITEM ENCONTRADO!");
                Recado recado = RecadoDAO.getItemByID(id);
                recado.setComentario(comentario);
                
                System.out.println("RECADO ATUALIZADO COM SUCESSO!");
                Util.mostrarMSG("RECADO ATUALIZADO COM SUCESSO!");
            }else{
                Util.mostrarErro("RECADO NÃO ENCONTRADO");
            }
        }else{
            Util.mostrarErro("PREENCHA OS CAMPOS!");
        }
        
           
    }
    public static boolean  addVetor(Recado p) {
        System.out.println("ADICIONANDO NO VETOR");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Percorrendo vetor");
            if (vetor[i] == null) {
                System.out.println("ITEM NULO ");
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
            if (vetor[i] != null && vetor[i].id == id) {
                return true;
            }
        }
        return false;
    }

    public static Recado getItemByID(int id) {
        for (int i = 0; i <vetor.length; i++) {
            if (vetor[i] != null && vetor[i].id == id) {
                return vetor[i];
            }
        }
        return null;
    }
     public static boolean delItemByID(int id) {
        for (int i = 0; i <vetor.length; i++) {
            if (vetor[i] != null && vetor[i].id == id) {
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
