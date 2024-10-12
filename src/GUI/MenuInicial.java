/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.*;

import javax.swing.JOptionPane;
import javax.swing.*;
import CLASSES.Usuario;

/**
 *
 * @author Mara
 */
public class MenuInicial {

    private String texto;
    private String op;
    private static boolean logou;
    private String opcoes[];
    private Usuario userLogado;
    private String listaClasses[] = new String[20];

    public MenuInicial() {
        MenuInicial.logou = false;
        setLista();

    }

    private void setLista() {
        String listaClasses[] = new String[20];
        listaClasses[0] = "RECADOS";
        listaClasses[1] = "PRESENTES";
        listaClasses[2] = "PESSOA";
        listaClasses[3] = "USUÁRIOS";
        listaClasses[4] = "FORNECEDOR";
        listaClasses[5] = "EVENTO";

        listaClasses[6] = "CERIMONIAL";
        listaClasses[7] = "IGREJA";
        listaClasses[8] = "CARTÓRIO";
        listaClasses[9] = "CONVIDADO INDIVIDUAL";
        listaClasses[10] = "CONVIDADO FAMÍLIA";
        listaClasses[11] = "PAGAMENTO";
        listaClasses[12] = "RELATÓRIOS";

        this.listaClasses = listaClasses;
    }

    private String[] getLista() {
        return this.listaClasses;
    }

    private void definirTexto(String noivo, String noiva) {
        if (this.userLogado != null) {
            this.texto = "\n                  BEM VINDO " + this.userLogado.getNome().toUpperCase() + "           ";

        } else {
            this.texto = "\n                    BEM VINDO            ";

        }

        this.texto += "\n\nNOIVOS";
        this.texto += "\n" + noivo + " ❤ " + noiva + "  \n";
        this.texto += "\n\nEscolha a opção a seguir ";

        this.texto += this.definirOpcoes();

        this.texto += "\n\nDigite aqui o número da sua opção: ";

    }

    private String definirOpcoes() {
        String Opcoes = "";
        int nOps = 1;
        System.out.println("definindo opcoes");
        if (this.userLogado != null && this.userLogado.getTipo() == 1) {
            System.out.println("Usuario adm");
            for (int n = 0; n < this.listaClasses.length; n++) {
                if (this.listaClasses[n] != null) {
                    Opcoes += "\n" + Util.intToString(nOps) + ". " + this.listaClasses[n];
                    nOps++;
                }

            }

        } else {
            System.out.println("Usuario NÃO adm");
            for (int n = 0; n < 2; n++) {
                if (this.listaClasses[n] != null) {
                    Opcoes += "\n" + Util.intToString(nOps) + ". " + this.listaClasses[n];
                    nOps++;
                }
            }
        }
        Opcoes += "\n" + Util.intToString(nOps) + ". SAIR";
        return Opcoes;
    }

    public void exibir(boolean logou, Usuario userLogou) {
        this.userLogado = userLogou;
        int o = -1;
        do {
            this.definirTexto("João", "Maria");

            this.op = JOptionPane.showInputDialog(null, this.texto, "UaiCasórioPro", JOptionPane.QUESTION_MESSAGE);
            System.out.println(this.op);

            if (this.op != null) {
                o = Util.stringToInt(this.op);
            } else {

                o = 4;
            }

            this.lidarEscolha(o);
        } while (o != 0 && o != 3);

    }

    private void lidarEscolha(int o) {
        if (this.userLogado != null) {
            if (this.userLogado.getTipo() == 1) {
                switch (o) {

                    case 1 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(RecadoDAO.class, MenuInicial.logou, this.userLogado);
                        break;
                    }
                    case 2 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(PresenteDAO.class, MenuInicial.logou, this.userLogado);
                        break;
                    }
                    case 3 -> {
                        TelaInicial menu = new TelaInicial();
                        menu.exibir();
                    }
                    case 4 -> {
                        TelaInicial menu = new TelaInicial();
                        menu.exibir();
                        break;
                    }
                    default -> {
                        TelaInicial menu = new TelaInicial();
                        menu.exibir();
                        break;
                    }
                }
            } else {
                //MENU DO USUARIO CONVIDADO LOGADO
                switch (o) {

                    case 1 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(RecadoDAO.class, MenuInicial.logou, this.userLogado);
                        break;
                    }
                    case 2 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(PresenteDAO.class, MenuInicial.logou, this.userLogado);
                        break;
                    }
                    case 3 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(PessoaDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 4 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(UserDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 5 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(FornDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 6 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(EventoDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 7 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(CerimonialDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 8 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(IgrejaDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 9 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(CartorioDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 10 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(ConvDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 11 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(ConvFamDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 12 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(PagDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 13 -> {
                        Menu_CRUD menu = new Menu_CRUD();
                        menu.exibir(RelatorioDAO.class, MenuInicial.logou, this.userLogado);

                        break;
                    }
                    case 14 -> {
                        TelaInicial menu = new TelaInicial();
                        menu.exibir();
                        break;
                    }

                    default -> {
                        TelaInicial menu = new TelaInicial();
                        menu.exibir();
                        break;
                    }
                }
            }
        } else {
            //MENU DA PESSOA NÃO LOGADA
            switch (o) {

                case 1 -> {
                    Menu_CRUD menu = new Menu_CRUD();
                    menu.exibir(RecadoDAO.class, MenuInicial.logou, null);
                    break;
                }
                case 2 -> {
                    Menu_CRUD menu = new Menu_CRUD();
                    menu.exibir(PresenteDAO.class, MenuInicial.logou,null);
                    break;
                }
                case 3 -> {
                    TelaInicial menu = new TelaInicial();
                    menu.exibir();
                    break;
                }
                case 4 -> {
                    TelaInicial menu = new TelaInicial();
                    menu.exibir();
                    break;
                }
                default -> {
                    TelaInicial menu = new TelaInicial();
                    menu.exibir();
                    break;
                }
            }

        }

    }

}
