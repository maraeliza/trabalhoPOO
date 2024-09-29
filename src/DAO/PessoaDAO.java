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
    
    public void montarPainel(){
        
    }
    
    
    
    
}
