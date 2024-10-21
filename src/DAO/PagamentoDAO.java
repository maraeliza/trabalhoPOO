/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CLASSES.Pagamento;
import GUI.Util;

/**
 *
 * @author Mara
 */
public class PagamentoDAO {
    private Class<Pagamento> classe;
    private int id;
    private static Pagamento[] vetor;
    private static int nItens;
    
   
    public PagamentoDAO(){
        
        this.classe = Pagamento.class;
        nItens = 0;
         this.setVetor();
    }
    public static Class<Pagamento> getClasse(){
        return Pagamento.class;
    }
    public int setNItens() {
        return nItens;
    }

    public static int getItens() {
        return nItens;
    }

    public boolean setVetor() {
        if (this.nItens == 0) {
            this.vetor = new Pagamento[100];
            return true;
        } else {
            return false;
        }
    }

    public Pagamento[] getVetor() {
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
        Pagamento recado = new Pagamento();
        //recado.criar(null,nome);
        if(PagamentoDAO.addVetor(recado) == true){
            System.out.println("RECADO ADICIONADO COM SUCESSO!");
        }else{
            System.out.println("NÃO FOI POSSíVEL ADICIONAR RECADO!");
        }      
    }
    public static void atualizar(String idS, String comentario){
        int id = Util.stringToInt(idS);
        System.out.println("ENCONTRANDO RECADO....");
        if(comentario.length() > 1 ){
            if (PagamentoDAO.find(id)){
                System.out.println("ITEM ENCONTRADO!");
                Pagamento recado = PagamentoDAO.getItemByID(id);
                //recado.setComentario(comentario);
                
                System.out.println("RECADO ATUALIZADO COM SUCESSO!");
                Util.mostrarMSG("RECADO ATUALIZADO COM SUCESSO!");
            }else{
                Util.mostrarErro("RECADO NÃO ENCONTRADO");
            }
        }else{
            Util.mostrarErro("PREENCHA OS CAMPOS!");
        }
        
           
    }
    public static boolean  addVetor(Pagamento p) {
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

    public boolean remove(Pagamento p) {
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

    public static Pagamento getItemByID(int id) {
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
