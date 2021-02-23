package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a */
/* compiled from: BackStackRecord */
final class C0663a extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.C0649m {

    /* renamed from: t */
    final FragmentManager f3256t;

    /* renamed from: u */
    boolean f3257u;

    /* renamed from: v */
    int f3258v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0663a(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.mo5777n0() != null ? fragmentManager.mo5777n0().mo5697b().getClassLoader() : null);
        this.f3258v = -1;
        this.f3256t = fragmentManager;
    }

    /* renamed from: o */
    private static boolean m2352o(FragmentTransaction.C0657a aVar) {
        Fragment fragment = aVar.f3227b;
        return fragment != null && fragment.f3019l && fragment.f2989H != null && !fragment.f2982A && !fragment.f3033z && fragment.mo5575t();
    }

    /* renamed from: a */
    public boolean mo5850a(@NonNull ArrayList<C0663a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.m2230w0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f3215i) {
            return true;
        }
        this.f3256t.mo5754e(this);
        return true;
    }

    public int commit() {
        return mo5979g(false);
    }

    public int commitAllowingStateLoss() {
        return mo5979g(true);
    }

    public void commitNow() {
        disallowAddToBackStack();
        this.f3256t.mo5740Y(this, false);
    }

    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.f3256t.mo5740Y(this, true);
    }

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.f3026s;
        if (fragmentManager == null || fragmentManager == this.f3256t) {
            return super.detach(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5915e(int i, Fragment fragment, @Nullable String str, int i2) {
        super.mo5915e(i, fragment, str, i2);
        fragment.f3026s = this.f3256t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5978f(int i) {
        if (this.f3215i) {
            if (FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f3209c.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.C0657a aVar = this.f3209c.get(i2);
                Fragment fragment = aVar.f3227b;
                if (fragment != null) {
                    fragment.f3025r += i;
                    if (FragmentManager.m2230w0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f3227b + " to " + aVar.f3227b.f3025r);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo5979g(boolean z) {
        if (!this.f3257u) {
            if (FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new C0713m("FragmentManager"));
                mo5980h("  ", printWriter);
                printWriter.close();
            }
            this.f3257u = true;
            if (this.f3215i) {
                this.f3258v = this.f3256t.mo5768i();
            } else {
                this.f3258v = -1;
            }
            this.f3256t.mo5736V(this, z);
            return this.f3258v;
        }
        throw new IllegalStateException("commit already called");
    }

    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        if (this.f3220n != 0) {
            return this.f3256t.mo5777n0().mo5697b().getText(this.f3220n);
        }
        return this.f3221o;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.f3220n;
    }

    @Nullable
    public CharSequence getBreadCrumbTitle() {
        if (this.f3218l != 0) {
            return this.f3256t.mo5777n0().mo5697b().getText(this.f3218l);
        }
        return this.f3219m;
    }

    public int getBreadCrumbTitleRes() {
        return this.f3218l;
    }

    public int getId() {
        return this.f3258v;
    }

    @Nullable
    public String getName() {
        return this.f3217k;
    }

    /* renamed from: h */
    public void mo5980h(String str, PrintWriter printWriter) {
        mo5981i(str, printWriter, true);
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.f3026s;
        if (fragmentManager == null || fragmentManager == this.f3256t) {
            return super.hide(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* renamed from: i */
    public void mo5981i(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3217k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3258v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3257u);
            if (this.f3214h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3214h));
            }
            if (!(this.f3210d == 0 && this.f3211e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3210d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3211e));
            }
            if (!(this.f3212f == 0 && this.f3213g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3212f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3213g));
            }
            if (!(this.f3218l == 0 && this.f3219m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3218l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3219m);
            }
            if (!(this.f3220n == 0 && this.f3221o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3220n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3221o);
            }
        }
        if (!this.f3209c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f3209c.size();
            for (int i = 0; i < size; i++) {
                FragmentTransaction.C0657a aVar = this.f3209c.get(i);
                switch (aVar.f3226a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f3226a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f3227b);
                if (z) {
                    if (!(aVar.f3228c == 0 && aVar.f3229d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3228c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3229d));
                    }
                    if (aVar.f3230e != 0 || aVar.f3231f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3230e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3231f));
                    }
                }
            }
        }
    }

    public boolean isEmpty() {
        return this.f3209c.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo5982j() {
        int size = this.f3209c.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.C0657a aVar = this.f3209c.get(i);
            Fragment fragment = aVar.f3227b;
            if (fragment != null) {
                fragment.mo5452e0(this.f3214h);
                fragment.mo5491h0(this.f3222p, this.f3223q);
            }
            switch (aVar.f3226a) {
                case 1:
                    fragment.mo5449d0(aVar.f3228c);
                    this.f3256t.mo5742Z0(fragment, false);
                    this.f3256t.mo5759g(fragment);
                    break;
                case 3:
                    fragment.mo5449d0(aVar.f3229d);
                    this.f3256t.mo5730P0(fragment);
                    break;
                case 4:
                    fragment.mo5449d0(aVar.f3229d);
                    this.f3256t.mo5804v0(fragment);
                    break;
                case 5:
                    fragment.mo5449d0(aVar.f3228c);
                    this.f3256t.mo5742Z0(fragment, false);
                    this.f3256t.mo5752d1(fragment);
                    break;
                case 6:
                    fragment.mo5449d0(aVar.f3229d);
                    this.f3256t.mo5803v(fragment);
                    break;
                case 7:
                    fragment.mo5449d0(aVar.f3228c);
                    this.f3256t.mo5742Z0(fragment, false);
                    this.f3256t.mo5773k(fragment);
                    break;
                case 8:
                    this.f3256t.mo5746b1(fragment);
                    break;
                case 9:
                    this.f3256t.mo5746b1((Fragment) null);
                    break;
                case 10:
                    this.f3256t.mo5743a1(fragment, aVar.f3233h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3226a);
            }
            if (!(this.f3224r || aVar.f3226a == 1 || fragment == null)) {
                if (FragmentManager.f3089P) {
                    this.f3256t.mo5798t(fragment).mo6073k();
                } else {
                    this.f3256t.mo5713F0(fragment);
                }
            }
        }
        if (!this.f3224r) {
            FragmentManager fragmentManager = this.f3256t;
            fragmentManager.mo5715G0(fragmentManager.f3120q, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo5983k(boolean z) {
        for (int size = this.f3209c.size() - 1; size >= 0; size--) {
            FragmentTransaction.C0657a aVar = this.f3209c.get(size);
            Fragment fragment = aVar.f3227b;
            if (fragment != null) {
                fragment.mo5452e0(FragmentManager.m2205W0(this.f3214h));
                fragment.mo5491h0(this.f3223q, this.f3222p);
            }
            switch (aVar.f3226a) {
                case 1:
                    fragment.mo5449d0(aVar.f3231f);
                    this.f3256t.mo5742Z0(fragment, true);
                    this.f3256t.mo5730P0(fragment);
                    break;
                case 3:
                    fragment.mo5449d0(aVar.f3230e);
                    this.f3256t.mo5759g(fragment);
                    break;
                case 4:
                    fragment.mo5449d0(aVar.f3230e);
                    this.f3256t.mo5752d1(fragment);
                    break;
                case 5:
                    fragment.mo5449d0(aVar.f3231f);
                    this.f3256t.mo5742Z0(fragment, true);
                    this.f3256t.mo5804v0(fragment);
                    break;
                case 6:
                    fragment.mo5449d0(aVar.f3230e);
                    this.f3256t.mo5773k(fragment);
                    break;
                case 7:
                    fragment.mo5449d0(aVar.f3231f);
                    this.f3256t.mo5742Z0(fragment, true);
                    this.f3256t.mo5803v(fragment);
                    break;
                case 8:
                    this.f3256t.mo5746b1((Fragment) null);
                    break;
                case 9:
                    this.f3256t.mo5746b1(fragment);
                    break;
                case 10:
                    this.f3256t.mo5743a1(fragment, aVar.f3232g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3226a);
            }
            if (!(this.f3224r || aVar.f3226a == 3 || fragment == null)) {
                if (FragmentManager.f3089P) {
                    this.f3256t.mo5798t(fragment).mo6073k();
                } else {
                    this.f3256t.mo5713F0(fragment);
                }
            }
        }
        if (!this.f3224r && z) {
            FragmentManager fragmentManager = this.f3256t;
            fragmentManager.mo5715G0(fragmentManager.f3120q, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public Fragment mo5984l(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f3209c.size()) {
            FragmentTransaction.C0657a aVar = this.f3209c.get(i);
            int i2 = aVar.f3226a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = aVar.f3227b;
                    int i3 = fragment3.f3031x;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.f3031x == i3) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f3209c.add(i, new FragmentTransaction.C0657a(9, fragment4));
                                    i++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.C0657a aVar2 = new FragmentTransaction.C0657a(3, fragment4);
                                aVar2.f3228c = aVar.f3228c;
                                aVar2.f3230e = aVar.f3230e;
                                aVar2.f3229d = aVar.f3229d;
                                aVar2.f3231f = aVar.f3231f;
                                this.f3209c.add(i, aVar2);
                                arrayList2.remove(fragment4);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.f3209c.remove(i);
                        i--;
                    } else {
                        aVar.f3226a = 1;
                        arrayList2.add(fragment3);
                    }
                } else if (i2 == 3 || i2 == 6) {
                    arrayList2.remove(aVar.f3227b);
                    Fragment fragment5 = aVar.f3227b;
                    if (fragment5 == fragment2) {
                        this.f3209c.add(i, new FragmentTransaction.C0657a(9, fragment5));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f3209c.add(i, new FragmentTransaction.C0657a(9, fragment2));
                        i++;
                        fragment2 = aVar.f3227b;
                    }
                }
                i++;
            }
            arrayList2.add(aVar.f3227b);
            i++;
        }
        return fragment2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo5985m(int i) {
        int size = this.f3209c.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f3209c.get(i2).f3227b;
            int i3 = fragment != null ? fragment.f3031x : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo5986n(ArrayList<C0663a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f3209c.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f3209c.get(i4).f3227b;
            int i5 = fragment != null ? fragment.f3031x : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    C0663a aVar = arrayList.get(i6);
                    int size2 = aVar.f3209c.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.f3209c.get(i7).f3227b;
                        if ((fragment2 != null ? fragment2.f3031x : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean mo5987p() {
        for (int i = 0; i < this.f3209c.size(); i++) {
            if (m2352o(this.f3209c.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: q */
    public void mo5988q() {
        if (this.f3225s != null) {
            for (int i = 0; i < this.f3225s.size(); i++) {
                this.f3225s.get(i).run();
            }
            this.f3225s = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo5989r(Fragment.C0631k kVar) {
        for (int i = 0; i < this.f3209c.size(); i++) {
            FragmentTransaction.C0657a aVar = this.f3209c.get(i);
            if (m2352o(aVar)) {
                aVar.f3227b.mo5455f0(kVar);
            }
        }
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.f3026s;
        if (fragmentManager == null || fragmentManager == this.f3256t) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public Fragment mo5990s(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f3209c.size() - 1; size >= 0; size--) {
            FragmentTransaction.C0657a aVar = this.f3209c.get(size);
            int i = aVar.f3226a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f3227b;
                            break;
                        case 10:
                            aVar.f3233h = aVar.f3232g;
                            break;
                    }
                }
                arrayList.add(aVar.f3227b);
            }
            arrayList.remove(aVar.f3227b);
        }
        return fragment;
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.f3026s == this.f3256t) {
            Lifecycle.State state2 = Lifecycle.State.CREATED;
            if (state.isAtLeast(state2)) {
                return super.setMaxLifecycle(fragment, state);
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + state2);
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f3256t);
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.f3026s) == null || fragmentManager == this.f3256t) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.f3026s;
        if (fragmentManager == null || fragmentManager == this.f3256t) {
            return super.show(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3258v >= 0) {
            sb.append(" #");
            sb.append(this.f3258v);
        }
        if (this.f3217k != null) {
            sb.append(" ");
            sb.append(this.f3217k);
        }
        sb.append("}");
        return sb.toString();
    }
}
