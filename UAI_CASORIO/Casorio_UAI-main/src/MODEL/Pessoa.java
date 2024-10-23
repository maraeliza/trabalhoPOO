/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Pessoa implements ClasseInterface {

    private int id;
    private String nome;
    private String telefone;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private LocalDate nascimento;
    private boolean userVinculado;

    public static int total;

    public boolean isUserVinculado() {
        return userVinculado;
    }

    public void setUserVinculado(boolean userVinculado) {
        this.userVinculado = userVinculado;
    }

    public static String[] getCampos() {
        String[] campos = new String[5];
        campos[0] = "ID: ";
        campos[1] = "NOME: ";
        campos[2] = "TELEFONE: ";
        campos[3] = "TIPO: ";
        campos[4] = "DATA DE NASCIMENTO: ";
        return campos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public static int getTotal() {
        return Pessoa.total;
    }

    public static void setTotal(int total) {
        Pessoa.total = total;
    }
    private String tipo;

    public void update(Object vetor[]) {
        boolean alterou = false;

        // Atualiza o nome
        if (vetor[1] != null && vetor[1] instanceof String) {
            String nome = (String) vetor[1];
            if (!nome.isEmpty()) {
                this.nome = nome;
                alterou = true;
            }
        }

        // Atualiza o telefone
        if (vetor[2] != null && vetor[2] instanceof String) {
            String telefone = (String) vetor[2];
            if (!telefone.isEmpty()) {
                this.telefone = telefone;
                alterou = true;
            }
        }

        // Atualiza a data de nascimento (recebe como String e converte para LocalDate)
        if (vetor[3] != null && vetor[3] instanceof String) {
            String nascimentoStr = (String) vetor[3];
            try {
                // Define o formato da data esperado (por exemplo, "dd/MM/yyyy")
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate nascimento = LocalDate.parse(nascimentoStr, formatter);
                this.nascimento = nascimento;
                alterou = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido: " + nascimentoStr);
            }
        }

        // Atualiza o tipo
        if (vetor[4] != null && vetor[4] instanceof String) {
            String tipo = (String) vetor[4];
            if (!tipo.isEmpty()) {
                this.tipo = tipo;
                alterou = true;
            }
        }

        // Se alguma alteração foi feita, atualiza a data de modificação
        if (alterou) {
            this.atualizarDataModificacao();
        }
    }

    public boolean criar(Usuario user, Object[] vetor) {
        boolean alterado = false;
        if (vetor[0] != null && vetor[0] instanceof String) {
            this.nome = (String) vetor[0]; // Nome
            if (vetor[2] != null && vetor[2] instanceof String) {
                this.tipo = (String) vetor[2]; // Tipo
                alterado = true;
            }
            if (vetor[1] != null && vetor[1] instanceof String) {
                this.telefone = (String) vetor[1]; // Telefone
            }

            if (vetor[3] != null && vetor[3] instanceof String) {
                String nasc = (String) vetor[3]; // Data de nascimento como string
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                try {
                    // Converte a string de data para LocalDate
                    LocalDate dataNascimento = LocalDate.parse(nasc, formato);
                    this.nascimento = dataNascimento;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido: " + e.getMessage());
                }
            }

        }
        if (alterado) {
            this.id = ++total;
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null;
            this.userVinculado = false;
        }
        return alterado;

    }

    public boolean criar(Object[] vetor) {
        boolean criado = false;
        if (vetor[0] != null && vetor[0] instanceof String) {
            this.nome = (String) vetor[0]; // Nome
            if (vetor[1] != null && vetor[1] instanceof String) {
                this.telefone = (String) vetor[1]; // Telefone
            }

            if (vetor[2] != null && vetor[2] instanceof String) {
                this.tipo = (String) vetor[2]; // Tipo
            }
            if (vetor[3] != null && vetor[3] instanceof String) {
                String nasc = (String) vetor[3]; // Data de nascimento como string
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                try {
                    // Converte a string de data para LocalDate
                    LocalDate dataNascimento = LocalDate.parse(nasc, formato);
                    this.nascimento = dataNascimento;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido: " + e.getMessage());
                }
            }
            criado = true;
        }
        if (criado) {
            // Atribui o ID único e define as datas de criação e modificação
            this.id = ++total;
            this.dataCriacao = LocalDate.now();
            this.dataModificacao = null; // Nenhuma modificação inicial

        }
        return criado;
    }

    public String ler() {
        StringBuilder resultado = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Adiciona informações da pessoa
        resultado.append("Pessoa ").append(this.id);
        resultado.append("\nNome: ").append(this.nome);

        // Verifica e formata a data de nascimento
        if (this.nascimento != null) {
            resultado.append("\nData de Nascimento: ").append(this.nascimento.format(formatter));
        }

        // Verifica e adiciona o telefone
        if (this.telefone != null && !this.telefone.isEmpty()) {
            resultado.append("\nTelefone: ").append(this.telefone);
        }

        // Verifica e formata a data de criação
        if (this.dataCriacao != null) {
            resultado.append("\nData de Criação: ").append(this.dataCriacao.format(formatter));
        }

        // Verifica e formata a data de modificação
        if (this.dataModificacao != null) {
            resultado.append("\nData da Última Modificação: ").append(this.dataModificacao.format(formatter));
        }

        resultado.append("\n\n");
        return resultado.toString();
    }

    public void deletar() {
        --Pessoa.total;
    }

    public String getNome() {
        return this.nome;

    }

    public String getTipo() {
        return this.tipo;

    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return this.dataModificacao;
    }

    public void atualizarDataModificacao() {

        this.dataModificacao = LocalDate.now();
    }
}
