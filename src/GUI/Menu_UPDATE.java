/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.DAO;
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
    private DAO dao;
    private int idClasse;

    public void exibir(DAO dao, int idClasse) {
        this.dao = dao;
        this.idClasse = idClasse;
        this.vetor = new String[10];
        this.nomeClasse = this.dao.getNameClasseById(idClasse);
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
        this.texto = this.dao.getTexto(this.idClasse);

        montarPainel(texto);

        return "";
    }

    public void montarPainel(String objetos) {

        String conteudo = "\nATUALIZAR CAMPO DE " + this.nomeClasse.toUpperCase();

        this.valores = new String[10];
        conteudo = "\nATUALIZAR " + this.nomeClasse.toUpperCase();
        conteudo += "\n" + objetos + "\n\n";
        conteudo += "\n\nINSIRA " + this.vetor[0].toUpperCase();
        String result = JOptionPane.showInputDialog(null, conteudo, "UaiCasórioPro", JOptionPane.QUESTION_MESSAGE);
        if (result != null) {
            int idInserido = Util.stringToInt(result);
            this.valores[0] = result;
            try {
                
                boolean existe = this.dao.find(this.idClasse, idInserido);
                

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
                    this.dao.atualizar(this.idClasse, this.valores);
                    this.exibir(this.dao, this.idClasse);
                } else {
                    Util.mostrarErro("Elemento de id " + result + " não encontrado!");
                }
            }catch (Exception e) {
                Util.mostrarErro("Digite um ID válido!");
            }
        } else {
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
