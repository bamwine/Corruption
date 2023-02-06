package com.example.tabs;

import tabsswipe.adapter.TabsPagerAdapter;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

			private ViewPager viewPager;
			private TabsPagerAdapter mAdapter;
			private ActionBar actionBar;
			// Tab titles
			private String[] tabs = { "HOME", "TOOLS", "REPORT" };
			private int[] icon={R.drawable.home,R.drawable.tools,R.drawable.repot};
			
			@Override
			protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			// Initilization
			viewPager = (ViewPager) findViewById(R.id.pager);
			actionBar = getActionBar();
			mAdapter = new TabsPagerAdapter(getSupportFragmentManager());			
			viewPager.setAdapter(mAdapter);
			actionBar.setHomeButtonEnabled(false);
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);       
			for(int k=0;k<tabs.length;k++){
				// Adding Tabs	
				//if(icon[k]==0)
					
			    actionBar.addTab(actionBar.newTab().setText(tabs[k]).setIcon(icon[k]).setTabListener(this));
			
			}
			/**
			 * on swiping the viewpager make respective tab selected
			 * */
			viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			    @Override
			    public void onPageSelected(int position) {
			        // on changing the page
			        // make respected tab selected
			        actionBar.setSelectedNavigationItem(position);
			    }
			
			    @Override
			    public void onPageScrolled(int arg0, float arg1, int arg2) {
			    }
			
			    @Override
			    public void onPageScrollStateChanged(int arg0) {
			    }
			});
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// on tab selected
			// show respected fragment view
			viewPager.setCurrentItem(tab.getPosition());
			}
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			}
			
			}