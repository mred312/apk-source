package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.tasks.z */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3208z implements Continuation<Void, Task<List<Task<?>>>> {

    /* renamed from: a */
    private final /* synthetic */ Collection f18818a;

    C3208z(Collection collection) {
        this.f18818a = collection;
    }

    public final /* synthetic */ Object then(@NonNull Task task) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f18818a);
        return Tasks.forResult(arrayList);
    }
}
