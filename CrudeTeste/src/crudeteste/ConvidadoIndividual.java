/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudeteste;

import java.time.LocalDate;
import crudeteste.ConvidadoIndividualDAO;

/**
 *
 * @author Jussie
 */
public class ConvidadoIndividual {
    
    private int id;
    private Pessoa pessoa;
    private ConvidadoFamilia familia;
    private String parentesco;
    private boolean confirmacao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public void criar(int id, Pessoa pessoa, ConvidadoFamilia familia, String parentesco,Boolean confirmacao, ConvidadoIndividualDAO dao){
        this.id = id;
        this.pessoa = pessoa;
        this.familia = familia;
        this.parentesco = parentesco;
        this.confirmacao = confirmacao; 
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
        dao.add(this);
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

    public ConvidadoFamilia getFamilia() {
        return familia;
    }

    public void setFamilia(ConvidadoFamilia familia) {
        this.familia = familia;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Boolean getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(Boolean confirmacao) {
        this.confirmacao = confirmacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    public String ler(){
        String dados = "\nConvidado Individual "+this.id;
        dados+= "\nNome: "+this.pessoa.getNome();
        dados+= "\nParentesco: "+this.parentesco;
        dados+= "\nConfirmado: "+this.confirmacao;
        return dados;
    }
     
    @Override
    public String toString() {
        return "ConvidadoIndividual id = " + id + "\n Pessoa = " + pessoa + "\n Familia = " + familia + 
               "\n Parentesco = " + parentesco + "\n Confirmacao=" + confirmacao + 
               "\n DataCriacao=" + dataCriacao + "\nDataModificacao = " + dataModificacao;
    }
}
