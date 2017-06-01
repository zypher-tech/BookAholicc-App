package com.bookaholicc.CustomUI;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bookaholicc.utils.FontCache;

/**
 * Created by nandhu on 31/5/17.
 * The Deafult TextView
 */

public class WhitenyBooksFont extends android.support.v7.widget.AppCompatTextView {
    public WhitenyBooksFont(Context context) {
            super(context);
        applyCustomFont(context);
    }

    public WhitenyBooksFont(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public WhitenyBooksFont(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }
    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/whiteny_book_reg.ttf", context);
        setTypeface(customFont);
    }
}
