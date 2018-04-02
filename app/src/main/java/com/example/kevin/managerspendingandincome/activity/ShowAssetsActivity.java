package com.example.kevin.managerspendingandincome.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.kevin.managerspendingandincome.R;
import com.example.kevin.managerspendingandincome.adapter.ShowAssetsAdapter;
import com.example.kevin.managerspendingandincome.base.BaseActivity;
import com.example.kevin.managerspendingandincome.javabean.AssetsEntity;
import com.example.kevin.managerspendingandincome.ui.PieChartView;
import com.example.kevin.managerspendingandincome.utils.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2018/4/2.
 * https://github.com/yinkaiwen
 */

public class ShowAssetsActivity extends BaseActivity {

    private static final String tag = ShowAssetsActivity.class.getSimpleName();
    ListView mLv;
    private List<AssetsEntity> mData;
    private PieChartView mPieChartView;
    private ShowAssetsAdapter mAdapter;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_show_assets2);
        onBindView();
        init();
    }


    private void onBindView() {
        mLv = findViewById(R.id.lv);
    }

    private void init() {
        getDataFromLocal();
        initView();
    }

    private void initView() {
        mPieChartView = (PieChartView) View.inflate(this, R.layout.activity_show_assets_pie_chartview, null);
        mPieChartView.setData(mData);

        mLv.addHeaderView(mPieChartView);
        mAdapter = new ShowAssetsAdapter(this, mData);
        mLv.setAdapter(mAdapter);
    }


    public void getDataFromLocal() {
        //模拟的数据
        mData = new ArrayList<>();
        mData.add(new AssetsEntity(20000f, "工资"));
        mData.add(new AssetsEntity(10000f, "房租"));
        mData.add(new AssetsEntity(1000f, "利息"));
        mData.add(new AssetsEntity(15000f, "奖金"));
    }
}
