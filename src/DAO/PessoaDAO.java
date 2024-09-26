/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelo.Pessoa;

/**
 *
 * @author IFTM
 */
public class PessoaDAO {
    int id;
    public Pessoa[] vetor = new Pessoa[100];
    public static int itens;
    
    public boolean add(Pessoa p){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == null){
                this.vetor[i] = p;
                this.itens++;
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(Pessoa p){
        for(int i = 0; i < this.vetor.length; i++){
            if(this.vetor[i] == p){
                this.vetor[i] = null;
                this.itens--;
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
    
    
}
