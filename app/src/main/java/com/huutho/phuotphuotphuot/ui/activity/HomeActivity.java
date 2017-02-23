package com.huutho.phuotphuotphuot.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.huutho.phuotphuotphuot.R.id.act_home_imv_central;
import static com.huutho.phuotphuotphuot.R.id.act_home_imv_north;
import static com.huutho.phuotphuotphuot.R.id.act_home_imv_south;


/**
 * Created by HuuTho on 1/19/2017.
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private final String TAG = HomeActivity.class.getSimpleName();

    @BindView(act_home_imv_north)
    ImageView mImvNorth;
    @BindView(act_home_imv_central)
    ImageView mImvCentral;
    @BindView(act_home_imv_south)
    ImageView mImvSouth;

    private Animation mZoomIn, mZoomOut;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setContentLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);
        mImvNorth.setDrawingCacheEnabled(true);
        mImvCentral.setDrawingCacheEnabled(true);
        mImvSouth.setDrawingCacheEnabled(true);

        mZoomIn = AnimationUtils.loadAnimation(this, R.anim.anim_zoom_in);
        mZoomOut = AnimationUtils.loadAnimation(this, R.anim.anim_zoom_out);
    }

    @Override
    public void activityReady() {
        mImvNorth.setOnTouchListener(changeColorListener);
        mImvCentral.setOnTouchListener(changeColorListener);
        mImvSouth.setOnTouchListener(changeColorListener);
    }

    @Override
    public void onClick(View v) {

    }

    private View.OnTouchListener changeColorListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(final View v, final MotionEvent event) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    Bitmap bm = Bitmap.createBitmap(v.getDrawingCache());
                    int color = bm.getPixel((int) event.getX(), (int) event.getY());
                    if (color != Color.TRANSPARENT) {

                        switch (v.getId()) {
                            case R.id.act_home_imv_north:
                                startActivity(RegionsActivity.REGIONS_NORTH);
                                break;
                            case R.id.act_home_imv_central:
                                startActivity(RegionsActivity.REGIONS_CENTRAL);
                                break;
                            case R.id.act_home_imv_south:
                                startActivity(RegionsActivity.REGIONS_SOUTH);
                                break;
                        }
                    }
                }
            });
            return false;
        }
    };

    private void startActivity(int regions) {
        Intent intent = new Intent(HomeActivity.this, RegionsActivity.class);
        intent.putExtra(RegionsActivity.KEY_BUNDLE_REGIONS, regions);
        startActivity(intent);
    }
}
