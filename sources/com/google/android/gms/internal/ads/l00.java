package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final /* synthetic */ class l00 implements Continuation {

    /* renamed from: a */
    private final zzbw.zza.C3974zza f9791a;

    /* renamed from: b */
    private final int f9792b;

    l00(zzbw.zza.C3974zza zza, int i) {
        this.f9791a = zza;
        this.f9792b = i;
    }

    public final Object then(Task task) {
        return zzdsi.m8482b(this.f9791a, this.f9792b, task);
    }
}
