package onpecas.com.br.app.Model;


import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {
    private int oid_pedido;
    private double frete;
    private String nomestatus, descricaostatus, formapagamento, dtrealizado;

    public int getOid_pedido() {
        return oid_pedido;
    }

    public void setOid_pedido(int oid_pedido) {
        this.oid_pedido = oid_pedido;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public String getNomestatus() {
        return nomestatus;
    }

    public void setNomestatus(String nomestatus) {
        this.nomestatus = nomestatus;
    }

    public String getDescricaostatus() {
        return descricaostatus;
    }

    public void setDescricaostatus(String descricaostatus) {
        this.descricaostatus = descricaostatus;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public String getDtrealizado() {
        return dtrealizado;
    }

    public void setDtrealizado(String dtrealizado) {
        this.dtrealizado = dtrealizado;
    }
}
