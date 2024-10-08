/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.lang.reflect.Method;
import javax.swing.JOptionPane;

/**
 *
 * @author Mara
 */
public class Menu_DEL {

    private String nomeClasse;
    private String texto;
    private String vetor[];
    private String valores[];
    private int nColetados;

    public void exibir(Class<?> clazzDAO, String clazzName) {

        this.nomeClasse = clazzName;

        try {
            System.out.println("NOME DA CLASSE: " + this.nomeClasse);
            String texto = this.getDados(clazzDAO);
            
            texto += "\n\nDigite o ID para excluir: ";
            String res = JOptionPane.showInputDialog(null, texto, "0");
            if (res != null && res.length()  > 0 ) {
                int id = Util.stringToInt(res);
                System.out.println("TEXTO: " + texto);
                try {
                    Method metodo = clazzDAO.getMethod("delItemByID", int.class);

                    // Invoca o método estático (passando null porque não precisamos de uma instância)
                    boolean sucess = (boolean) metodo.invoke(null, id);

                    if (sucess) {
                        JOptionPane.showMessageDialog(null, "Elemento " + id + " excluído com sucesso!", "DELETADO", JOptionPane.INFORMATION_MESSAGE);
                        this.exibir(clazzDAO, clazzName);

                    } else {
                        System.out.println("Nao foi possivel fazer a exclusao");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
