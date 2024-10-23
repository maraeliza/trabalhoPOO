/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;

import CONTROLLER.DAO;
import javax.swing.JOptionPane;

import MODEL.Usuario;
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
    private DAO dao;
    private int idClasse;
    

    private void definirTexto(String classNome) {
        this.texto = "\n\nMENU DE " + classNome ;
        this.texto += "\n\nEscolha a opção a seguir ";
        this.texto += "\n1. Adicionar novo";
        this.texto += "\n2. Ver todos";

        if (this.user != null && this.user.getTipo() == 1) {
            this.texto += "\n3. Atualizar";
            this.texto += "\n4. Deletar";
            this.texto += "\n5. Voltar";
        } else {
            this.texto += "\n3. Voltar";
        }

        this.texto += "\n\nDigite aqui o número da sua opção: ";

    }

    public void exibir( DAO dao, int idClasse, boolean logou, Usuario user) {
        this.dao = dao;
        System.out.println("Atualizando id da classe para "+idClasse);
        this.idClasse = idClasse;
        this.logou = logou;
        this.user = user;

        if (this.user != null) {
            this.tipoUsuario = user.getTipo();
        } else {
            this.tipoUsuario = 0;
        }

        do {

            this.tipoClasse = this.dao.getNameClasseById(idClasse);
            this.definirTexto(this.tipoClasse);

            this.op = JOptionPane.showInputDialog(null, this.texto, "UaiCasórioPro ", JOptionPane.QUESTION_MESSAGE);
            this.lidarEscolha();

        } while (this.o != 5 && this.o != 0);
    }

    private void lidarEscolha() {
        if (this.op == null) {
            MenuInicial menu = new MenuInicial();
            menu.exibir(this.dao, this.logou, this.user);
        } else {
            this.o = Util.stringToInt(this.op);
            switch (o) {

                case 1 -> {
                    Menu_CREATE menuAdd = new Menu_CREATE();
                    menuAdd.exibir(this.dao, this.idClasse, this.user);
                    break;
                }
                case 2 -> {
                    Menu_READ menuVer = new Menu_READ();
                    menuVer.exibir(this.dao,this.idClasse);
                    break;
                }
                case 3 -> {
                    if (this.user != null && this.user.getTipo() == 1) {
                        Menu_UPDATE menuUp = new Menu_UPDATE();
                        menuUp.exibir(this.dao,this.idClasse);
                    } else {
                        MenuInicial menu = new MenuInicial();
                        menu.exibir(this.dao, this.logou, this.user);
                    }

                    break;
                }
                case 4 -> {
                    if (this.user != null && this.user.getTipo() == 1) {
                        Menu_DEL menuDel = new Menu_DEL();
                        menuDel.exibir(this.dao, this.idClasse);
                    } else {
                        MenuInicial menu = new MenuInicial();
                        menu.exibir(this.dao, this.logou, this.user);
                    }

                    break;
                }
                case 5 -> {
                    MenuInicial menu = new MenuInicial();
                    menu.exibir(this.dao, this.logou, this.user);
                    break;
                }

                default -> {
                    MenuInicial menu = new MenuInicial();
                    menu.exibir(this.dao, this.logou, this.user);
                    break;
                }

            }
        }

    }
}
