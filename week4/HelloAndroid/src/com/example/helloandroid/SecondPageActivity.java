package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondPageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//Android生命周期方法
		setContentView(R.layout.secondpage_main);//设置使用的布局管理器
		
		final TextView text4 = (TextView) super.findViewById(R.id.text4);//取得text1组件
//		text1.setText("你好");//设置text1的显示文字
		final Button btn2=(Button)super.findViewById(R.id.btn2);//取得btn组件/绑定
		
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//btn.setBackgroundColor(TRIM_MEMORY_RUNNING_CRITICAL);
				SecondPageActivity.this.finish();
//				Intent intent = new Intent(SecondPageActivity.this,MainActivity.class);
//				startActivity(intent);
				text4.setText("Welcome back!");//设置text1的显示文字
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
