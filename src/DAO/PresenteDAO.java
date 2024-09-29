/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CLASSES.Presente;
import GUI.Util;

/**
 *
 * @author Mara
 */
public class PresenteDAO {
    private Class<Presente> classe;
    private int id;
    private static Presente[] vetor;
    private static int nItens;
    
   
    public PresenteDAO(){
        
        this.classe = Presente.class;
        nItens = 0;
    }
    public static Class<Presente> getClasse(){
        return Presente.class;
    }
    public int setNItens() {
        return nItens;
    }

    public static int getItens() {
        return nItens;
    }

    public boolean setVetor() {
        if (this.nItens == 0) {
            this.vetor = new Presente[100];
            return true;
        } else {
            return false;
        }
    }

    public Presente[] getVetor() {
        return this.vetor;
    }
    
    public static String getTexto(){
        String texto = "PRESENTES JÁ CADASTRADOS";
        
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

    public static void addPresente(String nome, String tipo){
        System.out.println("ADICIONANDO PRESENTE");
        Presente presente = new Presente();
        presente.criar(nome, tipo);
        if(PresenteDAO.add(presente) == true){
            System.out.println("PRESENTE ADICIONADO COM SUCESSO!");
        }else{
            System.out.println("NÃO FOI POSSíVEL ADICIONAR PRESENTE!");
        }      
    }
    public static void upPresente(String idS, String nome, String tipo){
        int id = Util.stringToInt(idS);
        System.out.println("ENCONTRANDO PRESENTE....");
        if(nome.length() > 1 && tipo.length() > 0){
            if (PresenteDAO.find(id)){
                System.out.println("ITEM ENCONTRADO!");
                Presente presente = PresenteDAO.getItemByID(id);
                presente.setNome(nome);
                presente.setTipo(tipo);
                System.out.println("PRESENTE ATUALIZADO COM SUCESSO!");
                Util.mostrarMSG("PRESENTE ATUALIZADO COM SUCESSO!");
            }else{
                Util.mostrarErro("PRESENTE NÃO ENCONTRADO");
            }
        }else{
            Util.mostrarErro("PREENCHA OS CAMPOS!");
        }
        
           
    }
    public static boolean  add(Presente p) {
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

    public boolean remove(Presente p) {
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

    public static Presente getItemByID(int id) {
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