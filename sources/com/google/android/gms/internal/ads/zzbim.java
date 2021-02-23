package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbim {

    /* renamed from: a */
    private zza f13329a;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static abstract class zza {
        public abstract zzbdf zzafh();

        public abstract zzbao zzafi();

        public abstract zztx zzafj();

        public abstract zzaws zzafk();

        public abstract zzarq zzafl();

        public abstract zzamy zzafm();

        public abstract zzacl zzafn();
    }

    public zzbim(zza zza2) {
        this.f13329a = zza2;
    }

    public final zzaws zzafk() {
        return this.f13329a.zzafk();
    }

    public final zzarq zzafl() {
        return this.f13329a.zzafl();
    }

    public final zzamy zzafm() {
        return this.f13329a.zzafm();
    }

    public final zzacl zzafn() {
        return this.f13329a.zzafn();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzawn, com.google.android.gms.internal.ads.zzawt] */
    public final zzb zzahu() {
        zza zza2 = this.f13329a;
        return new zzb(zza2.zzafh(), zza2.zzafi(), new zzawn(zza2.zzafk()), zza2.zzafj(), zza2.zzafl(), zza2.zzafn());
    }
}
