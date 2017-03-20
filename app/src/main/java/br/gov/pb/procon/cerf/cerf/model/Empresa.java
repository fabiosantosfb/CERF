package br.gov.pb.procon.cerf.cerf.model;

/**
 * Created by fabiano on 18/03/17.
 */

public class Empresa {
    private String nome;
    private String atendido;
    private String nao_atendido;
    private String total;
    private String Ranker;
    private static Empresa instanseEmpresa = null;

    public static synchronized Empresa getInstanseEmpresa(){
        if (instanseEmpresa == null)
            instanseEmpresa = new Empresa();
        return instanseEmpresa;
    }

    public Empresa() {

    }

    public Empresa(String ranck, String nome, String atendido, String nao_atendido, String total){
        this.Ranker = ranck;
        this.nome = nome;
        this.atendido = atendido;
        this.nao_atendido = nao_atendido;
        this.total = total;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAtendido() { return atendido; }
    public void setAtendido(String atendido) { this.atendido = atendido; }

    public String getNaoAtendido() { return nao_atendido; }
    public void setNaoAtendido(String nao_atendido) { this.nao_atendido = nao_atendido; }

    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }

    public String getRanker() { return Ranker; }
    public void setRanker(String ranker) { this.Ranker = ranker; }
}
