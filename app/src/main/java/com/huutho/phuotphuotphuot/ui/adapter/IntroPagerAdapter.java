package com.huutho.phuotphuotphuot.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.ui.entity.IntroItem;

import java.util.ArrayList;

/**
 * Created by HuuTho on 1/18/2017.
 */
public class IntroPagerAdapter extends PagerAdapter {
    private final String TAG = IntroPagerAdapter.class.getSimpleName();

    private ArrayList<IntroItem> dataIntros;

    public IntroPagerAdapter(ArrayList<IntroItem> dataIntros) {
        this.dataIntros = dataIntros;
    }

    @Override
    public int getCount() {
        return dataIntros.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.layout_intro, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_intro);
        TextView textView = (TextView) view.findViewById(R.id.text_intro);
        IntroItem item = dataIntros.get(position);
        imageView.setImageResource(item.resId);
        textView.setText(item.title);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

}
