/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author Mara
 */
public class Menu_CRUD {

    private String texto;
    private String op;
    private int o;
    private Class<?> tipoClasseDAO;
    private String tipoClasse;
    private boolean logou;

    private void definirTexto(String classNome) {
        this.texto = "\n\nMENU DE " + classNome + "S";
        this.texto += "\n\nEscolha a opção a seguir ";
        this.texto += "\n1. Adicionar novo";
        this.texto += "\n2. Atualizar";
        this.texto += "\n3. Ver todos";
        this.texto += "\n4. Deletar";
        this.texto += "\n5. Voltar";

        this.texto += "\n\nDigite aqui o número da sua opção: ";

    }

    public void exibir(Class<?> clazzDAO, boolean logou) {
        this.logou = logou;
        System.out.println("exibindo o menu de edição da classe!");
        do{

            this.tipoClasseDAO = clazzDAO;
            this.tipoClasse = this.tipoClasseDAO.getSimpleName().replace("DAO", "");
            System.out.println(this.tipoClasse);
            String classe = this.tipoClasse.toUpperCase();
            this.definirTexto(classe);

            this.op = JOptionPane.showInputDialog(null, this.texto, "UaiCasórioPro ", JOptionPane.QUESTION_MESSAGE);
            this.lidarEscolha();

        }while (this.o != 5 && this.o != 0) ;
    }

    private void lidarEscolha() {

        this.o = Util.stringToInt(this.op);
        switch (o) {

            case 1 -> {
                Menu_CREATE menuAdd = new Menu_CREATE();
                menuAdd.exibir(this.tipoClasseDAO, this.tipoClasse, this.logou);

                break;
            }
            case 2 -> {
                Menu_UPDATE menuUp = new Menu_UPDATE();
                System.out.println("atualizar");
                menuUp.exibir(this.tipoClasseDAO, this.tipoClasse);
                break;
            }
            case 3 -> {
                Menu_READ menuVer = new Menu_READ();
                System.out.println("ver cadastros");
                menuVer.exibir(this.tipoClasseDAO, this.tipoClasse);
                break;
            }
            case 4 -> {
                Menu_DEL menuDel = new Menu_DEL();
                System.out.println("deletar");
                menuDel.exibir(this.tipoClasseDAO, this.tipoClasse);
                break;
            }
            case 5 -> {

                break;
            }

            default -> {
                break;
            }

        }

    }
}
