package onpecas.com.br.app.Model;


import android.graphics.Bitmap;

import java.io.Serializable;

public class Pedido implements Serializable {
    private int idPedido;
    private double valor;
    private String NomePedido,DataPedido,QtdPedidos;
    private String frete, imagem;
    private Bitmap imagembit;

    public Bitmap getImagembit() {
        return imagembit;
    }

    public void setImagembit(Bitmap imagembit) {
        this.imagembit = imagembit;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public String getQtdPedidos() {

        return QtdPedidos;
    }

    public void setQtdPedidos(String qtdPedidos) {
        QtdPedidos = qtdPedidos;
    }

    public double getValor() {

        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getImglista() {
        return imglista;
    }

    public void setImglista(String imglista) {
        this.imglista = imglista;
    }

    public String getDataPedido() {

        return DataPedido;
    }

    public void setDataPedido(String txt_dataentrega) {
        this.DataPedido = txt_dataentrega;
    }

    public String getNomePedido() {

        return NomePedido;
    }

    public void setNomePedido(String txt_nomepedido) {
        this.NomePedido = txt_nomepedido;
    }

    public Bitmap getImagemBit() {

        return imagemBit;
    }

    public void setImagemBit(Bitmap imagemBit) {
        this.imagemBit = imagemBit;
    }

    private String imglista;
    private Bitmap imagemBit ;


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


}
