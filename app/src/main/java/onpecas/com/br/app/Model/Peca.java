package onpecas.com.br.app.Model;

public class Peca {

    private int oid_peca, qtd;
    private String nome, descricao;
    private double valorvendido, valortotal;

    public int getOid_peca() {
        return oid_peca;
    }

    public void setOid_peca(int oid_peca) {
        this.oid_peca = oid_peca;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorvendido() {
        return valorvendido;
    }

    public void setValorvendido(double valorvendido) {
        this.valorvendido = valorvendido;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
}
