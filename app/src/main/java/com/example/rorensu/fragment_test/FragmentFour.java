package com.example.rorensu.fragment_test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rorensu on 2017/11/14.
 */

public class FragmentFour extends Fragment {

    private TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        txt = (TextView) view.findViewById(R.id.textView);
        return view ;
    }
}
