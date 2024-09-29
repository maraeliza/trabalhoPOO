/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
/**
 *
 * @author Mara
 */
public class MenuLogin {
    
    
      JPanel panel = new JPanel();
      void criar(){
          panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      }
      
      void exibir(){
            this.criar();
            
            JLabel titulo = new JLabel("LOGIN");
            panel.add(titulo);
                   
            panel.add(
                    new JLabel("Insira seu login: "));
            panel.add(
                    new JTextField(10));
            panel.add(
                    new JLabel("Insira sua senha: "));
            panel.add(
                    new JTextField(10));

            int result = JOptionPane.showConfirmDialog(null, panel, "UaiCasórioPro ", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                // Lógica para processar os inputs
            }          
      }

}
