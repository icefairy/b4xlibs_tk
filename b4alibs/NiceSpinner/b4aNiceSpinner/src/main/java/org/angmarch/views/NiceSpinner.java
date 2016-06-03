package main.java.org.angmarch.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import main.java.org.angmarch.views.R;
import android.graphics.drawable.GradientDrawable; 
import android.graphics.drawable.GradientDrawable.Orientation;
import anywheresoftware.b4a.BA;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;

import java.util.List;

/**
 * @author angelo.marchesin
 */
@SuppressWarnings("unused")
public class NiceSpinner extends TextView {

    private static final int MAX_LEVEL = 10000;
    private static final int DEFAULT_ELEVATION = 16;
    private static final String INSTANCE_STATE = "instance_state";
    private static final String SELECTED_INDEX = "selected_index";
    private static final String IS_POPUP_SHOWING = "is_popup_showing";

    private int mSelectedIndex;
    private Drawable mDrawable;
    private DrawableCompat mDrawableCompat;
    private PopupWindow mPopup;
    private ListView mListView;
    private NiceSpinnerBaseAdapter mAdapter;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private boolean mHideArrow = false;
    private int[] dividercolor = {0, 0xFFFF0000, 0};
    private int arrowcolor = 0xff000000;
    private int selectedtextcolor = 0xffff0000;
    private int selectedtextsize = 12;
    private int selectedtextbackgroundcolor = 0xffff0000;


    @SuppressWarnings("ConstantConditions")
    public NiceSpinner(Context context) {
        super(context);
        init(context, null);
    }

    public NiceSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public NiceSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putInt(SELECTED_INDEX, mSelectedIndex);

        if (mPopup != null) {
            bundle.putBoolean(IS_POPUP_SHOWING, mPopup.isShowing());
            dismissDropDown();
        }

        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable savedState) {
        if (savedState instanceof Bundle) {
            Bundle bundle = (Bundle) savedState;

            mSelectedIndex = bundle.getInt(SELECTED_INDEX);

            if (mAdapter != null) {
                setText(mAdapter.getItemInDataset(mSelectedIndex).toString());
                mAdapter.notifyItemSelected(mSelectedIndex);
            }

            if (bundle.getBoolean(IS_POPUP_SHOWING)) {
                if (mPopup != null) {
                    // Post the show request into the looper to avoid bad token exception
                    post(new Runnable() {
                        @Override
                        public void run() {
                            showDropDown();
                        }
                    });
                }
            }

            savedState = bundle.getParcelable(INSTANCE_STATE);
        }

        super.onRestoreInstanceState(savedState);
    }

    private void init(Context context, AttributeSet attrs) {
        Resources resources = getResources();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NiceSpinner);
        int defaultPadding = resources.getDimensionPixelSize(R.dimen.one_and_a_half_grid_unit);

        setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        setPadding(resources.getDimensionPixelSize(R.dimen.three_grid_unit), defaultPadding, defaultPadding,
            defaultPadding);
        setClickable(true);
        setBackgroundResource(R.drawable.selector);

        mListView = new ListView(context);
        // Set the spinner's id into the listview to make it pretend to be the right parent in
        // onItemClick
        mListView.setId(getId());
        
       if (mDrawable != null && !mHideArrow) {
             mDrawableCompat.setTint(mDrawable, arrowcolor);               
       }


        mListView.setItemsCanFocus(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= mSelectedIndex && position < mAdapter.getCount()) {
                    position++;
                }

                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(parent, view, position, id);
                }

                if (mOnItemSelectedListener != null) {
                    mOnItemSelectedListener.onItemSelected(parent, view, position, id);
                }

                mAdapter.notifyItemSelected(position);
                mSelectedIndex = position;
                setText(mAdapter.getItemInDataset(position).toString());
                dismissDropDown();
            }
        });

        mPopup = new PopupWindow(context);
        mPopup.setContentView(mListView);
        mPopup.setOutsideTouchable(true);
        mPopup.setFocusable(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            mPopup.setElevation(DEFAULT_ELEVATION);
//            mPopup.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.spinner_drawable));   //original
            mPopup.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.drop_down_shadow));
        } else {
//            mPopup.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.drop_down_shadow));   //original
            mPopup.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.spinner_drawable));
        }

        mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (!mHideArrow) {
                    animateArrow(false);
                }
            }
        });

        mHideArrow = false;
        if (!mHideArrow) {
            Drawable basicDrawable = ContextCompat.getDrawable(context, R.drawable.arrow);
            int resId = 1;

            if (basicDrawable != null) {
                mDrawable = mDrawableCompat.wrap(basicDrawable);

                if (resId != -1) {
                    mDrawableCompat.setTint(mDrawable, arrowcolor);   
                }
            }
            setCompoundDrawablesWithIntrinsicBounds(null, null, mDrawable, null);
        }

        typedArray.recycle();
    }

    public int getSelectedIndex() {
        return mSelectedIndex;
    }

    /**
     * Set the default spinner item using its index
     * 
     * @param position the item's position
     */
    public void setSelectedIndex(int position) {
        if (mAdapter != null) {
            if (position >= 0 && position <= mAdapter.getCount()) {
                mAdapter.notifyItemSelected(position);
                mSelectedIndex = position;
                setText(mAdapter.getItemInDataset(position).toString());
                setTextColor(selectedtextcolor);
                setTextSize(selectedtextsize);
                setBackgroundColor(selectedtextbackgroundcolor);
            } else {
                throw new IllegalArgumentException("Position must be lower than adapter count!");
            }
        }
    }

    public void addOnItemClickListener(@NonNull AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(@NonNull AdapterView.OnItemSelectedListener onItemSelectedListener) {
        mOnItemSelectedListener = onItemSelectedListener;
    }

    public void setAdapter(@NonNull ListAdapter adapter) {
        mAdapter = new NiceSpinnerAdapterWrapper(getContext(), adapter);
        setAdapterInternal(mAdapter);
    }

    public <T> void attachDataSource(@NonNull List<T> dataset) {
        mAdapter = new NiceSpinnerAdapter(getContext(), dataset);
        setAdapterInternal(mAdapter);
    }

    private void setAdapterInternal(@NonNull NiceSpinnerBaseAdapter adapter) {
        mListView.setAdapter(adapter);
        setText(adapter.getItemInDataset(mSelectedIndex).toString());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mPopup.setWidth(View.MeasureSpec.getSize(widthMeasureSpec));
        mPopup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (!mPopup.isShowing()) {
                showDropDown();
            } else {
                dismissDropDown();
            }
        }

        return super.onTouchEvent(event);
    }

    private void animateArrow(boolean shouldRotateUp) {
        int start = shouldRotateUp ? 0 : MAX_LEVEL;
        int end = shouldRotateUp ? MAX_LEVEL : 0;
        ObjectAnimator animator = ObjectAnimator.ofInt(mDrawable, "level", start, end);
        animator.setInterpolator(new LinearOutSlowInInterpolator());
        animator.start();
    }

    public void dismissDropDown() {
        if (!mHideArrow) {
            animateArrow(false);
        }
        invokeItemClicked();
        mPopup.dismiss();
    }

    public void showDropDown() {
        if (!mHideArrow) {
            animateArrow(true);
        }
        mPopup.showAsDropDown(this);
    }

    public void setTintColor(int color) {
        arrowcolor = color;
        if (mDrawable != null && !mHideArrow) {
              BA.Log("I am here");
              mDrawableCompat.setTint(mDrawable, color);
        }
        this.invalidate();
    }

//    public void setTintColor(int color) {
//        arrowcolor = color;
//    }

    public void setDividerColor(int[] divcolor){
        mListView.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, divcolor));
        this.invalidate();
    }

    public void setDividerHeight(int height){
        mListView.setDividerHeight(height);
        this.invalidate();
    }

    public void setDropdownListBackgroundColor(int color){
        mListView.setBackgroundColor(color);                //this changes the background color of the dropdown list but not that of the selected item
        this.invalidate();
    }


    public void setDropdownListTextColor(int color){
        mAdapter.setDropdownListTextColor(color);
        this.invalidate();            
    }
    public void setDropdownListTextSize(int size){
        mAdapter.setDropdownListTextSize(size);
        this.invalidate();            
    }
    public void setSelectedTextColor(int color){
        selectedtextcolor = color;
        this.invalidate();            
    }
    public void setSelectedTextSize(int size){
        selectedtextsize = size;
        this.invalidate();            
    }
    public void setSelectedTextBackgroundColor(int color){
        selectedtextbackgroundcolor = color;
        this.invalidate();            
    }





    Callback callback;
    public interface  Callback{
        void item_clicked();
    }

    private void invokeItemClicked() {
        if(callback!=null){
            callback.item_clicked();
        }
    }


    public void setCallback(Callback callback){
        this.callback = callback;
    }


}
