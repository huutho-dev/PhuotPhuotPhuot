package com.huutho.phuotphuotphuot.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by HuuTho on 1/25/2017.
 */
public class TextViewRoboto extends TextView {
    private final String TAG = TextViewRoboto.class.getSimpleName();

    public TextViewRoboto(Context context) {
        super(context);
        init(context);
    }

    public TextViewRoboto(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextViewRoboto(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "/font/robotoregular.ttf");
        setTypeface(typeface);
    }
}
