package com.zaiten;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation.ConversationType;

@ShortName("RongyunIMCaller")
@ActivityObject
public class ryimcaller {
	@Hide
	public static String userName="";
	public static void startChatByUser(BA ba,String user,String title){
		if (RongIM.getInstance() != null){
			userName=title;
            RongIM.getInstance().startPrivateChat(ba.context, user, title);
            }
	}
	public static void startChatByClient(BA ba,String clientId,String title){
		if (RongIM.getInstance() != null){
			userName=title;
			RongIM.getInstance().startConversation(ba.context, ConversationType.APP_PUBLIC_SERVICE, clientId, title);
            }
	}
	public static void startConversationList(BA ba){
		if (RongIM.getInstance() != null){
            RongIM.getInstance().startConversationList(ba.context);
		}
	}
	public static void startSubConversationList(BA ba) {
		if (RongIM.getInstance() != null){
		                   RongIM.getInstance().startSubConversationList(ba.context, ConversationType.GROUP);
		}
	}
	
}
