/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Mara
 */
import java.time.LocalDate;

public class Evento {

    // Atributos da classe
    public int id;
    private Cerimonial cerimonial;
    private Igreja igreja;
    private Cartorio cartorio;
    private Pessoa noiva;
    private Pessoa noivo;
    private LocalDate data;
    
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public static int totalEventos;

    // Getters e Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotalEventos() {
        return totalEventos;
    }

    public static void setTotalEventos(int total) {
        totalEventos = total;
    }

    public Cerimonial getCerimonial() {
        return this.cerimonial;
    }

    public void setCerimonial(Cerimonial cerimonial) {
        this.cerimonial = cerimonial;
        this.dataModificacao = LocalDate.now();
    }

    public Igreja getIgreja() {
        return this.igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
        this.dataModificacao = LocalDate.now();
    }

    public Cartorio getCartorio() {
        return this.cartorio;
    }

    public void setCartorio(Cartorio cartorio) {
        this.cartorio = cartorio;
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa getNoiva() {
        return this.noiva;
    }

    public void setNoiva(Pessoa noiva) {
        this.noiva = noiva;
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa getNoivo() {
        return this.noivo;
    }

    public void setNoivo(Pessoa noivo) {
        this.noivo = noivo;
        this.dataModificacao = LocalDate.now();
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
        this.dataModificacao = LocalDate.now();
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return this.dataModificacao;
    }

    // Método para criar um novo evento
    public void criar(Cerimonial cerimonial, Igreja igreja, Cartorio cartorio, Pessoa noiva, Pessoa noivo, LocalDate data) {
        this.id = ++totalEventos;
        this.cerimonial = cerimonial;
        this.igreja = igreja;
        this.cartorio = cartorio;
        this.noiva = noiva;
        this.noivo = noivo;
        this.data = data;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
    }

    // Método para atualizar o evento
    public void update(Cerimonial cerimonial, Igreja igreja, Cartorio cartorio, Pessoa noiva, Pessoa noivo, LocalDate data) {
        boolean alterou = false;

        if (cerimonial != null) {
            this.cerimonial = cerimonial;
            alterou = true;
        }

        if (igreja != null) {
            this.igreja = igreja;
            alterou = true;
        }

        if (cartorio != null) {
            this.cartorio = cartorio;
            alterou = true;
        }

        if (noiva != null) {
            this.noiva = noiva;
            alterou = true;
        }

        if (noivo != null) {
            this.noivo = noivo;
            alterou = true;
        }

        if (data != null) {
            this.data = data;
            alterou = true;
        }

        if (alterou) {
            this.atualizarDataModificacao();
        }
    }

    // Método para atualizar a data de modificação
    private void atualizarDataModificacao() {
        this.dataModificacao = LocalDate.now();
    }

    // Método para deletar um evento
    private void deletar() {
        --totalEventos;
    }

    // Método para ler os dados do evento
    public String ler() {
        String dados = "\n\nID: " + this.id;
        dados += "\n Cerimonial: " + (this.cerimonial != null ? this.cerimonial.getNome() : "N/A");
        dados += "\n Igreja: " + (this.igreja != null ? this.igreja.getNome() : "N/A");
        dados += "\n Cartório: " + (this.cartorio != null ? this.cartorio.getNome() : "N/A");
        dados += "\n Noiva: " + (this.noiva != null ? this.noiva.getNome() : "N/A");
        dados += "\n Noivo: " + (this.noivo != null ? this.noivo.getNome() : "N/A");
        dados += "\n Data do Evento: " + (this.data != null ? this.data.toString() : "N/A");
        dados += "\n Data de criação: " + this.dataCriacao;
        dados += "\n Data de modificação: " + (this.dataModificacao != null ? this.dataModificacao.toString() : "N/A");
        
        return dados;
    }
}
