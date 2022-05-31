package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Slide;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Cauhoi.Cauhoi;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

public class Hienthiketqua extends AppCompatActivity {
    ArrayList<Cauhoi> arr_Cauhoi = new ArrayList<Cauhoi>();
    int numNoAns = 0;
    int numTrue = 0;
    int numFalse = 0;
    int tongdiem = 0;
    TextView tvDung, tvSai, tvChuatralloi, tvTong, tvKetqua;
    Button btnThoat, btnLuuketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthiketqua);
        Intent intent = getIntent();
        arr_Cauhoi = (ArrayList<Cauhoi>) intent.getExtras().getSerializable("arr_Ques");
        begin();
        Kiemtrakq();
        tongdiem = numTrue * 5;
        tvChuatralloi.setText("" + numNoAns);
        tvDung.setText("" + numTrue);
        tvSai.setText("" + numFalse);
        tvTong.setText("" + tongdiem);

        if (tongdiem >= 80) tvKetqua.setText("Đạt");
        else tvKetqua.setText("Không Đạt");

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Hienthiketqua.this);
                builder.setIcon(R.drawable.tt);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
               builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               });
                builder.show();
            }
        });

//        btnLuuketqua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
    public void begin(){
        tvDung = (TextView)findViewById(R.id.tvDung);
        tvSai = (TextView)findViewById(R.id.tvSai);
        tvChuatralloi = (TextView)findViewById(R.id.tvChuatraloi);
        tvTong = (TextView)findViewById(R.id.tvtongdiem);
       // btnLuuketqua=(Button)findViewById(R.id.btnLuudiem);
        btnThoat = (Button)findViewById(R.id.btnThoat);
        tvKetqua = (TextView) findViewById(R.id.tvKetqua);
    }

    // Kiểm tra kết quả trả về
    public void Kiemtrakq() {
        for (int i = 0; i < arr_Cauhoi.size(); i++) {
            if (arr_Cauhoi.get(i).getTraloi().equals("") == true) {
                numNoAns++;
            } else if (arr_Cauhoi.get(i).getResult().equals(arr_Cauhoi.get(i).getTraloi()) == true) {
                numTrue++;
            } else numFalse++;
        }
    }
}