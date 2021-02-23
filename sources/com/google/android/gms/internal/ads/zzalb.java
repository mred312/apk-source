package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzalb {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f12503a;

    /* renamed from: b */
    private final Context f12504b;

    /* renamed from: c */
    private final String f12505c;

    /* renamed from: d */
    private final zzazh f12506d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public zzau<zzako> f12507e;

    /* renamed from: f */
    private zzau<zzako> f12508f;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: g */
    public zzals f12509g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f12510h;

    private zzalb(Context context, zzazh zzazh, String str) {
        this.f12503a = new Object();
        this.f12510h = 1;
        this.f12505c = str;
        this.f12504b = context.getApplicationContext();
        this.f12506d = zzazh;
        this.f12507e = new zzalp();
        this.f12508f = new zzalp();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo15414d(zzako zzako) {
        if (zzako.isDestroyed()) {
            this.f12510h = 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void mo15415e(com.google.android.gms.internal.ads.zzals r4, com.google.android.gms.internal.ads.zzako r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f12503a
            monitor-enter(r0)
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = -1
            if (r1 == r2) goto L_0x0028
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            r4.reject()     // Catch:{ all -> 0x002a }
            com.google.android.gms.internal.ads.zzdzc r4 = com.google.android.gms.internal.ads.zzazj.zzegt     // Catch:{ all -> 0x002a }
            r5.getClass()     // Catch:{ all -> 0x002a }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.C2534w1.m7103a(r5)     // Catch:{ all -> 0x002a }
            r4.execute(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.ads.internal.util.zzd.zzee(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalb.mo15415e(com.google.android.gms.internal.ads.zzals, com.google.android.gms.internal.ads.zzako):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo15416f(zzef zzef, zzals zzals) {
        zzako zzako;
        try {
            Context context = this.f12504b;
            zzazh zzazh = this.f12506d;
            if (zzadm.zzddw.get().booleanValue()) {
                zzako = new zzaka(context, zzazh);
            } else {
                zzako = new zzakq(context, zzazh, zzef, (zzb) null);
            }
            zzako.zza(new C2460u1(this, zzals, zzako));
            zzako.zza("/jsLoaded", new C2497v1(this, zzals, zzako));
            zzbr zzbr = new zzbr();
            C2609y1 y1Var = new C2609y1(this, zzef, zzako, zzbr);
            zzbr.set(y1Var);
            zzako.zza("/requestReload", y1Var);
            if (this.f12505c.endsWith(".js")) {
                zzako.zzcv(this.f12505c);
            } else if (this.f12505c.startsWith("<html>")) {
                zzako.zzcw(this.f12505c);
            } else {
                zzako.zzcx(this.f12505c);
            }
            zzm.zzedd.postDelayed(new C2571x1(this, zzals, zzako), (long) C1753b2.f7865a);
        } catch (Throwable th) {
            zzaza.zzc("Error creating webview.", th);
            zzp.zzku().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzals.reject();
        }
    }

    /* access modifiers changed from: protected */
    public final zzals zza(@Nullable zzef zzef) {
        zzals zzals = new zzals(this.f12508f);
        zzazj.zzegt.execute(new C2308q1(this, zzef, zzals));
        zzals.zza(new C2647z1(this, zzals), new C1790c2(this, zzals));
        return zzals;
    }

    public final zzalo zzb(@Nullable zzef zzef) {
        synchronized (this.f12503a) {
            synchronized (this.f12503a) {
                zzals zzals = this.f12509g;
                if (zzals != null && this.f12510h == 0) {
                    zzals.zza(new C2382s1(this), C2345r1.f10756a);
                }
            }
            zzals zzals2 = this.f12509g;
            if (zzals2 != null) {
                if (zzals2.getStatus() != -1) {
                    int i = this.f12510h;
                    if (i == 0) {
                        zzalo zztv = this.f12509g.zztv();
                        return zztv;
                    } else if (i == 1) {
                        this.f12510h = 2;
                        zza((zzef) null);
                        zzalo zztv2 = this.f12509g.zztv();
                        return zztv2;
                    } else if (i == 2) {
                        zzalo zztv3 = this.f12509g.zztv();
                        return zztv3;
                    } else {
                        zzalo zztv4 = this.f12509g.zztv();
                        return zztv4;
                    }
                }
            }
            this.f12510h = 2;
            zzals zza = zza((zzef) null);
            this.f12509g = zza;
            zzalo zztv5 = zza.zztv();
            return zztv5;
        }
    }

    public zzalb(Context context, zzazh zzazh, String str, zzau<zzako> zzau, zzau<zzako> zzau2) {
        this(context, zzazh, str);
        this.f12507e = zzau;
        this.f12508f = zzau2;
    }
}
