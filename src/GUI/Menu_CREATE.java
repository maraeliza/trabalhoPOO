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
import DAO.RecadoDAO;

/**
 *
 * @author Mara
 */
public class Menu_CREATE {

    private String nomeClasse;
    private String texto;
    private String vetor[];
    private String valores[];
    private int nColetados;

    public void exibir(Class<?> clazzDAO, String clazzName, boolean logou) {
        this.vetor = new String[10];

        this.nomeClasse = clazzName;
        if (this.nomeClasse == "Recado" && logou == false) {
            Util.mostrarErro("Logue para adicionar recados!");
            return;
        } else {
            try {
                this.getTexto();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String getTexto() {
        this.texto = "";
        this.cleanVetor();
        switch (this.nomeClasse) {

            case "Presente" -> {
                this.add("Nome: ");
                this.add("Tipo: ");

                break;
            }
            case "Recado" -> {
                this.add("Comentário: ");

                break;
            }
        }

        montarPainel();
        return "";
    }

    public void montarPainel() {

        String conteudo = "\nCADASTRAR " + this.nomeClasse.toUpperCase();
        conteudo += "\n";
        this.valores = new String[10];
        String result = "";
        this.nColetados = 0;
        for (int i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i] != null && result != null) {
                conteudo = "\nCADASTRAR " + this.nomeClasse.toUpperCase();
                conteudo += "\n\nINSIRA " + this.vetor[i].toUpperCase();
                result = JOptionPane.showInputDialog(null, conteudo, "UaiCasórioPro", JOptionPane.QUESTION_MESSAGE);
                this.valores[this.nColetados] = result;
                this.nColetados++;
            }
        }
        switch (this.nomeClasse) {
            case "Presente" -> {
                System.out.println("add valores");
                if (this.valores != null && this.nColetados < 2 && (this.valores[0] == "" || this.valores[1] == "")) {
                    Util.mostrarErro("Preencha todos os valores!");
                } else if (this.valores != null) {
                    System.out.println("VALORES NÃO NULOS ADD");
                    System.out.println(this.valores[0] + " " + this.valores[1]);

                    PresenteDAO.cadastrar(this.valores[0], this.valores[1]);
                }
            }
            case "Recado" -> {
                System.out.println("add valores");
                if (this.valores != null && this.nColetados < 1 && (this.valores[0] == "")) {
                    Util.mostrarErro("Preencha todos os valores!");
                } else if (this.valores != null) {
                    System.out.println("VALORES NÃO NULOS ADD");
                    System.out.println(this.valores[0]);
                    RecadoDAO.cadastrar(this.valores[0]);

                }
            }
        }

    }

    public void cadastrar(int n) {

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
