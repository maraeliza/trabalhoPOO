/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CLASSES.Pessoa;
import GUI.Util;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author IFTM
 */
public class PessoaDAO {

    private int id;
    private static Pessoa[] vetor;
    private static int nItens;

    public PessoaDAO() {

        this.setVetor();
        Object[] pessoa1Dados = {"ADMINISTRADOR", "7777 5555", "adm", "01/01/2001"};
        Pessoa pessoa1 = new Pessoa();
        pessoa1.criar(pessoa1Dados);
        this.add(pessoa1);
        UsuarioDAO.add(pessoa1, "admin", "1234", 1);

        Object[] pessoa2Dados = {"João", "3432 2556", "NOIVO", "01/01/2001"};
        Pessoa pessoa2 = new Pessoa();
        pessoa2.criar(pessoa2Dados);
        this.add(pessoa2);
        UsuarioDAO.add(pessoa2, "jo2024", "1234", 1);

        Object[] pessoa3Dados = {"Maria", "3431 1335", "NOIVO", "01/01/2001"};
        Pessoa pessoa3 = new Pessoa();
        pessoa3.criar(pessoa3Dados);
        UsuarioDAO.add(pessoa3, "ma2024", "1234", 1);
        this.add(pessoa3);

        Object[] pessoa4Dados = {"Ana", "3431 1335", "convidado", "01/01/2001"};
        Pessoa pessoa4 = new Pessoa();
        pessoa4.criar(pessoa4Dados);
        this.add(pessoa4);
        UsuarioDAO.add(pessoa3, "an2024", "1234", 2);

    }

    public static String getTexto() {
        String texto = "PESSOAS JÁ CADASTRADAS\n";

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("PERCORRENDO VETOR");
            if (vetor[i] != null) {
                System.out.println("ITEM NÃO NULO");
                int id = vetor[i].getId();

                texto += vetor[i].ler();

            }
        }
        if (texto.equals("PRESENTES JÁ CADASTRADOS")) {
            texto += "\n\nNENHUM ITEM ENCONTRADO!\n";
        }
        System.out.println("No método getTexto: " + texto);
        return texto;
    }

    public static boolean addVetor(Pessoa p) {
        System.out.println("ADICIONANDO NO VETOR");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Percorrendo vetor");
            if (PessoaDAO.vetor[i] == null) {
                System.out.println("ITEM NULO ");
                PessoaDAO.vetor[i] = p;
                PessoaDAO.nItens++;
                System.out.println("PESSOA ADICIONADA ");
                return true;
            }
        }
        return false;
    }

    public void setNItens(int n) {
        PessoaDAO.nItens = n;
    }

    public static int getItens() {
        return PessoaDAO.nItens;
    }

    public boolean setVetor() {
        if (this.nItens == 0) {
            PessoaDAO.vetor = new Pessoa[100];
            return true;
        } else {
            return false;
        }
    }

    public Pessoa[] getVetor() {
        return PessoaDAO.vetor;
    }

    public boolean add(Pessoa p) {
        for (int i = 0; i < PessoaDAO.vetor.length; i++) {
            if (PessoaDAO.vetor[i] == null) {
                PessoaDAO.vetor[i] = p;
                this.nItens++;
                return true;
            }
        }
        return false;
    }

    public static void cadastrar(String infos[]) {
        System.out.println("ADICIONANDO PESSOA");
        Pessoa pessoa = new Pessoa();
        pessoa.criar(infos);

        if (PessoaDAO.addVetor(pessoa) == true) {
            System.out.println("PESSOA ADICIONADO COM SUCESSO!");
        } else {
            System.out.println("NÃO FOI POSSíVEL ADICIONAR PESSOA!");
        }
    }

    public static void atualizar(Object[] vetor) {
        if (vetor == null || vetor.length < 5) {
            Util.mostrarErro("Vetor de parâmetros inválido!");
            return;
        }
        String idS = (String) vetor[0];
        int id = Util.stringToInt(idS);

        System.out.println("ENCONTRANDO PESSOA....");

        // Extraindo os outros elementos do vetor
        String nome = (String) vetor[1];
        String telefone = (String) vetor[2];
        String tipo = (String) vetor[3];
        String nasc = (String) vetor[4];

        if ((nome != null && nome.length() > 1)
                || (telefone != null && telefone.length() > 1)
                || (tipo != null && tipo.length() > 1)
                || (nasc != null && nasc.length() > 1)) {

            Pessoa pessoa = PessoaDAO.getItemByID(id);
            if (pessoa != null) {
                System.out.println("PESSOA ENCONTRADA!");

                // Atualiza os campos se os valores não forem nulos e não vazios
                if (nome != null && nome.length() > 1) {
                    pessoa.setNome(nome);
                }
                if (telefone != null && telefone.length() > 1) {
                    pessoa.setTelefone(telefone);
                }
                if (tipo != null && tipo.length() > 1) {
                    pessoa.setTipo(tipo);
                }
                if (nasc != null && nasc.length() > 1) {
                    try {
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataNascimento = LocalDate.parse(nasc, formato);
                        pessoa.setNascimento(dataNascimento);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido: " + e.getMessage());
                        Util.mostrarErro("FORMATO DE DATA INVÁLIDO!");
                        return; // Saímos do método para evitar salvar a pessoa com dados incorretos
                    }
                }

                // Atualiza a data de modificação da pessoa
                pessoa.setDataModificacao(LocalDate.now());

                // Sucesso
                System.out.println("PESSOA ATUALIZADA COM SUCESSO!");
                Util.mostrarMSG("PESSOA ATUALIZADA COM SUCESSO!");
            } else {
                Util.mostrarErro("PESSOA NÃO ENCONTRADA");
            }
        } else {
            Util.mostrarErro("PREENCHA OS CAMPOS!");
        }
    }

    public boolean remove(Pessoa p) {
        for (int i = 0; i < PessoaDAO.vetor.length; i++) {
            if (PessoaDAO.vetor[i] == p) {
                PessoaDAO.vetor[i] = null;
                this.nItens--;
                return true;
            }
        }
        return false;
    }

    public static boolean find(Pessoa p) {
        for (int i = 0; i < PessoaDAO.vetor.length; i++) {
            if (PessoaDAO.vetor[i] == p) {
                return true;
            }
        }
        return false;
    }

    public static Pessoa getItemByID(int id) {
        for (int i = 0; i < PessoaDAO.vetor.length; i++) {
            if (PessoaDAO.vetor[i] != null && PessoaDAO.vetor[i].getId() == id) {
                return PessoaDAO.vetor[i];
            }
        }
        return null;
    }

    public static boolean delItemByID(int id) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null && vetor[i].getId() == id) {
                vetor[i] = null;
                return true;
            }
        }
        return false;
    }

    public Pessoa[] getNoivos() {
        Pessoa noivos[] = new Pessoa[2];
        int n = 0;
        for (int i = 0; i < PessoaDAO.vetor.length; i++) {
            if (PessoaDAO.vetor[i] != null && PessoaDAO.vetor[i].getTipo().equals("NOIVO")) {
                noivos[n] = PessoaDAO.vetor[i];
                n++;
            }
        }
        return noivos;
    }

    public static String getTextoNoivos() {
        String texto = "\n                    ";
        int n = 0;
        for (int i = 0; i < PessoaDAO.vetor.length; i++) {
            if (n < 2 && PessoaDAO.vetor[i] != null && PessoaDAO.vetor[i].getTipo().equals("NOIVO")) {
                texto += PessoaDAO.vetor[i].getNome();
                if (n == 0) {
                    texto += " ❤ ";
                }
                n++;
            }
        }
        return texto;
    }

    public void montarPainel() {

    }
  public static boolean find(int id) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null && vetor[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
}
