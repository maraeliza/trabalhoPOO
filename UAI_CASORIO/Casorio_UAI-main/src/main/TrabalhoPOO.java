package main;

import CONTROLLER.DAO;
import VIEW.TelaInicial;

public class TrabalhoPOO {

    public static void main(String[] args) {
        DAO dao = new DAO();
        TelaInicial menu = new TelaInicial();
        menu.exibir(dao);
       
    }

}
