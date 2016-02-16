package com.baiiu.filter.filter.typeview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.baiiu.filter.filter.adapter.BaseBaseAdapter;
import com.baiiu.filter.filter.interfaces.OnFilterItemClickListener;

/**
 * author: baiiu
 * date: on 16/2/16 15:46
 * description:
 */
public class SingleGridView<DATA> extends GridView implements AdapterView.OnItemClickListener {

    private BaseBaseAdapter<DATA> mAdapter;
    private OnFilterItemClickListener<DATA> mOnItemClickListener;

    public SingleGridView(Context context) {
        this(context, null);
    }

    public SingleGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SingleGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setSelector(new ColorDrawable(Color.TRANSPARENT));

        setOnItemClickListener(this);
    }

    public SingleGridView<DATA> adapter(BaseBaseAdapter<DATA> adapter) {
        this.mAdapter = adapter;
        setAdapter(adapter);
        return this;
    }

    public SingleGridView<DATA> onItemClick(OnFilterItemClickListener<DATA> onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        return this;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DATA item = mAdapter.getItem(position);
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(item);
        }
    }
}