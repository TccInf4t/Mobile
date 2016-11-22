package onpecas.com.br.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import onpecas.com.br.app.Model.Pedido;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        if(intent != null){
            Pedido pedido = (Pedido) intent.getSerializableExtra("pedido");

            Toast.makeText(this, pedido.getDescricaostatus(), Toast.LENGTH_LONG).show();

            TabHost host = (TabHost)findViewById(android.R.id.tabhost);
<<<<<<< HEAD

            host.setup();

            //Tab 1
            TabHost.TabSpec tab1 = host.newTabSpec("Detalhe");
            tab1.setContent(R.id.tab1);
            tab1.setIndicator("Detalhes");
            host.addTab(tab1);

            //Tab 2
            TabHost.TabSpec tab2 = host.newTabSpec("Mapa");
            tab2.setContent(R.id.tab2);
            tab2.setIndicator("Mapas");
=======
            host.setup();

            //Tab 1
            TabHost.TabSpec tab1 = host.newTabSpec("Tab One");
            tab1.setContent(new Intent(this, DetalhesActivity.class));
            tab1.setIndicator("Tab One");
            host.addTab(tab1);

            //Tab 2
            TabHost.TabSpec tab2 = host.newTabSpec("Tab two");
            tab2.setContent(new Intent(this, AcompanhamentoMapsActivity.class));
            tab2.setIndicator("Tab Two");
>>>>>>> ca753ad76041b1933128e41ccb2f7cbb36ad764d
            host.addTab(tab2);



        }
    }

}
