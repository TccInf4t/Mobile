package onpecas.com.br.app;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import onpecas.com.br.app.Model.Pedido;
import onpecas.com.br.app.helper.BuscarDadosAPI;
import onpecas.com.br.app.helper.ClienteLogado;
import onpecas.com.br.app.helper.ConfigLink;
import onpecas.com.br.app.helper.PedidoAdapter;

public class PedidosRealizadosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    //Lista dos Pediddos

    Pedido[] lstpedido;
    ListView list_view_item;
    SimpleAdapter listAdapter;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_realizados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        context = this;//definindo o contexto

        list_view_item = (ListView) findViewById(R.id.list_view_item);
        new ObterDadosAPI().execute();

    }

    private class ObterDadosAPI extends AsyncTask<Void, Void, String>{
        ProgressDialog progress;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            String titulo = "Carregando dados";
            String mensagem = "Aguarde...";
            boolean indeterminado = true;
            boolean podeCancelar = false;

            progress = ProgressDialog
                    .show(PedidosRealizadosActivity.this,
                            titulo,
                            mensagem,
                            indeterminado,
                            podeCancelar
                    );

        }

        @Override
        protected String doInBackground(Void... params) {

            String json ;
            String link= ConfigLink.LINK_API;

            link= link+"?buscarpedido&oid_cliente="+ClienteLogado.CLIENTELOGADO.getOid_cliente();

            BuscarDadosAPI dadosAPI = new BuscarDadosAPI();

            json = dadosAPI.getJson(link);

            return json;
        }

        @Override
        protected void onPostExecute(String stringJson) {
            super.onPostExecute(stringJson);

            progress.dismiss();
            if(stringJson!=null){
                Gson gson = new Gson();
                lstpedido = gson.fromJson(stringJson, Pedido[].class);

                PedidoAdapter adapter = new PedidoAdapter(
                        PedidosRealizadosActivity.this,
                        R.layout.list_view_item,
                        lstpedido
                );

                list_view_item.setAdapter(adapter);

            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(PedidosRealizadosActivity.this).
                        setTitle("Erro").
                        setMessage("Não foi possivel carregar o conteudo, tente novamente mais tarde!").
                        setPositiveButton("OK", null);
                builder.create().show();
            }
        }


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