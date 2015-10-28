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
import com.easemob.chatuidemo.activity.HaveLuckychanceActivity;
import com.easemob.chatuidemo.activity.MaterialFragment;
import com.easemob.chatuidemo.activity.MemberActivity;
import com.easemob.chatuidemo.activity.SearchActivity;
import com.easemob.chatuidemo.adapter.FindAdapter;
import com.easemob.chatuidemo.view.LineGridView;

/**
 * Created by jiang on 2015/10/26.
 */
public class FindFragment extends Fragment {
    private LineGridView gv = null;
    private boolean isFirstLayout = false;
    private int[] resIds = { R.drawable.find_destined,R.drawable.fatecircle,
            R.drawable.game, R.drawable.nearby,
         R.drawable.rioc
    };

    private String[] names = {"有缘人", "缘分圈", "搜附近", "千里约", "娱乐园",
    };
    private Class[] activitys = {HaveLuckychanceActivity.class, MaterialFragment.class, SearchActivity.class, CreditActivity.class, MemberActivity.class};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_find,null);
        {
            gv = (LineGridView) view.findViewById(R.id.gridview1);
            // 监听第一次加载，为了得到gv的实际高传入adapter进行高度适配
            ViewTreeObserver observer = gv.getViewTreeObserver();
            observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                @Override
                public void onGlobalLayout() {
                    // TODO Auto-generated method stub

                    if (!isFirstLayout) {
                        isFirstLayout = true;
                        ListAdapter adapter=new FindAdapter(getActivity(),gv.getHeight()/2,resIds,names);
                        gv.setAdapter(adapter);

                    }
                }
            });

        }
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(getActivity(), activitys[position]);
                startActivity(i);
            }
        });
        return view;
    }

}
