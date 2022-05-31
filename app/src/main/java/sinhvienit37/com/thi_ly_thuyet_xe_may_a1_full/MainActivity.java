package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Cauhoi.DBHelper;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura.BlankFragment;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura.ThiThuFragment;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.DLdaura.TrangChuFragment;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MeoThi.MeoThiBienBao;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MeoThi.MeoThiLyThuyet;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.MeoThi.MeoThiSaHinh;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.OnThi.OnThi;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TrangChuFragment homeFragment = new TrangChuFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();

        DBHelper db = new DBHelper(this);

         //Phương thức xoa database viết vào hàm MainActivity
        db.deleteDataBase();

        try {
            db.createDataBase();
            Toast.makeText(this, "Cập nhật thành công CSDL", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "CSDL đã bị lỗi", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_gioithieu) {
            about();
        }

        return super.onOptionsItemSelected(item);
    }

    private void about(){
        AlertDialog.Builder dialog = new  AlertDialog.Builder(this);
//        dialog.setIcon(R.drawable.)
        dialog.setTitle("Giới thiệu");
        dialog.setMessage("Chào các bạn đến với chương trình Thi Lý Thuyết Xe Máy Hãng A1 trên ứng dụng Android"+
                "\nĐược thiết kế bởi sinh viên Đại học Sư Phạm Kỹ Thuật Vinh"+
                "\nNhóm sinh viên Thực Hiện: "+
                "\n+ Đặng Quang Hợi"+
                "\n+ Tăng Thị Huyền"+
                "\nMọi Thông Tin Xin Liên Hệ:"+
                "\nGmail: Sinhvienit37@Gmail.com"
        );
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    //

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
            TrangChuFragment homeFragment = new TrangChuFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();
        } else if (id == R.id.Thi) {
            ThiThuFragment toanFragment = new ThiThuFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, toanFragment, toanFragment.getTag()).commit();

        }else if (id == R.id.Onthi) {
            OnThi onThiFragment = new OnThi();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, onThiFragment, onThiFragment.getTag()).commit();
         }else if (id == R.id.Meothibb) {
            MeoThiBienBao meoThiBienBao = new MeoThiBienBao();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, meoThiBienBao, meoThiBienBao.getTag()).commit();
        } else if (id == R.id.Meothish) {
            MeoThiSaHinh meoThiSaHinh = new MeoThiSaHinh();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, meoThiSaHinh, meoThiSaHinh.getTag()).commit();
        } else if (id == R.id.Meothilt) {
            MeoThiLyThuyet meoThiLyThuyet = new MeoThiLyThuyet();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, meoThiLyThuyet, meoThiLyThuyet.getTag()).commit();
        }
        else if (id == R.id.demo) {
            BlankFragment blankFragment = new BlankFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, blankFragment, blankFragment.getTag()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
