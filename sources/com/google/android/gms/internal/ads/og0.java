package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class og0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaa f10368a;

    /* renamed from: b */
    private final /* synthetic */ zzm f10369b;

    og0(zzm zzm, zzaa zzaa) {
        this.f10369b = zzm;
        this.f10368a = zzaa;
    }

    public final void run() {
        try {
            this.f10369b.f16720b.put(this.f10368a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
