package main.java.org.angmarch.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author angelo.marchesin
 */

@SuppressWarnings("unused")
public abstract class NiceSpinnerBaseAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected int mSelectedIndex;
    private int dropdownListTextColor = 0xffff0000;
    private int textsize=12;

    public NiceSpinnerBaseAdapter(Context context) {
        mContext = context;
    }

    @Override
    @SuppressWarnings("unchecked")
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.spinner_list_item, null);
            textView = (TextView) convertView.findViewById(R.id.tv_tinted_spinner);

              //it sets the color of the text in the dropdown list but not that of the selected item
              textView.setTextColor(dropdownListTextColor);

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                textView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.selector));

//            }

            convertView.setTag(new ViewHolder(textView));
        } else {
            textView = ((ViewHolder) convertView.getTag()).textView;
        }

        textView.setText(getItem(position).toString());
        textView.setTextSize(textsize);
        return convertView;
    }

    public int getSelectedIndex() {
        return mSelectedIndex;
    }


    public void notifyItemSelected(int index) {
        mSelectedIndex = index;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract T getItem(int position);

    @Override
    public abstract int getCount();

    public abstract T getItemInDataset(int position);

    protected static class ViewHolder {

        public TextView textView;

        public ViewHolder(TextView textView) {
            this.textView = textView;
        }
    }

    public void setDropdownListTextColor(int color){
        dropdownListTextColor = color;                
    }
    public void setDropdownListTextSize(int size){
        textsize=size;                
    }


}
