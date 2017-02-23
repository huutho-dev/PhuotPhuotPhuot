package com.huutho.phuotphuotphuot.ui.fragment;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.activity.RegionsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 1/28/2017.
 */
public class FlashLightFragment extends BaseFragment {
    private final String TAG = FlashLightFragment.class.getSimpleName();

    @BindView(R.id.fragment_flashlight_switch)
    SwitchCompat mSwitch;

    private AlertDialog alertDialog;
    private Camera mCamera;
    private Camera.Parameters mParams;

    private boolean mDeviceHasFlash;
    private boolean isFlashOn;

    @Override
    public int setContentLayout() {
        return R.layout.fragment_flashlight;
    }

    @Override
    public void bindViewToFragment() {
        ButterKnife.bind(this, getView());
    }

    @Override
    public void fragmentReady() {
        getCameraParams();

        mDeviceHasFlash = mContext
                .getApplicationContext()
                .getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!mDeviceHasFlash) {
            createDiaglog();
        } else {
            mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        turnOnFlash();
                    }else {
                        turnOffFlash();
                    }
                }
            });
        }
    }

    private void createDiaglog() {
        alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Rất tiếc thiết bị của  bạn không hỗ trợ đèn ");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                ((RegionsActivity) mActivity).onBackPressed();
            }
        });
        alertDialog.show();
    }

    private void getCameraParams() {
        if (mCamera != null) {
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
            mSwitch.setChecked(true);
            return;
        }
        mSwitch.setChecked(false);
    }

    private void playSound() {

    }
}
