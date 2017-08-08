package com.example.administrator.free_recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.widget.HorizontalScrollView;

/**
 * Created by admin on 2016/8/26.
 */
public class AnimateScrollView extends HorizontalScrollView {
    private FreeRecyclerView myRecyclerView;

    private VelocityTracker velocityTracker = null;
    public AnimateScrollView(Context context) {
        super(context);
        setOverScrollMode(OVER_SCROLL_NEVER);

    }

    public AnimateScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    int downX;
    private int mLastXIntercept,mLastYIntercept;

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        getMyRecyclerView().scrollTo(l);
    }

/*    @Override
    public boolean onTouchEvent(MotionEvent e) {

        int x = (int) e.getX();
        int y = (int) e.getY();
        if (velocityTracker == null){
            velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker.addMovement(e);
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) e.getX();

                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastXIntercept;
                int deltaY = y - mLastYIntercept;
                int moveX = (int) (e.getX() - downX);


                if (Math.abs(deltaX) > Math.abs(deltaY)) {
//                    getMyRecyclerView().scrollTo(moveX);
                }
                break;
            case MotionEvent.ACTION_UP:
                velocityTracker.computeCurrentVelocity(100);
                int vX = (int)velocityTracker.getXVelocity((int) e.getX());
                Log.i("AnimateScrollView","vX="+vX);
//                getMyRecyclerView().scrollTo(vX);
                break;

        }
        if(velocityTracker != null){
            velocityTracker.recycle();
            velocityTracker = null;
        }
        mLastXIntercept = x; // 分别记录上次滑动坐标
        mLastYIntercept = y;
        return super.onTouchEvent(e);
    }*/


    private FreeRecyclerView getMyRecyclerView(){
        if (myRecyclerView == null){
            myRecyclerView = (FreeRecyclerView)getTag();
        }
        return myRecyclerView;
    }

}
