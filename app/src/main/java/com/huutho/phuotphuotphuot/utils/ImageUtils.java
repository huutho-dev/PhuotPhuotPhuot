package com.huutho.phuotphuotphuot.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.huutho.phuotphuotphuot.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by HuuTho on 1/17/2017.
 */
public class ImageUtils {

    public static void loadImage(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .crossFade()
                .skipMemoryCache(false)
                .override(500, 500)
                .into(view);
    }
    public static void loadImage(Context context, String url, ImageView view, final ProgressBar progressBar) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .crossFade()
                .error(R.drawable.background_vietnam)
                .placeholder(R.drawable.background_vietnam)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(300, 300)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(view);
    }

}
