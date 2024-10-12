/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CLASSES.Pessoa;

/**
 *
 * @author IFTM
 */
public class PessoaDAO {
    private int id;
    private Pessoa[] vetor;
    private static int nItens;
    
    
    public PessoaDAO(){
        
        this.setVetor();
        Pessoa pessoa1 = new Pessoa();
        pessoa1.criar("ADMINISTRADOR", "7777 5555", "adm");
        UserDAO.add(pessoa1, "admin", "1234", 1);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.criar("João", "3432 2556", "NOIVO");
        UserDAO.add(pessoa2, "jo2024", "1234", 1);
       
        Pessoa pessoa3 = new Pessoa();
        pessoa3.criar("Maria", "3431 1335", "NOIVO");
        UserDAO.add(pessoa3, "ma2024", "1234", 1);
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.criar("Ana", "3431 1335", "convidado");
        UserDAO.add(pessoa3, "an2024", "1234", 2);
        
        
        
    }
    public int setNItens(){
        return this.nItens;
    }
    public int getItens(){
        return this.nItens;
    }
    public boolean setVetor(){
        if(this.nItens == 0){
            this.vetor = new Pessoa[100];
            return true;
        }else{
            return false;
        }
    }
    public Pessoa[] getVetor(){
        return this.vetor;
    }
    
    public boolean add(Pessoa p){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == null){
                this.vetor[i] = p;
                this.nItens++;
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(Pessoa p){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == p){
                this.vetor[i] = null;
                this.nItens--;
                return true;
            }
        }
        return false;
    }
    
    public boolean find(Pessoa p){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == p){
                return true;
            }
        }
        return false;
    }
    
    public Pessoa getItemByID(int id){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] != null && this.vetor[i].id == id){
                return this.vetor[i];
            }
        }
        return null;
    }
    public Pessoa[] getNoivos(){
        Pessoa noivos[] = new Pessoa[2];
        int n = 0;
         for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] != null && this.vetor[i].getTipo().equals("NOIVO")){
               noivos[n] = this.vetor[i];
               n++;
            }
        }
        return noivos;
    }
    public void montarPainel(){
        
    }
    
    
    
    
}
