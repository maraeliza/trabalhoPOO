/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CLASSES.Igreja;
import GUI.Util;

/**
 *
 * @author Mara
 */
public class IgrejaDAO {
    private Class<Igreja> classe;
    private int id;
    private static Igreja[] vetor;
    private static int nItens;
    
   
    public IgrejaDAO(){
        
        this.classe = Igreja.class;
        nItens = 0;
        this.setVetor();
    }
    public static Class<Igreja> getClasse(){
        return Igreja.class;
    }
    public int setNItens() {
        return nItens;
    }

    public static int getItens() {
        return nItens;
    }

    public boolean setVetor() {
        if (this.nItens == 0) {
            this.vetor = new Igreja[100];
            return true;
        } else {
            return false;
        }
    }

    public Igreja[] getVetor() {
        return this.vetor;
    }
    
    public static String getTexto(){
        String texto = "IGREJAS JÁ CADASTRADOS";
        
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

    public static void cadastrar(String nome, String tipo){
        System.out.println("ADICIONANDO IGREJA");
        Igreja igreja = new Igreja();
        igreja.criar(nome, tipo);
        if(IgrejaDAO.addVetor(igreja) == true){
            System.out.println("IGREJA ADICIONADO COM SUCESSO!");
        }else{
            System.out.println("NÃO FOI POSSíVEL ADICIONAR IGREJA!");
        }      
    }
    public static void atualizar(String idS, String nome){
        int id = Util.stringToInt(idS);
        System.out.println("ENCONTRANDO IGREJA....");
        if(nome.length() > 1 ){
            if (IgrejaDAO.find(id)){
                System.out.println("ITEM ENCONTRADO!");
                Igreja igreja = IgrejaDAO.getItemByID(id);
                igreja.setNome(nome);
                
                System.out.println("IGREJA ATUALIZADO COM SUCESSO!");
                Util.mostrarMSG("IGREJA ATUALIZADO COM SUCESSO!");
            }else{
                Util.mostrarErro("IGREJA NÃO ENCONTRADO");
            }
        }else{
            Util.mostrarErro("PREENCHA OS CAMPOS!");
        }
        
           
    }
    public static boolean  addVetor(Igreja p) {
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

    public boolean remove(Igreja p) {
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

    public static Igreja getItemByID(int id) {
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
