package com.bookaholicc.CustomUI;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bookaholicc.utils.FontCache;


/**
 * Created by nandhu on 2/4/17.
 * A TextView Whihc Applies Custom Font From Assets Folder
 *
 * Fonts are initialized and Maintained In {@link FontCache}
 *
 *
 */

public class HelviticaTv extends android.support.v7.widget.AppCompatTextView {
    public HelviticaTv(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public HelviticaTv(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public HelviticaTv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/grand_hotel.otf", context);
        setTypeface(customFont);
    }
}
