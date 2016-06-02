package main.java.org.angmarch.views;

import anywheresoftware.b4a.BA;

public class R {
	public static final class dimen {
		public static int one_and_a_half_grid_unit = BA.applicationContext.getResources().getIdentifier("one_and_a_half_grid_unit", "dimen", BA.packageName);
		public static int three_grid_unit = BA.applicationContext.getResources().getIdentifier("three_grid_unit", "dimen", BA.packageName);
	}
	public static final class layout {
		public static int spinner_list_item = BA.applicationContext.getResources().getIdentifier("spinner_list_item", "layout", BA.packageName);
	}
	public static final class drawable {
		public static int selector = BA.applicationContext.getResources().getIdentifier("selector", "drawable", BA.packageName);
		public static int spinner_drawable = BA.applicationContext.getResources().getIdentifier("spinner_drawable", "drawable", BA.packageName);
		public static int drop_down_shadow = BA.applicationContext.getResources().getIdentifier("drop_down_shadow", "drawable", BA.packageName);
		public static int arrow = BA.applicationContext.getResources().getIdentifier("arrow", "drawable", BA.packageName);
	}
	public static final class styleable {
//		public static int NiceSpinner = BA.applicationContext.getResources().getIdentifier("NiceSpinner", "styleable", BA.packageName);
		public static int NiceSpinner_hideArrow = BA.applicationContext.getResources().getIdentifier("NiceSpinner_hideArrow", "styleable", BA.packageName);
		public static int NiceSpinner_arrowTint = BA.applicationContext.getResources().getIdentifier("NiceSpinner_arrowTint", "styleable", BA.packageName);
                public static int[] NiceSpinner = {NiceSpinner_hideArrow, NiceSpinner_arrowTint};
                
	}
	public static final class id {
		public static int tv_tinted_spinner = BA.applicationContext.getResources().getIdentifier("tv_tinted_spinner", "id", BA.packageName);
	}
}
