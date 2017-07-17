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

public class OpenSansBold extends android.support.v7.widget.AppCompatTextView {

    public OpenSansBold(Context context) {
        super(context);
        applyCustomFont(context);
    }
    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/os_semi_bold.ttf", context);
        setTypeface(customFont);
    }

    public OpenSansBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public OpenSansBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }
}
