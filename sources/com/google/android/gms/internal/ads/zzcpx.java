package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcpx {

    /* renamed from: a */
    private int f14693a = 0;

    /* renamed from: b */
    private long f14694b = 0;

    /* renamed from: c */
    private long f14695c = 0;

    /* renamed from: d */
    private long f14696d = 0;

    /* renamed from: e */
    private final Object f14697e = new Object();

    /* renamed from: f */
    private final Object f14698f = new Object();

    /* renamed from: g */
    private final Object f14699g = new Object();

    /* renamed from: h */
    private final Object f14700h = new Object();

    public final int getResponseCode() {
        int i;
        synchronized (this.f14697e) {
            i = this.f14693a;
        }
        return i;
    }

    public final long zzard() {
        long j;
        synchronized (this.f14698f) {
            j = this.f14694b;
        }
        return j;
    }

    public final synchronized long zzare() {
        long j;
        synchronized (this.f14699g) {
            j = this.f14695c;
        }
        return j;
    }

    public final synchronized long zzarf() {
        long j;
        synchronized (this.f14700h) {
            j = this.f14696d;
        }
        return j;
    }

    public final void zzea(int i) {
        synchronized (this.f14697e) {
            this.f14693a = i;
        }
    }

    public final void zzeq(long j) {
        synchronized (this.f14698f) {
            this.f14694b = j;
        }
    }

    public final synchronized void zzer(long j) {
        synchronized (this.f14700h) {
            this.f14696d = j;
        }
    }

    public final synchronized void zzfe(long j) {
        synchronized (this.f14699g) {
            this.f14695c = j;
        }
    }
}
