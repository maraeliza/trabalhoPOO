/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;
import DAO.UsuarioDAO;
import CLASSES.Usuario;
/**
 *
 * @author Mara
 */
public class MenuLogin {
    
      void exibir(){
          String texto = "\nLOGAR\n";
          texto += "\nLOGIN: ";
          String result = JOptionPane.showInputDialog(null, texto, "admin");
          
          if(result != null && result.length() > 1){
              
              String user = result;
              texto = "\nLOGAR\n";
              texto = "SENHA: ";
              result = JOptionPane.showInputDialog(null, texto, "1234");
              System.out.println("Senha digitada: "+result);
              if(result != null && result.length() > 3){
                  System.out.println("autenticando usuario: "+user);
                  if(UsuarioDAO.autentica(user, result) == true){
                        Usuario usuario = UsuarioDAO.getUser(user);
                        MenuInicial menu = new MenuInicial();
                        menu.exibir(true, usuario);
                  }else{
                      
                      Util.mostrarErro("Não foi possível realizar login! \nVerifique suas credenciais e tente novamente!");
                  }
                  
                  
                  
              }else{
                  Util.mostrarErro("Digite sua senha!");
              }
          }else{
              Util.mostrarErro("Digite seu login!");
              
          }
      }

}
