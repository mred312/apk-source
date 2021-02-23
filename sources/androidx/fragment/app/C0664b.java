package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.p003os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.C0679c;
import androidx.fragment.app.C0714n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.fragment.app.b */
/* compiled from: DefaultSpecialEffectsController */
class C0664b extends C0714n {

    /* renamed from: f */
    private final HashMap<C0714n.C0719e, HashSet<CancellationSignal>> f3259f = new HashMap<>();

    /* renamed from: androidx.fragment.app.b$a */
    /* compiled from: DefaultSpecialEffectsController */
    class C0665a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0678m f3260a;

        C0665a(C0678m mVar) {
            this.f3260a = mVar;
        }

        public void run() {
            C0664b.this.mo5997u(this.f3260a.mo6013c(), this.f3260a.mo6015e());
        }
    }

    /* renamed from: androidx.fragment.app.b$b */
    /* compiled from: DefaultSpecialEffectsController */
    static /* synthetic */ class C0666b {

        /* renamed from: a */
        static final /* synthetic */ int[] f3262a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.n$e$d[] r0 = androidx.fragment.app.C0714n.C0719e.C0723d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3262a = r0
                androidx.fragment.app.n$e$d r1 = androidx.fragment.app.C0714n.C0719e.C0723d.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3262a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.n$e$d r1 = androidx.fragment.app.C0714n.C0719e.C0723d.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3262a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.n$e$d r1 = androidx.fragment.app.C0714n.C0719e.C0723d.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3262a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.n$e$d r1 = androidx.fragment.app.C0714n.C0719e.C0723d.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0664b.C0666b.<clinit>():void");
        }
    }

    /* renamed from: androidx.fragment.app.b$c */
    /* compiled from: DefaultSpecialEffectsController */
    class C0667c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0714n.C0719e f3263a;

        C0667c(C0664b bVar, C0714n.C0719e eVar) {
            this.f3263a = eVar;
        }

        public void run() {
            View j;
            if (this.f3263a.mo6157d() == C0714n.C0719e.C0723d.VISIBLE && (j = this.f3263a.mo6158e().mo5504j()) != null) {
                j.requestFocus();
                this.f3263a.mo6158e().mo5446b0((View) null);
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$d */
    /* compiled from: DefaultSpecialEffectsController */
    class C0668d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f3264a;

        /* renamed from: b */
        final /* synthetic */ C0714n.C0719e f3265b;

        C0668d(List list, C0714n.C0719e eVar) {
            this.f3264a = list;
            this.f3265b = eVar;
        }

        public void run() {
            if (this.f3264a.contains(this.f3265b)) {
                this.f3264a.remove(this.f3265b);
                C0664b.this.mo5993q(this.f3265b);
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$e */
    /* compiled from: DefaultSpecialEffectsController */
    class C0669e implements CancellationSignal.OnCancelListener {

        /* renamed from: a */
        final /* synthetic */ C0714n.C0719e f3267a;

        C0669e(C0714n.C0719e eVar) {
            this.f3267a = eVar;
        }

        public void onCancel() {
            C0664b.this.mo5994r(this.f3267a);
        }
    }

    /* renamed from: androidx.fragment.app.b$f */
    /* compiled from: DefaultSpecialEffectsController */
    class C0670f implements Animation.AnimationListener {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f3269a;

        /* renamed from: b */
        final /* synthetic */ View f3270b;

        /* renamed from: c */
        final /* synthetic */ C0714n.C0719e f3271c;

        /* renamed from: d */
        final /* synthetic */ CancellationSignal f3272d;

        /* renamed from: androidx.fragment.app.b$f$a */
        /* compiled from: DefaultSpecialEffectsController */
        class C0671a implements Runnable {
            C0671a() {
            }

            public void run() {
                C0670f fVar = C0670f.this;
                fVar.f3269a.endViewTransition(fVar.f3270b);
                C0670f fVar2 = C0670f.this;
                C0664b.this.mo5997u(fVar2.f3271c, fVar2.f3272d);
            }
        }

        C0670f(ViewGroup viewGroup, View view, C0714n.C0719e eVar, CancellationSignal cancellationSignal) {
            this.f3269a = viewGroup;
            this.f3270b = view;
            this.f3271c = eVar;
            this.f3272d = cancellationSignal;
        }

        public void onAnimationEnd(Animation animation) {
            this.f3269a.post(new C0671a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.b$g */
    /* compiled from: DefaultSpecialEffectsController */
    class C0672g extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f3275a;

        /* renamed from: b */
        final /* synthetic */ View f3276b;

        /* renamed from: c */
        final /* synthetic */ C0714n.C0719e f3277c;

        /* renamed from: d */
        final /* synthetic */ CancellationSignal f3278d;

        C0672g(ViewGroup viewGroup, View view, C0714n.C0719e eVar, CancellationSignal cancellationSignal) {
            this.f3275a = viewGroup;
            this.f3276b = view;
            this.f3277c = eVar;
            this.f3278d = cancellationSignal;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3275a.endViewTransition(this.f3276b);
            C0664b.this.mo5997u(this.f3277c, this.f3278d);
        }
    }

    /* renamed from: androidx.fragment.app.b$h */
    /* compiled from: DefaultSpecialEffectsController */
    class C0673h implements CancellationSignal.OnCancelListener {

        /* renamed from: a */
        final /* synthetic */ View f3280a;

        C0673h(C0664b bVar, View view) {
            this.f3280a = view;
        }

        public void onCancel() {
            this.f3280a.clearAnimation();
        }
    }

    /* renamed from: androidx.fragment.app.b$i */
    /* compiled from: DefaultSpecialEffectsController */
    class C0674i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0714n.C0719e f3281a;

        /* renamed from: b */
        final /* synthetic */ C0714n.C0719e f3282b;

        /* renamed from: c */
        final /* synthetic */ boolean f3283c;

        /* renamed from: d */
        final /* synthetic */ ArrayMap f3284d;

        C0674i(C0664b bVar, C0714n.C0719e eVar, C0714n.C0719e eVar2, boolean z, ArrayMap arrayMap) {
            this.f3281a = eVar;
            this.f3282b = eVar2;
            this.f3283c = z;
            this.f3284d = arrayMap;
        }

        public void run() {
            C0697j.m2476f(this.f3281a.mo6158e(), this.f3282b.mo6158e(), this.f3283c, this.f3284d, false);
        }
    }

    /* renamed from: androidx.fragment.app.b$j */
    /* compiled from: DefaultSpecialEffectsController */
    class C0675j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ FragmentTransitionImpl f3285a;

        /* renamed from: b */
        final /* synthetic */ View f3286b;

        /* renamed from: c */
        final /* synthetic */ Rect f3287c;

        C0675j(C0664b bVar, FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
            this.f3285a = fragmentTransitionImpl;
            this.f3286b = view;
            this.f3287c = rect;
        }

        public void run() {
            this.f3285a.getBoundsOnScreen(this.f3286b, this.f3287c);
        }
    }

    /* renamed from: androidx.fragment.app.b$k */
    /* compiled from: DefaultSpecialEffectsController */
    class C0676k implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3288a;

        C0676k(C0664b bVar, ArrayList arrayList) {
            this.f3288a = arrayList;
        }

        public void run() {
            C0697j.m2468B(this.f3288a, 4);
        }
    }

    /* renamed from: androidx.fragment.app.b$l */
    /* compiled from: DefaultSpecialEffectsController */
    private static class C0677l {
        @NonNull

        /* renamed from: a */
        private final C0714n.C0719e f3289a;
        @NonNull

        /* renamed from: b */
        private final CancellationSignal f3290b;

        C0677l(@NonNull C0714n.C0719e eVar, @NonNull CancellationSignal cancellationSignal) {
            this.f3289a = eVar;
            this.f3290b = cancellationSignal;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: a */
        public C0714n.C0719e mo6010a() {
            return this.f3289a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public CancellationSignal mo6011b() {
            return this.f3290b;
        }
    }

    /* renamed from: androidx.fragment.app.b$m */
    /* compiled from: DefaultSpecialEffectsController */
    private static class C0678m {
        @NonNull

        /* renamed from: a */
        private final C0714n.C0719e f3291a;
        @NonNull

        /* renamed from: b */
        private final CancellationSignal f3292b;
        @Nullable

        /* renamed from: c */
        private final Object f3293c;

        /* renamed from: d */
        private final boolean f3294d;
        @Nullable

        /* renamed from: e */
        private final Object f3295e;

        C0678m(@NonNull C0714n.C0719e eVar, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            Object obj;
            Object obj2;
            boolean z3;
            this.f3291a = eVar;
            this.f3292b = cancellationSignal;
            if (eVar.mo6157d() == C0714n.C0719e.C0723d.VISIBLE) {
                if (z) {
                    obj2 = eVar.mo6158e().getReenterTransition();
                } else {
                    obj2 = eVar.mo6158e().getEnterTransition();
                }
                this.f3293c = obj2;
                if (z) {
                    z3 = eVar.mo6158e().getAllowReturnTransitionOverlap();
                } else {
                    z3 = eVar.mo6158e().getAllowEnterTransitionOverlap();
                }
                this.f3294d = z3;
            } else {
                if (z) {
                    obj = eVar.mo6158e().getReturnTransition();
                } else {
                    obj = eVar.mo6158e().getExitTransition();
                }
                this.f3293c = obj;
                this.f3294d = true;
            }
            if (!z2) {
                this.f3295e = null;
            } else if (z) {
                this.f3295e = eVar.mo6158e().getSharedElementReturnTransition();
            } else {
                this.f3295e = eVar.mo6158e().getSharedElementEnterTransition();
            }
        }

        @Nullable
        /* renamed from: b */
        private FragmentTransitionImpl m2380b(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = C0697j.f3341b;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = C0697j.f3342c;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f3291a.mo6158e() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: a */
        public FragmentTransitionImpl mo6012a() {
            FragmentTransitionImpl b = m2380b(this.f3293c);
            FragmentTransitionImpl b2 = m2380b(this.f3295e);
            if (b == null || b2 == null || b == b2) {
                return b != null ? b : b2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.f3291a.mo6158e() + " returned Transition " + this.f3293c + " which uses a different Transition  type than its shared element transition " + this.f3295e);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: c */
        public C0714n.C0719e mo6013c() {
            return this.f3291a;
        }

        @Nullable
        /* renamed from: d */
        public Object mo6014d() {
            return this.f3295e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: e */
        public CancellationSignal mo6015e() {
            return this.f3292b;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: f */
        public Object mo6016f() {
            return this.f3293c;
        }

        /* renamed from: g */
        public boolean mo6017g() {
            return this.f3295e != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public boolean mo6018h() {
            return this.f3294d;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r2 = androidx.fragment.app.C0714n.C0719e.C0723d.VISIBLE;
         */
        /* renamed from: i */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo6019i() {
            /*
                r3 = this;
                androidx.fragment.app.n$e r0 = r3.f3291a
                androidx.fragment.app.Fragment r0 = r0.mo6158e()
                android.view.View r0 = r0.f2989H
                androidx.fragment.app.n$e$d r0 = androidx.fragment.app.C0714n.C0719e.C0723d.m2531c(r0)
                androidx.fragment.app.n$e r1 = r3.f3291a
                androidx.fragment.app.n$e$d r1 = r1.mo6157d()
                if (r0 == r1) goto L_0x001d
                androidx.fragment.app.n$e$d r2 = androidx.fragment.app.C0714n.C0719e.C0723d.VISIBLE
                if (r0 == r2) goto L_0x001b
                if (r1 == r2) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                r0 = 0
                goto L_0x001e
            L_0x001d:
                r0 = 1
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0664b.C0678m.mo6019i():boolean");
        }
    }

    C0664b(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* renamed from: p */
    private void m2368p(@NonNull C0714n.C0719e eVar, @NonNull CancellationSignal cancellationSignal) {
        if (this.f3259f.get(eVar) == null) {
            this.f3259f.put(eVar, new HashSet());
        }
        this.f3259f.get(eVar).add(cancellationSignal);
    }

    /* renamed from: w */
    private void m2369w(@NonNull C0714n.C0719e eVar, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
        C0714n.C0719e.C0723d dVar;
        Animation animation;
        ViewGroup k = mo6150k();
        Context context = k.getContext();
        Fragment e = eVar.mo6158e();
        View view = e.f2989H;
        C0714n.C0719e.C0723d c = C0714n.C0719e.C0723d.m2531c(view);
        C0714n.C0719e.C0723d d = eVar.mo6157d();
        if (c == d || !(c == (dVar = C0714n.C0719e.C0723d.VISIBLE) || d == dVar)) {
            mo5997u(eVar, cancellationSignal);
            return;
        }
        C0679c.C0684d b = C0679c.m2390b(context, e, d == dVar);
        if (b == null) {
            mo5997u(eVar, cancellationSignal);
        } else if (z && b.f3307a != null) {
            if (FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "Ignoring Animation set on " + e + " as Animations cannot run alongside Transitions.");
            }
            mo5997u(eVar, cancellationSignal);
        } else if (z2) {
            if (FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "Ignoring Animator set on " + e + " as this Fragment was involved in a Transition.");
            }
            mo5997u(eVar, cancellationSignal);
        } else {
            k.startViewTransition(view);
            if (b.f3307a != null) {
                if (eVar.mo6157d() == dVar) {
                    animation = new C0679c.C0686f(b.f3307a);
                } else {
                    animation = new C0679c.C0685e(b.f3307a, k, view);
                }
                animation.setAnimationListener(new C0670f(k, view, eVar, cancellationSignal));
                view.startAnimation(animation);
            } else {
                b.f3308b.addListener(new C0672g(k, view, eVar, cancellationSignal));
                b.f3308b.setTarget(view);
                b.f3308b.start();
            }
            cancellationSignal.setOnCancelListener(new C0673h(this, view));
        }
    }

    @NonNull
    /* renamed from: x */
    private Map<C0714n.C0719e, Boolean> m2370x(@NonNull List<C0678m> list, boolean z, @Nullable C0714n.C0719e eVar, @Nullable C0714n.C0719e eVar2) {
        View view;
        View view2;
        View view3;
        C0714n.C0719e eVar3;
        Object obj;
        ArrayMap arrayMap;
        Boolean bool;
        ArrayList arrayList;
        Boolean bool2;
        HashMap hashMap;
        C0714n.C0719e eVar4;
        FragmentTransitionImpl fragmentTransitionImpl;
        Rect rect;
        ArrayList arrayList2;
        View view4;
        SharedElementCallback sharedElementCallback;
        SharedElementCallback sharedElementCallback2;
        Boolean bool3;
        View view5;
        View view6;
        String q;
        Boolean bool4;
        boolean z2 = z;
        C0714n.C0719e eVar5 = eVar;
        C0714n.C0719e eVar6 = eVar2;
        Boolean bool5 = Boolean.TRUE;
        Boolean bool6 = Boolean.FALSE;
        HashMap hashMap2 = new HashMap();
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (C0678m next : list) {
            if (!next.mo6019i()) {
                FragmentTransitionImpl a = next.mo6012a();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = a;
                } else if (!(a == null || fragmentTransitionImpl2 == a)) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + next.mo6013c().mo6158e() + " returned Transition " + next.mo6016f() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (C0678m next2 : list) {
                hashMap2.put(next2.mo6013c(), bool6);
                mo5997u(next2.mo6013c(), next2.mo6015e());
            }
            return hashMap2;
        }
        View view7 = new View(mo6150k().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<C0678m> it = list.iterator();
        Object obj2 = null;
        View view8 = null;
        boolean z3 = false;
        while (true) {
            view = view8;
            if (!it.hasNext()) {
                break;
            }
            C0678m next3 = it.next();
            if (!next3.mo6017g() || eVar5 == null || eVar6 == null) {
                arrayMap = arrayMap2;
                arrayList2 = arrayList3;
                bool = bool6;
                hashMap = hashMap2;
                view4 = view7;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                arrayList = arrayList4;
                rect = rect2;
                eVar4 = eVar5;
                bool2 = bool5;
                view8 = view;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(next3.mo6014d()));
                ArrayList<String> n = eVar2.mo6158e().mo5508n();
                ArrayList<String> n2 = eVar.mo6158e().mo5508n();
                Object obj3 = wrapTransitionInSet;
                ArrayList<String> o = eVar.mo6158e().mo5509o();
                Rect rect3 = rect2;
                bool = bool6;
                int i = 0;
                while (i < o.size()) {
                    int indexOf = n.indexOf(o.get(i));
                    ArrayList<String> arrayList5 = o;
                    if (indexOf != -1) {
                        n.set(indexOf, n2.get(i));
                    }
                    i++;
                    o = arrayList5;
                }
                ArrayList<String> o2 = eVar2.mo6158e().mo5509o();
                if (!z2) {
                    sharedElementCallback2 = eVar.mo6158e().mo5494i();
                    sharedElementCallback = eVar2.mo6158e().mo5490h();
                } else {
                    sharedElementCallback2 = eVar.mo6158e().mo5490h();
                    sharedElementCallback = eVar2.mo6158e().mo5494i();
                }
                int i2 = 0;
                for (int size = n.size(); i2 < size; size = size) {
                    arrayMap2.put(n.get(i2), o2.get(i2));
                    i2++;
                    C0714n.C0719e eVar7 = eVar;
                }
                ArrayMap arrayMap3 = new ArrayMap();
                mo5996t(arrayMap3, eVar.mo6158e().f2989H);
                arrayMap3.retainAll(n);
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(n, arrayMap3);
                    int size2 = n.size() - 1;
                    while (size2 >= 0) {
                        String str = n.get(size2);
                        View view9 = (View) arrayMap3.get(str);
                        if (view9 == null) {
                            arrayMap2.remove(str);
                            bool4 = bool5;
                        } else {
                            bool4 = bool5;
                            if (!str.equals(ViewCompat.getTransitionName(view9))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view9), (String) arrayMap2.remove(str));
                            }
                        }
                        size2--;
                        bool5 = bool4;
                    }
                    bool3 = bool5;
                } else {
                    bool3 = bool5;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                ArrayMap arrayMap4 = new ArrayMap();
                mo5996t(arrayMap4, eVar2.mo6158e().f2989H);
                arrayMap4.retainAll(o2);
                arrayMap4.retainAll(arrayMap2.values());
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(o2, arrayMap4);
                    for (int size3 = o2.size() - 1; size3 >= 0; size3--) {
                        String str2 = o2.get(size3);
                        View view10 = (View) arrayMap4.get(str2);
                        if (view10 == null) {
                            String q2 = C0697j.m2487q(arrayMap2, str2);
                            if (q2 != null) {
                                arrayMap2.remove(q2);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view10)) && (q = C0697j.m2487q(arrayMap2, str2)) != null) {
                            arrayMap2.put(q, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    C0697j.m2495y(arrayMap2, arrayMap4);
                }
                mo5998v(arrayMap3, arrayMap2.keySet());
                mo5998v(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList3.clear();
                    arrayList4.clear();
                    eVar4 = eVar;
                    eVar6 = eVar2;
                    arrayMap = arrayMap2;
                    arrayList2 = arrayList3;
                    hashMap = hashMap2;
                    view4 = view7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view8 = view;
                    bool2 = bool3;
                    obj2 = null;
                    arrayList = arrayList4;
                    rect = rect3;
                } else {
                    C0697j.m2476f(eVar2.mo6158e(), eVar.mo6158e(), z2, arrayMap3, true);
                    Object obj4 = obj3;
                    C0674i iVar = r0;
                    arrayMap = arrayMap2;
                    HashMap hashMap3 = hashMap2;
                    arrayList = arrayList4;
                    View view11 = view7;
                    ArrayList arrayList6 = arrayList3;
                    Rect rect4 = rect3;
                    ArrayList<String> arrayList7 = o2;
                    ViewGroup k = mo6150k();
                    C0674i iVar2 = new C0674i(this, eVar2, eVar, z, arrayMap4);
                    OneShotPreDrawListener.add(k, iVar);
                    for (View s : arrayMap3.values()) {
                        mo5995s(arrayList6, s);
                    }
                    if (!n.isEmpty()) {
                        View view12 = (View) arrayMap3.get(n.get(0));
                        fragmentTransitionImpl2.setEpicenter(obj4, view12);
                        view8 = view12;
                    } else {
                        view8 = view;
                    }
                    for (View s2 : arrayMap4.values()) {
                        mo5995s(arrayList, s2);
                    }
                    if (arrayList7.isEmpty() || (view6 = (View) arrayMap4.get(arrayList7.get(0))) == null) {
                        rect = rect4;
                        view5 = view11;
                    } else {
                        rect = rect4;
                        OneShotPreDrawListener.add(mo6150k(), new C0675j(this, fragmentTransitionImpl2, view6, rect));
                        view5 = view11;
                        z3 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(obj4, view5, arrayList6);
                    view4 = view5;
                    arrayList2 = arrayList6;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(obj4, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj4, arrayList);
                    eVar4 = eVar;
                    bool2 = bool3;
                    hashMap = hashMap3;
                    hashMap.put(eVar4, bool2);
                    eVar6 = eVar2;
                    hashMap.put(eVar6, bool2);
                    obj2 = obj4;
                }
            }
            view7 = view4;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            bool5 = bool2;
            bool6 = bool;
            arrayList3 = arrayList2;
            eVar5 = eVar4;
            arrayMap2 = arrayMap;
            rect2 = rect;
            arrayList4 = arrayList;
            hashMap2 = hashMap;
            z2 = z;
        }
        ArrayMap arrayMap5 = arrayMap2;
        ArrayList arrayList8 = arrayList3;
        Boolean bool7 = bool6;
        HashMap hashMap4 = hashMap2;
        View view13 = view7;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        ArrayList arrayList9 = arrayList4;
        Rect rect5 = rect2;
        C0714n.C0719e eVar8 = eVar5;
        Boolean bool8 = bool5;
        ArrayList arrayList10 = new ArrayList();
        Iterator<C0678m> it2 = list.iterator();
        Object obj5 = null;
        Object obj6 = null;
        while (it2.hasNext()) {
            C0678m next4 = it2.next();
            if (next4.mo6019i()) {
                hashMap4.put(next4.mo6013c(), bool7);
                mo5997u(next4.mo6013c(), next4.mo6015e());
                obj6 = obj6;
                it2 = it2;
            } else {
                Iterator<C0678m> it3 = it2;
                Object obj7 = obj6;
                Boolean bool9 = bool7;
                Object cloneTransition = fragmentTransitionImpl3.cloneTransition(next4.mo6016f());
                C0714n.C0719e c = next4.mo6013c();
                boolean z4 = obj2 != null && (c == eVar8 || c == eVar6);
                if (cloneTransition == null) {
                    if (!z4) {
                        hashMap4.put(c, bool9);
                        mo5997u(c, next4.mo6015e());
                    }
                    view2 = view13;
                    bool7 = bool9;
                    obj6 = obj7;
                    view3 = view;
                } else {
                    ArrayList arrayList11 = new ArrayList();
                    bool7 = bool9;
                    mo5995s(arrayList11, c.mo6158e().f2989H);
                    if (z4) {
                        if (c == eVar8) {
                            arrayList11.removeAll(arrayList8);
                        } else {
                            arrayList11.removeAll(arrayList9);
                        }
                    }
                    if (arrayList11.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view13);
                        view2 = view13;
                        eVar3 = c;
                        obj = obj7;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList11);
                        eVar3 = c;
                        view2 = view13;
                        Object obj8 = cloneTransition;
                        obj = obj7;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, obj8, arrayList11, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (eVar3.mo6157d() == C0714n.C0719e.C0723d.GONE) {
                            cloneTransition = obj8;
                            fragmentTransitionImpl3.scheduleHideFragmentView(cloneTransition, eVar3.mo6158e().f2989H, arrayList11);
                            OneShotPreDrawListener.add(mo6150k(), new C0676k(this, arrayList11));
                        } else {
                            cloneTransition = obj8;
                        }
                    }
                    if (eVar3.mo6157d() == C0714n.C0719e.C0723d.VISIBLE) {
                        arrayList10.addAll(arrayList11);
                        if (z3) {
                            fragmentTransitionImpl3.setEpicenter(cloneTransition, rect5);
                        }
                        view3 = view;
                    } else {
                        view3 = view;
                        fragmentTransitionImpl3.setEpicenter(cloneTransition, view3);
                    }
                    hashMap4.put(eVar3, bool8);
                    if (next4.mo6018h()) {
                        Object mergeTransitionsTogether = fragmentTransitionImpl3.mergeTransitionsTogether(obj5, cloneTransition, (Object) null);
                        obj6 = obj;
                        obj5 = mergeTransitionsTogether;
                    } else {
                        obj6 = fragmentTransitionImpl3.mergeTransitionsTogether(obj, cloneTransition, (Object) null);
                    }
                }
                it2 = it3;
                eVar6 = eVar2;
                view = view3;
                view13 = view2;
                eVar8 = eVar;
            }
        }
        Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj5, obj6, obj2);
        for (C0678m next5 : list) {
            if (!next5.mo6019i() && next5.mo6016f() != null) {
                fragmentTransitionImpl3.setListenerForTransitionEnd(next5.mo6013c().mo6158e(), mergeTransitionsInSequence, next5.mo6015e(), new C0665a(next5));
            }
        }
        C0697j.m2468B(arrayList10, 4);
        ArrayList<String> e = fragmentTransitionImpl3.mo5945e(arrayList9);
        fragmentTransitionImpl3.beginDelayedTransition(mo6150k(), mergeTransitionsInSequence);
        fragmentTransitionImpl3.mo5949h(mo6150k(), arrayList8, arrayList9, e, arrayMap5);
        C0697j.m2468B(arrayList10, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj2, arrayList8, arrayList9);
        return hashMap4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5992f(@NonNull List<C0714n.C0719e> list, boolean z) {
        C0714n.C0719e eVar = null;
        C0714n.C0719e eVar2 = null;
        for (C0714n.C0719e next : list) {
            C0714n.C0719e.C0723d c = C0714n.C0719e.C0723d.m2531c(next.mo6158e().f2989H);
            int i = C0666b.f3262a[next.mo6157d().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (c == C0714n.C0719e.C0723d.VISIBLE && eVar == null) {
                    eVar = next;
                }
            } else if (i == 4 && c != C0714n.C0719e.C0723d.VISIBLE) {
                eVar2 = next;
            }
        }
        ArrayList<C0677l> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<C0714n.C0719e> arrayList3 = new ArrayList<>(list);
        Iterator<C0714n.C0719e> it = list.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            C0714n.C0719e next2 = it.next();
            CancellationSignal cancellationSignal = new CancellationSignal();
            m2368p(next2, cancellationSignal);
            arrayList.add(new C0677l(next2, cancellationSignal));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            m2368p(next2, cancellationSignal2);
            if (z) {
                if (next2 != eVar) {
                    arrayList2.add(new C0678m(next2, cancellationSignal2, z, z2));
                    next2.mo6155a(new C0667c(this, next2));
                    next2.mo6155a(new C0668d(arrayList3, next2));
                    next2.mo6156c().setOnCancelListener(new C0669e(next2));
                }
            } else if (next2 != eVar2) {
                arrayList2.add(new C0678m(next2, cancellationSignal2, z, z2));
                next2.mo6155a(new C0667c(this, next2));
                next2.mo6155a(new C0668d(arrayList3, next2));
                next2.mo6156c().setOnCancelListener(new C0669e(next2));
            }
            z2 = true;
            arrayList2.add(new C0678m(next2, cancellationSignal2, z, z2));
            next2.mo6155a(new C0667c(this, next2));
            next2.mo6155a(new C0668d(arrayList3, next2));
            next2.mo6156c().setOnCancelListener(new C0669e(next2));
        }
        Map<C0714n.C0719e, Boolean> x = m2370x(arrayList2, z, eVar, eVar2);
        boolean containsValue = x.containsValue(Boolean.TRUE);
        for (C0677l lVar : arrayList) {
            C0714n.C0719e a = lVar.mo6010a();
            m2369w(a, lVar.mo6011b(), containsValue, x.containsKey(a) ? x.get(a).booleanValue() : false);
        }
        for (C0714n.C0719e q : arrayList3) {
            mo5993q(q);
        }
        arrayList3.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo5993q(@NonNull C0714n.C0719e eVar) {
        eVar.mo6157d().mo6161a(eVar.mo6158e().f2989H);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo5994r(@NonNull C0714n.C0719e eVar) {
        HashSet remove = this.f3259f.remove(eVar);
        if (remove != null) {
            Iterator it = remove.iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).cancel();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo5995s(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    mo5995s(arrayList, childAt);
                }
            }
            return;
        }
        arrayList.add(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo5996t(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    mo5996t(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo5997u(@NonNull C0714n.C0719e eVar, @NonNull CancellationSignal cancellationSignal) {
        HashSet hashSet = this.f3259f.get(eVar);
        if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            this.f3259f.remove(eVar);
            eVar.mo6154b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo5998v(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
