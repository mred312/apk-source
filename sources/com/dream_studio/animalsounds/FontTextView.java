package com.dream_studio.animalsounds;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class FontTextView extends TextView {

    /* renamed from: a */
    private static Typeface f6619a;

    public FontTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FontTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (f6619a == null) {
            f6619a = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
        }
        setTypeface(f6619a);
    }
}
