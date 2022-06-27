package com.example.startproject;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navView;
    ViewPager vp;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.first_tab:
                    Toast.makeText(getApplicationContext(), "첫번째 탭 선택", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.second_tab:
                    Toast.makeText(getApplicationContext(), "두번째 탭 선택", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.third_tab:
                    Toast.makeText(getApplicationContext(), "세번째 탭 선택", Toast.LENGTH_LONG).show();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.vp);
        vp.setOffscreenPageLimit(3);//페이지의 개수는 3-5정도로 권장
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        FirstFragment firtsfragment = new FirstFragment();//첫번째(웹뷰)
        adapter.addItem(firtsfragment);

        SecondFragment secondFragment = new SecondFragment();//두번째
        adapter.addItem(secondFragment);

        ThirdFragment thirdFragment = new ThirdFragment();//세번째
        adapter.addItem(thirdFragment);

        vp.setAdapter(adapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {//페이지 변경 관련 리스너
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }//

            @Override
            public void onPageSelected(int position) {
                navView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.first_tab:
                                vp.setCurrentItem(0);
                                break;
                            case R.id.second_tab:
                                vp.setCurrentItem(1);
                                break;
                            case R.id.third_tab:
                                vp.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });
        //navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter
    {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fragmentManager){super(fragmentManager);}

        public void addItem(Fragment item){items.add(item);}

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "페이지 " + position;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }
    }

}
