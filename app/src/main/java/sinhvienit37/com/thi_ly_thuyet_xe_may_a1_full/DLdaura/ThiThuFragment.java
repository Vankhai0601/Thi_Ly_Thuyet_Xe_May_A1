package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MainActivity;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Slide.ScreenSlideActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThiThuFragment extends Fragment {
      ExamAdapter examAdapter;
    GridView gvEXam;
    ArrayList<Exam> arr_exam = new ArrayList<Exam>();

    public ThiThuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Thi Thử");
        
        return inflater.inflate(R.layout.fragment_thi_thu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvEXam = (GridView) getActivity().findViewById(R.id.gvExam);
        arr_exam.add(new Exam("Đề số 1"));
        arr_exam.add(new Exam("Đề số 2"));
        arr_exam.add(new Exam("Đề số 3"));
        arr_exam.add(new Exam("Đề số 4"));
        arr_exam.add(new Exam("Đề số 5"));
        arr_exam.add(new Exam("Đề số 6"));
        arr_exam.add(new Exam("Đề số 7"));
        arr_exam.add(new Exam("Đề số 8"));
        examAdapter = new ExamAdapter(getActivity(),arr_exam);
        gvEXam.setAdapter(examAdapter);
        gvEXam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                startActivity(intent);

            }
        });

    }
}
