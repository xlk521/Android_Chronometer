package com.example.chronometer_text;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

public class MainActivity extends Activity {

	private Chronometer chronometer = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		chronometer = (Chronometer)findViewById(R.id.chronometer1);
		//设置启示时间
		chronometer.setBase(SystemClock.elapsedRealtime());
		//设置显示时间的格式
		chronometer.setFormat("已用时间： %s");
		//开始计时
		chronometer.start();
		//添加监听器
		chronometer.setOnChronometerTickListener(new OnChronometerTickListener() {
			
			@Override
			public void onChronometerTick(Chronometer ch) {
				// TODO Auto-generated method stub
				if (SystemClock.elapsedRealtime() - chronometer.getBase()>=10000) {
					//此处默认设置为10s
					//停止计时
					chronometer.stop();
					//时间到后，结束app
					MainActivity.this.finish();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
