package io.rong.fast.activity;

import com.zaiten.R;
import com.zaiten.ryimcaller;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Conversation;

public class ConversationActivity extends FragmentActivity {

	  	private TextView tvtitle;
	    private String mTargetId;

	    /**
	     * 刚刚创建完讨论组后获得讨论组的id 为targetIds，需要根据 为targetIds 获取 targetId
	     */
	    private String mTargetIds;

	    private Conversation.ConversationType mConversationType;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.conversation);
	        findViewById(R.id.ivback).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
			tvtitle=(TextView) findViewById(R.id.tvtitle);
			if (ryimcaller.userName==null||ryimcaller.userName.length()<1) {
				if (ryimcaller.userTel==null||ryimcaller.userTel.length()<1) {
					tvtitle.setText("聊天中");
				}else{
					tvtitle.setText("与"+ryimcaller.userTel+"聊天中");
				}
			}else{
				tvtitle.setText("与"+ryimcaller.userName+"聊天中");
			}
			
	    }
	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        return super.onKeyDown(keyCode, event);
	    }
	    @Override
	    public void onBackPressed() {
	               ConversationFragment fragment = (ConversationFragment) getSupportFragmentManager().findFragmentById(R.id.conversation);
	        if(!fragment.onBackPressed()) {
	            finish();
	        }
	      }
	}