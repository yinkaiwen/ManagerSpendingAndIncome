package com.example.kevin.managerspendingandincome.base;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.kevin.managerspendingandincome.R;

/**
 * Created by kevin on 2018/3/29.
 * https://github.com/yinkaiwen
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateActivity(savedInstanceState);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity.this.finish();
            }
        });
        afterToolBar();
    }

    /**
     * You should override this method on your Activity instead of normal onCreate();
     *
     * @param savedInstanceState
     */
    abstract protected void onCreateActivity(Bundle savedInstanceState);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        throw new RuntimeException("You should implements this method.");
    }


    protected void afterToolBar(){
//        throw new RuntimeException("You must override this method.");
    }
}
