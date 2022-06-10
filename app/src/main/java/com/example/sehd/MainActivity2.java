package com.example.sehd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        saad data_data =new saad(this,"my_data",null,1);
        Button btn_save =findViewById(R.id.BTN);
        EditText label=findViewById(R.id.lable1);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_data.add_element(label.getText().toString());
            }
        });
    }
}