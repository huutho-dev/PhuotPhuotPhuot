package com.huutho.phuotphuotphuot.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 1/28/2017.
 */
public class FlashLightActivity extends BaseActivity {
    private final String TAG = FlashLightActivity.class.getSimpleName();

    @BindView(R.id.fragment_flashlight_switch)
    ImageView mSwitch;

    private AlertDialog alertDialog;
    private Camera mCamera;
    private Camera.Parameters mParams;

    private boolean mDeviceHasFlash;
    private boolean isFlashOn;

    public static void lauch(AppCompatActivity activity){
        Intent intent = new Intent(activity, FlashLightActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_flashlight;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);
    }

    @Override
    public void activityReady() {
        getCameraParams();

        mDeviceHasFlash = this
                .getApplicationContext()
                .getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!mDeviceHasFlash){
            createDiaglog();
        }else {
            mSwitch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isFlashOn) {
                        turnOnFlash();
                    } else {
                        turnOffFlash();
                    }
                }
            });
        }

    }


    private void createDiaglog() {
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Rất tiếc thiết bị của  bạn không hỗ trợ đèn ");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                onBackPressed();
            }
        });
        alertDialog.show();
    }

    private void getCameraParams() {
        if (mCamera == null) {
            try {
                mCamera = android.hardware.Camera.open();
                mParams = mCamera.getParameters();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void turnOnFlash() {
        if (!isFlashOn) {
            if (mCamera == null || mParams == null) {
                return;
            }
            playSound();
            mParams = mCamera.getParameters();
            mParams.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            mCamera.setParameters(mParams);
            mCamera.startPreview();
            isFlashOn = true;
            changeImageSwitch(isFlashOn);
        }
    }

    private void turnOffFlash() {
        if (isFlashOn) {
            if (mCamera == null || mParams == null) {
                return;
            }
            playSound();
            mParams = mCamera.getParameters();
            mParams.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            mCamera.setParameters(mParams);
            mCamera.startPreview();
            isFlashOn = false;
            changeImageSwitch(isFlashOn);
        }
    }

    private void changeImageSwitch(boolean isFlashOn) {
        if (isFlashOn) {
            mSwitch.setImageResource(R.drawable.icon_flash_turn_on);
            mSwitch.setBackgroundColor(getResources().getColor(R.color.flashlighton ));
            return;
        }
        mSwitch.setImageResource(R.drawable.icon_flash_turn_off);
        mSwitch.setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    private void playSound() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (isFlashOn){
            turnOffFlash();
            mCamera.release();
            finish();
        }
    }
}
