package com.example.ski_4;

/**
 * Created with IntelliJ IDEA.
 * User: Alyosha
 * Date: 12.10.13
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.view.ViewPager;

import android.view.Menu;

public class Container_Buy extends Activity {
    private ViewPager vp;
    private TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        //setContentView(R.layout.activity_container);
        vp = new ViewPager(this);
        vp.setId(2);
        setContentView(vp);


        mTabsAdapter = new TabsAdapter(this, vp);
        mTabsAdapter.addTab(actionBar.newTab().setText("Date"),
                ChooseDate.class, null);
        mTabsAdapter.addTab(actionBar.newTab().setText("Date End"),
                ChooseDateEnd.class, null);
        mTabsAdapter.addTab(actionBar.newTab().setText("List"),
                ShowList.class, null);
       // mTabsAdapter.setChildrenAdapterReference();
    }

    @Override
    protected void onResume() {
        super.onResume();
    //    mTabsAdapter.setChildrenAdapterReference();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.container, menu);
        return true;
    }

}
