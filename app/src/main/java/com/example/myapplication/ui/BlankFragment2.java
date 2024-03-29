package com.example.myapplication.ui;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.bean.Exercise_bean;
import com.squareup.picasso.Picasso;

import static androidx.core.content.ContextCompat.getSystemService;


public class BlankFragment2 extends Fragment implements View.OnClickListener {
    private EditText MultipleChoice;
    private TextView topic, hint, select;
    private ImageView imageView;
    private RadioGroup option_ment;
    private RadioButton A_rb, B_rb, C_rb, D_rb;
    private LinearLayout lin_select;
    private Exercise_bean.DataBean data;
    int post, count;

    public Button submit, tuichu;


    public BlankFragment2() {
        // Required empty public constructor
    }

    public static BlankFragment2 newInstance(Exercise_bean.DataBean data, int post, int count) {
        BlankFragment2 fragment = new BlankFragment2();
        Bundle args = new Bundle();
        args.putSerializable("data", data);
        args.putInt("post", post);
        args.putInt("count", count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            /* mParam1 = (TheTest) getArguments().getSerializable(ARG_PARAM1);*/
            data = (Exercise_bean.DataBean) getArguments().getSerializable("data");
            post = getArguments().getInt("post");
            count = getArguments().getInt("count");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        init(view);

        final Main2Activity main2Activity = (Main2Activity) getParentFragment();
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

        if (data.getItem1().length() == 0) {
            MultipleChoice.setVisibility(View.VISIBLE);
            A_rb.setVisibility(View.GONE);
            B_rb.setVisibility(View.GONE);
        } else if (data.getItem4().length() != 0) {
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
                if (i  == Integer.valueOf(data.getAnswer())) {
                    setRbStyl(radioButton, getActivity().getResources().getDrawable(R.drawable.trueimg), "#00FF00");
                /*    sqldao.setResult(post, Integer.parseInt(data.getAnswer()));
                    sqldao.close();*/
                    Main2Activity fm = (Main2Activity) getParentFragment();
                    //  fm.viewPager.setCurrentItem(fm.viewPager.getCurrentItem()+1);


                    main2Activity.right++;
                }
                if (i  != Integer.valueOf(data.getAnswer())) {
                    setRbStyl(radioButton, getActivity().getResources().getDrawable(R.drawable.flasimg), "#FF0000");
                 /*   sqldao.setResult(post, i + 1);
                    sqldao.close();*/
                    setLin_selectStyle();
                    main2Activity.wrong++;
                }
                /*       df.TrueOrFalse();*/
                disableRadioGroup(group, false);
                /*  mInterface.AdvanceFragment();*/
                /*   option_ment.setEnabled(false);*/
            }
        });


        MultipleChoice.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String val = MultipleChoice.getText().toString();
                if (val.equals(data.getAnswer())) {
                    main2Activity.right++;

                } else {
                    main2Activity.wrong++;
                }
                MultipleChoice.setFocusable(false);
                InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getView().getWindowToken(),0);
                lin_select.setVisibility(View.VISIBLE);
                select.setText("正确答案：" + data.getAnswer());
                hint.setText(data.getExplains());
                select.setGravity(Gravity.LEFT);
                return false;
            }
        });
        return view;

    }



    private void setLin_selectStyle() {
        lin_select.setVisibility(View.VISIBLE);
        select.setText("正确答案：" + abcd(Integer.parseInt(data.getAnswer())));
        hint.setText(data.getExplains());
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



        lin_select = view.findViewById(R.id.lin_select);
        imageView = view.findViewById(R.id.imageView);
        option_ment = view.findViewById(R.id.option_ment);

        MultipleChoice = view.findViewById(R.id.MultipleChoice);

        A_rb = view.findViewById(R.id.A_rb);
        B_rb = view.findViewById(R.id.B_rb);
        C_rb = view.findViewById(R.id.C_rb);
        D_rb = view.findViewById(R.id.D_rb);


        A_rb.setOnClickListener(this);
        B_rb.setOnClickListener(this);
        C_rb.setOnClickListener(this);
        D_rb.setOnClickListener(this);
    }

    public void disableRadioGroup(RadioGroup testRadioGroup, Boolean mBoolean) {
        for (int i = 0; i < testRadioGroup.getChildCount(); i++) {
            testRadioGroup.getChildAt(i).setEnabled(mBoolean);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.A_rb:

                break;
            case R.id.B_rb:

                break;
            case R.id.C_rb:

                break;
            case R.id.D_rb:

                break;
        }
    }
}
