package onpecas.com.br.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import onpecas.com.br.app.helper.ClienteLogado;
import onpecas.com.br.app.helper.ObterDadosAPI;

import static onpecas.com.br.app.R.id.email;
import static onpecas.com.br.app.R.id.none;
import static onpecas.com.br.app.R.id.txtEmail;
import static onpecas.com.br.app.R.id.txtLogin;
import static onpecas.com.br.app.R.id.txt_nomepedido;

public class InicialActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public TextView txtNomeCliente;
    public TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Codigo que ira alimentar as Activity

        txtEmail =(TextView) findViewById(R.id.txtEmail);
        txtNomeCliente = (TextView) findViewById(R.id.txtNomeCliente);

        //Dizendo que os "txts" é o mesmo que class CLIENTE LOGADO onde esta armazenando o ID do cliente
        txtEmail.setText(ClienteLogado.CLIENTELOGADO.getEmail());
        txtNomeCliente.setText(ClienteLogado.CLIENTELOGADO.getNome());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            Intent intent = new Intent(this, InicialActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_pedidos) {
            Intent intent = new Intent(this, PedidosRealizadosActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_acompanhamento) {
            Intent intent = new Intent(this, AcompanhamentoMapsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_cliente) {
            Intent intent = new Intent(this, DadosClienteActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
