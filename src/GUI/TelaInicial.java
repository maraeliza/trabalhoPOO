/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class TelaInicial {

    public void exibir() {
        int o = -1;  // Valor inicial inválido para garantir que o loop execute pelo menos uma vez
        do {
            String texto = "\nCASAMENTO\n";
            texto += "\n João ❤ Maria ";
            texto += "\n1. LOGAR";
            texto += "\n2. ENTRAR SEM LOGIN";

            String result = JOptionPane.showInputDialog(null, texto, "1");
            int op = Util.stringToInt(result);
            if (op == 1) {
                MenuLogin menu = new MenuLogin();
                menu.exibir();

            } else if (op == 2) {
                MenuInicial menu = new MenuInicial();
                menu.exibir(false, null);
            } else {
                Util.mostrarErro("Digite uma opção válida!");
            }
        } while (o != 0 && o != 4 && o != -1); // O loop continuará até o usuário escolher "Sair" ou "0"

    }
}
