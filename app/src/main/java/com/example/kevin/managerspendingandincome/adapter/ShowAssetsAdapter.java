package com.example.kevin.managerspendingandincome.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kevin.managerspendingandincome.R;
import com.example.kevin.managerspendingandincome.javabean.AssetsEntity;
import com.example.kevin.managerspendingandincome.ui.PieChartView;

import java.util.List;

/**
 * Created by kevin on 2018/4/2.
 * https://github.com/yinkaiwen
 */

public class ShowAssetsAdapter extends BaseAdapter {

    private Context mContext;
    private List<AssetsEntity> mData;

    public ShowAssetsAdapter(Context context, List<AssetsEntity> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.activity_show_assets_text,null);
            holder = new ViewHolder();
            holder.mViewColor = convertView.findViewById(R.id.view_color);
            holder.mTextAssets = convertView.findViewById(R.id.text_assets);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        AssetsEntity assetsEntity = mData.get(position);
        float total = calTotal();
        int color = PieChartView.sPaintColor[position % PieChartView.sPaintColor.length];
        holder.mViewColor.setBackgroundColor(color);


        float percent = calculatePercent(total, mData.get(position).data);
        String text = String.format("%s : %s 占比 : %.2f", assetsEntity.name, assetsEntity.data, percent)+"%";
        holder.mTextAssets.setText(text);


        return convertView;
    }

    private class ViewHolder{
        View mViewColor;
        TextView mTextAssets;
    }

    private float calTotal() {
        if (mData == null || mData.size() == 0) {
            return 0;
        }
        float total = 0f;
        for (int i = 0; i < mData.size(); i++) {
            total += mData.get(i).data;
        }
        return total;
    }

    private float calculatePercent(float total, float per) {
        return (per / total * 100);
    }
}
