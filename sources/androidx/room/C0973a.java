package androidx.room;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* renamed from: androidx.room.a */
/* compiled from: InvalidationLiveDataContainer */
class C0973a {
    @VisibleForTesting

    /* renamed from: a */
    final Set<LiveData> f4557a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b */
    private final RoomDatabase f4558b;

    C0973a(RoomDatabase roomDatabase) {
        this.f4558b = roomDatabase;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T> LiveData<T> mo7890a(String[] strArr, boolean z, Callable<T> callable) {
        return new C0982c(this.f4558b, this, z, callable, strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo7891b(LiveData liveData) {
        this.f4557a.add(liveData);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo7892c(LiveData liveData) {
        this.f4557a.remove(liveData);
    }
}
