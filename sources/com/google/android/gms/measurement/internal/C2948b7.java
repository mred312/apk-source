package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* renamed from: com.google.android.gms.measurement.internal.b7 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final /* synthetic */ class C2948b7 implements Runnable {

    /* renamed from: a */
    private final zzjr f17966a;

    /* renamed from: b */
    private final zzer f17967b;

    /* renamed from: c */
    private final JobParameters f17968c;

    C2948b7(zzjr zzjr, zzer zzer, JobParameters jobParameters) {
        this.f17966a = zzjr;
        this.f17967b = zzer;
        this.f17968c = jobParameters;
    }

    public final void run() {
        this.f17966a.mo20490b(this.f17967b, this.f17968c);
    }
}
