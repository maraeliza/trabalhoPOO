/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Mara
 */
public class Util {
    
    String mensagem;
    
    public static void mostrarErro(String erroMSG){
        JOptionPane.showMessageDialog(null, erroMSG, "ERRO!", JOptionPane.ERROR_MESSAGE);
        
    }
    public static void mostrarMSG(String MSG){
        JOptionPane.showMessageDialog(null, MSG, "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int stringToInt(String str){
       try{
            int n = Integer.parseInt(str);
            return n;
        }catch(NumberFormatException e){
            mostrarErro("Valor invalido!");
            return 0;
        }
        
    }
    public static String intToString(int n){
       try{
            String str = String.valueOf(n);
            return str;
        }catch(NumberFormatException e){
            mostrarErro("Valor invalido!");
            return "";
        }
        
    }
    public static String dateToString(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Converte o LocalDate para String usando o formatter
        String dataFormatada = data.format(formatter);
        return dataFormatada;
    }
}
