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
public class MenuInicial {

    private String texto;
    private String op;
    private static boolean logou;
    private String opcoes[];
    private Usuario userLogado;
    private String listaNomeClasses[] = new String[20];
    private Class<?>[] listaClassesDAO;
    private int nOps;
    private DAO dao;

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

        this.listaNomeClasses = listaClasses;
        

    }

    private String[] getLista() {
        return this.listaNomeClasses;
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
        this.nOps = 1;
        System.out.println("definindo opcoes");
        if (this.userLogado != null && this.userLogado.getTipo() == 1) {
            System.out.println("Usuario adm");
            for (int n = 0; n < this.listaNomeClasses.length; n++) {
                if (this.listaNomeClasses[n] != null) {
                    Opcoes += "\n" + Util.intToString(this.nOps) + ". " + this.listaNomeClasses[n];
                    this.nOps++;
                }

            }

        } else {
            System.out.println("Usuario NÃO adm");
            for (int n = 0; n < 2; n++) {
                if (this.listaNomeClasses[n] != null) {
                    Opcoes += "\n" + Util.intToString(this.nOps) + ". " + this.listaNomeClasses[n];
                    this.nOps++;
                }
            }
        }
        Opcoes += "\n" + Util.intToString(this.nOps) + ". SAIR";
        return Opcoes;
    }

    public void exibir(DAO dao, boolean logou, Usuario userLogou) {
        this.dao = dao;
        this.userLogado = userLogou;
        int o = -1;
        do {
            this.definirTexto("João", "Maria");

            this.op = JOptionPane.showInputDialog(null, this.texto, "UaiCasórioPro", JOptionPane.QUESTION_MESSAGE);
            System.out.println(this.op);

            if (this.op != null) {
                o = Util.stringToInt(this.op);
                this.lidarEscolha(o);
            } else {
                TelaInicial menu = new TelaInicial();
                op = menu.exibir(this.dao);
            }
        } while (o != 0 && this.op != null);

    }

    private void lidarEscolha(int o) {
        if(o == 13){
             MenuRelatorio menu = new MenuRelatorio();
             menu.exibir(this.dao, this.userLogado,MenuInicial.logou);
        }
        if (o >= this.nOps) {
            TelaInicial menu = new TelaInicial();
            op = menu.exibir(this.dao);
        } else {
            if (this.userLogado != null) {
                if (this.userLogado.getTipo() == 1) {
                    //MENU DO USUARIO ADM
                    criarMenuCRUD(this.dao, o-1);
                } else {
                    //MENU DO USUARIO CONVIDADO LOGADO
                    criarMenuCRUD(this.dao, o-1);
                }
            } else {
                //MENU DA PESSOA NÃO LOGADA
                criarMenuCRUD(this.dao, o-1);
            }
        }

    }

    public void criarMenuCRUD(DAO dao, int idClasse) {
        Menu_CRUD menu = new Menu_CRUD();
        menu.exibir(this.dao, idClasse, MenuInicial.logou, this.userLogado);
    }
}
