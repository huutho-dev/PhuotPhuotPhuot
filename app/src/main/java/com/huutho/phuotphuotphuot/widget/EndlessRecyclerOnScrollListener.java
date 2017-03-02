package com.huutho.phuotphuotphuot.widget;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ProgressBar;

/**
 * Created by HuuTho on 3/2/2017.
 */

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
    private boolean isLoading;
    private int mVisibleThreshold = 5;
    private int mFirstVisible;
    private int mTotalItemCount;
    private int mVisibleItemCount;
    private RecyclerView.LayoutManager mLayoutManager;

    public EndlessRecyclerOnScrollListener() {
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        ProgressBar progressBar = new ProgressBar(recyclerView.getContext());

        mLayoutManager = recyclerView.getLayoutManager();
        mTotalItemCount = mLayoutManager.getItemCount();
        mVisibleItemCount = recyclerView.getChildCount();
        if (mLayoutManager instanceof LinearLayoutManager) {
            mFirstVisible = ((LinearLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
        } else if (mLayoutManager instanceof GridLayoutManager) {
            mFirstVisible = ((GridLayoutManager) mLayoutManager).findFirstVisibleItemPosition();
        } else if (mLayoutManager instanceof StaggeredGridLayoutManager) {
            mFirstVisible = ((StaggeredGridLayoutManager) mLayoutManager).findFirstVisibleItemPositions(new int[]{})[0];
        }

        if (isLoading && mTotalItemCount > mLayoutManager.getItemCount()) {
            isLoading = false;
            recyclerView.removeView(progressBar);
        }

        if (!isLoading && (mTotalItemCount - mVisibleItemCount) <= (mFirstVisible + mFirstVisible)) {
            onEndlessScroll();
            recyclerView.addView(new ProgressBar(recyclerView.getContext()));
            isLoading = true;
        }
    }

    public abstract void onEndlessScroll();

    public void setLoading(boolean load) {
        this.isLoading = load;
    }
}
