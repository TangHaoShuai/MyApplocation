package com.example.myapplication.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.TheTest;

import java.util.ArrayList;
import java.util.List;

public class Home_adpter extends BaseAdapter {

    private Context context;

    private ArrayList<TheTest.DataBean> theTests = new ArrayList<>();

    public void getData(ArrayList<TheTest> theTests) {
        this.theTests = (ArrayList) theTests.get(0).getData();
    }

    public Home_adpter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return theTests.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.item_home_listview, null, false);

        TextView theName, theStartTime, State, theEndOfTime;
        theName = v.findViewById(R.id.theName);
        theStartTime = v.findViewById(R.id.theStartTime);
        State = v.findViewById(R.id.State);
        theEndOfTime = v.findViewById(R.id.theEndOfTime);

        theName.setText(theTests.get(i).getTheName());
        theStartTime.setText("开始时间" + theTests.get(i).getTheStartTime());
        State.setText(theTests.get(i).getState());
        theEndOfTime.setText("结束时间" + theTests.get(i).getTheEndOfTime());


        return v;
    }


}
