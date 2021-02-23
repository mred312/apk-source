package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* renamed from: androidx.appcompat.graphics.drawable.a */
/* compiled from: DrawableContainer */
class C0200a extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private C0203c f674a;

    /* renamed from: b */
    private Rect f675b;

    /* renamed from: c */
    private Drawable f676c;

    /* renamed from: d */
    private Drawable f677d;

    /* renamed from: e */
    private int f678e = 255;

    /* renamed from: f */
    private boolean f679f;

    /* renamed from: g */
    private int f680g = -1;

    /* renamed from: h */
    private boolean f681h;

    /* renamed from: i */
    private Runnable f682i;

    /* renamed from: j */
    private long f683j;

    /* renamed from: k */
    private long f684k;

    /* renamed from: l */
    private C0202b f685l;

    /* renamed from: androidx.appcompat.graphics.drawable.a$a */
    /* compiled from: DrawableContainer */
    class C0201a implements Runnable {
        C0201a() {
        }

        public void run() {
            C0200a.this.mo1357a(true);
            C0200a.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.appcompat.graphics.drawable.a$b */
    /* compiled from: DrawableContainer */
    static class C0202b implements Drawable.Callback {

        /* renamed from: a */
        private Drawable.Callback f687a;

        C0202b() {
        }

        /* renamed from: a */
        public Drawable.Callback mo1365a() {
            Drawable.Callback callback = this.f687a;
            this.f687a = null;
            return callback;
        }

        /* renamed from: b */
        public C0202b mo1366b(Drawable.Callback callback) {
            this.f687a = callback;
            return this;
        }

        public void invalidateDrawable(@NonNull Drawable drawable) {
        }

        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
            Drawable.Callback callback = this.f687a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.f687a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* renamed from: androidx.appcompat.graphics.drawable.a$c */
    /* compiled from: DrawableContainer */
    static abstract class C0203c extends Drawable.ConstantState {

        /* renamed from: A */
        int f688A;

        /* renamed from: B */
        int f689B;

        /* renamed from: C */
        boolean f690C;

        /* renamed from: D */
        ColorFilter f691D;

        /* renamed from: E */
        boolean f692E;

        /* renamed from: F */
        ColorStateList f693F;

        /* renamed from: G */
        PorterDuff.Mode f694G;

        /* renamed from: H */
        boolean f695H;

        /* renamed from: I */
        boolean f696I;

        /* renamed from: a */
        final C0200a f697a;

        /* renamed from: b */
        Resources f698b;

        /* renamed from: c */
        int f699c = 160;

        /* renamed from: d */
        int f700d;

        /* renamed from: e */
        int f701e;

        /* renamed from: f */
        SparseArray<Drawable.ConstantState> f702f;

        /* renamed from: g */
        Drawable[] f703g;

        /* renamed from: h */
        int f704h;

        /* renamed from: i */
        boolean f705i;

        /* renamed from: j */
        boolean f706j;

        /* renamed from: k */
        Rect f707k;

        /* renamed from: l */
        boolean f708l;

        /* renamed from: m */
        boolean f709m;

        /* renamed from: n */
        int f710n;

        /* renamed from: o */
        int f711o;

        /* renamed from: p */
        int f712p;

        /* renamed from: q */
        int f713q;

        /* renamed from: r */
        boolean f714r;

        /* renamed from: s */
        int f715s;

        /* renamed from: t */
        boolean f716t;

        /* renamed from: u */
        boolean f717u;

        /* renamed from: v */
        boolean f718v;

        /* renamed from: w */
        boolean f719w;

        /* renamed from: x */
        boolean f720x;

        /* renamed from: y */
        boolean f721y;

        /* renamed from: z */
        int f722z;

        C0203c(C0203c cVar, C0200a aVar, Resources resources) {
            Resources resources2;
            this.f705i = false;
            this.f708l = false;
            this.f720x = true;
            this.f688A = 0;
            this.f689B = 0;
            this.f697a = aVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = cVar != null ? cVar.f698b : null;
            }
            this.f698b = resources2;
            int f = C0200a.m578f(resources, cVar != null ? cVar.f699c : 0);
            this.f699c = f;
            if (cVar != null) {
                this.f700d = cVar.f700d;
                this.f701e = cVar.f701e;
                this.f718v = true;
                this.f719w = true;
                this.f705i = cVar.f705i;
                this.f708l = cVar.f708l;
                this.f720x = cVar.f720x;
                this.f721y = cVar.f721y;
                this.f722z = cVar.f722z;
                this.f688A = cVar.f688A;
                this.f689B = cVar.f689B;
                this.f690C = cVar.f690C;
                this.f691D = cVar.f691D;
                this.f692E = cVar.f692E;
                this.f693F = cVar.f693F;
                this.f694G = cVar.f694G;
                this.f695H = cVar.f695H;
                this.f696I = cVar.f696I;
                if (cVar.f699c == f) {
                    if (cVar.f706j) {
                        this.f707k = new Rect(cVar.f707k);
                        this.f706j = true;
                    }
                    if (cVar.f709m) {
                        this.f710n = cVar.f710n;
                        this.f711o = cVar.f711o;
                        this.f712p = cVar.f712p;
                        this.f713q = cVar.f713q;
                        this.f709m = true;
                    }
                }
                if (cVar.f714r) {
                    this.f715s = cVar.f715s;
                    this.f714r = true;
                }
                if (cVar.f716t) {
                    this.f717u = cVar.f717u;
                    this.f716t = true;
                }
                Drawable[] drawableArr = cVar.f703g;
                this.f703g = new Drawable[drawableArr.length];
                this.f704h = cVar.f704h;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f702f;
                if (sparseArray != null) {
                    this.f702f = sparseArray.clone();
                } else {
                    this.f702f = new SparseArray<>(this.f704h);
                }
                int i = this.f704h;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f702f.put(i2, constantState);
                        } else {
                            this.f703g[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.f703g = new Drawable[10];
            this.f704h = 0;
        }

        /* renamed from: e */
        private void m587e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f702f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.f703g[this.f702f.keyAt(i)] = m588s(this.f702f.valueAt(i).newDrawable(this.f698b));
                }
                this.f702f = null;
            }
        }

        /* renamed from: s */
        private Drawable m588s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f722z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f697a);
            return mutate;
        }

        /* renamed from: a */
        public final int mo1370a(Drawable drawable) {
            int i = this.f704h;
            if (i >= this.f703g.length) {
                mo1385o(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f697a);
            this.f703g[i] = drawable;
            this.f704h++;
            this.f701e = drawable.getChangingConfigurations() | this.f701e;
            mo1386p();
            this.f707k = null;
            this.f706j = false;
            this.f709m = false;
            this.f718v = false;
            return i;
        }

        /* access modifiers changed from: package-private */
        @RequiresApi(21)
        /* renamed from: b */
        public final void mo1371b(Resources.Theme theme) {
            if (theme != null) {
                m587e();
                int i = this.f704h;
                Drawable[] drawableArr = this.f703g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f701e |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                mo1393y(theme.getResources());
            }
        }

        /* renamed from: c */
        public synchronized boolean mo1372c() {
            if (this.f718v) {
                return this.f719w;
            }
            m587e();
            this.f718v = true;
            int i = this.f704h;
            Drawable[] drawableArr = this.f703g;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.f719w = false;
                    return false;
                }
            }
            this.f719w = true;
            return true;
        }

        @RequiresApi(21)
        public boolean canApplyTheme() {
            int i = this.f704h;
            Drawable[] drawableArr = this.f703g;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f702f.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo1374d() {
            this.f709m = true;
            m587e();
            int i = this.f704h;
            Drawable[] drawableArr = this.f703g;
            this.f711o = -1;
            this.f710n = -1;
            this.f713q = 0;
            this.f712p = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f710n) {
                    this.f710n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f711o) {
                    this.f711o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f712p) {
                    this.f712p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f713q) {
                    this.f713q = minimumHeight;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public final int mo1375f() {
            return this.f703g.length;
        }

        /* renamed from: g */
        public final Drawable mo1376g(int i) {
            int indexOfKey;
            Drawable drawable = this.f703g[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f702f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable s = m588s(this.f702f.valueAt(indexOfKey).newDrawable(this.f698b));
            this.f703g[i] = s;
            this.f702f.removeAt(indexOfKey);
            if (this.f702f.size() == 0) {
                this.f702f = null;
            }
            return s;
        }

        public int getChangingConfigurations() {
            return this.f700d | this.f701e;
        }

        /* renamed from: h */
        public final int mo1378h() {
            return this.f704h;
        }

        /* renamed from: i */
        public final int mo1379i() {
            if (!this.f709m) {
                mo1374d();
            }
            return this.f711o;
        }

        /* renamed from: j */
        public final int mo1380j() {
            if (!this.f709m) {
                mo1374d();
            }
            return this.f713q;
        }

        /* renamed from: k */
        public final int mo1381k() {
            if (!this.f709m) {
                mo1374d();
            }
            return this.f712p;
        }

        /* renamed from: l */
        public final Rect mo1382l() {
            Rect rect = null;
            if (this.f705i) {
                return null;
            }
            Rect rect2 = this.f707k;
            if (rect2 != null || this.f706j) {
                return rect2;
            }
            m587e();
            Rect rect3 = new Rect();
            int i = this.f704h;
            Drawable[] drawableArr = this.f703g;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i3 = rect3.left;
                    if (i3 > rect.left) {
                        rect.left = i3;
                    }
                    int i4 = rect3.top;
                    if (i4 > rect.top) {
                        rect.top = i4;
                    }
                    int i5 = rect3.right;
                    if (i5 > rect.right) {
                        rect.right = i5;
                    }
                    int i6 = rect3.bottom;
                    if (i6 > rect.bottom) {
                        rect.bottom = i6;
                    }
                }
            }
            this.f706j = true;
            this.f707k = rect;
            return rect;
        }

        /* renamed from: m */
        public final int mo1383m() {
            if (!this.f709m) {
                mo1374d();
            }
            return this.f710n;
        }

        /* renamed from: n */
        public final int mo1384n() {
            if (this.f714r) {
                return this.f715s;
            }
            m587e();
            int i = this.f704h;
            Drawable[] drawableArr = this.f703g;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.f715s = opacity;
            this.f714r = true;
            return opacity;
        }

        /* renamed from: o */
        public void mo1385o(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.f703g, 0, drawableArr, 0, i);
            this.f703g = drawableArr;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public void mo1386p() {
            this.f714r = false;
            this.f716t = false;
        }

        /* renamed from: q */
        public final boolean mo1387q() {
            return this.f708l;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public abstract void mo1291r();

        /* renamed from: t */
        public final void mo1388t(boolean z) {
            this.f708l = z;
        }

        /* renamed from: u */
        public final void mo1389u(int i) {
            this.f688A = i;
        }

        /* renamed from: v */
        public final void mo1390v(int i) {
            this.f689B = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public final boolean mo1391w(int i, int i2) {
            int i3 = this.f704h;
            Drawable[] drawableArr = this.f703g;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.f722z = i;
            return z;
        }

        /* renamed from: x */
        public final void mo1392x(boolean z) {
            this.f705i = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: y */
        public final void mo1393y(Resources resources) {
            if (resources != null) {
                this.f698b = resources;
                int f = C0200a.m578f(resources, this.f699c);
                int i = this.f699c;
                this.f699c = f;
                if (i != f) {
                    this.f709m = false;
                    this.f706j = false;
                }
            }
        }
    }

    C0200a() {
    }

    /* renamed from: d */
    private void m576d(Drawable drawable) {
        if (this.f685l == null) {
            this.f685l = new C0202b();
        }
        C0202b bVar = this.f685l;
        bVar.mo1366b(drawable.getCallback());
        drawable.setCallback(bVar);
        try {
            if (this.f674a.f688A <= 0 && this.f679f) {
                drawable.setAlpha(this.f678e);
            }
            C0203c cVar = this.f674a;
            if (cVar.f692E) {
                drawable.setColorFilter(cVar.f691D);
            } else {
                if (cVar.f695H) {
                    DrawableCompat.setTintList(drawable, cVar.f693F);
                }
                C0203c cVar2 = this.f674a;
                if (cVar2.f696I) {
                    DrawableCompat.setTintMode(drawable, cVar2.f694G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f674a.f720x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (i >= 19) {
                drawable.setAutoMirrored(this.f674a.f690C);
            }
            Rect rect = this.f675b;
            if (i >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f685l.mo1365a());
        }
    }

    /* renamed from: e */
    private boolean m577e() {
        if (!isAutoMirrored() || DrawableCompat.getLayoutDirection(this) != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    static int m578f(@Nullable Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1357a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f679f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f676c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0038
            long r9 = r13.f683j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.f678e
            r3.setAlpha(r9)
            r13.f683j = r7
            goto L_0x003a
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.graphics.drawable.a$c r9 = r13.f674a
            int r9 = r9.f688A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f678e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L_0x003b
        L_0x0038:
            r13.f683j = r7
        L_0x003a:
            r3 = 0
        L_0x003b:
            android.graphics.drawable.Drawable r9 = r13.f677d
            if (r9 == 0) goto L_0x0065
            long r10 = r13.f684k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x0067
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0052
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f677d = r0
            r13.f684k = r7
            goto L_0x0067
        L_0x0052:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.a$c r4 = r13.f674a
            int r4 = r4.f689B
            int r3 = r3 / r4
            int r4 = r13.f678e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0068
        L_0x0065:
            r13.f684k = r7
        L_0x0067:
            r0 = r3
        L_0x0068:
            if (r14 == 0) goto L_0x0074
            if (r0 == 0) goto L_0x0074
            java.lang.Runnable r14 = r13.f682i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.C0200a.mo1357a(boolean):void");
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.f674a.mo1371b(theme);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0203c mo1242b() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo1358c() {
        return this.f680g;
    }

    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.f674a.canApplyTheme();
    }

    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f676c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f677d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo1359g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f680g
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.a$c r0 = r9.f674a
            int r0 = r0.f689B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.f677d
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.f676c
            if (r0 == 0) goto L_0x0029
            r9.f677d = r0
            androidx.appcompat.graphics.drawable.a$c r0 = r9.f674a
            int r0 = r0.f689B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f684k = r0
            goto L_0x0035
        L_0x0029:
            r9.f677d = r4
            r9.f684k = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.f676c
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            androidx.appcompat.graphics.drawable.a$c r0 = r9.f674a
            int r1 = r0.f704h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.mo1376g(r10)
            r9.f676c = r0
            r9.f680g = r10
            if (r0 == 0) goto L_0x005a
            androidx.appcompat.graphics.drawable.a$c r10 = r9.f674a
            int r10 = r10.f688A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f683j = r2
        L_0x0051:
            r9.m576d(r0)
            goto L_0x005a
        L_0x0055:
            r9.f676c = r4
            r10 = -1
            r9.f680g = r10
        L_0x005a:
            long r0 = r9.f683j
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0067
            long r0 = r9.f684k
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r0 = r9.f682i
            if (r0 != 0) goto L_0x0073
            androidx.appcompat.graphics.drawable.a$a r0 = new androidx.appcompat.graphics.drawable.a$a
            r0.<init>()
            r9.f682i = r0
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r0)
        L_0x0076:
            r9.mo1357a(r10)
        L_0x0079:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.C0200a.mo1359g(int):boolean");
    }

    public int getAlpha() {
        return this.f678e;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f674a.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f674a.mo1372c()) {
            return null;
        }
        this.f674a.f700d = getChangingConfigurations();
        return this.f674a;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.f676c;
    }

    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.f675b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f674a.mo1387q()) {
            return this.f674a.mo1379i();
        }
        Drawable drawable = this.f676c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f674a.mo1387q()) {
            return this.f674a.mo1383m();
        }
        Drawable drawable = this.f676c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f674a.mo1387q()) {
            return this.f674a.mo1380j();
        }
        Drawable drawable = this.f676c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f674a.mo1387q()) {
            return this.f674a.mo1381k();
        }
        Drawable drawable = this.f676c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f676c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f674a.mo1384n();
    }

    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.f676c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        boolean z;
        Rect l = this.f674a.mo1382l();
        if (l != null) {
            rect.set(l);
            z = (l.right | ((l.left | l.top) | l.bottom)) != 0;
        } else {
            Drawable drawable = this.f676c;
            if (drawable != null) {
                z = drawable.getPadding(rect);
            } else {
                z = super.getPadding(rect);
            }
        }
        if (m577e()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo1256h(C0203c cVar) {
        this.f674a = cVar;
        int i = this.f680g;
        if (i >= 0) {
            Drawable g = cVar.mo1376g(i);
            this.f676c = g;
            if (g != null) {
                m576d(g);
            }
        }
        this.f677d = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final void mo1361i(Resources resources) {
        this.f674a.mo1393y(resources);
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        C0203c cVar = this.f674a;
        if (cVar != null) {
            cVar.mo1386p();
        }
        if (drawable == this.f676c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f674a.f690C;
    }

    public boolean isStateful() {
        throw null;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f677d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f677d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f676c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f679f) {
                this.f676c.setAlpha(this.f678e);
            }
        }
        if (this.f684k != 0) {
            this.f684k = 0;
            z = true;
        }
        if (this.f683j != 0) {
            this.f683j = 0;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @NonNull
    public Drawable mutate() {
        if (!this.f681h && super.mutate() == this) {
            C0203c b = mo1242b();
            b.mo1291r();
            mo1256h(b);
            this.f681h = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f677d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f676c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        return this.f674a.mo1391w(i, mo1358c());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f677d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f676c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f677d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f676c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        if (drawable == this.f676c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (!this.f679f || this.f678e != i) {
            this.f679f = true;
            this.f678e = i;
            Drawable drawable = this.f676c;
            if (drawable == null) {
                return;
            }
            if (this.f683j == 0) {
                drawable.setAlpha(i);
            } else {
                mo1357a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        C0203c cVar = this.f674a;
        if (cVar.f690C != z) {
            cVar.f690C = z;
            Drawable drawable = this.f676c;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        C0203c cVar = this.f674a;
        cVar.f692E = true;
        if (cVar.f691D != colorFilter) {
            cVar.f691D = colorFilter;
            Drawable drawable = this.f676c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        C0203c cVar = this.f674a;
        if (cVar.f720x != z) {
            cVar.f720x = z;
            Drawable drawable = this.f676c;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setEnterFadeDuration(int i) {
        this.f674a.f688A = i;
    }

    public void setExitFadeDuration(int i) {
        this.f674a.f689B = i;
    }

    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f676c;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f675b;
        if (rect == null) {
            this.f675b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f676c;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i, i2, i3, i4);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        C0203c cVar = this.f674a;
        cVar.f695H = true;
        if (cVar.f693F != colorStateList) {
            cVar.f693F = colorStateList;
            DrawableCompat.setTintList(this.f676c, colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        C0203c cVar = this.f674a;
        cVar.f696I = true;
        if (cVar.f694G != mode) {
            cVar.f694G = mode;
            DrawableCompat.setTintMode(this.f676c, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f677d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f676c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.f676c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
