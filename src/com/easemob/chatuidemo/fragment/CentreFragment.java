package com.easemob.chatuidemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.activity.CreditActivity;
import com.easemob.chatuidemo.activity.GritActivity;
import com.easemob.chatuidemo.activity.MaterialFragment;
import com.easemob.chatuidemo.activity.MemberActivity;
import com.easemob.chatuidemo.activity.SetActivity;
import com.easemob.chatuidemo.activity.TaActivity;
import com.easemob.chatuidemo.adapter.MeAdapter;
import com.easemob.chatuidemo.view.LineGridView;


/**
 * Created by jiang on 2015/10/26.
 * 个人中心
 */
public class CentreFragment extends Fragment {
    private LineGridView gv = null;
    private boolean isFirstLayout = false;
    private int[] resIds = { R.drawable.me_ta,
            R.drawable.me_data, R.drawable.me_gift,
            R.drawable.me_credit, R.drawable.me_member,R.drawable.me_setup
    };



    private String[] names = {"TA", "资料", "礼物", "信誉", "会员","设置"
    };
    private Class[] activitys = {TaActivity.class, MaterialFragment.class, GritActivity.class, CreditActivity.class, MemberActivity.class, SetActivity.class};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_me,null);
        {
            gv = (LineGridView) view.findViewById(R.id.me_grid);
            // 监听第一次加载，为了得到gv的实际高传入adapter进行高度适配
            ViewTreeObserver observer = gv.getViewTreeObserver();
            observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                @Override
                public void onGlobalLayout() {
                    // TODO Auto-generated method stub

                    if (!isFirstLayout) {
                        isFirstLayout = true;
                        ListAdapter adapter=new MeAdapter(getActivity(),gv.getHeight()/2,resIds,names);
                        gv.setAdapter(adapter);

                    }
                }
            });
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(getActivity(), activitys[position]);
                    startActivity(i);
                }
            });

        }
        return view;
    }

}
