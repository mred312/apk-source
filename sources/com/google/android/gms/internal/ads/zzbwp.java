package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbwp {

    /* renamed from: a */
    private final Set<zzbxy<zzva>> f13796a;

    /* renamed from: b */
    private final Set<zzbxy<zzbru>> f13797b;

    /* renamed from: c */
    private final Set<zzbxy<zzbsm>> f13798c;

    /* renamed from: d */
    private final Set<zzbxy<zzbto>> f13799d;

    /* renamed from: e */
    private final Set<zzbxy<zzbtj>> f13800e;

    /* renamed from: f */
    private final Set<zzbxy<zzbrz>> f13801f;

    /* renamed from: g */
    private final Set<zzbxy<zzbsi>> f13802g;

    /* renamed from: h */
    private final Set<zzbxy<AdMetadataListener>> f13803h;

    /* renamed from: i */
    private final Set<zzbxy<AppEventListener>> f13804i;

    /* renamed from: j */
    private final Set<zzbxy<zzbub>> f13805j;

    /* renamed from: k */
    private final Set<zzbxy<zzp>> f13806k;
    @Nullable

    /* renamed from: l */
    private final zzdki f13807l;

    /* renamed from: m */
    private zzbrx f13808m;

    /* renamed from: n */
    private zzcum f13809n;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Set<zzbxy<zzva>> f13810a = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Set<zzbxy<zzbru>> f13811b = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Set<zzbxy<zzbsm>> f13812c = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Set<zzbxy<zzbto>> f13813d = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Set<zzbxy<zzbtj>> f13814e = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Set<zzbxy<zzbrz>> f13815f = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Set<zzbxy<AdMetadataListener>> f13816g = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: h */
        public Set<zzbxy<AppEventListener>> f13817h = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: i */
        public Set<zzbxy<zzbsi>> f13818i = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: j */
        public Set<zzbxy<zzbub>> f13819j = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: k */
        public Set<zzbxy<zzp>> f13820k = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: l */
        public zzdki f13821l;

        public final zza zza(zzbru zzbru, Executor executor) {
            this.f13811b.add(new zzbxy(zzbru, executor));
            return this;
        }

        public final zzbwp zzalt() {
            return new zzbwp(this);
        }

        public final zza zza(zzbtj zzbtj, Executor executor) {
            this.f13814e.add(new zzbxy(zzbtj, executor));
            return this;
        }

        public final zza zza(zzbrz zzbrz, Executor executor) {
            this.f13815f.add(new zzbxy(zzbrz, executor));
            return this;
        }

        public final zza zza(zzbsi zzbsi, Executor executor) {
            this.f13818i.add(new zzbxy(zzbsi, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.f13816g.add(new zzbxy(adMetadataListener, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.f13817h.add(new zzbxy(appEventListener, executor));
            return this;
        }

        public final zza zza(@Nullable zzxo zzxo, Executor executor) {
            if (this.f13817h != null) {
                zzcxq zzcxq = new zzcxq();
                zzcxq.zzb(zzxo);
                this.f13817h.add(new zzbxy(zzcxq, executor));
            }
            return this;
        }

        public final zza zza(zzva zzva, Executor executor) {
            this.f13810a.add(new zzbxy(zzva, executor));
            return this;
        }

        public final zza zza(zzbsm zzbsm, Executor executor) {
            this.f13812c.add(new zzbxy(zzbsm, executor));
            return this;
        }

        public final zza zza(zzbto zzbto, Executor executor) {
            this.f13813d.add(new zzbxy(zzbto, executor));
            return this;
        }

        public final zza zza(zzp zzp, Executor executor) {
            this.f13820k.add(new zzbxy(zzp, executor));
            return this;
        }

        public final zza zza(zzbub zzbub, Executor executor) {
            this.f13819j.add(new zzbxy(zzbub, executor));
            return this;
        }

        public final zza zza(zzdki zzdki) {
            this.f13821l = zzdki;
            return this;
        }
    }

    private zzbwp(zza zza2) {
        this.f13796a = zza2.f13810a;
        this.f13798c = zza2.f13812c;
        this.f13799d = zza2.f13813d;
        this.f13797b = zza2.f13811b;
        this.f13800e = zza2.f13814e;
        this.f13801f = zza2.f13815f;
        this.f13802g = zza2.f13818i;
        this.f13803h = zza2.f13816g;
        this.f13804i = zza2.f13817h;
        this.f13805j = zza2.f13819j;
        this.f13807l = zza2.f13821l;
        this.f13806k = zza2.f13820k;
    }

    public final zzcum zza(Clock clock, zzcuo zzcuo, zzcrg zzcrg) {
        if (this.f13809n == null) {
            this.f13809n = new zzcum(clock, zzcuo, zzcrg);
        }
        return this.f13809n;
    }

    public final Set<zzbxy<zzbru>> zzalh() {
        return this.f13797b;
    }

    public final Set<zzbxy<zzbtj>> zzali() {
        return this.f13800e;
    }

    public final Set<zzbxy<zzbrz>> zzalj() {
        return this.f13801f;
    }

    public final Set<zzbxy<zzbsi>> zzalk() {
        return this.f13802g;
    }

    public final Set<zzbxy<AdMetadataListener>> zzall() {
        return this.f13803h;
    }

    public final Set<zzbxy<AppEventListener>> zzalm() {
        return this.f13804i;
    }

    public final Set<zzbxy<zzva>> zzaln() {
        return this.f13796a;
    }

    public final Set<zzbxy<zzbsm>> zzalo() {
        return this.f13798c;
    }

    public final Set<zzbxy<zzbto>> zzalp() {
        return this.f13799d;
    }

    public final Set<zzbxy<zzbub>> zzalq() {
        return this.f13805j;
    }

    public final Set<zzbxy<zzp>> zzalr() {
        return this.f13806k;
    }

    @Nullable
    public final zzdki zzals() {
        return this.f13807l;
    }

    public final zzbrx zzc(Set<zzbxy<zzbrz>> set) {
        if (this.f13808m == null) {
            this.f13808m = new zzbrx(set);
        }
        return this.f13808m;
    }
}
