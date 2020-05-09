package com.myapplicationdev.android.lp1_quiz;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<String> data;
    public MyAdapter(Activity activity, ArrayList<String> data){
        this.activity=activity;
        this.data=data;
    }

    @Override
    public int getCount() { return data.size();}

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        View myview;
        if(view==null){
            myview=new View(activity);
            LayoutInflater lf =(LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
            myview=lf.inflate(R.layout.row,null);
            TextView tv1 = myview.findViewById(R.id.tv2);
            TextView tv2 = myview.findViewById(R.id.tv3);

            tv1.setText(getDate());
            tv2.setText(data.get(pos));
            return myview;


        }else
        {
            return myview=view;
        }
    }

    protected String getDate(){
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String formattedDate = df.format(c);
        Log.i("Today's date : ", formattedDate);
        return formattedDate;
    }
}
