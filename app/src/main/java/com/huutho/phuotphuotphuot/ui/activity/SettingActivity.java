package com.huutho.phuotphuotphuot.ui.activity;

import android.content.res.Configuration;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;
import com.huutho.phuotphuotphuot.utils.SharePreferencesUtils;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by hnc on 12/04/2017.
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.toobar)
    Toolbar toolbar ;
    @BindView(R.id.act_setting_spn_language)
    AppCompatSpinner mSpnLanguage;


    private String languages[] = {"vi", "en", "jpn"};

    @Override
    public int setContentLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.setting_title);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        setupSpinner(mSpnLanguage);
    }

    @Override
    public void activityReady() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupSpinner(AppCompatSpinner mSpnLanguage) {
        ArrayAdapter<String> adapterLanguage = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnLanguage.setAdapter(adapterLanguage);
        mSpnLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // change language
                Locale locale = new Locale(languages[position]);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                // save sharepreference
                SharePreferencesUtils.getInstances().setLanguage(languages[position]);

                Toast.makeText(SettingActivity.this, "Language changed after you restart app", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
