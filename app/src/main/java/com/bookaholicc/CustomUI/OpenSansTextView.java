package com.bookaholicc.CustomUI;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bookaholicc.utils.FontCache;

/**
 * Created by nandhu on 18/7/17.
 *
 */

public class OpenSansTextView extends android.support.v7.widget.AppCompatTextView {

    public OpenSansTextView(Context context) {
        super(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/oa_light.ttf", context);
        setTypeface(customFont);
    }

    public OpenSansTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public OpenSansTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }
}
