package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.p003os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: androidx.fragment.app.j */
/* compiled from: FragmentTransition */
class C0697j {

    /* renamed from: a */
    private static final int[] f3340a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b */
    static final FragmentTransitionImpl f3341b = (Build.VERSION.SDK_INT >= 21 ? new C0706k() : null);

    /* renamed from: c */
    static final FragmentTransitionImpl f3342c = m2494x();

    /* renamed from: androidx.fragment.app.j$a */
    /* compiled from: FragmentTransition */
    class C0698a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0704g f3343a;

        /* renamed from: b */
        final /* synthetic */ Fragment f3344b;

        /* renamed from: c */
        final /* synthetic */ CancellationSignal f3345c;

        C0698a(C0704g gVar, Fragment fragment, CancellationSignal cancellationSignal) {
            this.f3343a = gVar;
            this.f3344b = fragment;
            this.f3345c = cancellationSignal;
        }

        public void run() {
            this.f3343a.mo5840a(this.f3344b, this.f3345c);
        }
    }

    /* renamed from: androidx.fragment.app.j$b */
    /* compiled from: FragmentTransition */
    class C0699b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3346a;

        C0699b(ArrayList arrayList) {
            this.f3346a = arrayList;
        }

        public void run() {
            C0697j.m2468B(this.f3346a, 4);
        }
    }

    /* renamed from: androidx.fragment.app.j$c */
    /* compiled from: FragmentTransition */
    class C0700c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0704g f3347a;

        /* renamed from: b */
        final /* synthetic */ Fragment f3348b;

        /* renamed from: c */
        final /* synthetic */ CancellationSignal f3349c;

        C0700c(C0704g gVar, Fragment fragment, CancellationSignal cancellationSignal) {
            this.f3347a = gVar;
            this.f3348b = fragment;
            this.f3349c = cancellationSignal;
        }

        public void run() {
            this.f3347a.mo5840a(this.f3348b, this.f3349c);
        }
    }

    /* renamed from: androidx.fragment.app.j$d */
    /* compiled from: FragmentTransition */
    class C0701d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f3350a;

        /* renamed from: b */
        final /* synthetic */ FragmentTransitionImpl f3351b;

        /* renamed from: c */
        final /* synthetic */ View f3352c;

        /* renamed from: d */
        final /* synthetic */ Fragment f3353d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f3354e;

        /* renamed from: f */
        final /* synthetic */ ArrayList f3355f;

        /* renamed from: g */
        final /* synthetic */ ArrayList f3356g;

        /* renamed from: h */
        final /* synthetic */ Object f3357h;

        C0701d(Object obj, FragmentTransitionImpl fragmentTransitionImpl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f3350a = obj;
            this.f3351b = fragmentTransitionImpl;
            this.f3352c = view;
            this.f3353d = fragment;
            this.f3354e = arrayList;
            this.f3355f = arrayList2;
            this.f3356g = arrayList3;
            this.f3357h = obj2;
        }

        public void run() {
            Object obj = this.f3350a;
            if (obj != null) {
                this.f3351b.removeTarget(obj, this.f3352c);
                this.f3355f.addAll(C0697j.m2481k(this.f3351b, this.f3350a, this.f3353d, this.f3354e, this.f3352c));
            }
            if (this.f3356g != null) {
                if (this.f3357h != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f3352c);
                    this.f3351b.replaceTargets(this.f3357h, this.f3356g, arrayList);
                }
                this.f3356g.clear();
                this.f3356g.add(this.f3352c);
            }
        }
    }

    /* renamed from: androidx.fragment.app.j$e */
    /* compiled from: FragmentTransition */
    class C0702e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Fragment f3358a;

        /* renamed from: b */
        final /* synthetic */ Fragment f3359b;

        /* renamed from: c */
        final /* synthetic */ boolean f3360c;

        /* renamed from: d */
        final /* synthetic */ ArrayMap f3361d;

        /* renamed from: e */
        final /* synthetic */ View f3362e;

        /* renamed from: f */
        final /* synthetic */ FragmentTransitionImpl f3363f;

        /* renamed from: g */
        final /* synthetic */ Rect f3364g;

        C0702e(Fragment fragment, Fragment fragment2, boolean z, ArrayMap arrayMap, View view, FragmentTransitionImpl fragmentTransitionImpl, Rect rect) {
            this.f3358a = fragment;
            this.f3359b = fragment2;
            this.f3360c = z;
            this.f3361d = arrayMap;
            this.f3362e = view;
            this.f3363f = fragmentTransitionImpl;
            this.f3364g = rect;
        }

        public void run() {
            C0697j.m2476f(this.f3358a, this.f3359b, this.f3360c, this.f3361d, false);
            View view = this.f3362e;
            if (view != null) {
                this.f3363f.getBoundsOnScreen(view, this.f3364g);
            }
        }
    }

    /* renamed from: androidx.fragment.app.j$f */
    /* compiled from: FragmentTransition */
    class C0703f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ FragmentTransitionImpl f3365a;

        /* renamed from: b */
        final /* synthetic */ ArrayMap f3366b;

        /* renamed from: c */
        final /* synthetic */ Object f3367c;

        /* renamed from: d */
        final /* synthetic */ C0705h f3368d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f3369e;

        /* renamed from: f */
        final /* synthetic */ View f3370f;

        /* renamed from: g */
        final /* synthetic */ Fragment f3371g;

        /* renamed from: h */
        final /* synthetic */ Fragment f3372h;

        /* renamed from: i */
        final /* synthetic */ boolean f3373i;

        /* renamed from: j */
        final /* synthetic */ ArrayList f3374j;

        /* renamed from: k */
        final /* synthetic */ Object f3375k;

        /* renamed from: l */
        final /* synthetic */ Rect f3376l;

        C0703f(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object obj, C0705h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f3365a = fragmentTransitionImpl;
            this.f3366b = arrayMap;
            this.f3367c = obj;
            this.f3368d = hVar;
            this.f3369e = arrayList;
            this.f3370f = view;
            this.f3371g = fragment;
            this.f3372h = fragment2;
            this.f3373i = z;
            this.f3374j = arrayList2;
            this.f3375k = obj2;
            this.f3376l = rect;
        }

        public void run() {
            ArrayMap<String, View> h = C0697j.m2478h(this.f3365a, this.f3366b, this.f3367c, this.f3368d);
            if (h != null) {
                this.f3369e.addAll(h.values());
                this.f3369e.add(this.f3370f);
            }
            C0697j.m2476f(this.f3371g, this.f3372h, this.f3373i, h, false);
            Object obj = this.f3367c;
            if (obj != null) {
                this.f3365a.swapSharedElementTargets(obj, this.f3374j, this.f3369e);
                View t = C0697j.m2490t(h, this.f3368d, this.f3375k, this.f3373i);
                if (t != null) {
                    this.f3365a.getBoundsOnScreen(t, this.f3376l);
                }
            }
        }
    }

    /* renamed from: androidx.fragment.app.j$g */
    /* compiled from: FragmentTransition */
    interface C0704g {
        /* renamed from: a */
        void mo5840a(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal);

        /* renamed from: b */
        void mo5841b(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal);
    }

    /* renamed from: androidx.fragment.app.j$h */
    /* compiled from: FragmentTransition */
    static class C0705h {

        /* renamed from: a */
        public Fragment f3377a;

        /* renamed from: b */
        public boolean f3378b;

        /* renamed from: c */
        public C0663a f3379c;

        /* renamed from: d */
        public Fragment f3380d;

        /* renamed from: e */
        public boolean f3381e;

        /* renamed from: f */
        public C0663a f3382f;

        C0705h() {
        }
    }

    /* renamed from: A */
    private static void m2467A(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, C0663a aVar) {
        String str;
        ArrayList<String> arrayList = aVar.f3222p;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = aVar.f3223q.get(0);
            } else {
                str = aVar.f3222p.get(0);
            }
            View view = arrayMap.get(str);
            fragmentTransitionImpl.setEpicenter(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.setEpicenter(obj2, view);
            }
        }
    }

    /* renamed from: B */
    static void m2468B(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* renamed from: C */
    static void m2469C(@NonNull Context context, @NonNull FragmentContainer fragmentContainer, ArrayList<C0663a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, C0704g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            C0663a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                m2475e(aVar, sparseArray, z);
            } else {
                m2473c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                ArrayMap<String, String> d = m2474d(keyAt, arrayList, arrayList2, i, i2);
                C0705h hVar = (C0705h) sparseArray.valueAt(i4);
                if (fragmentContainer.onHasView() && (viewGroup = (ViewGroup) fragmentContainer.onFindViewById(keyAt)) != null) {
                    if (z) {
                        m2485o(viewGroup, hVar, view, d, gVar);
                    } else {
                        m2484n(viewGroup, hVar, view, d, gVar);
                    }
                }
            }
        }
    }

    /* renamed from: D */
    static boolean m2470D() {
        return (f3341b == null && f3342c == null) ? false : true;
    }

    /* renamed from: a */
    private static void m2471a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        if (r0.f3019l != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008a, code lost:
        if (r0.f3033z == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008c, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m2472b(androidx.fragment.app.C0663a r8, androidx.fragment.app.FragmentTransaction.C0657a r9, android.util.SparseArray<androidx.fragment.app.C0697j.C0705h> r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.f3227b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.f3031x
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = f3340a
            int r9 = r9.f3226a
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.f3226a
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x007f
            r4 = 3
            if (r9 == r4) goto L_0x0057
            r4 = 4
            if (r9 == r4) goto L_0x003f
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0057
            r4 = 7
            if (r9 == r4) goto L_0x007f
            r9 = 0
            r3 = 0
        L_0x002a:
            r4 = 0
            goto L_0x0092
        L_0x002d:
            if (r12 == 0) goto L_0x003c
            boolean r9 = r0.f2995N
            if (r9 == 0) goto L_0x008e
            boolean r9 = r0.f3033z
            if (r9 != 0) goto L_0x008e
            boolean r9 = r0.f3019l
            if (r9 == 0) goto L_0x008e
            goto L_0x008c
        L_0x003c:
            boolean r9 = r0.f3033z
            goto L_0x008f
        L_0x003f:
            if (r12 == 0) goto L_0x004e
            boolean r9 = r0.f2995N
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.f3019l
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.f3033z
            if (r9 == 0) goto L_0x0070
        L_0x004d:
            goto L_0x006e
        L_0x004e:
            boolean r9 = r0.f3019l
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.f3033z
            if (r9 != 0) goto L_0x0070
            goto L_0x004d
        L_0x0057:
            if (r12 == 0) goto L_0x0072
            boolean r9 = r0.f3019l
            if (r9 != 0) goto L_0x0070
            android.view.View r9 = r0.f2989H
            if (r9 == 0) goto L_0x0070
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0070
            float r9 = r0.f2996O
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0070
        L_0x006e:
            r9 = 1
            goto L_0x007b
        L_0x0070:
            r9 = 0
            goto L_0x007b
        L_0x0072:
            boolean r9 = r0.f3019l
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.f3033z
            if (r9 != 0) goto L_0x0070
            goto L_0x006e
        L_0x007b:
            r4 = r9
            r9 = 1
            r3 = 0
            goto L_0x0092
        L_0x007f:
            if (r12 == 0) goto L_0x0084
            boolean r9 = r0.f2994M
            goto L_0x008f
        L_0x0084:
            boolean r9 = r0.f3019l
            if (r9 != 0) goto L_0x008e
            boolean r9 = r0.f3033z
            if (r9 != 0) goto L_0x008e
        L_0x008c:
            r9 = 1
            goto L_0x008f
        L_0x008e:
            r9 = 0
        L_0x008f:
            r2 = r9
            r9 = 0
            goto L_0x002a
        L_0x0092:
            java.lang.Object r5 = r10.get(r1)
            androidx.fragment.app.j$h r5 = (androidx.fragment.app.C0697j.C0705h) r5
            if (r2 == 0) goto L_0x00a4
            androidx.fragment.app.j$h r5 = m2486p(r5, r10, r1)
            r5.f3377a = r0
            r5.f3378b = r11
            r5.f3379c = r8
        L_0x00a4:
            r2 = 0
            if (r12 != 0) goto L_0x00c5
            if (r3 == 0) goto L_0x00c5
            if (r5 == 0) goto L_0x00b1
            androidx.fragment.app.Fragment r3 = r5.f3380d
            if (r3 != r0) goto L_0x00b1
            r5.f3380d = r2
        L_0x00b1:
            boolean r3 = r8.f3224r
            if (r3 != 0) goto L_0x00c5
            androidx.fragment.app.FragmentManager r3 = r8.f3256t
            androidx.fragment.app.h r6 = r3.mo5798t(r0)
            androidx.fragment.app.i r7 = r3.mo5776m0()
            r7.mo6101q(r6)
            r3.mo5717H0(r0)
        L_0x00c5:
            if (r4 == 0) goto L_0x00d7
            if (r5 == 0) goto L_0x00cd
            androidx.fragment.app.Fragment r3 = r5.f3380d
            if (r3 != 0) goto L_0x00d7
        L_0x00cd:
            androidx.fragment.app.j$h r5 = m2486p(r5, r10, r1)
            r5.f3380d = r0
            r5.f3381e = r11
            r5.f3382f = r8
        L_0x00d7:
            if (r12 != 0) goto L_0x00e3
            if (r9 == 0) goto L_0x00e3
            if (r5 == 0) goto L_0x00e3
            androidx.fragment.app.Fragment r8 = r5.f3377a
            if (r8 != r0) goto L_0x00e3
            r5.f3377a = r2
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0697j.m2472b(androidx.fragment.app.a, androidx.fragment.app.FragmentTransaction$a, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: c */
    public static void m2473c(C0663a aVar, SparseArray<C0705h> sparseArray, boolean z) {
        int size = aVar.f3209c.size();
        for (int i = 0; i < size; i++) {
            m2472b(aVar, aVar.f3209c.get(i), sparseArray, false, z);
        }
    }

    /* renamed from: d */
    private static ArrayMap<String, String> m2474d(int i, ArrayList<C0663a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0663a aVar = arrayList.get(i4);
            if (aVar.mo5985m(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar.f3222p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar.f3222p;
                        arrayList4 = aVar.f3223q;
                    } else {
                        ArrayList<String> arrayList6 = aVar.f3222p;
                        arrayList3 = aVar.f3223q;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    /* renamed from: e */
    public static void m2475e(C0663a aVar, SparseArray<C0705h> sparseArray, boolean z) {
        if (aVar.f3256t.mo5774k0().onHasView()) {
            for (int size = aVar.f3209c.size() - 1; size >= 0; size--) {
                m2472b(aVar, aVar.f3209c.get(size), sparseArray, true, z);
            }
        }
    }

    /* renamed from: f */
    static void m2476f(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback sharedElementCallback;
        int i;
        if (z) {
            sharedElementCallback = fragment2.mo5490h();
        } else {
            sharedElementCallback = fragment.mo5490h();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i = 0;
            } else {
                i = arrayMap.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(arrayMap.keyAt(i2));
                arrayList.add(arrayMap.valueAt(i2));
            }
            if (z2) {
                sharedElementCallback.onSharedElementStart(arrayList2, arrayList, (List<View>) null);
            } else {
                sharedElementCallback.onSharedElementEnd(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    /* renamed from: g */
    private static boolean m2477g(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    static ArrayMap<String, View> m2478h(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, C0705h hVar) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        String q;
        Fragment fragment = hVar.f3377a;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.mo5944d(arrayMap2, view);
        C0663a aVar = hVar.f3379c;
        if (hVar.f3378b) {
            sharedElementCallback = fragment.mo5494i();
            arrayList = aVar.f3222p;
        } else {
            sharedElementCallback = fragment.mo5490h();
            arrayList = aVar.f3223q;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String q2 = m2487q(arrayMap, str);
                    if (q2 != null) {
                        arrayMap.remove(q2);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (q = m2487q(arrayMap, str)) != null) {
                    arrayMap.put(q, ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            m2495y(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    /* renamed from: i */
    private static ArrayMap<String, View> m2479i(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, C0705h hVar) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = hVar.f3380d;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.mo5944d(arrayMap2, fragment.requireView());
        C0663a aVar = hVar.f3382f;
        if (hVar.f3381e) {
            sharedElementCallback = fragment.mo5490h();
            arrayList = aVar.f3223q;
        } else {
            sharedElementCallback = fragment.mo5494i();
            arrayList = aVar.f3222p;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    /* renamed from: j */
    private static FragmentTransitionImpl m2480j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = f3341b;
        if (fragmentTransitionImpl != null && m2477g(fragmentTransitionImpl, arrayList)) {
            return fragmentTransitionImpl;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = f3342c;
        if (fragmentTransitionImpl2 != null && m2477g(fragmentTransitionImpl2, arrayList)) {
            return fragmentTransitionImpl2;
        }
        if (fragmentTransitionImpl == null && fragmentTransitionImpl2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: k */
    static ArrayList<View> m2481k(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.mo5938a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    /* renamed from: l */
    private static Object m2482l(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, C0705h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Object obj4;
        Rect rect;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        C0705h hVar2 = hVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = hVar2.f3377a;
        Fragment fragment2 = hVar2.f3380d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar2.f3378b;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            obj3 = null;
        } else {
            obj3 = m2491u(fragmentTransitionImpl2, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> i = m2479i(fragmentTransitionImpl2, arrayMap2, obj3, hVar2);
        if (arrayMap.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(i.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        m2476f(fragment, fragment2, z, i, true);
        if (obj4 != null) {
            rect = new Rect();
            fragmentTransitionImpl2.setSharedElementTargets(obj4, view, arrayList3);
            m2467A(fragmentTransitionImpl, obj4, obj2, i, hVar2.f3381e, hVar2.f3382f);
            if (obj5 != null) {
                fragmentTransitionImpl2.setEpicenter(obj5, rect);
            }
        } else {
            rect = null;
        }
        C0703f fVar = r0;
        C0703f fVar2 = new C0703f(fragmentTransitionImpl, arrayMap, obj4, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect);
        OneShotPreDrawListener.add(viewGroup, fVar);
        return obj4;
    }

    /* renamed from: m */
    private static Object m2483m(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, C0705h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Rect rect;
        View view2;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        View view3 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        C0705h hVar2 = hVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = hVar2.f3377a;
        Fragment fragment2 = hVar2.f3380d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar2.f3378b;
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = m2491u(fragmentTransitionImpl, fragment, fragment2, z);
        }
        ArrayMap<String, View> i = m2479i(fragmentTransitionImpl, arrayMap2, obj3, hVar2);
        ArrayMap<String, View> h = m2478h(fragmentTransitionImpl, arrayMap2, obj3, hVar2);
        if (arrayMap.isEmpty()) {
            if (i != null) {
                i.clear();
            }
            if (h != null) {
                h.clear();
            }
            obj4 = null;
        } else {
            m2471a(arrayList3, i, arrayMap.keySet());
            m2471a(arrayList4, h, arrayMap.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        m2476f(fragment, fragment2, z, i, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            fragmentTransitionImpl.setSharedElementTargets(obj4, view3, arrayList3);
            m2467A(fragmentTransitionImpl, obj4, obj2, i, hVar2.f3381e, hVar2.f3382f);
            Rect rect2 = new Rect();
            View t = m2490t(h, hVar2, obj5, z);
            if (t != null) {
                fragmentTransitionImpl.setEpicenter(obj5, rect2);
            }
            rect = rect2;
            view2 = t;
        } else {
            view2 = null;
            rect = null;
        }
        OneShotPreDrawListener.add(viewGroup, new C0702e(fragment, fragment2, z, h, view2, fragmentTransitionImpl, rect));
        return obj4;
    }

    /* renamed from: n */
    private static void m2484n(@NonNull ViewGroup viewGroup, C0705h hVar, View view, ArrayMap<String, String> arrayMap, C0704g gVar) {
        Object obj;
        ViewGroup viewGroup2 = viewGroup;
        C0705h hVar2 = hVar;
        View view2 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        C0704g gVar2 = gVar;
        Fragment fragment = hVar2.f3377a;
        Fragment fragment2 = hVar2.f3380d;
        FragmentTransitionImpl j = m2480j(fragment2, fragment);
        if (j != null) {
            boolean z = hVar2.f3378b;
            boolean z2 = hVar2.f3381e;
            Object r = m2488r(j, fragment, z);
            Object s = m2489s(j, fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = s;
            FragmentTransitionImpl fragmentTransitionImpl = j;
            Object l = m2482l(j, viewGroup, view, arrayMap, hVar, arrayList, arrayList2, r, obj2);
            Object obj3 = r;
            if (obj3 == null && l == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList<View> k = m2481k(fragmentTransitionImpl, obj, fragment2, arrayList4, view2);
            if (k == null || k.isEmpty()) {
                obj = null;
            }
            Object obj4 = obj;
            fragmentTransitionImpl.addTarget(obj3, view2);
            Object v = m2492v(fragmentTransitionImpl, obj3, obj4, l, fragment, hVar2.f3378b);
            if (!(fragment2 == null || k == null || (k.size() <= 0 && arrayList4.size() <= 0))) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                gVar2.mo5841b(fragment2, cancellationSignal);
                fragmentTransitionImpl.setListenerForTransitionEnd(fragment2, v, cancellationSignal, new C0700c(gVar2, fragment2, cancellationSignal));
            }
            if (v != null) {
                ArrayList arrayList5 = new ArrayList();
                FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
                fragmentTransitionImpl2.scheduleRemoveTargets(v, obj3, arrayList5, obj4, k, l, arrayList2);
                m2496z(fragmentTransitionImpl2, viewGroup, fragment, view, arrayList2, obj3, arrayList5, obj4, k);
                ViewGroup viewGroup3 = viewGroup;
                FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
                ArrayList arrayList6 = arrayList2;
                fragmentTransitionImpl3.mo5947g(viewGroup3, arrayList6, arrayMap2);
                fragmentTransitionImpl3.beginDelayedTransition(viewGroup3, v);
                fragmentTransitionImpl3.mo5946f(viewGroup3, arrayList6, arrayMap2);
            }
        }
    }

    /* renamed from: o */
    private static void m2485o(@NonNull ViewGroup viewGroup, C0705h hVar, View view, ArrayMap<String, String> arrayMap, C0704g gVar) {
        Object obj;
        C0705h hVar2 = hVar;
        View view2 = view;
        C0704g gVar2 = gVar;
        Fragment fragment = hVar2.f3377a;
        Fragment fragment2 = hVar2.f3380d;
        FragmentTransitionImpl j = m2480j(fragment2, fragment);
        if (j != null) {
            boolean z = hVar2.f3378b;
            boolean z2 = hVar2.f3381e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object r = m2488r(j, fragment, z);
            Object s = m2489s(j, fragment2, z2);
            ArrayList arrayList3 = arrayList2;
            Object m = m2483m(j, viewGroup, view, arrayMap, hVar, arrayList2, arrayList, r, s);
            Object obj2 = r;
            if (obj2 == null && m == null) {
                obj = s;
                if (obj == null) {
                    return;
                }
            } else {
                obj = s;
            }
            ArrayList<View> k = m2481k(j, obj, fragment2, arrayList3, view2);
            ArrayList<View> k2 = m2481k(j, obj2, fragment, arrayList, view2);
            m2468B(k2, 4);
            Fragment fragment3 = fragment;
            ArrayList<View> arrayList4 = k;
            Object v = m2492v(j, obj2, obj, m, fragment3, z);
            if (!(fragment2 == null || arrayList4 == null || (arrayList4.size() <= 0 && arrayList3.size() <= 0))) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                C0704g gVar3 = gVar;
                gVar3.mo5841b(fragment2, cancellationSignal);
                j.setListenerForTransitionEnd(fragment2, v, cancellationSignal, new C0698a(gVar3, fragment2, cancellationSignal));
            }
            if (v != null) {
                m2493w(j, obj, fragment2, arrayList4);
                ArrayList<String> e = j.mo5945e(arrayList);
                FragmentTransitionImpl fragmentTransitionImpl = j;
                fragmentTransitionImpl.scheduleRemoveTargets(v, obj2, k2, obj, arrayList4, m, arrayList);
                ViewGroup viewGroup2 = viewGroup;
                j.beginDelayedTransition(viewGroup2, v);
                fragmentTransitionImpl.mo5949h(viewGroup2, arrayList3, arrayList, e, arrayMap);
                m2468B(k2, 0);
                j.swapSharedElementTargets(m, arrayList3, arrayList);
            }
        }
    }

    /* renamed from: p */
    private static C0705h m2486p(C0705h hVar, SparseArray<C0705h> sparseArray, int i) {
        if (hVar != null) {
            return hVar;
        }
        C0705h hVar2 = new C0705h();
        sparseArray.put(i, hVar2);
        return hVar2;
    }

    /* renamed from: q */
    static String m2487q(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    /* renamed from: r */
    private static Object m2488r(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    /* renamed from: s */
    private static Object m2489s(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    /* renamed from: t */
    static View m2490t(ArrayMap<String, View> arrayMap, C0705h hVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        C0663a aVar = hVar.f3379c;
        if (obj == null || arrayMap == null || (arrayList = aVar.f3222p) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar.f3222p.get(0);
        } else {
            str = aVar.f3223q.get(0);
        }
        return arrayMap.get(str);
    }

    /* renamed from: u */
    private static Object m2491u(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(obj));
    }

    /* renamed from: v */
    private static Object m2492v(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    /* renamed from: w */
    private static void m2493w(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.f3019l && fragment.f3033z && fragment.f2995N) {
            fragment.mo5447c0(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.f2988G, new C0699b(arrayList));
        }
    }

    /* renamed from: x */
    private static FragmentTransitionImpl m2494x() {
        try {
            return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: y */
    static void m2495y(@NonNull ArrayMap<String, String> arrayMap, @NonNull ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    /* renamed from: z */
    private static void m2496z(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        OneShotPreDrawListener.add(viewGroup, new C0701d(obj, fragmentTransitionImpl, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
