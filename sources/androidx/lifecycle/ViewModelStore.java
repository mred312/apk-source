package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ViewModelStore {

    /* renamed from: a */
    private final HashMap<String, ViewModel> f3556a = new HashMap<>();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final ViewModel mo6278a(String str) {
        return this.f3556a.get(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Set<String> mo6279b() {
        return new HashSet(this.f3556a.keySet());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo6280c(String str, ViewModel viewModel) {
        ViewModel put = this.f3556a.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }

    public final void clear() {
        for (ViewModel a : this.f3556a.values()) {
            a.mo6273a();
        }
        this.f3556a.clear();
    }
}
