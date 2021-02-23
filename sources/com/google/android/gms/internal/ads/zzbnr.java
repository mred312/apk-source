package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbnr implements zzbsm, zzbtj {

    /* renamed from: a */
    private final Context f13548a;
    @Nullable

    /* renamed from: b */
    private final zzbdv f13549b;

    /* renamed from: c */
    private final zzdmu f13550c;

    /* renamed from: d */
    private final zzazh f13551d;
    @GuardedBy("this")
    @Nullable

    /* renamed from: e */
    private IObjectWrapper f13552e;
    @GuardedBy("this")

    /* renamed from: f */
    private boolean f13553f;

    public zzbnr(Context context, @Nullable zzbdv zzbdv, zzdmu zzdmu, zzazh zzazh) {
        this.f13548a = context;
        this.f13549b = zzbdv;
        this.f13550c = zzdmu;
        this.f13551d = zzazh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e8, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m7824a() {
        /*
            r13 = this;
            monitor-enter(r13)
            com.google.android.gms.internal.ads.zzdmu r0 = r13.f13550c     // Catch:{ all -> 0x00e9 }
            boolean r0 = r0.zzdvl     // Catch:{ all -> 0x00e9 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r13)
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbdv r0 = r13.f13549b     // Catch:{ all -> 0x00e9 }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r13)
            return
        L_0x000f:
            com.google.android.gms.internal.ads.zzard r0 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00e9 }
            android.content.Context r1 = r13.f13548a     // Catch:{ all -> 0x00e9 }
            boolean r0 = r0.zzm(r1)     // Catch:{ all -> 0x00e9 }
            if (r0 != 0) goto L_0x001d
            monitor-exit(r13)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzazh r0 = r13.f13551d     // Catch:{ all -> 0x00e9 }
            int r1 = r0.zzegl     // Catch:{ all -> 0x00e9 }
            int r0 = r0.zzegm     // Catch:{ all -> 0x00e9 }
            r2 = 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e9 }
            r3.<init>(r2)     // Catch:{ all -> 0x00e9 }
            r3.append(r1)     // Catch:{ all -> 0x00e9 }
            java.lang.String r1 = "."
            r3.append(r1)     // Catch:{ all -> 0x00e9 }
            r3.append(r0)     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdmu r0 = r13.f13550c     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings r0 = r0.zzhhi     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r0.getVideoEventsOwner()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcul     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00e9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00e9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00e9 }
            r1 = 1
            if (r0 == 0) goto L_0x008e
            com.google.android.gms.internal.ads.zzdmu r0 = r13.f13550c     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings r0 = r0.zzhhi     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType r0 = r0.getMediaType()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType r2 = com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType.VIDEO     // Catch:{ all -> 0x00e9 }
            if (r0 != r2) goto L_0x0067
            com.google.android.gms.internal.ads.zzare r0 = com.google.android.gms.internal.ads.zzare.VIDEO     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzarg r2 = com.google.android.gms.internal.ads.zzarg.DEFINED_BY_JAVASCRIPT     // Catch:{ all -> 0x00e9 }
        L_0x0064:
            r11 = r0
            r10 = r2
            goto L_0x0075
        L_0x0067:
            com.google.android.gms.internal.ads.zzare r0 = com.google.android.gms.internal.ads.zzare.HTML_DISPLAY     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdmu r2 = r13.f13550c     // Catch:{ all -> 0x00e9 }
            int r2 = r2.zzhgq     // Catch:{ all -> 0x00e9 }
            if (r2 != r1) goto L_0x0072
            com.google.android.gms.internal.ads.zzarg r2 = com.google.android.gms.internal.ads.zzarg.ONE_PIXEL     // Catch:{ all -> 0x00e9 }
            goto L_0x0064
        L_0x0072:
            com.google.android.gms.internal.ads.zzarg r2 = com.google.android.gms.internal.ads.zzarg.BEGIN_TO_RENDER     // Catch:{ all -> 0x00e9 }
            goto L_0x0064
        L_0x0075:
            com.google.android.gms.internal.ads.zzard r4 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzbdv r0 = r13.f13549b     // Catch:{ all -> 0x00e9 }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.internal.ads.zzdmu r0 = r13.f13550c     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r0.zzche     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00e9 }
            r13.f13552e = r0     // Catch:{ all -> 0x00e9 }
            goto L_0x00a2
        L_0x008e:
            com.google.android.gms.internal.ads.zzard r4 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzbdv r0 = r13.f13549b     // Catch:{ all -> 0x00e9 }
            android.webkit.WebView r6 = r0.getWebView()     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = ""
            java.lang.String r8 = "javascript"
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zza(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00e9 }
            r13.f13552e = r0     // Catch:{ all -> 0x00e9 }
        L_0x00a2:
            com.google.android.gms.internal.ads.zzbdv r0 = r13.f13549b     // Catch:{ all -> 0x00e9 }
            android.view.View r0 = r0.getView()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.f13552e     // Catch:{ all -> 0x00e9 }
            if (r2 == 0) goto L_0x00e7
            if (r0 == 0) goto L_0x00e7
            com.google.android.gms.internal.ads.zzard r2 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = r13.f13552e     // Catch:{ all -> 0x00e9 }
            r2.zza(r3, r0)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzbdv r0 = r13.f13549b     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.f13552e     // Catch:{ all -> 0x00e9 }
            r0.zzaq(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzard r0 = com.google.android.gms.ads.internal.zzp.zzlf()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.f13552e     // Catch:{ all -> 0x00e9 }
            r0.zzab(r2)     // Catch:{ all -> 0x00e9 }
            r13.f13553f = r1     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcuo     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00e9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00e9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00e9 }
            if (r0 == 0) goto L_0x00e7
            com.google.android.gms.internal.ads.zzbdv r0 = r13.f13549b     // Catch:{ all -> 0x00e9 }
            java.lang.String r1 = "onSdkLoaded"
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00e9 }
            r2.<init>()     // Catch:{ all -> 0x00e9 }
            r0.zza(r1, r2)     // Catch:{ all -> 0x00e9 }
        L_0x00e7:
            monitor-exit(r13)
            return
        L_0x00e9:
            r0 = move-exception
            monitor-exit(r13)
            goto L_0x00ed
        L_0x00ec:
            throw r0
        L_0x00ed:
            goto L_0x00ec
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnr.m7824a():void");
    }

    public final synchronized void onAdImpression() {
        zzbdv zzbdv;
        if (!this.f13553f) {
            m7824a();
        }
        if (!(!this.f13550c.zzdvl || this.f13552e == null || (zzbdv = this.f13549b) == null)) {
            zzbdv.zza("onSdkImpression", new ArrayMap());
        }
    }

    public final synchronized void onAdLoaded() {
        if (!this.f13553f) {
            m7824a();
        }
    }
}
