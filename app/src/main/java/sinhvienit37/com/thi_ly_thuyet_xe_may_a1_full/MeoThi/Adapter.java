package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MeoThi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.OnThi.Item;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

public class Adapter extends ArrayAdapter<Item> {

    Activity context;
    int id;
    ArrayList<Item> items;
    public Adapter(Activity context, int resource, ArrayList<Item> objects){
        super( context, resource, objects);
        this.context = context;
        this.id=resource;
        this.items = objects;
    }
    @Override
    public View getView(final int position, View v, ViewGroup parent){
        if (v==null){
            LayoutInflater inflater=context.getLayoutInflater();
            v=inflater.inflate(id,null);

        }
        TextView tvId = (TextView)v.findViewById(R.id.textView1);
        TextView tvTitle = (TextView)v.findViewById(R.id.textView2);
        ImageView imgIcon= (ImageView)v.findViewById(R.id.imageView);

        Item item = items.get(position);
        tvId.setText(item.getId());
        tvTitle.setText(item.getTitle());
        imgIcon.setBackgroundResource(0);
        imgIcon.toString();
        imgIcon.setBackgroundResource(item.getIcon());
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {}
        });
        return v;
    }
}