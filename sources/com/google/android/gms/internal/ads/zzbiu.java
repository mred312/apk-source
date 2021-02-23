package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzag;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbiu extends zzxv {

    /* renamed from: a */
    private final Context f13335a;

    /* renamed from: b */
    private final zzazh f13336b;

    /* renamed from: c */
    private final zzciq f13337c;

    /* renamed from: d */
    private final zzcre<zzdoe, zzcsw> f13338d;

    /* renamed from: e */
    private final zzcwz f13339e;

    /* renamed from: f */
    private final zzclp f13340f;

    /* renamed from: g */
    private final zzawx f13341g;

    /* renamed from: h */
    private final zzcis f13342h;
    @GuardedBy("this")

    /* renamed from: i */
    private boolean f13343i = false;

    zzbiu(Context context, zzazh zzazh, zzciq zzciq, zzcre<zzdoe, zzcsw> zzcre, zzcwz zzcwz, zzclp zzclp, zzawx zzawx, zzcis zzcis) {
        this.f13335a = context;
        this.f13336b = zzazh;
        this.f13337c = zzciq;
        this.f13338d = zzcre;
        this.f13339e = zzcwz;
        this.f13340f = zzclp;
        this.f13341g = zzawx;
        this.f13342h = zzcis;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo16301a(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzanh> zzxh = zzp.zzku().zzwz().zzxv().zzxh();
        if (zzxh != null && !zzxh.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzaza.zzd("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.f13337c.zzapg()) {
                HashMap hashMap = new HashMap();
                for (zzanh zzanh : zzxh.values()) {
                    for (zzane next : zzanh.zzdlr) {
                        String str = next.zzdle;
                        for (String next2 : next.zzdkw) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(next2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        zzcrb<zzdoe, zzcsw> zzf = this.f13338d.zzf(str2, jSONObject);
                        if (zzf != null) {
                            zzdoe zzdoe = (zzdoe) zzf.zzdmo;
                            if (!zzdoe.isInitialized()) {
                                if (zzdoe.zzui()) {
                                    zzdoe.zza(this.f13335a, (zzauw) (zzcsw) zzf.zzgqp, (List<String>) (List) entry.getValue());
                                    String valueOf = String.valueOf(str2);
                                    zzaza.zzeb(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                                }
                            }
                        }
                    } catch (zzdnr e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str2);
                        sb.append("\"");
                        zzaza.zzd(sb.toString(), e);
                    }
                }
            }
        }
    }

    public final String getVersionString() {
        return this.f13336b.zzbrf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f13343i     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)     // Catch:{ all -> 0x005d }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.f13335a     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabf.initialize(r0)     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzayg r0 = com.google.android.gms.ads.internal.zzp.zzku()     // Catch:{ all -> 0x005d }
            android.content.Context r1 = r3.f13335a     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzazh r2 = r3.f13336b     // Catch:{ all -> 0x005d }
            r0.zzd(r1, r2)     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzsx r0 = com.google.android.gms.ads.internal.zzp.zzkw()     // Catch:{ all -> 0x005d }
            android.content.Context r1 = r3.f13335a     // Catch:{ all -> 0x005d }
            r0.initialize(r1)     // Catch:{ all -> 0x005d }
            r0 = 1
            r3.f13343i = r0     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzclp r0 = r3.f13340f     // Catch:{ all -> 0x005d }
            r0.zzaqm()     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcqd     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzcwz r0 = r3.f13339e     // Catch:{ all -> 0x005d }
            r0.zzapi()     // Catch:{ all -> 0x005d }
        L_0x0044:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcss     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzcis r0 = r3.f13342h     // Catch:{ all -> 0x005d }
            r0.zzapi()     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r3)
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiu.initialize():void");
    }

    public final synchronized void setAppMuted(boolean z) {
        zzp.zzkv().setAppMuted(z);
    }

    public final synchronized void setAppVolume(float f) {
        zzp.zzkv().setAppVolume(f);
    }

    public final void zza(@Nullable String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzabf.initialize(this.f13335a);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcst)).booleanValue()) {
            zzp.zzkq();
            str2 = zzm.zzba(this.f13335a);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcsr)).booleanValue();
            zzaaq zzaaq = zzabf.zzcok;
            boolean booleanValue2 = booleanValue | ((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue();
            C2021ib ibVar = null;
            if (((Boolean) zzwq.zzqe().zzd(zzaaq)).booleanValue()) {
                booleanValue2 = true;
                ibVar = new C2021ib(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            }
            if (booleanValue2) {
                zzp.zzky().zza(this.f13335a, this.f13336b, str, (Runnable) ibVar);
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzaza.zzey("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzaza.zzey("Context is null. Failed to open debug menu.");
            return;
        }
        zzag zzag = new zzag(context);
        zzag.setAdUnitId(str);
        zzag.zzad(this.f13336b.zzbrf);
        zzag.showDialog();
    }

    public final synchronized void zzcd(String str) {
        zzabf.initialize(this.f13335a);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcsr)).booleanValue()) {
                zzp.zzky().zza(this.f13335a, this.f13336b, str, (Runnable) null);
            }
        }
    }

    public final void zzce(String str) {
        this.f13339e.zzgn(str);
    }

    public final synchronized float zzqk() {
        return zzp.zzkv().zzqk();
    }

    public final synchronized boolean zzql() {
        return zzp.zzkv().zzql();
    }

    public final List<zzaiz> zzqm() {
        return this.f13340f.zzaqn();
    }

    public final void zzqn() {
        this.f13340f.disable();
    }

    public final void zza(zzani zzani) {
        this.f13337c.zzb(zzani);
    }

    public final void zza(zzajc zzajc) {
        this.f13340f.zzb(zzajc);
    }

    public final void zza(zzaae zzaae) {
        this.f13341g.zza(this.f13335a, zzaae);
    }
}
