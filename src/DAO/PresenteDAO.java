/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAO.DAOPAI;
import CLASSES.Presente;
import GUI.Util;

/**
 *
 * @author Mara
 */
public class PresenteDAO extends DAOPAI{
    private Class<Presente> classe;
    private int id;
    private static Presente[] vetor;
    private static int nItens;
    
   public PresenteDAO (){
        super(PresenteDAO.class, "Presente");
   }

    public  Class<Presente> getClasse(){
        return Presente.class;
    }
    public int setNItens() {
        return nItens;
    }


    public boolean setVetor() {
        if (nItens == 0) {
            this.vetor = new Presente[100];
            return true;
        } else {
            return false;
        }
    }

    
  

    public static void cadastrar(String nome, String tipo){
        System.out.println("ADICIONANDO PRESENTE");
        Presente presente = new Presente();
        presente.criar(nome, tipo);
        if(PresenteDAO.addVetor(presente) == true){
            System.out.println("PRESENTE ADICIONADO COM SUCESSO!");
        }else{
            System.out.println("NÃO FOI POSSíVEL ADICIONAR PRESENTE!");
        }      
    }
    public  void atualizar(String idS, String nome, String tipo){
        int id = Util.stringToInt(idS);
        System.out.println("ENCONTRANDO PRESENTE....");
        if(nome.length() > 1 && tipo.length() > 0){
            if (this.find(id)){
                System.out.println("ITEM ENCONTRADO!");
                /*
                Presente presente = this.getItemByID(id);
                presente.setNome(nome);
                presente.setTipo(tipo);
                */
                System.out.println("PRESENTE ATUALIZADO COM SUCESSO!");
                Util.mostrarMSG("PRESENTE ATUALIZADO COM SUCESSO!");
            }else{
                Util.mostrarErro("PRESENTE NÃO ENCONTRADO");
            }
        }else{
            Util.mostrarErro("PREENCHA OS CAMPOS!");
        }
        
           
    }
    public static boolean  addVetor(Presente p) {
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
  
    
    public void montarPainelCadastro(){
        
    }
    public void montarPainelRelatorio(){
        
    }
}
