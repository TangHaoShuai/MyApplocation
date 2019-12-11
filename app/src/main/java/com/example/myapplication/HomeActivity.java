package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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



public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
  /*  http://47.103.15.111:8080/demo-0.0.1-SNAPSHOT/home/user?username=123&passWord=123*/
    private EditText user_txt,password_txt;
    private Button login;
    String url="http://47.103.15.111:8080/home/user?username=" ;
     String url2= "&passWord=";
     private final int TOPIC_SUCCESS=1;
     private final int WRONG=1;

     private Handler handler=new Handler(new Handler.Callback() {
         @Override
         public boolean handleMessage(@NonNull Message msg) {
             switch (msg.what){
                 case TOPIC_SUCCESS:
             ArrayList<User_bean>  list= (ArrayList<User_bean>)msg.obj;
//                    if ( list.get(0).getUsername()==null){
//                        Toast.makeText(HomeActivity.this,"用户名或密码错误，请重新输入！",Toast.LENGTH_SHORT).show();
//                 }else {
//                        Toast.makeText(HomeActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(HomeActivity.this,MainActivity.class);
//                        startActivity(intent);
//                    }
                     Toast.makeText(HomeActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                     Intent intent=new Intent(HomeActivity.this,MainActivity.class);
                     startActivity(intent);
                     break;
             }
             return false;
         }
     });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ini();
    }

    private void ini(){
        password_txt=findViewById(R.id.password_txt);
        user_txt=findViewById(R.id.user_txt);
        login=findViewById(R.id.login);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id. login:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        TopicJson(url+   password_txt.getText()+url2+ user_txt.getText());
                    }
                }).start();
                break;
        }
    }

    //得到题目数据
    public void TopicJson(String url) {
        Message message = Message.obtain();
        List<User_bean> practices = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(getRemoteContent(url));
                Gson gson = new Gson();
                User_bean practice = gson.fromJson(jsonObject.toString(), User_bean.class);
                practices.add(practice);

            message.what = TOPIC_SUCCESS;
            message.obj = practices;
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
