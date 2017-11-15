package com.example.rorensu.fragment_test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rorensu on 2017/11/14.
 */

public class FragmentOne extends Fragment implements View.OnClickListener {
    private Button mBtn ;
    private TextView txtV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mBtn = (Button) view.findViewById(R.id.id_fragment_one_btn);
        txtV = (TextView) view.findViewById(R.id.id_txt);
        mBtn.setOnClickListener(this);
        return view ;
    }



    @Override
    public void onClick(View v)
    {
        FragmentTwo fTwo = new FragmentTwo();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.id_content, fTwo, "TWO");
        tx.addToBackStack(null);
        tx.commit();
    }
}
