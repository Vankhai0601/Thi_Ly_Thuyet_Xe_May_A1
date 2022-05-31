package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Slide;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Cauhoi.Cauhoi;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {

    ArrayList<Cauhoi> arr_Ques = new ArrayList<Cauhoi>();
    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";
    public int checkAns; // Biến kiểm tra câu hỏi

    private int mPageNumber;  //Số trang hiện tại

    TextView tvND, tvSTT;
    RadioButton rad1, rad2, rad3, rad4;
    RadioGroup radioGroup;
    ImageView img;
    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    //Lấy số trang hiện tại
    public static ScreenSlidePageFragment create(int pageNumber,int checkAnswer) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putInt(ARG_CHECKANSWER,checkAnswer);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tvND = (TextView) rootView.findViewById(R.id.tvQuestion);
        tvSTT = (TextView) rootView.findViewById(R.id.tvNum);
        rad1 = (RadioButton) rootView.findViewById(R.id.rad1);
        rad2 = (RadioButton) rootView.findViewById(R.id.rad2);
        rad3 = (RadioButton) rootView.findViewById(R.id.rad3);
        rad4 = (RadioButton) rootView.findViewById(R.id.rad4);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);
        img = (ImageView) rootView.findViewById(R.id.imageView3);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Lấy mảng dữ liệu từ ScreenSliderActivity
        ScreenSlideActivity sliderActivity = (ScreenSlideActivity) getActivity();
        arr_Ques = sliderActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns = getArguments().getInt(ARG_CHECKANSWER);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvSTT.setText("Câu " + (mPageNumber + 1));
        tvND.setText(arr_Ques.get(mPageNumber).getQuestion());
        rad1.setText(getItem(mPageNumber).getAns_1());
        rad2.setText(getItem(mPageNumber).getAns_2());
        rad3.setText(getItem(mPageNumber).getAns_3());
        rad4.setText(getItem(mPageNumber).getAns_4());
        if(checkAns!=0){
            rad1.setClickable(false);
            rad2.setClickable(false);
            rad3.setClickable(false);
            rad4.setClickable(false);
            getcheckAns(getItem(mPageNumber).getResult().toString());
        }


        String nameimg= getItem(mPageNumber).getImage();

        int idimg = getResources().getIdentifier(nameimg,"mipmap", getContext().getPackageName());
        img.setImageResource(idimg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getItem(mPageNumber).choiID = checkedId;
                getItem(mPageNumber).setTraloi(getchoiFromID(checkedId));
            }
        });
    }
public Cauhoi getItem(int position){
    return arr_Ques.get(position);
}
    //Lấy vị trí của radioGtoup chuyển thành đáp án 1/2/3/4.
    private String getchoiFromID(int ID) {
        if (ID == R.id.rad1) {
            return "1";
        } else if (ID == R.id.rad2) {
            return "2";
        } else if (ID == R.id.rad3) {
            return "3";
        } else if (ID == R.id.rad4) {
            return "4";
        } else return "";
    }
        // Hàm kiểm tra câu đúng, nếu câu đúng thì dược khoanh tròn màu background tương ứng
        private void getcheckAns(String ans){
        if(ans.equals("1")==true){
            rad1.setBackgroundColor(Color.YELLOW);
        }else if(ans.equals("2")==true){
            rad2.setBackgroundColor(Color.YELLOW);
        }else if(ans.equals("3")==true){
            rad3.setBackgroundColor(Color.YELLOW);
        }else if(ans.equals("4")==true){
            rad4.setBackgroundColor(Color.YELLOW);
        }else;

    }
    }



