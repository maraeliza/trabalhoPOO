/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import CONTROLLER.DAO;
import VIEW.Util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Usuario implements ClasseInterface {

    private int id;
    private int idPessoa;
    private Pessoa pessoa;
    private int tipo;
    private String login;
    private String senha;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private DAO dao;

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Usuario.total = total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public static int total;

    public void update(Object vetor[]) {

    }

    public void update(Usuario user, Object vetor[]) {

    }

    public void update(DAO dao, Usuario user, Object vetor[]) {
        boolean alterou = false;
        int idPessoa = Util.stringToInt((String) vetor[0]);
        if (idPessoa != 0) {
            Pessoa pessoa = (Pessoa) dao.getItemByID(2, idPessoa);
            if (pessoa != null && idPessoa == pessoa.getId()) {
                this.pessoa = pessoa;
                this.idPessoa = idPessoa;
                alterou = true;

            }
        }
        if (vetor[1] != null) {
            int tipo = (int) vetor[1];
            if (tipo != 0) {
                this.tipo = tipo;
                alterou = true;

            }
        }
        if (vetor[2] != null) {
            String login = (String) vetor[2];
            if (login.length() > 0) {
                this.login = login;
                alterou = true;

            }
        }
        if (vetor[3] != null) {
            String senha = (String) vetor[3];
            if (senha.length() > 0) {
                this.senha = senha;
                alterou = true;

            }
        }
        if (alterou) {
            this.atualizarDataModificacao();
        }

    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public boolean criar(Object vetor[]) {
        System.out.println("CRIANDO O USUARIO de ID " + vetor[0]);
        boolean criou = false;

        int idPessoa = (int) vetor[0];
        System.out.println("id convertido para inteiro com sucesso");
        //Pessoa pessoa, String login, String senha, int tipo
        if (vetor[0] != null && vetor[1] != null && vetor[2] != null && vetor[3] != null && vetor[4] != null) {
            System.out.println("Nenhum campo nulo!");
            if (idPessoa != 0) {
                System.out.println("ID DIFERENTE DE ZERO!");
                System.out.println("Procurando pessoa de id " + vetor[0]);
                Pessoa pessoa = (Pessoa) vetor[4];
                if (pessoa != null) {
                    if (!pessoa.isUserVinculado()) {
                        if (pessoa != null
                                && idPessoa == pessoa.getId()
                                && !pessoa.isUserVinculado()) {
                            System.out.println("Pessoa encontrada " + pessoa.getNome());

                            String login = (String) vetor[1];
                            String senha = (String) vetor[2];
                            int tipo = (int) vetor[3];

                            if (login.length() > 0 && senha.length() > 0 && this.checarTipo(tipo)) {
                                pessoa.setUserVinculado(true);
                                this.pessoa = pessoa;
                                this.idPessoa = idPessoa;
                                this.id = ++total;
                                this.login = login;
                                this.senha = senha;
                                this.tipo = tipo;
                                this.dataCriacao = LocalDate.now();
                                this.dataModificacao = null;
                                criou = true;

                            }
                        } 
                    } 

                } else {
                    System.out.println("Não foi possivel criar o objeto");
                    Util.mostrarErro("Pessoa de id " + vetor[0] + " não encontrada");
                }

            }

        }
        return criou;
    }

    public boolean criar(Usuario user, Object vetor[]) {
        boolean criou = false;
        int idPessoa = Util.stringToInt((String) vetor[0]);
        System.out.println("id convertido para inteiro com sucesso");
        //Pessoa pessoa, String login, String senha, int tipo
        if (vetor[0] != null && vetor[1] != null && vetor[2] != null && vetor[3] != null && vetor[4] != null) {
            System.out.println("Nenhum campo nulo!");
            if (idPessoa != 0) {
                System.out.println("ID DIFERENTE DE ZERO!");
                System.out.println("Procurando pessoa de id " + vetor[0]);
                Pessoa pessoa = (Pessoa) vetor[4];
                if (pessoa != null
                        && idPessoa == pessoa.getId()
                        && !pessoa.isUserVinculado()) {
                    System.out.println("Pessoa encontrada " + pessoa.getNome());

                    String login = (String) vetor[1];
                    String senha = (String) vetor[2];
                    int tipo = Util.stringToInt((String) vetor[3]);

                    if (login.length() > 0 && senha.length() > 0 && this.checarTipo(tipo)) {
                        pessoa.setUserVinculado(true);
                        this.pessoa = pessoa;
                        this.idPessoa = idPessoa;
                        this.id = ++total;
                        this.pessoa = pessoa;
                        this.login = login;
                        this.senha = senha;
                        this.tipo = tipo;
                        this.dataCriacao = LocalDate.now();
                        this.dataModificacao = null;
                        criou = true;
                    }
                }
            }

        }
        return criou;
    }

    public boolean checarTipo(int tipo) {
        return (tipo >= 0 && tipo <= 2);
    }

    public String ler() {
        StringBuilder resultado = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Adiciona informações do usuário
        resultado.append("\n\nUsuário ").append(this.id);
        resultado.append("\n Nome: ").append(this.getNome());
        resultado.append("\n Login: ").append(this.login);
        resultado.append("\n Senha: ").append(this.senha); // Considere ocultar a senha em produção

        // Verifica e formata a data de criação
        if (this.dataCriacao != null) {
            resultado.append("\n Data de Criação: ").append(this.dataCriacao.format(formatter));
        }

        // Verifica e formata a data de modificação
        if (this.dataModificacao != null) {
            resultado.append("\n Data da Última Modificação: ").append(this.dataModificacao.format(formatter));
        }

        return resultado.toString();
    }

    public static String[] getCampos() {

        String[] campos = new String[5];
        campos[0] = "ID: ";
        campos[1] = "ID DA PESSOA: ";
        campos[2] = "Login: ";
        campos[3] = "Senha: ";
        campos[4] = "Tipo: ";
        return campos;
    }

    public void atualizar() {
        this.dataModificacao = LocalDate.now();
    }

    public void deletar() {
        Usuario.total--;
        this.pessoa.setUserVinculado(false);
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getNome() {
        return this.pessoa.getNome();
    }

    public int getId() {
        return this.id;
    }

    public int getTipo() {
        return this.tipo;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void atualizarDataModificacao() {

        this.dataModificacao = LocalDate.now();
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public static int getTotalUsuario() {
        return total;
    }

    public static void setTotalUsuario(int totalUsuario) {
        Usuario.total = totalUsuario;
    }

}
