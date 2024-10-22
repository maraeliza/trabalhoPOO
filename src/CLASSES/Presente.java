/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;

import DAO.PresenteDAO;
import java.time.LocalDate;

/**
 *
 * @author Mara
 */
public class Presente implements ClasseInterface {

    private int id;
    private String nome;
    private String tipo;
    private Pessoa pessoa;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private boolean escolhido;
    public static int total;

    public static String[] getCampos() {
        String[] campos = new String[3];
        campos[0] = "ID: ";
        campos[1] = "NOME: ";
        campos[2] = "TIPO: ";

        return campos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPresentes() {
        return total;
    }

    public static void setTotal(int t) {
        total = t;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.dataModificacao = LocalDate.now();
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataModificacao = LocalDate.now();
    }

    public boolean getEscolhido() {
        return this.escolhido;

    }

    public void setEscolhido(boolean escolhido) {
        this.escolhido = escolhido;
        this.dataModificacao = LocalDate.now();
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return this.dataModificacao;
    }

    public void criar(Object vetor[]) {
        if (vetor[0] != null && vetor[1] != null) {
            String nome = (String) vetor[0];
            this.nome = nome;
            String tipo = (String) vetor[1];
            this.tipo = tipo;
            this.id = ++total;
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null;
            this.escolhido = false;
        }

    }

    public boolean criar(Usuario user, Object vetor[]) {
        System.out.println("CRIANDO UM NOVO PRESENTE!");

        boolean alterado = false;
        if (vetor[0] != null && vetor[0] instanceof String) {
            this.nome = (String) vetor[0]; // Nome
            if (vetor[2] != null && vetor[2] instanceof String) {
                this.tipo = (String) vetor[2]; // Tipo
                alterado = true;
            }

        }
        if (alterado) {
            // Atribui o ID único e define as datas de criação e modificação
            this.id = ++total;
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null; // Nenhuma modificação inicial
            this.escolhido = false;
        }
        return alterado;

    }

    public String ler() {
        String dados = "";
        dados = "\n\nID: " + this.id;
        if (this.nome.length() > 0) {
            dados += "\nNome: " + this.nome;
        }
        if (this.tipo.length() > 0) {
            dados += "\nTipo: " + this.tipo;
        }

        if (this.escolhido) {
            dados += "\nEscolhido: SIM";
            dados += "\nPessoa " + this.pessoa.getNome();
        } else {
            dados += "\nEscolhido: NÃO";
        }
        return dados;
    }

    public void update(Object vetor[]) {
        boolean alterou = false;

        if (vetor[1] != null) {
            String nome = (String) vetor[1];
            if (nome.length() > 0) {
                this.nome = nome;
                alterou = true;

            }
        }
        if (vetor[2] != null) {
            String tipo = (String) vetor[2];
            if (tipo.length() > 0) {
                this.tipo = tipo;
                alterou = true;

            }
        }

        if (vetor[3] != null) {
            Pessoa p = (Pessoa) vetor[3];
            if (p != null) {
                this.pessoa = p;
                alterou = true;

            }
        }
        if (vetor[4] != null) {
            boolean escolheu = (boolean) vetor[4];
            if (escolheu != this.escolhido) {
                this.escolhido = escolheu;
                alterou = true;

            }
        }

        if (alterou) {
            this.atualizarDataModificacao();
        }

    }

    public boolean escolher(Pessoa p) {

        if (p != null && this.escolhido == false) {
            this.pessoa = p;
            this.escolhido = true;
            return true;
        }
        return false;
    }

    public void atualizarDataModificacao() {

        this.dataModificacao = LocalDate.now();
    }

    public void deletar() {

        Presente.total--;

    }
}
