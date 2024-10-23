/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

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

    public boolean criar(Object vetor[]) {
        boolean alterado = false;
        System.out.println("CRIANDO UM NOVO PRESENTE!");
        System.out.println(vetor[0] + " " + vetor[1] + " " + vetor[2]);
        
        if (vetor[0] != null && vetor[0] instanceof String) {
            this.nome = (String) vetor[0]; // Nome
            if (vetor[1] != null && vetor[1] instanceof String) {
                this.tipo = (String) vetor[1]; // Tipo
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

    public boolean criar(Usuario user, Object vetor[]) {
        System.out.println("CRIANDO UM NOVO PRESENTE!");
        System.out.println(vetor[0] + " " + vetor[1] + " " + vetor[2]);
        boolean alterado = false;
        if (vetor[0] != null && vetor[0] instanceof String) {
            this.nome = (String) vetor[0]; // Nome
            if (vetor[1] != null && vetor[1] instanceof String) {
                this.tipo = (String) vetor[1]; // Tipo
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
        StringBuilder resultado = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Adiciona o ID
        resultado.append("\n\nID: ").append(this.id);

        // Verifica e adiciona o nome
        if (this.nome != null && this.nome.length() > 0) {
            resultado.append("\nNome: ").append(this.nome);
        }

        // Verifica e adiciona o tipo
        if (this.tipo != null && this.tipo.length() > 0) {
            resultado.append("\nTipo: ").append(this.tipo);
        }

        // Verifica se foi escolhido e adiciona informações da pessoa
        if (this.escolhido) {
            resultado.append("\nEscolhido: SIM");
            if (this.pessoa != null && this.pessoa.getNome() != null && this.pessoa.getNome().length() > 0) {
                resultado.append("\nPessoa: ").append(this.pessoa.getNome());
            }
        } else {
            resultado.append("\nEscolhido: NÃO");
        }

        // Verifica e formata a data de criação
        if (this.dataCriacao != null) {
            resultado.append("\nData de Criação: ").append(this.dataCriacao.format(formatter));
        }

        // Verifica e formata a data de modificação
        if (this.dataModificacao != null) {
            resultado.append("\nData da Última Modificação: ").append(this.dataModificacao.format(formatter));
        }

        return resultado.toString();
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
