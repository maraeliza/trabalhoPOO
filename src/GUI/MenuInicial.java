/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import DAO.DAOPAI;
import DAO.RecadoDAO;
import DAO.PresenteDAO;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author Mara
 */
public class MenuInicial {

    private String texto;
    private String op;
    private static boolean logou;
    private DAOPAI dao1;
    private DAOPAI dao2;
    
    public MenuInicial(DAOPAI dao1, DAOPAI dao2){
        MenuInicial.logou = false;
        this.dao1 = dao1;
        this.dao2 = dao2;
    }
    private void definirTexto(String noivo, String noiva) {
        this.texto = "\n                    BEM VINDO               ";
        this.texto += "\n\nNOIVOS";
        this.texto += "\n" + noivo + " ❤ " + noiva + "  \n";
        this.texto += "\n\nEscolha a opção a seguir ";
        this.texto += "\n1.LOGIN";
        this.texto += "\n2.RECADOS";
        this.texto += "\n3.PRESENTES";
        this.texto += "\n4.SAIR";
        this.texto += "\n\nDigite aqui o número da sua opção: ";

    }

    public void exibir( ) {
        int o = -1;  // Valor inicial inválido para garantir que o loop execute pelo menos uma vez
           do {
               this.definirTexto("João", "Maria");

               this.op = JOptionPane.showInputDialog(null, this.texto, "UaiCasórioPro", JOptionPane.QUESTION_MESSAGE);
               System.out.println(this.op);
               // Verifica se a entrada não é nula e converte a string para int
               if (this.op != null) {
                   o = Util.stringToInt(this.op);
               } else {
                   // Se for null, o usuário fechou a janela ou clicou em "Cancelar"
                   o = 4; // Define para "Sair"
               }

               // Chama o método de lidar com a escolha
               this.lidarEscolha(o);
           } while (o != 0 && o != 4); // O loop continuará até o usuário escolher "Sair" ou "0"

    }

    private void lidarEscolha(int o) {
        switch (o) {

            case 1 -> {
                MenuLogin menu = new MenuLogin();
                menu.exibir();
                break;
            }
            case 2 -> {
                Menu_CRUD menu = new Menu_CRUD();
                menu.exibir(this.dao2,"Recado", MenuInicial.logou);
                break;
            }
            case 3 -> {
                Menu_CRUD menu = new Menu_CRUD();
                menu.exibir(this.dao1, "Presente", MenuInicial.logou);
                break;
            }
            case 4 -> {
                break;
            }
            default -> {
                break;
            }

        }
       

    }

}
