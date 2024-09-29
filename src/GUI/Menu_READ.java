/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.lang.reflect.Method;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import DAO.PresenteDAO;

/**
 *
 * @author Mara
 */
public class Menu_READ {

    private String nomeClasse;
    private String texto;
    private String vetor[];
    private String valores[];
    private int nColetados;

    public void exibir(Class<?> clazzDAO, String clazzName) {
        try {
            Method metodo = clazzDAO.getMethod("getItens");
            int n = (int) metodo.invoke(null);
            if (n > 0) {
                this.nomeClasse = clazzName;

                try {
                    System.out.println("NOME DA CLASSE: " + this.nomeClasse);
                    String texto = this.getDados(clazzDAO);
                    int res = JOptionPane.showConfirmDialog(null, texto, "RELATÓRIO DE " + this.nomeClasse.toUpperCase(), JOptionPane.OK_CANCEL_OPTION);

                    System.out.println("TEXTO: " + texto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Util.mostrarMSG("Nenhum item encontrado ainda!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getDados(Class<?> clazzDAO) {
        this.texto = "";

        try {
            Method metodo = clazzDAO.getMethod("getTexto");

            // Invoca o método estático (passando null porque não precisamos de uma instância)
            this.texto = (String) metodo.invoke(null);

            System.out.println(this.texto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        montarPainel();

        return this.texto;
    }

    public void montarPainel() {

    }

    public boolean add(String p) {
        for (int i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i] == null) {
                this.vetor[i] = p;
                return true;
            }
        }
        return false;
    }

    public boolean cleanVetor() {
        for (int i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i] != null) {
                this.vetor[i] = null;
                return true;
            }
        }
        return false;
    }

}
