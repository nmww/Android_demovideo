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
				/* ��activity1�Ľ������ScrollView�� */
				/*Intent intent = new Intent(ActivityGroup16Activity.this, Activity01.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				String name = "activity01";
				Window subActivity = getLocalActivityManager().
						startActivity(name, intent);
				 ����ActivityGroupActivity ��
				 * ��������������
				View view1 = subActivity.getDecorView();
				 getDecorView��ʾ�õ�activity01�ĸ�View
				sv.removeAllViews();
				sv.addView(view1);
				 sv��һ��ScrollView��������к���ȫ��ɾ��
				 * Ȼ���view1��������*/
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
      	�������FLAG_ACTIVITY_CLEAR_TOP����������Activity�����ڵ�ǰ��ActivityGroup16Activity�����С�
       	then instead of launching a new instance of that activity,
       	�����ǰ�Activity��Ϊһ���µĶ���������
      */
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		  /**
	     * If set, the activity will not be launched if it is already running
	     * at the top of the history stack.
	     * ����FLAG_ACTIVITY_SINGLE_TOPѡ���
	     * ÿ�ε���getLocalActivityManager����.startActivity(name, intent);
	     * ʱ�򣬻����name�Ƿ�֮ǰ�Ѿ�����������Ѿ�������ֱ��ʹ��֮ǰ�ģ����û���ã�ÿ�ζ����´�����
	     */
//		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		/*���*/
		String name = id;
		Window subActivity = getLocalActivityManager().
				startActivity(name, intent);
		/**
		 * ��������Ϊname��intent(��ʵ���Ǵ��������Activity)
		 * ������name���ڣ�����Intent.FLAG_ACTIVITY_SINGLE_TOP
		 * �����ˣ�ϵͳ�ͻ���ԭ����
		 * ����ϵͳ�½�
		 **/
		View view3 = subActivity.getDecorView();
		/*
		 * getDecorView();�õ�activity1�ĸ�View
		 * ������������
		 */
		sv.removeAllViews();
		/*
		 * 
		 */
		sv.addView(view3);
    }
}











