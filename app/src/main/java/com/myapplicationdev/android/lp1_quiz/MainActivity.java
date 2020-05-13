package com.myapplicationdev.android.lp1_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
Button btn;
EditText edt;
ListView list;
ArrayList<String> data;
MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.et);
        btn = findViewById(R.id.btnsubmit);
        list=findViewById(R.id.mylist);
        data=new ArrayList<>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(edt.getText().toString().trim()+"@"+ getDate());
                adapter=new MyAdapter(MainActivity.this,data);
                list.setAdapter(adapter);
                edt.setText("");

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {


                Intent obj=new Intent(MainActivity.this,DetailActivity.class);
                obj.putExtra("vals",data.get(pos));
                startActivity(obj);

            }
        });


    }

    protected String getDate(){
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String formattedDate = df.format(c);
        Log.i("Today's date : ", formattedDate);
        return formattedDate;
    }

}
