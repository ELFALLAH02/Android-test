package com.example.sehd;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database mb=new database(this,"sehd",null,1) {};
        Button btn =findViewById(R.id.btnadd);
        EditText username,email,pass;
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mb.addintodatabase(username.getText().toString(),email.getText().toString(),pass.getText().toString());
                username.setText("");
                email.setText("");
                pass.setText("");

            }

        });
        Button btn_list =findViewById(R.id.btnlist);
        ListView lis_tv=findViewById(R.id.list_item);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String>ald=mb.read_it();
                ArrayAdapter<String> ad=new ArrayAdapter<String>(MainActivity.this, android.support.constraint.R.layout.support_simple_spinner_dropdown_item,ald);
                lis_tv.setAdapter(ad);
            }
        });




    }
}