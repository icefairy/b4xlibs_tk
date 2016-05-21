package io.rong.fast.activity;

import com.zaiten.R;
import com.zaiten.ryimcaller;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import io.rong.imlib.model.Conversation;

public class ConversationActivity extends FragmentActivity {

	  	private TextView tvtitle,tvback;
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
	        tvback=(TextView) findViewById(R.id.tvback);
	        tvback.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});;
			tvback.setText("<返回");
			tvtitle=(TextView) findViewById(R.id.tvtitle);
			tvtitle.setText("与"+ryimcaller.userName+"聊天中");
	    }

	}