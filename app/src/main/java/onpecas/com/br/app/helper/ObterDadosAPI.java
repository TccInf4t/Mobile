package onpecas.com.br.app.helper;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;

import com.google.android.gms.analytics.internal.zzy;
import com.google.gson.Gson;

import onpecas.com.br.app.InicialActivity;
import onpecas.com.br.app.LoginActivity;
import onpecas.com.br.app.Model.Cliente;

/**
 * Created by 15160977 on 27/10/2016.
 */
public class ObterDadosAPI extends AsyncTask<Void, Void, String> {
    ProgressDialog progress;

    Context context;
    String txtEmail, txtSenha;
    public ObterDadosAPI(Context context, String txtEmail, String txtSenha){
        this.context =context;
        this.txtEmail = txtEmail;
        this.txtSenha=txtSenha;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        String titulo = "Carregando dados";
        String mensagem = "Aguarde...";
        boolean indeterminado = true;
        boolean podeCancelar = false;

        progress = ProgressDialog
                .show(context,
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

        link= link+"?login&email="+txtEmail+"&senha="+txtSenha;
        BuscarDadosAPI dadosAPI = new BuscarDadosAPI();
        System.out.print(link);

        json = dadosAPI.getJson(link);

        return json;
    }

    @Override
    protected void onPostExecute(String stringJson) {
        super.onPostExecute(stringJson);

        progress.dismiss();
        if(stringJson!=null){
            Gson gson = new Gson();

            Cliente[] lstcliente;

            lstcliente = gson.fromJson(stringJson, Cliente[].class);
            ClienteLogado.CLIENTELOGADO = lstcliente[0];

            System.out.print(ClienteLogado.CLIENTELOGADO.getNome());

            Intent intent = new Intent(context, InicialActivity.class);
            context.startActivity(intent);

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(context).
                    setTitle("Erro").
                    setMessage("Não foi possivel carregar o conteudo, tente novamente mais tarde!").
                    setPositiveButton("OK", null);
            builder.create().show();
        }
    }
}
