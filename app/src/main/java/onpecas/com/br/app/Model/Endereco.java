package onpecas.com.br.app.Model;

/**
 * Created by 15160977 on 24/10/2016.
 */
public class Endereco {

    private String cep, rua, longradouro;
    private String numero, bairro, cidade;
    private String complemento;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {

        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {

        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {

        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLongradouro() {

        return longradouro;
    }

    public void setLongradouro(String longradouro) {
        this.longradouro = longradouro;
    }

    public String getRua() {

        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
