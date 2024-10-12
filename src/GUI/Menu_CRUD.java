/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;

import CLASSES.Usuario;

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
    private String userTipo;
    private int tipoUsuario;
    private Usuario user;

    private void definirTexto(String classNome) {
        this.texto = "\n\nMENU DE " + classNome + "S";
        this.texto += "\n\nEscolha a opção a seguir ";
        this.texto += "\n1. Adicionar novo";
        this.texto += "\n2. Ver todos";
        System.out.println("DEFINIR TEXTO ");
        
        if (this.user != null && this.user.getTipo() == 1) {
            this.texto += "\n3. Atualizar";
            this.texto += "\n4. Deletar";
            this.texto += "\n5. Voltar";
        } else {
            this.texto += "\n3. Voltar";
        }

        this.texto += "\n\nDigite aqui o número da sua opção: ";

    }

    public void exibir(Class<?> clazzDAO, boolean logou, Usuario user) {
        System.out.println("Exibindo o menu de edição de objetos da classe");
        this.logou = logou;
        this.user = user;
        
       
        if(this.user != null){
            this.tipoUsuario = user.getTipo();
        }else{
            this.tipoUsuario = 0;
        }
        
        System.out.println("exibindo o menu de edição da classe!");
        do {

            this.tipoClasseDAO = clazzDAO;
            this.tipoClasse = this.tipoClasseDAO.getSimpleName().replace("DAO", "");
            System.out.println(this.tipoClasse);
            String classe = this.tipoClasse.toUpperCase();
            this.definirTexto(classe);

            this.op = JOptionPane.showInputDialog(null, this.texto, "UaiCasórioPro ", JOptionPane.QUESTION_MESSAGE);
            this.lidarEscolha();

        } while (this.o != 5 && this.o != 0);
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
                Menu_READ menuVer = new Menu_READ();
                System.out.println("ver cadastros");
                menuVer.exibir(this.tipoClasseDAO, this.tipoClasse);
                break;
            }
            case 3 -> {
                if (this.user != null && this.user.getTipo() == 1) {
                    Menu_UPDATE menuUp = new Menu_UPDATE();
                    System.out.println("atualizar");
                    menuUp.exibir(this.tipoClasseDAO, this.tipoClasse);
                } else {
                    MenuInicial menu = new MenuInicial();
                    menu.exibir(this.logou, this.user);
                }

                break;
            }
            case 4 -> {
                if (this.user != null && this.user.getTipo() == 1) {
                    Menu_DEL menuDel = new Menu_DEL();
                    System.out.println("deletar");
                    menuDel.exibir(this.tipoClasseDAO, this.tipoClasse);
                } else {
                    MenuInicial menu = new MenuInicial();
                    menu.exibir(this.logou, this.user);
                }

                break;
            }
            case 5 -> {
                MenuInicial menu = new MenuInicial();
                menu.exibir(this.logou, this.user);
                break;
            }

            default -> {
                MenuInicial menu = new MenuInicial();
                menu.exibir(this.logou, this.user);
                break;
            }

        }

    }
}
