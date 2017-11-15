package com.example.rorensu.fragment_test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by rorensu on 2017/11/14.
 */

public class FragmentThree extends Fragment implements View.OnClickListener {
    private Button mBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        mBtn = (Button) view.findViewById(R.id.id_fragment_three_btn);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        FragmentFour fFour = new FragmentFour();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.id_content, fFour, "Four");
        tx.commit();
    }
}
