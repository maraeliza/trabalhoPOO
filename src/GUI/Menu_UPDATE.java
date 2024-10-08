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
public class Menu_UPDATE {

    private String nomeClasse;
    private String texto;
    private String vetor[];
    private String valores[];
    private Class classe;
    private int nColetados;

    public void exibir(Class<?> clazzDAO, String clazzName) {
        this.classe = clazzDAO;
        this.vetor = new String[10];
        this.nomeClasse = clazzName;
        try {
            this.getTexto();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTexto() {
        this.texto = "";
        this.cleanVetor();
        this.add("ID: ");
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
        try {
            Method metodo = this.classe.getMethod("getTexto");

            // Invoca o método estático (passando null porque não precisamos de uma instância)
            this.texto = (String) metodo.invoke(null);
            this.texto.replaceAll("\n", "<br>");
            System.out.println(this.texto);
            
             montarPainel(texto);
        } catch (Exception e) {
            e.printStackTrace();
        }
       

        return "";
    }

    public void montarPainel(String objetos) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("ATUALIZAR CAMPO DE " + this.nomeClasse.toUpperCase());
        panel.add(titulo);
        JLabel relatorio = new JLabel("<html>"+objetos.replaceAll("\n", "<br>")+"<br></html>");
        panel.add(relatorio);

        JTextField[] campos = new JTextField[this.vetor.length];
        this.valores = new String[10];

        this.nColetados = 0;
        for (int i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i] != null) {
                panel.add(new JLabel("\n" + this.vetor[i]));
                campos[i] = new JTextField(10);
                panel.add(campos[i]);
            }
        }
        int result = JOptionPane.showConfirmDialog(null, panel, "UaiCasórioPro ", JOptionPane.OK_CANCEL_OPTION);;

        if (result == JOptionPane.OK_OPTION) {
            for (int i = 0; i < campos.length; i++) {
                if (campos[i] != null) {
                    String valor = campos[i].getText();
                    this.valores[this.nColetados] = valor;
                    System.out.println(this.vetor[i] + ": " + valor); // Exibe o valor
                    this.nColetados++;
                }

            }

            switch (this.nomeClasse) {
                case "Presente" -> {
                    System.out.println("add valores");
                    if (this.valores != null && this.nColetados < 3 && (this.valores[0] == "" || this.valores[1] == "")) {
                        Util.mostrarErro("Preencha todos os valores!");
                    } else if (this.valores != null) {
                        System.out.println("VALORES NÃO NULOS ADD");
                        System.out.println("ID " + this.valores[0] + " " + this.valores[1] + this.valores[2]);

                        PresenteDAO.atualizar(this.valores[0], this.valores[1], this.valores[2]);
                    }
                }
                case "Recado" -> {
                    System.out.println("add valores");
                    if (this.valores != null && this.nColetados < 2 && (this.valores[0] == "" || this.valores[1] == "")) {
                        Util.mostrarErro("Preencha todos os valores!");
                    } else if (this.valores != null) {
                        System.out.println("VALORES NÃO NULOS ADD");
                        System.out.println("ID " + this.valores[0] + " " + this.valores[1] );

                        RecadoDAO.atualizar(this.valores[0], this.valores[1]);
                    }
                }
            }

        } else {

            System.out.println("Cancelada!");
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
