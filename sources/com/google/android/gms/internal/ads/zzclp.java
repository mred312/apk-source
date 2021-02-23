package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzclp {

    /* renamed from: a */
    private boolean f14560a = false;
    /* access modifiers changed from: private */
    @GuardedBy("this")

    /* renamed from: b */
    public boolean f14561b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final long f14562c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzazq<Boolean> f14563d = new zzazq<>();

    /* renamed from: e */
    private final Context f14564e;

    /* renamed from: f */
    private final WeakReference<Context> f14565f;

    /* renamed from: g */
    private final zzciq f14566g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Executor f14567h;

    /* renamed from: i */
    private final Executor f14568i;

    /* renamed from: j */
    private final ScheduledExecutorService f14569j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final zzckz f14570k;

    /* renamed from: l */
    private final zzazh f14571l;

    /* renamed from: m */
    private Map<String, zzaiz> f14572m = new ConcurrentHashMap();

    /* renamed from: n */
    private boolean f14573n = true;

    public zzclp(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzciq zzciq, ScheduledExecutorService scheduledExecutorService, zzckz zzckz, zzazh zzazh) {
        this.f14566g = zzciq;
        this.f14564e = context;
        this.f14565f = weakReference;
        this.f14567h = executor2;
        this.f14569j = scheduledExecutorService;
        this.f14568i = executor;
        this.f14570k = zzckz;
        this.f14571l = zzazh;
        this.f14562c = zzp.zzkx().elapsedRealtime();
        m8190g("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m8190g(String str, boolean z, String str2, int i) {
        this.f14572m.put(str, new zzaiz(str, z, i, str2));
    }

    /* renamed from: i */
    private final synchronized zzdyz<String> m8192i() {
        String zzxf = zzp.zzku().zzwz().zzxv().zzxf();
        if (!TextUtils.isEmpty(zzxf)) {
            return zzdyr.zzag(zzxf);
        }
        zzazq zzazq = new zzazq();
        zzp.zzku().zzwz().zzb(new C1809cl(this, zzazq));
        return zzazq;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public final void m8196q(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzazq zzazq = new zzazq();
                zzdyz zza = zzdyr.zza(zzazq, ((Long) zzwq.zzqe().zzd(zzabf.zzcql)).longValue(), TimeUnit.SECONDS, this.f14569j);
                this.f14570k.zzgf(next);
                long elapsedRealtime = zzp.zzkx().elapsedRealtime();
                Iterator<String> it = keys;
                C1883el elVar = r1;
                C1883el elVar2 = new C1883el(this, obj, zzazq, next, elapsedRealtime);
                zza.addListener(elVar, this.f14567h);
                arrayList.add(zza);
                C2068jl jlVar = new C2068jl(this, obj, next, elapsedRealtime, zzazq);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzajj(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                m8190g(next, false, "", 0);
                try {
                    this.f14568i.execute(new C1957gl(this, this.f14566g.zzd(next, new JSONObject()), jlVar, arrayList2, next));
                } catch (zzdnr unused2) {
                    try {
                        jlVar.onInitializationFailed("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzaza.zzc("", e);
                    }
                }
                keys = it;
            }
            zzdyr.zzj(arrayList).zza(new C1846dl(this), this.f14567h);
        } catch (JSONException e2) {
            zzd.zza("Malformed CLD response", e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16909b(zzazq zzazq) {
        this.f14567h.execute(new C1920fl(this, zzazq));
    }

    public final void disable() {
        this.f14573n = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzaza.zzc("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.onInitializationFailed(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void mo16911e(com.google.android.gms.internal.ads.zzdoe r2, com.google.android.gms.internal.ads.zzajb r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.f14565f     // Catch:{ zzdnr -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzdnr -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzdnr -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.f14564e     // Catch:{ zzdnr -> 0x0011 }
        L_0x000d:
            r2.zza((android.content.Context) r0, (com.google.android.gms.internal.ads.zzajb) r3, (java.util.List<com.google.android.gms.internal.ads.zzajj>) r4)     // Catch:{ zzdnr -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.onInitializationFailed(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclp.mo16911e(com.google.android.gms.internal.ads.zzdoe, com.google.android.gms.internal.ads.zzajb, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo16912f(Object obj, zzazq zzazq, String str, long j) {
        synchronized (obj) {
            if (!zzazq.isDone()) {
                m8190g(str, false, "Timeout.", (int) (zzp.zzkx().elapsedRealtime() - j));
                this.f14570k.zzs(str, "timeout");
                zzazq.set(Boolean.FALSE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ Object mo16913j() {
        this.f14563d.set(Boolean.TRUE);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final /* synthetic */ void mo16914k() {
        synchronized (this) {
            if (!this.f14561b) {
                m8190g("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzp.zzkx().elapsedRealtime() - this.f14562c));
                this.f14563d.setException(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ void mo16915l() {
        this.f14570k.zzaqk();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final /* synthetic */ void mo16916o(zzajc zzajc) {
        try {
            zzajc.zze(zzaqn());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zzaqm() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqj)).booleanValue() && !zzadc.zzdcv.get().booleanValue()) {
            if (this.f14571l.zzegm >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcqk)).intValue() && this.f14573n) {
                if (!this.f14560a) {
                    synchronized (this) {
                        if (!this.f14560a) {
                            this.f14570k.zzaqj();
                            this.f14563d.addListener(new C2666zk(this), this.f14567h);
                            this.f14560a = true;
                            zzdyz<String> i = m8192i();
                            this.f14569j.schedule(new C1772bl(this), ((Long) zzwq.zzqe().zzd(zzabf.zzcqm)).longValue(), TimeUnit.SECONDS);
                            zzdyr.zza(i, new C2031il(this), this.f14567h);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.f14560a) {
            m8190g("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.f14563d.set(Boolean.FALSE);
            this.f14560a = true;
        }
    }

    public final List<zzaiz> zzaqn() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.f14572m.keySet()) {
            zzaiz zzaiz = this.f14572m.get(next);
            arrayList.add(new zzaiz(next, zzaiz.zzdho, zzaiz.zzdhp, zzaiz.description));
        }
        return arrayList;
    }

    public final void zzb(zzajc zzajc) {
        this.f14563d.addListener(new C1735al(this, zzajc), this.f14568i);
    }
}
