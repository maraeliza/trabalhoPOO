/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

/**
 *
 * @author Mara
 */
public abstract class DAO {
    
    abstract void setNItens(int n);
    abstract int getNItens();
    
    abstract boolean setVetor();
    abstract Object[] getVetor();
    
    abstract String getTexto();
    
    abstract void cadastrar(Object vetor[]);
    abstract boolean addVetor(Object obj);
    
    abstract void atualizar(Object vetor[]);
    
    abstract boolean find(int id);
    abstract Object getItemByID(int id);
    
    abstract boolean delItemByID(int id);
    abstract Object remove(Object obj);
  
}
