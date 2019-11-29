package com.example.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adpter.BaseDialogFragment;
import com.example.myapplication.adpter.CustomViewPager;
import com.example.myapplication.adpter.GuideAdapter;
import com.example.myapplication.bean.Exercise_bean;
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


public class Main2Activity extends BaseDialogFragment {
    public ViewPager viewPager;
    private String TestPaperID;
    private final int TOPIC_SUCCESS = 1;
    private final int WRONG = 0;
    private String url = "http://47.103.15.111:8080/home/ExerciseJson?val=";

    private GuideAdapter mGuideAdapter;
    int max, zq, cw;
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case WRONG:
                    Toast.makeText( getActivity(), "请求出错！" + msg.obj, Toast.LENGTH_LONG).show();
                    break;
                case TOPIC_SUCCESS:
                 ArrayList<Exercise_bean> list = (ArrayList<Exercise_bean>) msg.obj;
                 /*   max = list.size();*/

                    List<Fragment> fragments = new ArrayList<Fragment>();
                    for (int y = 0; y < list.get(0).getData().size(); y++) {
                        BlankFragment2 fragment = BlankFragment2.newInstance(list.get(0).getData().get(y), y,list.size());
                        fragments.add(fragment);
                    }
                    mGuideAdapter = new GuideAdapter(getChildFragmentManager(), fragments);
                    viewPager.setAdapter(mGuideAdapter);
                    viewPager.setCurrentItem(0);
                    break;

            }
            return true;
        }
    });

    public static Main2Activity newInstance(String data) {
        Main2Activity fragment = new Main2Activity();
        Bundle args = new Bundle();
        args.putString("data",data);
      /*  args.putSerializable("data", data);
        args.putInt("post",post);
        args.putInt("count",count);*/
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main2, container, false);
        init(view);

        Bundle intent = getArguments();
        TestPaperID = intent.getString("Key");
        init(view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                getTheText(url);
            }
        }).start();
        return view;
    }

    private Fragment initFragmenView(Exercise_bean.DataBean topic, int post,int nub) {
        return BlankFragment2.newInstance(topic, post,nub);
    }

    private void init(View view){
        viewPager=view.findViewById(R.id.viewpager);

    }

    private void getTheText(String url){
        ArrayList<Exercise_bean> list = new ArrayList<Exercise_bean>();

        Message message=Message.obtain();
        OkHttpClient mOkHttpClient=new OkHttpClient();
        Request request =new Request.Builder().url(url).build();
        Call call=mOkHttpClient.newCall(request);
        try {
            Response response=call.execute();
            String message2=response.body().string();
            JSONObject jsonObject=new JSONObject(message2);
            Gson gson=new Gson();
            Exercise_bean test=gson.fromJson(jsonObject.toString(),Exercise_bean.class);

            list.add(test);
            message.what=TOPIC_SUCCESS;
            message.obj=list;
        }catch (Exception e){
            message.what=WRONG;
            message.obj=e.getMessage();
            e.printStackTrace();
        }
        handler.sendMessage(message);
    }
}
