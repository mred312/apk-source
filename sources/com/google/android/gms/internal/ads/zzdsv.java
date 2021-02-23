package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdsv {

    /* renamed from: a */
    private final Context f15935a;

    /* renamed from: b */
    private final Executor f15936b;

    /* renamed from: c */
    private final zzdsi f15937c;

    /* renamed from: d */
    private final zzdsj f15938d;

    /* renamed from: e */
    private final w00 f15939e;

    /* renamed from: f */
    private final w00 f15940f;

    /* renamed from: g */
    private Task<zzcf.zza> f15941g;

    /* renamed from: h */
    private Task<zzcf.zza> f15942h;

    @VisibleForTesting
    private zzdsv(Context context, Executor executor, zzdsi zzdsi, zzdsj zzdsj, u00 u00, x00 x00) {
        this.f15935a = context;
        this.f15936b = executor;
        this.f15937c = zzdsi;
        this.f15938d = zzdsj;
        this.f15939e = u00;
        this.f15940f = x00;
    }

    /* renamed from: a */
    private static zzcf.zza m8485a(@NonNull Task<zzcf.zza> task, @NonNull zzcf.zza zza) {
        if (!task.isSuccessful()) {
            return zza;
        }
        return task.getResult();
    }

    /* renamed from: e */
    private final Task<zzcf.zza> m8486e(@NonNull Callable<zzcf.zza> callable) {
        return Tasks.call(this.f15936b, callable).addOnFailureListener(this.f15936b, (OnFailureListener) new v00(this));
    }

    public static zzdsv zza(@NonNull Context context, @NonNull Executor executor, @NonNull zzdsi zzdsi, @NonNull zzdsj zzdsj) {
        zzdsv zzdsv = new zzdsv(context, executor, zzdsi, zzdsj, new u00(), new x00());
        if (zzdsv.f15938d.zzawy()) {
            zzdsv.f15941g = zzdsv.m8486e(new t00(zzdsv));
        } else {
            zzdsv.f15941g = Tasks.forResult(zzdsv.f15939e.mo14853b());
        }
        zzdsv.f15942h = zzdsv.m8486e(new s00(zzdsv));
        return zzdsv;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzcf.zza mo17274b() {
        return this.f15940f.mo14852a(this.f15935a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ zzcf.zza mo17275c() {
        return this.f15939e.mo14852a(this.f15935a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo17276d(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.f15937c.zza(2025, -1, exc);
    }

    public final zzcf.zza zzaxe() {
        return m8485a(this.f15941g, this.f15939e.mo14853b());
    }

    public final zzcf.zza zzco() {
        return m8485a(this.f15942h, this.f15940f.mo14853b());
    }
}
