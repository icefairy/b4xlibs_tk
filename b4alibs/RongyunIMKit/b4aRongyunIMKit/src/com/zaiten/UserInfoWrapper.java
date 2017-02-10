package com.zaiten;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import io.rong.imlib.model.UserInfo;

@ShortName("UserInfo_ry")
public class UserInfoWrapper extends AbsObjectWrapper<UserInfo> {

	public void init(String uid) {
		setObject(new UserInfo(uid, "", null));
	}
	public String getName() {
		return getObject().getName();
	}
	public void setName(String name) {
		getObject().setName(name);
	}
	public String getPortraitUri() {
		return getObject().getPortraitUri().toString();
	}
	public void setPortraitUri(String sUri) {
		android.net.Uri u=android.net.Uri.parse(sUri);
		getObject().setPortraitUri(u);
	}
	public String getUserId() {
		return getObject().getUserId();
	}
	public void setUserId(String userId) {
		getObject().setUserId(userId);
	}
}
