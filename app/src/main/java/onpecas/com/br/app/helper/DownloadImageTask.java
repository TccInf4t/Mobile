package onpecas.com.br.app.helper;
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

    WeakReference<ImageView> imageView;

    public DownloadImageTask(ImageView imageView) {
        this.imageView = new WeakReference<ImageView>(imageView);
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
            ImageView img = imageView.get();
            img.setImageBitmap(bitmap);
        }
    }
}
