package com.example.rorensu.fragment_test;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final static String TAG = MainActivity.class.getSimpleName();
    private ImageButton imgBtn1;
    private ImageButton imgBtn2;
    private ImageButton imgBtn3;

    private FragmentOne mTab01;
    private FragmentTwo mTab02;
    private FragmentThree mTab03;
    private int flag=0;
    private String[] fragment_name={"mTab01","mTab03","mTab03"};
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection_R(0);


    }

    private void initViews()
    {
        imgBtn1 =(ImageButton)findViewById(R.id.imageButton);
        imgBtn2 =(ImageButton)findViewById(R.id.imageButton2);
        imgBtn3 =(ImageButton)findViewById(R.id.imageButton3);

        imgBtn1.setOnClickListener(this);
        imgBtn2.setOnClickListener(this);
        imgBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton:
                setTabSelection_R(0);
                break;
            case R.id.imageButton2:
                setTabSelection_R(1);
                break;
            case R.id.imageButton3:
                setTabSelection_R(2);
                break;
        }

    }

    private void setTabSelection_R(int index)
    {
        // 重置按钮
        //resetBtn();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index)
        {
            case 0:
                    // 如果MessageFragment为空，则创建一个并添加到界面上

                    mTab01 = new FragmentOne();
                    transaction.add(R.id.id_content, mTab01);
                    //transaction.replace(R.id.id_content, fTwo, "TWO");
                    transaction.addToBackStack(null);
                    Log.e(TAG,"mTab01-if");
                break;
            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab02 = new FragmentTwo();
                    transaction.add(R.id.id_content, mTab02);
                    transaction.addToBackStack(null);
                    Log.e(TAG,"mTab02-if");

                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                // 如果NewsFragment为空，则创建一个并添加到界面上

                    mTab03 = new FragmentThree();
                    transaction.add(R.id.id_content, mTab03);
                    transaction.addToBackStack(null);
                    Log.e(TAG,"mTab03-if");
                break;

        }
        transaction.commit();
    }
/*
    private void setTabSelection(int index)
    {
        // 重置按钮
        resetBtn();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index)
        {
            case 0:

                if (mTab01 == null)
                {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab01 = new FragmentOne();
                    transaction.add(R.id.id_content, mTab01);
                    //transaction.addToBackStack(null);
                    Log.e(TAG,"mTab01-if");

                } else
                {
                    Log.e(TAG,"mTab01-else");
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab01);
                    //transaction.addToBackStack(null);
                }

                break;
            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色

                if (mTab02 == null)
                {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mTab02 = new FragmentTwo();
                    transaction.add(R.id.id_content, mTab02);
                    //transaction.addToBackStack(null);
                    Log.e(TAG,"mTab02-if");
                } else
                {
                    Log.e(TAG,"mTab02-else");
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mTab02);
                    //transaction.addToBackStack(null);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色

                if (mTab03 == null)
                {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    mTab03 = new FragmentThree();
                    transaction.add(R.id.id_content, mTab03);

                    Log.e(TAG,"mTab03-if");
                } else
                {
                    Log.e(TAG,"mTab03-else");
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(mTab03);

                }
                break;

        }
        transaction.commit();
    }*/

    private void hideFragments(FragmentTransaction transaction) {

        if (mTab01 != null)
        {
            //transaction.hide(mTab01);
            transaction.remove(mTab01);
            Log.e(TAG,"hi hi");
        }
        if (mTab02 != null){

            transaction.remove(mTab02);
            //transaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            transaction.remove(mTab03);
            //transaction.hide(mTab03);
        }


    }

    private void resetBtn()
    {

    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.add(R.id.id_content, new FragmentOne(),"ONE");
        tx.commit();
    }
    */
}
