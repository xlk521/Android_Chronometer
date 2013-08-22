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
		//������ʾʱ��
		chronometer.setBase(SystemClock.elapsedRealtime());
		//������ʾʱ��ĸ�ʽ
		chronometer.setFormat("����ʱ�䣺 %s");
		//��ʼ��ʱ
		chronometer.start();
		//��Ӽ�����
		chronometer.setOnChronometerTickListener(new OnChronometerTickListener() {
			
			@Override
			public void onChronometerTick(Chronometer ch) {
				// TODO Auto-generated method stub
				if (SystemClock.elapsedRealtime() - chronometer.getBase()>=10000) {
					//�˴�Ĭ������Ϊ10s
					//ֹͣ��ʱ
					chronometer.stop();
					//ʱ�䵽�󣬽���app
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
