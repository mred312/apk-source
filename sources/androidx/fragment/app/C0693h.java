package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.p003os.CancellationSignal;
import androidx.core.p003os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.C0610R;
import androidx.fragment.app.C0714n;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;

/* renamed from: androidx.fragment.app.h */
/* compiled from: FragmentStateManager */
class C0693h {

    /* renamed from: a */
    private final C0688e f3327a;

    /* renamed from: b */
    private final C0696i f3328b;
    @NonNull

    /* renamed from: c */
    private final Fragment f3329c;

    /* renamed from: d */
    private boolean f3330d = false;

    /* renamed from: e */
    private int f3331e = -1;

    /* renamed from: f */
    private CancellationSignal f3332f;

    /* renamed from: g */
    private CancellationSignal f3333g;

    /* renamed from: h */
    private CancellationSignal f3334h;

    /* renamed from: androidx.fragment.app.h$a */
    /* compiled from: FragmentStateManager */
    class C0694a implements View.OnAttachStateChangeListener {

        /* renamed from: a */
        final /* synthetic */ View f3335a;

        C0694a(C0693h hVar, View view) {
            this.f3335a = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f3335a.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(this.f3335a);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: androidx.fragment.app.h$b */
    /* compiled from: FragmentStateManager */
    static /* synthetic */ class C0695b {

        /* renamed from: a */
        static final /* synthetic */ int[] f3336a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3336a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3336a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3336a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0693h.C0695b.<clinit>():void");
        }
    }

    C0693h(@NonNull C0688e eVar, @NonNull C0696i iVar, @NonNull Fragment fragment) {
        this.f3327a = eVar;
        this.f3328b = iVar;
        this.f3329c = fragment;
    }

    /* renamed from: o */
    private Bundle m2421o() {
        Bundle bundle = new Bundle();
        this.f3329c.mo5437Q(bundle);
        this.f3327a.mo6039j(this.f3329c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f3329c.f2989H != null) {
            mo6079r();
        }
        if (this.f3329c.f3010c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f3329c.f3010c);
        }
        if (this.f3329c.f3011d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f3329c.f3011d);
        }
        if (!this.f3329c.f2991J) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f3329c.f2991J);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6063a() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f3329c);
        }
        Fragment fragment = this.f3329c;
        fragment.mo5580w(fragment.f3009b);
        C0688e eVar = this.f3327a;
        Fragment fragment2 = this.f3329c;
        eVar.mo6030a(fragment2, fragment2.f3009b, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6064b() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f3329c);
        }
        Fragment fragment = this.f3329c;
        Fragment fragment2 = fragment.f3015h;
        C0693h hVar = null;
        if (fragment2 != null) {
            C0693h n = this.f3328b.mo6098n(fragment2.f3013f);
            if (n != null) {
                Fragment fragment3 = this.f3329c;
                fragment3.f3016i = fragment3.f3015h.f3013f;
                fragment3.f3015h = null;
                hVar = n;
            } else {
                throw new IllegalStateException("Fragment " + this.f3329c + " declared target fragment " + this.f3329c.f3015h + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.f3016i;
            if (str != null && (hVar = this.f3328b.mo6098n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f3329c + " declared target fragment " + this.f3329c.f3016i + " that does not belong to this FragmentManager!");
            }
        }
        if (hVar != null && (FragmentManager.f3089P || hVar.mo6072j().f3008a < 1)) {
            hVar.mo6073k();
        }
        Fragment fragment4 = this.f3329c;
        fragment4.f3027t = fragment4.f3026s.mo5777n0();
        Fragment fragment5 = this.f3329c;
        fragment5.f3029v = fragment5.f3026s.mo5788q0();
        this.f3327a.mo6036g(this.f3329c, false);
        this.f3329c.mo5581x();
        this.f3327a.mo6031b(this.f3329c, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r2 = r9.f3329c;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo6065c() {
        /*
            r9 = this;
            androidx.fragment.app.Fragment r0 = r9.f3329c
            androidx.fragment.app.FragmentManager r1 = r0.f3026s
            if (r1 != 0) goto L_0x0009
            int r0 = r0.f3008a
            return r0
        L_0x0009:
            int r1 = r9.f3331e
            boolean r2 = r0.f3021n
            r3 = 2
            r4 = 4
            r5 = 1
            if (r2 == 0) goto L_0x0028
            boolean r2 = r0.f3022o
            if (r2 == 0) goto L_0x001b
            int r1 = java.lang.Math.max(r1, r3)
            goto L_0x0028
        L_0x001b:
            if (r1 >= r4) goto L_0x0024
            int r0 = r0.f3008a
            int r1 = java.lang.Math.min(r1, r0)
            goto L_0x0028
        L_0x0024:
            int r1 = java.lang.Math.min(r1, r5)
        L_0x0028:
            androidx.fragment.app.Fragment r0 = r9.f3329c
            boolean r0 = r0.f3019l
            if (r0 != 0) goto L_0x0032
            int r1 = java.lang.Math.min(r1, r5)
        L_0x0032:
            r0 = 0
            boolean r2 = androidx.fragment.app.FragmentManager.f3089P
            if (r2 == 0) goto L_0x0049
            androidx.fragment.app.Fragment r2 = r9.f3329c
            android.view.ViewGroup r6 = r2.f2988G
            if (r6 == 0) goto L_0x0049
            androidx.fragment.app.FragmentManager r0 = r2.getParentFragmentManager()
            androidx.fragment.app.n r0 = androidx.fragment.app.C0714n.m2508l(r6, r0)
            androidx.fragment.app.n$e$c r0 = r0.mo6149j(r9)
        L_0x0049:
            androidx.fragment.app.n$e$c r2 = androidx.fragment.app.C0714n.C0719e.C0722c.ADDING
            r6 = -1
            r7 = 3
            if (r0 != r2) goto L_0x0055
            r0 = 6
            int r1 = java.lang.Math.min(r1, r0)
            goto L_0x0073
        L_0x0055:
            androidx.fragment.app.n$e$c r2 = androidx.fragment.app.C0714n.C0719e.C0722c.REMOVING
            if (r0 != r2) goto L_0x005e
            int r1 = java.lang.Math.max(r1, r7)
            goto L_0x0073
        L_0x005e:
            androidx.fragment.app.Fragment r0 = r9.f3329c
            boolean r2 = r0.f3020m
            if (r2 == 0) goto L_0x0073
            boolean r0 = r0.mo5550s()
            if (r0 == 0) goto L_0x006f
            int r1 = java.lang.Math.min(r1, r5)
            goto L_0x0073
        L_0x006f:
            int r1 = java.lang.Math.min(r1, r6)
        L_0x0073:
            androidx.fragment.app.Fragment r0 = r9.f3329c
            boolean r2 = r0.f2990I
            r8 = 5
            if (r2 == 0) goto L_0x0082
            int r0 = r0.f3008a
            if (r0 >= r8) goto L_0x0082
            int r1 = java.lang.Math.min(r1, r4)
        L_0x0082:
            int[] r0 = androidx.fragment.app.C0693h.C0695b.f3336a
            androidx.fragment.app.Fragment r2 = r9.f3329c
            androidx.lifecycle.Lifecycle$State r2 = r2.f2999R
            int r2 = r2.ordinal()
            r0 = r0[r2]
            if (r0 == r5) goto L_0x00a2
            if (r0 == r3) goto L_0x009e
            if (r0 == r7) goto L_0x0099
            int r1 = java.lang.Math.min(r1, r6)
            goto L_0x00a2
        L_0x0099:
            int r1 = java.lang.Math.min(r1, r5)
            goto L_0x00a2
        L_0x009e:
            int r1 = java.lang.Math.min(r1, r8)
        L_0x00a2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0693h.mo6065c():int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6066d() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f3329c);
        }
        Fragment fragment = this.f3329c;
        if (!fragment.f2998Q) {
            this.f3327a.mo6037h(fragment, fragment.f3009b, false);
            Fragment fragment2 = this.f3329c;
            fragment2.mo5422A(fragment2.f3009b);
            C0688e eVar = this.f3327a;
            Fragment fragment3 = this.f3329c;
            eVar.mo6032c(fragment3, fragment3.f3009b, false);
            return;
        }
        fragment.mo5441W(fragment.f3009b);
        this.f3329c.f3008a = 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6067e() {
        String str;
        if (!this.f3329c.f3021n) {
            if (FragmentManager.m2230w0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3329c);
            }
            Fragment fragment = this.f3329c;
            LayoutInflater G = fragment.mo5427G(fragment.f3009b);
            ViewGroup viewGroup = null;
            Fragment fragment2 = this.f3329c;
            ViewGroup viewGroup2 = fragment2.f2988G;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i = fragment2.f3031x;
                if (i != 0) {
                    if (i != -1) {
                        viewGroup = (ViewGroup) fragment2.f3026s.mo5774k0().onFindViewById(this.f3329c.f3031x);
                        if (viewGroup == null) {
                            Fragment fragment3 = this.f3329c;
                            if (!fragment3.f3023p) {
                                try {
                                    str = fragment3.getResources().getResourceName(this.f3329c.f3031x);
                                } catch (Resources.NotFoundException unused) {
                                    str = EnvironmentCompat.MEDIA_UNKNOWN;
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f3329c.f3031x) + " (" + str + ") for fragment " + this.f3329c);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create fragment " + this.f3329c + " for a container view with no id");
                    }
                }
            }
            Fragment fragment4 = this.f3329c;
            fragment4.f2988G = viewGroup;
            fragment4.mo5387C(G, viewGroup, fragment4.f3009b);
            View view = this.f3329c.f2989H;
            if (view != null) {
                boolean z = false;
                view.setSaveFromParentEnabled(false);
                Fragment fragment5 = this.f3329c;
                fragment5.f2989H.setTag(C0610R.C0612id.fragment_container_view_tag, fragment5);
                if (viewGroup != null) {
                    viewGroup.addView(this.f3329c.f2989H, this.f3328b.mo6094j(this.f3329c));
                }
                Fragment fragment6 = this.f3329c;
                if (fragment6.f3033z) {
                    fragment6.f2989H.setVisibility(8);
                }
                if (ViewCompat.isAttachedToWindow(this.f3329c.f2989H)) {
                    ViewCompat.requestApplyInsets(this.f3329c.f2989H);
                } else {
                    View view2 = this.f3329c.f2989H;
                    view2.addOnAttachStateChangeListener(new C0694a(this, view2));
                }
                this.f3329c.mo5440T();
                C0688e eVar = this.f3327a;
                Fragment fragment7 = this.f3329c;
                eVar.mo6042m(fragment7, fragment7.f2989H, fragment7.f3009b, false);
                int visibility = this.f3329c.f2989H.getVisibility();
                if (FragmentManager.f3089P) {
                    this.f3329c.mo5457g0(visibility);
                    Fragment fragment8 = this.f3329c;
                    if (fragment8.f2988G != null && visibility == 0) {
                        fragment8.mo5446b0(fragment8.f2989H.findFocus());
                        this.f3329c.f2989H.setVisibility(4);
                    }
                } else {
                    Fragment fragment9 = this.f3329c;
                    if (visibility == 0 && fragment9.f2988G != null) {
                        z = true;
                    }
                    fragment9.f2994M = z;
                }
            }
            this.f3329c.f3008a = 2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6068f() {
        Fragment f;
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f3329c);
        }
        Fragment fragment = this.f3329c;
        boolean z = true;
        boolean z2 = fragment.f3020m && !fragment.mo5550s();
        if (z2 || this.f3328b.mo6100p().mo6060q(this.f3329c)) {
            FragmentHostCallback<?> fragmentHostCallback = this.f3329c.f3027t;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z = this.f3328b.mo6100p().mo6055m();
            } else if (fragmentHostCallback.mo5697b() instanceof Activity) {
                z = true ^ ((Activity) fragmentHostCallback.mo5697b()).isChangingConfigurations();
            }
            if (z2 || z) {
                this.f3328b.mo6100p().mo6048f(this.f3329c);
            }
            this.f3329c.mo5424D();
            this.f3327a.mo6033d(this.f3329c, false);
            for (C0693h next : this.f3328b.mo6096l()) {
                if (next != null) {
                    Fragment j = next.mo6072j();
                    if (this.f3329c.f3013f.equals(j.f3016i)) {
                        j.f3015h = this.f3329c;
                        j.f3016i = null;
                    }
                }
            }
            Fragment fragment2 = this.f3329c;
            String str = fragment2.f3016i;
            if (str != null) {
                fragment2.f3015h = this.f3328b.mo6090f(str);
            }
            this.f3328b.mo6102r(this);
            return;
        }
        String str2 = this.f3329c.f3016i;
        if (!(str2 == null || (f = this.f3328b.mo6090f(str2)) == null || !f.f2983B)) {
            this.f3329c.f3015h = f;
        }
        this.f3329c.f3008a = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6069g() {
        this.f3329c.mo5425E();
        this.f3327a.mo6043n(this.f3329c, false);
        Fragment fragment = this.f3329c;
        fragment.f2988G = null;
        fragment.f2989H = null;
        fragment.f3001T = null;
        fragment.f3002U.setValue(null);
        this.f3329c.f3022o = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6070h() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f3329c);
        }
        this.f3329c.mo5426F();
        boolean z = false;
        this.f3327a.mo6034e(this.f3329c, false);
        Fragment fragment = this.f3329c;
        fragment.f3008a = -1;
        fragment.f3027t = null;
        fragment.f3029v = null;
        fragment.f3026s = null;
        if (fragment.f3020m && !fragment.mo5550s()) {
            z = true;
        }
        if (z || this.f3328b.mo6100p().mo6060q(this.f3329c)) {
            if (FragmentManager.m2230w0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f3329c);
            }
            this.f3329c.mo5539q();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo6071i() {
        Fragment fragment = this.f3329c;
        if (fragment.f3021n && fragment.f3022o && !fragment.f3024q) {
            if (FragmentManager.m2230w0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3329c);
            }
            Fragment fragment2 = this.f3329c;
            fragment2.mo5387C(fragment2.mo5427G(fragment2.f3009b), (ViewGroup) null, this.f3329c.f3009b);
            View view = this.f3329c.f2989H;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f3329c;
                fragment3.f2989H.setTag(C0610R.C0612id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f3329c;
                if (fragment4.f3033z) {
                    fragment4.f2989H.setVisibility(8);
                }
                this.f3329c.mo5440T();
                C0688e eVar = this.f3327a;
                Fragment fragment5 = this.f3329c;
                eVar.mo6042m(fragment5, fragment5.f2989H, fragment5.f3009b, false);
                this.f3329c.f3008a = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: j */
    public Fragment mo6072j() {
        return this.f3329c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo6073k() {
        ViewGroup viewGroup;
        if (!this.f3330d) {
            boolean z = false;
            z = true;
            try {
                while (true) {
                    int c = mo6065c();
                    Fragment fragment = this.f3329c;
                    int i = fragment.f3008a;
                    if (c != i) {
                        if (c <= i) {
                            int i2 = i - 1;
                            CancellationSignal cancellationSignal = this.f3332f;
                            if (cancellationSignal != null) {
                                cancellationSignal.cancel();
                            }
                            switch (i2) {
                                case -1:
                                    mo6070h();
                                    break;
                                case 0:
                                    mo6068f();
                                    break;
                                case 1:
                                    this.f3329c.f3008a = z ? 1 : 0;
                                    break;
                                case 2:
                                    mo6069g();
                                    this.f3329c.f3008a = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.m2230w0(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f3329c);
                                    }
                                    Fragment fragment2 = this.f3329c;
                                    if (fragment2.f2989H != null && fragment2.f3010c == null) {
                                        mo6079r();
                                    }
                                    Fragment fragment3 = this.f3329c;
                                    if (!(fragment3.f2989H == null || (viewGroup = fragment3.f2988G) == null || this.f3331e <= -1)) {
                                        C0714n l = C0714n.m2508l(viewGroup, fragment3.getParentFragmentManager());
                                        CancellationSignal cancellationSignal2 = this.f3333g;
                                        if (cancellationSignal2 != null) {
                                            cancellationSignal2.cancel();
                                        }
                                        CancellationSignal cancellationSignal3 = new CancellationSignal();
                                        this.f3334h = cancellationSignal3;
                                        l.mo6144d(this, cancellationSignal3);
                                    }
                                    this.f3329c.f3008a = 3;
                                    break;
                                case 4:
                                    mo6082u();
                                    break;
                                case 5:
                                    this.f3329c.f3008a = 5;
                                    break;
                                case 6:
                                    mo6074l();
                                    break;
                            }
                        } else {
                            int i3 = i + 1;
                            CancellationSignal cancellationSignal4 = this.f3334h;
                            if (cancellationSignal4 != null) {
                                cancellationSignal4.cancel();
                            }
                            switch (i3) {
                                case 0:
                                    mo6064b();
                                    break;
                                case 1:
                                    mo6066d();
                                    break;
                                case 2:
                                    mo6071i();
                                    mo6067e();
                                    break;
                                case 3:
                                    mo6063a();
                                    break;
                                case 4:
                                    Fragment fragment4 = this.f3329c;
                                    View view = fragment4.f2989H;
                                    if (!(view == null || fragment4.f2988G == null)) {
                                        if (view.getParent() == null) {
                                            int j = this.f3328b.mo6094j(this.f3329c);
                                            Fragment fragment5 = this.f3329c;
                                            fragment5.f2988G.addView(fragment5.f2989H, j);
                                        }
                                        Fragment fragment6 = this.f3329c;
                                        C0714n l2 = C0714n.m2508l(fragment6.f2988G, fragment6.getParentFragmentManager());
                                        CancellationSignal cancellationSignal5 = this.f3333g;
                                        if (cancellationSignal5 != null) {
                                            cancellationSignal5.cancel();
                                        }
                                        this.f3332f = new CancellationSignal();
                                        l2.mo6142b(C0714n.C0719e.C0723d.m2530b(this.f3329c.mo5507m()), this, this.f3332f);
                                    }
                                    this.f3329c.f3008a = 4;
                                    break;
                                case 5:
                                    mo6081t();
                                    break;
                                case 6:
                                    this.f3329c.f3008a = 6;
                                    break;
                                case 7:
                                    mo6076n();
                                    break;
                            }
                        }
                    } else {
                        if (FragmentManager.f3089P && fragment.f2995N) {
                            if (!(fragment.f2989H == null || fragment.f2988G == null)) {
                                CancellationSignal cancellationSignal6 = this.f3333g;
                                if (cancellationSignal6 != null) {
                                    cancellationSignal6.cancel();
                                }
                                Fragment fragment7 = this.f3329c;
                                C0714n l3 = C0714n.m2508l(fragment7.f2988G, fragment7.getParentFragmentManager());
                                CancellationSignal cancellationSignal7 = new CancellationSignal();
                                this.f3333g = cancellationSignal7;
                                if (this.f3329c.f3033z) {
                                    l3.mo6143c(this, cancellationSignal7);
                                } else {
                                    l3.mo6145e(this, cancellationSignal7);
                                }
                            }
                            Fragment fragment8 = this.f3329c;
                            fragment8.f2995N = z;
                            fragment8.onHiddenChanged(fragment8.f3033z);
                        }
                        this.f3330d = z;
                        return;
                    }
                }
            } finally {
                this.f3330d = z;
            }
        } else if (FragmentManager.m2230w0(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + mo6072j());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo6074l() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f3329c);
        }
        this.f3329c.mo5432L();
        this.f3327a.mo6035f(this.f3329c, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo6075m(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.f3329c.f3009b;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f3329c;
            fragment.f3010c = fragment.f3009b.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f3329c;
            fragment2.f3011d = fragment2.f3009b.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f3329c;
            fragment3.f3016i = fragment3.f3009b.getString("android:target_state");
            Fragment fragment4 = this.f3329c;
            if (fragment4.f3016i != null) {
                fragment4.f3017j = fragment4.f3009b.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f3329c;
            Boolean bool = fragment5.f3012e;
            if (bool != null) {
                fragment5.f2991J = bool.booleanValue();
                this.f3329c.f3012e = null;
            } else {
                fragment5.f2991J = fragment5.f3009b.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f3329c;
            if (!fragment6.f2991J) {
                fragment6.f2990I = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo6076n() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f3329c);
        }
        this.f3329c.mo5436P();
        this.f3327a.mo6038i(this.f3329c, false);
        Fragment fragment = this.f3329c;
        fragment.f3009b = null;
        fragment.f3010c = null;
        fragment.f3011d = null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: p */
    public Fragment.SavedState mo6077p() {
        Bundle o;
        if (this.f3329c.f3008a <= -1 || (o = m2421o()) == null) {
            return null;
        }
        return new Fragment.SavedState(o);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: q */
    public FragmentState mo6078q() {
        FragmentState fragmentState = new FragmentState(this.f3329c);
        Fragment fragment = this.f3329c;
        if (fragment.f3008a <= -1 || fragmentState.f3185m != null) {
            fragmentState.f3185m = fragment.f3009b;
        } else {
            Bundle o = m2421o();
            fragmentState.f3185m = o;
            if (this.f3329c.f3016i != null) {
                if (o == null) {
                    fragmentState.f3185m = new Bundle();
                }
                fragmentState.f3185m.putString("android:target_state", this.f3329c.f3016i);
                int i = this.f3329c.f3017j;
                if (i != 0) {
                    fragmentState.f3185m.putInt("android:target_req_state", i);
                }
            }
        }
        return fragmentState;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo6079r() {
        if (this.f3329c.f2989H != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f3329c.f2989H.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f3329c.f3010c = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f3329c.f3001T.mo6137e(bundle);
            if (!bundle.isEmpty()) {
                this.f3329c.f3011d = bundle;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo6080s(int i) {
        this.f3331e = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo6081t() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f3329c);
        }
        this.f3329c.mo5438R();
        this.f3327a.mo6040k(this.f3329c, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo6082u() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f3329c);
        }
        this.f3329c.mo5439S();
        this.f3327a.mo6041l(this.f3329c, false);
    }

    C0693h(@NonNull C0688e eVar, @NonNull C0696i iVar, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull FragmentState fragmentState) {
        this.f3327a = eVar;
        this.f3328b = iVar;
        Fragment instantiate = fragmentFactory.instantiate(classLoader, fragmentState.f3173a);
        this.f3329c = instantiate;
        Bundle bundle = fragmentState.f3182j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(fragmentState.f3182j);
        instantiate.f3013f = fragmentState.f3174b;
        instantiate.f3021n = fragmentState.f3175c;
        instantiate.f3023p = true;
        instantiate.f3030w = fragmentState.f3176d;
        instantiate.f3031x = fragmentState.f3177e;
        instantiate.f3032y = fragmentState.f3178f;
        instantiate.f2983B = fragmentState.f3179g;
        instantiate.f3020m = fragmentState.f3180h;
        instantiate.f2982A = fragmentState.f3181i;
        instantiate.f3033z = fragmentState.f3183k;
        instantiate.f2999R = Lifecycle.State.values()[fragmentState.f3184l];
        Bundle bundle2 = fragmentState.f3185m;
        if (bundle2 != null) {
            instantiate.f3009b = bundle2;
        } else {
            instantiate.f3009b = new Bundle();
        }
        if (FragmentManager.m2230w0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    C0693h(@NonNull C0688e eVar, @NonNull C0696i iVar, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.f3327a = eVar;
        this.f3328b = iVar;
        this.f3329c = fragment;
        fragment.f3010c = null;
        fragment.f3011d = null;
        fragment.f3025r = 0;
        fragment.f3022o = false;
        fragment.f3019l = false;
        Fragment fragment2 = fragment.f3015h;
        fragment.f3016i = fragment2 != null ? fragment2.f3013f : null;
        fragment.f3015h = null;
        Bundle bundle = fragmentState.f3185m;
        if (bundle != null) {
            fragment.f3009b = bundle;
        } else {
            fragment.f3009b = new Bundle();
        }
    }
}
