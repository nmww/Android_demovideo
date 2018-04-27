package com.gongsi.activitygroup;


import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ScrollView;

public class ActivityGroup16Activity extends ActivityGroup {
	ScrollView sv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.overridePendingTransition(
        		R.anim.fadein, R.anim.fadeout);
        
        setContentView(R.layout.main);
        
        sv = (ScrollView)findViewById(R.id.containerBody);
        Button b1 = (Button)findViewById(R.id.startActivity1);
        Button b2 = (Button)findViewById(R.id.startActivity2);
        Button b3 = (Button)findViewById(R.id.startActivity3);
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/* 把activity1的界面放入ScrollView中 */
				/*Intent intent = new Intent(ActivityGroup16Activity.this, Activity01.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				String name = "activity01";
				Window subActivity = getLocalActivityManager().
						startActivity(name, intent);
				 启动ActivityGroupActivity 把
				 * 启动，但是启动
				View view1 = subActivity.getDecorView();
				 getDecorView表示得到activity01的根View
				sv.removeAllViews();
				sv.addView(view1);
				 sv是一个ScrollView里面的所有孩子全部删除
				 * 然后把view1加入其中*/
				startMyActivity("activity01", Activity01.class);
			}
		});
        
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			/*	Intent intent = new Intent(ActivityGroup16Activity.this, Activity02.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				String name = "activity02";
				Window subActivity = getLocalActivityManager().
						startActivity(name, intent);
				View view2 = subActivity.getDecorView();
				sv.removeAllViews();
				sv.addView(view2);*/
				startMyActivity("activity02", Activity02.class);
			}
		});
        
        b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startMyActivity("activity03", Activity03.class);
			}
		});
    }
    
    public void startMyActivity(String id, Class <? extends Activity> cls){
    	Intent intent = new Intent(ActivityGroup16Activity.this, cls);
    	/* If set, and the activity being launched is already running in the
      	current task,
      	如果设置FLAG_ACTIVITY_CLEAR_TOP，即将启动Activity，会在当前的ActivityGroup16Activity中运行。
       	then instead of launching a new instance of that activity,
       	而不是把Activity作为一个新的对象来运行
      */
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		  /**
	     * If set, the activity will not be launched if it is already running
	     * at the top of the history stack.
	     * 加了FLAG_ACTIVITY_SINGLE_TOP选项后，
	     * 每次调用getLocalActivityManager（）.startActivity(name, intent);
	     * 时候，会查找name是否之前已经创建，如果已经创建，直接使用之前的，如果没设置，每次都重新创建。
	     */
//		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		/*针对*/
		String name = id;
		Window subActivity = getLocalActivityManager().
				startActivity(name, intent);
		/**
		 * 创建名字为name的intent(其实就是创建里面的Activity)
		 * 如果这个name存在，并且Intent.FLAG_ACTIVITY_SINGLE_TOP
		 * 设置了，系统就会用原来的
		 * 否则系统新建
		 **/
		View view3 = subActivity.getDecorView();
		/*
		 * getDecorView();得到activity1的根View
		 * 不包含标题栏
		 */
		sv.removeAllViews();
		/*
		 * 
		 */
		sv.addView(view3);
    }
}











