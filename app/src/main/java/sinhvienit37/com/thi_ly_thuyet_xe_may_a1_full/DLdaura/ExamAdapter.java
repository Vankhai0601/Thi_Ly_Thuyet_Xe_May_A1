package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * Sinhvienit37 on 11/12/2016.
 */
public class ExamAdapter extends ArrayAdapter<Exam> {
    ArrayList<Exam> arr_exam = new ArrayList<Exam>();
    String[] strings={"Đề số 1","Đề số 2","Đề số 3","Đề số 4","Đề số 5","Đề số 6","Đề số 7","Đề số 8"};
    public ExamAdapter(Context context, ArrayList<Exam> exam) {
        super(context, 0,exam);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.item_gridview, parent, false);
    }
        arr_exam.add(new Exam("Đề số 1"));
        arr_exam.add(new Exam("Đề số 2"));
        arr_exam.add(new Exam("Đề số 3"));
        arr_exam.add(new Exam("Đề số 4"));
        arr_exam.add(new Exam("Đề số 5"));
        arr_exam.add(new Exam("Đề số 6"));
        arr_exam.add(new Exam("Đề số 7"));
        arr_exam.add(new Exam("Đề số 8"));
        TextView tvName = (TextView) convertView.findViewById(R.id.tvNumExam);
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);

        Exam p = getItem(position);
        if (p!= null){
            //tvName.setText(""+p.getName());
            tvName.setText(""+strings[position]);
            Log.i("",p.getName()+ "A");
            imgIcon.setImageResource(R.drawable.thi);
        }

        return convertView;
    }

}
