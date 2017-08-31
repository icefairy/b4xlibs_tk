package io.rong.fast.activity;

import com.zaiten.R;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;
/*
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
*/

public class ConversationListActivity extends FragmentActivity {  
	  
    private TextView mTitle;  
    private ImageView mBack;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.conversationlist);  
  
        mTitle = (TextView) findViewById(R.id.tvtitle);  
        mBack = (ImageView) findViewById(R.id.ivback);  
  
        mTitle.setText("会话列表");  
  
        mBack.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                finish();  
            }  
        });

        enterFragment();  
    }  
 
    /** 
     * 加载 会话列表 ConversationListFragment 
     */  
    private void enterFragment() {  
  
        ConversationListFragment fragment = (ConversationListFragment) getSupportFragmentManager().findFragmentById(R.id.conversationlist);  
  
        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()  
                .appendPath("conversationlist")  
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示  
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")  
                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "true")  
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")  
                .build();  
  
        fragment.setUri(uri);  
    }   
}  