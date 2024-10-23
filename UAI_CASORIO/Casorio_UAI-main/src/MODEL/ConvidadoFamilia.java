/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import CONTROLLER.DAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Random;

/**
 *
 * @author CAUPT - ALUNOS
 */

    
public class ConvidadoFamilia implements ClasseInterface {
    
    private int id;
    private String nomeFamilia;
    private String acesso;  
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private DAO dao;
    
    public static int total;
    
    private String gerarAcesso(String primeiroNomeNoivo, String primeiroNomeNoiva, LocalDate dataCasamento) {
        String diaMesAno = String.format("%02d%02d%d", dataCasamento.getDayOfMonth(), dataCasamento.getMonthValue(), dataCasamento.getYear());
        String letrasAleatorias = gerarLetrasAleatorias(4);
        return primeiroNomeNoivo + primeiroNomeNoiva + diaMesAno + letrasAleatorias;
    }

   
    private String gerarLetrasAleatorias(int tamanho) {
        String letras = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(tamanho);
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            sb.append(letras.charAt(random.nextInt(letras.length())));
            
            
        }
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFamilia() {
        return nomeFamilia;
    }

    public void setNomeFamilia(String nomeFamilia) {
        this.nomeFamilia = nomeFamilia;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public int getTotalRecados() {
        return totalRecados;
    }

    public static void setTotalRecados(int t) {
        totalRecados = t;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataModificacao = LocalDate.now();
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

    
    @Override
    public boolean criar(Object[] vetor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean criar(Usuario user, Object[] vetor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void update(Object vetor[]) {
        boolean alterou = false;

        // Atualiza o nome da familia
        if (vetor[1] != null && vetor[1] instanceof String) {
            String nome = (String) vetor[1];
            if (!nome.isEmpty()) {
                this.nomeFamilia = nomeFamilia;
                alterou = true;
            }
        }

        // Atualiza o acesso
        if (vetor[2] != null && vetor[2] instanceof String) {
            String telefone = (String) vetor[2];
            if (!telefone.isEmpty()) {
                this.acesso = acesso;
                alterou = true;
            }
        }
        if(alterou){
            atualizarDataModificacao();
        }
        }
    
    public String ler() {
        StringBuilder resultado = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Adiciona informações da pessoa
        resultado.append("Familia ").append(this.id);
        resultado.append("\nNome Familia: ").append(this.nomeFamilia);


        // Verifica e adiciona o Acesso
        if (this.acesso != null && !this.acesso.isEmpty()) {
            resultado.append("\nAcesso da Familia: ").append(this.acesso);
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
        --ConvidadoFamilia.total;
    }

}
