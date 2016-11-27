package onpecas.com.br.app;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import onpecas.com.br.app.Model.Cliente;
import onpecas.com.br.app.Model.Endereco;
import onpecas.com.br.app.Model.Pedido;
import onpecas.com.br.app.helper.BuscarDadosAPI;
import onpecas.com.br.app.helper.ClienteLogado;
import onpecas.com.br.app.helper.ConfigLink;
import onpecas.com.br.app.helper.ObterDadosAPI;
import onpecas.com.br.app.helper.PedidoAdapter;

public class LoginActivity extends AppCompatActivity {

    private EditText txtLogin;
    private EditText txtSenha;
    Button btnEntrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        txtLogin = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Esta convertendo o Layout para String
                String email = txtLogin.getText().toString().trim();
                String senha = txtSenha.getText().toString().trim();

                //Verificando se o Email e Senha é valido
                if(!email.isEmpty() && !senha.isEmpty()){
                    new ObterDadosAPI(LoginActivity.this, email, senha).execute();
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this).
                            setTitle("Erro").
                            setMessage("Não foi possivel fazer login\nE-mail ou Senha vazio!").
                            setPositiveButton("OK", null);
                    builder.create().show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
            finish();
        }
    }

}
