package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.OnThi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * Created by Tin Học Yino on 11/1/2016.
 */
public class AdapterH extends ArrayAdapter<Item> {

    Context context;
    int id;
    TextView txthienthi;
    ArrayList<Item> items;
    public AdapterH(Context context, int resource, ArrayList<Item> objects){
        super( context, resource, objects);
        this.context = context;
        this.id=resource;
        this.items = objects;
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent){
        if (v==null){
            //LayoutInflater inflater=context.getLayoutInflater();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v=inflater.inflate(id,null);

        }
        TextView tvId = (TextView)v.findViewById(R.id.textView1);
        TextView tvTitle = (TextView)v.findViewById(R.id.textView2);
        ImageView imgIcon= (ImageView)v.findViewById(R.id.imageView);

        Item item = items.get(position);
        tvId.setText(item.getId());
        tvTitle.setText(item.getTitle());
        // tvresult.setText(item.getResult());
        imgIcon.setBackgroundResource(0);
        imgIcon.toString();
        imgIcon.setBackgroundResource(item.getIcon());
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), str[position], Toast.LENGTH_SHORT).show();
            }
        });
        return v;

    }
    String[] str ={
            "Đáp án đúng là: 1,2", "Đáp án đúng là: 1", "Đáp án đúng là: 1", "Đáp án đúng là: 2", "Đáp án đúng là: 1",
            "Đáp án đúng là: 1", "Đáp án đúng là: 1,2", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 2",

            "Đáp án đúng là: 1,2", "Đáp án đúng là: 1,2", "Đáp án đúng là: 2,3", "Đáp án đúng là: 1,2", "Đáp án đúng là: 1,2",
            "Đáp án đúng là: 1", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 1", "Đáp án đúng là: 2",


            "Đáp án đúng là: 1", "Đáp án đúng là: 1,2", "Đáp án đúng là: 1,2", "Đáp án đúng là: 3", "Đáp án đúng là: 1,2",
            "Đáp án đúng là: 3", "Đáp án đúng là: 1,2", "Đáp án đúng là: 3", "Đáp án đúng là: 2,3", "Đáp án đúng là: 2",

            "Đáp án đúng là: 1,2", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 1,2", "Đáp án đúng là: 1",
            "Đáp án đúng là: 2", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 2", "Đáp án đúng là: 2",

            "Đáp án đúng là: 2", "Đáp án đúng là: 1,3", "Đáp án đúng là: 1,2", "Đáp án đúng là: 1", "Đáp án đúng là: 2,3",
            "Đáp án đúng là: 1,2", "Đáp án đúng là: 2", "Đáp án đúng là: 3", "Đáp án đúng là: 3", "Đáp án đúng là: 3",

            "Đáp án đúng là: 1", "Đáp án đúng là: 3", "Đáp án đúng là: 1", "Đáp án đúng là: 1,3", "Đáp án đúng là: 1",
            "Đáp án đúng là: 3", "Đáp án đúng là: 1", "Đáp án đúng là: 1", "Đáp án đúng là: 1,2", "Đáp án đúng là: 1,2",

            "Đáp án đúng là: 1", "Đáp án đúng là: 2", "Đáp án đúng là: 1,2", "Đáp án đúng là: 1,2", "Đáp án đúng là: 3",
            "Đáp án đúng là: 2", "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 1",

            "Đáp án đúng là: 1,2", "Đáp án đúng là: 2", "Đáp án đúng là: 3", "Đáp án đúng là: 1", "Đáp án đúng là: 3",
            "Đáp án đúng là: 1,2", "Đáp án đúng là: 2", "Đáp án đúng là: 2,3", "Đáp án đúng là: 1,3", "Đáp án đúng là: 1,2",

            "Đáp án đúng là: 3", "Đáp án đúng là: 1", "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 1",
            "Đáp án đúng là: 3", "Đáp án đúng là: 1,3", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 2",

            "Đáp án đúng là: 1", "Đáp án đúng là: 2", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 2",
            "Đáp án đúng là: 1", "Đáp án đúng là: 2", "Đáp án đúng là: 3", "Đáp án đúng là: 3", "Đáp án đúng là: 1",

            "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 1,2",
            "Đáp án đúng là: 1", "Đáp án đúng là: 2", "Đáp án đúng là: 2", "Đáp án đúng là: 3", "Đáp án đúng là: 2",

            "Đáp án đúng là: 1", "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 3",
            "Đáp án đúng là: 1", "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 2",

            "Đáp án đúng là: 1", "Đáp án đúng là: 3", "Đáp án đúng là: 1", "Đáp án đúng là: 3", "Đáp án đúng là: 1",
            "Đáp án đúng là: 2", "Đáp án đúng là: 1", "Đáp án đúng là: 1", "Đáp án đúng là: 3", "Đáp án đúng là: 2",

            "Đáp án đúng là: 2", "Đáp án đúng là: 4", "Đáp án đúng là: 2", "Đáp án đúng là: 3", "Đáp án đúng là: 3",
            "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 1",

            "Đáp án đúng là: 3", "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 1,2", "Đáp án đúng là: 2",
            "Đáp án đúng là: 3", "Đáp án đúng là: 2", "Đáp án đúng là: 2", "Đáp án đúng là: 3", "Đáp án đúng là: 2",


    };
}