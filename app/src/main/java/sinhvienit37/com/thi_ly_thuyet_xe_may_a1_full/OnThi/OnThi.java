package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.OnThi;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura.Main2Activity;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura.TrangChuFragment;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MainActivity;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * Sinhvienit37 Lập trình Android - 2016.
 */
public class OnThi extends Fragment {
    private ListView listViewHoc;
    View view;

    private ArrayList<Item> listitem = new ArrayList<Item>();
    int[] icon= {
            R.mipmap.ho1, R.mipmap.ho2, R.mipmap.ho3, R.mipmap.ho4, R.mipmap.ho5,
            R.mipmap.ho6, R.mipmap.ho7, R.mipmap.ho8,R.mipmap.ho9, R.mipmap.ho10,

            R.mipmap.hoc11, R.mipmap.hoc12, R.mipmap.hoc13, R.mipmap.hoc14, R.mipmap.hoc15,
            R.mipmap.hoc16, R.mipmap.hoc17, R.mipmap.hoc18,R.mipmap.hoc19, R.mipmap.hoc20,

            R.mipmap.hoc21, R.mipmap.hoc22, R.mipmap.hoc23, R.mipmap.hoc24, R.mipmap.hoc25,
            R.mipmap.hoc26, R.mipmap.hoc27, R.mipmap.hoc28,R.mipmap.hoc29, R.mipmap.hoc30,

            R.mipmap.hoc31, R.mipmap.hoc32, R.mipmap.hoc33, R.mipmap.hoc34, R.mipmap.hoc35,
            R.mipmap.hoc36, R.mipmap.hoc37, R.mipmap.hoc38,R.mipmap.hoc39, R.mipmap.hoc40,

            R.mipmap.hoc41, R.mipmap.hoc42, R.mipmap.hoc43, R.mipmap.hoc44, R.mipmap.hoc45,
            R.mipmap.hoc46, R.mipmap.hoc47, R.mipmap.hoc48,R.mipmap.hoc49, R.mipmap.hoc50,

            R.mipmap.hoc51, R.mipmap.hoc52, R.mipmap.hoc53, R.mipmap.hoc54, R.mipmap.hoc55,
            R.mipmap.hoc56, R.mipmap.hoc57, R.mipmap.hoc58,R.mipmap.hoc59, R.mipmap.hoc60,

            R.mipmap.hoc61, R.mipmap.hoc62, R.mipmap.hoc63, R.mipmap.hoc64, R.mipmap.hoc65,
            R.mipmap.hoc66, R.mipmap.hoc67, R.mipmap.hoc68,R.mipmap.hoc69, R.mipmap.hoc70,

            R.mipmap.hoc71, R.mipmap.hoc72, R.mipmap.hoc73, R.mipmap.hoc74, R.mipmap.hoc75,
            R.mipmap.hoc76, R.mipmap.hoc77, R.mipmap.hoc78,R.mipmap.hoc79, R.mipmap.hoc80,

            R.mipmap.hoc81, R.mipmap.hoc82, R.mipmap.hoc83, R.mipmap.hoc84, R.mipmap.hoc85,
            R.mipmap.hoc86, R.mipmap.hoc87, R.mipmap.hoc88,R.mipmap.hoc89, R.mipmap.hoc90,

            R.mipmap.hoc91, R.mipmap.hoc92, R.mipmap.hoc93, R.mipmap.hoc94, R.mipmap.hoc95,
            R.mipmap.hoc96, R.mipmap.hoc97, R.mipmap.hoc98,R.mipmap.hoc99, R.mipmap.hoc100,

            R.mipmap.hoc101, R.mipmap.hoc102, R.mipmap.hoc103, R.mipmap.hoc104, R.mipmap.hoc105,
            R.mipmap.hoc106, R.mipmap.hoc107, R.mipmap.hoc108,R.mipmap.hoc109, R.mipmap.hoc110,

            R.mipmap.hoc111, R.mipmap.hoc112, R.mipmap.hoc113, R.mipmap.hoc114, R.mipmap.hoc115,
            R.mipmap.hoc116, R.mipmap.hoc117, R.mipmap.hoc118,R.mipmap.hoc119, R.mipmap.hoc120,

            R.mipmap.hoc121, R.mipmap.hoc122, R.mipmap.hoc123, R.mipmap.hoc124, R.mipmap.hoc125,
            R.mipmap.hoc126, R.mipmap.hoc127, R.mipmap.hoc128,R.mipmap.hoc129, R.mipmap.hoc130,

            R.mipmap.hoc131, R.mipmap.hoc132, R.mipmap.hoc133, R.mipmap.hoc134, R.mipmap.hoc135,
            R.mipmap.hoc136, R.mipmap.hoc137, R.mipmap.hoc138,R.mipmap.hoc139, R.mipmap.hoc140,

            R.mipmap.hoc141, R.mipmap.hoc142, R.mipmap.hoc143, R.mipmap.hoc144, R.mipmap.hoc145,
            R.mipmap.hoc146, R.mipmap.hoc147, R.mipmap.hoc148,R.mipmap.hoc149, R.mipmap.hoc150,


    };

    String[] str ={
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",

            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",  };

    ArrayAdapter<String> adapter;

    public OnThi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Ôn thi");
        return view=inflater.inflate(R.layout.fragment_on_thi, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listViewHoc =(ListView) getActivity().findViewById(R.id.listViewHoc);
        for (int i=0; i<str.length;i++){
            Item item=new Item();
            item.setId("Câu"+(i+1));
            item.setTitle(str[i]);
            item.setIcon(icon[i]);
            listitem.add(item);
        }
        AdapterH adapterh = new AdapterH(getContext(), R.layout.custom_lvhoc, listitem);
        adapterh.notifyDataSetChanged();
        listViewHoc.setAdapter(adapterh);


       listViewHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String str = (String) adapter.getItemAtPosition(position);
                String str3 = (String) adapter.getItem(i);
                Toast.makeText(getActivity(), str3, Toast.LENGTH_SHORT).show();
            }

        });
    }


}



