package com.example.kevin.managerspendingandincome.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kevin.managerspendingandincome.R;
import com.example.kevin.managerspendingandincome.base.BaseActivity;

public class MainActivity extends BaseActivity {


    ConstraintLayout mLayout;
    TextView mTextviewShowAssets;
    TextView mTextviewShowAssetsMonth;
    TextView mTextviewShowAssetsYear;
    TextView mTextviewIncome;
    TextView mTextviewSpending;
    Button mButtonSpeding;
    Button mButtonSpending;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        onBindView();
    }

    private void onBindView() {
        mLayout = findViewById(R.id.layout);
        mTextviewShowAssets = findViewById(R.id.textview_show_assets);
        mTextviewShowAssetsMonth = findViewById(R.id.textview_show_assets_month);
        mTextviewShowAssetsYear = findViewById(R.id.textview_show_assets_year);
        mTextviewIncome = findViewById(R.id.textview_income);
        mTextviewSpending = findViewById(R.id.textview_spending);
        mButtonSpeding = findViewById(R.id.button_speding);
        mButtonSpending = findViewById(R.id.button_spending);

        mLayout.setOnClickListener(this);
        mTextviewShowAssets.setOnClickListener(this);
        mTextviewShowAssetsMonth.setOnClickListener(this);
        mTextviewShowAssetsYear.setOnClickListener(this);
        mTextviewIncome.setOnClickListener(this);
        mTextviewSpending.setOnClickListener(this);
        mButtonSpeding.setOnClickListener(this);
        mButtonSpending.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        ComponentName componentName = null;
        switch (v.getId()) {
            case R.id.textview_show_assets:
                componentName = new ComponentName(this,ShowAssetsActivity.class);
                break;
            case R.id.textview_show_assets_month:
                break;
            case R.id.textview_show_assets_year:
                break;
            case R.id.textview_income:
                break;
            case R.id.textview_spending:
                break;
            case R.id.button_speding:
                break;
            case R.id.button_spending:
                break;
        }
        if (componentName != null) {
            intent.setComponent(componentName);
            startActivity(intent);
        }
    }
}
