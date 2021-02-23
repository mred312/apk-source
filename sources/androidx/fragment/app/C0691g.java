package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.fragment.app.g */
/* compiled from: FragmentManagerViewModel */
final class C0691g extends ViewModel {

    /* renamed from: j */
    private static final ViewModelProvider.Factory f3319j = new C0692a();

    /* renamed from: c */
    private final HashMap<String, Fragment> f3320c = new HashMap<>();

    /* renamed from: d */
    private final HashMap<String, C0691g> f3321d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<String, ViewModelStore> f3322e = new HashMap<>();

    /* renamed from: f */
    private final boolean f3323f;

    /* renamed from: g */
    private boolean f3324g = false;

    /* renamed from: h */
    private boolean f3325h = false;

    /* renamed from: i */
    private boolean f3326i = false;

    /* renamed from: androidx.fragment.app.g$a */
    /* compiled from: FragmentManagerViewModel */
    class C0692a implements ViewModelProvider.Factory {
        C0692a() {
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new C0691g(true);
        }
    }

    C0691g(boolean z) {
        this.f3323f = z;
    }

    @NonNull
    /* renamed from: i */
    static C0691g m2408i(ViewModelStore viewModelStore) {
        return (C0691g) new ViewModelProvider(viewModelStore, f3319j).get(C0691g.class);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6046e(@NonNull Fragment fragment) {
        if (this.f3326i) {
            if (FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f3320c.containsKey(fragment.f3013f)) {
            this.f3320c.put(fragment.f3013f, fragment);
            if (FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0691g.class != obj.getClass()) {
            return false;
        }
        C0691g gVar = (C0691g) obj;
        if (!this.f3320c.equals(gVar.f3320c) || !this.f3321d.equals(gVar.f3321d) || !this.f3322e.equals(gVar.f3322e)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6048f(@NonNull Fragment fragment) {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        C0691g gVar = this.f3321d.get(fragment.f3013f);
        if (gVar != null) {
            gVar.onCleared();
            this.f3321d.remove(fragment.f3013f);
        }
        ViewModelStore viewModelStore = this.f3322e.get(fragment.f3013f);
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.f3322e.remove(fragment.f3013f);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: g */
    public Fragment mo6049g(String str) {
        return this.f3320c.get(str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: h */
    public C0691g mo6050h(@NonNull Fragment fragment) {
        C0691g gVar = this.f3321d.get(fragment.f3013f);
        if (gVar != null) {
            return gVar;
        }
        C0691g gVar2 = new C0691g(this.f3323f);
        this.f3321d.put(fragment.f3013f, gVar2);
        return gVar2;
    }

    public int hashCode() {
        return (((this.f3320c.hashCode() * 31) + this.f3321d.hashCode()) * 31) + this.f3322e.hashCode();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: j */
    public Collection<Fragment> mo6052j() {
        return new ArrayList(this.f3320c.values());
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    @Nullable
    /* renamed from: k */
    public FragmentManagerNonConfig mo6053k() {
        if (this.f3320c.isEmpty() && this.f3321d.isEmpty() && this.f3322e.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f3321d.entrySet()) {
            FragmentManagerNonConfig k = ((C0691g) next.getValue()).mo6053k();
            if (k != null) {
                hashMap.put(next.getKey(), k);
            }
        }
        this.f3325h = true;
        if (!this.f3320c.isEmpty() || !hashMap.isEmpty() || !this.f3322e.isEmpty()) {
            return new FragmentManagerNonConfig(new ArrayList(this.f3320c.values()), hashMap, new HashMap(this.f3322e));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: l */
    public ViewModelStore mo6054l(@NonNull Fragment fragment) {
        ViewModelStore viewModelStore = this.f3322e.get(fragment.f3013f);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f3322e.put(fragment.f3013f, viewModelStore2);
        return viewModelStore2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo6055m() {
        return this.f3324g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo6056n(@NonNull Fragment fragment) {
        if (!this.f3326i) {
            if ((this.f3320c.remove(fragment.f3013f) != null) && FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        } else if (FragmentManager.m2230w0(2)) {
            Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: o */
    public void mo6057o(@Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f3320c.clear();
        this.f3321d.clear();
        this.f3322e.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> b = fragmentManagerNonConfig.mo5855b();
            if (b != null) {
                for (Fragment next : b) {
                    if (next != null) {
                        this.f3320c.put(next.f3013f, next);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> a = fragmentManagerNonConfig.mo5854a();
            if (a != null) {
                for (Map.Entry next2 : a.entrySet()) {
                    C0691g gVar = new C0691g(this.f3323f);
                    gVar.mo6057o((FragmentManagerNonConfig) next2.getValue());
                    this.f3321d.put(next2.getKey(), gVar);
                }
            }
            Map<String, ViewModelStore> c = fragmentManagerNonConfig.mo5856c();
            if (c != null) {
                this.f3322e.putAll(c);
            }
        }
        this.f3325h = false;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f3324g = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo6059p(boolean z) {
        this.f3326i = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo6060q(@NonNull Fragment fragment) {
        if (!this.f3320c.containsKey(fragment.f3013f)) {
            return true;
        }
        if (this.f3323f) {
            return this.f3324g;
        }
        return !this.f3325h;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f3320c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f3321d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f3322e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
