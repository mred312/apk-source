package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.s6 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3106s6 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18354a;

    /* renamed from: b */
    private final /* synthetic */ String f18355b;

    /* renamed from: c */
    private final /* synthetic */ String f18356c;

    /* renamed from: d */
    private final /* synthetic */ String f18357d;

    /* renamed from: e */
    private final /* synthetic */ zzn f18358e;

    /* renamed from: f */
    private final /* synthetic */ zzio f18359f;

    C3106s6(zzio zzio, AtomicReference atomicReference, String str, String str2, String str3, zzn zzn) {
        this.f18359f = zzio;
        this.f18354a = atomicReference;
        this.f18355b = str;
        this.f18356c = str2;
        this.f18357d = str3;
        this.f18358e = zzn;
    }

    public final void run() {
        synchronized (this.f18354a) {
            try {
                zzej q = this.f18359f.f18673c;
                if (q == null) {
                    this.f18359f.zzq().zze().zza("(legacy) Failed to get conditional properties; not connected to service", zzer.zza(this.f18355b), this.f18356c, this.f18357d);
                    this.f18354a.set(Collections.emptyList());
                    this.f18354a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f18355b)) {
                    this.f18354a.set(q.zza(this.f18356c, this.f18357d, this.f18358e));
                } else {
                    this.f18354a.set(q.zza(this.f18355b, this.f18356c, this.f18357d));
                }
                this.f18359f.zzaj();
                this.f18354a.notify();
            } catch (RemoteException e) {
                try {
                    this.f18359f.zzq().zze().zza("(legacy) Failed to get conditional properties; remote exception", zzer.zza(this.f18355b), this.f18356c, e);
                    this.f18354a.set(Collections.emptyList());
                    this.f18354a.notify();
                } catch (Throwable th) {
                    this.f18354a.notify();
                    throw th;
                }
            }
        }
    }
}
