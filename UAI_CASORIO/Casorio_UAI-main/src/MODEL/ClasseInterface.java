/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MODEL;

import java.time.LocalDate;

/**
 *
 * @author Mara
 */
public interface ClasseInterface {

    int getId();

    void setId(int id);

    String ler();

    void deletar();

    boolean criar(Object vetor[]);

    boolean criar(Usuario user, Object vetor[]);

    void update(Object vetor[]);

    LocalDate getDataCriacao();

    LocalDate getDataModificacao();

    void atualizarDataModificacao();

}
