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
        String texto = "RecadoS JÁ CADASTRADOS";
        
        for (int i = 0; i < vetor.length; i++){
            System.out.println("PERCORRENDO VETOR");
            if(vetor[i] != null){
                System.out.println("ITEM NÃO NULO");
                int id = vetor[i].getId();
                
               
                
            }
        }
        System.out.println("No método getTexto: "+texto);
        return texto;
    }

    public static void addRecado(Pessoa pessoa, String comentario){
        System.out.println("ADICIONANDO Recado");
        Recado recado = new Recado();
        recado.criar(pessoa, comentario);
        if(RecadoDAO.add(recado) == true){
            System.out.println("Recado ADICIONADO COM SUCESSO!");
        }else{
            System.out.println("NÃO FOI POSSíVEL ADICIONAR Recado!");
        }      
    }
    public static void upRecado(String idS, String nome, String tipo){
        int id = Util.stringToInt(idS);
        System.out.println("ENCONTRANDO Recado....");
        if(nome.length() > 1 && tipo.length() > 0){
            if (RecadoDAO.find(id)){
                System.out.println("ITEM ENCONTRADO!");
                Recado Recado = RecadoDAO.getItemByID(id);
                
                System.out.println("Recado ATUALIZADO COM SUCESSO!");
                Util.mostrarMSG("Recado ATUALIZADO COM SUCESSO!");
            }else{
                Util.mostrarErro("Recado NÃO ENCONTRADO");
            }
        }else{
            Util.mostrarErro("PREENCHA OS CAMPOS!");
        }
        
           
    }
    public static boolean  add(Recado p) {
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
    public static void cadastrar(String nome, String tipo){
          
        
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
