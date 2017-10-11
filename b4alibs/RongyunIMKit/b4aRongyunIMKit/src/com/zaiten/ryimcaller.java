package com.zaiten;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation.ConversationType;

@ShortName("RongyunIMCaller")
@ActivityObject
public class ryimcaller {
	public static ConversationType CUSTOMER_SERVICE=ConversationType.CUSTOMER_SERVICE;
	public static ConversationType APP_PUBLIC_SERVICE=ConversationType.APP_PUBLIC_SERVICE;
	public static ConversationType PUBLIC_SERVICE=ConversationType.PUBLIC_SERVICE;
	public static ConversationType PRIVATE=ConversationType.PRIVATE;
	public static ConversationType GROUP=ConversationType.GROUP;
	@Hide
	public static String userName="";
	@Hide
	public static String userTel="";
	public static BA mba;
	public static void startChatByUser(BA ba,String user,String title){
		if (RongIM.getInstance() != null){
			userName=title;
			userTel=user;
			mba = ba;
            RongIM.getInstance().startPrivateChat(ba.context, user, title);
            }
	}
	public static void startChatByUser2(BA ba,String clientId,String title,ConversationType ct){
		if (RongIM.getInstance() != null){
			userName=title;
			RongIM.getInstance().startConversation(ba.context, ct, clientId, title);
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
