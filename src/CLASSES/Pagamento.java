/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASSES;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Pagamento {
    public int id;
    Pessoa pessoa;
    Fornecedor fornecedor;
    String descricao;
    String valor;
    String parcela;
    LocalDate data;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
   
     public static int total;
    
    public void criar(int id, Pessoa pessoa,Fornecedor fornecedor, String descricao, String valor, String parcela){
        this.id = ++total;
        this.pessoa = pessoa;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.parcela = parcela;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        
    }
    public String ler(){
        String dados = "\nMural de Recados "+this.id;
        dados+= "\nNome: "+this.pessoa.getNome();
        dados+= "\nDescricao: "+this.descricao;
        
        return dados;
    }
    private void atualizar(){
        
        this.dataModificacao = LocalDate.now();
    }
    
    private void deletar(){
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Pagamento.total = total;
    }

    
}
