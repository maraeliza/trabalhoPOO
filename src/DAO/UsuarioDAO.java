/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CLASSES.Pessoa;
import CLASSES.Usuario;

/**
 *
 * @author IFTM
 */
public class UsuarioDAO {
    private int id;
    private static Usuario[] vetor;
    private static int itens;
    
    public UsuarioDAO(){
        UsuarioDAO.vetor = new Usuario[100];
    }
    
    public static boolean add(Pessoa pessoa, String login, String senha, int tipo){
        System.out.println("criando usuario da pessoa "+pessoa.getNome());
        Usuario newUser = new Usuario();
        newUser.criar(pessoa, login, senha, tipo);
        System.out.println("add no vetor");
        for(int i = 0; i < vetor.length; i++){
            System.out.println("pos "+i+" no vetor encontrada ");
            if(vetor[i] == null){
                vetor[i] = newUser;
                itens++;
                System.out.println("Usuario: "+newUser.getLogin());
                System.out.println("Usuario adicionado com sucesso!");
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(Usuario p){
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == p){
                vetor[i] = null;
                itens--;
                return true;
            }
        }
        return false;
    }
    
    public boolean find(Usuario p){
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == p){
                return true;
            }
        }
        return false;
    }
    public static Usuario getUser(String user){
        System.out.println("Procurando usuario "+user);
        for(int i = 0; i < vetor.length; i++){
            
            if(vetor[i] != null && vetor[i].getLogin().equals(user) ){
                System.out.println("usuario encontrado "+user);
                return vetor[i];
            }
        }
        System.out.println("usuario nao encontrado "+user);
        return null;
    }

    
    
     public String getNomeByID(int id){
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] != null && vetor[i].getId() == id){
                return this.vetor[i].getNome();
            }
        }
        return "";
    }
    
    public static boolean autentica(String user, String senha){
        System.out.println("Autenticando usuario "+user+" com senha "+senha);
        Usuario usuario = UsuarioDAO.getUser(user);
        
        
        if(usuario != null){
            System.out.println("usuario encontrado "+usuario.getLogin());
            if(usuario.getSenha().equals(senha) ){
                return true;
            }else {
                return false;
            }
        }else{
            System.out.println("usuario nao encontrado "+user);
            return false;
        }
    }
 
     
}
