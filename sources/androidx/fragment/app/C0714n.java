package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.p003os.CancellationSignal;
import androidx.fragment.C0610R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: androidx.fragment.app.n */
/* compiled from: SpecialEffectsController */
abstract class C0714n {

    /* renamed from: a */
    private final ViewGroup f3399a;

    /* renamed from: b */
    final ArrayList<C0719e> f3400b = new ArrayList<>();

    /* renamed from: c */
    final HashMap<Fragment, C0719e> f3401c = new HashMap<>();

    /* renamed from: d */
    boolean f3402d = false;

    /* renamed from: e */
    boolean f3403e = false;

    /* renamed from: androidx.fragment.app.n$a */
    /* compiled from: SpecialEffectsController */
    class C0715a implements CancellationSignal.OnCancelListener {

        /* renamed from: a */
        final /* synthetic */ C0718d f3404a;

        /* renamed from: b */
        final /* synthetic */ CancellationSignal f3405b;

        C0715a(C0718d dVar, CancellationSignal cancellationSignal) {
            this.f3404a = dVar;
            this.f3405b = cancellationSignal;
        }

        public void onCancel() {
            synchronized (C0714n.this.f3400b) {
                C0714n.this.f3400b.remove(this.f3404a);
                C0714n.this.f3401c.remove(this.f3404a.mo6158e());
                this.f3405b.cancel();
            }
        }
    }

    /* renamed from: androidx.fragment.app.n$b */
    /* compiled from: SpecialEffectsController */
    class C0716b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0718d f3407a;

        C0716b(C0718d dVar) {
            this.f3407a = dVar;
        }

        public void run() {
            if (!this.f3407a.mo6156c().isCanceled()) {
                C0714n.this.f3401c.remove(this.f3407a.mo6158e());
            }
        }
    }

    /* renamed from: androidx.fragment.app.n$c */
    /* compiled from: SpecialEffectsController */
    static /* synthetic */ class C0717c {

        /* renamed from: a */
        static final /* synthetic */ int[] f3409a;

        /* renamed from: b */
        static final /* synthetic */ int[] f3410b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.n$e$c[] r0 = androidx.fragment.app.C0714n.C0719e.C0722c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3410b = r0
                r1 = 1
                androidx.fragment.app.n$e$c r2 = androidx.fragment.app.C0714n.C0719e.C0722c.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3410b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.n$e$c r3 = androidx.fragment.app.C0714n.C0719e.C0722c.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3410b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.n$e$c r4 = androidx.fragment.app.C0714n.C0719e.C0722c.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.n$e$d[] r3 = androidx.fragment.app.C0714n.C0719e.C0723d.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3409a = r3
                androidx.fragment.app.n$e$d r4 = androidx.fragment.app.C0714n.C0719e.C0723d.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f3409a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.n$e$d r3 = androidx.fragment.app.C0714n.C0719e.C0723d.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f3409a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.n$e$d r1 = androidx.fragment.app.C0714n.C0719e.C0723d.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f3409a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.n$e$d r1 = androidx.fragment.app.C0714n.C0719e.C0723d.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0714n.C0717c.<clinit>():void");
        }
    }

    /* renamed from: androidx.fragment.app.n$d */
    /* compiled from: SpecialEffectsController */
    private static class C0718d extends C0719e {
        @NonNull

        /* renamed from: f */
        private final C0693h f3411f;

        C0718d(@NonNull C0719e.C0723d dVar, @NonNull C0719e.C0722c cVar, @NonNull C0693h hVar, @NonNull CancellationSignal cancellationSignal) {
            super(dVar, cVar, hVar.mo6072j(), cancellationSignal);
            this.f3411f = hVar;
        }

        /* renamed from: b */
        public void mo6154b() {
            super.mo6154b();
            this.f3411f.mo6073k();
        }
    }

    /* renamed from: androidx.fragment.app.n$e */
    /* compiled from: SpecialEffectsController */
    static class C0719e {
        @NonNull

        /* renamed from: a */
        private C0723d f3412a;
        @NonNull

        /* renamed from: b */
        private C0722c f3413b;
        @NonNull

        /* renamed from: c */
        private final Fragment f3414c;
        @NonNull

        /* renamed from: d */
        final CancellationSignal f3415d = new CancellationSignal();
        @NonNull

        /* renamed from: e */
        private final List<Runnable> f3416e = new ArrayList();

        /* renamed from: androidx.fragment.app.n$e$a */
        /* compiled from: SpecialEffectsController */
        class C0720a implements CancellationSignal.OnCancelListener {
            C0720a() {
            }

            public void onCancel() {
                C0719e.this.f3415d.cancel();
            }
        }

        /* renamed from: androidx.fragment.app.n$e$b */
        /* compiled from: SpecialEffectsController */
        class C0721b implements CancellationSignal.OnCancelListener {
            C0721b() {
            }

            public void onCancel() {
                C0719e.this.f3415d.cancel();
            }
        }

        /* renamed from: androidx.fragment.app.n$e$c */
        /* compiled from: SpecialEffectsController */
        enum C0722c {
            NONE,
            ADDING,
            REMOVING
        }

        /* renamed from: androidx.fragment.app.n$e$d */
        /* compiled from: SpecialEffectsController */
        enum C0723d {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            /* renamed from: b */
            static C0723d m2530b(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i);
            }

            @NonNull
            /* renamed from: c */
            static C0723d m2531c(@NonNull View view) {
                return m2530b(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo6161a(@NonNull View view) {
                int i = C0717c.f3409a[ordinal()];
                if (i == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                } else if (i == 2) {
                    view.setVisibility(0);
                } else if (i == 3) {
                    view.setVisibility(8);
                } else if (i == 4) {
                    view.setVisibility(4);
                }
            }
        }

        C0719e(@NonNull C0723d dVar, @NonNull C0722c cVar, @NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            this.f3412a = dVar;
            this.f3413b = cVar;
            this.f3414c = fragment;
            cancellationSignal.setOnCancelListener(new C0720a());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo6155a(@NonNull Runnable runnable) {
            this.f3416e.add(runnable);
        }

        @CallSuper
        /* renamed from: b */
        public void mo6154b() {
            for (Runnable run : this.f3416e) {
                run.run();
            }
        }

        @NonNull
        /* renamed from: c */
        public final CancellationSignal mo6156c() {
            return this.f3415d;
        }

        @NonNull
        /* renamed from: d */
        public C0723d mo6157d() {
            return this.f3412a;
        }

        @NonNull
        /* renamed from: e */
        public final Fragment mo6158e() {
            return this.f3414c;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: f */
        public C0722c mo6159f() {
            return this.f3413b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public final void mo6160g(@NonNull C0723d dVar, @NonNull C0722c cVar, @NonNull CancellationSignal cancellationSignal) {
            int i = C0717c.f3410b[cVar.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.f3412a = C0723d.REMOVED;
                    this.f3413b = C0722c.REMOVING;
                } else if (i == 3 && this.f3412a != C0723d.REMOVED) {
                    this.f3412a = dVar;
                }
            } else if (this.f3412a == C0723d.REMOVED) {
                this.f3412a = C0723d.VISIBLE;
                this.f3413b = C0722c.ADDING;
            }
            cancellationSignal.setOnCancelListener(new C0721b());
        }
    }

    C0714n(@NonNull ViewGroup viewGroup) {
        this.f3399a = viewGroup;
    }

    /* renamed from: a */
    private void m2507a(@NonNull C0719e.C0723d dVar, @NonNull C0719e.C0722c cVar, @NonNull C0693h hVar, @NonNull CancellationSignal cancellationSignal) {
        if (!cancellationSignal.isCanceled()) {
            synchronized (this.f3400b) {
                CancellationSignal cancellationSignal2 = new CancellationSignal();
                C0719e eVar = this.f3401c.get(hVar.mo6072j());
                if (eVar != null) {
                    eVar.mo6160g(dVar, cVar, cancellationSignal);
                    return;
                }
                C0718d dVar2 = new C0718d(dVar, cVar, hVar, cancellationSignal2);
                this.f3400b.add(dVar2);
                this.f3401c.put(dVar2.mo6158e(), dVar2);
                cancellationSignal.setOnCancelListener(new C0715a(dVar2, cancellationSignal2));
                dVar2.mo6155a(new C0716b(dVar2));
            }
        }
    }

    @NonNull
    /* renamed from: l */
    static C0714n m2508l(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return m2509m(viewGroup, fragmentManager.mo5790r0());
    }

    @NonNull
    /* renamed from: m */
    static C0714n m2509m(@NonNull ViewGroup viewGroup, @NonNull C0724o oVar) {
        int i = C0610R.C0612id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i);
        if (tag instanceof C0714n) {
            return (C0714n) tag;
        }
        C0714n a = oVar.mo5842a(viewGroup);
        viewGroup.setTag(i, a);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6142b(@NonNull C0719e.C0723d dVar, @NonNull C0693h hVar, @NonNull CancellationSignal cancellationSignal) {
        m2507a(dVar, C0719e.C0722c.ADDING, hVar, cancellationSignal);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6143c(@NonNull C0693h hVar, @NonNull CancellationSignal cancellationSignal) {
        m2507a(C0719e.C0723d.GONE, C0719e.C0722c.NONE, hVar, cancellationSignal);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6144d(@NonNull C0693h hVar, @NonNull CancellationSignal cancellationSignal) {
        m2507a(C0719e.C0723d.REMOVED, C0719e.C0722c.REMOVING, hVar, cancellationSignal);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6145e(@NonNull C0693h hVar, @NonNull CancellationSignal cancellationSignal) {
        m2507a(C0719e.C0723d.VISIBLE, C0719e.C0722c.NONE, hVar, cancellationSignal);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract void mo5992f(@NonNull List<C0719e> list, boolean z);

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6146g() {
        if (!this.f3403e) {
            synchronized (this.f3400b) {
                if (!this.f3400b.isEmpty()) {
                    mo5992f(new ArrayList(this.f3400b), this.f3402d);
                    this.f3400b.clear();
                    this.f3402d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6147h() {
        synchronized (this.f3400b) {
            for (C0719e next : this.f3401c.values()) {
                next.mo6156c().cancel();
                next.mo6157d().mo6161a(next.mo6158e().f2989H);
                next.mo6154b();
            }
            this.f3401c.clear();
            this.f3400b.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo6148i() {
        if (this.f3403e) {
            this.f3403e = false;
            mo6146g();
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: j */
    public C0719e.C0722c mo6149j(@NonNull C0693h hVar) {
        C0719e eVar = this.f3401c.get(hVar.mo6072j());
        if (eVar == null || eVar.mo6156c().isCanceled()) {
            return null;
        }
        return eVar.mo6159f();
    }

    @NonNull
    /* renamed from: k */
    public ViewGroup mo6150k() {
        return this.f3399a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo6151n() {
        synchronized (this.f3400b) {
            this.f3403e = false;
            int size = this.f3400b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                C0719e eVar = this.f3400b.get(size);
                C0719e.C0723d c = C0719e.C0723d.m2531c(eVar.mo6158e().f2989H);
                C0719e.C0723d d = eVar.mo6157d();
                C0719e.C0723d dVar = C0719e.C0723d.VISIBLE;
                if (d == dVar && c != dVar) {
                    this.f3403e = eVar.mo6158e().mo5575t();
                    break;
                }
                size--;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo6152o(boolean z) {
        this.f3402d = z;
    }
}
