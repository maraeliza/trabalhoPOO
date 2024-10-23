/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CONTROLLER;

import MODEL.Evento;
import MODEL.Recado;
import MODEL.Relatorio;
import MODEL.ConvidadoFamilia;
import MODEL.Usuario;
import MODEL.Pessoa;
import MODEL.Pagamento;
import MODEL.Presente;
import MODEL.ConvidadoIndividual;
import MODEL.Fornecedor;
import MODEL.ClasseInterface;
import MODEL.Igreja;
import MODEL.Cerimonial;
import MODEL.Cartorio;
import VIEW.Util;

/**
 *
 * @author Mara
 */
public class DAO {

    private Usuario userLogado;

    private Recado[] recados;
    private Presente[] presentes;
    private Pessoa[] pessoas;
    private Usuario[] usuarios;
    private Fornecedor[] fornecedores;
    private Evento[] eventos;
    private Cerimonial[] cerimoniais;
    private Igreja[] igrejas;
    private Cartorio[] cartorios;
    private ConvidadoIndividual[] convidadosIndividuais;
    private ConvidadoFamilia[] convidadosFamilia;
    private Pagamento[] pagamentos;
    private Relatorio[] relatorios;
    private Object[][] todosOsVetores;
    private Class<?> listaClasses[];
    private String listaNomesClasses[];

    public DAO() {
        this.listaNomesClasses = new String[20];
        this.listaNomesClasses[0] = "RECADOS";
        this.listaNomesClasses[1] = "PRESENTES";
        this.listaNomesClasses[2] = "PESSOA";
        this.listaNomesClasses[3] = "USUÁRIOS";
        this.listaNomesClasses[4] = "FORNECEDOR";
        this.listaNomesClasses[5] = "EVENTO";

        this.listaNomesClasses[6] = "CERIMONIAL";
        this.listaNomesClasses[7] = "IGREJA";
        this.listaNomesClasses[8] = "CARTÓRIO";
        this.listaNomesClasses[9] = "CONVIDADO INDIVIDUAL";
        this.listaNomesClasses[10] = "CONVIDADO FAMÍLIA";
        this.listaNomesClasses[11] = "PAGAMENTO";
        this.listaNomesClasses[12] = "RELATÓRIOS";

        this.listaClasses = new Class<?>[]{
            Recado.class, // RECADOS
            Presente.class, // PRESENTES
            Pessoa.class, // PESSOA
            Usuario.class, // USUÁRIOS
            Fornecedor.class, // FORNECEDOR
            Evento.class, // EVENTO
            Cerimonial.class, // CERIMONIAL
            Igreja.class, // IGREJA
            Cartorio.class, // CARTÓRIO
            ConvidadoIndividual.class, // CONVIDADO INDIVIDUAL
            ConvidadoFamilia.class, // CONVIDADO FAMÍLIA
            Pagamento.class, // PAGAMENTO
            Relatorio.class // RELATÓRIOS
        };

        recados = new Recado[10];            // Por exemplo, vetor com 10 elementos
        presentes = new Presente[10];
        pessoas = new Pessoa[10];
        usuarios = new Usuario[10];
        fornecedores = new Fornecedor[10];
        eventos = new Evento[10];
        cerimoniais = new Cerimonial[10];
        igrejas = new Igreja[10];
        cartorios = new Cartorio[10];
        convidadosIndividuais = new ConvidadoIndividual[10];
        convidadosFamilia = new ConvidadoFamilia[10];
        pagamentos = new Pagamento[10];
        relatorios = new Relatorio[10];
        this.todosOsVetores = new Object[][]{
            recados,//0
            presentes,//1
            pessoas,//2
            usuarios,//3
            fornecedores,//4
            eventos,//5
            cerimoniais,//6
            igrejas,//7
            cartorios,//8
            convidadosIndividuais,//9
            convidadosFamilia,//10
            pagamentos,//11
            relatorios//12
        };
        this.addUsuariosPrincipais();
    }

    public void addUsuariosPrincipais() {
        Object[] pessoa1Dados = {"ADMINISTRADOR", "7777 5555", "adm", "01/01/2001"};
        Pessoa pessoa1 = new Pessoa();
        pessoa1.criar(pessoa1Dados);
        this.addVetor(2, pessoa1);

        Object[] pessoa2Dados = {"João", "3432 2556", "NOIVO", "01/01/2001"};
        Pessoa pessoa2 = new Pessoa();
        pessoa2.criar(pessoa2Dados);
        this.addVetor(2, pessoa2);

        Object[] pessoa3Dados = {"Maria", "3431 1335", "NOIVO", "01/01/2001"};
        Pessoa pessoa3 = new Pessoa();
        pessoa3.criar(pessoa3Dados);
        this.addVetor(2, pessoa3);

        Object[] pessoa4Dados = {"Ana", "3431 1335", "convidado", "01/01/2001"};
        Pessoa pessoa4 = new Pessoa();
        pessoa4.criar(pessoa4Dados);
        this.addVetor(2, pessoa4);

        Usuario user1 = new Usuario();
        Object[] userDados1 = {1, "admin", "1234", 1, pessoa1};
        user1.criar(userDados1);
        this.addVetor(3, user1);

    }

    public Recado[] getRecados() {
        return recados;
    }

    public void setRecados(Recado[] recados) {
        this.recados = recados;
    }

    public Presente[] getPresentes() {
        return presentes;
    }

    public void setPresentes(Presente[] presentes) {
        this.presentes = presentes;
    }

    public Pessoa[] getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public Fornecedor[] getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Fornecedor[] fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Evento[] getEventos() {
        return eventos;
    }

    public void setEventos(Evento[] eventos) {
        this.eventos = eventos;
    }

    public Cerimonial[] getCerimoniais() {
        return cerimoniais;
    }

    public void setCerimoniais(Cerimonial[] cerimoniais) {
        this.cerimoniais = cerimoniais;
    }

    public Igreja[] getIgrejas() {
        return igrejas;
    }

    public void setIgrejas(Igreja[] igrejas) {
        this.igrejas = igrejas;
    }

    public Cartorio[] getCartorios() {
        return cartorios;
    }

    public void setCartorios(Cartorio[] cartorios) {
        this.cartorios = cartorios;
    }

    public ConvidadoIndividual[] getConvidadosIndividuais() {
        return convidadosIndividuais;
    }

    public void setConvidadosIndividuais(ConvidadoIndividual[] convidadosIndividuais) {
        this.convidadosIndividuais = convidadosIndividuais;
    }

    public ConvidadoFamilia[] getConvidadosFamilia() {
        return convidadosFamilia;
    }

    public void setConvidadosFamilia(ConvidadoFamilia[] convidadosFamilia) {
        this.convidadosFamilia = convidadosFamilia;
    }

    public Pagamento[] getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamento[] pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Relatorio[] getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(Relatorio[] relatorios) {
        this.relatorios = relatorios;
    }

    public Object[][] getTodosOsVetores() {
        return this.todosOsVetores;
    }

    public void setTodosOsVetores(Object[][] todosOsVetores) {
        this.todosOsVetores = todosOsVetores;
    }

    public Class<?>[] getListaClasses() {
        return listaClasses;
    }

    public void setListaClasses(Class<?>[] listaClasses) {
        this.listaClasses = listaClasses;
    }

    public Object[] getVetorById(int id) {
        System.out.println("pegando o vetor de id " + id);
        return this.todosOsVetores[id];
    }

    public String getNameClasseById(int idClasse) {
        return this.listaNomesClasses[idClasse];
    }

    public int getTotalClasse(int idClasse) {
        int n = 0;

        for (int i = 0; i < this.getVetorById(idClasse).length; i++) {
            if (this.getVetorById(idClasse)[i] != null) {
                n++;
            }
        }

        return n;
    }

    public String getTexto(int idClasse) {
        System.out.println("LENDO CLASSE DE ID " + idClasse);
        System.out.println("");
        String texto = this.listaNomesClasses[idClasse] + " JÁ CADASTRADOS";
        if (this.getTotalClasse(idClasse) > 1) {
            texto += "\nTotal: " + this.getTotalClasse(idClasse) + " itens\n\n";
        } else if (this.getTotalClasse(idClasse) == 1) {
            texto += "\nTotal: " + this.getTotalClasse(idClasse) + " item\n\n";
        }

        if (this.getTotalClasse(idClasse) > 0) {
            Object[] vetor = this.getVetorById(idClasse);
            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] != null) {
                    System.out.println("ITEM NÃO NULO");
                    if (vetor[i] instanceof ClasseInterface) {

                        int id = ((ClasseInterface) vetor[i]).getId();
                        System.out.println("LENDO ITEM DE ID " + id);
                        texto += ((ClasseInterface) vetor[i]).ler();
                        System.out.println("LENDO TEXTO  ");
                    }

                }
            }
        } else {
            texto += "\n\nNENHUM ITEM ENCONTRADO!\n";
        }

        return texto;
    }

    public Class<?> getClasseByID(int idClasse) {
        System.out.println("LENDO A CLASSE DE ID " + idClasse + " e nome " + this.getNameClasseById(idClasse));
        return this.listaClasses[idClasse];
    }

    public void cadastrar(int idClasse, Object infos[], Usuario userLogado) {
        boolean criado = false;
        System.out.println("ADICIONANDO NO VETOR DA CLASSE DE ID " + idClasse);
        System.out.println("CLASSE NOME: " + this.getNameClasseById(idClasse));
        try {
            // Obtém a classe correspondente ao idClasse
            Class<?> classe = this.listaClasses[idClasse];

            // Cria uma nova instância da classe
            ClasseInterface objeto = (ClasseInterface) classe.getDeclaredConstructor().newInstance();
            System.out.println("CRIANDO O OBJETO");
            // Chama o método criar com as informações fornecidas

            if (this.getNameClasseById(idClasse).equals("USUÁRIOS")) {
                System.out.println("usuario detectado");

                Pessoa pessoa = (Pessoa) this.getItemByID(2, Util.stringToInt((String) infos[0]));
                if (pessoa != null) {
                    if (!pessoa.isUserVinculado()) {

                        infos[4] = pessoa;
                        criado = objeto.criar(userLogado, infos);
                    } else {
                        Util.mostrarErro("A conta de usuário de " + pessoa.getNome() + " já existe!");
                    }

                } else {
                    Util.mostrarErro("Pessoa de id " + infos[0] + " não encontrada");

                }
            } else {
                criado = objeto.criar(userLogado, infos);
            }
            if (criado) {
                System.out.println("add no vetor");
                // Adiciona o objeto ao vetor correspondente
                boolean adicionado = this.addVetor(idClasse, objeto);

                if (adicionado) {
                    Util.mostrarMSG("Cadastrado com sucesso!");
                } else {
                    Util.mostrarErro("Não foi possível realizar o cadastro!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO AO CRIAR O OBJETO: " + e.getMessage());
        }
    }

    public void atualizar(int idClasse, String infos[]) {
        int id = Util.stringToInt(infos[0]);
        System.out.println("ENCONTRANDO ....");
        if (this.find(idClasse, id)) {
            System.out.println("ITEM ENCONTRADO!");
            ClasseInterface item = this.getItemByID(idClasse, id);
            if (item != null) {
                item.update(infos);

                System.out.println("ATUALIZADO COM SUCESSO!");
                Util.mostrarMSG("ATUALIZADO COM SUCESSO!");
            } else {
                Util.mostrarErro("ITEM NÃO ENCONTRADO");
            }
        } else {
            Util.mostrarErro("NÃO ENCONTRADO");
        }

    }

    public boolean addVetor(int idClasse, Object ob) {
        Object[] vetor = this.getVetorById(idClasse);
        System.out.println("ADICIONANDO NO VETOR");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Percorrendo vetor");
            if (vetor[i] == null) {
                System.out.println("ITEM NULO ");
                vetor[i] = ob;
                return true;
            }
        }
        return false;
    }

    public boolean remove(int idClasse, Object ob) {
        Object[] vetor = this.getVetorById(idClasse);
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == ob) {
                vetor[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean find(int idClasse, int id) {
        Object[] vetor = this.getVetorById(idClasse);
        for (int i = 0; i < vetor.length; i++) {
            // Verifica se o item não é nulo e se implementa a interface
            if (vetor[i] != null && vetor[i] instanceof ClasseInterface) {
                ClasseInterface item = (ClasseInterface) vetor[i]; // Faz o cast
                if (item.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public ClasseInterface getItemByID(int idClasse, int id) {
        Object[] vetor = this.getVetorById(idClasse);
        for (int i = 0; i < vetor.length; i++) {
            // Verifica se o item não é nulo e se implementa a interface
            if (vetor[i] != null && vetor[i] instanceof ClasseInterface) {
                ClasseInterface item = (ClasseInterface) vetor[i]; // Faz o cast
                if (item.getId() == id) {
                    return item; // Retorna como ClasseInterface
                }
            }
        }
        return null;
    }

    public boolean delItemByID(int idClasse, int id) {
        System.out.println("DELETANDO ITEM " + id + " DA CLASSE DE ID " + idClasse);
        System.out.println("NOME DA CLASSE " + this.getNameClasseById(idClasse));
        Object[] vetor = this.getVetorById(idClasse);
        System.out.println("vetor pego");
        for (int i = 0; i < vetor.length; i++) {
            // Verifica se o item não é nulo e se implementa a interface
            if (vetor[i] != null && vetor[i] instanceof ClasseInterface) {
                System.out.println("verificado!");
                ClasseInterface item = (ClasseInterface) vetor[i]; // Faz o cast
                if (item.getId() == id) {
                    item.deletar();
                    System.out.println("elemento encontrado");
                    vetor[i] = null; // Remove o item
                    System.out.println("elemento apagado");

                    return true;
                }
            }
        }
        return false;
    }

    public Pessoa[] getNoivos() {
        Pessoa noivos[] = new Pessoa[2];
        int n = 0;
        Pessoa vPessoas[] = (Pessoa[]) this.todosOsVetores[2];
        for (int i = 0; i < vPessoas.length; i++) {
            if (vPessoas[i] != null && vPessoas[i].getTipo().equals("NOIVO")) {
                noivos[n] = vPessoas[i];
                n++;
            }
        }
        return noivos;
    }

    public String getTextoNoivos() {
        String texto = "\n                    ";
        int n = 0;
        Pessoa vPessoas[] = (Pessoa[]) this.todosOsVetores[2];
        for (int i = 0; i < vPessoas.length; i++) {
            if (vPessoas[i] != null && vPessoas[i].getTipo().equals("NOIVO")) {
                texto += vPessoas[i].getNome();
                if (n == 0) {
                    texto += " ❤ ";
                }
                n++;
            }
        }
        return texto;
    }

    public String getNomesPessoasSemUsers() {
        String texto = "\n                    ";
        Pessoa vPessoas[] = (Pessoa[]) this.todosOsVetores[2];
        Usuario vUsers[] = (Usuario[]) this.todosOsVetores[3];
        boolean userVinculado = false;
        int c = 0;
        for (int i = 0; i < vPessoas.length; i++) {
            if (vPessoas[i] != null) {
                if (!vPessoas[i].isUserVinculado()) {
                    texto += "\nID: " + vPessoas[i].getId() + "\nNome: " + vPessoas[i].getNome();
                    c++;
                    texto += "\n";
                }
            }
        }

        if (c == 0) {
            texto = "\n\nNENHUMA PESSOA CADASTRADA SEM USUÁRIO VINCULADO!\n\n";
        }
        return texto;
    }

    public Usuario getUser(String user) {

        System.out.println("Procurando usuario " + user);
        Usuario vUsers[] = (Usuario[]) this.todosOsVetores[3];
        for (int i = 0; i < vUsers.length; i++) {

            if (vUsers[i] != null && vUsers[i].getLogin().equals(user)) {
                System.out.println("usuario encontrado " + user);
                return vUsers[i];
            }
        }
        System.out.println("usuario nao encontrado " + user);
        return null;
    }

    public boolean autentica(String user, String senha) {
        System.out.println("Autenticando usuario " + user + " com senha " + senha);
        Usuario usuario = this.getUser(user);

        if (usuario != null) {
            System.out.println("usuario encontrado " + usuario.getLogin());
            if (usuario.getSenha().equals(senha)) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("usuario nao encontrado " + user);
            return false;
        }
    }
}
