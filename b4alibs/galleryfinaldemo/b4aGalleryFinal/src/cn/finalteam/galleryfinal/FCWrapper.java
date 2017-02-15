package cn.finalteam.galleryfinal;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("FunctionConfig_gf")
public class FCWrapper extends AbsObjectWrapper<FunctionConfig.Builder> {
	public void init(){
		FunctionConfig.Builder fb=new FunctionConfig.Builder();
		setObject(fb);
	}
	public void setEnableEdit(Boolean val) {
		getObject().setEnableEdit(val);
	}
	public void setCropHeight(int height) {
		getObject().setCropHeight(height);
		
	}
	public void setCropSquare(boolean enable) {
		getObject().setCropSquare(enable);
	}
	public void setCropWidth(int width) {
		getObject().setCropWidth(width);
	}
	public void setEnableCamera(boolean enable) {
		getObject().setEnableCamera(enable);
	}
	public void setEnableCrop(boolean enable) {
		getObject().setEnableCrop(enable);
	}
	public void setEnablePreview(boolean enable) {
		getObject().setEnablePreview(enable);
	}
	public void setMutiSelect(boolean mutiSelect) {
		getObject().setMutiSelect(mutiSelect);
	}
	public void setMutiSelectMaxSize(int maxSize) {
		getObject().setMutiSelectMaxSize(maxSize);
	}
	public void setCropReplaceSource(boolean cropReplaceSource) {
		getObject().setCropReplaceSource(cropReplaceSource);
	}
	public void setRotateReplaceSource(boolean rotateReplaceSource) {
		getObject().setRotateReplaceSource(rotateReplaceSource);
	}
	public void setEnableRotate(Boolean EnableRotate) {
		getObject().setEnableRotate(EnableRotate);
	}
	public void setForceCrop(boolean forceCrop) {
		getObject().setForceCrop(forceCrop);
	}
	public void setForceCropEdit(boolean forceCropEdit) {
		getObject().setForceCropEdit(forceCropEdit);
	}
	public FunctionConfig Build(){
		return getObject().build();
	}
}
