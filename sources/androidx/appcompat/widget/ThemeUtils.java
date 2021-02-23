package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ThemeUtils {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f1514a = new ThreadLocal<>();

    /* renamed from: b */
    static final int[] f1515b = {-16842910};

    /* renamed from: c */
    static final int[] f1516c = {16842908};

    /* renamed from: d */
    static final int[] f1517d = {16842919};

    /* renamed from: e */
    static final int[] f1518e = {16842912};

    /* renamed from: f */
    static final int[] f1519f = new int[0];

    /* renamed from: g */
    private static final int[] f1520g = new int[1];

    private ThemeUtils() {
    }

    /* renamed from: a */
    static int m987a(@NonNull Context context, int i, float f) {
        int themeAttrColor = getThemeAttrColor(context, i);
        return ColorUtils.setAlphaComponent(themeAttrColor, Math.round(((float) Color.alpha(themeAttrColor)) * f));
    }

    /* renamed from: b */
    private static TypedValue m988b() {
        ThreadLocal<TypedValue> threadLocal = f1514a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static void checkAppCompatTheme(@NonNull View view, @NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C0131R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(C0131R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static ColorStateList createDisabledStateList(int i, int i2) {
        return new ColorStateList(new int[][]{f1515b, f1519f}, new int[]{i2, i});
    }

    public static int getDisabledThemeAttrColor(@NonNull Context context, int i) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(f1515b, themeAttrColorStateList.getDefaultColor());
        }
        TypedValue b = m988b();
        context.getTheme().resolveAttribute(16842803, b, true);
        return m987a(context, i, b.getFloat());
    }

    public static int getThemeAttrColor(@NonNull Context context, int i) {
        int[] iArr = f1520g;
        iArr[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Nullable
    public static ColorStateList getThemeAttrColorStateList(@NonNull Context context, int i) {
        int[] iArr = f1520g;
        iArr[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
