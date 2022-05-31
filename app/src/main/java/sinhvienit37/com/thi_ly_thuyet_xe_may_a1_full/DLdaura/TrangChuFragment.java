package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MainActivity;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChuFragment extends Fragment {


    public TrangChuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Thi Lý Thuyết Xe Máy A1");
        return inflater.inflate(R.layout.fragment_trang_chu, container, false);
    }

}
