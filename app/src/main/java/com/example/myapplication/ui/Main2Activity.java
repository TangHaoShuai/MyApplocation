package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adpter.GuideAdapter;
import com.example.myapplication.bean.TheTest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Main2Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private String TestPaperID;
    private final int TOPIC_SUCCESS = 1;
    private final int WRONG = 0;
    private String url = "http://47.103.15.111:8080/home/ExerciseJson?val=";
    private ArrayList<TheTest> list = new ArrayList<>();
    private GuideAdapter mGuideAdapter;
    int max, zq, cw;
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case WRONG:
                    Toast.makeText( Main2Activity.this, "请求出错！" + msg.obj, Toast.LENGTH_LONG).show();
                    break;
                case TOPIC_SUCCESS:
                    list = (ArrayList<TheTest>) msg.obj;
                    max = list.size();
                    List<Fragment> fragments = new ArrayList<Fragment>();
                    for (int y = 0; y < list.size(); y++) {
                        Fragment fragment = initFragmenView(list.get(y), list.size());
                        fragments.add(fragment);
                    }
                    mGuideAdapter = new GuideAdapter(getSupportFragmentManager(), fragments);
                    viewPager.setAdapter(mGuideAdapter);
                    break;
            }
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        TestPaperID = intent.getStringExtra("Key");
        init();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getTheText(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Fragment initFragmenView(TheTest topic, int nub) {
        return BlankFragment2.newInstance(topic, nub);
    }

    private void init(){
        viewPager.findViewById(R.id.viewpager);
    }

    private void getTheText(String url){
        Message message=Message.obtain();
        OkHttpClient mOkHttpClient=new OkHttpClient();
        Request request =new Request.Builder().url(url).build();
        Call call=mOkHttpClient.newCall(request);
        try {
            Response response=call.execute();
            String message2=response.body().string();
            JSONObject jsonObject=new JSONObject(message2);
            Gson gson=new Gson();
            TheTest test=gson.fromJson(jsonObject.toString(),TheTest.class);
            message.what=TOPIC_SUCCESS;
            message.obj=test;
        }catch (Exception e){
            message.what=WRONG;
            message.obj=e.getMessage();
            e.printStackTrace();
        }
        handler.sendMessage(message);
    }
}
