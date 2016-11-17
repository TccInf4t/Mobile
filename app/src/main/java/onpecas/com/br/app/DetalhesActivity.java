package onpecas.com.br.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import onpecas.com.br.app.Model.Pedido;

/**
 * Created by 15160977 on 08/11/2016.
 */

public class DetalhesActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if(intent != null){
            Pedido pedido = (Pedido) intent.getSerializableExtra("pedido");

            Toast.makeText(this, pedido.getDescricaostatus(), Toast.LENGTH_LONG).show();
        }
    }
}
