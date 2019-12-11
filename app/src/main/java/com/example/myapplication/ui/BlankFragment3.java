package com.example.myapplication.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adpter.BaseDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment3 extends BaseDialogFragment {

    private int right, woring, TestSize;
    private TextView right_grage, wrong_grade, coutn_grade;
    private Button tuichu;

    public BlankFragment3() {

    }


    public static BlankFragment3 newInstance(int right, int woring, int TestSize) {
        BlankFragment3 fragment = new BlankFragment3();
        Bundle args = new Bundle();
        args.putInt("TestSize", TestSize);
        args.putInt("right", right);
        args.putInt("woring", woring);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            right = getArguments().getInt("right");
            woring = getArguments().getInt("woring");
            TestSize = getArguments().getInt("TestSize");
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        iniView(view);
        right_grage.setText(String.valueOf(right));
        wrong_grade.setText(String.valueOf(woring));
        coutn_grade.setText(String.valueOf(TestSize-(right+woring)));

                tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
             //   Toast.makeText(getActivity(), "返回", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void iniView(View view) {
        right_grage=view.findViewById(R.id.right_grage);
        wrong_grade=view.findViewById(R.id.wrong_grade);
        coutn_grade=view.findViewById(R.id.coutn_grade);
        tuichu = view.findViewById(R.id.fanhui);
    }

}
