package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.p003os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat implements Spannable {

    /* renamed from: e */
    private static final Object f2523e = new Object();
    @GuardedBy("sLock")
    @NonNull

    /* renamed from: f */
    private static Executor f2524f;
    @NonNull

    /* renamed from: a */
    private final Spannable f2525a;
    @NonNull

    /* renamed from: b */
    private final Params f2526b;
    @NonNull

    /* renamed from: c */
    private final int[] f2527c;
    @Nullable

    /* renamed from: d */
    private final PrecomputedText f2528d;

    /* renamed from: androidx.core.text.PrecomputedTextCompat$a */
    private static class C0511a extends FutureTask<PrecomputedTextCompat> {

        /* renamed from: androidx.core.text.PrecomputedTextCompat$a$a */
        private static class C0512a implements Callable<PrecomputedTextCompat> {

            /* renamed from: a */
            private Params f2538a;

            /* renamed from: b */
            private CharSequence f2539b;

            C0512a(@NonNull Params params, @NonNull CharSequence charSequence) {
                this.f2538a = params;
                this.f2539b = charSequence;
            }

            /* renamed from: a */
            public PrecomputedTextCompat call() {
                return PrecomputedTextCompat.create(this.f2539b, this.f2538a);
            }
        }

        C0511a(@NonNull Params params, @NonNull CharSequence charSequence) {
            super(new C0512a(params, charSequence));
        }
    }

    private PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull Params params, @NonNull int[] iArr) {
        this.f2525a = new SpannableString(charSequence);
        this.f2526b = params;
        this.f2527c = iArr;
        this.f2528d = null;
    }

    @SuppressLint({"NewApi"})
    public static PrecomputedTextCompat create(@NonNull CharSequence charSequence, @NonNull Params params) {
        PrecomputedText.Params params2;
        int i = Build.VERSION.SDK_INT;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(params);
        try {
            TraceCompat.beginSection("PrecomputedText");
            if (i >= 29 && (params2 = params.f2533e) != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params2), params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                int indexOf = TextUtils.indexOf(charSequence, 10, i2, length);
                i2 = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i2));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
            }
            if (i >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
            } else if (i >= 21) {
                new StaticLayout(charSequence, params.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(charSequence, params, iArr);
            TraceCompat.endSection();
            return precomputedTextCompat;
        } finally {
            TraceCompat.endSection();
        }
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence charSequence, @NonNull Params params, @Nullable Executor executor) {
        C0511a aVar = new C0511a(params, charSequence);
        if (executor == null) {
            synchronized (f2523e) {
                if (f2524f == null) {
                    f2524f = Executors.newFixedThreadPool(1);
                }
                executor = f2524f;
            }
        }
        executor.execute(aVar);
        return aVar;
    }

    public char charAt(int i) {
        return this.f2525a.charAt(i);
    }

    @SuppressLint({"NewApi"})
    @IntRange(from = 0)
    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f2528d.getParagraphCount();
        }
        return this.f2527c.length;
    }

    @SuppressLint({"NewApi"})
    @IntRange(from = 0)
    public int getParagraphEnd(@IntRange(from = 0) int i) {
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f2528d.getParagraphEnd(i);
        }
        return this.f2527c[i];
    }

    @SuppressLint({"NewApi"})
    @IntRange(from = 0)
    public int getParagraphStart(@IntRange(from = 0) int i) {
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f2528d.getParagraphStart(i);
        }
        if (i == 0) {
            return 0;
        }
        return this.f2527c[i - 1];
    }

    @NonNull
    public Params getParams() {
        return this.f2526b;
    }

    @RequiresApi(28)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.f2525a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public int getSpanEnd(Object obj) {
        return this.f2525a.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f2525a.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f2525a.getSpanStart(obj);
    }

    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f2528d.getSpans(i, i2, cls);
        }
        return this.f2525a.getSpans(i, i2, cls);
    }

    public int length() {
        return this.f2525a.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f2525a.nextSpanTransition(i, i2, cls);
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2528d.removeSpan(obj);
        } else {
            this.f2525a.removeSpan(obj);
        }
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2528d.setSpan(obj, i, i2, i3);
        } else {
            this.f2525a.setSpan(obj, i, i2, i3);
        }
    }

    public CharSequence subSequence(int i, int i2) {
        return this.f2525a.subSequence(i, i2);
    }

    @NonNull
    public String toString() {
        return this.f2525a.toString();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull Params params) {
        this.f2525a = precomputedText;
        this.f2526b = params;
        this.f2527c = null;
        this.f2528d = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public static final class Params {
        @NonNull

        /* renamed from: a */
        private final TextPaint f2529a;
        @Nullable

        /* renamed from: b */
        private final TextDirectionHeuristic f2530b;

        /* renamed from: c */
        private final int f2531c;

        /* renamed from: d */
        private final int f2532d;

        /* renamed from: e */
        final PrecomputedText.Params f2533e;

        public static class Builder {
            @NonNull

            /* renamed from: a */
            private final TextPaint f2534a;

            /* renamed from: b */
            private TextDirectionHeuristic f2535b;

            /* renamed from: c */
            private int f2536c;

            /* renamed from: d */
            private int f2537d;

            public Builder(@NonNull TextPaint textPaint) {
                this.f2534a = textPaint;
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    this.f2536c = 1;
                    this.f2537d = 1;
                } else {
                    this.f2537d = 0;
                    this.f2536c = 0;
                }
                if (i >= 18) {
                    this.f2535b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2535b = null;
                }
            }

            @NonNull
            public Params build() {
                return new Params(this.f2534a, this.f2535b, this.f2536c, this.f2537d);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int i) {
                this.f2536c = i;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int i) {
                this.f2537d = i;
                return this;
            }

            @RequiresApi(18)
            public Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f2535b = textDirectionHeuristic;
                return this;
            }
        }

        @SuppressLint({"NewApi"})
        Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2533e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f2533e = null;
            }
            this.f2529a = textPaint;
            this.f2530b = textDirectionHeuristic;
            this.f2531c = i;
            this.f2532d = i2;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (!equalsWithoutTextDirection(params)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f2530b == params.getTextDirection();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params params) {
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.f2531c != params.getBreakStrategy() || this.f2532d != params.getHyphenationFrequency())) || this.f2529a.getTextSize() != params.getTextPaint().getTextSize() || this.f2529a.getTextScaleX() != params.getTextPaint().getTextScaleX() || this.f2529a.getTextSkewX() != params.getTextPaint().getTextSkewX()) {
                return false;
            }
            if ((i >= 21 && (this.f2529a.getLetterSpacing() != params.getTextPaint().getLetterSpacing() || !TextUtils.equals(this.f2529a.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()))) || this.f2529a.getFlags() != params.getTextPaint().getFlags()) {
                return false;
            }
            if (i >= 24) {
                if (!this.f2529a.getTextLocales().equals(params.getTextPaint().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f2529a.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                return false;
            }
            if (this.f2529a.getTypeface() == null) {
                if (params.getTextPaint().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f2529a.getTypeface().equals(params.getTextPaint().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            return this.f2531c;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.f2532d;
        }

        @RequiresApi(18)
        @Nullable
        public TextDirectionHeuristic getTextDirection() {
            return this.f2530b;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.f2529a;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return ObjectsCompat.hash(Float.valueOf(this.f2529a.getTextSize()), Float.valueOf(this.f2529a.getTextScaleX()), Float.valueOf(this.f2529a.getTextSkewX()), Float.valueOf(this.f2529a.getLetterSpacing()), Integer.valueOf(this.f2529a.getFlags()), this.f2529a.getTextLocales(), this.f2529a.getTypeface(), Boolean.valueOf(this.f2529a.isElegantTextHeight()), this.f2530b, Integer.valueOf(this.f2531c), Integer.valueOf(this.f2532d));
            } else if (i >= 21) {
                return ObjectsCompat.hash(Float.valueOf(this.f2529a.getTextSize()), Float.valueOf(this.f2529a.getTextScaleX()), Float.valueOf(this.f2529a.getTextSkewX()), Float.valueOf(this.f2529a.getLetterSpacing()), Integer.valueOf(this.f2529a.getFlags()), this.f2529a.getTextLocale(), this.f2529a.getTypeface(), Boolean.valueOf(this.f2529a.isElegantTextHeight()), this.f2530b, Integer.valueOf(this.f2531c), Integer.valueOf(this.f2532d));
            } else if (i >= 18) {
                return ObjectsCompat.hash(Float.valueOf(this.f2529a.getTextSize()), Float.valueOf(this.f2529a.getTextScaleX()), Float.valueOf(this.f2529a.getTextSkewX()), Integer.valueOf(this.f2529a.getFlags()), this.f2529a.getTextLocale(), this.f2529a.getTypeface(), this.f2530b, Integer.valueOf(this.f2531c), Integer.valueOf(this.f2532d));
            } else if (i >= 17) {
                return ObjectsCompat.hash(Float.valueOf(this.f2529a.getTextSize()), Float.valueOf(this.f2529a.getTextScaleX()), Float.valueOf(this.f2529a.getTextSkewX()), Integer.valueOf(this.f2529a.getFlags()), this.f2529a.getTextLocale(), this.f2529a.getTypeface(), this.f2530b, Integer.valueOf(this.f2531c), Integer.valueOf(this.f2532d));
            } else {
                return ObjectsCompat.hash(Float.valueOf(this.f2529a.getTextSize()), Float.valueOf(this.f2529a.getTextScaleX()), Float.valueOf(this.f2529a.getTextSkewX()), Integer.valueOf(this.f2529a.getFlags()), this.f2529a.getTypeface(), this.f2530b, Integer.valueOf(this.f2531c), Integer.valueOf(this.f2532d));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f2529a.getTextSize());
            sb.append(", textScaleX=" + this.f2529a.getTextScaleX());
            sb.append(", textSkewX=" + this.f2529a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                sb.append(", letterSpacing=" + this.f2529a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f2529a.isElegantTextHeight());
            }
            if (i >= 24) {
                sb.append(", textLocale=" + this.f2529a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f2529a.getTextLocale());
            }
            sb.append(", typeface=" + this.f2529a.getTypeface());
            if (i >= 26) {
                sb.append(", variationSettings=" + this.f2529a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2530b);
            sb.append(", breakStrategy=" + this.f2531c);
            sb.append(", hyphenationFrequency=" + this.f2532d);
            sb.append("}");
            return sb.toString();
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params params) {
            this.f2529a = params.getTextPaint();
            this.f2530b = params.getTextDirection();
            this.f2531c = params.getBreakStrategy();
            this.f2532d = params.getHyphenationFrequency();
            this.f2533e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
