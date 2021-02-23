package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

public class WindowInsetsCompat {
    @NonNull
    public static final WindowInsetsCompat CONSUMED;

    /* renamed from: a */
    private final C0559j f2684a;

    public static final class Type {

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* renamed from: a */
        static int m1817a() {
            return -1;
        }

        /* renamed from: b */
        static int m1818b(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    @RequiresApi(30)
    /* renamed from: androidx.core.view.WindowInsetsCompat$c */
    private static class C0552c extends C0551b {
        C0552c() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo4741d(int i, @NonNull Insets insets) {
            this.f2691c.setInsets(C0560k.m1887a(i), insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo4742e(int i, @NonNull Insets insets) {
            this.f2691c.setInsetsIgnoringVisibility(C0560k.m1887a(i), insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo4743k(int i, boolean z) {
            this.f2691c.setVisible(C0560k.m1887a(i), z);
        }

        C0552c(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    /* renamed from: androidx.core.view.WindowInsetsCompat$d */
    private static class C0553d {

        /* renamed from: a */
        private final WindowInsetsCompat f2692a;

        /* renamed from: b */
        private Insets[] f2693b;

        C0553d() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo4744a() {
            Insets[] insetsArr = this.f2693b;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.m1818b(1)];
                Insets insets2 = this.f2693b[Type.m1818b(2)];
                if (insets != null && insets2 != null) {
                    mo4735i(Insets.max(insets, insets2));
                } else if (insets != null) {
                    mo4735i(insets);
                } else if (insets2 != null) {
                    mo4735i(insets2);
                }
                Insets insets3 = this.f2693b[Type.m1818b(16)];
                if (insets3 != null) {
                    mo4739h(insets3);
                }
                Insets insets4 = this.f2693b[Type.m1818b(32)];
                if (insets4 != null) {
                    mo4737f(insets4);
                }
                Insets insets5 = this.f2693b[Type.m1818b(64)];
                if (insets5 != null) {
                    mo4740j(insets5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public WindowInsetsCompat mo4734b() {
            mo4744a();
            return this.f2692a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo4736c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo4741d(int i, @NonNull Insets insets) {
            if (this.f2693b == null) {
                this.f2693b = new Insets[9];
            }
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.f2693b[Type.m1818b(i2)] = insets;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo4742e(int i, @NonNull Insets insets) {
            if (i == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo4737f(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo4738g(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo4739h(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo4735i(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo4740j(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo4743k(int i, boolean z) {
        }

        C0553d(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f2692a = windowInsetsCompat;
        }
    }

    @RequiresApi(28)
    /* renamed from: androidx.core.view.WindowInsetsCompat$g */
    private static class C0556g extends C0555f {
        C0556g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: a */
        public WindowInsetsCompat mo4760a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2694c.consumeDisplayCutout());
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: e */
        public DisplayCutoutCompat mo4761e() {
            return DisplayCutoutCompat.m1710c(this.f2694c.getDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0556g)) {
                return false;
            }
            return Objects.equals(this.f2694c, ((C0556g) obj).f2694c);
        }

        public int hashCode() {
            return this.f2694c.hashCode();
        }

        C0556g(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull C0556g gVar) {
            super(windowInsetsCompat, (C0555f) gVar);
        }
    }

    @RequiresApi(30)
    /* renamed from: androidx.core.view.WindowInsetsCompat$i */
    private static class C0558i extends C0557h {
        @NonNull

        /* renamed from: l */
        static final WindowInsetsCompat f2703l = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        C0558i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @NonNull
        /* renamed from: f */
        public Insets mo4746f(int i) {
            return Insets.toCompatInsets(this.f2694c.getInsets(C0560k.m1887a(i)));
        }

        @NonNull
        /* renamed from: g */
        public Insets mo4747g(int i) {
            return Insets.toCompatInsets(this.f2694c.getInsetsIgnoringVisibility(C0560k.m1887a(i)));
        }

        /* renamed from: p */
        public boolean mo4751p(int i) {
            return this.f2694c.isVisible(C0560k.m1887a(i));
        }

        C0558i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull C0558i iVar) {
            super(windowInsetsCompat, (C0557h) iVar);
        }
    }

    /* renamed from: androidx.core.view.WindowInsetsCompat$j */
    private static class C0559j {
        @NonNull

        /* renamed from: b */
        static final WindowInsetsCompat f2704b = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();

        /* renamed from: a */
        final WindowInsetsCompat f2705a;

        C0559j(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f2705a = windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: a */
        public WindowInsetsCompat mo4760a() {
            return this.f2705a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public WindowInsetsCompat mo4756b() {
            return this.f2705a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: c */
        public WindowInsetsCompat mo4757c() {
            return this.f2705a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo4745d(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: e */
        public DisplayCutoutCompat mo4761e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0559j)) {
                return false;
            }
            C0559j jVar = (C0559j) obj;
            if (mo4750o() != jVar.mo4750o() || mo4759n() != jVar.mo4759n() || !ObjectsCompat.equals(mo4748k(), jVar.mo4748k()) || !ObjectsCompat.equals(mo4758i(), jVar.mo4758i()) || !ObjectsCompat.equals(mo4761e(), jVar.mo4761e())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: f */
        public Insets mo4746f(int i) {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: g */
        public Insets mo4747g(int i) {
            if ((i & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: h */
        public Insets mo4764h() {
            return mo4748k();
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(mo4750o()), Boolean.valueOf(mo4759n()), mo4748k(), mo4758i(), mo4761e());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: i */
        public Insets mo4758i() {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: j */
        public Insets mo4765j() {
            return mo4748k();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: k */
        public Insets mo4748k() {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: l */
        public Insets mo4766l() {
            return mo4748k();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: m */
        public WindowInsetsCompat mo4749m(int i, int i2, int i3, int i4) {
            return f2704b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public boolean mo4759n() {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public boolean mo4750o() {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public boolean mo4751p(int i) {
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public void mo4752q(@NonNull Rect rect, int i) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public void mo4753r(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }
    }

    @RequiresApi(30)
    /* renamed from: androidx.core.view.WindowInsetsCompat$k */
    private static final class C0560k {
        /* renamed from: a */
        static int m1887a(int i) {
            int i2;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i & i4) != 0) {
                    if (i4 == 1) {
                        i2 = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        i2 = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        i2 = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        i2 = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        i2 = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        i2 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        i2 = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        i2 = WindowInsets.Type.displayCutout();
                    }
                    i3 |= i2;
                }
            }
            return i3;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = C0558i.f2703l;
        } else {
            CONSUMED = C0559j.f2704b;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f2684a = new C0558i(this, windowInsets);
        } else if (i >= 29) {
            this.f2684a = new C0557h(this, windowInsets);
        } else if (i >= 28) {
            this.f2684a = new C0556g(this, windowInsets);
        } else if (i >= 21) {
            this.f2684a = new C0555f(this, windowInsets);
        } else if (i >= 20) {
            this.f2684a = new C0554e(this, windowInsets);
        } else {
            this.f2684a = new C0559j(this);
        }
    }

    /* renamed from: b */
    static Insets m1813b(@NonNull Insets insets, int i, int i2, int i3, int i4) {
        int max = Math.max(0, insets.left - i);
        int max2 = Math.max(0, insets.top - i2);
        int max3 = Math.max(0, insets.right - i3);
        int max4 = Math.max(0, insets.bottom - i4);
        if (max == i && max2 == i2 && max3 == i3 && max4 == i4) {
            return insets;
        }
        return Insets.m1529of(max, max2, max3, max4);
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, (View) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4689a(@NonNull View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        mo4690c(rect, view.getHeight());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4690c(@NonNull Rect rect, int i) {
        this.f2684a.mo4752q(rect, i);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.f2684a.mo4760a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.f2684a.mo4756b();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.f2684a.mo4757c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4694d(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.f2684a.mo4753r(windowInsetsCompat);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.equals(this.f2684a, ((WindowInsetsCompat) obj).f2684a);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.f2684a.mo4761e();
    }

    @NonNull
    public Insets getInsets(int i) {
        return this.f2684a.mo4746f(i);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i) {
        return this.f2684a.mo4747g(i);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.f2684a.mo4764h();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.f2684a.mo4758i().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.f2684a.mo4758i().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.f2684a.mo4758i().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.f2684a.mo4758i().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.f2684a.mo4758i();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.f2684a.mo4765j();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.f2684a.mo4748k().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.f2684a.mo4748k().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.f2684a.mo4748k().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.f2684a.mo4748k().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.f2684a.mo4748k();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.f2684a.mo4766l();
    }

    public boolean hasInsets() {
        Insets insets = getInsets(Type.m1817a());
        Insets insets2 = Insets.NONE;
        return !insets.equals(insets2) || !getInsetsIgnoringVisibility(Type.m1817a()).equals(insets2) || getDisplayCutout() != null;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.f2684a.mo4758i().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.f2684a.mo4748k().equals(Insets.NONE);
    }

    public int hashCode() {
        C0559j jVar = this.f2684a;
        if (jVar == null) {
            return 0;
        }
        return jVar.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.f2684a.mo4759n();
    }

    public boolean isRound() {
        return this.f2684a.mo4750o();
    }

    public boolean isVisible(int i) {
        return this.f2684a.mo4751p(i);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new Builder(this).setSystemWindowInsets(Insets.m1529of(i, i2, i3, i4)).build();
    }

    @RequiresApi(20)
    @Nullable
    public WindowInsets toWindowInsets() {
        C0559j jVar = this.f2684a;
        if (jVar instanceof C0554e) {
            return ((C0554e) jVar).f2694c;
        }
        return null;
    }

    @RequiresApi(api = 20)
    /* renamed from: androidx.core.view.WindowInsetsCompat$a */
    private static class C0550a extends C0553d {

        /* renamed from: d */
        private static Field f2686d = null;

        /* renamed from: e */
        private static boolean f2687e = false;

        /* renamed from: f */
        private static Constructor<WindowInsets> f2688f = null;

        /* renamed from: g */
        private static boolean f2689g = false;

        /* renamed from: c */
        private WindowInsets f2690c;

        C0550a() {
            this.f2690c = m1819l();
        }

        @Nullable
        /* renamed from: l */
        private static WindowInsets m1819l() {
            if (!f2687e) {
                try {
                    f2686d = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                f2687e = true;
            }
            Field field = f2686d;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!f2689g) {
                try {
                    f2688f = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                f2689g = true;
            }
            Constructor<WindowInsets> constructor = f2688f;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public WindowInsetsCompat mo4734b() {
            mo4744a();
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2690c);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo4735i(@NonNull Insets insets) {
            WindowInsets windowInsets = this.f2690c;
            if (windowInsets != null) {
                this.f2690c = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        C0550a(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f2690c = windowInsetsCompat.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    /* renamed from: androidx.core.view.WindowInsetsCompat$b */
    private static class C0551b extends C0553d {

        /* renamed from: c */
        final WindowInsets.Builder f2691c;

        C0551b() {
            this.f2691c = new WindowInsets.Builder();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public WindowInsetsCompat mo4734b() {
            mo4744a();
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2691c.build());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo4736c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.f2691c.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.mo4535b() : null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo4737f(@NonNull Insets insets) {
            this.f2691c.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo4738g(@NonNull Insets insets) {
            this.f2691c.setStableInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo4739h(@NonNull Insets insets) {
            this.f2691c.setSystemGestureInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo4735i(@NonNull Insets insets) {
            this.f2691c.setSystemWindowInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo4740j(@NonNull Insets insets) {
            this.f2691c.setTappableElementInsets(insets.toPlatformInsets());
        }

        C0551b(@NonNull WindowInsetsCompat windowInsetsCompat) {
            WindowInsets.Builder builder;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f2691c = builder;
        }
    }

    @RequiresApi(21)
    /* renamed from: androidx.core.view.WindowInsetsCompat$f */
    private static class C0555f extends C0554e {

        /* renamed from: h */
        private Insets f2699h = null;

        C0555f(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public WindowInsetsCompat mo4756b() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2694c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: c */
        public WindowInsetsCompat mo4757c() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2694c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: i */
        public final Insets mo4758i() {
            if (this.f2699h == null) {
                this.f2699h = Insets.m1529of(this.f2694c.getStableInsetLeft(), this.f2694c.getStableInsetTop(), this.f2694c.getStableInsetRight(), this.f2694c.getStableInsetBottom());
            }
            return this.f2699h;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public boolean mo4759n() {
            return this.f2694c.isConsumed();
        }

        C0555f(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull C0555f fVar) {
            super(windowInsetsCompat, (C0554e) fVar);
        }
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.mo4694d(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.mo4689a(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        return this.f2684a.mo4749m(i, i2, i3, i4);
    }

    @RequiresApi(20)
    /* renamed from: androidx.core.view.WindowInsetsCompat$e */
    private static class C0554e extends C0559j {
        @NonNull

        /* renamed from: c */
        final WindowInsets f2694c;

        /* renamed from: d */
        private Insets f2695d;

        /* renamed from: e */
        private WindowInsetsCompat f2696e;

        /* renamed from: f */
        private Rect f2697f;

        /* renamed from: g */
        private int f2698g;

        C0554e(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f2695d = null;
            this.f2694c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        /* renamed from: s */
        private Insets m1843s(int i, boolean z) {
            Insets insets = Insets.NONE;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    insets = Insets.max(insets, mo4754t(i2, z));
                }
            }
            return insets;
        }

        /* renamed from: u */
        private Insets m1844u() {
            WindowInsetsCompat windowInsetsCompat = this.f2696e;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getStableInsets();
            }
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo4745d(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.mo4694d(this.f2696e);
            windowInsetsCompat.mo4690c(this.f2697f, this.f2698g);
        }

        @NonNull
        /* renamed from: f */
        public Insets mo4746f(int i) {
            return m1843s(i, false);
        }

        @NonNull
        /* renamed from: g */
        public Insets mo4747g(int i) {
            return m1843s(i, true);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: k */
        public final Insets mo4748k() {
            if (this.f2695d == null) {
                this.f2695d = Insets.m1529of(this.f2694c.getSystemWindowInsetLeft(), this.f2694c.getSystemWindowInsetTop(), this.f2694c.getSystemWindowInsetRight(), this.f2694c.getSystemWindowInsetBottom());
            }
            return this.f2695d;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: m */
        public WindowInsetsCompat mo4749m(int i, int i2, int i3, int i4) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.f2694c));
            builder.setSystemWindowInsets(WindowInsetsCompat.m1813b(mo4748k(), i, i2, i3, i4));
            builder.setStableInsets(WindowInsetsCompat.m1813b(mo4758i(), i, i2, i3, i4));
            return builder.build();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public boolean mo4750o() {
            return this.f2694c.isRound();
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        /* renamed from: p */
        public boolean mo4751p(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0 && !mo4755v(i2)) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public void mo4752q(@NonNull Rect rect, int i) {
            this.f2697f = rect;
            this.f2698g = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public void mo4753r(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.f2696e = windowInsetsCompat;
        }

        /* access modifiers changed from: protected */
        @NonNull
        /* renamed from: t */
        public Insets mo4754t(int i, boolean z) {
            int i2;
            DisplayCutoutCompat displayCutoutCompat;
            if (i != 1) {
                if (i != 2) {
                    if (i == 8) {
                        Insets k = mo4748k();
                        Insets u = m1844u();
                        int i3 = k.bottom;
                        if (i3 > u.bottom) {
                            return Insets.m1529of(0, 0, 0, i3);
                        }
                        Rect rect = this.f2697f;
                        if (rect == null || rect.isEmpty() || (i2 = this.f2698g - this.f2697f.bottom) <= u.bottom) {
                            return Insets.NONE;
                        }
                        return Insets.m1529of(0, 0, 0, i2);
                    } else if (i == 16) {
                        return mo4765j();
                    } else {
                        if (i == 32) {
                            return mo4764h();
                        }
                        if (i == 64) {
                            return mo4766l();
                        }
                        if (i != 128) {
                            return Insets.NONE;
                        }
                        WindowInsetsCompat windowInsetsCompat = this.f2696e;
                        if (windowInsetsCompat != null) {
                            displayCutoutCompat = windowInsetsCompat.getDisplayCutout();
                        } else {
                            displayCutoutCompat = mo4761e();
                        }
                        if (displayCutoutCompat != null) {
                            return Insets.m1529of(displayCutoutCompat.getSafeInsetLeft(), displayCutoutCompat.getSafeInsetTop(), displayCutoutCompat.getSafeInsetRight(), displayCutoutCompat.getSafeInsetBottom());
                        }
                        return Insets.NONE;
                    }
                } else if (z) {
                    Insets u2 = m1844u();
                    Insets i4 = mo4758i();
                    return Insets.m1529of(Math.max(u2.left, i4.left), 0, Math.max(u2.right, i4.right), Math.max(u2.bottom, i4.bottom));
                } else {
                    Insets k2 = mo4748k();
                    WindowInsetsCompat windowInsetsCompat2 = this.f2696e;
                    Insets stableInsets = windowInsetsCompat2 != null ? windowInsetsCompat2.getStableInsets() : null;
                    int i5 = k2.bottom;
                    if (stableInsets != null) {
                        i5 = Math.min(i5, stableInsets.bottom);
                    }
                    return Insets.m1529of(k2.left, 0, k2.right, i5);
                }
            } else if (z) {
                return Insets.m1529of(0, Math.max(m1844u().top, mo4748k().top), 0, 0);
            } else {
                return Insets.m1529of(0, mo4748k().top, 0, 0);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: v */
        public boolean mo4755v(int i) {
            if (!(i == 1 || i == 2)) {
                if (i == 4) {
                    return false;
                }
                if (!(i == 8 || i == 128)) {
                    return true;
                }
            }
            return !mo4754t(i, false).equals(Insets.NONE);
        }

        C0554e(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull C0554e eVar) {
            this(windowInsetsCompat, new WindowInsets(eVar.f2694c));
        }
    }

    @RequiresApi(29)
    /* renamed from: androidx.core.view.WindowInsetsCompat$h */
    private static class C0557h extends C0556g {

        /* renamed from: i */
        private Insets f2700i = null;

        /* renamed from: j */
        private Insets f2701j = null;

        /* renamed from: k */
        private Insets f2702k = null;

        C0557h(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: h */
        public Insets mo4764h() {
            if (this.f2701j == null) {
                this.f2701j = Insets.toCompatInsets(this.f2694c.getMandatorySystemGestureInsets());
            }
            return this.f2701j;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: j */
        public Insets mo4765j() {
            if (this.f2700i == null) {
                this.f2700i = Insets.toCompatInsets(this.f2694c.getSystemGestureInsets());
            }
            return this.f2700i;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: l */
        public Insets mo4766l() {
            if (this.f2702k == null) {
                this.f2702k = Insets.toCompatInsets(this.f2694c.getTappableElementInsets());
            }
            return this.f2702k;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: m */
        public WindowInsetsCompat mo4749m(int i, int i2, int i3, int i4) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2694c.inset(i, i2, i3, i4));
        }

        C0557h(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull C0557h hVar) {
            super(windowInsetsCompat, (C0556g) hVar);
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.m1530of(rect)).build();
    }

    public static final class Builder {

        /* renamed from: a */
        private final C0553d f2685a;

        public Builder() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.f2685a = new C0552c();
            } else if (i >= 29) {
                this.f2685a = new C0551b();
            } else if (i >= 20) {
                this.f2685a = new C0550a();
            } else {
                this.f2685a = new C0553d();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.f2685a.mo4734b();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.f2685a.mo4736c(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setInsets(int i, @NonNull Insets insets) {
            this.f2685a.mo4741d(i, insets);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
            this.f2685a.mo4742e(i, insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.f2685a.mo4737f(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets insets) {
            this.f2685a.mo4738g(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.f2685a.mo4739h(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.f2685a.mo4735i(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.f2685a.mo4740j(insets);
            return this;
        }

        @NonNull
        public Builder setVisible(int i, boolean z) {
            this.f2685a.mo4743k(i, z);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.f2685a = new C0552c(windowInsetsCompat);
            } else if (i >= 29) {
                this.f2685a = new C0551b(windowInsetsCompat);
            } else if (i >= 20) {
                this.f2685a = new C0550a(windowInsetsCompat);
            } else {
                this.f2685a = new C0553d(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            C0559j jVar = windowInsetsCompat.f2684a;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && (jVar instanceof C0558i)) {
                this.f2684a = new C0558i(this, (C0558i) jVar);
            } else if (i >= 29 && (jVar instanceof C0557h)) {
                this.f2684a = new C0557h(this, (C0557h) jVar);
            } else if (i >= 28 && (jVar instanceof C0556g)) {
                this.f2684a = new C0556g(this, (C0556g) jVar);
            } else if (i >= 21 && (jVar instanceof C0555f)) {
                this.f2684a = new C0555f(this, (C0555f) jVar);
            } else if (i < 20 || !(jVar instanceof C0554e)) {
                this.f2684a = new C0559j(this);
            } else {
                this.f2684a = new C0554e(this, (C0554e) jVar);
            }
            jVar.mo4745d(this);
            return;
        }
        this.f2684a = new C0559j(this);
    }
}
