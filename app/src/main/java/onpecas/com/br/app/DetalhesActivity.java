package onpecas.com.br.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import onpecas.com.br.app.Model.Peca;
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

            TabHost host = (TabHost)findViewById(android.R.id.tabhost);
            host.setup();
            //Tab 1
            final TabHost.TabSpec tab1 = host.newTabSpec("Detalhes");
            tab1.setContent(R.id.tab1);
            tab1.setIndicator("Detalhes");
            host.addTab(tab1);

            //Tab 2
            final TabHost.TabSpec tab2 = host.newTabSpec("Mapas");
            tab2.setContent(R.id.tab2);
            tab2.setIndicator("Mapas");
            host.addTab(tab2);
            host.setup();

            TextView txtDescStatus = (TextView) findViewById(R.id.txtDescStatus);
            TextView txtQauntidadePedido = (TextView) findViewById(R.id.txtQauntidadePedido);
            TextView txtFrete = (TextView) findViewById(R.id.txtFrete);
            TextView txtValorTotal = (TextView) findViewById(R.id.txtValorTotal);
            TextView txtDataPedido = (TextView) findViewById(R.id.txtDataPedido);
            TextView txtFormaPagamento = (TextView) findViewById(R.id.txtFormaPagamento);
            TextView txtNumPedido = (TextView) findViewById(R.id.txtNumPedido);
            TextView txtStatus = (TextView) findViewById(R.id.txtStatus);

            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

            txtDescStatus.setText(pedido.getDescricaostatus());
            txtStatus.setText(pedido.getNomestatus());
            txtFrete.setText(numberFormat.format(pedido.getFrete()));
            txtDataPedido.setText(txtDataPedido.getText()+""+pedido.getDtrealizado());
            txtFormaPagamento.setText(txtFormaPagamento.getText()+""+pedido.getFormapagamento());
            txtNumPedido.setText(txtNumPedido.getText()+""+pedido.getOid_pedido());

            int countPeca = 0;
            double valorTodosPedidos = 0;
            for(Peca item : pedido.getOid_peca()){
                countPeca+=item.getQtd();
                valorTodosPedidos+= item.getValortotal();
            }

            txtQauntidadePedido.setText(""+countPeca);
            txtValorTotal.setText(numberFormat.format(valorTodosPedidos));

            host.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
                @Override
                public void onTabChanged(String tabId) {
                    if(tab1.getTag().equals(tabId)) {
                        Log.i("JKAGSDASDASDAS", "CLICOU 1");
                    }
                    if(tab2.getTag().equals(tabId)) {
                        Log.i("JKAGSDASDASDAS", "CLICOU 2");
                    }
                }});
        }
    }

}
