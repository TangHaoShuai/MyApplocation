package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.HomeActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adpter.Home_adpter;
import com.example.myapplication.bean.TheTest;
import com.example.myapplication.bean.User_bean;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends Fragment    {

    private HomeViewModel homeViewModel;
    private ListView listview_home;

    String url = "http://47.103.15.111:8080/home/TheTestJosn";

    private Home_adpter adpter;

    private final int TOPIC_SUCCESS = 1;
    private final int WRONG = 1;


    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case TOPIC_SUCCESS:
                    ArrayList<TheTest> list = (ArrayList<TheTest>) msg.obj;
                    adpter.getData(list);
                    adpter.notifyDataSetChanged();
//                    Toast.makeText(HomeActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(HomeActivity.this, MainActivity.class);
//                    startActivity(intent);
                    break;
            }
            return false;
        }
    });

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        init(root);

        new Thread(new Runnable() {
            @Override
            public void run() {
                TopicJson(url);
            }
        }).start();


        return root;
    }

    private void init(View view) {
        adpter = new Home_adpter(getActivity());
        listview_home = view.findViewById(R.id.listview_home);
        listview_home.setAdapter(adpter);

    }

    public void TopicJson(String url) {
        Message message = Message.obtain();
        List<TheTest> theTests = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(getRemoteContent(url));
            Gson gson = new Gson();
            TheTest theTest = gson.fromJson(jsonObject.toString(), TheTest.class);
            theTests.add(theTest);

            message.what = TOPIC_SUCCESS;
            message.obj = theTests;
        } catch (Exception e) {
            message.what = WRONG;
            message.obj = e.getMessage();
            e.printStackTrace();
        }
        handler.sendMessage(message);
    }

    private String getRemoteContent(String URL) {
        String body = "";
        Request request = new Request.Builder().url(URL).build();
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            body = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }
}