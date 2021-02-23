package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;

    /* renamed from: a */
    private final FragmentFactory f3207a;

    /* renamed from: b */
    private final ClassLoader f3208b;

    /* renamed from: c */
    ArrayList<C0657a> f3209c;

    /* renamed from: d */
    int f3210d;

    /* renamed from: e */
    int f3211e;

    /* renamed from: f */
    int f3212f;

    /* renamed from: g */
    int f3213g;

    /* renamed from: h */
    int f3214h;

    /* renamed from: i */
    boolean f3215i;

    /* renamed from: j */
    boolean f3216j;
    @Nullable

    /* renamed from: k */
    String f3217k;

    /* renamed from: l */
    int f3218l;

    /* renamed from: m */
    CharSequence f3219m;

    /* renamed from: n */
    int f3220n;

    /* renamed from: o */
    CharSequence f3221o;

    /* renamed from: p */
    ArrayList<String> f3222p;

    /* renamed from: q */
    ArrayList<String> f3223q;

    /* renamed from: r */
    boolean f3224r;

    /* renamed from: s */
    ArrayList<Runnable> f3225s;

    /* renamed from: androidx.fragment.app.FragmentTransaction$a */
    static final class C0657a {

        /* renamed from: a */
        int f3226a;

        /* renamed from: b */
        Fragment f3227b;

        /* renamed from: c */
        int f3228c;

        /* renamed from: d */
        int f3229d;

        /* renamed from: e */
        int f3230e;

        /* renamed from: f */
        int f3231f;

        /* renamed from: g */
        Lifecycle.State f3232g;

        /* renamed from: h */
        Lifecycle.State f3233h;

        C0657a() {
        }

        C0657a(int i, Fragment fragment) {
            this.f3226a = i;
            this.f3227b = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f3232g = state;
            this.f3233h = state;
        }

        C0657a(int i, @NonNull Fragment fragment, Lifecycle.State state) {
            this.f3226a = i;
            this.f3227b = fragment;
            this.f3232g = fragment.f2999R;
            this.f3233h = state;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.f3209c = new ArrayList<>();
        this.f3216j = true;
        this.f3224r = false;
        this.f3207a = null;
        this.f3208b = null;
    }

    @NonNull
    /* renamed from: d */
    private Fragment m2338d(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        FragmentFactory fragmentFactory = this.f3207a;
        if (fragmentFactory != null) {
            ClassLoader classLoader = this.f3208b;
            if (classLoader != null) {
                Fragment instantiate = fragmentFactory.instantiate(classLoader, cls.getName());
                if (bundle != null) {
                    instantiate.setArguments(bundle);
                }
                return instantiate;
            }
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(m2338d(cls, bundle), str);
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View view, @NonNull String str) {
        if (C0697j.m2470D()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                if (this.f3222p == null) {
                    this.f3222p = new ArrayList<>();
                    this.f3223q = new ArrayList<>();
                } else if (this.f3223q.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.f3222p.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
                this.f3222p.add(transitionName);
                this.f3223q.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String str) {
        if (this.f3216j) {
            this.f3215i = true;
            this.f3217k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment fragment) {
        mo5908c(new C0657a(7, fragment));
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public FragmentTransaction mo5907b(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, @Nullable String str) {
        fragment.f2988G = viewGroup;
        return add(viewGroup.getId(), fragment, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5908c(C0657a aVar) {
        this.f3209c.add(aVar);
        aVar.f3228c = this.f3210d;
        aVar.f3229d = this.f3211e;
        aVar.f3230e = this.f3212f;
        aVar.f3231f = this.f3213g;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        mo5908c(new C0657a(6, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (!this.f3215i) {
            this.f3216j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5915e(int i, Fragment fragment, @Nullable String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.f3032y;
            if (str2 == null || str.equals(str2)) {
                fragment.f3032y = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f3032y + " now " + str);
            }
        }
        if (i != 0) {
            if (i != -1) {
                int i3 = fragment.f3030w;
                if (i3 == 0 || i3 == i) {
                    fragment.f3030w = i;
                    fragment.f3031x = i;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f3030w + " now " + i);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        mo5908c(new C0657a(i2, fragment));
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        mo5908c(new C0657a(4, fragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.f3216j;
    }

    public boolean isEmpty() {
        return this.f3209c.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        mo5908c(new C0657a(3, fragment));
        return this;
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return replace(i, cls, bundle, (String) null);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable runnable) {
        disallowAddToBackStack();
        if (this.f3225s == null) {
            this.f3225s = new ArrayList<>();
        }
        this.f3225s.add(runnable);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int i) {
        this.f3220n = i;
        this.f3221o = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int i) {
        this.f3218l = i;
        this.f3219m = null;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        mo5908c(new C0657a(10, fragment, state));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        mo5908c(new C0657a(8, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.f3224r = z;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int i) {
        this.f3214h = i;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(@StyleRes int i) {
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        mo5908c(new C0657a(5, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment fragment, @Nullable String str) {
        mo5915e(0, fragment, str, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment) {
        return replace(i, fragment, (String) null);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        this.f3210d = i;
        this.f3211e = i2;
        this.f3212f = i3;
        this.f3213g = i4;
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return add(i, m2338d(cls, bundle));
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return replace(i, m2338d(cls, bundle), str);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        this.f3220n = 0;
        this.f3221o = charSequence;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        this.f3218l = 0;
        this.f3219m = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment) {
        mo5915e(i, fragment, (String) null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        if (i != 0) {
            mo5915e(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(i, m2338d(cls, bundle), str);
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        mo5915e(i, fragment, str, 1);
        return this;
    }

    FragmentTransaction(@NonNull FragmentFactory fragmentFactory, @Nullable ClassLoader classLoader) {
        this.f3209c = new ArrayList<>();
        this.f3216j = true;
        this.f3224r = false;
        this.f3207a = fragmentFactory;
        this.f3208b = classLoader;
    }
}
