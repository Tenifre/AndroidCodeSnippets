package jp.tenifre.simplecustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by YuArai on 2015/05/05.
 */
public class SampleListViewAdapter extends ArrayAdapter<SampleListViewData> {
    private LayoutInflater layoutInflater_;

    private static class ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;

        public ViewHolder(View view) {
            titleTextView = (TextView) view.findViewById(R.id.listCellTitle);
            descriptionTextView = (TextView) view.findViewById(R.id.listCellDescription);
        }
    }

    public SampleListViewAdapter(Context placeholderFragment, int textViewResourceId, List<SampleListViewData> objects) {
        super(placeholderFragment, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) placeholderFragment.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private InputMethodManager inputMethodManager;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        final SampleListViewData item = (SampleListViewData)getItem(position);

        final ViewHolder holder;

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.sample_listview_cell, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        // データをViewの各Widgetにセットする
        holder.titleTextView.setText(item.getTitle());

        holder.descriptionTextView.setText(item.getDescription());

        return convertView;
    }
}
