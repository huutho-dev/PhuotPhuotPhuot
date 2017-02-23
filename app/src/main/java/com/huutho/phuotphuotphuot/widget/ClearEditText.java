package com.huutho.phuotphuotphuot.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.huutho.phuotphuotphuot.R;

/**
 * Created by HuuTho on 1/21/2017.
 */
public class ClearEditText extends EditText {
    private final String TAG = ClearEditText.class.getSimpleName();

    private Drawable mCrossX;
    private Drawable mNonCross;
    private boolean isVisible = false;

    private Drawable mDrawableRight;

    public ClearEditText(Context context) {
        super(context);
        initClearEditText();
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initClearEditText();
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initClearEditText();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initClearEditText();
    }

    private void initClearEditText() {
        mCrossX = ContextCompat.getDrawable(getContext(), R.drawable.ic_cross_x).mutate();
        mNonCross = ContextCompat.getDrawable(getContext(), android.R.drawable.screen_background_light_transparent).mutate();
        configCrossToRight();
    }

    private void configCrossToRight() {
        setInputType(InputType.TYPE_CLASS_TEXT);
        Drawable[] drawables = getCompoundDrawables();
        mDrawableRight = isVisible ? mCrossX : mNonCross;
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], mDrawableRight, drawables[3]);
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (start != 0) {
            isVisible = true;
        } else {
            isVisible = false;
        }
        configCrossToRight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction() &&
                event.getX() >= (getRight() - mDrawableRight.getBounds().width() - 2 * getPaddingLeft())) {
            setText("");
        }
        return super.onTouchEvent(event);
    }
}
