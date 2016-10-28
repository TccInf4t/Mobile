package onpecas.com.br.app.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

import onpecas.com.br.app.Model.Pedido;
import onpecas.com.br.app.R;


public class PedidoAdapter extends ArrayAdapter<Pedido> {

    int resource;
    public PedidoAdapter(Context context, int resource, Pedido[] objects) {
        super(context, resource, objects);

        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(resource, null);
        }
        Pedido pedido = getItem(position);

        if (pedido != null) {


            ImageView imglista = (ImageView) v.findViewById(R.id.imglista);
            TextView txt_nomepedido = (TextView) v.findViewById(R.id.txt_nomepedido);
            TextView txt_dataPedido = (TextView) v.findViewById(R.id.txt_dataPedido);
            TextView idPedido = (TextView) v.findViewById(R.id.idPedido);


            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

            txt_nomepedido.setText(pedido.getNomePedido());
            txt_dataPedido.setText(pedido.getDataPedido());
            idPedido.setText(pedido.getIdPedido());


           /* String link = String.format("%s%s", ConfigLink.LINK_IMG, home.getImagem());
            new DownloadImageTask(imglista).execute(link);*/
        }
        return v;
    }
}
