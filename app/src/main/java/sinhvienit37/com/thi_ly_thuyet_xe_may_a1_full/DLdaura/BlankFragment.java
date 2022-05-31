package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.util.Map;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MainActivity;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

private ImageView img1;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("demo");
        return inflater.inflate(R.layout.fragment_blank, container, false);
//        img1 = (ImageView)  getActivity().findViewById(R.id.img1);

    }
//    gvEXam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
//            startActivity(intent);
//
//        }
//    });


    public Map<Integer, Object> beginTransaction() {
        return null;
    }
}
