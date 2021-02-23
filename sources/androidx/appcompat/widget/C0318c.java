package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

/* renamed from: androidx.appcompat.widget.c */
/* compiled from: AppCompatCompoundButtonHelper */
class C0318c {
    @NonNull

    /* renamed from: a */
    private final CompoundButton f1619a;

    /* renamed from: b */
    private ColorStateList f1620b = null;

    /* renamed from: c */
    private PorterDuff.Mode f1621c = null;

    /* renamed from: d */
    private boolean f1622d = false;

    /* renamed from: e */
    private boolean f1623e = false;

    /* renamed from: f */
    private boolean f1624f;

    C0318c(@NonNull CompoundButton compoundButton) {
        this.f1619a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2952a() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f1619a);
        if (buttonDrawable == null) {
            return;
        }
        if (this.f1622d || this.f1623e) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.f1622d) {
                DrawableCompat.setTintList(mutate, this.f1620b);
            }
            if (this.f1623e) {
                DrawableCompat.setTintMode(mutate, this.f1621c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1619a.getDrawableState());
            }
            this.f1619a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.core.widget.CompoundButtonCompat.getButtonDrawable(r2.f1619a);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo2953b(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f1619a
            android.graphics.drawable.Drawable r0 = androidx.core.widget.CompoundButtonCompat.getButtonDrawable(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0318c.mo2953b(int):int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ColorStateList mo2954c() {
        return this.f1620b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public PorterDuff.Mode mo2955d() {
        return this.f1621c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[SYNTHETIC, Splitter:B:12:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[Catch:{ all -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[Catch:{ all -> 0x0084 }] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2956e(@androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.f1619a
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.C0131R.styleable.CompoundButton
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.f1619a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.getWrappedTypeArray()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.C0131R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x003a
            int r10 = r0.getResourceId(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x003a
            android.widget.CompoundButton r11 = r9.f1619a     // Catch:{ NotFoundException -> 0x003a }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003a }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r10)     // Catch:{ NotFoundException -> 0x003a }
            r11.setButtonDrawable(r10)     // Catch:{ NotFoundException -> 0x003a }
            r10 = 1
            goto L_0x003b
        L_0x003a:
            r10 = 0
        L_0x003b:
            if (r10 != 0) goto L_0x0058
            int r10 = androidx.appcompat.C0131R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0058
            int r10 = r0.getResourceId(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x0058
            android.widget.CompoundButton r11 = r9.f1619a     // Catch:{ all -> 0x0084 }
            android.content.Context r1 = r11.getContext()     // Catch:{ all -> 0x0084 }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r10)     // Catch:{ all -> 0x0084 }
            r11.setButtonDrawable(r10)     // Catch:{ all -> 0x0084 }
        L_0x0058:
            int r10 = androidx.appcompat.C0131R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0069
            android.widget.CompoundButton r11 = r9.f1619a     // Catch:{ all -> 0x0084 }
            android.content.res.ColorStateList r10 = r0.getColorStateList(r10)     // Catch:{ all -> 0x0084 }
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r11, r10)     // Catch:{ all -> 0x0084 }
        L_0x0069:
            int r10 = androidx.appcompat.C0131R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0080
            android.widget.CompoundButton r11 = r9.f1619a     // Catch:{ all -> 0x0084 }
            r1 = -1
            int r10 = r0.getInt(r10, r1)     // Catch:{ all -> 0x0084 }
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r10, r1)     // Catch:{ all -> 0x0084 }
            androidx.core.widget.CompoundButtonCompat.setButtonTintMode(r11, r10)     // Catch:{ all -> 0x0084 }
        L_0x0080:
            r0.recycle()
            return
        L_0x0084:
            r10 = move-exception
            r0.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0318c.mo2956e(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo2957f() {
        if (this.f1624f) {
            this.f1624f = false;
            return;
        }
        this.f1624f = true;
        mo2952a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo2958g(ColorStateList colorStateList) {
        this.f1620b = colorStateList;
        this.f1622d = true;
        mo2952a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo2959h(@Nullable PorterDuff.Mode mode) {
        this.f1621c = mode;
        this.f1623e = true;
        mo2952a();
    }
}
