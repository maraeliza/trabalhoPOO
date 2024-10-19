/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.PessoaDAO;
import java.lang.reflect.Method;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import DAO.PresenteDAO;

import DAO.RecadoDAO;
import java.lang.reflect.InvocationTargetException;

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
            case "Pessoa" -> {
                this.add("Nome: ");
                this.add("Telefone: ");
                this.add("Tipo: ");
                this.add("Data de Nascimento: ");
                break;
            }
        }
        try {
            Method metodo = this.classe.getMethod("getTexto");

            // Invoca o método estático (passando null porque não precisamos de uma instância)
            this.texto = (String) metodo.invoke(null);
            System.out.println(this.texto);

            montarPainel(texto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public void montarPainel(String objetos) {

        String conteudo = "\nATUALIZAR CAMPO DE " + this.nomeClasse.toUpperCase();

        this.valores = new String[10];
        conteudo = "\nATUALIZAR " + this.nomeClasse.toUpperCase();
        conteudo += "\n" + objetos + "\n\n";
        conteudo += "\n\nINSIRA " + this.vetor[0].toUpperCase();
        String result = JOptionPane.showInputDialog(null, conteudo, "UaiCasórioPro", JOptionPane.QUESTION_MESSAGE);
        if(result != null){
          int idInserido = Util.stringToInt(result);
        this.valores[0] = result;
        try {
            Method metodo = this.classe.getMethod("find", int.class);
            boolean existe = (boolean) metodo.invoke(null, idInserido);

            if (existe) {
                this.nColetados = 0;
                for (int i = 1; i < this.vetor.length; i++) {
                    if (this.vetor[i] != null && result != null) {
                        conteudo = "\nATUALIZAR " + this.nomeClasse.toUpperCase();
                        conteudo += "\n\nINSIRA " + this.vetor[i].toUpperCase();
                        result = JOptionPane.showInputDialog(null, conteudo, "UaiCasórioPro", JOptionPane.QUESTION_MESSAGE);
                        this.nColetados++;
                        this.valores[this.nColetados] = result;
                        
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
                            System.out.println("ID " + this.valores[0] + " " + this.valores[1]);

                            RecadoDAO.atualizar(this.valores[0], this.valores[1]);
                        }
                    }
                    case "Pessoa" -> {
                        System.out.println("add valores");
                        if (this.valores != null && this.nColetados < 2 && (this.valores[0] == "" || this.valores[1] == "")) {
                            Util.mostrarErro("Preencha todos os valores!");
                        } else if (this.valores != null) {
                            System.out.println("VALORES NÃO NULOS ADD");
                            System.out.println("ID " + this.valores[0] + " " + this.valores[1]);

                            PessoaDAO.atualizar(this.valores);
                        }
                    }
                }

            } else {
                Util.mostrarErro("Elemento de id " + result + " não encontrado!");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Util.mostrarErro("Digite um ID válido!");
        }  
        }else{
             Util.mostrarErro("Digite um ID válido!");
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
