package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.tasks.b */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3184b implements Continuation<Void, List<TResult>> {

    /* renamed from: a */
    private final /* synthetic */ Collection f18768a;

    C3184b(Collection collection) {
        this.f18768a = collection;
    }

    public final /* synthetic */ Object then(@NonNull Task task) {
        ArrayList arrayList = new ArrayList();
        for (Task result : this.f18768a) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
