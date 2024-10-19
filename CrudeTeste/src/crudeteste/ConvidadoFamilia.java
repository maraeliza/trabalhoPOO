/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudeteste;
import java.time.LocalDate;
import java.util.Random;
/**
 *
 * @author Jussie
 */
public class ConvidadoFamilia {

    private int id;
    private String nomeFamilia;
    private String acesso;  
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

  
    public void Criar(int id, String nomeFamilia, String primeiroNomeNoivo, String primeiroNomeNoiva, LocalDate dataCasamento, ConvidadoFamiliaDAO dao){
        this.id = id;
        this.nomeFamilia = nomeFamilia;
        this.acesso = gerarAcesso(primeiroNomeNoivo, primeiroNomeNoiva, dataCasamento);
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = null;
        dao.add(this);
    }

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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "ConvidadoFamilia id=" + id + "\n nomeFamilia=" + nomeFamilia + "\n acesso=" + acesso +
                "\n dataCriacao=" + dataCriacao + "\n dataModificacao=" + dataModificacao;
    }


}
