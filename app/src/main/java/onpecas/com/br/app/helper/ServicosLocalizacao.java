package onpecas.com.br.app.helper;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import onpecas.com.br.app.DetalhesActivity;

/**
 * Created by ISMAEL on 27/11/2016.
 */

public class ServicosLocalizacao extends IntentService {
    public ServicosLocalizacao() {
        super("ServicosLocalizacao");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String saida = "TESTE";

        /*Broadcast - envia um sinal para todos os aplicativos do sistema android*/
        Intent broadcastIntent = new Intent();
        broadcastIntent.putExtra("saida", saida);

        /*Ação para enviar o Broadcast*/
        /*O aplicativo que tiver a ação para pegar esse pacote "br.com.servicos.app.OK" poderá ter o conteudo do mesmo*/
        broadcastIntent.setAction(DetalhesActivity.ResponseReceiver.PACKBROADCAST);

        /*Componente Broadcast*/
        LocalBroadcastManager localBroadcastManager;
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        /*Envia o broadcast*/
        localBroadcastManager.sendBroadcast(broadcastIntent);
    }
}
