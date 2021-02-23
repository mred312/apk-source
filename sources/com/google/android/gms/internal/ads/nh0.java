package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class nh0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ oh0 f10203a;

    nh0(oh0 oh0) {
        this.f10203a = oh0;
    }

    public final void run() {
        synchronized (this.f10203a.f10375c) {
            if (!this.f10203a.f10376d || !this.f10203a.f10377e) {
                zzaza.zzeb("App is still foreground");
            } else {
                boolean unused = this.f10203a.f10376d = false;
                zzaza.zzeb("App went background");
                for (zzrl zzp : this.f10203a.f10378f) {
                    try {
                        zzp.zzp(false);
                    } catch (Exception e) {
                        zzaza.zzc("", e);
                    }
                }
            }
        }
    }
}
