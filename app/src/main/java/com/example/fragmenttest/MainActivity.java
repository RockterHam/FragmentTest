package com.example.fragmenttest;

import android.content.pm.ActivityInfo;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //底部菜单栏4个TextView
    private ImageView mImageHome;
    private ImageView mImageOrder;
    private ImageView mImageCommunity;
    private ImageView mImageMine;

    //4个Fragment
    private Fragment mHome;
    private Fragment mOrder;
    private Fragment mCommunity;
    private Fragment mMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        //初始化
        init();
        //设置第一个Fragment默认显示
        setFragment(0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;
            case R.id.home:
                setFragment(0);
                break;
            case R.id.order:
                setFragment(1);
                break;
            case R.id.community:
                setFragment(2);
                break;
            case R.id.mine:
                setFragment(3);
                break;
        }
    }

    private void init(){
        //初始化控件
        mImageHome = (ImageView)findViewById(R.id.home);
        mImageOrder = (ImageView) findViewById(R.id.order);
        mImageCommunity = (ImageView) findViewById(R.id.community);
        mImageMine = (ImageView) findViewById(R.id.mine);

        //设置监听
        mImageHome.setOnClickListener(this);
        mImageOrder.setOnClickListener(this);
        mImageCommunity.setOnClickListener(this);
        mImageMine.setOnClickListener(this);
    }

    private void setFragment(int index){
        //获取Fragment管理器
        FragmentManager mFragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        //隐藏所有Fragment
        hideFragments(mTransaction);
        switch (index){
            default:
                break;
            case 0:
                //设置菜单栏为选中状态（修改文字和图片颜色）
               /* mImageHome.setTextColor(getResources()
                        .getColor(R.color.colorTextPressed));*/
                mImageHome.setImageResource(R.drawable.ic_home_on);
                //显示对应Fragment
                if(mHome == null){
                    mHome = new HomeFragment();
                    mTransaction.add(R.id.container, mHome,
                            "home_fragment");
                }else {
                    mTransaction.show(mHome);
                }
                break;
            case 1:
              /*  mImageOrder.setTextColor(getResources()
                        .getColor(R.color.colorTextPressed));*/
                mImageOrder.setImageResource(R.drawable.ic_order_on);
                if(mOrder == null){
                    mOrder = new OrderFragment();
                    mTransaction.add(R.id.container, mOrder,
                            "Order_fragment");
                }else {
                    mTransaction.show(mOrder);
                }
                break;
            case 2:
              /*  mImageCommunity.setTextColor(getResources()
                        .getColor(R.color.colorTextPressed));*/
                mImageCommunity.setImageResource(R.drawable.ic_community_on);
                if(mCommunity == null){
                    mCommunity = new CommunityFragment();
                    mTransaction.add(R.id.container, mCommunity,
                            "community_fragment");
                }else {
                    mTransaction.show(mCommunity);
                }
                break;
            case 3:
              /*  mImageMine.setTextColor(getResources()
                        .getColor(R.color.colorTextPressed));*/
                mImageMine.setImageResource(R.drawable.ic_mine_on);
                if(mMine == null){
                    mMine = new MineFragment();
                    mTransaction.add(R.id.container, mMine,
                            "mine_fragment");
                }else {
                    mTransaction.show(mMine);
                }
                break;
        }
        //提交事务
        mTransaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction){
        if(mHome != null){
            //隐藏Fragment
            transaction.hide(mHome);
            //将对应菜单栏设置为默认状态
          /*  mImageHome.setTextColor(getResources()
                    .getColor(R.color.colorText));*/
            mImageHome.setImageResource(R.drawable.ic_home_off);
        }
        if(mOrder != null){
            transaction.hide(mOrder);
           /* mImageOrder.setTextColor(getResources()
                    .getColor(R.color.colorText));*/
            mImageOrder.setImageResource(R.drawable.ic_order_off);
        }
        if(mCommunity != null){
            transaction.hide(mCommunity);
            /*mImageCommunity.setTextColor(getResources()
                    .getColor(R.color.colorText));*/
            mImageCommunity.setImageResource(R.drawable.ic_community_off);
        }
        if(mMine != null) {
            transaction.hide(mMine);
            /*mImageMine.setTextColor(getResources()
                    .getColor(R.color.colorText));*/
            mImageMine.setImageResource(R.drawable.ic_mine_off);
        }
    }
}