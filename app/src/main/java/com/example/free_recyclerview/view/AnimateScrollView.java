package com.example.free_recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.widget.HorizontalScrollView;

/**
 * myt.
 */
public class AnimateScrollView extends HorizontalScrollView {
    private FreeRecyclerView myRecyclerView;
    private ScrollBridge scrollBridge;
    private VelocityTracker velocityTracker = null;
    public AnimateScrollView(Context context) {
        super(context);
        setOverScrollMode(OVER_SCROLL_NEVER);

    }

    public void setScrollBridge(ScrollBridge scrollBridge) {
        this.scrollBridge = scrollBridge;
    }

    public AnimateScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollBridge != null) {
            scrollBridge.scrollTo(l);
        }
    }

}
