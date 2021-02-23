package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.fragment.app.i */
/* compiled from: FragmentStore */
class C0696i {

    /* renamed from: a */
    private final ArrayList<Fragment> f3337a = new ArrayList<>();

    /* renamed from: b */
    private final HashMap<String, C0693h> f3338b = new HashMap<>();

    /* renamed from: c */
    private C0691g f3339c;

    C0696i() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6085a(@NonNull Fragment fragment) {
        if (!this.f3337a.contains(fragment)) {
            synchronized (this.f3337a) {
                this.f3337a.add(fragment);
            }
            fragment.f3019l = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6086b() {
        this.f3338b.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6087c(@NonNull String str) {
        return this.f3338b.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6088d(int i) {
        for (C0693h next : this.f3338b.values()) {
            if (next != null) {
                next.mo6080s(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6089e(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        String str2 = str + "    ";
        if (!this.f3338b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (C0693h next : this.f3338b.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment j = next.mo6072j();
                    printWriter.println(j);
                    j.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f3337a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.f3337a.get(i).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: f */
    public Fragment mo6090f(@NonNull String str) {
        C0693h hVar = this.f3338b.get(str);
        if (hVar != null) {
            return hVar.mo6072j();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: g */
    public Fragment mo6091g(@IdRes int i) {
        for (int size = this.f3337a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3337a.get(size);
            if (fragment != null && fragment.f3030w == i) {
                return fragment;
            }
        }
        for (C0693h next : this.f3338b.values()) {
            if (next != null) {
                Fragment j = next.mo6072j();
                if (j.f3030w == i) {
                    return j;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: h */
    public Fragment mo6092h(@Nullable String str) {
        if (str != null) {
            for (int size = this.f3337a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f3337a.get(size);
                if (fragment != null && str.equals(fragment.f3032y)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (C0693h next : this.f3338b.values()) {
            if (next != null) {
                Fragment j = next.mo6072j();
                if (str.equals(j.f3032y)) {
                    return j;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: i */
    public Fragment mo6093i(@NonNull String str) {
        Fragment d;
        for (C0693h next : this.f3338b.values()) {
            if (next != null && (d = next.mo6072j().mo5448d(str)) != null) {
                return d;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo6094j(@NonNull Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.f2988G;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f3337a.indexOf(fragment);
        for (int i = indexOf - 1; i >= 0; i--) {
            Fragment fragment2 = this.f3337a.get(i);
            if (fragment2.f2988G == viewGroup && (view2 = fragment2.f2989H) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f3337a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f3337a.get(indexOf);
            if (fragment3.f2988G == viewGroup && (view = fragment3.f2989H) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo6095k() {
        return this.f3338b.size();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: l */
    public List<C0693h> mo6096l() {
        ArrayList arrayList = new ArrayList();
        for (C0693h next : this.f3338b.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: m */
    public List<Fragment> mo6097m() {
        ArrayList arrayList = new ArrayList();
        for (C0693h next : this.f3338b.values()) {
            if (next != null) {
                arrayList.add(next.mo6072j());
            } else {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: n */
    public C0693h mo6098n(@NonNull String str) {
        return this.f3338b.get(str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: o */
    public List<Fragment> mo6099o() {
        ArrayList arrayList;
        if (this.f3337a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3337a) {
            arrayList = new ArrayList(this.f3337a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public C0691g mo6100p() {
        return this.f3339c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo6101q(@NonNull C0693h hVar) {
        Fragment j = hVar.mo6072j();
        if (!mo6087c(j.f3013f)) {
            this.f3338b.put(j.f3013f, hVar);
            if (j.f2984C) {
                if (j.f2983B) {
                    this.f3339c.mo6046e(j);
                } else {
                    this.f3339c.mo6056n(j);
                }
                j.f2984C = false;
            }
            if (FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo6102r(@NonNull C0693h hVar) {
        Fragment j = hVar.mo6072j();
        if (j.f2983B) {
            this.f3339c.mo6056n(j);
        }
        if (this.f3338b.put(j.f3013f, (Object) null) != null && FragmentManager.m2230w0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo6103s() {
        Iterator<Fragment> it = this.f3337a.iterator();
        while (it.hasNext()) {
            C0693h hVar = this.f3338b.get(it.next().f3013f);
            if (hVar != null) {
                hVar.mo6073k();
            }
        }
        for (C0693h next : this.f3338b.values()) {
            if (next != null) {
                next.mo6073k();
                Fragment j = next.mo6072j();
                if (j.f3020m && !j.mo5550s()) {
                    mo6102r(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo6104t(@NonNull Fragment fragment) {
        synchronized (this.f3337a) {
            this.f3337a.remove(fragment);
        }
        fragment.f3019l = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo6105u() {
        this.f3338b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo6106v(@Nullable List<String> list) {
        this.f3337a.clear();
        if (list != null) {
            for (String next : list) {
                Fragment f = mo6090f(next);
                if (f != null) {
                    if (FragmentManager.m2230w0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + next + "): " + f);
                    }
                    mo6085a(f);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: w */
    public ArrayList<FragmentState> mo6107w() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f3338b.size());
        for (C0693h next : this.f3338b.values()) {
            if (next != null) {
                Fragment j = next.mo6072j();
                FragmentState q = next.mo6078q();
                arrayList.add(q);
                if (FragmentManager.m2230w0(2)) {
                    Log.v("FragmentManager", "Saved state of " + j + ": " + q.f3185m);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: x */
    public ArrayList<String> mo6108x() {
        synchronized (this.f3337a) {
            if (this.f3337a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f3337a.size());
            Iterator<Fragment> it = this.f3337a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f3013f);
                if (FragmentManager.m2230w0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f3013f + "): " + next);
                }
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo6109y(@NonNull C0691g gVar) {
        this.f3339c = gVar;
    }
}
