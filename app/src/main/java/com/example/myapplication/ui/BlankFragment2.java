package com.example.myapplication.ui;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Exercise_bean;
import com.squareup.picasso.Picasso;


public class BlankFragment2 extends Fragment implements View.OnClickListener {
    private TextView topic, hint, select;
    private ImageView imageView;
    private RadioGroup option_ment;
    private RadioButton A_rb, B_rb, C_rb, D_rb;
    private LinearLayout lin_select;
    private Exercise_bean.DataBean data;
    int post,count;

    public BlankFragment2() {
        // Required empty public constructor
    }


    public static BlankFragment2 newInstance(Exercise_bean.DataBean data, int post,int count) {
        BlankFragment2 fragment = new BlankFragment2();
        Bundle args = new Bundle();
        args.putSerializable("data", data);
        args.putInt("post",post);
        args.putInt("count",count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           /* mParam1 = (TheTest) getArguments().getSerializable(ARG_PARAM1);*/
            data = (Exercise_bean.DataBean) getArguments().getSerializable("data");
            post=getArguments().getInt("post");
            count=getArguments().getInt("count");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        init(view);

        topic.setText((post + 1) + "、" + data.getQuestion());
        if (data.getUrl().length() != 0) {

         Picasso.with(getActivity())
                    .load(data.getUrl())
                    .fit()
                    .into(imageView);

        } else {
            imageView.setVisibility(View.GONE);
            LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) option_ment.getLayoutParams();
            linearParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            linearParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            linearParams.weight = 0;
            option_ment.setLayoutParams(linearParams);

            A_rb.setPadding(0, 0, 0, 35);
            B_rb.setPadding(0, 0, 0, 35);
            C_rb.setPadding(0, 0, 0, 35);
            D_rb.setPadding(0, 0, 0, 35);
        }


        if (data.getItem4().length()!=0) {
            A_rb.setText("A、" + data.getItem1());
            B_rb.setText("B、" + data.getItem2());
            C_rb.setText("C、" + data.getItem3());
            D_rb.setText("D、" + data.getItem4());
        }

        option_ment.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
              /*  sqldao = new SQLDAO(getActivity(), Integer.valueOf(Subjects), title);*/

                int i = group.indexOfChild(group.findViewById(checkedId));

                RadioButton radioButton = group.findViewById(checkedId);

                radioButton.setText("  " + radioButton.getText());


//                Exercises_DialogFagment df = (Exercises_DialogFagment) getParentFragment();

                if (i + 1 == Integer.valueOf(data.getAnswer())) {
                    setRbStyl(radioButton, getActivity().getResources().getDrawable(R.drawable.trueimg), "#00FF00");
                /*    sqldao.setResult(post, Integer.parseInt(data.getAnswer()));
                    sqldao.close();*/

                    Main2Activity fm=(Main2Activity)getParentFragment();

                  //  fm.viewPager.setCurrentItem(fm.viewPager.getCurrentItem()+1);


                }
                if (i + 1 != Integer.valueOf(data.getAnswer())) {
                    setRbStyl(radioButton, getActivity().getResources().getDrawable(R.drawable.flasimg), "#FF0000");
                 /*   sqldao.setResult(post, i + 1);
                    sqldao.close();*/

                    setLin_selectStyle();
                }

         /*       df.TrueOrFalse();*/
                disableRadioGroup(group, false);
                /*  mInterface.AdvanceFragment();*/
                option_ment.setEnabled(false);
            }
        });
        return view;

    }
    private void setLin_selectStyle() {
        lin_select.setVisibility(View.VISIBLE);
        select.setText("正确答案：" + abcd(Integer.parseInt(data.getAnswer())));
        hint.setText(data.getExplains());
    }

    public void disableRadioGroup(RadioGroup testRadioGroup, Boolean mBoolean) {
        for (int i = 0; i < testRadioGroup.getChildCount(); i++) {
            testRadioGroup.getChildAt(i).setEnabled(mBoolean);
        }
    }

    private static String abcd(int i) {
        switch (i) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
        }
        return null;
    }

    private void setRbStyl(RadioButton radioButton, Drawable drawable, String color) {
        radioButton.setTextColor(Color.parseColor(color));
        radioButton.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }

    private void init(View view) {
        select = view.findViewById(R.id.select);
        hint = view.findViewById(R.id.hint);
        topic = view.findViewById(R.id.topic);
        /*        Test_count = view.findViewById(R.id.test_count);*/

        lin_select = view.findViewById(R.id.lin_select);

        imageView = view.findViewById(R.id.imageView);

        option_ment = view.findViewById(R.id.option_ment);

        A_rb = view.findViewById(R.id.A_rb);
        B_rb = view.findViewById(R.id.B_rb);
        C_rb = view.findViewById(R.id.C_rb);
        D_rb = view.findViewById(R.id.D_rb);


        A_rb.setOnClickListener(this);
        B_rb.setOnClickListener(this);
        C_rb.setOnClickListener(this);
        D_rb.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }
}
