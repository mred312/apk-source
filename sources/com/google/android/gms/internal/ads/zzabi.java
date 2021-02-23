package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzabi {
    @VisibleForTesting

    /* renamed from: a */
    private BlockingQueue<zzabs> f12349a = new ArrayBlockingQueue(100);
    @VisibleForTesting

    /* renamed from: b */
    private LinkedHashMap<String, String> f12350b = new LinkedHashMap<>();
    @VisibleForTesting

    /* renamed from: c */
    private Map<String, zzabm> f12351c = new HashMap();
    @VisibleForTesting

    /* renamed from: d */
    private String f12352d;
    @VisibleForTesting

    /* renamed from: e */
    private Context f12353e;
    @VisibleForTesting

    /* renamed from: f */
    private String f12354f;

    /* renamed from: g */
    private final HashSet<String> f12355g = new HashSet<>(Arrays.asList(new String[]{"noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"}));

    /* renamed from: h */
    private AtomicBoolean f12356h;

    /* renamed from: i */
    private File f12357i;

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a8 A[SYNTHETIC, Splitter:B:38:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3 A[SYNTHETIC, Splitter:B:43:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m7429b(java.util.Map<java.lang.String, java.lang.String> r5, com.google.android.gms.internal.ads.zzabv r6) {
        /*
            r4 = this;
            java.lang.String r0 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            java.lang.String r1 = r4.f12352d
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0014:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r1.appendQueryParameter(r3, r2)
            goto L_0x0014
        L_0x0030:
            android.net.Uri r5 = r1.build()
            java.lang.String r5 = r5.toString()
            if (r6 != 0) goto L_0x003b
            goto L_0x0070
        L_0x003b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            java.lang.String r5 = r6.zzsa()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0056
            java.lang.String r5 = "&it="
            r1.append(r5)
            java.lang.String r5 = r6.zzsa()
            r1.append(r5)
        L_0x0056:
            java.lang.String r5 = r6.zzsb()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x006c
            java.lang.String r5 = "&blat="
            r1.append(r5)
            java.lang.String r5 = r6.zzsb()
            r1.append(r5)
        L_0x006c:
            java.lang.String r5 = r1.toString()
        L_0x0070:
            java.util.concurrent.atomic.AtomicBoolean r6 = r4.f12356h
            boolean r6 = r6.get()
            if (r6 == 0) goto L_0x00c2
            java.io.File r6 = r4.f12357i
            if (r6 == 0) goto L_0x00bc
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00a0 }
            r3 = 1
            r2.<init>(r6, r3)     // Catch:{ IOException -> 0x00a0 }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r2.write(r5)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r5 = 10
            r2.write(r5)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            r2.close()     // Catch:{ IOException -> 0x0093 }
            return
        L_0x0093:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzd(r0, r5)
            return
        L_0x0098:
            r5 = move-exception
            r1 = r2
            goto L_0x00b1
        L_0x009b:
            r5 = move-exception
            r1 = r2
            goto L_0x00a1
        L_0x009e:
            r5 = move-exception
            goto L_0x00b1
        L_0x00a0:
            r5 = move-exception
        L_0x00a1:
            java.lang.String r6 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.ads.zzaza.zzd(r6, r5)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x00b0
            r1.close()     // Catch:{ IOException -> 0x00ac }
            goto L_0x00b0
        L_0x00ac:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzd(r0, r5)
        L_0x00b0:
            return
        L_0x00b1:
            if (r1 == 0) goto L_0x00bb
            r1.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzd(r0, r6)
        L_0x00bb:
            throw r5
        L_0x00bc:
            java.lang.String r5 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.ads.zzaza.zzfa(r5)
            return
        L_0x00c2:
            com.google.android.gms.ads.internal.zzp.zzkq()
            android.content.Context r6 = r4.f12353e
            java.lang.String r0 = r4.f12354f
            com.google.android.gms.ads.internal.util.zzm.zzb(r6, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabi.m7429b(java.util.Map, com.google.android.gms.internal.ads.zzabv):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Map<String, String> mo15165a(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry next : map2.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzcq(str).zzg(str2, (String) next.getValue()));
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo15166c() {
        while (true) {
            try {
                zzabs take = this.f12349a.take();
                zzabv zzrw = take.zzrw();
                if (zzrw != null && !TextUtils.isEmpty(zzrw.zzsa())) {
                    m7429b(mo15165a(this.f12350b, take.zzrx()), zzrw);
                }
            } catch (InterruptedException e) {
                zzaza.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.f12353e = context;
        this.f12354f = str;
        this.f12352d = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f12356h = atomicBoolean;
        atomicBoolean.set(zzacx.zzdcc.get().booleanValue());
        if (this.f12356h.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.f12357i = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry next : map.entrySet()) {
            this.f12350b.put((String) next.getKey(), (String) next.getValue());
        }
        zzazj.zzegp.execute(new C2231o(this));
        Map<String, zzabm> map2 = this.f12351c;
        zzabm zzabm = zzabm.zzczq;
        map2.put("action", zzabm);
        this.f12351c.put(FirebaseAnalytics.Param.AD_FORMAT, zzabm);
        this.f12351c.put("e", zzabm.zzczr);
    }

    public final zzabm zzcq(String str) {
        zzabm zzabm = this.f12351c.get(str);
        if (zzabm != null) {
            return zzabm;
        }
        return zzabm.zzczp;
    }

    public final void zzcr(String str) {
        if (!this.f12355g.contains(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.f12354f);
            linkedHashMap.put("ue", str);
            m7429b(mo15165a(this.f12350b, linkedHashMap), (zzabv) null);
        }
    }

    public final boolean zza(zzabs zzabs) {
        return this.f12349a.offer(zzabs);
    }
}
