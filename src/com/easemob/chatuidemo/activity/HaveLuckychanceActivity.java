package com.easemob.chatuidemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import com.easemob.chatuidemo.R;


public class HaveLuckychanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_have_luckychance);
    }
}
