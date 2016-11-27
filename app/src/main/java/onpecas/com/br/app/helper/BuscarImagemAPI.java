package onpecas.com.br.app.helper;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import onpecas.com.br.app.Model.Cliente;

/**
 * Created by 15160210 on 17/05/2016.
 */
public class BuscarImagemAPI extends AsyncTask<String, Void, Bitmap>{
    ProgressDialog progress;
    Context context;
    ImageView imgPerfil, imgHeader;

    public BuscarImagemAPI(Context context, ImageView imgPerfil, ImageView imgHeader) {
        this.context = context;
        this.imgHeader=imgHeader;
        this.imgPerfil=imgPerfil;
    }

    @Override
    protected void onPreExecute() {
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
    protected Bitmap doInBackground(String... params) {

        String caminhoImagem = params[0];

        Bitmap bitmap = null;

        try {
            InputStream inputStream = (InputStream) new URL(caminhoImagem).getContent();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        progress.dismiss();

        if(bitmap!=null){
            imgPerfil.setImageBitmap(bitmap);
            imgHeader.setImageBitmap(bitmap);
            ClienteLogado.CLIENTELOGADO.setImagem(bitmap);
        }
    }
}
