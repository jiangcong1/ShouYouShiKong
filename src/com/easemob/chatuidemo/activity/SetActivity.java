package com.easemob.chatuidemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.easemob.chatuidemo.R;


public class SetActivity extends Activity {
    private ImageButton buttons;
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        buttons = (ImageButton) findViewById(R.id.imgbuton);
        buttons.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //当此时打开时，再次点击状态为关闭

                if (isOpen) {
                    buttons.setBackgroundResource(R.drawable.off);
                    isOpen = false;

                } else {
                    //此时关闭时，再次点击状态为开启
                    buttons.setBackgroundResource(R.drawable.on);
                    isOpen = true;

                }
            }
        });

    }


}
