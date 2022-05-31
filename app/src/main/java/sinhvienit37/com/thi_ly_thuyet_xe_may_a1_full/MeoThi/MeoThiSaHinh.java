package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MeoThi;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MainActivity;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.OnThi.AdapterH;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.OnThi.Item;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeoThiSaHinh extends Fragment {
    private ListView listViewsh;
    private Button btnthoatsh;
    private ArrayList<Item> listitem = new ArrayList<Item>();
    int[] icon ={R.drawable.sh1, R.drawable.sh2, R.drawable.sh3, R.drawable.sh4, R.drawable.sh5
            , R.drawable.sh6, R.drawable.sh7, R.drawable.sh8,R.drawable.sh9, R.drawable.sh10};
    String[] str = {
            "Xét theo quy tắc từ trước đến sau: Nhất lộ -> Nhị ưu -> Tam đường -> Tứ hướng\n" +
                    "\n" +
                    "Nhất lộ: Xe nào vào giao lộ được quyền đi trước",
            "Nhị ưu: Xe ưu tiên được quyền đi trước (Quân sự-> Công an-> Cứu hỏa-> Cứu thương).",
            "Tam đường: Xe trên đường ưu tiên được quyền đi trước",
            "Tứ hướng: Rẽ phải->>Đi thẳng->> Rẽ trái ",
            "Câu hỏi: “Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?”" +
                    "\n Câu này thứ tự là xe nào có đoạn đường ngắn nhất thì được quyền đi trước.",
            "Câu hỏi: “Theo hướng mũi tên, những hướng nào xe gắn máy đi được?”" +
                    "\n Câu này cần chú ý từ “xe gắn máy”, ở đây nghĩa là cái xe đạp điện. " +
                    "\n Lưu ý có một câu hỏi về xe mô tô, để ý tránh nhầm 2 câu này.",
            "Câu hỏi “Xe nào vi phạm quy tắc giao thông?”" +
                    "\n Câu này lưu ý cái vòng kia là cái vòng của công trình đang thi công dở, " +
                    "không phải vòng xuyến nên xe con quay đầu là sai.",
            "Tiếp theo: Câu hỏi về “Xe nào vi phạm quy tắc giao thông” thì xét “xe con” trước, nếu “xe con vi phạm” thì chọn đáp án “có xe con”; Nếu “xe con không vi phạm” thì loại đáp án có “xe con”, chọn đáp án “không có xe con”.\n" +
                    "\n" +
                    "Ngược lại, câu hỏi về “Xe nào vi chấp hành đúng quy tắc giao thông” thì cũng xét “xe con” trước, nếu “xe con chấp hành“ thì chọn đáp án “có xe con”; nếu “xe con không chấp hành“ thì loại đáp án có “xe con”.",
            "Tiếp theo, trong câu hỏi “Những xe nào vi phạm quy tắc giao thông”->> Chọn đáp án có từ “Xe con(E)”",
            "Câu hỏi mà đáp án có từ “Xe của bạn” thì đếm số hướng (Ngã 3, ngã 4) sau đó trừ 1  là ra đáp án. Ví dụ 3 hướng thì đáp án là (2)"};

    public MeoThiSaHinh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Mẹo Thi Sa Hình");
        return inflater.inflate(R.layout.fragment_meo_thi_sa_hinh, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listViewsh =(ListView) getActivity().findViewById(R.id.listViewsh);
        for (int i=0; i<str.length;i++){
            Item item=new Item();
            item.setId(" "+(i+1));
            item.setTitle(str[i]);
            item.setIcon(icon[i]);
            listitem.add(item);
        }
        Adapter adapter = new Adapter((Activity) getContext(), R.layout.custom_listview, listitem);
        adapter.notifyDataSetChanged();
        listViewsh.setAdapter(adapter);

    }


}