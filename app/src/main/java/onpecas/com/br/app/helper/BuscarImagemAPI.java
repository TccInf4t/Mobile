package onpecas.com.br.app.helper;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by 15160210 on 17/05/2016.
 */
public class BuscarImagemAPI extends AsyncTask<String, Void, Bitmap>{

    ImageView imageView;

    public BuscarImagemAPI(ImageView imageView) {
        this.imageView = imageView;
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
        if(bitmap!=null){
            imageView.setImageBitmap(bitmap);
        }
    }
}
