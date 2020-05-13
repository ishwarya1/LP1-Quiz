package com.myapplicationdev.android.lp1_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tvInfo;
    Button btnEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvInfo=findViewById(R.id.tvInfo);
        btnEmail=findViewById(R.id.btnEmail);
        Bundle bun=getIntent().getExtras();
        String vals[]=bun.getString("vals").split("@");


        tvInfo.setText(vals[1].toString()+"\n\n"+vals[0].toString());
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "LP1 Quiz:18016638");
                intent.putExtra(Intent.EXTRA_TEXT, "Date Created :"+ tvInfo.getText().toString().trim());

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });

    }
}
