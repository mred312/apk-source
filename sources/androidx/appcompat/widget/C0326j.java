package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.C0131R;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.appcompat.widget.j */
/* compiled from: AppCompatTextViewAutoSizeHelper */
class C0326j {

    /* renamed from: l */
    private static final RectF f1655l = new RectF();

    /* renamed from: m */
    private static ConcurrentHashMap<String, Method> f1656m = new ConcurrentHashMap<>();

    /* renamed from: n */
    private static ConcurrentHashMap<String, Field> f1657n = new ConcurrentHashMap<>();

    /* renamed from: a */
    private int f1658a = 0;

    /* renamed from: b */
    private boolean f1659b = false;

    /* renamed from: c */
    private float f1660c = -1.0f;

    /* renamed from: d */
    private float f1661d = -1.0f;

    /* renamed from: e */
    private float f1662e = -1.0f;

    /* renamed from: f */
    private int[] f1663f = new int[0];

    /* renamed from: g */
    private boolean f1664g = false;

    /* renamed from: h */
    private TextPaint f1665h;
    @NonNull

    /* renamed from: i */
    private final TextView f1666i;

    /* renamed from: j */
    private final Context f1667j;

    /* renamed from: k */
    private final C0329c f1668k;

    @RequiresApi(23)
    /* renamed from: androidx.appcompat.widget.j$a */
    /* compiled from: AppCompatTextViewAutoSizeHelper */
    private static class C0327a extends C0329c {
        C0327a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3009a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) C0326j.m1103r(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @RequiresApi(29)
    /* renamed from: androidx.appcompat.widget.j$b */
    /* compiled from: AppCompatTextViewAutoSizeHelper */
    private static class C0328b extends C0327a {
        C0328b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3009a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo3010b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* renamed from: androidx.appcompat.widget.j$c */
    /* compiled from: AppCompatTextViewAutoSizeHelper */
    private static class C0329c {
        C0329c() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3009a(StaticLayout.Builder builder, TextView textView) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo3010b(TextView textView) {
            return ((Boolean) C0326j.m1103r(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    C0326j(@NonNull TextView textView) {
        this.f1666i = textView;
        this.f1667j = textView.getContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.f1668k = new C0328b();
        } else if (i >= 23) {
            this.f1668k = new C0327a();
        } else {
            this.f1668k = new C0329c();
        }
    }

    /* renamed from: A */
    private void m1089A(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f1663f = m1095c(iArr);
            m1090B();
        }
    }

    /* renamed from: B */
    private boolean m1090B() {
        int[] iArr = this.f1663f;
        int length = iArr.length;
        boolean z = length > 0;
        this.f1664g = z;
        if (z) {
            this.f1658a = 1;
            this.f1661d = (float) iArr[0];
            this.f1662e = (float) iArr[length - 1];
            this.f1660c = -1.0f;
        }
        return z;
    }

    /* renamed from: C */
    private boolean m1091C(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1666i.getText();
        TransformationMethod transformationMethod = this.f1666i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f1666i)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f1666i.getMaxLines() : -1;
        mo3002q(i);
        StaticLayout e = mo2996e(text, (Layout.Alignment) m1103r(this.f1666i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (e.getLineCount() <= maxLines && e.getLineEnd(e.getLineCount() - 1) == text.length())) && ((float) e.getHeight()) <= rectF.bottom;
    }

    /* renamed from: D */
    private boolean m1092D() {
        return !(this.f1666i instanceof AppCompatEditText);
    }

    /* renamed from: E */
    private void m1093E(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 > 0.0f) {
            this.f1658a = 1;
            this.f1661d = f;
            this.f1662e = f2;
            this.f1660c = f3;
            this.f1664g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
    }

    /* renamed from: a */
    private static <T> T m1094a(@NonNull Object obj, @NonNull String str, @NonNull T t) {
        try {
            Field o = m1101o(str);
            if (o == null) {
                return t;
            }
            return o.get(obj);
        } catch (IllegalAccessException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return t;
        }
    }

    /* renamed from: c */
    private int[] m1095c(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: d */
    private void m1096d() {
        this.f1658a = 0;
        this.f1661d = -1.0f;
        this.f1662e = -1.0f;
        this.f1660c = -1.0f;
        this.f1663f = new int[0];
        this.f1659b = false;
    }

    @RequiresApi(23)
    /* renamed from: f */
    private StaticLayout m1097f(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1665h, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f1666i.getLineSpacingExtra(), this.f1666i.getLineSpacingMultiplier()).setIncludePad(this.f1666i.getIncludeFontPadding()).setBreakStrategy(this.f1666i.getBreakStrategy()).setHyphenationFrequency(this.f1666i.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            this.f1668k.mo3009a(obtain, this.f1666i);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    /* renamed from: g */
    private StaticLayout m1098g(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f1665h, i, alignment, ((Float) m1094a(this.f1666i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) m1094a(this.f1666i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) m1094a(this.f1666i, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    @RequiresApi(16)
    /* renamed from: h */
    private StaticLayout m1099h(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f1665h, i, alignment, this.f1666i.getLineSpacingMultiplier(), this.f1666i.getLineSpacingExtra(), this.f1666i.getIncludeFontPadding());
    }

    /* renamed from: i */
    private int m1100i(RectF rectF) {
        int length = this.f1663f.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 1;
            int i3 = 0;
            while (i2 <= i) {
                int i4 = (i2 + i) / 2;
                if (m1091C(this.f1663f[i4], rectF)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    i2 = i5;
                } else {
                    i3 = i4 - 1;
                    i = i3;
                }
            }
            return this.f1663f[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    @Nullable
    /* renamed from: o */
    private static Field m1101o(@NonNull String str) {
        try {
            Field field = f1657n.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f1657n.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return null;
        }
    }

    @Nullable
    /* renamed from: p */
    private static Method m1102p(@NonNull String str) {
        try {
            Method method = f1656m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1656m.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* renamed from: r */
    static <T> T m1103r(@NonNull Object obj, @NonNull String str, @NonNull T t) {
        try {
            return m1102p(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    /* renamed from: x */
    private void m1104x(float f) {
        if (f != this.f1666i.getPaint().getTextSize()) {
            this.f1666i.getPaint().setTextSize(f);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f1666i.isInLayout() : false;
            if (this.f1666i.getLayout() != null) {
                this.f1659b = false;
                try {
                    Method p = m1102p("nullLayouts");
                    if (p != null) {
                        p.invoke(this.f1666i, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.f1666i.requestLayout();
                } else {
                    this.f1666i.forceLayout();
                }
                this.f1666i.invalidate();
            }
        }
    }

    /* renamed from: z */
    private boolean m1105z() {
        if (!m1092D() || this.f1658a != 1) {
            this.f1659b = false;
        } else {
            if (!this.f1664g || this.f1663f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1662e - this.f1661d) / this.f1660c))) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round(this.f1661d + (((float) i) * this.f1660c));
                }
                this.f1663f = m1095c(iArr);
            }
            this.f1659b = true;
        }
        return this.f1659b;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: b */
    public void mo2995b() {
        int i;
        if (mo3003s()) {
            if (this.f1659b) {
                if (this.f1666i.getMeasuredHeight() > 0 && this.f1666i.getMeasuredWidth() > 0) {
                    if (this.f1668k.mo3010b(this.f1666i)) {
                        i = 1048576;
                    } else {
                        i = (this.f1666i.getMeasuredWidth() - this.f1666i.getTotalPaddingLeft()) - this.f1666i.getTotalPaddingRight();
                    }
                    int height = (this.f1666i.getHeight() - this.f1666i.getCompoundPaddingBottom()) - this.f1666i.getCompoundPaddingTop();
                    if (i > 0 && height > 0) {
                        RectF rectF = f1655l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) i;
                            rectF.bottom = (float) height;
                            float i2 = (float) m1100i(rectF);
                            if (i2 != this.f1666i.getTextSize()) {
                                mo3008y(0, i2);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1659b = true;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: e */
    public StaticLayout mo2996e(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return m1097f(charSequence, alignment, i, i2);
        }
        if (i3 >= 16) {
            return m1099h(charSequence, alignment, i);
        }
        return m1098g(charSequence, alignment, i);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: j */
    public int mo2997j() {
        return Math.round(this.f1662e);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: k */
    public int mo2998k() {
        return Math.round(this.f1661d);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: l */
    public int mo2999l() {
        return Math.round(this.f1660c);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: m */
    public int[] mo3000m() {
        return this.f1663f;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: n */
    public int mo3001n() {
        return this.f1658a;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: q */
    public void mo3002q(int i) {
        TextPaint textPaint = this.f1665h;
        if (textPaint == null) {
            this.f1665h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1665h.set(this.f1666i.getPaint());
        this.f1665h.setTextSize((float) i);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: s */
    public boolean mo3003s() {
        return m1092D() && this.f1658a != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo3004t(@Nullable AttributeSet attributeSet, int i) {
        int resourceId;
        Context context = this.f1667j;
        int[] iArr = C0131R.styleable.AppCompatTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        TextView textView = this.f1666i;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i, 0);
        int i2 = C0131R.styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f1658a = obtainStyledAttributes.getInt(i2, 0);
        }
        int i3 = C0131R.styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = obtainStyledAttributes.hasValue(i3) ? obtainStyledAttributes.getDimension(i3, -1.0f) : -1.0f;
        int i4 = C0131R.styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = obtainStyledAttributes.hasValue(i4) ? obtainStyledAttributes.getDimension(i4, -1.0f) : -1.0f;
        int i5 = C0131R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = obtainStyledAttributes.hasValue(i5) ? obtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = C0131R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i6) && (resourceId = obtainStyledAttributes.getResourceId(i6, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m1089A(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!m1092D()) {
            this.f1658a = 0;
        } else if (this.f1658a == 1) {
            if (!this.f1664g) {
                DisplayMetrics displayMetrics = this.f1667j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m1093E(dimension2, dimension3, dimension);
            }
            m1105z();
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: u */
    public void mo3005u(int i, int i2, int i3, int i4) {
        if (m1092D()) {
            DisplayMetrics displayMetrics = this.f1667j.getResources().getDisplayMetrics();
            m1093E(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (m1105z()) {
                mo2995b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: v */
    public void mo3006v(@NonNull int[] iArr, int i) {
        if (m1092D()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1667j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                    }
                }
                this.f1663f = m1095c(iArr2);
                if (!m1090B()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1664g = false;
            }
            if (m1105z()) {
                mo2995b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: w */
    public void mo3007w(int i) {
        if (!m1092D()) {
            return;
        }
        if (i == 0) {
            m1096d();
        } else if (i == 1) {
            DisplayMetrics displayMetrics = this.f1667j.getResources().getDisplayMetrics();
            m1093E(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (m1105z()) {
                mo2995b();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: y */
    public void mo3008y(int i, float f) {
        Resources resources;
        Context context = this.f1667j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        m1104x(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }
}
