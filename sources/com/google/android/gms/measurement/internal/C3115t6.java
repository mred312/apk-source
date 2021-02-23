package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.t6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3115t6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18375a;

    /* renamed from: b */
    private final /* synthetic */ String f18376b;

    /* renamed from: c */
    private final /* synthetic */ String f18377c;

    /* renamed from: d */
    private final /* synthetic */ String f18378d;

    /* renamed from: e */
    private final /* synthetic */ boolean f18379e;

    /* renamed from: f */
    private final /* synthetic */ zzn f18380f;

    /* renamed from: g */
    private final /* synthetic */ zzio f18381g;

    C3115t6(zzio zzio, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzn zzn) {
        this.f18381g = zzio;
        this.f18375a = atomicReference;
        this.f18376b = str;
        this.f18377c = str2;
        this.f18378d = str3;
        this.f18379e = z;
        this.f18380f = zzn;
    }

    public final void run() {
        synchronized (this.f18375a) {
            try {
                zzej q = this.f18381g.f18673c;
                if (q == null) {
                    this.f18381g.zzq().zze().zza("(legacy) Failed to get user properties; not connected to service", zzer.zza(this.f18376b), this.f18377c, this.f18378d);
                    this.f18375a.set(Collections.emptyList());
                    this.f18375a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f18376b)) {
                    this.f18375a.set(q.zza(this.f18377c, this.f18378d, this.f18379e, this.f18380f));
                } else {
                    this.f18375a.set(q.zza(this.f18376b, this.f18377c, this.f18378d, this.f18379e));
                }
                this.f18381g.zzaj();
                this.f18375a.notify();
            } catch (RemoteException e) {
                try {
                    this.f18381g.zzq().zze().zza("(legacy) Failed to get user properties; remote exception", zzer.zza(this.f18376b), this.f18377c, e);
                    this.f18375a.set(Collections.emptyList());
                    this.f18375a.notify();
                } catch (Throwable th) {
                    this.f18375a.notify();
                    throw th;
                }
            }
        }
    }
}
