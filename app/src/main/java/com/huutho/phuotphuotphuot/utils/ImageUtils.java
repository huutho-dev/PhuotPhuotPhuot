package com.huutho.phuotphuotphuot.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.huutho.phuotphuotphuot.R;
import com.squareup.picasso.Picasso;

/**
 * Created by HuuTho on 1/17/2017.
 */
public class ImageUtils {

    public static void loadImage(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .error(R.drawable.background_loading)
                .placeholder(R.drawable.background_loading)
                .skipMemoryCache(false)
                .into(view);
    }

    public static void loadImage(Context context, String url, ImageView view, final ProgressBar progressBar) {
        Glide.with(context)
                .load(url)
                .error(R.drawable.background_loading)
                .placeholder(R.drawable.background_loading)
                .skipMemoryCache(false)
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


    public static void loadImagePicasso(Context context, String url, ImageView imageView){
        Picasso.with(context)
                .load(url)
                .error(R.drawable.background_loading)
                .placeholder(R.drawable.background_loading)
                .into(imageView);
    }
}
