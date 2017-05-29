package com.bookaholicc.utils;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by nandhu on 27/3/17.
 * A Custom simple Gesture listener That Listens For Fling Event on a View
 *
 * Fires up a Callback
 * currently used in {@link com.strictlyindian.replay.Fragment.ViewProductFragment}
 *
 */

public class GListener extends GestureDetector.SimpleOnGestureListener {

    private static final float SWIPE_MIN_DISTANCE = 50;
    private static final float SWIPE_THRESHOLD_VELOCITY = 25;


    private Callbacks mCallback = null;
    public GListener(Callbacks mCallbacks) {
        this.mCallback = mCallbacks;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            return false; // Right to left
        }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            return false; // Left to right
        }

        if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            Log.d("GLISTENR", "onFling: in Inner Class");
            if (mCallback != null){
                mCallback.removeFromCart();
            }

            return false; // Bottom to top
        }  else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            mCallback.addtoCart();
            return false; // Top to bottom
        }
        return false;
    }
    public interface Callbacks{
        void addtoCart();
        void removeFromCart();
    }
}
