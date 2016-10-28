package onpecas.com.br.app.Model;

/**
 * Created by 15160977 on 24/10/2016.
 */
public class Cliente {

    private String nome , email, senha;
    private String ultimoacesso, data_nascimento, cpfcnpj;

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
