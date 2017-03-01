package com.huutho.phuotphuotphuot.widget;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by HuuTho on 3/1/2017.
 */

public class BasicToolbar extends Toolbar {
    public BasicToolbar(final Context context) {
        super(context);

        if (context != null) {
            ((AppCompatActivity) context).setSupportActionBar(this);
            ((AppCompatActivity) context).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) context).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            setOnMenuItemClickListener(new OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == android.R.id.home) {
                        ((AppCompatActivity) context).finish();
                    }
                    return true;
                }
            });
        }

    }

    public void setToolbarTitle(String title) {
        setTitle(title);
    }

    public void setToolbarTitle(int resId) {
        setTitle(resId);
    }
}
