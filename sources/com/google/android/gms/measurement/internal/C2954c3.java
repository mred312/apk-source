package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.c3 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2954c3 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f17990a;

    /* renamed from: b */
    private final /* synthetic */ String f17991b;

    /* renamed from: c */
    private final /* synthetic */ Object f17992c;

    /* renamed from: d */
    private final /* synthetic */ Object f17993d;

    /* renamed from: e */
    private final /* synthetic */ Object f17994e;

    /* renamed from: f */
    private final /* synthetic */ zzer f17995f;

    C2954c3(zzer zzer, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f17995f = zzer;
        this.f17990a = i;
        this.f17991b = str;
        this.f17992c = obj;
        this.f17993d = obj2;
        this.f17994e = obj3;
    }

    public final void run() {
        C3049m3 zzb = this.f17995f.zzy.zzb();
        if (!zzb.mo20065a()) {
            this.f17995f.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.f17995f.f18536b == 0) {
            if (this.f17995f.zzs().zze()) {
                char unused = this.f17995f.f18536b = 'C';
            } else {
                char unused2 = this.f17995f.f18536b = 'c';
            }
        }
        if (this.f17995f.f18537c < 0) {
            long unused3 = this.f17995f.f18537c = 32053;
        }
        char charAt = "01VDIWEA?".charAt(this.f17990a);
        char b = this.f17995f.f18536b;
        long g = this.f17995f.f18537c;
        String f = zzer.m10775f(true, this.f17991b, this.f17992c, this.f17993d, this.f17994e);
        StringBuilder sb = new StringBuilder(String.valueOf(f).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(b);
        sb.append(g);
        sb.append(":");
        sb.append(f);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.f17991b.substring(0, 1024);
        }
        zzb.f18227c.zza(sb2, 1);
    }
}
