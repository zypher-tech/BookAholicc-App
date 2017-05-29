package com.bookaholicc.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by nandhu on 17/10/16.
 *
 *
 * Font Inistialisation takes a lot of Time so we use cache here to reduce Time
 */

public class FontCache {
    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String fontname, Context context) {
        Typeface typeface = fontCache.get(fontname);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontname);
            } catch (Exception e) {
                Log.d("TYPE FACE", "getTypeface:null ");
                return null;
            }

            fontCache.put(fontname, typeface);
        }

        return typeface;
    }

}
