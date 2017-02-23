package com.huutho.phuotphuotphuot.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.huutho.phuotphuotphuot.R;

/**
 * Created by HuuTho on 1/28/2017.
 */
public class ToobarBackButton extends Toolbar {
    private final String TAG = ToobarBackButton.class.getSimpleName();

    public ToobarBackButton(Context context) {
        super(context);
        initToolbar(context);
    }

    public ToobarBackButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initToolbar(context);
    }

    public ToobarBackButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initToolbar(context);
    }

   private void initToolbar(final Context context){
       setBackgroundColor(ContextCompat.getColor(context,R.color.colorPrimary));
       context.setTheme(android.R.style.Theme_Holo_Light_DarkActionBar);
       setNavigationIcon(R.drawable.ic_arrow_back);
       setNavigationOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               ((AppCompatActivity) context).onBackPressed();
           }
       });
    }

    private void setTitle(String title){
        setTitle(title);
    }
}
