package com.easemob.chatuidemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.easemob.chatuidemo.R;

import java.util.ArrayList;

/**
 * Created by jiang on 2015/10/24.
 */
public class NeswFragment extends Fragment implements View.OnClickListener {
    private ArrayList<Fragment> fragments;
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rb0;
    private RadioButton rb1;
    private RadioButton rb2;
    Fragment1 fragment;
    ContactlistFragment   newfragmen;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frament_news,null);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup1);
        rb0 = (RadioButton) view.findViewById(R.id.radio0);
        rb1 = (RadioButton) view.findViewById(R.id.radio1);
        rb2 = (RadioButton) view.findViewById(R.id.radio2);
        rb0.setOnClickListener(this);
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        fragment=new Fragment1();
        fragments = new ArrayList<Fragment>();
         newfragmen=new ContactlistFragment();
        fragments.add(fragment);
        fragments.add(newfragmen);
        fragments.add(new Fragment3());

        FragmentManager fm = getActivity().getSupportFragmentManager();
        // new一个适配器
        MyPagerAdapter adapter = new MyPagerAdapter(fm);

            fragment.refresh();



        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb0.setChecked(true);
                        break;
                    case 1:
                        rb1.setChecked(true);
                        break;
                    case 2:
                        rb2.setChecked(true);
                        break;

                }
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });

    return  view;
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.radio0:
                viewPager.setCurrentItem(0);
                break;
            case R.id.radio1:
                viewPager.setCurrentItem(1);
                break;
            case R.id.radio2:
                viewPager.setCurrentItem(2);
                break;
        }
    }
    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
    public void on(){
        fragment.refresh();;
    }
    public  void oonc(){
        newfragmen.refresh();;
    }
}
