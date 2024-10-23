/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;

import CONTROLLER.DAO;
import javax.swing.JOptionPane;
import MODEL.Usuario;
/**
 *
 * @author Mara
 */
public class MenuLogin {
    private DAO dao;
    
    public  void exibir(DAO dao){
          this.dao = dao;
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
                  if(dao.autentica(user, result) == true){
                        Usuario usuario = dao.getUser(user);
                        MenuInicial menu = new MenuInicial();
                        menu.exibir(this.dao, true, usuario);
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
