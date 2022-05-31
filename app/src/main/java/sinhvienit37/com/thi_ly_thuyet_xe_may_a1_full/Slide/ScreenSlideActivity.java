package sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Slide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Cauhoi.Cauhoi;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.Cauhoi.KetNoiCauHoi;
import sinhvienit37.com.thi_ly_thuyet_xe_may_a1_full.R;

public class ScreenSlideActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 20;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    private  TextView tvTimer, tvXemdiem;
    public int checkAns = 0;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    TextView tvKiemtra;


    //CSDL
    KetNoiCauHoi questionController;
    ArrayList<Cauhoi> arr_Ques;
    CounterClass timer;
    int totalTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());

        totalTimer=15;
        timer=new CounterClass(totalTimer*60*1000, 1000);
        questionController= new KetNoiCauHoi(this);
        arr_Ques= new ArrayList<Cauhoi>();
        arr_Ques = questionController.getQuestion(1,"thi");

        tvKiemtra= (TextView) findViewById(R.id.tvKiemTra);
        tvTimer= (TextView) findViewById(R.id.tvTimer);
        tvXemdiem= (TextView) findViewById(R.id.tvScore);
        tvKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kiemtraAnswer();
            }
        });
        tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvXemdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent1 = new Intent(ScreenSlideActivity.this,Hienthiketqua.class);
                intent1.putExtra("arr_Ques", arr_Ques);
                startActivity(intent1);
            }
        });
        timer.start();
    }

    //Tạo một phương thức lấy dữ diệu cho fragmentslider.
    public ArrayList<Cauhoi> getData() {
        return arr_Ques;
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position, checkAns);// truyền giá trị khởi tạo bằng 0

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
     public void  kiemtraAnswer(){
         final Dialog dialog = new Dialog(this);
         dialog.setContentView(R.layout.check_answer);
         dialog.setTitle("Danh sách câu trả lời");

         KiemtraAnswer kiemtraAnswer = new KiemtraAnswer(arr_Ques, this);
         GridView gvlsCauhoi= (GridView) dialog.findViewById(R.id.gvLsCauhoi);
         gvlsCauhoi.setAdapter(kiemtraAnswer);

        gvlsCauhoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });
         Button btnCancle, btnFinnish;
         btnCancle = (Button) dialog.findViewById(R.id.btnCancle);
         btnFinnish = (Button) dialog.findViewById(R.id.btnFinish);
         btnCancle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dialog.dismiss();
             }
         });
         btnFinnish.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 timer.cancel();
                 result();
                 dialog.dismiss();
             }
         });
         dialog.show();
     }
    public void result(){
        checkAns =1;
        if(mPager.getCurrentItem()>=4)mPager.setCurrentItem(mPager.getCurrentItem()-4);
        else if (mPager.getCurrentItem()<=4)mPager.setCurrentItem(mPager.getCurrentItem()+4);
        tvXemdiem.setVisibility(View.VISIBLE);
        tvKiemtra.setVisibility(View.GONE);
    }
    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */



        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

            tvTimer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");  //SetText cho textview hiện thị thời gian.
        }
    }


}