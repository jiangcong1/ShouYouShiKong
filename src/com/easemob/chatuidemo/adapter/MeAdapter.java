package com.easemob.chatuidemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.utils.MonitorItem;

import java.util.ArrayList;

/**
 * Created by jiang on 2015/10/14.
 */
public class MeAdapter extends BaseAdapter {

    private ArrayList<MonitorItem> data = new ArrayList<MonitorItem>();

    private Context context;
    private LayoutInflater inflater;

    private int resIds[];
    private String names[];
    private int itemH;

    public MeAdapter(Context context, int itemH, int resIds[], String names[]) {

        this.context = context;
        this.itemH = itemH;
        this.resIds = resIds;
        this.names = names;
        inflater = LayoutInflater.from(context);
        // 初始化数据+
        data.clear();
        for (int i = 0; i < resIds.length; i++) {
            data.add(new MonitorItem(names[i], resIds[i]));
        }
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.me_grid_item, null);
            viewHolder = new ViewHolder();
            viewHolder.iconIv = (ImageView) convertView
                    .findViewById(R.id.monitor_gv_item_iv_icon);
            viewHolder.nameTv = (TextView) convertView
                    .findViewById(R.id.monitor_gv_item_tv_name);
            convertView.setMinimumHeight(itemH);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MonitorItem monitorItem = data.get(position);
        viewHolder.iconIv.setBackgroundResource(monitorItem.getIconResid());
        viewHolder.nameTv.setText(monitorItem.getName());

        return convertView;
    }

    class ViewHolder {
        ImageView iconIv;
        TextView nameTv;
    }
}
