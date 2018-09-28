package sercandevops.com.retrofitwebservis3.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import sercandevops.com.retrofitwebservis3.R;

public class Adaptor extends BaseAdapter {
    Context context;
    List<Bilgi> listbilgi;

    public Adaptor(Context context, List<Bilgi> listbilgi) {
        this.context = context;
        this.listbilgi = listbilgi;
    }

    @Override
    public int getCount() {
        return listbilgi.size();
    }

    @Override
    public Object getItem(int position) {
        return listbilgi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.layoutum,parent,false);

        TextView albumid,id,title,url;
        ImageView imageview;


        albumid = (TextView)convertView.findViewById(R.id.txtalbumid);
        id = (TextView)convertView.findViewById(R.id.txtid);
        title = (TextView)convertView.findViewById(R.id.txtitle);
        url = (TextView)convertView.findViewById(R.id.txturl);

        imageview = (ImageView)convertView.findViewById(R.id.imgthumnbl);

        albumid.setText(""+listbilgi.get(position).getAlbumId());
        id.setText(""+listbilgi.get(position).getId());
        title.setText(listbilgi.get(position).getTitle());
        url.setText(listbilgi.get(position).getUrl());

        Picasso.get().load(listbilgi.get(position).getThumbnailUrl()).into(imageview);

        return convertView;
    }
}
