package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MeoThi;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MainActivity;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.OnThi.AdapterH;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.OnThi.Item;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeoThiBienBao extends Fragment {
    private ListView listViewbb;
    private ArrayList<Item> listitem = new ArrayList<Item>();
    int[] icon ={R.drawable.bb1, R.drawable.bb2, R.drawable.bb3, R.drawable.bb4, R.drawable.bb5
            , R.drawable.bb6, R.drawable.bb7, R.drawable.bb8,R.drawable.bb9, R.drawable.bb10,
            R.drawable.bb11, R.drawable.bb12, R.drawable.bb13, R.drawable.bb14};
    String[] str = {
            "Phần biển báo bạn buộc phải nhớ tên và ý nghĩa của từng biển báo thì mới làm được vì đây là phần rất dễ nhầm lẫn. Tuy nhiên bạn cần chú ý một vài quy tắc sau đây:\n" +
                    "\n" +
                    "Chú ý phân biệt 3 biển báo sau: \"\\n\"Biển 1: Có tên là “Giao nhau với đường không ưu tiên”, nghĩa là mình đang đi trên đường lớn (ưu tiên) mà gặp đường bé (ko ưu tiên) cắt ngang qua. Gặp biển này mình được quyền qua nơi giao nhau(được đi trước).\n" +
                    "\n" +
                    "Biển 2: Có tên là “Giao nhau với đường ưu tiên”, biển này ngược lại với biển 1, nghĩa là mình đang đi trên đường bé (ko ưu tiên) gặp đường lớn cắt ngang qua (đường ưu tiên). Gặp biển này mình phải dừng lại nhường đường.\n" +
                    "\n" +
                    "Biển 3: Có tên là “Bắt đầu đoạn đường ưu tiên”, gặp biển này người đang đi trên đường được quyền đi trước",
            "Lưu ý tên và ý nghĩa của 3 biển tiếp theo:\n" +
                    "\nBiển số 1 có tên là “Nhường đường cho người đi bộ”, Gặp biển này các phương tiện chú ý quan sát và nhường đường cho người đi bộ.\n" +
                    "Biển số 2 có tên là “cấm người đi bộ”. Gặp biển này người đi bộ không được phép đi vào.\n" +
                    "Biển số 3 có tên là “Chỉ dành cho người đi bộ”, gặp biển này các loại phương tiện khác không được phép đi vào.\n" +
                    "Lưu ý: Câu hỏi này thường dễ bị nhầm ở chỗ “Biển số 2 nhưng đáp án lại là 3“. Mong các bạn hết sức lưu ý",
            "Lưu ý tiếp tên và ý nghĩa của 3 biển sau:" +
                    "Biển 1 có tên là “Biển báo hiệu đường 2 chiều”.\n" +
                    "Biển 2 có tên là “Nhường đường cho xe cơ giới đi ngược chiều qua đường hẹp”.\n" +
                    "Biển 3 có tên là “Ưu tiên qua đường hẹp”.",
            "Câu hỏi “Biển nào báo hiệu nguy hiểm giao nhau với đường sắt?“"+ "\n Câu này rất nhiều bạn chọn đáp án là biển 1 và 2. Đáp án phải là biển 1 và 3.",
            "Câu hỏi: “Biển nào báo hiệu “Đường giao nhau” của các tuyến đường cùng cấp?”"+"\n Biển nào có dấu cộng là biểu thị tuyến đường cùng cấp với nhau. ",
            "Câu hỏi: “Biển nào báo hiệu cấm xe mô tô ba bánh đi vào?”" +
                    "\nLưu ý câu này: Mẹo cho dễ nhớ là “cấm xe con thì cấm luôn cả 3 bánh”. Cấm xe mô tô 3 bánh thì đương nhiên cũng cấm luôn cả xe mô tô 2 bánh.",
            "Câu hỏi “Khi gặp biển nào thì xe mô tô 2 bánh được đi vào?”" +
                    "\n Chỉ có biển 1 cấm xe mô tô 2 bánh, 2 biển còn lại không cấm nên vẫn được phép đi vào.",
            "Câu hỏi: “Biển nào xe mô tô hai bánh được đi vào?” " +
                    "\n Biển loại này ý nghĩa của nó là “Cấm các loại xe ở biển phụ đi vào”.",
            "Câu hỏi: “Biển nào báo hiệu cầu vượt liên thông?” " +
                    "\n Câu này chọn 2 cái biển giống nhau.",
            "Câu hỏi: “Biển nào báo hiệu tuyến đường cầu vượt cắt qua?” " +
                    "\n Câu này tương tự câu trên, chọn 2 biển giống nhau.",
            "Câu hỏi: “Biển nào báo hiệu đoạn đường hay xảy ra tai nạn?” " +
                    "\n Câu này rất dễ làm sai, thường nhiều bạn hay chọn đáp án 3, biển 2 và 3. Biển 3 báo hiệu đoạn đường gồ ghề.",
            "Câu hỏi: “Biển nào chỉ dẫn tên đường trên các tuyến đường đối ngoại?”" +
                    "Câu này chọn Biển AH112",
            "Hỏi về biển nào được quay đầu xe, biển nào được rẽ trái?\n" +
                    "\n" +
                    "Nhớ quy tắc sau: “Cấm rẽ trái thì cấm luôn cả quay đầu xe”; Nhưng “Cấm quay đầu xe thì vẫn được rẽ trái”",
            "\nLưu ý: Trong bộ đề thi chỉ có duy nhất câu này có 2 đáp án ở phần biển báo"};


    public MeoThiBienBao() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Mẹo Thi Biển Báo");
        return inflater.inflate(R.layout.fragment_meo_thi_bien_bao, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listViewbb =(ListView) getActivity().findViewById(R.id.listViewbb);
        for (int i=0; i<str.length;i++){
            Item item=new Item();
            item.setId(" "+(i+1));
            item.setTitle(str[i]);
            item.setIcon(icon[i]);
            listitem.add(item);
        }
        Adapter adapter = new Adapter((Activity) getContext(), R.layout.custom_listview, listitem);
        adapter.notifyDataSetChanged();
        listViewbb.setAdapter(adapter);

    }


}