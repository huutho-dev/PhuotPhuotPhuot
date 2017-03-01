package com.huutho.phuotphuotphuot.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by HuuTho on 1/17/2017.
 */
public class ImageUtils {

    public static void loadImage(Activity activity, String url, ImageView view) {
        Glide.with(activity)
                .load(url)
                .fitCenter()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)
                .into(view);
    }

    public static void loadImage(Fragment fragment, String url, ImageView view) {
        Glide.with(fragment)
                .load(url)
                .fitCenter()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)
                .into(view);
    }

    public static void loadImage(Context context, String url, ImageView view){
        Glide.with(context)
                .load(url)
                .fitCenter()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)
                .into(view);
    }

    public static void loadImageWithPicasso(Context context, String url, ImageView view){
        final ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);

        Picasso.with(context)
                .load(url)
                .into(view, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
