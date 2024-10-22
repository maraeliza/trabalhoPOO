package main;

import DAO.DAO;
import GUI.TelaInicial;

public class TrabalhoPOO {

    public static void main(String[] args) {
        DAO dao = new DAO();
        TelaInicial menu = new TelaInicial();
        menu.exibir(dao);
       
    }

}
