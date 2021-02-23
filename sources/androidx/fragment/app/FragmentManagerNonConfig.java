package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
public class FragmentManagerNonConfig {
    @Nullable

    /* renamed from: a */
    private final Collection<Fragment> f3157a;
    @Nullable

    /* renamed from: b */
    private final Map<String, FragmentManagerNonConfig> f3158b;
    @Nullable

    /* renamed from: c */
    private final Map<String, ViewModelStore> f3159c;

    FragmentManagerNonConfig(@Nullable Collection<Fragment> collection, @Nullable Map<String, FragmentManagerNonConfig> map, @Nullable Map<String, ViewModelStore> map2) {
        this.f3157a = collection;
        this.f3158b = map;
        this.f3159c = map2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public Map<String, FragmentManagerNonConfig> mo5854a() {
        return this.f3158b;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public Collection<Fragment> mo5855b() {
        return this.f3157a;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public Map<String, ViewModelStore> mo5856c() {
        return this.f3159c;
    }
}
