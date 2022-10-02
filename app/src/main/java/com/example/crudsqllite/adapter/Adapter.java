package com.example.crudsqllite.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crudsqllite.R;
import com.example.crudsqllite.model.data;

import java.io.InputStream;
import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<data> items;

    public Adapter(Activity activity, List<data> items){
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount(){
        return items.size();
    }

    @Override
    public Object getItem(int location){
        return items.get(location);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView address = (TextView) convertView.findViewById(R.id.address);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imgView);

        data data = items.get(position);

        id.setText(data.getId());
        name.setText(data.getName());
        address.setText(data.getAddress());
        if (data.getPhat() != null) {
            Bitmap img= BitmapFactory.decodeFile(data.getPhat());
            imgView.setImageBitmap(img);
        }
        System.out.println(data.getPhat());
        return convertView;
    }
}
