package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class w20 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzdyz f11657a;

    /* renamed from: b */
    private final /* synthetic */ int f11658b;

    /* renamed from: c */
    private final /* synthetic */ x20 f11659c;

    w20(x20 x20, zzdyz zzdyz, int i) {
        this.f11659c = x20;
        this.f11657a = zzdyz;
        this.f11658b = i;
    }

    public final void run() {
        try {
            if (this.f11657a.isCancelled()) {
                zzdwl unused = this.f11659c.f11750l = null;
                this.f11659c.cancel(false);
            } else {
                this.f11659c.m7144C(this.f11658b, this.f11657a);
            }
        } finally {
            this.f11659c.m7145D((zzdwl) null);
        }
    }
}
