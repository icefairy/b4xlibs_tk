package cn.finalteam.galleryfinal;

import anywheresoftware.b4a.BA;

public class R {
	public static final class dimen {
		public static int fab_shadow_radius = BA.applicationContext.getResources().getIdentifier("fab_shadow_radius", "dimen", BA.packageName);
		public static int fab_shadow_offset = BA.applicationContext.getResources().getIdentifier("fab_shadow_offset", "dimen", BA.packageName);
		public static int fab_size_normal = BA.applicationContext.getResources().getIdentifier("fab_size_normal", "dimen", BA.packageName);
		public static int fab_icon_size = BA.applicationContext.getResources().getIdentifier("fab_icon_size", "dimen", BA.packageName);
	}
	public static final class anim {
		public static int gf_flip_horizontal_in = BA.applicationContext.getResources().getIdentifier("gf_flip_horizontal_in", "anim", BA.packageName);
		public static int gf_flip_horizontal_out = BA.applicationContext.getResources().getIdentifier("gf_flip_horizontal_out", "anim", BA.packageName);
	}
	public static final class layout {
		public static int gf_activity_photo_edit = BA.applicationContext.getResources().getIdentifier("gf_activity_photo_edit", "layout", BA.packageName);
		public static int gf_activity_photo_preview = BA.applicationContext.getResources().getIdentifier("gf_activity_photo_preview", "layout", BA.packageName);
		public static int gf_activity_photo_select = BA.applicationContext.getResources().getIdentifier("gf_activity_photo_select", "layout", BA.packageName);
		public static int gf_adapter_folder_list_item = BA.applicationContext.getResources().getIdentifier("gf_adapter_folder_list_item", "layout", BA.packageName);
		public static int gf_adapter_edit_list = BA.applicationContext.getResources().getIdentifier("gf_adapter_edit_list", "layout", BA.packageName);
		public static int gf_adapter_photo_list_item = BA.applicationContext.getResources().getIdentifier("gf_adapter_photo_list_item", "layout", BA.packageName);
		public static int gf_adapter_preview_viewpgaer_item = BA.applicationContext.getResources().getIdentifier("gf_adapter_preview_viewpgaer_item", "layout", BA.packageName);
	}
	public static final class string {
		public static int open_gallery_fail = BA.applicationContext.getResources().getIdentifier("open_gallery_fail", "string", BA.packageName);
		public static int empty_sdcard = BA.applicationContext.getResources().getIdentifier("empty_sdcard", "string", BA.packageName);
		public static int maxsize_zero_tip = BA.applicationContext.getResources().getIdentifier("maxsize_zero_tip", "string", BA.packageName);
		public static int select_max_tips = BA.applicationContext.getResources().getIdentifier("select_max_tips", "string", BA.packageName);
		public static int take_photo_fail = BA.applicationContext.getResources().getIdentifier("take_photo_fail", "string", BA.packageName);
		public static int photo_list_empty = BA.applicationContext.getResources().getIdentifier("photo_list_empty", "string", BA.packageName);
		public static int crop_suc = BA.applicationContext.getResources().getIdentifier("crop_suc", "string", BA.packageName);
		public static int crop_fail = BA.applicationContext.getResources().getIdentifier("crop_fail", "string", BA.packageName);
		public static int photo_edit = BA.applicationContext.getResources().getIdentifier("photo_edit", "string", BA.packageName);
		public static int please_reopen_gf = BA.applicationContext.getResources().getIdentifier("please_reopen_gf", "string", BA.packageName);
		public static int no_photo = BA.applicationContext.getResources().getIdentifier("no_photo", "string", BA.packageName);
		public static int edit_letoff_photo_format = BA.applicationContext.getResources().getIdentifier("edit_letoff_photo_format", "string", BA.packageName);
		public static int photo_crop = BA.applicationContext.getResources().getIdentifier("photo_crop", "string", BA.packageName);
		public static int waiting = BA.applicationContext.getResources().getIdentifier("waiting", "string", BA.packageName);
		public static int selected = BA.applicationContext.getResources().getIdentifier("selected", "string", BA.packageName);
		public static int permissions_denied_tips = BA.applicationContext.getResources().getIdentifier("permissions_denied_tips", "string", BA.packageName);
		public static int permissions_tips_gallery = BA.applicationContext.getResources().getIdentifier("permissions_tips_gallery", "string", BA.packageName);
		public static int folder_photo_size = BA.applicationContext.getResources().getIdentifier("folder_photo_size", "string", BA.packageName);
		public static int all_photo = BA.applicationContext.getResources().getIdentifier("all_photo", "string", BA.packageName);
		public static int saving = BA.applicationContext.getResources().getIdentifier("saving", "string", BA.packageName);
	}
	public static final class styleable {
		public static int[] GFFloatingActionButton = {BA.applicationContext.getResources().getIdentifier("GFFloatingActionButton", "styleable", BA.packageName)};
		public static int GFFloatingActionButton_fabColorNormal = BA.applicationContext.getResources().getIdentifier("GFFloatingActionButton_fabColorNormal", "styleable", BA.packageName);
		public static int GFFloatingActionButton_fabColorPressed = BA.applicationContext.getResources().getIdentifier("GFFloatingActionButton_fabColorPressed", "styleable", BA.packageName);
		public static int GFFloatingActionButton_fabIcon = BA.applicationContext.getResources().getIdentifier("GFFloatingActionButton_fabIcon", "styleable", BA.packageName);
		public static int GFFloatingActionButton_fabTitle = BA.applicationContext.getResources().getIdentifier("GFFloatingActionButton_fabTitle", "styleable", BA.packageName);
		public static int[] HorizontalListView = {BA.applicationContext.getResources().getIdentifier("HorizontalListView", "styleable", BA.packageName)};
		public static int HorizontalListView_android_divider = BA.applicationContext.getResources().getIdentifier("HorizontalListView_android_divider", "styleable", BA.packageName);
		public static int HorizontalListView_dividerWidth = BA.applicationContext.getResources().getIdentifier("HorizontalListView_dividerWidth", "styleable", BA.packageName);
		public static int CropImageView = BA.applicationContext.getResources().getIdentifier("CropImageView", "styleable", BA.packageName);
		public static int CropImageView_showThirds = BA.applicationContext.getResources().getIdentifier("CropImageView_showThirds", "styleable", BA.packageName);
		public static int CropImageView_showCircle = BA.applicationContext.getResources().getIdentifier("CropImageView_showCircle", "styleable", BA.packageName);
		public static int CropImageView_highlightColor = BA.applicationContext.getResources().getIdentifier("CropImageView_highlightColor", "styleable", BA.packageName);
		public static int CropImageView_showHandles = BA.applicationContext.getResources().getIdentifier("CropImageView_showHandles", "styleable", BA.packageName);
	}
	public static final class drawable {
		public static int ic_gf_default_photo = BA.applicationContext.getResources().getIdentifier("ic_gf_default_photo", "drawable", BA.packageName);
		public static int ic_gf_back = BA.applicationContext.getResources().getIdentifier("ic_gf_back", "drawable", BA.packageName);
		public static int ic_gf_camera = BA.applicationContext.getResources().getIdentifier("ic_gf_camera", "drawable", BA.packageName);
		public static int ic_gf_crop = BA.applicationContext.getResources().getIdentifier("ic_gf_crop", "drawable", BA.packageName);
		public static int ic_gf_preview = BA.applicationContext.getResources().getIdentifier("ic_gf_preview", "drawable", BA.packageName);
		public static int ic_gf_rotate = BA.applicationContext.getResources().getIdentifier("ic_gf_rotate", "drawable", BA.packageName);
		public static int ic_gf_triangle_arrow = BA.applicationContext.getResources().getIdentifier("ic_gf_triangle_arrow", "drawable", BA.packageName);
		public static int ic_gf_clear = BA.applicationContext.getResources().getIdentifier("ic_gf_clear", "drawable", BA.packageName);
		public static int ic_delete_photo = BA.applicationContext.getResources().getIdentifier("ic_delete_photo", "drawable", BA.packageName);
		public static int ic_folder_check = BA.applicationContext.getResources().getIdentifier("ic_folder_check", "drawable", BA.packageName);
	}
	public static final class id {
		public static int iv_take_photo = BA.applicationContext.getResources().getIdentifier("iv_take_photo", "id", BA.packageName);
		public static int iv_crop_photo = BA.applicationContext.getResources().getIdentifier("iv_crop_photo", "id", BA.packageName);
		public static int iv_source_photo = BA.applicationContext.getResources().getIdentifier("iv_source_photo", "id", BA.packageName);
		public static int lv_gallery = BA.applicationContext.getResources().getIdentifier("lv_gallery", "id", BA.packageName);
		public static int ll_gallery = BA.applicationContext.getResources().getIdentifier("ll_gallery", "id", BA.packageName);
		public static int iv_back = BA.applicationContext.getResources().getIdentifier("iv_back", "id", BA.packageName);
		public static int tv_empty_view = BA.applicationContext.getResources().getIdentifier("tv_empty_view", "id", BA.packageName);
		public static int fab_crop = BA.applicationContext.getResources().getIdentifier("fab_crop", "id", BA.packageName);
		public static int iv_crop = BA.applicationContext.getResources().getIdentifier("iv_crop", "id", BA.packageName);
		public static int iv_rotate = BA.applicationContext.getResources().getIdentifier("iv_rotate", "id", BA.packageName);
		public static int tv_title = BA.applicationContext.getResources().getIdentifier("tv_title", "id", BA.packageName);
		public static int titlebar = BA.applicationContext.getResources().getIdentifier("titlebar", "id", BA.packageName);
		public static int iv_preview = BA.applicationContext.getResources().getIdentifier("iv_preview", "id", BA.packageName);
		public static int tv_indicator = BA.applicationContext.getResources().getIdentifier("tv_indicator", "id", BA.packageName);
		public static int vp_pager = BA.applicationContext.getResources().getIdentifier("vp_pager", "id", BA.packageName);
		public static int gv_photo_list = BA.applicationContext.getResources().getIdentifier("gv_photo_list", "id", BA.packageName);
		public static int lv_folder_list = BA.applicationContext.getResources().getIdentifier("lv_folder_list", "id", BA.packageName);
		public static int tv_sub_title = BA.applicationContext.getResources().getIdentifier("tv_sub_title", "id", BA.packageName);
		public static int ll_folder_panel = BA.applicationContext.getResources().getIdentifier("ll_folder_panel", "id", BA.packageName);
		public static int tv_choose_count = BA.applicationContext.getResources().getIdentifier("tv_choose_count", "id", BA.packageName);
		public static int fab_ok = BA.applicationContext.getResources().getIdentifier("fab_ok", "id", BA.packageName);
		public static int ll_title = BA.applicationContext.getResources().getIdentifier("ll_title", "id", BA.packageName);
		public static int iv_clear = BA.applicationContext.getResources().getIdentifier("iv_clear", "id", BA.packageName);
		public static int iv_folder_arrow = BA.applicationContext.getResources().getIdentifier("iv_folder_arrow", "id", BA.packageName);
		public static int iv_cover = BA.applicationContext.getResources().getIdentifier("iv_cover", "id", BA.packageName);
		public static int tv_folder_name = BA.applicationContext.getResources().getIdentifier("tv_folder_name", "id", BA.packageName);
		public static int tv_photo_count = BA.applicationContext.getResources().getIdentifier("tv_photo_count", "id", BA.packageName);
		public static int iv_folder_check = BA.applicationContext.getResources().getIdentifier("iv_folder_check", "id", BA.packageName);
		public static int iv_photo = BA.applicationContext.getResources().getIdentifier("iv_photo", "id", BA.packageName);
		public static int iv_delete = BA.applicationContext.getResources().getIdentifier("iv_delete", "id", BA.packageName);
		public static int iv_thumb = BA.applicationContext.getResources().getIdentifier("iv_thumb", "id", BA.packageName);
		public static int iv_check = BA.applicationContext.getResources().getIdentifier("iv_check", "id", BA.packageName);
		public static int fab_label = BA.applicationContext.getResources().getIdentifier("fab_label", "id", BA.packageName);
	}
	public static final class attr {
		public static int cropImageStyle = BA.applicationContext.getResources().getIdentifier("cropImageStyle", "attr", BA.packageName);
	}
}
