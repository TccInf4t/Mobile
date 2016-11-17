package onpecas.com.br.app.Model;


public class Cliente {

    private int oid_cliente;
    private String nome , email, senha, oid_imagem;
    private String ultimoacesso, data_nascimento, cpfcnpj;


    public int getOid_cliente() {
        return oid_cliente;
    }

    public void setOid_cliente(int oid_cliente) {
        this.oid_cliente = oid_cliente;
    }

    public String getOid_imagem() {
        return oid_imagem;
    }

    public void setOid_imagem(String oid_imagem) {
        this.oid_imagem = oid_imagem;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getUltimoacesso() {
        return ultimoacesso;
    }

    public void setUltimoacesso(String ultimoacesso) {
        this.ultimoacesso = ultimoacesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
