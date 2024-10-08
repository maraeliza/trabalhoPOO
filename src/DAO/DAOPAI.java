/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.lang.reflect.Method;
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
    public Class<?> getClasse() {
        return this.tipoClasseDAO;
    }
    public  void setNItens(int n) {
         nItens = n;
         
    }

    public int getItens() {
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
    
    public String getTexto(){
        String texto = "";
        
        for (int i = 0; i < this.vetor.length; i++){
            System.out.println("PERCORRENDO VETOR");
            if(this.vetor[i] != null){
                System.out.println("ITEM NÃO NULO");
                int id = getId(this.vetor[i]);
                
                texto += this.ler(this.vetor[i]);
                
            }
        }
        System.out.println("No método getTexto: "+texto);
        return texto;
    }

    
    public  boolean  addVetor(Class<?> p) {
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

    public boolean remove(Class <?> p) {
        for (int i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i] == p) {
               this.vetor[i] = null;
                this.nItens--;
                return true;
            }
        }
        return false;
    }
  
    public  boolean find(int id) {
        for (int i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i] != null && getId(this.vetor[i]) == id) {
                return true;
            }
        }
        return false;
    }
    public int getId(Class <?> item){
        try{
            Method buscarId = item.getClass().getMethod("getId");
            int id = (int) buscarId.invoke(item);
            return id;
            
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public String ler(Class <?> item){
        try{
            Method buscarMetodo = item.getClass().getMethod("ler");
            String texto = (String) buscarMetodo.invoke(item);
            return texto;
            
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
    public Class <?>   getItemByID(int id) {
        for (int i = 0; i <this.vetor.length; i++) {
            
            if (this.vetor[i] != null && getId(this.vetor[i]) == id) {
                return this.vetor[i];
            }
        }
        return null;
    }
     public  boolean delItemByID(int id) {
        for (int i = 0; i <this.vetor.length; i++) {
            if (this.vetor[i] != null && getId(this.vetor[i]) == id) {
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
