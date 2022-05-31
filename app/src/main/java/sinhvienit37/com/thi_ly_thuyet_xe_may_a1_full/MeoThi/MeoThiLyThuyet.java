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
public class MeoThiLyThuyet extends Fragment {
    private ListView listViewlt;
    private Button btnthoatsh;
    private ArrayList<Item> listitem = new ArrayList<Item>();
    int[] icon ={R.drawable.hoc10, R.drawable.hoc10, R.drawable.hoc10, R.drawable.hoc10, R.drawable.hoc10
            , R.drawable.hoc10, R.drawable.hoc10, R.drawable.hoc10,R.drawable.hoc10, R.drawable.hoc10,
            R.drawable.hoc10, R.drawable.hoc10, R.drawable.hoc10, R.drawable.hoc10, R.drawable.hoc10
            , R.drawable.hoc10, R.drawable.hoc10, R.drawable.hoc10,R.drawable.hoc10,

    };
    String[] str = {
            "Những câu có 2 đáp án mà trong câu hỏi có xuất hiện từ “Những” hoặc từ “Các” thi chọn cả 2 đáp án(cái này luôn luôn đúng)." +
                    "\"vì thế trong câu ưu tiên xét cái này trước, nhớ là chỉ đúng cho câu hỏi có 2 đáp án thôi nhé, câu nào 3 đáp án thì không còn đúng nữa).",
            "Những câu mà trong dấu ngoặc kép ” “ có các từ: Vạch – phố– dải – phần –>> Chọn đáp án (1)",
            "Những câu mà trong dấu ngoặc kép ” “ có các từ: Ưu – phương- làn –>> Chọn đáp án (2)",
            "Những câu hỏi về hành vi bị nghiêm cấm mà trong đáp án có xuất hiện các từ như: “Bị nghiêm cấm”, “Không được phép”, “Không được mang, vác”." +
                    "\"“Là thiếu văn hóa giao thông”…Những câu đại loại tương tự như vậy thì chọn đáp án đó.",
            "Hỏi về người điều khiển giao thông: Có từ “Giang tay” ->> Chọn đáp án (1); “Giơ tay”->> Chọn đáp án (2).",
            "Trong đáp án mà có các con số sau đây là đáp án: 5 mét, 5 năm, 0.25miligam, 50miligam, 18 tuổi, 40km/h.",
            "Ưu tiên chấp hành theo hiệu lệnh của “người điều khiển giao thông” và “biển báo hiệu tạm thời“",
            "Tại nơi giao nhau “Không có báo hiệu đi theo vòng xuyến” ->> Chọn đáp án “Nhường đường cho người đi từ bên phải tới”;" +
                    "\"Ngược lại “Có biển báo đi theo vòng xuyến” ->> Chọn đáp án “Nhường đường cho người đi từ bên trái tới”",
            "Hỏi ở “trên cầu”, “trong đường hầm” có được quay đầu xe hay không?" +
                    "\"–>> Chọn đáp án “Không được quay đầu xe”, nhớ kỹ bất cứ trường hợp nào trong hầm hay trên cầu vượt cũng “không được phép quay đầu xe”.",
            "Câu hỏi về tốc độ tối đa cho phép là 40km/h hoặc 50km/h->> Chọn đáp án có từ “Xe gắn máy” ở cuối câu.",
            "Câu hỏi “Đảm bảo trật tự, an toàn giao thông là trách nhiệm của ai?” ->> Chọn đáp án “Là trách nhiệm của cơ quan, tổ chức, cá nhân”." +
                    "\"Nghĩa là tất cả mọi người đều phải có trách nhiệm bảo đảm trật tự an toàn giao thông.",
            "Với những câu hỏi và đáp án dài thì kinh nghiệm là đáp án nào ngắn đọc trước." +
                    "\" Nếu đáp án đó sai thì chọn 2 đáp án dài còn lại.",
            "Câu hỏi “Khi muốn chuyển hướng, người lái xe phải thực hiện như thế nào?” Với câu này thì nên đọc hiểu" +
                    "\"Ví dụ như khi muốn chuyển hướng cần phải giảm tốc độ và phải xi nhan để cho phương tiện phía sau biết.",
            "Câu hỏi “Khi tránh xe đi ngược chiều, các xe phải nhường đường như thế nào?“." +
                    "\"Đáp án là 1 và 2. Tại sao xe xuống dốc phải nhường đường cho xe lên dốc là do tầm nhìn của xe xuống dốc rộng hơn so với tầm nhìn của xe đang lên dốc. ",
            "Câu hỏi “Trên dường bộ giao nhau cùng mức với đường sắt." +
                    "\"cầu đường bộ đi chúng với đường sắt thì loại phương tiện nào được quyền ưu tiên đi trước?”",
            "Câu hỏi “Người điều khiển phương tiện tham gia giao thông trong hầm đường bộ ngoài việc phải tuân thủ các quy tắc giao thông còn phải thực hiện những quy định nào dưới đây?”",
            "Câu hỏi “Người ngồi trên xe mô tô 2 bánh, xe mô tô 3 bánh, xe gắn máy phải đội mũ bảo hiểm có cài quai đúng quy cách khi nào?”. Bất cứ khi nào tham gia giao thông đều phải đội mũ bảo hiểm.",
            "Câu hỏi “Khi điều khiển xe chạy trên đường, người lái xe phải mang theo các loại giấy tờ gì?”. Đáp án số 3 đúng, bởi vì xe ô tô thì không được phép mang giấy phép lái xe của xe máy và ngược lại.",
            "Câu hỏi “Cơ quan nào quy định đoạn đường cấm đi, đường đi một chiều, nơi cấm dừng, cấm đỗ, cấm quay đầu xe, lắp đặt biển báo hiệu đường bộ thuộc địa phương quản lý?“." +
                    "\"Câu này chọn đáp án Ủy ban nhân dân cấp tỉnh bởi vì các cơ quan khác còn lại chỉ có nhiệm vụ thi hành, Ủy ban nhân dân cấp tỉnh là đơn vị quyền lực cao nhất ở địa phương.",
            };

    public MeoThiLyThuyet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Mẹo Thi Lý Thuyết");
        return inflater.inflate(R.layout.fragment_meo_thi_ly_thuyet, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listViewlt =(ListView) getActivity().findViewById(R.id.listViewlt);
        for (int i=0; i<str.length;i++){
            Item item=new Item();
            item.setId(" "+(i+1));
            item.setTitle(str[i]);
            item.setIcon(icon[i]);
            listitem.add(item);
        }
        Adapter adapter = new Adapter((Activity) getContext(), R.layout.custom_listview, listitem);
        adapter.notifyDataSetChanged();
        listViewlt.setAdapter(adapter);

    }


}