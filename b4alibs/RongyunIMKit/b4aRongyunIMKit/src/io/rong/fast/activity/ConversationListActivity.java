package io.rong.fast.activity;

import com.zaiten.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ConversationListActivity extends FragmentActivity {
	private TextView tvtitle;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversationlist);
        findViewById(R.id.ivback).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		tvtitle=(TextView) findViewById(R.id.tvtitle);
		tvtitle.setText("会话列表");
		
    }
}
