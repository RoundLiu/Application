package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends Activity {
    TextView welcomeTv;
    Button backBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2_layout_activity);
        welcomeTv = (TextView)findViewById(R.id.welcomeTvId);
        backBt = (Button) findViewById(R.id.backBtId);
        Intent intent=getIntent();
        welcomeTv.setText("当前登陆用户为："+ intent.getExtras().getString("abc"));
        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", "用户退出了");
                setResult(1, intent);
                finish();
            }
        });
    }
}
