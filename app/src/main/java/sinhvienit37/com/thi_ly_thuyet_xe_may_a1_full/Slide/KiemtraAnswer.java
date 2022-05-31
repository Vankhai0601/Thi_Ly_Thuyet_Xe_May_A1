package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Cauhoi.Cauhoi;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * Created by ADMIN on 11/15/2016.
 */
public class KiemtraAnswer extends BaseAdapter {
 ArrayList lisData;
    LayoutInflater inflater;

    public KiemtraAnswer(ArrayList lisData, Context context) {
        this.lisData = lisData;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return lisData.size();
    }

    @Override
    public Object getItem(int position) {
        return lisData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cauhoi data=(Cauhoi) getItem(position);
        ViewHolder holder;
        if(convertView ==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_girdview_ansewr, null);
            holder.tvNumAns=(TextView) convertView.findViewById(R.id.tvNumAns);
            holder.tvYoutAns=(TextView) convertView.findViewById(R.id.tvAnsewr);
            convertView.setTag(holder);

        }else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        int i = position+1;
        holder.tvNumAns.setText("Câu"+i+": ");
        holder.tvYoutAns.setText(data.getTraloi());
        return convertView;
    }
    private static  class  ViewHolder{
        TextView tvNumAns, tvYoutAns;
    }
}
