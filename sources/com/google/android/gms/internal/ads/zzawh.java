package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzeoe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzawh implements zzawq {
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static List<Future<Void>> f12883n = Collections.synchronizedList(new ArrayList());
    @GuardedBy("lock")

    /* renamed from: a */
    private final zzeoe.zzb.C3984zzb f12884a;
    @GuardedBy("lock")

    /* renamed from: b */
    private final LinkedHashMap<String, zzeoe.zzb.zzh.C3990zzb> f12885b;
    @GuardedBy("lock")

    /* renamed from: c */
    private final List<String> f12886c = new ArrayList();
    @GuardedBy("lock")

    /* renamed from: d */
    private final List<String> f12887d = new ArrayList();

    /* renamed from: e */
    private final Context f12888e;

    /* renamed from: f */
    private final zzaws f12889f;
    @VisibleForTesting

    /* renamed from: g */
    private boolean f12890g;

    /* renamed from: h */
    private final zzawp f12891h;

    /* renamed from: i */
    private final C2463u4 f12892i;

    /* renamed from: j */
    private final Object f12893j = new Object();

    /* renamed from: k */
    private HashSet<String> f12894k = new HashSet<>();

    /* renamed from: l */
    private boolean f12895l = false;

    /* renamed from: m */
    private boolean f12896m = false;

    public zzawh(Context context, zzazh zzazh, zzawp zzawp, String str, zzaws zzaws) {
        Preconditions.checkNotNull(zzawp, "SafeBrowsing config is not present.");
        this.f12888e = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f12885b = new LinkedHashMap<>();
        this.f12889f = zzaws;
        this.f12891h = zzawp;
        for (String lowerCase : zzawp.zzdzf) {
            this.f12894k.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.f12894k.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzeoe.zzb.C3984zzb zzbkw = zzeoe.zzb.zzbkw();
        zzbkw.zzb(zzeoe.zzb.zzg.OCTAGON_AD);
        zzbkw.zzhy(str);
        zzbkw.zzhz(str);
        zzeoe.zzb.zza.C3983zza zzbky = zzeoe.zzb.zza.zzbky();
        String str2 = this.f12891h.zzdzb;
        if (str2 != null) {
            zzbky.zzib(str2);
        }
        zzbkw.zzb((zzeoe.zzb.zza) ((zzekh) zzbky.zzbhv()));
        zzeoe.zzb.zzi.zza zzbw = zzeoe.zzb.zzi.zzbln().zzbw(Wrappers.packageManager(this.f12888e).isCallerInstantApp());
        String str3 = zzazh.zzbrf;
        if (str3 != null) {
            zzbw.zzig(str3);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.f12888e);
        if (apkVersion > 0) {
            zzbw.zzfs(apkVersion);
        }
        zzbkw.zzb((zzeoe.zzb.zzi) ((zzekh) zzbw.zzbhv()));
        this.f12884a = zzbkw;
        this.f12892i = new C2463u4(this.f12888e, this.f12891h.zzdzi, this);
    }

    @Nullable
    /* renamed from: d */
    private final zzeoe.zzb.zzh.C3990zzb m7578d(String str) {
        zzeoe.zzb.zzh.C3990zzb zzb;
        synchronized (this.f12893j) {
            zzb = this.f12885b.get(str);
        }
        return zzb;
    }

    /* renamed from: e */
    static final /* synthetic */ Void m7579e(String str) {
        return null;
    }

    @VisibleForTesting
    /* renamed from: g */
    private final zzdyz<Void> m7580g() {
        zzdyz<Void> zzb;
        boolean z = this.f12890g;
        if (!((z && this.f12891h.zzdzh) || (this.f12896m && this.f12891h.zzdzg) || (!z && this.f12891h.zzdze))) {
            return zzdyr.zzag(null);
        }
        synchronized (this.f12893j) {
            for (zzeoe.zzb.zzh.C3990zzb zzbhv : this.f12885b.values()) {
                this.f12884a.zzb((zzeoe.zzb.zzh) ((zzekh) zzbhv.zzbhv()));
            }
            this.f12884a.zzo(this.f12886c);
            this.f12884a.zzp(this.f12887d);
            if (zzawr.isEnabled()) {
                String url = this.f12884a.getUrl();
                String zzbku = this.f12884a.zzbku();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(zzbku).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(zzbku);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzeoe.zzb.zzh next : this.f12884a.zzbkt()) {
                    sb2.append("    [");
                    sb2.append(next.zzblk());
                    sb2.append("] ");
                    sb2.append(next.getUrl());
                }
                zzawr.zzeb(sb2.toString());
            }
            zzdyz<String> zza = new zzax(this.f12888e).zza(1, this.f12891h.zzdzc, (Map<String, String>) null, ((zzeoe.zzb) ((zzekh) this.f12884a.zzbhv())).toByteArray());
            if (zzawr.isEnabled()) {
                zza.addListener(C2311q4.f10680a, zzazj.zzegp);
            }
            zzb = zzdyr.zzb(zza, C2426t4.f11133a, (Executor) zzazj.zzegu);
        }
        return zzb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo15803a(Bitmap bitmap) {
        zzejh zzbft = zzeiu.zzbft();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzbft);
        synchronized (this.f12893j) {
            this.f12884a.zzb((zzeoe.zzb.zzf) ((zzekh) zzeoe.zzb.zzf.zzbli().zzas(zzbft.zzbfg()).zzic("image/png").zzb(zzeoe.zzb.zzf.zza.TYPE_CREATIVE).zzbhv()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo15804b(String str) {
        synchronized (this.f12893j) {
            this.f12886c.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo15805c(String str) {
        synchronized (this.f12893j) {
            this.f12887d.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ zzdyz mo15806f(Map map) {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.f12893j) {
                            int length = optJSONArray.length();
                            zzeoe.zzb.zzh.C3990zzb d = m7578d(str);
                            if (d == null) {
                                String valueOf = String.valueOf(str);
                                zzawr.zzeb(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    d.zzif(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.f12890g;
                                if (length > 0) {
                                    z = true;
                                }
                                this.f12890g = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (zzadh.zzddl.get().booleanValue()) {
                    zzaza.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzdyr.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.f12890g) {
            synchronized (this.f12893j) {
                this.f12884a.zzb(zzeoe.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return m7580g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f12893j
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.f12896m = r2     // Catch:{ all -> 0x00bd }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb> r2 = r6.f12885b     // Catch:{ all -> 0x00bd }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x0024
            if (r9 != r1) goto L_0x0022
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb> r8 = r6.f12885b     // Catch:{ all -> 0x00bd }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb r7 = (com.google.android.gms.internal.ads.zzeoe.zzb.zzh.C3990zzb) r7     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zza r8 = com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zza.zzia(r9)     // Catch:{ all -> 0x00bd }
            r7.zzb((com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zza) r8)     // Catch:{ all -> 0x00bd }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x0024:
            com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb r1 = com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zzbll()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zza r9 = com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zza.zzia(r9)     // Catch:{ all -> 0x00bd }
            if (r9 == 0) goto L_0x0031
            r1.zzb((com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zza) r9)     // Catch:{ all -> 0x00bd }
        L_0x0031:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb> r9 = r6.f12885b     // Catch:{ all -> 0x00bd }
            int r9 = r9.size()     // Catch:{ all -> 0x00bd }
            r1.zzib(r9)     // Catch:{ all -> 0x00bd }
            r1.zzie(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzd$zzb r9 = com.google.android.gms.internal.ads.zzeoe.zzb.zzd.zzbld()     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r2 = r6.f12894k     // Catch:{ all -> 0x00bd }
            int r2 = r2.size()     // Catch:{ all -> 0x00bd }
            if (r2 <= 0) goto L_0x00ab
            if (r8 == 0) goto L_0x00ab
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00bd }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00bd }
        L_0x0053:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00ab
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00bd }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00bd }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00bd }
            goto L_0x006e
        L_0x006c:
            java.lang.String r3 = ""
        L_0x006e:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x007b
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00bd }
            goto L_0x007d
        L_0x007b:
            java.lang.String r2 = ""
        L_0x007d:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r5 = r6.f12894k     // Catch:{ all -> 0x00bd }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzeoe$zzb$zzc$zza r4 = com.google.android.gms.internal.ads.zzeoe.zzb.zzc.zzblb()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeiu r3 = com.google.android.gms.internal.ads.zzeiu.zzhs(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzc$zza r3 = r4.zzap(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeiu r2 = com.google.android.gms.internal.ads.zzeiu.zzhs(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzc$zza r2 = r3.zzaq(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzels r2 = r2.zzbhv()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzekh r2 = (com.google.android.gms.internal.ads.zzekh) r2     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzc r2 = (com.google.android.gms.internal.ads.zzeoe.zzb.zzc) r2     // Catch:{ all -> 0x00bd }
            r9.zzb(r2)     // Catch:{ all -> 0x00bd }
            goto L_0x0053
        L_0x00ab:
            com.google.android.gms.internal.ads.zzels r8 = r9.zzbhv()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzekh r8 = (com.google.android.gms.internal.ads.zzekh) r8     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzd r8 = (com.google.android.gms.internal.ads.zzeoe.zzb.zzd) r8     // Catch:{ all -> 0x00bd }
            r1.zzb((com.google.android.gms.internal.ads.zzeoe.zzb.zzd) r8)     // Catch:{ all -> 0x00bd }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb> r8 = r6.f12885b     // Catch:{ all -> 0x00bd }
            r8.put(r7, r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x00bd:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            goto L_0x00c1
        L_0x00c0:
            throw r7
        L_0x00c1:
            goto L_0x00c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawh.zza(java.lang.String, java.util.Map, int):void");
    }

    public final void zzdw(String str) {
        synchronized (this.f12893j) {
            if (str == null) {
                this.f12884a.zzbla();
            } else {
                this.f12884a.zzia(str);
            }
        }
    }

    public final void zzl(View view) {
        if (this.f12891h.zzdzd && !this.f12895l) {
            zzp.zzkq();
            Bitmap zzn = zzm.zzn(view);
            if (zzn == null) {
                zzawr.zzeb("Failed to capture the webview bitmap.");
                return;
            }
            this.f12895l = true;
            zzm.zzc((Runnable) new C2274p4(this, zzn));
        }
    }

    public final zzawp zzwc() {
        return this.f12891h;
    }

    public final boolean zzwd() {
        return PlatformVersion.isAtLeastKitKat() && this.f12891h.zzdzd && !this.f12895l;
    }

    public final void zzwe() {
    }

    public final void zzwf() {
        synchronized (this.f12893j) {
            zzdyz<Map<String, String>> zza = this.f12889f.zza(this.f12888e, this.f12885b.keySet());
            C2348r4 r4Var = new C2348r4(this);
            zzdzc zzdzc = zzazj.zzegu;
            zzdyz<O> zzb = zzdyr.zzb(zza, r4Var, (Executor) zzdzc);
            zzdyz<O> zza2 = zzdyr.zza(zzb, 10, TimeUnit.SECONDS, zzazj.zzegs);
            zzdyr.zza(zzb, new C2385s4(this, zza2), zzdzc);
            f12883n.add(zza2);
        }
    }

    public final String[] zza(String[] strArr) {
        return (String[]) this.f12892i.mo14857a(strArr).toArray(new String[0]);
    }
}
