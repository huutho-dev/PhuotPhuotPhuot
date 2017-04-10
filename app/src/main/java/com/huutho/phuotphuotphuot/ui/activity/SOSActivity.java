package com.huutho.phuotphuotphuot.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;
import com.huutho.phuotphuotphuot.ui.adapter.SosAdapter;
import com.huutho.phuotphuotphuot.ui.entity.SOS;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;
import com.huutho.phuotphuotphuot.utils.database.TableSOS;
import com.huutho.phuotphuotphuot.widget.ToobarBackButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hnc on 31/03/2017.
 */

public class SOSActivity extends BaseActivity implements SosAdapter.ISosAdapterListener {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 11;
    @BindView(R.id.reycler_sos)
    public RecyclerView mRvSOS;
    @BindView(R.id.toolbar)
    public ToobarBackButton toobarBackButton;

    private SosAdapter adapter;
    private ArrayList<SOS> datas = new ArrayList<>();

    @Override
    public int setContentLayout() {
        return R.layout.activity_sos;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);

        setSupportActionBar(toobarBackButton);
        toobarBackButton.setToolbarTitle("SOS");

        datas.addAll(TableSOS.getInstance().getListData(null, null, null));
        adapter = new SosAdapter(this, this);
        mRvSOS.setLayoutManager(new LinearLayoutManager(this));
        mRvSOS.setAdapter(adapter);

        adapter.setDatas(datas);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void activityReady() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_sos, menu);

        final MenuItem itemSearch = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(itemSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                itemSearch.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                    if (TextUtils.isEmpty(newText)){
                        // Search view is empty
                        datas.clear();
                        datas.addAll(TableSOS.getInstance().getListData(null, null, null));
                        adapter.setDatas(datas);
                    }else {
                        datas.clear();
                        ArrayList<SOS> newData = TableSOS.getInstance().getListData(DbContracts.TableSOS.SOS_NAME_CITY + " LIKE '%" + newText + "%' ",null,null);
                        datas.addAll(newData);
                        adapter.setDatas(datas);
                    }
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRecyclerViewItemClick(SOS dataItem, View view, int position) {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
