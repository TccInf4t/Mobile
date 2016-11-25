package onpecas.com.br.app.helper;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

/**
 * Created by 15160210 on 24/05/2016.
 */
public class DownloadImageTask extends AsyncTask<String,Void,Bitmap > {
    ProgressDialog progress;
    WeakReference<ImageView> imageView;
    Context context;
    public DownloadImageTask(ImageView imageView, Context context) {
        this.imageView = new WeakReference<ImageView>(imageView);
        this.context = context;
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
            ImageView img = imageView.get();
            img.setImageBitmap(bitmap);
        }
    }
}
