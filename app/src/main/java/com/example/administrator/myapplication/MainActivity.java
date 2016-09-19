package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button b1;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        b1=(Button) findViewById(R.id.button);
        editText=(EditText) findViewById(R.id.textView2) ;
        onClickMethod();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0&&resultCode==1){

            b1.setText(data.getExtras().getString("result").toString());
        }

    }

    public void onClickMethod(){
        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("abc",editText.getText().toString());
                startActivityForResult(intent,0);

                Toast.makeText(getApplicationContext(),"即将转跳到下一页",Toast.LENGTH_LONG).show();
                return false;
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                Intent intent=new Intent(MainActivity.this,GotoActivity.class);
                startActivity(intent);
            }
        });

    }

}
