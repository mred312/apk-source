package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.AutoSizeableTextView;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.i */
/* compiled from: AppCompatTextHelper */
class C0324i {
    @NonNull

    /* renamed from: a */
    private final TextView f1638a;

    /* renamed from: b */
    private TintInfo f1639b;

    /* renamed from: c */
    private TintInfo f1640c;

    /* renamed from: d */
    private TintInfo f1641d;

    /* renamed from: e */
    private TintInfo f1642e;

    /* renamed from: f */
    private TintInfo f1643f;

    /* renamed from: g */
    private TintInfo f1644g;

    /* renamed from: h */
    private TintInfo f1645h;
    @NonNull

    /* renamed from: i */
    private final C0326j f1646i;

    /* renamed from: j */
    private int f1647j = 0;

    /* renamed from: k */
    private int f1648k = -1;

    /* renamed from: l */
    private Typeface f1649l;

    /* renamed from: m */
    private boolean f1650m;

    /* renamed from: androidx.appcompat.widget.i$a */
    /* compiled from: AppCompatTextHelper */
    class C0325a extends ResourcesCompat.FontCallback {

        /* renamed from: a */
        final /* synthetic */ int f1651a;

        /* renamed from: b */
        final /* synthetic */ int f1652b;

        /* renamed from: c */
        final /* synthetic */ WeakReference f1653c;

        C0325a(int i, int i2, WeakReference weakReference) {
            this.f1651a = i;
            this.f1652b = i2;
            this.f1653c = weakReference;
        }

        public void onFontRetrievalFailed(int i) {
        }

        public void onFontRetrieved(@NonNull Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.f1651a) != -1) {
                typeface = Typeface.create(typeface, i, (this.f1652b & 2) != 0);
            }
            C0324i.this.mo2982n(this.f1653c, typeface);
        }
    }

    C0324i(@NonNull TextView textView) {
        this.f1638a = textView;
        this.f1646i = new C0326j(textView);
    }

    /* renamed from: A */
    private void m1061A(int i, float f) {
        this.f1646i.mo3008y(i, f);
    }

    /* renamed from: B */
    private void m1062B(Context context, TintTypedArray tintTypedArray) {
        String string;
        int i = Build.VERSION.SDK_INT;
        this.f1647j = tintTypedArray.getInt(C0131R.styleable.TextAppearance_android_textStyle, this.f1647j);
        boolean z = false;
        if (i >= 28) {
            int i2 = tintTypedArray.getInt(C0131R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f1648k = i2;
            if (i2 != -1) {
                this.f1647j = (this.f1647j & 2) | 0;
            }
        }
        int i3 = C0131R.styleable.TextAppearance_android_fontFamily;
        if (tintTypedArray.hasValue(i3) || tintTypedArray.hasValue(C0131R.styleable.TextAppearance_fontFamily)) {
            this.f1649l = null;
            int i4 = C0131R.styleable.TextAppearance_fontFamily;
            if (tintTypedArray.hasValue(i4)) {
                i3 = i4;
            }
            int i5 = this.f1648k;
            int i6 = this.f1647j;
            if (!context.isRestricted()) {
                try {
                    Typeface font = tintTypedArray.getFont(i3, this.f1647j, new C0325a(i5, i6, new WeakReference(this.f1638a)));
                    if (font != null) {
                        if (i < 28 || this.f1648k == -1) {
                            this.f1649l = font;
                        } else {
                            this.f1649l = Typeface.create(Typeface.create(font, 0), this.f1648k, (this.f1647j & 2) != 0);
                        }
                    }
                    this.f1650m = this.f1649l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1649l == null && (string = tintTypedArray.getString(i3)) != null) {
                if (i < 28 || this.f1648k == -1) {
                    this.f1649l = Typeface.create(string, this.f1647j);
                    return;
                }
                Typeface create = Typeface.create(string, 0);
                int i7 = this.f1648k;
                if ((this.f1647j & 2) != 0) {
                    z = true;
                }
                this.f1649l = Typeface.create(create, i7, z);
                return;
            }
            return;
        }
        int i8 = C0131R.styleable.TextAppearance_android_typeface;
        if (tintTypedArray.hasValue(i8)) {
            this.f1650m = false;
            int i9 = tintTypedArray.getInt(i8, 1);
            if (i9 == 1) {
                this.f1649l = Typeface.SANS_SERIF;
            } else if (i9 == 2) {
                this.f1649l = Typeface.SERIF;
            } else if (i9 == 3) {
                this.f1649l = Typeface.MONOSPACE;
            }
        }
    }

    /* renamed from: a */
    private void m1063a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.m805d(drawable, tintInfo, this.f1638a.getDrawableState());
        }
    }

    /* renamed from: d */
    private static TintInfo m1064d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList c = appCompatDrawableManager.mo2204c(context, i);
        if (c == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = c;
        return tintInfo;
    }

    /* renamed from: x */
    private void m1065x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1638a.getCompoundDrawablesRelative();
            TextView textView = this.f1638a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (i >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1638a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f1638a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1638a.getCompoundDrawables();
            TextView textView3 = this.f1638a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: y */
    private void m1066y() {
        TintInfo tintInfo = this.f1645h;
        this.f1639b = tintInfo;
        this.f1640c = tintInfo;
        this.f1641d = tintInfo;
        this.f1642e = tintInfo;
        this.f1643f = tintInfo;
        this.f1644g = tintInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2971b() {
        if (!(this.f1639b == null && this.f1640c == null && this.f1641d == null && this.f1642e == null)) {
            Drawable[] compoundDrawables = this.f1638a.getCompoundDrawables();
            m1063a(compoundDrawables[0], this.f1639b);
            m1063a(compoundDrawables[1], this.f1640c);
            m1063a(compoundDrawables[2], this.f1641d);
            m1063a(compoundDrawables[3], this.f1642e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f1643f != null || this.f1644g != null) {
            Drawable[] compoundDrawablesRelative = this.f1638a.getCompoundDrawablesRelative();
            m1063a(compoundDrawablesRelative[0], this.f1643f);
            m1063a(compoundDrawablesRelative[2], this.f1644g);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: c */
    public void mo2972c() {
        this.f1646i.mo2995b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo2973e() {
        return this.f1646i.mo2997j();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo2974f() {
        return this.f1646i.mo2998k();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo2975g() {
        return this.f1646i.mo2999l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int[] mo2976h() {
        return this.f1646i.mo3000m();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo2977i() {
        return this.f1646i.mo3001n();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: j */
    public ColorStateList mo2978j() {
        TintInfo tintInfo = this.f1645h;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: k */
    public PorterDuff.Mode mo2979k() {
        TintInfo tintInfo = this.f1645h;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: l */
    public boolean mo2980l() {
        return this.f1646i.mo3003s();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ce  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2981m(@androidx.annotation.Nullable android.util.AttributeSet r24, int r25) {
        /*
            r23 = this;
            r7 = r23
            r8 = r24
            r9 = r25
            android.widget.TextView r0 = r7.f1638a
            android.content.Context r10 = r0.getContext()
            androidx.appcompat.widget.AppCompatDrawableManager r11 = androidx.appcompat.widget.AppCompatDrawableManager.get()
            int[] r2 = androidx.appcompat.C0131R.styleable.AppCompatTextHelper
            r12 = 0
            androidx.appcompat.widget.TintTypedArray r13 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r10, r8, r2, r9, r12)
            android.widget.TextView r0 = r7.f1638a
            android.content.Context r1 = r0.getContext()
            android.content.res.TypedArray r4 = r13.getWrappedTypeArray()
            r6 = 0
            r3 = r24
            r5 = r25
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r0, r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextHelper_android_textAppearance
            r14 = -1
            int r0 = r13.getResourceId(r0, r14)
            int r1 = androidx.appcompat.C0131R.styleable.AppCompatTextHelper_android_drawableLeft
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0042
            int r1 = r13.getResourceId(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = m1064d(r10, r11, r1)
            r7.f1639b = r1
        L_0x0042:
            int r1 = androidx.appcompat.C0131R.styleable.AppCompatTextHelper_android_drawableTop
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0054
            int r1 = r13.getResourceId(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = m1064d(r10, r11, r1)
            r7.f1640c = r1
        L_0x0054:
            int r1 = androidx.appcompat.C0131R.styleable.AppCompatTextHelper_android_drawableRight
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0066
            int r1 = r13.getResourceId(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = m1064d(r10, r11, r1)
            r7.f1641d = r1
        L_0x0066:
            int r1 = androidx.appcompat.C0131R.styleable.AppCompatTextHelper_android_drawableBottom
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0078
            int r1 = r13.getResourceId(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = m1064d(r10, r11, r1)
            r7.f1642e = r1
        L_0x0078:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x00a2
            int r2 = androidx.appcompat.C0131R.styleable.AppCompatTextHelper_android_drawableStart
            boolean r3 = r13.hasValue(r2)
            if (r3 == 0) goto L_0x0090
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = m1064d(r10, r11, r2)
            r7.f1643f = r2
        L_0x0090:
            int r2 = androidx.appcompat.C0131R.styleable.AppCompatTextHelper_android_drawableEnd
            boolean r3 = r13.hasValue(r2)
            if (r3 == 0) goto L_0x00a2
            int r2 = r13.getResourceId(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = m1064d(r10, r11, r2)
            r7.f1644g = r2
        L_0x00a2:
            r13.recycle()
            android.widget.TextView r2 = r7.f1638a
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            r5 = 23
            if (r0 == r14) goto L_0x011e
            int[] r6 = androidx.appcompat.C0131R.styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes((android.content.Context) r10, (int) r0, (int[]) r6)
            if (r2 != 0) goto L_0x00c9
            int r6 = androidx.appcompat.C0131R.styleable.TextAppearance_textAllCaps
            boolean r15 = r0.hasValue(r6)
            if (r15 == 0) goto L_0x00c9
            boolean r6 = r0.getBoolean(r6, r12)
            r15 = 1
            goto L_0x00cb
        L_0x00c9:
            r6 = 0
            r15 = 0
        L_0x00cb:
            r7.m1062B(r10, r0)
            if (r1 >= r5) goto L_0x00f9
            int r4 = androidx.appcompat.C0131R.styleable.TextAppearance_android_textColor
            boolean r17 = r0.hasValue(r4)
            if (r17 == 0) goto L_0x00dd
            android.content.res.ColorStateList r4 = r0.getColorStateList(r4)
            goto L_0x00de
        L_0x00dd:
            r4 = 0
        L_0x00de:
            int r13 = androidx.appcompat.C0131R.styleable.TextAppearance_android_textColorHint
            boolean r18 = r0.hasValue(r13)
            if (r18 == 0) goto L_0x00eb
            android.content.res.ColorStateList r13 = r0.getColorStateList(r13)
            goto L_0x00ec
        L_0x00eb:
            r13 = 0
        L_0x00ec:
            int r14 = androidx.appcompat.C0131R.styleable.TextAppearance_android_textColorLink
            boolean r19 = r0.hasValue(r14)
            if (r19 == 0) goto L_0x00fb
            android.content.res.ColorStateList r14 = r0.getColorStateList(r14)
            goto L_0x00fc
        L_0x00f9:
            r4 = 0
            r13 = 0
        L_0x00fb:
            r14 = 0
        L_0x00fc:
            int r5 = androidx.appcompat.C0131R.styleable.TextAppearance_textLocale
            boolean r20 = r0.hasValue(r5)
            if (r20 == 0) goto L_0x0109
            java.lang.String r5 = r0.getString(r5)
            goto L_0x010a
        L_0x0109:
            r5 = 0
        L_0x010a:
            if (r1 < r3) goto L_0x0119
            int r3 = androidx.appcompat.C0131R.styleable.TextAppearance_fontVariationSettings
            boolean r21 = r0.hasValue(r3)
            if (r21 == 0) goto L_0x0119
            java.lang.String r3 = r0.getString(r3)
            goto L_0x011a
        L_0x0119:
            r3 = 0
        L_0x011a:
            r0.recycle()
            goto L_0x0125
        L_0x011e:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0125:
            int[] r0 = androidx.appcompat.C0131R.styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r10, r8, r0, r9, r12)
            if (r2 != 0) goto L_0x0140
            int r12 = androidx.appcompat.C0131R.styleable.TextAppearance_textAllCaps
            boolean r22 = r0.hasValue(r12)
            if (r22 == 0) goto L_0x0140
            r22 = r3
            r3 = 0
            boolean r6 = r0.getBoolean(r12, r3)
            r3 = 23
            r15 = 1
            goto L_0x0144
        L_0x0140:
            r22 = r3
            r3 = 23
        L_0x0144:
            if (r1 >= r3) goto L_0x016a
            int r3 = androidx.appcompat.C0131R.styleable.TextAppearance_android_textColor
            boolean r12 = r0.hasValue(r3)
            if (r12 == 0) goto L_0x0152
            android.content.res.ColorStateList r4 = r0.getColorStateList(r3)
        L_0x0152:
            int r3 = androidx.appcompat.C0131R.styleable.TextAppearance_android_textColorHint
            boolean r12 = r0.hasValue(r3)
            if (r12 == 0) goto L_0x015e
            android.content.res.ColorStateList r13 = r0.getColorStateList(r3)
        L_0x015e:
            int r3 = androidx.appcompat.C0131R.styleable.TextAppearance_android_textColorLink
            boolean r12 = r0.hasValue(r3)
            if (r12 == 0) goto L_0x016a
            android.content.res.ColorStateList r14 = r0.getColorStateList(r3)
        L_0x016a:
            int r3 = androidx.appcompat.C0131R.styleable.TextAppearance_textLocale
            boolean r12 = r0.hasValue(r3)
            if (r12 == 0) goto L_0x0176
            java.lang.String r5 = r0.getString(r3)
        L_0x0176:
            r3 = 26
            if (r1 < r3) goto L_0x0187
            int r3 = androidx.appcompat.C0131R.styleable.TextAppearance_fontVariationSettings
            boolean r12 = r0.hasValue(r3)
            if (r12 == 0) goto L_0x0187
            java.lang.String r3 = r0.getString(r3)
            goto L_0x0189
        L_0x0187:
            r3 = r22
        L_0x0189:
            r12 = 28
            if (r1 < r12) goto L_0x01a6
            int r12 = androidx.appcompat.C0131R.styleable.TextAppearance_android_textSize
            boolean r16 = r0.hasValue(r12)
            if (r16 == 0) goto L_0x01a6
            r16 = r11
            r11 = -1
            int r12 = r0.getDimensionPixelSize(r12, r11)
            if (r12 != 0) goto L_0x01a8
            android.widget.TextView r11 = r7.f1638a
            r12 = 0
            r8 = 0
            r11.setTextSize(r8, r12)
            goto L_0x01a8
        L_0x01a6:
            r16 = r11
        L_0x01a8:
            r7.m1062B(r10, r0)
            r0.recycle()
            if (r4 == 0) goto L_0x01b5
            android.widget.TextView r0 = r7.f1638a
            r0.setTextColor(r4)
        L_0x01b5:
            if (r13 == 0) goto L_0x01bc
            android.widget.TextView r0 = r7.f1638a
            r0.setHintTextColor(r13)
        L_0x01bc:
            if (r14 == 0) goto L_0x01c3
            android.widget.TextView r0 = r7.f1638a
            r0.setLinkTextColor(r14)
        L_0x01c3:
            if (r2 != 0) goto L_0x01ca
            if (r15 == 0) goto L_0x01ca
            r7.mo2986r(r6)
        L_0x01ca:
            android.graphics.Typeface r0 = r7.f1649l
            if (r0 == 0) goto L_0x01e0
            int r2 = r7.f1648k
            r4 = -1
            if (r2 != r4) goto L_0x01db
            android.widget.TextView r2 = r7.f1638a
            int r4 = r7.f1647j
            r2.setTypeface(r0, r4)
            goto L_0x01e0
        L_0x01db:
            android.widget.TextView r2 = r7.f1638a
            r2.setTypeface(r0)
        L_0x01e0:
            if (r3 == 0) goto L_0x01e7
            android.widget.TextView r0 = r7.f1638a
            r0.setFontVariationSettings(r3)
        L_0x01e7:
            if (r5 == 0) goto L_0x020f
            r0 = 24
            if (r1 < r0) goto L_0x01f7
            android.widget.TextView r0 = r7.f1638a
            android.os.LocaleList r1 = android.os.LocaleList.forLanguageTags(r5)
            r0.setTextLocales(r1)
            goto L_0x020f
        L_0x01f7:
            r0 = 21
            if (r1 < r0) goto L_0x020f
            r0 = 44
            int r0 = r5.indexOf(r0)
            r1 = 0
            java.lang.String r0 = r5.substring(r1, r0)
            android.widget.TextView r1 = r7.f1638a
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            r1.setTextLocale(r0)
        L_0x020f:
            androidx.appcompat.widget.j r0 = r7.f1646i
            r1 = r24
            r0.mo3004t(r1, r9)
            boolean r0 = androidx.core.widget.AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE
            if (r0 == 0) goto L_0x0257
            androidx.appcompat.widget.j r0 = r7.f1646i
            int r0 = r0.mo3001n()
            if (r0 == 0) goto L_0x0257
            androidx.appcompat.widget.j r0 = r7.f1646i
            int[] r0 = r0.mo3000m()
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0257
            android.widget.TextView r2 = r7.f1638a
            int r2 = r2.getAutoSizeStepGranularity()
            float r2 = (float) r2
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0251
            android.widget.TextView r0 = r7.f1638a
            androidx.appcompat.widget.j r2 = r7.f1646i
            int r2 = r2.mo2998k()
            androidx.appcompat.widget.j r3 = r7.f1646i
            int r3 = r3.mo2997j()
            androidx.appcompat.widget.j r4 = r7.f1646i
            int r4 = r4.mo2999l()
            r5 = 0
            r0.setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5)
            goto L_0x0257
        L_0x0251:
            r5 = 0
            android.widget.TextView r2 = r7.f1638a
            r2.setAutoSizeTextTypeUniformWithPresetSizes(r0, r5)
        L_0x0257:
            int[] r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView
            androidx.appcompat.widget.TintTypedArray r8 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes((android.content.Context) r10, (android.util.AttributeSet) r1, (int[]) r0)
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_drawableLeftCompat
            r1 = -1
            int r0 = r8.getResourceId(r0, r1)
            r2 = r16
            if (r0 == r1) goto L_0x026e
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r10, r0)
            r3 = r0
            goto L_0x026f
        L_0x026e:
            r3 = 0
        L_0x026f:
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_drawableTopCompat
            int r0 = r8.getResourceId(r0, r1)
            if (r0 == r1) goto L_0x027d
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r10, r0)
            r4 = r0
            goto L_0x027e
        L_0x027d:
            r4 = 0
        L_0x027e:
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_drawableRightCompat
            int r0 = r8.getResourceId(r0, r1)
            if (r0 == r1) goto L_0x028c
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r10, r0)
            r5 = r0
            goto L_0x028d
        L_0x028c:
            r5 = 0
        L_0x028d:
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_drawableBottomCompat
            int r0 = r8.getResourceId(r0, r1)
            if (r0 == r1) goto L_0x029b
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r10, r0)
            r6 = r0
            goto L_0x029c
        L_0x029b:
            r6 = 0
        L_0x029c:
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_drawableStartCompat
            int r0 = r8.getResourceId(r0, r1)
            if (r0 == r1) goto L_0x02aa
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r10, r0)
            r9 = r0
            goto L_0x02ab
        L_0x02aa:
            r9 = 0
        L_0x02ab:
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_drawableEndCompat
            int r0 = r8.getResourceId(r0, r1)
            if (r0 == r1) goto L_0x02b9
            android.graphics.drawable.Drawable r0 = r2.getDrawable(r10, r0)
            r10 = r0
            goto L_0x02ba
        L_0x02b9:
            r10 = 0
        L_0x02ba:
            r0 = r23
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r9
            r6 = r10
            r0.m1065x(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_drawableTint
            boolean r1 = r8.hasValue(r0)
            if (r1 == 0) goto L_0x02d6
            android.content.res.ColorStateList r0 = r8.getColorStateList(r0)
            android.widget.TextView r1 = r7.f1638a
            androidx.core.widget.TextViewCompat.setCompoundDrawableTintList(r1, r0)
        L_0x02d6:
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_drawableTintMode
            boolean r1 = r8.hasValue(r0)
            if (r1 == 0) goto L_0x02ee
            r1 = -1
            int r0 = r8.getInt(r0, r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r0, r2)
            android.widget.TextView r2 = r7.f1638a
            androidx.core.widget.TextViewCompat.setCompoundDrawableTintMode(r2, r0)
            goto L_0x02ef
        L_0x02ee:
            r1 = -1
        L_0x02ef:
            int r0 = androidx.appcompat.C0131R.styleable.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.getDimensionPixelSize(r0, r1)
            int r2 = androidx.appcompat.C0131R.styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r8.getDimensionPixelSize(r2, r1)
            int r3 = androidx.appcompat.C0131R.styleable.AppCompatTextView_lineHeight
            int r3 = r8.getDimensionPixelSize(r3, r1)
            r8.recycle()
            if (r0 == r1) goto L_0x030b
            android.widget.TextView r4 = r7.f1638a
            androidx.core.widget.TextViewCompat.setFirstBaselineToTopHeight(r4, r0)
        L_0x030b:
            if (r2 == r1) goto L_0x0312
            android.widget.TextView r0 = r7.f1638a
            androidx.core.widget.TextViewCompat.setLastBaselineToBottomHeight(r0, r2)
        L_0x0312:
            if (r3 == r1) goto L_0x0319
            android.widget.TextView r0 = r7.f1638a
            androidx.core.widget.TextViewCompat.setLineHeight(r0, r3)
        L_0x0319:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0324i.mo2981m(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo2982n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1650m) {
            this.f1649l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f1647j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: o */
    public void mo2983o(boolean z, int i, int i2, int i3, int i4) {
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            mo2972c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo2984p() {
        mo2971b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo2985q(Context context, int i) {
        String string;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, C0131R.styleable.TextAppearance);
        int i2 = C0131R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i2)) {
            mo2986r(obtainStyledAttributes.getBoolean(i2, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            int i4 = C0131R.styleable.TextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i4) && (colorStateList3 = obtainStyledAttributes.getColorStateList(i4)) != null) {
                this.f1638a.setTextColor(colorStateList3);
            }
            int i5 = C0131R.styleable.TextAppearance_android_textColorLink;
            if (obtainStyledAttributes.hasValue(i5) && (colorStateList2 = obtainStyledAttributes.getColorStateList(i5)) != null) {
                this.f1638a.setLinkTextColor(colorStateList2);
            }
            int i6 = C0131R.styleable.TextAppearance_android_textColorHint;
            if (obtainStyledAttributes.hasValue(i6) && (colorStateList = obtainStyledAttributes.getColorStateList(i6)) != null) {
                this.f1638a.setHintTextColor(colorStateList);
            }
        }
        int i7 = C0131R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i7) && obtainStyledAttributes.getDimensionPixelSize(i7, -1) == 0) {
            this.f1638a.setTextSize(0, 0.0f);
        }
        m1062B(context, obtainStyledAttributes);
        if (i3 >= 26) {
            int i8 = C0131R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i8) && (string = obtainStyledAttributes.getString(i8)) != null) {
                this.f1638a.setFontVariationSettings(string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.f1649l;
        if (typeface != null) {
            this.f1638a.setTypeface(typeface, this.f1647j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo2986r(boolean z) {
        this.f1638a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo2987s(int i, int i2, int i3, int i4) {
        this.f1646i.mo3005u(i, i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo2988t(@NonNull int[] iArr, int i) {
        this.f1646i.mo3006v(iArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo2989u(int i) {
        this.f1646i.mo3007w(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo2990v(@Nullable ColorStateList colorStateList) {
        if (this.f1645h == null) {
            this.f1645h = new TintInfo();
        }
        TintInfo tintInfo = this.f1645h;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        m1066y();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo2991w(@Nullable PorterDuff.Mode mode) {
        if (this.f1645h == null) {
            this.f1645h = new TintInfo();
        }
        TintInfo tintInfo = this.f1645h;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        m1066y();
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: z */
    public void mo2992z(int i, float f) {
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !mo2980l()) {
            m1061A(i, f);
        }
    }
}
